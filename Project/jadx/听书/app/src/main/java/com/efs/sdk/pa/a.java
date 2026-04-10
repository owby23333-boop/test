package com.efs.sdk.pa;

import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements PAANRListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PAFactory f1615a;
    private PATraceListener b;

    public a(PAFactory pAFactory) {
        this.f1615a = pAFactory;
        this.b = pAFactory.getTraceListener();
        boolean zEnableTracer = pAFactory.getConfigManager().enableTracer();
        if (zEnableTracer || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            c.a(this.f1615a, "patracepv", null);
        }
        PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onCheck(zEnableTracer);
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void anrStack(String str) {
        if (str == null || str.length() <= 200) {
            return;
        }
        c.a(this.f1615a, "patrace", str);
        PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onAnrTrace();
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void unexcept(Object obj) {
        PATraceListener pATraceListener = this.b;
        if (pATraceListener != null) {
            pATraceListener.onUnexcept(obj);
        }
    }
}
