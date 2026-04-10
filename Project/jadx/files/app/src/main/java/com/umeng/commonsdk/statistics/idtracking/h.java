package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.config.FieldManager;

/* JADX INFO: compiled from: OaidTracking.java */
/* JADX INFO: loaded from: classes3.dex */
public class h extends a {
    public static final String a = "umeng_sp_oaid";
    public static final String b = "key_umeng_sp_oaid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f20106c = "key_umeng_sp_oaid_required_time";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f20107d = "oaid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f20108e;

    public h(Context context) {
        super("oaid");
        this.f20108e = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = this.f20108e.getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getString(b, "");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
