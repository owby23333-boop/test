package com.bytedance.sdk.openadsdk.tb.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ls.z.z.fo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final TTAdNative.FeedAdListener z;

    public g(TTAdNative.FeedAdListener feedAdListener) {
        this.z = feedAdListener;
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
            case 164101:
                this.z.onError(valueSetG.intValue(0), valueSetG.stringValue(1));
                return null;
            case 164102:
                List arrayList = (List) valueSetG.objectValue(0, List.class);
                if (arrayList == null) {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new fo((Function) it.next()));
                }
                this.z.onFeedAdLoad(arrayList2);
                return null;
            default:
                return null;
        }
    }
}
