package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.hh;
import com.bytedance.sdk.openadsdk.core.iq.j;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface sy<T> {

    public interface a {
        void z(int i, String str);

        void z(hh.dl dlVar);
    }

    public interface dl<T> {
        void z(int i, String str);

        void z(T t);
    }

    public interface g {
        void z(int i, String str, com.bytedance.sdk.openadsdk.core.iq.g gVar);

        void z(com.bytedance.sdk.openadsdk.core.iq.z zVar, com.bytedance.sdk.openadsdk.core.iq.g gVar);
    }

    public interface gc {
        void z(int i, String str);

        void z(hh.a aVar);
    }

    public interface z {
        void z(boolean z, long j, long j2);
    }

    void dl(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, int i, g gVar2);

    void g(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, int i, g gVar2);

    com.bytedance.sdk.component.adexpress.z.dl.z z(int i);

    com.bytedance.sdk.openadsdk.core.iq.a z(na naVar, String str);

    String z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar);

    String z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, boolean z2, int i);

    void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar, List<com.bytedance.sdk.openadsdk.ls.dl.g.m> list);

    void z(ja jaVar, String str, String str2, dl dlVar, int i, long j);

    void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, j jVar, int i, g gVar2);

    void z(String str);

    void z(String str, String str2, z zVar);

    void z(Map<String, Object> map, Function<SparseArray<Object>, Object> function);

    void z(Function<SparseArray<Object>, Object> function);

    void z(JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.gc.g.g gVar);

    void z(JSONObject jSONObject, a aVar);

    void z(JSONObject jSONObject, dl<com.bytedance.sdk.component.fo.g> dlVar);

    void z(JSONObject jSONObject, gc gcVar);
}
