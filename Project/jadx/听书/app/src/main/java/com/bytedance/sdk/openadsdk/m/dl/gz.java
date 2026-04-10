package com.bytedance.sdk.openadsdk.m.dl;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f1446a;
    private int dl;
    private long g;
    private long z;

    public void z(int i) {
        this.dl = i;
    }

    public void z(long j) {
        this.z = j;
    }

    public void g(long j) {
        this.g = j;
    }

    public void z(Map<String, Object> map) {
        this.f1446a = map;
    }

    @Override // com.bytedance.sdk.openadsdk.m.dl.a
    public void a_(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Map<String, Object> map = this.f1446a;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue());
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
        }
        try {
            jSONObject.put("buffers_time", this.z);
            jSONObject.put("total_duration", this.g);
            jSONObject.put("vbtt_skip_type", this.dl);
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.wp.z(th2);
        }
    }
}
