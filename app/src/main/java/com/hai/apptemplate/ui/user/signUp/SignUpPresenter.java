package com.hai.apptemplate.ui.user.signUp;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;


/**
 * fileDesc
 * Created by huanghp on 2019/9/26.
 * Email h1132760021@sina.com
 */
public class SignUpPresenter implements SignUpContract.Presenter {
    private SignUpContract.View view;
    Handler handler;

    public SignUpPresenter(final SignUpContract.View view) {
        this.view = view;
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                view.dialogHide();
                view.suc();
            }
        };
    }


    @Override
    public void singUp(String userName, String passwd) {
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(passwd)) {

            view.dialogShow(false);
            handler.sendEmptyMessageDelayed(2, 2000);

        } else view.fail();
    }
}
