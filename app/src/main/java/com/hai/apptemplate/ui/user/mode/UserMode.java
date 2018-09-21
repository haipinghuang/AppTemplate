package com.hai.apptemplate.ui.user.mode;

import android.text.TextUtils;

/**
 * fileDesc
 * Created by huanghp on 2018/9/21.
 * Email h1132760021@sina.com
 */
public class UserMode implements IUser {
    @Override
    public boolean isValidate(String userName, String pwd) {
        return !TextUtils.isEmpty(userName) && TextUtils.isEmpty(pwd);
    }
}
