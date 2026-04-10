package com.bytedance.sdk.openadsdk.mediation.g.z;

import android.util.SparseArray;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements IMediationDislikeCallback {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? dl.dl : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 268013);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 268014);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 268015);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
