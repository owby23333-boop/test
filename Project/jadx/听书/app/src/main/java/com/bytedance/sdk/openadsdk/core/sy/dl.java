package com.bytedance.sdk.openadsdk.core.sy;

import android.content.Context;
import android.util.SparseArray;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface dl {
    void init(Context context, Function<SparseArray<Object>, Object> function);

    boolean isPitayaEnvAvailable();

    boolean isPitayaInitSuccess();

    void queryPackage(String str, Function<SparseArray<Object>, Object> function);

    void runTask(String str, JSONObject jSONObject, Function<SparseArray<Object>, Object> function);
}
