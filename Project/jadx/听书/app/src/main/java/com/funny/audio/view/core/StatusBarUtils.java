package com.funny.audio.view.core;

import android.app.Activity;
import android.os.Build;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.zackratos.ultimatebarx.ultimatebarx.java.UltimateBarX;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StatusbarUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\n\u0010\u0011\u001a\u00020\u0004*\u00020\u0006¨\u0006\u0012"}, d2 = {"Lcom/funny/audio/view/core/StatusBarUtils;", "", "()V", "enableShortEdges", "", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "fullscreen", "getStatusBarHeight", "", "hide", "setStatusBarDarkMode", "setStatusBarLightMode", "show", "translucent", "translucentWithDarkMode", "translucentWithLightMode", "fullscreenToolbar", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StatusBarUtils {
    public static final StatusBarUtils INSTANCE = new StatusBarUtils();

    private StatusBarUtils() {
    }

    public final void setStatusBarLightMode(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QMUIStatusBarHelper.setStatusBarLightMode(activity);
    }

    public final void setStatusBarDarkMode(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QMUIStatusBarHelper.setStatusBarDarkMode(activity);
    }

    public final void translucent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QMUIStatusBarHelper.translucent(activity);
    }

    public final void translucentWithLightMode(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        translucent(activity);
        setStatusBarLightMode(activity);
    }

    public final void translucentWithDarkMode(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        translucent(activity);
        setStatusBarDarkMode(activity);
    }

    public final void hide(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().addFlags(1024);
    }

    public final void show(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().clearFlags(1024);
    }

    public final void enableShortEdges(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                activity.getWindow().setAttributes(attributes);
            }
        } catch (Exception unused) {
        }
    }

    public final int getStatusBarHeight(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return UltimateBarX.getStatusBarHeight();
    }

    public final void fullscreen(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        translucent(activity);
        enableShortEdges(activity);
        hide(activity);
    }

    public final void fullscreenToolbar(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        translucent(activity);
        enableShortEdges(activity);
        hide(activity);
    }
}
