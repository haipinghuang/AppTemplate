package com.hai.apptemplate.ui.base;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * viewpage适配器
 */
public class MPageAdapter<T extends View> extends PagerAdapter {
    private List<T> views;

    @Override
    public int getCount() {
        return views != null ? views.size() : 0;
    }

    public MPageAdapter(List<T> views) {
        super();
        this.views = views;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public T instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }
}