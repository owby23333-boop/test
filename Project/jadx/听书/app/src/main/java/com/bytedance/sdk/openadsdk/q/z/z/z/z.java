package com.bytedance.sdk.openadsdk.q.z.z.z;

import android.util.SparseArray;
import com.bykv.z.z.z.z.dl;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final TTDrawFeedAd.DrawVideoListener z;

    public z(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.z = drawVideoListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        switch (dl.z(sparseArray).g().intValue(-99999987)) {
            case 171101:
                this.z.onClick();
                return null;
            case 171102:
                this.z.onClickRetry();
                return null;
            default:
                return null;
        }
    }
}
