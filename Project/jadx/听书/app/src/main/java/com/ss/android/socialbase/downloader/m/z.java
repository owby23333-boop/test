package com.ss.android.socialbase.downloader.m;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes4.dex */
public class z {
    private static AbstractC0481z g = null;
    private static int z = 4;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.m.z$z, reason: collision with other inner class name */
    public static abstract class AbstractC0481z {
    }

    public static void z(int i) {
        z = i;
    }

    public static boolean z() {
        return z <= 3;
    }

    public static void z(String str, String str2) {
        if (str2 == null || g == null) {
            return;
        }
        g(str);
    }

    public static void z(String str) {
        g("DownloaderLogger", str);
    }

    public static String g(String str) {
        return !TextUtils.isEmpty(str) ? "Downloader-" + str : "DownloaderLogger";
    }

    public static void g(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (z <= 3) {
            g(str);
        }
        if (g != null) {
            g(str);
        }
    }

    public static void z(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (z <= 3) {
            g(str);
        }
        if (g != null) {
            g(str);
        }
    }

    public static void dl(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (z <= 4) {
            wp.z(g(str), str2);
        }
        if (g != null) {
            g(str);
        }
    }

    public static void dl(String str) {
        a("DownloaderLogger", str);
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (z <= 5) {
            wp.g(g(str), str2);
        }
        if (g != null) {
            g(str);
        }
    }

    public static void gc(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (z <= 6) {
            wp.a(g(str), str2);
        }
        if (g != null) {
            g(str);
        }
    }

    public static void g(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (z <= 6) {
            wp.dl(g(str), str2, th);
        }
        if (g != null) {
            g(str);
        }
    }
}
