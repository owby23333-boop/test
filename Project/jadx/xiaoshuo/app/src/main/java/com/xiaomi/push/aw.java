package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class aw implements aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile aw f7806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f154a = av.f7805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private aq f155a;

    private aw(Context context) {
        this.f155a = av.a(context);
        com.xiaomi.channel.commonutils.logger.b.m106a("create id manager is: " + this.f154a);
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    public void a() {
    }

    public static aw a(Context context) {
        if (f7806a == null) {
            synchronized (aw.class) {
                if (f7806a == null) {
                    f7806a = new aw(context.getApplicationContext());
                }
            }
        }
        return f7806a;
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public boolean mo195a() {
        return this.f155a.mo195a();
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public String mo194a() {
        return a(this.f155a.mo194a());
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String strB = b();
        if (!TextUtils.isEmpty(strB)) {
            map.put("udid", strB);
        }
        String strMo194a = mo194a();
        if (!TextUtils.isEmpty(strMo194a)) {
            map.put("oaid", strMo194a);
        }
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            map.put("vaid", strC);
        }
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            map.put("aaid", strD);
        }
        map.put("oaid_type", String.valueOf(this.f154a));
    }
}
