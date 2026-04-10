package com.alipay.sdk.m.t;

import android.text.TextUtils;
import com.alipay.sdk.m.y.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1941b;

    public b(String str, String str2) {
        this.f1940a = str;
        this.f1941b = str2;
    }

    public String a() {
        return this.f1941b;
    }

    public String b() {
        return this.f1940a;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.f1941b)) {
            return null;
        }
        try {
            return new JSONObject(this.f1941b);
        } catch (Exception e) {
            g.a(e);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f1940a, this.f1941b);
    }
}
