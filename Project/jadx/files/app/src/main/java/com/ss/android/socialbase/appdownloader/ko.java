package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* JADX INFO: loaded from: classes3.dex */
public final class ko {

    public static class mb {
        private Drawable b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f18065h;
        private String hj;
        private boolean ko;
        private String mb;
        private String ox;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private int f18066u;

        public mb(String str, String str2, Drawable drawable, String str3, String str4, int i2, boolean z2) {
            ox(str2);
            mb(drawable);
            mb(str);
            b(str3);
            hj(str4);
            mb(i2);
            mb(z2);
        }

        public String b() {
            return this.mb;
        }

        public String h() {
            return this.hj;
        }

        public String hj() {
            return this.ox;
        }

        public String ko() {
            return this.f18065h;
        }

        public Drawable mb() {
            return this.b;
        }

        public boolean ox() {
            return this.ko;
        }

        public String toString() {
            return "{\n  pkg name: " + b() + "\n  app icon: " + mb() + "\n  app name: " + hj() + "\n  app path: " + h() + "\n  app v name: " + ko() + "\n  app v code: " + u() + "\n  is system: " + ox() + "}";
        }

        public int u() {
            return this.f18066u;
        }

        public void b(String str) {
            this.hj = str;
        }

        public void hj(String str) {
            this.f18065h = str;
        }

        public void mb(Drawable drawable) {
            this.b = drawable;
        }

        public void ox(String str) {
            this.ox = str;
        }

        public void mb(boolean z2) {
            this.ko = z2;
        }

        public void mb(String str) {
            this.mb = str;
        }

        public void mb(int i2) {
            this.f18066u = i2;
        }
    }

    private static boolean b(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static int mb(String str) {
        if (b(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = DownloadComponentManager.getAppContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static mb ox(String str) {
        try {
            PackageManager packageManager = DownloadComponentManager.getAppContext().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return mb(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static mb mb(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawableLoadIcon = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String string = applicationInfo.loadLabel(packageManager).toString();
        try {
            drawableLoadIcon = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new mb(str, string, drawableLoadIcon, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
