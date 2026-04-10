package com.ss.android.downloadlib.addownload.model;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.expressad.foundation.g.a;
import com.ss.android.downloadlib.addownload.x;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    private static final String[] b = {"com", DispatchConstants.ANDROID, a.ac};
    private static final int[] hj = {3101, 3102, 3103, 3201, 3202, 3203};
    private static volatile hj mb;
    private final LinkedList<mb> ox = new LinkedList<>();

    public static class mb {
        public final String b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f18008h;
        public final String hj;
        public final String mb;
        public final int ox;

        private mb(String str, int i2, String str2, String str3, long j2) {
            this.mb = str;
            this.ox = i2;
            this.b = str2 != null ? str2.toLowerCase() : null;
            this.hj = str3 != null ? str3.toLowerCase() : null;
            this.f18008h = j2;
        }
    }

    private hj() {
    }

    private mb b(String str) {
        try {
            PackageManager packageManager = x.getContext().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return new mb(str, packageInfo.versionCode, packageInfo.versionName, (String) packageManager.getApplicationLabel(packageInfo.applicationInfo), System.currentTimeMillis());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static hj mb() {
        if (mb == null) {
            synchronized (hj.class) {
                if (mb == null) {
                    mb = new hj();
                }
            }
        }
        return mb;
    }

    public void ox(String str) {
        ox();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.ox) {
            Iterator<mb> it = this.ox.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().mb)) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void mb(String str) {
        mb mbVarB;
        ox();
        if (TextUtils.isEmpty(str) || (mbVarB = b(str)) == null) {
            return;
        }
        synchronized (this.ox) {
            this.ox.add(mbVarB);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0098, code lost:
    
        r6[1] = r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.ss.android.downloadlib.addownload.model.hj.mb, java.lang.Integer> ox(com.ss.android.downloadad.api.mb.ox r18) {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.model.hj.ox(com.ss.android.downloadad.api.mb.ox):android.util.Pair");
    }

    public mb mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return null;
        }
        ox();
        synchronized (this.ox) {
            for (mb mbVar : this.ox) {
                if (mbVar.f18008h > oxVar.xa()) {
                    return mbVar;
                }
            }
            return null;
        }
    }

    private static boolean mb(String str, String str2) {
        String[] strArrSplit;
        String[] strArrSplit2;
        int i2;
        boolean z2;
        try {
            strArrSplit = str.split("\\.");
            strArrSplit2 = str2.split("\\.");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (strArrSplit.length != 0 && strArrSplit2.length != 0) {
            int i3 = 0;
            int i4 = 0;
            for (String str3 : strArrSplit) {
                String[] strArr = b;
                int length = strArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        i2 = i3;
                        z2 = false;
                        break;
                    }
                    String str4 = strArr[i5];
                    if (str4.equals(str3)) {
                        if (i3 < strArrSplit2.length && str4.equals(strArrSplit2[i3])) {
                            i3++;
                        }
                        i2 = i3;
                        z2 = true;
                    } else {
                        i5++;
                    }
                }
                if (z2) {
                    i3 = i2;
                } else {
                    i3 = i2;
                    while (i2 < strArrSplit2.length) {
                        if (str3.equals(strArrSplit2[i2])) {
                            if (i2 == i3) {
                                i3++;
                            }
                            i4++;
                            if (i4 >= 2) {
                                return true;
                            }
                        }
                        i2++;
                    }
                }
            }
            return false;
        }
        return false;
    }

    private void ox() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.ox) {
            Iterator<mb> it = this.ox.iterator();
            while (it.hasNext() && jCurrentTimeMillis - it.next().f18008h > 1800000) {
                it.remove();
            }
        }
    }
}
