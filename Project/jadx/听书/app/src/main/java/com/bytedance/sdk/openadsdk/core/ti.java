package com.bytedance.sdk.openadsdk.core;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class ti {
    public static String z(int i) {
        switch (i) {
            case 1:
                return "view不可见";
            case 2:
            case 5:
            default:
                return "";
            case 3:
                return "view可见区域比例不够";
            case 4:
                return "屏幕关闭";
            case 6:
                return "view可见宽高不够";
            case 7:
                return "show检测发生崩溃";
            case 8:
                return "设置为了不需要检测";
            case 9:
                return "没有在检测";
            case 10:
                return "没有在检测，已show";
        }
    }

    private static boolean z(View view, int i) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null) {
            Rect rect = new Rect();
            if (!view.getGlobalVisibleRect(rect) && (!zw.g().un() || !z(view, new Rect(), (Point) null))) {
                return false;
            }
            long jHeight = ((long) rect.height()) * ((long) rect.width());
            long height = ((long) view.getHeight()) * ((long) view.getWidth());
            if (height > 0 && jHeight * 100 >= ((long) i) * height) {
                return true;
            }
        }
        return false;
    }

    public static boolean z(View view, Rect rect, Point point) {
        if (view == null) {
            return false;
        }
        int right = view.getRight() - view.getLeft();
        int bottom = view.getBottom() - view.getTop();
        if (right <= 0 || bottom <= 0) {
            return false;
        }
        rect.set(0, 0, right, bottom);
        if (point != null) {
            point.set(-view.getScrollX(), -view.getScrollY());
        }
        return view.getParent() == null || view.getParent().getChildVisibleRect(view, rect, point);
    }

    private static boolean g(View view) {
        return view != null && view.isShown();
    }

    private static boolean g(View view, int i) {
        return view.getWidth() >= dl(view, i) && view.getHeight() >= a(view, i);
    }

    private static int dl(View view, int i) {
        if (i == 3) {
            return (int) (((double) com.bytedance.sdk.openadsdk.core.un.oq.a(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    private static int a(View view, int i) {
        if (i == 3) {
            return com.bytedance.sdk.openadsdk.core.un.oq.gc(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    public static int z(View view, int i, int i2) throws Throwable {
        if (!com.bytedance.sdk.openadsdk.core.un.kb.z()) {
            return 4;
        }
        if (!g(view)) {
            return 1;
        }
        if (g(view, i2)) {
            return !z(view, i) ? 3 : 0;
        }
        return 6;
    }

    public static boolean g(View view, int i, int i2) {
        return z(view, i, i2) == 0;
    }

    public static boolean z(View view) {
        if (view != null && view.getVisibility() == 0 && view.getParent() != null && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            return z(view, 20);
        }
        return false;
    }
}
