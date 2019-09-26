package com.hai.apptemplate.ui.base;

import android.support.v7.app.AppCompatActivity;

import com.hai.apptemplate.utils.MyToast;

/**
 * fileDesc
 * Created by huanghp on 2018/9/20.
 * Email h1132760021@sina.com
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onPause() {
        super.onPause();
        MyToast.cancel();
    }
}
