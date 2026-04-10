package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: loaded from: classes8.dex */
class bb implements aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7814a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f7815b = f7814a + "OAID";
    private static String c = f7814a + "VAID_";
    private static String d = f7814a + "AAID_";
    private static String e = f7814a + com.alipay.sdk.m.u0.b.h;
    private static String f = com.alipay.sdk.m.u0.c.c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f165a;

    public bb(Context context) {
        this.f165a = context;
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public boolean mo195a() {
        return "1".equals(q.a(f, "0"));
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public String mo194a() {
        return a(f7815b);
    }

    private String a(String str) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        String string = null;
        try {
            cursorQuery = this.f165a.getContentResolver().query(Uri.parse(str), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                    }
                    return string;
                } catch (Throwable th2) {
                    th = th2;
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string;
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f7814a).getAuthority(), 128);
            if (providerInfoResolveContentProvider != null) {
                if ((providerInfoResolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
