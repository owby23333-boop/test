package com.bytedance.sdk.gromore.z.z.a;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z {
    private com.bytedance.sdk.gromore.z.z.g z;

    public e(com.bytedance.sdk.gromore.z.z.g gVar) {
        this.z = gVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public Map<String, String> getCustomData() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        if (gVar != null) {
            return gVar.z();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getSdkName() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.g() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getCustomSdkName() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.dl() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getSlotId() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.a() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getLevelTag() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.gc() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getEcpm() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.m() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public int getReqBiddingType() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        if (gVar != null) {
            return gVar.e();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getErrorMsg() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.gz() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getRequestId() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.fo() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getRitType() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.uy() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getSegmentId() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.wp() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getChannel() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.i() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getSubChannel() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.v() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getAbTestId() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.pf() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getScenarioId() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.ls() : "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z
    public String getSubRitType() {
        com.bytedance.sdk.gromore.z.z.g gVar = this.z;
        return gVar != null ? gVar.kb() : "";
    }
}
