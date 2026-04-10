package com.bytedance.sdk.openadsdk.mediation.g.z.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements IMediationDrawTokenInfo {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.dl.dl : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo
    public void loadDrawAdByAdm(String str, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 270031);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, str);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.tb.z.z.z.z(drawFeedAdListener));
        this.z.apply(sparseArray);
    }
}
