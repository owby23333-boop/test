package com.bytedance.sdk.openadsdk.uf.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Function<SparseArray<Object>, Object> {
    private final TTNativeExpressAd.ExpressVideoAdListener g;
    private final ValueSet z = com.bykv.z.z.z.z.dl.z;

    public dl(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.g = expressVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.g == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        switch (valueSetG.intValue(-99999987)) {
            case 152101:
                this.g.onVideoLoad();
                return null;
            case 152102:
                this.g.onVideoError(valueSetG.intValue(0), valueSetG.intValue(1));
                return null;
            case 152103:
                this.g.onVideoAdStartPlay();
                return null;
            case 152104:
                this.g.onVideoAdPaused();
                return null;
            case 152105:
                this.g.onVideoAdContinuePlay();
                return null;
            case 152106:
                this.g.onProgressUpdate(valueSetG.longValue(0), valueSetG.longValue(1));
                return null;
            case 152107:
                this.g.onVideoAdComplete();
                return null;
            case 152108:
                this.g.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
