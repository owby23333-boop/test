package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.e;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.g;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediationSplashManagerDefault extends e {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.e
    public void destroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public boolean isReady() {
        return true;
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
    public MediationAdEcpmInfoDefault getBestEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public List<z> getCacheList() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public MediationAdEcpmInfoDefault getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }
}
