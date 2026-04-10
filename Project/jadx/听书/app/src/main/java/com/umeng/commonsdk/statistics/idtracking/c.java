package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: IDFATracker.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2339a = "idfa";
    private Context b;

    public c(Context context) {
        super(f2339a);
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.b);
    }
}
