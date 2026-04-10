package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.v2.GMMediationAdSdk;
import com.bytedance.msdk.api.v2.GMSettingConfigCallback;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final GMSettingConfigCallback a = new a();

    static final class a implements GMSettingConfigCallback {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.GMSettingConfigCallback
        public void configLoad() {
            try {
                b.d();
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    private static int a(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    str = str.substring(1);
                }
                if (str2.startsWith("v") || str2.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                    str2 = str2.substring(1);
                }
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = str2.split("\\.");
                int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
                int i2 = 0;
                while (true) {
                    if (i2 < iMin) {
                        if (strArrSplit[i2].length() == strArrSplit2[i2].length()) {
                            int iCompareTo = strArrSplit[i2].compareTo(strArrSplit2[i2]);
                            if (iCompareTo != 0) {
                                return iCompareTo;
                            }
                            i2++;
                        } else if (strArrSplit[i2].length() <= strArrSplit2[i2].length()) {
                            return -1;
                        }
                    } else if (strArrSplit.length != strArrSplit2.length) {
                        if (strArrSplit.length <= strArrSplit2.length) {
                            return -1;
                        }
                    }
                }
            }
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.b.b(java.lang.String, java.lang.String):boolean");
    }

    public static void c() {
        try {
            if (Logger.isDebug() && GMMediationAdSdk.configLoadSuccess()) {
                d();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean c(java.lang.String r5, java.lang.String r6) {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.b.c(java.lang.String, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d() {
        synchronized (b.class) {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() != null) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().d();
            }
        }
    }
}
