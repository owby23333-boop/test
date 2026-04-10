package com.yuewen;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class wr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19591b;
    public final String c;

    public wr(JSONObject jSONObject) {
        this.f19590a = jSONObject.optString("banner");
        this.f19591b = jSONObject.optString("id");
        this.c = jSONObject.optString("desc");
    }

    public static wr a(JSONObject jSONObject) {
        return new wr(jSONObject);
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.f19590a) || (TextUtils.isEmpty(this.f19591b) && TextUtils.isEmpty(this.c))) ? false : true;
    }
}
