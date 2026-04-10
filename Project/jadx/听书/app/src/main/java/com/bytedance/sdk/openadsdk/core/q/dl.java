package com.bytedance.sdk.openadsdk.core.q;

import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements com.bytedance.sdk.component.a.e, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            onExceptionEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2), (Throwable) sparseArray.get(3));
            return null;
        }
        if (iIntValue != 2) {
            return null;
        }
        onStatsEvent((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
        return null;
    }

    @Override // com.bytedance.sdk.component.a.e
    public void onExceptionEvent(String str, JSONObject jSONObject, Throwable th) {
        if (gc.z(str, 1.0d)) {
            v.z().z(str, jSONObject, th);
        }
    }

    @Override // com.bytedance.sdk.component.a.e
    public void onStatsEvent(String str, JSONObject jSONObject) {
        v.z().z(str, jSONObject);
    }
}
