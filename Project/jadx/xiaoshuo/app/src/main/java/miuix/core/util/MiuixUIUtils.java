package miuix.core.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yuewen.kl2;
import miuix.reflect.Reflects;

/* JADX INFO: loaded from: classes7.dex */
public class MiuixUIUtils {
    public static final int FONT_LEVEL_LARGE = 2;
    public static final int FONT_LEVEL_NORMAL = 1;
    private static final String HIDE_GESTURE_LINE = "hide_gesture_line";
    private static final String TAG = "MiuixUtils";
    private static final String USE_GESTURE_VERSION_THREE = "use_gesture_version_three";
    private static TypedValue mTmpValue = new TypedValue();

    public static boolean checkDeviceHasNavigationBar(Context context) {
        String str = SystemProperties.get("qemu.hw.mainkeys");
        if ("1".equals(str)) {
            return false;
        }
        if ("0".equals(str)) {
            return true;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier > 0) {
            return resources.getBoolean(identifier);
        }
        return false;
    }

    private static boolean checkMultiWindow(Activity activity) {
        return activity.isInMultiWindowMode();
    }

    public static int dp2px(float f, float f2) {
        return (int) ((f2 * f) + 0.5f);
    }

    public static int getDefDimen(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(i, typedValue, true);
        return (int) TypedValue.complexToFloat(typedValue.data);
    }

    public static int getFontLevel(Context context) {
        return context.getResources().getConfiguration().fontScale < 1.55f ? 1 : 2;
    }

    public static int getNaviBarIntercationMode(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_navBarInteractionMode", TypedValues.Custom.S_INT, "android");
        if (identifier > 0) {
            return resources.getInteger(identifier);
        }
        return 0;
    }

    public static int getNavigationBarHeight(Context context) {
        int realNavigationBarHeight = (isShowNavigationHandle(context) || !isFullScreenGestureMode(context)) ? getRealNavigationBarHeight(context) : 0;
        if (realNavigationBarHeight < 0) {
            return 0;
        }
        return realNavigationBarHeight;
    }

    private static Point getPhysicalSize(Context context) {
        Point point = new Point();
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        Display defaultDisplay = windowManager.getDefaultDisplay();
        try {
            Object obj = Reflects.get(defaultDisplay, Reflects.getDeclaredField(defaultDisplay.getClass(), "mDisplayInfo"));
            point.x = ((Integer) Reflects.get(obj, Reflects.getField(obj.getClass(), "logicalWidth"))).intValue();
            point.y = ((Integer) Reflects.get(obj, Reflects.getField(obj.getClass(), "logicalHeight"))).intValue();
        } catch (Exception e) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            point.x = displayMetrics.widthPixels;
            point.y = displayMetrics.heightPixels;
            Log.w(TAG, "catch error! failed to get physical size", e);
        }
        return point;
    }

    public static int getRealNavigationBarHeight(Context context) {
        Resources resources;
        int identifier;
        if (checkDeviceHasNavigationBar(context) && (identifier = (resources = context.getResources()).getIdentifier("navigation_bar_height", "dimen", "android")) > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int[] getScreenSizeDp(Context context) {
        int[] iArr = new int[2];
        float f = context.getResources().getDisplayMetrics().density;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics maximumWindowMetrics = ((WindowManager) context.getSystemService(WindowManager.class)).getMaximumWindowMetrics();
            iArr[0] = (int) (maximumWindowMetrics.getBounds().width() / f);
            iArr[1] = (int) (maximumWindowMetrics.getBounds().height() / f);
        } else {
            ((WindowManager) context.getSystemService(kl2.t9)).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
            iArr[0] = (int) (r2.widthPixels / f);
            iArr[1] = (int) (r2.heightPixels / f);
        }
        return iArr;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean isEnableGestureLine(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), HIDE_GESTURE_LINE, 0) == 0;
    }

    @Deprecated
    public static boolean isFreeformMode(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(kl2.t9);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        Point physicalSize = getPhysicalSize(context);
        return context.getResources().getConfiguration().toString().contains("mWindowingMode=freeform") && ((((float) point.x) + 0.0f) / ((float) physicalSize.x) <= 0.9f || (((float) point.y) + 0.0f) / ((float) physicalSize.y) <= 0.9f);
    }

    public static boolean isFullScreenGestureMode(Context context) {
        return getNaviBarIntercationMode(context) == 2;
    }

    public static boolean isInMultiWindowMode(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return checkMultiWindow((Activity) context);
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return false;
    }

    public static boolean isLayoutHideNavigation(View view) {
        return (view.getWindowSystemUiVisibility() & 512) != 0;
    }

    @Deprecated
    public static boolean isNavigationBarFullScreen(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0;
    }

    public static boolean isShowNavigationHandle(Context context) {
        return isEnableGestureLine(context) && isFullScreenGestureMode(context) && isSupportGestureLine(context);
    }

    public static boolean isSupportGestureLine(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), USE_GESTURE_VERSION_THREE, 0) != 0;
    }

    public static boolean isTallFontLang(Context context) {
        if (context == null) {
            return false;
        }
        String language = context.getResources().getConfiguration().locale.getLanguage();
        return "bo".equals(language) || "ta".equals(language);
    }

    public static int px2dp(float f, float f2) {
        return (int) ((f2 / f) + 0.5f);
    }

    public static int dp2px(Context context, float f) {
        return dp2px(context.getResources().getConfiguration().densityDpi / 160.0f, f);
    }

    public static int px2dp(Context context, float f) {
        return px2dp(context.getResources().getConfiguration().densityDpi / 160.0f, f);
    }
}
