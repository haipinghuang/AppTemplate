package com.hai.apptemplate.ui.user.signUp;

import android.content.Context;
import android.os.Handler;

import com.hai.apptemplate.ui.base.mvp.BasePresenter;
import com.hai.apptemplate.ui.user.BaseDialogView;

/**
 * fileDesc
 * Created by huanghp on 2019/9/26.
 * Email h1132760021@sina.com
 */
public class SignUpContract {
    interface Presenter extends BasePresenter<View> {

        void singUp(String userName, String passwd);
    }

    interface View extends BaseDialogView<Presenter> {
        void suc();

        void fail();

        Context getContext();
    }
}
