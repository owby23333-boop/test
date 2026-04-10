package com.volcengine.mobsecBiz.metasec.ml;

import java.util.Map;
import ms.bz.bd.c.Pgl.m0;
import ms.bz.bd.c.Pgl.n0;

/* JADX INFO: loaded from: classes4.dex */
public final class PglMSManager implements n0.pgla {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n0.pgla f2485a;

    PglMSManager(m0 m0Var) {
        this.f2485a = m0Var;
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public Map<String, String> getFeatureHash(String str, byte[] bArr) {
        return this.f2485a.getFeatureHash(str, bArr);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public String getToken() {
        return this.f2485a.getToken();
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public void report(String str) {
        this.f2485a.report(str);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public void setBDDeviceID(String str) {
        this.f2485a.setBDDeviceID(str);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public void setCollectMode(int i) {
        this.f2485a.setCollectMode(i);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public void setDeviceID(String str) {
        this.f2485a.setDeviceID(str);
    }

    @Override // ms.bz.bd.c.Pgl.n0.pgla
    public void setInstallID(String str) {
        this.f2485a.setInstallID(str);
    }
}
