package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.m;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.g;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediationNativeManagerDefault extends gc {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public boolean isExpress() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public void setShakeViewListener(m mVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc
    public void setUseCustomVideo(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public List<g> getAdLoadInfo() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public List<z> getMultiBiddingEcpm() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public z getBestEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public List<z> getCacheList() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public z getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }
}
