package com.hai.apptemplate.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by 黄海 on 2016/9/28.
 */

public abstract class MBaseListAdapter<T, VH extends MBaseListAdapter.ViewHolder> extends BaseAdapter {
    public List<T> list;
    public Context context;

    public MBaseListAdapter(List<T> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = onCreateViewHolder(parent, getItemViewType(position));
            convertView = holder.itemView;
        }
        onBindViewHolder((VH) holder, position);
        ViewHolder hold = new ViewHolder(null) {
        };
        return convertView;
    }

    public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindViewHolder(VH holder, int position);

    public static abstract class Adapter<VH extends ViewHolder> {
        public abstract VH onCreateViewHolder(ViewGroup parent, int viewType);

        public abstract void onBindViewHolder(VH holder, int position);
    }

    public static abstract class ViewHolder {
        public final View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
        }
    }
}
