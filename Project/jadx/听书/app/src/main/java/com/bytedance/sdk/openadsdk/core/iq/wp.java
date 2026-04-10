package com.bytedance.sdk.openadsdk.core.iq;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends com.bytedance.sdk.openadsdk.ls.dl.g.dl {
    private m z;

    public wp(na naVar) {
        if (naVar == null) {
            return;
        }
        this.z = naVar.bw();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.dl
    public String z() {
        m mVar = this.z;
        return mVar == null ? "" : mVar.v();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.dl
    public String g() {
        m mVar = this.z;
        return mVar == null ? "" : mVar.gc();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.dl
    public String dl() {
        m mVar = this.z;
        return mVar == null ? "" : mVar.e();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.dl
    public String a() {
        m mVar = this.z;
        return mVar == null ? "" : mVar.gz();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.dl
    public Map<String, String> gc() {
        m mVar = this.z;
        if (mVar == null) {
            return null;
        }
        return mVar.z();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.dl
    public String m() {
        m mVar = this.z;
        if (mVar == null) {
            return null;
        }
        return mVar.g();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.dl
    public String e() {
        m mVar = this.z;
        if (mVar == null) {
            return null;
        }
        return mVar.fo();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.dl
    public String fo() {
        m mVar = this.z;
        if (mVar == null) {
            return null;
        }
        return mVar.uy();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.dl
    public String gz() {
        m mVar = this.z;
        if (mVar == null) {
            return null;
        }
        return mVar.kb();
    }
}
