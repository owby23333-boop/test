package com.bytedance.embedapplog;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected JSONObject f301a;
    protected String dl = "";
    protected final h g = new h();
    protected Context z;

    public abstract String dl();

    protected abstract String g();

    public tb(Context context, JSONObject jSONObject) {
        this.z = context;
        this.f301a = jSONObject;
    }

    public h z() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strG = g();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            this.g.g(strG);
            this.g.z(dl());
            this.g.z(jCurrentTimeMillis2 - jCurrentTimeMillis);
            this.g.dl(a());
            this.g.dl();
            if (this.f301a.has("index")) {
                this.g.z(this.f301a.optInt("index"));
            }
            return this.g;
        } catch (Exception e) {
            js.g("__kite" + dl() + " doLoad# error " + e.getMessage());
            return this.g;
        }
    }

    private String a() {
        return this.dl;
    }
}
