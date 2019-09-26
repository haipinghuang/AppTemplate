package com.hai.lifecycledemo.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;


/**
 * 懒加载Fragment
 * Created by huanghp on 2019/8/12.
 * Email h1132760021@sina.com
 */
public abstract class LazyFragment extends Fragment {
    private boolean isViewCreated;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) loadData();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        initView(view);
        loadData();
    }

    protected abstract void initView(View view);

    private void loadData() {
        if (getUserVisibleHint() && isViewCreated) initData();
    }

    protected void initData() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isViewCreated = true;
    }

}

