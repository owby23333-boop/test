package com.zackratos.ultimatebarx.ultimatebarx.extension;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.uc.crashsdk.export.LogType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Activity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0003\u001a\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0003\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0002H\u0001\u001a\f\u0010\u0019\u001a\u00020\u0018*\u00020\u0002H\u0001\u001a\u0014\u0010\u001a\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0001\u001a\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0001\u001a\f\u0010\u001c\u001a\u00020\u0018*\u00020\u0002H\u0001\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u0018\u0010\u000b\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n\"\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"contentView", "Landroid/view/ViewGroup;", "Landroidx/fragment/app/FragmentActivity;", "getContentView", "(Landroidx/fragment/app/FragmentActivity;)Landroid/view/ViewGroup;", "decorView", "getDecorView", "originNavigationBarColor", "", "getOriginNavigationBarColor", "(Landroidx/fragment/app/FragmentActivity;)I", "originStatusBarColor", "getOriginStatusBarColor", "rootView", "Landroid/view/View;", "getRootView", "(Landroidx/fragment/app/FragmentActivity;)Landroid/view/View;", "statusBarSystemUiFlag", "light", "", "systemUiFlag", "statusBarLight", "navigationBarLight", "barTransparent", "", "navigationBarTransparent", "setStatusBarSystemUiFlagWithLight", "setSystemUiFlagWithLight", "statusBarTransparent", "ultimatebarx_release"}, k = 2, mv = {1, 1, 16})
public final class ActivityKt {
    private static final int statusBarSystemUiFlag(boolean z) {
        if (z) {
            return 9472;
        }
        return LogType.UNEXP_ANR;
    }

    private static final int systemUiFlag(boolean z, boolean z2) {
        int i = z ? 9984 : 1792;
        return z2 ? i | 16 : i;
    }

    public static final void setSystemUiFlagWithLight(FragmentActivity setSystemUiFlagWithLight, boolean z, boolean z2) {
        View decorView;
        Intrinsics.checkParameterIsNotNull(setSystemUiFlagWithLight, "$this$setSystemUiFlagWithLight");
        Window window = setSystemUiFlagWithLight.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(systemUiFlag(z, z2));
    }

    public static final void setStatusBarSystemUiFlagWithLight(FragmentActivity setStatusBarSystemUiFlagWithLight, boolean z) {
        View decorView;
        Intrinsics.checkParameterIsNotNull(setStatusBarSystemUiFlagWithLight, "$this$setStatusBarSystemUiFlagWithLight");
        Window window = setStatusBarSystemUiFlagWithLight.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.setSystemUiVisibility(statusBarSystemUiFlag(z));
    }

    public static final void barTransparent(FragmentActivity barTransparent) {
        Intrinsics.checkParameterIsNotNull(barTransparent, "$this$barTransparent");
        statusBarTransparent(barTransparent);
        navigationBarTransparent(barTransparent);
    }

    public static final void statusBarTransparent(FragmentActivity statusBarTransparent) {
        Intrinsics.checkParameterIsNotNull(statusBarTransparent, "$this$statusBarTransparent");
        if (Build.VERSION.SDK_INT >= 29) {
            Window window = statusBarTransparent.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "window");
            window.setStatusBarContrastEnforced(false);
        }
        Window window2 = statusBarTransparent.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window2, "window");
        window2.setStatusBarColor(0);
    }

    public static final void navigationBarTransparent(FragmentActivity navigationBarTransparent) {
        Intrinsics.checkParameterIsNotNull(navigationBarTransparent, "$this$navigationBarTransparent");
        if (Build.VERSION.SDK_INT >= 29) {
            Window window = navigationBarTransparent.getWindow();
            Intrinsics.checkExpressionValueIsNotNull(window, "window");
            window.setNavigationBarContrastEnforced(false);
        }
        Window window2 = navigationBarTransparent.getWindow();
        Intrinsics.checkExpressionValueIsNotNull(window2, "window");
        window2.setNavigationBarColor(0);
    }

    public static final ViewGroup getDecorView(FragmentActivity decorView) {
        Intrinsics.checkParameterIsNotNull(decorView, "$this$decorView");
        Window window = decorView.getWindow();
        return (ViewGroup) (window != null ? window.getDecorView() : null);
    }

    public static final ViewGroup getContentView(FragmentActivity contentView) {
        Intrinsics.checkParameterIsNotNull(contentView, "$this$contentView");
        ViewGroup decorView = getDecorView(contentView);
        if (decorView != null) {
            return (ViewGroup) decorView.findViewById(R.id.content);
        }
        return null;
    }

    public static final View getRootView(FragmentActivity rootView) {
        Intrinsics.checkParameterIsNotNull(rootView, "$this$rootView");
        ViewGroup contentView = getContentView(rootView);
        if (contentView != null) {
            return contentView.getChildAt(0);
        }
        return null;
    }

    public static final int getOriginStatusBarColor(FragmentActivity originStatusBarColor) {
        Intrinsics.checkParameterIsNotNull(originStatusBarColor, "$this$originStatusBarColor");
        Window window = originStatusBarColor.getWindow();
        if (window != null) {
            return window.getStatusBarColor();
        }
        return 0;
    }

    public static final int getOriginNavigationBarColor(FragmentActivity originNavigationBarColor) {
        Intrinsics.checkParameterIsNotNull(originNavigationBarColor, "$this$originNavigationBarColor");
        Window window = originNavigationBarColor.getWindow();
        if (window != null) {
            return window.getNavigationBarColor();
        }
        return 0;
    }
}
