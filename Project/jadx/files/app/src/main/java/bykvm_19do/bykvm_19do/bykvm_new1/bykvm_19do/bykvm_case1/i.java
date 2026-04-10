package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b;
import com.taobao.accs.utl.UtilityImpl;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[b.EnumC0061b.values().length];

        static {
            try {
                a[b.EnumC0061b.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.EnumC0061b.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.EnumC0061b.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.EnumC0061b.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.EnumC0061b.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String a(Context context) {
        return a(b(context));
    }

    public static String a(b.EnumC0061b enumC0061b) {
        int i2;
        try {
            i2 = a.a[enumC0061b.ordinal()];
        } catch (Exception unused) {
        }
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "" : "mobile" : UtilityImpl.NET_TYPE_4G : UtilityImpl.NET_TYPE_3G : UtilityImpl.NET_TYPE_2G : UtilityImpl.NET_TYPE_WIFI;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0035 A[Catch: all -> 0x003e, TryCatch #0 {all -> 0x003e, blocks: (B:2:0x0000, B:4:0x000a, B:5:0x000d, B:7:0x0013, B:10:0x001a, B:12:0x0021, B:14:0x0026, B:15:0x0032, B:17:0x0038, B:18:0x003b, B:16:0x0035), top: B:23:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.EnumC0061b b(android.content.Context r2) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r2.getSystemService(r0)     // Catch: java.lang.Throwable -> L3e
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch: java.lang.Throwable -> L3e
            if (r0 != 0) goto Ld
        La:
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b$b r2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.EnumC0061b.NONE     // Catch: java.lang.Throwable -> L3e
            goto L40
        Ld:
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L3e
            if (r0 == 0) goto La
            boolean r1 = r0.isAvailable()     // Catch: java.lang.Throwable -> L3e
            if (r1 != 0) goto L1a
            goto La
        L1a:
            int r0 = r0.getType()     // Catch: java.lang.Throwable -> L3e
            r1 = 1
            if (r1 != r0) goto L24
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b$b r2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.EnumC0061b.WIFI     // Catch: java.lang.Throwable -> L3e
            goto L40
        L24:
            if (r0 != 0) goto L35
            java.lang.String r0 = "phone"
            java.lang.Object r2 = r2.getSystemService(r0)     // Catch: java.lang.Throwable -> L3e
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2     // Catch: java.lang.Throwable -> L3e
            int r2 = r2.getNetworkType()     // Catch: java.lang.Throwable -> L3e
            switch(r2) {
                case 3: goto L3b;
                case 4: goto L35;
                case 5: goto L3b;
                case 6: goto L3b;
                case 7: goto L35;
                case 8: goto L3b;
                case 9: goto L3b;
                case 10: goto L3b;
                case 11: goto L35;
                case 12: goto L3b;
                case 13: goto L38;
                case 14: goto L3b;
                case 15: goto L3b;
                default: goto L35;
            }     // Catch: java.lang.Throwable -> L3e
        L35:
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b$b r2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.EnumC0061b.MOBILE     // Catch: java.lang.Throwable -> L3e
            goto L40
        L38:
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b$b r2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.EnumC0061b.MOBILE_4G     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3b:
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b$b r2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.EnumC0061b.MOBILE_3G     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3e:
            bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b$b r2 = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.EnumC0061b.MOBILE
        L40:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.i.b(android.content.Context):bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b$b");
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception unused) {
            return false;
        }
    }
}
