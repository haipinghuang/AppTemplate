package com.hai.apptemplate.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.widget.Toast;

/**
 * 单例toast
 * Created by huanghp on 2018/9/27.
 * Email h1132760021@sina.com
 */
public class MyToast {
    private static final int SHOW_INTERVAL = 2500;
    private static String lastMsg;
    private static long lastTime;
    private static Toast toast;

    public static void show(@NonNull Context context, @StringRes int msgId) {
        show(context, context.getString(msgId), Toast.LENGTH_SHORT);
    }

    public static void show(@NonNull Context context, @NonNull String msg) {
        show(context, msg, Toast.LENGTH_SHORT);
    }

    public static void show(@NonNull Context context, @NonNull String msg, int duration) {
        show(context, msg, duration, Gravity.BOTTOM);
    }

    public static void show(@NonNull Context context, @NonNull String msg, int duration, int gravity) {
        if (msg != null && context != null) {

            initToast(context, msg, duration, gravity);

            if (!msg.equals(lastMsg)) { // 当显示的内容不一样时
                toast.cancel();
                toast = null;
                initToast(context, msg, duration, gravity);
                toast.show();
                lastTime = System.currentTimeMillis();
            } else {
                // 显示内容一样时，只有间隔时间大于2秒时才显示
                if (System.currentTimeMillis() - lastTime > SHOW_INTERVAL) {
                    toast.cancel();
                    toast = null;
                    initToast(context, msg, duration, gravity);
                    toast.show();
                    lastTime = System.currentTimeMillis();
                }
            }
            lastMsg = msg;
        }
    }

    private static void initToast(@NonNull Context context, @NonNull String msg, int duration, int gravity) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, duration);
            toast.setGravity(gravity, 0, 0);
        }
    }

    public static void cancel() {
        if (toast != null) toast.cancel();
    }
}
