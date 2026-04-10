package com.kwad.sdk.i;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class i implements b {
    public String aSX;
    public String aSY;
    public String aSZ;
    public long aTa = System.currentTimeMillis();
    public double avY;

    public static i Nm() {
        return new i();
    }

    public final i gj(String str) {
        this.aSX = str;
        return this;
    }

    public final i gk(String str) {
        this.aSY = str;
        return this;
    }

    public final i gl(String str) {
        this.aSZ = str;
        return this;
    }

    public final i n(double d) {
        this.avY = d;
        return this;
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        c.a(jSONObject, "ratio", Double.valueOf(this.avY));
        c.a(jSONObject, "ratio_count", Double.valueOf(j.o(this.avY)));
        c.putValue(jSONObject, "log_build_time_ms", this.aTa);
        c.putValue(jSONObject, "log_level", this.aSX);
        c.putValue(jSONObject, "log_tag", this.aSY);
        c.putValue(jSONObject, "log_content", this.aSZ);
        return jSONObject;
    }
}
