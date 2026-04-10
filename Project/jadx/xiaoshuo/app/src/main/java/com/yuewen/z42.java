package com.yuewen;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;

/* JADX INFO: loaded from: classes5.dex */
public class z42 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Point f20687a = new Point();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f20688b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 4100;
    public static final int f = 4097;
    public static final int g = 4098;
    public static final int h = 4099;
    public static final int i = 8192;
    public static final int j = 8193;
    public static final int k = 8194;
    public static final int l = 8195;
    public static final int m = 8196;
    public static final int n = 1001;
    public static final int o = 1002;

    public static int a(ci4 ci4Var) {
        return ((float) ci4Var.f9672b) >= Resources.getSystem().getDisplayMetrics().density * 676.0f ? 2 : 1;
    }

    public static int b(ci4 ci4Var) {
        return ci4Var.f9672b > ci4Var.c ? 1001 : 1002;
    }

    public static ci4 c(float f2, int i2, int i3) {
        ci4 ci4Var = new ci4();
        if (f2 <= 0.0f) {
            ci4Var.f9671a = 8192;
        } else if (f2 >= 0.74f && f2 < 0.76f) {
            ci4Var.f9671a = 8195;
        } else if (f2 >= 1.32f && f2 < 1.34f) {
            ci4Var.f9671a = 8194;
        } else if (f2 < 1.76f || f2 >= 1.79f) {
            ci4Var.f9671a = 8196;
        } else {
            ci4Var.f9671a = 8193;
        }
        ci4Var.f9672b = i2;
        ci4Var.c = i3;
        return ci4Var;
    }

    public static ci4 d(Context context) {
        return i(context) ? e(context) : g(context);
    }

    public static ci4 e(Context context) {
        int iWidth;
        int iHeight;
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            if (currentWindowMetrics == null || currentWindowMetrics.getBounds().width() == 0) {
                iWidth = 0;
                iHeight = 0;
            } else {
                iWidth = currentWindowMetrics.getBounds().width();
                iHeight = currentWindowMetrics.getBounds().height();
                f = (iHeight * 1.0f) / iWidth;
            }
        } else {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            int i2 = point.x;
            int i3 = point.y;
            f = i2 != 0 ? (i3 * 1.0f) / i2 : 0.0f;
            iWidth = i2;
            iHeight = i3;
        }
        return c(f, iWidth, iHeight);
    }

    public static Point f(Context context) {
        Point point = new Point();
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        try {
            Object objB = e63.b(defaultDisplay, e63.c(defaultDisplay.getClass(), "mDisplayInfo"));
            point.x = ((Integer) e63.b(objB, e63.g(objB.getClass(), "logicalWidth"))).intValue();
            point.y = ((Integer) e63.b(objB, e63.g(objB.getClass(), "logicalHeight"))).intValue();
        } catch (Exception e2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            point.x = displayMetrics.widthPixels;
            point.y = displayMetrics.heightPixels;
            Log.w("MiuixUtils", "catch error! failed to get physical size", e2);
        }
        return point;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.yuewen.ci4 g(android.content.Context r5) {
        /*
            com.yuewen.ci4 r0 = new com.yuewen.ci4
            r0.<init>()
            android.view.WindowManager r1 = h(r5)
            android.view.Display r1 = r1.getDefaultDisplay()
            android.graphics.Point r2 = com.yuewen.z42.f20687a
            r1.getRealSize(r2)
            android.content.res.Resources r5 = r5.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            boolean r1 = k()
            r2 = 0
            if (r1 == 0) goto L2c
            int r1 = r5.widthPixels
            float r1 = (float) r1
            android.graphics.Point r3 = com.yuewen.z42.f20687a
            int r3 = r3.x
        L28:
            float r3 = (float) r3
            float r3 = r3 + r2
            float r1 = r1 / r3
            goto L42
        L2c:
            int r1 = r5.widthPixels
            float r1 = (float) r1
            android.graphics.Point r3 = com.yuewen.z42.f20687a
            int r4 = r3.x
            float r4 = (float) r4
            float r4 = r4 + r2
            float r1 = r1 / r4
            r4 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 != 0) goto L42
            int r1 = r5.heightPixels
            float r1 = (float) r1
            int r3 = r3.y
            goto L28
        L42:
            int r3 = r5.widthPixels
            r0.f9672b = r3
            int r5 = r5.heightPixels
            r0.c = r5
            r5 = 1053609165(0x3ecccccd, float:0.4)
            boolean r2 = j(r1, r2, r5)
            if (r2 == 0) goto L58
            r5 = 4097(0x1001, float:5.741E-42)
            r0.f9671a = r5
            goto L78
        L58:
            r2 = 1058642330(0x3f19999a, float:0.6)
            boolean r5 = j(r1, r5, r2)
            if (r5 == 0) goto L66
            r5 = 4098(0x1002, float:5.743E-42)
            r0.f9671a = r5
            goto L78
        L66:
            r5 = 1061997773(0x3f4ccccd, float:0.8)
            boolean r5 = j(r1, r2, r5)
            if (r5 == 0) goto L74
            r5 = 4099(0x1003, float:5.744E-42)
            r0.f9671a = r5
            goto L78
        L74:
            r5 = 4100(0x1004, float:5.745E-42)
            r0.f9671a = r5
        L78:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.z42.g(android.content.Context):com.yuewen.ci4");
    }

    public static WindowManager h(Context context) {
        return (WindowManager) context.getApplicationContext().getSystemService(kl2.t9);
    }

    public static boolean i(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        Point pointF = f(context);
        return context.getResources().getConfiguration().toString().contains("mWindowingMode=freeform") && ((((float) point.x) + 0.0f) / ((float) pointF.x) <= 0.9f || (((float) point.y) + 0.0f) / ((float) pointF.y) <= 0.9f);
    }

    public static boolean j(float f2, float f3, float f4) {
        return f2 >= f3 && f2 < f4;
    }

    public static boolean k() {
        Point point = f20687a;
        return point.x > point.y;
    }

    public static boolean l(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService(kl2.t9)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d;
    }
}
