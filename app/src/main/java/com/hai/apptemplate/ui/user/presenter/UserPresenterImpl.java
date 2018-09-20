package com.hai.apptemplate.ui.user.presenter;

import com.hai.apptemplate.ui.user.UserActivity;

/**
 * fileDesc
 * Created by huanghp on 2018/9/20.
 * Email h1132760021@sina.com
 */
public class UserPresenterImpl implements IUserPresenter {
    UserActivity userActivity;

    public UserPresenterImpl(UserActivity userActivity) {
        this.userActivity = userActivity;
    }

    @Override
    public void loadData() {

    }

    @Override
    public void clearInput() {

    }
}
