package com.bytedance.sdk.openadsdk.ls.z.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Function<SparseArray<Object>, Object> {
    private final TTAppDownloadListener z;

    public dl(TTAppDownloadListener tTAppDownloadListener) {
        this.z = tTAppDownloadListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z == null) {
            return null;
        }
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z(sparseArray).g();
        switch (valueSetG.intValue(-99999987)) {
            case 221101:
                this.z.onIdle();
                return null;
            case 221102:
                this.z.onDownloadActive(valueSetG.longValue(0), valueSetG.longValue(1), valueSetG.stringValue(2), valueSetG.stringValue(3));
                return null;
            case 221103:
                this.z.onDownloadPaused(valueSetG.longValue(0), valueSetG.longValue(1), valueSetG.stringValue(2), valueSetG.stringValue(3));
                return null;
            case 221104:
                this.z.onDownloadFailed(valueSetG.longValue(0), valueSetG.longValue(1), valueSetG.stringValue(2), valueSetG.stringValue(3));
                return null;
            case 221105:
                this.z.onDownloadFinished(valueSetG.longValue(0), valueSetG.stringValue(1), valueSetG.stringValue(2));
                return null;
            case 221106:
                this.z.onInstalled(valueSetG.stringValue(0), valueSetG.stringValue(1));
                return null;
            default:
                return null;
        }
    }
}
