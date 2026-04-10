package com.dangdang.thirdpart.umeng;

import android.content.Context;
import com.umeng.analytics.MobclickAgent;

/* JADX INFO: loaded from: classes10.dex */
public class UmengStatistics {
    public static boolean openStatis = false;

    public static void onEvent(Context context, String str) {
        if (openStatis) {
            MobclickAgent.onEvent(context, str);
        }
    }

    public static void onKillProcess(Context context) {
        if (openStatis) {
            MobclickAgent.onKillProcess(context);
        }
    }

    public static void onPageEnd(String str) {
        if (openStatis) {
            MobclickAgent.onPageEnd(str);
        }
    }

    public static void onPageStart(String str) {
        if (openStatis) {
            MobclickAgent.onPageStart(str);
        }
    }

    public static void onPause(Context context) {
        if (openStatis) {
            MobclickAgent.onPause(context);
        }
    }

    public static void onResume(Context context) {
        if (openStatis) {
            MobclickAgent.onResume(context);
        }
    }

    public static void reportError(Context context, String str) {
        if (openStatis) {
            MobclickAgent.reportError(context, str);
        }
    }

    public static void setCatchUncaughtExceptions(boolean z) {
        if (openStatis) {
            MobclickAgent.setCatchUncaughtExceptions(z);
        }
    }
}
