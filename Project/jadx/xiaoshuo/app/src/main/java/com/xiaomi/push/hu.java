package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.passport.sim.SIMInfo;
import com.yuewen.openapi.track.TrackConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import miuix.android.content.SystemIntent;

/* JADX INFO: loaded from: classes8.dex */
public class hu {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static aj f512a = new aj(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f8055a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static long f511a = System.currentTimeMillis();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Object f514a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static List<a> f516a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f515a = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static com.xiaomi.push.providers.a f513a = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8056a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f517a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8057b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f519b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f520b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f518a = str;
            this.f517a = j;
            this.f8056a = i;
            this.f8057b = i2;
            this.f520b = str2;
            this.f519b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f518a, this.f518a) && TextUtils.equals(aVar.f520b, this.f520b) && aVar.f8056a == this.f8056a && aVar.f8057b == this.f8057b && Math.abs(aVar.f517a - this.f517a) <= 5000;
        }
    }

    private static int b(Context context) {
        bi biVarM216a = bf.m216a();
        if (biVarM216a == null) {
            return -1;
        }
        return biVarM216a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f884a) {
                SQLiteDatabase writableDatabase = m509a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f518a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f517a));
                        contentValues.put(TrackConstants.NETWORK_TYPE, Integer.valueOf(aVar.f8056a));
                        contentValues.put("bytes", Long.valueOf(aVar.f519b));
                        contentValues.put("rcv", Integer.valueOf(aVar.f8057b));
                        contentValues.put(SIMInfo.SIM_INFO_TYPE_IMSI, aVar.f520b);
                        writableDatabase.insert("traffic", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m512a(Context context) {
        f8055a = b(context);
    }

    public static int a(Context context) {
        if (f8055a == -1) {
            f8055a = b(context);
        }
        return f8055a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static synchronized String m510a(Context context) {
        if (TextUtils.isEmpty(f515a)) {
            return "";
        }
        return f515a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized void m513a(String str) {
        if (!j.m617d() && !TextUtils.isEmpty(str)) {
            f515a = str;
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int iA;
        boolean zIsEmpty;
        if (context == null || TextUtils.isEmpty(str) || !SystemIntent.ACTIVATE_SERVICE_HOST_PACKAGE.equals(context.getPackageName()) || SystemIntent.ACTIVATE_SERVICE_HOST_PACKAGE.equals(str) || -1 == (iA = a(context))) {
            return;
        }
        synchronized (f514a) {
            zIsEmpty = f516a.isEmpty();
            a(new a(str, j2, iA, z ? 1 : 0, iA == 0 ? m510a(context) : "", j));
        }
        if (zIsEmpty) {
            f512a.a(new hv(context), 5000L);
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f511a;
            f511a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * ((long) (i == 0 ? 13 : 11))) / 10;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m509a(Context context) {
        com.xiaomi.push.providers.a aVar = f513a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f513a = aVar2;
        return aVar2;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static void a(a aVar) {
        for (a aVar2 : f516a) {
            if (aVar2.a(aVar)) {
                aVar2.f519b += aVar.f519b;
                return;
            }
        }
        f516a.add(aVar);
    }
}
