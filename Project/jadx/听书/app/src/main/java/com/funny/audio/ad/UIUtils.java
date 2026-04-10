package com.funny.audio.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.media3.common.C;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
public class UIUtils {
    public static final int VIVO_FILLET = 8;
    public static final int VIVO_NOTCH = 32;

    public static float getScreenWidthDp(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static float getHeight(Activity activity) {
        int iPx2dip;
        hideBottomUIMenu(activity);
        int realHeight = getRealHeight(activity);
        if (hasNotchScreen(activity)) {
            iPx2dip = px2dip(activity, realHeight - getStatusBarHeight(activity));
        } else {
            iPx2dip = px2dip(activity, realHeight);
        }
        return iPx2dip;
    }

    public static void hideBottomUIMenu(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3842);
            activity.getWindow().addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getRealHeight(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static float getStatusBarHeight(Context context) {
        if (context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android") > 0) {
            return context.getApplicationContext().getResources().getDimensionPixelSize(r0);
        }
        return 0.0f;
    }

    public static int px2dip(Context context, float pxValue) {
        float f = context.getResources().getDisplayMetrics().density;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((pxValue / f) + 0.5f);
    }

    public static int dp2px(Context context, float dp) {
        return (int) ((dp * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean hasNotchScreen(Activity activity) {
        return isAndroidPHasNotch(activity) || getInt("ro.miui.notch", activity) == 1 || hasNotchAtHuawei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVivo(activity);
    }

    public static boolean isAndroidPHasNotch(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            return (rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getInt(String key, Activity activity) {
        if (!isMiui()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(key), new Integer(0))).intValue();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return 0;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static boolean hasNotchAtHuawei(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNotchAtVivo(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean hasNotchAtOPPO(Context context) {
        return context.getPackageManager().hasSystemFeature(getKllkDecryptString("com.kllk.feature.screen.heteromorphism"));
    }

    public static boolean isMiui() {
        try {
            return Class.forName("miui.os.Build") != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getKllkDecryptString(String encryptionString) {
        if (TextUtils.isEmpty(encryptionString)) {
            return "";
        }
        if (encryptionString.contains("KLLK")) {
            return encryptionString.replace("KLLK", "OPPO");
        }
        return encryptionString.contains("kllk") ? encryptionString.replace("kllk", "oppo") : "";
    }

    public static void setViewSize(View view, int width, int height) {
        if (view.getParent() instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = height;
            view.setLayoutParams(layoutParams);
            view.requestLayout();
            return;
        }
        if (view.getParent() instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams2.width = width;
            layoutParams2.height = height;
            view.setLayoutParams(layoutParams2);
            view.requestLayout();
            return;
        }
        if (view.getParent() instanceof LinearLayout) {
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view.getLayoutParams();
            layoutParams3.width = width;
            layoutParams3.height = height;
            view.setLayoutParams(layoutParams3);
            view.requestLayout();
        }
    }

    public static int getScreenWidthInPx(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeightInPx(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenHeight(Context context) {
        return (int) (getScreenHeightInPx(context) + getStatusBarHeight(context));
    }

    public static void removeFromParent(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static int[] getScreenSize(Context context) {
        int[] iArr = {0, 0};
        if (context == null) {
            return iArr;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        iArr[0] = displayMetrics.widthPixels;
        iArr[1] = displayMetrics.heightPixels;
        return iArr;
    }
}
