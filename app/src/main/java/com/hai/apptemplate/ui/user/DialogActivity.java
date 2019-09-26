package com.hai.apptemplate.ui.user;

import android.app.ProgressDialog;

import com.hai.apptemplate.ui.base.mvp.MvpActivity;

/**
 * fileDesc
 * Created by huanghp on 2019/9/26.
 * Email h1132760021@sina.com
 */
public class DialogActivity<T> extends MvpActivity<T> implements BaseDialogView<T> {
    ProgressDialog progressDialog;

    @Override
    public void dialogShow(boolean canCancel) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("请求中...");
        } else progressDialog.dismiss();
        progressDialog.show();
    }

    @Override
    public void dialogHide() {
        if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
    }
}
