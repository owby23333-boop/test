package com.zackratos.ultimatebarx.ultimatebarx.extension;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Context.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0002H\u0001\u001a\u0014\u0010\u000e\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0016\u0010\u0011\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0012\u001a\u00020\u0006H\u0001\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\u0006*\u00020\u00028AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0018\u0010\u000b\u001a\u00020\u0006*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0013"}, d2 = {"landscape", "", "Landroid/content/Context;", "getLandscape", "(Landroid/content/Context;)Z", "navigationBarHeight", "", "getNavigationBarHeight", "(Landroid/content/Context;)I", "screenHeight", "getScreenHeight", "statusBarHeight", "getStatusBarHeight", "commonNavigationBarExist", "getBarHeight", "name", "", "getColorInt", "colorRes", "ultimatebarx_release"}, k = 2, mv = {1, 1, 16})
public final class ContextKt {
    private static final int getBarHeight(Context context, String str) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier(str, "dimen", "android"));
    }

    public static final int getStatusBarHeight(Context statusBarHeight) {
        Intrinsics.checkParameterIsNotNull(statusBarHeight, "$this$statusBarHeight");
        return getBarHeight(statusBarHeight, "status_bar_height");
    }

    public static final int getNavigationBarHeight(Context navigationBarHeight) {
        Intrinsics.checkParameterIsNotNull(navigationBarHeight, "$this$navigationBarHeight");
        return getBarHeight(navigationBarHeight, "navigation_bar_height");
    }

    public static final boolean getLandscape(Context landscape) {
        Intrinsics.checkParameterIsNotNull(landscape, "$this$landscape");
        Resources resources = landscape.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        return resources.getConfiguration().orientation == 2;
    }

    public static final int getColorInt(Context getColorInt, int i) {
        Intrinsics.checkParameterIsNotNull(getColorInt, "$this$getColorInt");
        return ContextCompat.getColor(getColorInt, i);
    }

    public static final int getScreenHeight(Context screenHeight) {
        Intrinsics.checkParameterIsNotNull(screenHeight, "$this$screenHeight");
        Object systemService = screenHeight.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Point point = new Point();
        ((WindowManager) systemService).getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static final boolean commonNavigationBarExist(Context commonNavigationBarExist) {
        Intrinsics.checkParameterIsNotNull(commonNavigationBarExist, "$this$commonNavigationBarExist");
        Object systemService = commonNavigationBarExist.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }
}
