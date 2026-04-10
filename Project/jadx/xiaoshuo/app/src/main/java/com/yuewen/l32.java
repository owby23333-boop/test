package com.yuewen;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes12.dex */
public abstract class l32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f13797b;
    public static final rd2<Boolean> c = new rd2<>();

    static {
        boolean z;
        int i = 0;
        try {
            Class.forName("miui.os.Build");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        f13797b = z;
        try {
            Class<?> cls = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            i = cls.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls);
        } catch (Throwable unused2) {
        }
        f13796a = i;
    }

    public static boolean a(Activity activity) {
        if (!f13797b || activity == null) {
            return false;
        }
        try {
            int iC = c(activity.getWindow().getAttributes());
            int i = f13796a;
            return (iC & i) == i;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Activity activity, View view) {
        View rootView;
        if (!f13797b || view == null || (rootView = view.getRootView()) == null) {
            return false;
        }
        Activity activityC = qd.c(rootView.getContext());
        if (activityC != null) {
            activity = activityC;
        } else if (activity == null) {
            return false;
        }
        try {
            int iC = c(rootView == activity.getWindow().getDecorView().getRootView() ? activity.getWindow().getAttributes() : (WindowManager.LayoutParams) rootView.getLayoutParams());
            int i = f13796a;
            return (iC & i) == i;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(WindowManager.LayoutParams layoutParams) {
        if (!f13797b) {
            return 0;
        }
        try {
            return layoutParams.getClass().getField("extraFlags").getInt(layoutParams);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean d() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return ((Integer) cls.getMethod("getInt", String.class, Integer.TYPE).invoke(cls, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean e() {
        rd2<Boolean> rd2Var = c;
        if (rd2Var.hasValue()) {
            return rd2Var.getValue().booleanValue();
        }
        boolean zBooleanValue = false;
        try {
            zBooleanValue = ((Boolean) Class.forName("miui.util.MiuiFeatureUtils").getDeclaredMethod("isLiteMode", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Throwable unused) {
        }
        rd2<Boolean> rd2Var2 = c;
        rd2Var2.setValue(Boolean.valueOf(zBooleanValue));
        return rd2Var2.getValue().booleanValue();
    }

    public static boolean f() {
        return f13797b;
    }

    public static void g(Activity activity, boolean z) {
        if (f13797b && activity != null) {
            try {
                i(activity.getWindow(), z);
            } catch (Throwable unused) {
            }
        }
    }

    public static void h(View view, boolean z) {
        View rootView;
        Activity activityC;
        if (!f13797b || view == null || (rootView = view.getRootView()) == null || (activityC = qd.c(view.getContext())) == null) {
            return;
        }
        try {
            if (rootView == activityC.getWindow().getDecorView().getRootView()) {
                i(activityC.getWindow(), z);
                return;
            }
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) rootView.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (z) {
                j(layoutParams, c(layoutParams) | f13796a);
            } else {
                j(layoutParams, c(layoutParams) & (~f13796a));
            }
            ((WindowManager) view.getContext().getSystemService(kl2.t9)).updateViewLayout(rootView, layoutParams);
        } catch (Throwable unused) {
        }
    }

    public static void i(Window window, boolean z) {
        if (f13797b && window != null) {
            try {
                Class<?> cls = window.getClass();
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("setExtraFlags", cls2, cls2);
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(z ? f13796a : 0);
                objArr[1] = Integer.valueOf(f13796a);
                method.invoke(window, objArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static void j(WindowManager.LayoutParams layoutParams, int i) {
        if (f13797b) {
            try {
                layoutParams.getClass().getField("extraFlags").setInt(layoutParams, i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
