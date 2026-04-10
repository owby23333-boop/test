package xyz.doikki.videoplayer.util;

import xyz.doikki.videoplayer.player.VideoViewManager;

/* JADX INFO: loaded from: classes4.dex */
public final class L {
    private static final String TAG = "DKPlayer";
    private static boolean isDebug = VideoViewManager.getConfig().mIsEnableLog;

    private L() {
    }

    public static void d(String str) {
        boolean z2 = isDebug;
    }

    public static void e(String str) {
        boolean z2 = isDebug;
    }

    public static void i(String str) {
        boolean z2 = isDebug;
    }

    public static void setDebug(boolean z2) {
        isDebug = z2;
    }

    public static void w(String str) {
        boolean z2 = isDebug;
    }
}
