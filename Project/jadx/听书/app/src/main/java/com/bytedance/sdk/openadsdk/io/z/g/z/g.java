package com.bytedance.sdk.openadsdk.io.z.g.z;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 144101);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.z.apply(sparseArray);
    }

    public JSONObject z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 144101);
        sparseArray.put(-99999985, JSONObject.class);
        return (JSONObject) this.z.apply(sparseArray);
    }

    public void g(JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 144103);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.z.apply(sparseArray);
    }

    public void dl(JSONObject jSONObject) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 144104);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(0, jSONObject);
        this.z.apply(sparseArray);
    }

    public void g() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 144105);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
