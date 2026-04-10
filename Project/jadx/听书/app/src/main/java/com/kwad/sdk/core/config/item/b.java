package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b<T> {
    private T aCi;
    private T aCj;
    private String mKey;

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public abstract void k(JSONObject jSONObject);

    public b(String str, T t) {
        this(str, t, t);
    }

    private b(String str, T t, T t2) {
        this.mKey = str;
        this.aCj = t;
        this.aCi = t2;
        com.kwad.sdk.core.config.b.a(this);
    }

    public final String getKey() {
        return this.mKey;
    }

    public T getValue() {
        return this.aCj;
    }

    public final T Gu() {
        return this.aCi;
    }

    public void setValue(T t) {
        this.aCj = t;
    }

    public static String dz(String str) {
        return !TextUtils.isEmpty(str) ? com.kwad.sdk.core.a.c.encodeKsSdk(str) : str;
    }

    public static String getDecodeString(String str) {
        return (TextUtils.isEmpty(str) || !com.kwad.sdk.core.a.c.isEncodeKsSdk(str)) ? str : com.kwad.sdk.core.a.c.decodeKsSdk(str);
    }
}
