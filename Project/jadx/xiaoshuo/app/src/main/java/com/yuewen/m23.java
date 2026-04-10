package com.yuewen;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.duokan.free.tts.service.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class m23 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14288b;
    public final String c;
    public final int d;
    public final String e;

    public m23(@NonNull JSONObject jSONObject) {
        this.f14287a = jSONObject.optString("title");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
        this.f14288b = jSONObjectOptJSONObject.optString("summary");
        this.c = jSONObjectOptJSONObject.optString("book_cover");
        this.d = jSONObjectOptJSONObject.optInt("qmss_read");
        this.e = jSONObjectOptJSONObject.optString(e.c.f3725a);
    }

    public static m23 a(JSONObject jSONObject) {
        return new m23(jSONObject);
    }

    public boolean b() {
        return (TextUtils.isEmpty(this.f14287a) || TextUtils.isEmpty(this.f14288b) || TextUtils.isEmpty(this.c) || this.d == 0 || TextUtils.isEmpty(this.e)) ? false : true;
    }
}
