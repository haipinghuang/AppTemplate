package com.hai.apptemplate.http.okhttp;

import retrofit2.Call;

/**
 * 自定义call ，配合 HaiCallAdapterFactory 使用
 * Created by huanghp on 2018/9/27.
 * Email h1132760021@sina.com
 */
public interface Hcall<T> extends Call<T> {
}
