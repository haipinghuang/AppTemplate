package com.hai.apptemplate.ui.user.signIn.presenter;

import com.hai.apptemplate.ui.user.signIn.View.IUserView;
import com.hai.apptemplate.ui.user.signIn.View.UserActivity;
import com.hai.apptemplate.ui.user.signIn.mode.IUser;
import com.hai.apptemplate.ui.user.signIn.mode.UserMode;

/**
 * fileDesc
 * Created by huanghp on 2018/9/20.
 * Email h1132760021@sina.com
 */
public class UserPresenterImpl implements IUserPresenter {
    IUserView userActivity;
    IUser user;

    public UserPresenterImpl(UserActivity userActivity) {
        this.userActivity = userActivity;
        user = new UserMode();
    }

    @Override
    public void loadData(String userName, String pwd) {
        if (user.isValidate(userName, pwd)) userActivity.showSuccess();
        else clearInput();
    }

    @Override
    public void clearInput() {
        userActivity.clearInput();
    }
}
