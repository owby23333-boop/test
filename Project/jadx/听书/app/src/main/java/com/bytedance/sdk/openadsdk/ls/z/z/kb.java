package com.bytedance.sdk.openadsdk.ls.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTImage;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends TTImage {
    private ValueSet g;
    private final Function<SparseArray<Object>, Object> z;

    public kb(Function<SparseArray<Object>, Object> function) {
        this.g = com.bykv.z.z.z.z.dl.z;
        function = function == null ? com.bykv.z.z.z.z.dl.dl : function;
        this.z = function;
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, -99999986);
        sparseArray.put(-99999985, SparseArray.class);
        Object objApply = function.apply(sparseArray);
        if (objApply instanceof SparseArray) {
            this.g = com.bykv.z.z.z.z.dl.z((SparseArray<Object>) objApply).g();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getHeight() {
        return this.g.intValue(230002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public int getWidth() {
        return this.g.intValue(230001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public String getImageUrl() {
        return this.g.stringValue(230003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public double getDuration() {
        return this.g.doubleValue(230004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTImage
    public boolean isValid() {
        return this.g.booleanValue(230005);
    }
}
