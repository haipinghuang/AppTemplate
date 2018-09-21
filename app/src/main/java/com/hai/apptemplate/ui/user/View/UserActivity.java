package com.hai.apptemplate.ui.user.View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hai.apptemplate.R;
import com.hai.apptemplate.base.BaseActivity;
import com.hai.apptemplate.ui.user.presenter.IUserPresenter;
import com.hai.apptemplate.ui.user.presenter.UserPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserActivity extends BaseActivity implements IUserView {

    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPwd)
    EditText etPwd;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    IUserPresenter userPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);

        userPresenter = new UserPresenterImpl(this);
    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked() {
        String userName = etUserName.getText().toString();
        String pwd = etPwd.getText().toString();
        userPresenter.loadData(userName, pwd);
    }

    @Override
    public void clearInput() {
        etPwd.setText(null);
        etUserName.setText(null);
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "success result", Toast.LENGTH_LONG).show();
    }
}
