package com.bytedance.sdk.openadsdk.mediation.manager.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements MediationAdLoadInfo {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getMediationRit() {
        return this.g.stringValue(271001);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdnName() {
        return this.g.stringValue(271002);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdType() {
        return this.g.stringValue(271003);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public int getErrCode() {
        return this.g.intValue(271004);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getErrMsg() {
        return this.g.stringValue(271005);
    }
}
