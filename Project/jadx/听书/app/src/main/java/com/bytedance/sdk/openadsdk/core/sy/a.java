package com.bytedance.sdk.openadsdk.core.sy;

import android.content.Context;
import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements dl {
    Function z;

    public a(Function function) {
        this.z = function;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public void init(Context context, Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, function);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public boolean isPitayaEnvAvailable() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public boolean isPitayaInitSuccess() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public void queryPackage(String str, Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, function);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.dl
    public void runTask(String str, JSONObject jSONObject, Function function) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        sparseArray.put(3, function);
        this.z.apply(sparseArray);
    }
}
