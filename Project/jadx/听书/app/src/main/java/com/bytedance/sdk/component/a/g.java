package com.bytedance.sdk.component.a;

import android.util.SparseArray;
import com.bytedance.sdk.component.a.z;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z.InterfaceC0115z, Function {
    z.InterfaceC0115z g;
    Function z;

    public g(z.InterfaceC0115z interfaceC0115z) {
        this.g = interfaceC0115z;
    }

    public g(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        if (((Integer) sparseArray.get(0)).intValue() != 1) {
            return null;
        }
        this.g.reportSensorData((JSONObject) sparseArray.get(1));
        return null;
    }

    @Override // com.bytedance.sdk.component.a.z.InterfaceC0115z
    public void reportSensorData(JSONObject jSONObject) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, jSONObject);
        this.z.apply(sparseArray);
    }
}
