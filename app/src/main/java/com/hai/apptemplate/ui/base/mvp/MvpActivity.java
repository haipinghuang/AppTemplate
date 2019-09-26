package com.hai.apptemplate.ui.base.mvp;

import com.hai.apptemplate.ui.base.BaseActivity;

/**
 * mvp baseActivity
 * Created by huanghp on 2019/9/26.
 * Email h1132760021@sina.com
 */
public abstract class MvpActivity<T> extends BaseActivity implements BaseView<T> {
    protected T presenter;

    @Override
    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
