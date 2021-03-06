package com.hai.apptemplate.http.okhttp;

import android.content.Context;
import android.widget.Toast;

import com.hai.apptemplate.utils.Logger;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by 黄海 on 2017/4/7.
 */

public abstract class BaseCallBack<T> implements HcallBack<T> {
    private static final String TAG = "BaseCallBack";
    protected Context context;

    public BaseCallBack(Context context) {
        this.context = context;
    }

    @Override
    public void onStart() {
        Logger.i(TAG, "onStart() called");
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful() && response.code() == 200) {
            try {
                onSuccess(call, response);
            } catch (Exception e) {
                Toast.makeText(context, "onSuccess方法出错，请检查", Toast.LENGTH_SHORT).show();
                Logger.e(null, "方法onSuccess抛出异常", e);
            }
        } else {
            Toast.makeText(context, "服务器内部错误，请稍候重试", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call call, Throwable t) {
        Logger.e(TAG, "onFailure() called with: call = [" + call + "],\n t = [" + t + "]");
        if (t instanceof UnknownHostException || t instanceof SocketTimeoutException || t instanceof ConnectException) {
            Toast.makeText(context, "网络错误，请稍候重试", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "未知错误，请稍候重试", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCompleted() {
        Logger.i(TAG, "onCompleted() called");
    }
}
