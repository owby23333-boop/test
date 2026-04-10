package com.bytedance.sdk.openadsdk.zw.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener g;
    private ValueSet z = dl.z;

    public z(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.g = fullScreenVideoAdInteractionListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.g == null) {
            return null;
        }
        switch (dl.z(sparseArray).g().intValue(-99999987)) {
            case 131101:
                this.g.onAdShow();
                return null;
            case 131102:
                this.g.onAdVideoBarClick();
                return null;
            case 131103:
                this.g.onAdClose();
                return null;
            case 131104:
                this.g.onVideoComplete();
                return null;
            case 131105:
                this.g.onSkippedVideo();
                return null;
            default:
                return null;
        }
    }
}
