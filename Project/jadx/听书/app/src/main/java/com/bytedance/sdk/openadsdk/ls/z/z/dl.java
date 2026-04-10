package com.bytedance.sdk.openadsdk.ls.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements ComplianceInfo {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public dl(Function<SparseArray<Object>, Object> function) {
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

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppName() {
        return this.g.stringValue(250001);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getAppVersion() {
        return this.g.stringValue(250002);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getDeveloperName() {
        return this.g.stringValue(250003);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPrivacyUrl() {
        return this.g.stringValue(250004);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public Map<String, String> getPermissionsMap() {
        return (Map) this.g.objectValue(250006, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getPermissionUrl() {
        return this.g.stringValue(250005);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getFunctionDescUrl() {
        return this.g.stringValue(250007);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getRegUrl() {
        return this.g.stringValue(250009);
    }

    @Override // com.bytedance.sdk.openadsdk.ComplianceInfo
    public String getRegNumber() {
        return this.g.stringValue(250008);
    }
}
