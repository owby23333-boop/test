package com.bytedance.sdk.openadsdk.mediation.init.z.z.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static final SparseArray<Object> z(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        com.bykv.z.z.z.z.dl dlVarZ = com.bykv.z.z.z.z.dl.z();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        dlVarZ.z(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        dlVarZ.z(265001, mediationConfigUserInfoForSegment.getUserId());
        dlVarZ.z(265002, mediationConfigUserInfoForSegment.getChannel());
        dlVarZ.z(265003, mediationConfigUserInfoForSegment.getSubChannel());
        dlVarZ.z(265004, mediationConfigUserInfoForSegment.getAge());
        dlVarZ.z(265005, mediationConfigUserInfoForSegment.getGender());
        dlVarZ.z(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return dlVarZ.g().sparseArray();
    }
}
