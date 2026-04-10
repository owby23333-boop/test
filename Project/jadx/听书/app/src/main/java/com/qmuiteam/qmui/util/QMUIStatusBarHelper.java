package com.qmuiteam.qmui.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.uc.crashsdk.export.LogType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIStatusBarHelper {
    private static final int STATUSBAR_TYPE_ANDROID6 = 3;
    private static final int STATUSBAR_TYPE_DEFAULT = 0;
    private static final int STATUSBAR_TYPE_FLYME = 2;
    private static final int STATUSBAR_TYPE_MIUI = 1;
    private static final int STATUS_BAR_DEFAULT_HEIGHT_DP = 25;
    private static int mStatusBarType = 0;
    private static int sStatusBarHeight = -1;
    private static Integer sTransparentValue = null;
    public static float sVirtualDensity = -1.0f;
    public static float sVirtualDensityDpi = -1.0f;

    public static void translucent(Activity activity) {
        translucent(activity.getWindow());
    }

    public static void translucent(Window window) {
        translucent(window, 1073741824);
    }

    private static boolean supportTranslucent() {
        QMUIDeviceHelper.isEssentialPhone();
        return true;
    }

    public static void translucent(Activity activity, int i) {
        translucent(activity.getWindow(), i);
    }

    public static void translucent(Window window, int i) {
        if (supportTranslucent()) {
            if (QMUINotchHelper.isNotchOfficialSupport()) {
                handleDisplayCutoutMode(window);
            }
            if (QMUIDeviceHelper.isFlymeLowerThan(8)) {
                window.setFlags(67108864, 67108864);
                return;
            }
            QMUIDeviceHelper.isMIUI();
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | LogType.UNEXP_ANR);
            if (supportTransclentStatusBar6()) {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            } else {
                window.clearFlags(67108864);
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(i);
            }
        }
    }

    public static int retainSystemUiFlag(Window window, int i, int i2) {
        return (window.getDecorView().getSystemUiVisibility() & i2) == i2 ? i | i2 : i;
    }

    private static void handleDisplayCutoutMode(final Window window) {
        View decorView = window.getDecorView();
        if (decorView != null) {
            if (ViewCompat.isAttachedToWindow(decorView)) {
                realHandleDisplayCutoutMode(window, decorView);
            } else {
                decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.qmuiteam.qmui.util.QMUIStatusBarHelper.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewDetachedFromWindow(View view) {
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public void onViewAttachedToWindow(View view) {
                        view.removeOnAttachStateChangeListener(this);
                        QMUIStatusBarHelper.realHandleDisplayCutoutMode(window, view);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void realHandleDisplayCutoutMode(Window window, View view) {
        if (view.getRootWindowInsets() == null || view.getRootWindowInsets().getDisplayCutout() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
    }

    public static boolean setStatusBarLightMode(Activity activity) {
        if (activity == null || QMUIDeviceHelper.isZTKC2016()) {
            return false;
        }
        int i = mStatusBarType;
        if (i != 0) {
            return setStatusBarLightMode(activity, i);
        }
        if (isMIUICustomStatusBarLightModeImpl() && MIUISetStatusBarLightMode(activity.getWindow(), true)) {
            mStatusBarType = 1;
            return true;
        }
        if (FlymeSetStatusBarLightMode(activity.getWindow(), true)) {
            mStatusBarType = 2;
            return true;
        }
        Android6SetStatusBarLightMode(activity.getWindow(), true);
        mStatusBarType = 3;
        return true;
    }

    private static boolean setStatusBarLightMode(Activity activity, int i) {
        if (i == 1) {
            return MIUISetStatusBarLightMode(activity.getWindow(), true);
        }
        if (i == 2) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), true);
        }
        if (i == 3) {
            return Android6SetStatusBarLightMode(activity.getWindow(), true);
        }
        return false;
    }

    public static boolean setStatusBarDarkMode(Activity activity) {
        if (activity == null) {
            return false;
        }
        int i = mStatusBarType;
        if (i == 0) {
            return true;
        }
        if (i == 1) {
            return MIUISetStatusBarLightMode(activity.getWindow(), false);
        }
        if (i == 2) {
            return FlymeSetStatusBarLightMode(activity.getWindow(), false);
        }
        if (i == 3) {
            return Android6SetStatusBarLightMode(activity.getWindow(), false);
        }
        return true;
    }

    private static boolean Android6SetStatusBarLightMode(Window window, boolean z) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        if (!QMUIDeviceHelper.isMIUIV9()) {
            return true;
        }
        MIUISetStatusBarLightMode(window, z);
        return true;
    }

    public static boolean MIUISetStatusBarLightMode(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            if (z) {
                method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                method.invoke(window, 0, Integer.valueOf(i));
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isMIUICustomStatusBarLightModeImpl() {
        QMUIDeviceHelper.isMIUIV9();
        return QMUIDeviceHelper.isMIUIV5() || QMUIDeviceHelper.isMIUIV6() || QMUIDeviceHelper.isMIUIV7() || QMUIDeviceHelper.isMIUIV8();
    }

    public static boolean FlymeSetStatusBarLightMode(Window window, boolean z) {
        if (window != null) {
            Android6SetStatusBarLightMode(window, z);
            if (QMUIDeviceHelper.isFlymeLowerThan(7)) {
                try {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                    Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                    declaredField.setAccessible(true);
                    declaredField2.setAccessible(true);
                    int i = declaredField.getInt(null);
                    int i2 = declaredField2.getInt(attributes);
                    declaredField2.setInt(attributes, z ? i2 | i : (~i) & i2);
                    window.setAttributes(attributes);
                    return true;
                } catch (Exception unused) {
                }
            } else if (QMUIDeviceHelper.isFlyme()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isFullScreen(Activity activity) {
        try {
            return (activity.getWindow().getAttributes().flags & 1024) != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Integer getStatusBarAPITransparentValue(Context context) {
        Integer num = sTransparentValue;
        if (num != null) {
            return num;
        }
        String str = null;
        for (String str2 : context.getPackageManager().getSystemSharedLibraryNames()) {
            if ("touchwiz".equals(str2)) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT_BACKGROUND";
            } else if (str2.startsWith("com.sonyericsson.navigationbar")) {
                str = "SYSTEM_UI_FLAG_TRANSPARENT";
            }
        }
        if (str != null) {
            try {
                Field field = View.class.getField(str);
                if (field != null && field.getType() == Integer.TYPE) {
                    sTransparentValue = Integer.valueOf(field.getInt(null));
                }
            } catch (Exception unused) {
            }
        }
        return sTransparentValue;
    }

    public static boolean supportTransclentStatusBar6() {
        return (QMUIDeviceHelper.isZUKZ1() || QMUIDeviceHelper.isZTKC2016()) ? false : true;
    }

    public static int getStatusbarHeight(Context context) {
        if (sStatusBarHeight == -1) {
            initStatusBarHeight(context);
        }
        return sStatusBarHeight;
    }

    private static void initStatusBarHeight(Context context) {
        Throwable th;
        Field field;
        Object objNewInstance;
        Class<?> cls;
        Object obj = null;
        field = null;
        field = null;
        field = null;
        Field field2 = null;
        try {
            cls = Class.forName("com.android.internal.R$dimen");
            objNewInstance = cls.newInstance();
        } catch (Throwable th2) {
            th = th2;
            field = null;
        }
        try {
            if (QMUIDeviceHelper.isMeizu()) {
                try {
                    field2 = cls.getField("status_bar_height_large");
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            if (field2 == null) {
                field2 = cls.getField("status_bar_height");
            }
        } catch (Throwable th4) {
            field = field2;
            obj = objNewInstance;
            th = th4;
            th.printStackTrace();
            objNewInstance = obj;
            field2 = field;
        }
        if (field2 != null && objNewInstance != null) {
            try {
                sStatusBarHeight = context.getResources().getDimensionPixelSize(Integer.parseInt(field2.get(objNewInstance).toString()));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (sStatusBarHeight <= 0) {
            float f = sVirtualDensity;
            if (f == -1.0f) {
                sStatusBarHeight = QMUIDisplayHelper.dp2px(context, 25);
            } else {
                sStatusBarHeight = (int) ((f * 25.0f) + 0.5f);
            }
        }
    }

    public static void setVirtualDensity(float f) {
        sVirtualDensity = f;
    }

    public static void setVirtualDensityDpi(float f) {
        sVirtualDensityDpi = f;
    }
}
