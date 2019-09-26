package com.hai.apptemplate.ui.user.signUp;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.hai.apptemplate.R;
import com.hai.apptemplate.ui.user.DialogActivity;
import com.hai.apptemplate.utils.MyToast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * fileDesc
 * Created by huanghp on 2019/9/26.
 * Email h1132760021@sina.com
 */
public class UserSignUpActivity extends DialogActivity<SignUpContract.Presenter> implements SignUpContract.View {
    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPwd)
    EditText etPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
        ButterKnife.bind(this);
        setPresenter(new SignUpPresenter(this));
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        presenter.singUp(etUserName.getText().toString(), etPwd.getText().toString());
    }

    @Override
    public void suc() {
        MyToast.show(this, "success");
    }

    @Override
    public void fail() {
        MyToast.show(this, "failed");
    }

    @Override
    public Context getContext() {
        return this;
    }
}
