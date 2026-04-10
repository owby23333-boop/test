package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static int z(String str) {
        if (dl(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.dl.xl().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            com.ss.android.socialbase.downloader.m.z.gc("AppUtils", "getAppVersionCode:" + e.getMessage());
            return -1;
        }
    }

    public static z g(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.dl.xl().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return z(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e) {
            com.ss.android.socialbase.downloader.m.z.gc("AppUtils", "getAppInfo:" + e.getMessage());
            return null;
        }
    }

    private static z z(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawableLoadIcon = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String string = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawableLoadIcon = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new z(str, string, drawableLoadIcon, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2031a;
        private Drawable dl;
        private boolean e;
        private String g;
        private String gc;
        private int m;
        private String z;

        public Drawable z() {
            return this.dl;
        }

        public void z(Drawable drawable) {
            this.dl = drawable;
        }

        public boolean g() {
            return this.e;
        }

        public void z(boolean z) {
            this.e = z;
        }

        public String dl() {
            return this.z;
        }

        public void z(String str) {
            this.z = str;
        }

        public String a() {
            return this.g;
        }

        public void g(String str) {
            this.g = str;
        }

        public String gc() {
            return this.f2031a;
        }

        public void dl(String str) {
            this.f2031a = str;
        }

        public int m() {
            return this.m;
        }

        public void z(int i) {
            this.m = i;
        }

        public String e() {
            return this.gc;
        }

        public void a(String str) {
            this.gc = str;
        }

        public z(String str, String str2, Drawable drawable, String str3, String str4, int i, boolean z) {
            g(str2);
            z(drawable);
            z(str);
            dl(str3);
            a(str4);
            z(i);
            z(z);
        }

        public String toString() {
            return "{\n  pkg name: " + dl() + "\n  app icon: " + z() + "\n  app name: " + a() + "\n  app path: " + gc() + "\n  app v name: " + e() + "\n  app v code: " + m() + "\n  is system: " + g() + "}";
        }
    }

    private static boolean dl(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
