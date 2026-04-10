package com.umeng.analytics;

import android.content.Context;
import com.umeng.analytics.pro.o;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMSenderStateNotify;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class CoreProtocol implements UMLogDataProtocol, UMSenderStateNotify {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f2147a;

    private CoreProtocol() {
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final CoreProtocol f2148a = new CoreProtocol();

        private a() {
        }
    }

    public static CoreProtocol getInstance(Context context) {
        if (f2147a == null && context != null) {
            f2147a = context.getApplicationContext();
        }
        return a.f2148a;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i) {
        o.a(f2147a).a(obj, i);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
        o.a(f2147a).a(obj);
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j) {
        return o.a(f2147a).a(j);
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onConnectionAvailable() {
        o.a(f2147a).a();
    }

    @Override // com.umeng.commonsdk.framework.UMSenderStateNotify
    public void onSenderIdle() {
        o.a(f2147a).b();
    }
}
