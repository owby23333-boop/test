package com.bytedance.sdk.openadsdk.m.dl;

import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.m.dl.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g<T extends a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private T f1444a;
    private JSONObject dl;
    private String g;
    private boolean gc = false;
    private na z;

    public g(na naVar, String str, JSONObject jSONObject, T t) {
        this.z = naVar;
        this.g = str;
        this.dl = jSONObject;
        this.f1444a = t;
    }

    public na z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public JSONObject dl() {
        if (this.dl == null) {
            this.dl = new JSONObject();
        }
        return this.dl;
    }

    public T a() {
        return this.f1444a;
    }

    public boolean gc() {
        return this.gc;
    }

    public void z(boolean z) {
        this.gc = z;
    }
}
