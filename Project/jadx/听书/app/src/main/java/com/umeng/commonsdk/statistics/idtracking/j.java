package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;

/* JADX INFO: compiled from: UTDIdTracker.java */
/* JADX INFO: loaded from: classes4.dex */
public class j extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2347a = "utdid";
    private Context b;

    public j(Context context) {
        super(f2347a);
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.u)) {
                String strH = h();
                return TextUtils.isEmpty(strH) ? g() : strH;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private String g() {
        try {
            return this.b.getSharedPreferences("Alvin2", 0).getString("UTDID2", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private String h() {
        try {
            return this.b.getSharedPreferences("um_push_ut", 0).getString("d_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }
}
