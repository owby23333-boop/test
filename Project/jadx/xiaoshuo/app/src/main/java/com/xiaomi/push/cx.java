package com.xiaomi.push;

import com.yuewen.xa3;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f214a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7868b;
    private long c;

    public cx() {
        this(0, 0L, 0L, null);
    }

    public int a() {
        return this.f7867a;
    }

    public cx(int i, long j, long j2, Exception exc) {
        this.f7867a = i;
        this.f214a = j;
        this.c = j2;
        this.f7868b = System.currentTimeMillis();
        if (exc != null) {
            this.f215a = exc.getClass().getSimpleName();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public JSONObject m273a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f214a);
        jSONObject.put("size", this.c);
        jSONObject.put(xa3.c, this.f7868b);
        jSONObject.put("wt", this.f7867a);
        jSONObject.put("expt", this.f215a);
        return jSONObject;
    }

    public cx a(JSONObject jSONObject) {
        this.f214a = jSONObject.getLong("cost");
        this.c = jSONObject.getLong("size");
        this.f7868b = jSONObject.getLong(xa3.c);
        this.f7867a = jSONObject.getInt("wt");
        this.f215a = jSONObject.optString("expt");
        return this;
    }
}
