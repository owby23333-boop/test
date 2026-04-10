package com.bytedance.sdk.openadsdk.core.live.z;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    void a();

    void a(na naVar);

    int b_(na naVar);

    long dl();

    String e();

    int g();

    int g(Context context, na naVar, Map<String, Object> map);

    int gc();

    JSONObject gz();

    boolean m();

    int z(Context context, na naVar, Map<String, Object> map);

    int z(na naVar, dl dlVar, String str);

    int z(com.bytedance.sdk.openadsdk.core.live.g.g gVar, boolean z);

    int z(String str);

    void z();

    void z(com.bytedance.sdk.openadsdk.pf.a aVar);

    void z(String str, na naVar, long j);

    void z(String str, boolean z);

    void z(Function<SparseArray<Object>, Object> function);

    boolean z(na naVar);

    boolean z(String str, int i);
}
