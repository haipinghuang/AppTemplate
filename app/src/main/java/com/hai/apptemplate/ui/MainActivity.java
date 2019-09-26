package com.hai.apptemplate.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hai.apptemplate.R;
import com.hai.apptemplate.ui.base.BaseActivity;
import com.hai.apptemplate.ui.user.signIn.View.UserActivity;
import com.hai.apptemplate.ui.user.signUp.UserSignUpActivity;
import com.hai.apptemplate.utils.MyToast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clk(View view) {
        switch (view.getId()) {
            case R.id.btnOne:
                MyToast.show(this, "One");
                break;
            case R.id.btnSignUp:
                startActivity(new Intent(this, UserSignUpActivity.class));
                break;
            case R.id.btnThree:
                MyToast.show(this, "Three");
                startActivity(new Intent(this, UserActivity.class));
                break;
        }
    }
}
