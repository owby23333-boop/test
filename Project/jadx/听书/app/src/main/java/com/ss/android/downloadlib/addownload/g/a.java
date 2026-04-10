package com.ss.android.downloadlib.addownload.g;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static volatile a z;
    private final LinkedList<z> g = new LinkedList<>();
    private static final String[] dl = {"com", "android", "ss"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f1983a = {3101, 3102, 3103, 3201, 3202, 3203};

    private a() {
    }

    public static a z() {
        if (z == null) {
            synchronized (a.class) {
                if (z == null) {
                    z = new a();
                }
            }
        }
        return z;
    }

    public void z(String str) {
        z zVarDl;
        g();
        if (TextUtils.isEmpty(str) || (zVarDl = dl(str)) == null) {
            return;
        }
        synchronized (this.g) {
            this.g.add(zVarDl);
        }
    }

    public void g(String str) {
        g();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.g) {
            Iterator<z> it = this.g.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().z)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public z z(com.ss.android.g.z.g.g gVar) {
        if (gVar == null) {
            return null;
        }
        g();
        synchronized (this.g) {
            for (z zVar : this.g) {
                if (zVar.gc > gVar.h()) {
                    return zVar;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        r7[1] = r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.g.a.z, java.lang.Integer> g(com.ss.android.g.z.g.g r18) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.g.a.g(com.ss.android.g.z.g.g):android.util.Pair");
    }

    private void g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.g) {
            Iterator<z> it = this.g.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().gc > 1800000) {
                it.remove();
            }
        }
    }

    private z dl(String str) {
        try {
            PackageManager packageManager = wp.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new z(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            return null;
        }
    }

    private static boolean z(String str, String str2) {
        String[] strArrSplit;
        String[] strArrSplit2;
        boolean z2;
        try {
            strArrSplit = str.split("\\.");
            strArrSplit2 = str2.split("\\.");
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
            int i = 0;
            int i2 = 0;
            for (String str3 : strArrSplit) {
                String[] strArr = dl;
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z2 = false;
                        break;
                    }
                    String str4 = strArr[i3];
                    if (str4.equals(str3)) {
                        if (i < strArrSplit2.length && str4.equals(strArrSplit2[i])) {
                            i++;
                        }
                        z2 = true;
                    } else {
                        i3++;
                    }
                }
                if (!z2) {
                    int i4 = i2;
                    int i5 = i;
                    while (i < strArrSplit2.length) {
                        if (str3.equals(strArrSplit2[i])) {
                            if (i == i5) {
                                i5++;
                            }
                            i4++;
                            if (i4 >= 2) {
                                return true;
                            }
                        }
                        i++;
                    }
                    i = i5;
                    i2 = i4;
                }
            }
            return false;
        }
        return false;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1984a;
        public final String dl;
        public final int g;
        public final long gc;
        public final String z;

        private z(String str, int i, String str2, String str3, long j) {
            this.z = str;
            this.g = i;
            this.dl = str2 != null ? str2.toLowerCase() : null;
            this.f1984a = str3 != null ? str3.toLowerCase() : null;
            this.gc = j;
        }
    }
}
