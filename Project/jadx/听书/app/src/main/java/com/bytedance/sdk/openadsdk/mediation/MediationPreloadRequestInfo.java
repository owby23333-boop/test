package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {
    private List<String> dl;
    private AdSlot g;
    private int z;

    public MediationPreloadRequestInfo(int i, AdSlot adSlot, List<String> list) {
        this.z = i;
        this.g = adSlot;
        this.dl = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.dl;
    }
}
