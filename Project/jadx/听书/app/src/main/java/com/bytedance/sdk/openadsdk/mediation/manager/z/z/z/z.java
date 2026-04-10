package com.bytedance.sdk.openadsdk.mediation.manager.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends MediationAdEcpmInfo {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.g = com.bykv.z.z.z.z.dl.z;
        function = function == null ? com.bykv.z.z.z.z.dl.dl : function;
        this.z = function;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            this.g = com.bykv.z.z.z.z.dl.z((SparseArray<Object>) objApply).g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public Map<String, String> getCustomData() {
        return (Map) this.g.objectValue(271006, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSdkName() {
        return this.g.stringValue(271007);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getCustomSdkName() {
        return this.g.stringValue(271008);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSlotId() {
        return this.g.stringValue(271009);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getLevelTag() {
        return this.g.stringValue(271010);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getEcpm() {
        return this.g.stringValue(271011);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public int getReqBiddingType() {
        return this.g.intValue(271012);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getErrorMsg() {
        return this.g.stringValue(271013);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getRequestId() {
        return this.g.stringValue(271014);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getRitType() {
        return this.g.stringValue(271015);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSegmentId() {
        return this.g.stringValue(271016);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getChannel() {
        return this.g.stringValue(271017);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSubChannel() {
        return this.g.stringValue(271018);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getAbTestId() {
        return this.g.stringValue(271019);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getScenarioId() {
        return this.g.stringValue(271020);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo
    public String getSubRitType() {
        return this.g.stringValue(271051);
    }
}
