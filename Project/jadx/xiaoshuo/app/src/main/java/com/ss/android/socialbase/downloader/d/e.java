package com.ss.android.socialbase.downloader.d;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    private static AbstractC0500e bf = null;
    private static int e = 4;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.d.e$e, reason: collision with other inner class name */
    public static abstract class AbstractC0500e {
        public void bf(String str, String str2) {
        }

        public void d(String str, String str2) {
        }

        public void e(String str, String str2) {
        }

        public void ga(String str, String str2) {
        }

        public void tg(String str, String str2) {
        }

        public void e(String str, String str2, Throwable th) {
        }
    }

    public static String bf(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    public static void d(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (e <= 4) {
            Log.i(bf(str), str2);
        }
        AbstractC0500e abstractC0500e = bf;
        if (abstractC0500e != null) {
            abstractC0500e.d(bf(str), str2);
        }
    }

    public static void e(int i) {
        e = i;
    }

    public static void ga(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (e <= 6) {
            Log.e(bf(str), str2);
        }
        AbstractC0500e abstractC0500e = bf;
        if (abstractC0500e != null) {
            abstractC0500e.tg(bf(str), str2);
        }
    }

    public static void tg(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (e <= 5) {
            Log.w(bf(str), str2);
        }
        AbstractC0500e abstractC0500e = bf;
        if (abstractC0500e != null) {
            abstractC0500e.ga(bf(str), str2);
        }
    }

    public static boolean e() {
        return e <= 3;
    }

    public static void bf(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (e <= 3) {
            Log.d(bf(str), str2);
        }
        AbstractC0500e abstractC0500e = bf;
        if (abstractC0500e != null) {
            abstractC0500e.bf(bf(str), str2);
        }
    }

    public static void e(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (e <= 2) {
            Log.v(str, str2);
        }
        AbstractC0500e abstractC0500e = bf;
        if (abstractC0500e != null) {
            abstractC0500e.e(bf(str), str2);
        }
    }

    public static void d(String str) {
        tg("DownloaderLogger", str);
    }

    public static void e(String str) {
        bf("DownloaderLogger", str);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (e <= 6) {
            Log.e(bf(str), str2, th);
        }
        AbstractC0500e abstractC0500e = bf;
        if (abstractC0500e != null) {
            abstractC0500e.e(bf(str), str2, th);
        }
    }
}
