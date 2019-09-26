package com.hai.apptemplate.ui.user;

import com.hai.apptemplate.ui.base.mvp.BaseView;

/**
 * fileDesc
 * Created by huanghp on 2019/9/26.
 * Email h1132760021@sina.com
 */
public interface BaseDialogView<T> extends BaseView<T> {
    void dialogShow(boolean canCancel);

    void dialogHide();
}
