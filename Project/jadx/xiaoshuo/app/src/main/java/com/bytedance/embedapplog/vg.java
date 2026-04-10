package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
final class vg {

    public static class e implements Runnable {
        private final String bf;
        private final String d = Log.getStackTraceString(new RuntimeException("origin stacktrace"));
        private final Runnable e;

        public e(Runnable runnable, String str) {
            this.e = runnable;
            this.bf = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.e.run();
            } catch (Exception e) {
                tx.d("Thread:" + this.bf + " exception\n" + this.d, e);
            }
        }
    }

    public static boolean e(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.d("HWOAID", "getPackageInfo NameNotFoundException");
            return false;
        } catch (Exception unused2) {
            Log.d("HWOAID", "getPackageInfo Exception");
            return false;
        }
    }

    public static void e(@Nullable String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new Thread(new e(runnable, str), str).start();
    }
}
