package xyz.doikki.videoplayer.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public final class PlayerUtils {
    public static final int NETWORK_CLOSED = 1;
    public static final int NETWORK_ETHERNET = 2;
    public static final int NETWORK_MOBILE = 4;
    public static final int NETWORK_UNKNOWN = -1;
    public static final int NETWORK_WIFI = 3;
    public static final int NO_NETWORK = 0;

    private PlayerUtils() {
    }

    public static int dp2px(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    @SuppressLint({"PrivateApi"})
    @Deprecated
    public static Application getApplication() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getCurrentSystemTime() {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
    }

    public static int getNavigationBarHeight(Context context) {
        if (!hasNavigationBar(context)) {
            return 0;
        }
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID));
    }

    public static int getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 0;
        }
        if (!activeNetworkInfo.isConnected()) {
            return 1;
        }
        if (activeNetworkInfo.getType() == 9) {
            return 2;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 3;
        }
        if (activeNetworkInfo.getType() != 0) {
            return -1;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 20) {
            return 4;
        }
        switch (subtype) {
        }
        return 0;
    }

    public static int getScreenHeight(Context context, boolean z2) {
        return z2 ? context.getResources().getDisplayMetrics().heightPixels + getNavigationBarHeight(context) : context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context, boolean z2) {
        return z2 ? context.getResources().getDisplayMetrics().widthPixels + getNavigationBarHeight(context) : context.getResources().getDisplayMetrics().widthPixels;
    }

    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t2 : collection) {
            if (t2 != null) {
                arrayList.add(t2);
            }
        }
        return arrayList;
    }

    public static double getStatusBarHeight(Context context) {
        return context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID) > 0 ? context.getResources().getDimensionPixelSize(r0) : 0;
    }

    public static double getStatusBarHeightPortrait(Context context) {
        return context.getResources().getIdentifier("status_bar_height_portrait", "dimen", DispatchConstants.ANDROID) > 0 ? context.getResources().getDimensionPixelSize(r0) : 0;
    }

    public static WindowManager getWindowManager(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static boolean hasNavigationBar(Context context) {
        if (Build.VERSION.SDK_INT < 17) {
            return (ViewConfiguration.get(context).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
        Display defaultDisplay = getWindowManager(context).getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        return (point2.x == point.x && point2.y == point.y) ? false : true;
    }

    public static boolean isEdge(Context context, MotionEvent motionEvent) {
        int iDp2px = dp2px(context, 40.0f);
        float f2 = iDp2px;
        return motionEvent.getRawX() < f2 || motionEvent.getRawX() > ((float) (getScreenWidth(context, true) - iDp2px)) || motionEvent.getRawY() < f2 || motionEvent.getRawY() > ((float) (getScreenHeight(context, true) - iDp2px));
    }

    public static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int sp2px(Context context, float f2) {
        return (int) TypedValue.applyDimension(2, f2, context.getResources().getDisplayMetrics());
    }

    public static String stringForTime(int i2) {
        int i3 = i2 / 1000;
        int i4 = i3 % 60;
        int i5 = (i3 / 60) % 60;
        int i6 = i3 / 3600;
        return i6 > 0 ? String.format(Locale.getDefault(), "%d:%02d:%02d", Integer.valueOf(i6), Integer.valueOf(i5), Integer.valueOf(i4)) : String.format(Locale.getDefault(), "%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4));
    }
}
