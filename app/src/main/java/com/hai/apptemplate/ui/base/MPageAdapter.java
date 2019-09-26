package com.hai.apptemplate.ui.base;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * viewpage适配器
 */
public class MPageAdapter extends PagerAdapter {
    private List<View> views;

    @Override
    public int getCount() {
        return views.size();
    }

    public MPageAdapter(List<View> views) {
        super();
        this.views = views;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }
}