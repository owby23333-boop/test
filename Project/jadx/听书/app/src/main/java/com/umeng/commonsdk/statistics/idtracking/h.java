package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.config.FieldManager;

/* JADX INFO: compiled from: OaidTracking.java */
/* JADX INFO: loaded from: classes4.dex */
public class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2345a = z.b().b(z.l);
    public static final String b = "key_umeng_sp_oaid";
    public static final String c = "key_umeng_sp_oaid_required_time";
    private static final String d = "oaid";
    private Context e;

    public h(Context context) {
        super(d);
        this.e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.e.getSharedPreferences(f2345a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
