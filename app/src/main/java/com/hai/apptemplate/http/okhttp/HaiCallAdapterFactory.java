package com.hai.apptemplate.http.okhttp;

import android.os.Handler;

import com.hai.apptemplate.utils.Logger;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
* 自定义callAdapter
* Created by huanghp on 2018/9/27.
* Email h1132760021@sina.com
*/
public class HaiCallAdapterFactory extends CallAdapter.Factory {
    final Handler callbackExecutor;

    public HaiCallAdapterFactory(Handler callbackExecutor) {
        this.callbackExecutor = callbackExecutor;
    }

    @Override
    public CallAdapter<Call<?>> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) != Hcall.class) return null;
        final Type responseType = Utils.getCallResponseType(returnType);
        return new CallAdapter<Call<?>>() {
            @Override
            public Type responseType() {
                return responseType;
            }

            @Override
            public <R> Call<R> adapt(Call<R> call) {
                return new HaiCallbackCall<>(callbackExecutor, call);
            }
        };
    }

    static final class HaiCallbackCall<T> implements Hcall<T> {
        final Handler callbackExecutor;
        final Call<T> delegate;

        public HaiCallbackCall(Handler callbackExecutor, Call<T> delegate) {
            this.callbackExecutor = callbackExecutor;
            this.delegate = delegate;
        }

        @Override
        public void enqueue(Callback<T> callback) {
            if (callback == null) throw new NullPointerException("callback == null");
            if (!(callback instanceof HcallBack))
                throw new IllegalArgumentException("callback.getClass()!=HcallBack.class");
            final HcallBack hcallBack = (HcallBack) callback;
            onStart(hcallBack);
            delegate.enqueue(new Callback<T>() {
                @Override
                public void onResponse(Call<T> call, final Response<T> response) {
                    callbackExecutor.post(new Runnable() {
                        @Override
                        public void run() {
                            if (delegate.isCanceled()) {
                                // Emulate OkHttp's behavior of throwing/delivering an IOException on cancellation.
                                try {
                                    hcallBack.onFailure(HaiCallbackCall.this, new IOException("Canceled"));
                                } catch (Exception e) {
                                    Logger.e(null, "方法onFailure抛出异常", e);
                                }
                            } else {
                                try {
                                    hcallBack.onResponse(HaiCallbackCall.this, response);
                                } catch (Exception e) {
                                    Logger.e(null, "方法onResponse抛出异常", e);
                                }
                            }
                            onCompleted(hcallBack);
                        }
                    });
                }

                @Override
                public void onFailure(Call<T> call, final Throwable t) {
                    callbackExecutor.post(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                hcallBack.onFailure(HaiCallbackCall.this, t);
                            } catch (Exception e) {
                                Logger.e(null, "方法onFailure抛出异常", e);
                            }
                            onCompleted(hcallBack);
                        }
                    });
                }
            });
        }

        private void onStart(final HcallBack hcallBack) {
            callbackExecutor.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        hcallBack.onStart();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        private void onCompleted(final HcallBack hcallBack) {
            callbackExecutor.post(new Runnable() {
                @Override
                public void run() {
                    try {
                        hcallBack.onCompleted();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        @Override
        public Response<T> execute() throws IOException {
            return delegate.execute();
        }

        @Override
        public boolean isExecuted() {
            return delegate.isExecuted();
        }

        @Override
        public void cancel() {
            delegate.cancel();
        }

        @Override
        public boolean isCanceled() {
            return delegate.isCanceled();
        }

        @Override
        public Call<T> clone() {
            return new HaiCallbackCall<>(callbackExecutor, delegate.clone());
        }

        @Override
        public Request request() {
            return delegate.request();
        }
    }
}
