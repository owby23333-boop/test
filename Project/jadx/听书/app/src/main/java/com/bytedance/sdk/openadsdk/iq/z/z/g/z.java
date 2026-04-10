package com.bytedance.sdk.openadsdk.iq.z.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.ls.z.z.fo;
import com.bytedance.sdk.openadsdk.ls.z.z.pf;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final TTFeedAd.VideoAdListener g;
    private ValueSet z = dl.z;

    public z(TTFeedAd.VideoAdListener videoAdListener) {
        this.g = videoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.g == null) {
            return null;
        }
        ValueSet valueSetG = dl.z(sparseArray).g();
        switch (valueSetG.intValue(-99999987)) {
            case 161101:
                this.g.onVideoLoad(new fo(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            case 161102:
                this.g.onVideoError(valueSetG.intValue(0), valueSetG.intValue(1));
                return null;
            case 161103:
                this.g.onVideoAdPaused(new fo(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            case 161104:
                this.g.onVideoAdStartPlay(new fo(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            case 161105:
                this.g.onVideoAdContinuePlay(new fo(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            case 161106:
                this.g.onProgressUpdate(valueSetG.longValue(0), valueSetG.longValue(1));
                return null;
            case 161107:
                this.g.onVideoAdComplete(new fo(pf.z(valueSetG.objectValue(0, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
