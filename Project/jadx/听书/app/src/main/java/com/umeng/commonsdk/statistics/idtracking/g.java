package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: MacTracker.java */
/* JADX INFO: loaded from: classes4.dex */
public class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2344a = "mac";
    private Context b;

    public g(Context context) {
        super(f2344a);
        this.b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfig.getMac(this.b);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                e.printStackTrace();
            }
            UMCrashManager.reportCrash(this.b, e);
            return null;
        }
    }
}
