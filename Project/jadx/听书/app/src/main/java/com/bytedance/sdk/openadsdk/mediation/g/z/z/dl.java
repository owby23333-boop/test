package com.bytedance.sdk.openadsdk.mediation.g.z.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements IMediationNativeTokenInfo {
    private final Function<SparseArray<Object>, Object> z;

    public dl(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.dl.dl : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(0, str);
        sparseArray.put(1, new com.bytedance.sdk.openadsdk.tb.z.z.z.g(feedAdListener));
        sparseArray.put(-99999987, 270028);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
