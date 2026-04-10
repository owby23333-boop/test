package com.bigkoo.dkconvenientbanner.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.yuewen.kl2;

/* JADX INFO: loaded from: classes.dex */
public class ScreenUtil {
    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @TargetApi(13)
    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    @TargetApi(13)
    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
