package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
final class zb {
    static boolean z(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 128) != null;
    }

    static boolean z(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return false;
        }
    }

    static void z(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new com.bytedance.sdk.component.uy.a.dl(new z(runnable, str), str).start();
    }

    static class z implements Runnable {
        private final String dl = Log.getStackTraceString(new RuntimeException("origin stacktrace"));
        private final String g;
        private final Runnable z;

        z(Runnable runnable, String str) {
            this.z = runnable;
            this.g = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.z.run();
            } catch (Exception e) {
                cb.dl("Thread:" + this.g + " exception\n" + this.dl, e);
            }
        }
    }
}
