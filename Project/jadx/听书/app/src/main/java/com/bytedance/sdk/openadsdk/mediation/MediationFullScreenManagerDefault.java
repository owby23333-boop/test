package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.a;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.g;
import com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.z;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediationFullScreenManagerDefault extends a {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.a
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
