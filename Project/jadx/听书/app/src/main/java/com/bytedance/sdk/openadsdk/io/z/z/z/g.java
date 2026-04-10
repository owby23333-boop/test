package com.bytedance.sdk.openadsdk.io.z.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Function<SparseArray<Object>, Object> {
    private final TTNativeAd.EasyPlayWidgetListener z;

    public g(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        this.z = easyPlayWidgetListener;
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
            case 144101:
                this.z.onInfo((JSONObject) valueSetG.objectValue(0, JSONObject.class));
                return null;
            case 144102:
                return this.z.getEstimatedInteractionArea();
            case 144103:
                this.z.onCanRenderSuccess((JSONObject) valueSetG.objectValue(0, JSONObject.class));
                return null;
            case 144104:
                this.z.onCanRenderFail((JSONObject) valueSetG.objectValue(0, JSONObject.class));
                return null;
            case 144105:
                this.z.onClose();
                return null;
            default:
                return null;
        }
    }
}
