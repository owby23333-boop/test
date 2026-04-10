package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b<T> {
    private T adA;
    private T adz;
    private String mKey;

    public b(String str, T t2) {
        this(str, t2, t2);
    }

    private b(String str, T t2, T t3) {
        this.mKey = str;
        this.adA = t2;
        this.adz = t3;
        com.kwad.sdk.core.config.b.a(this);
    }

    public static String bm(String str) {
        return !TextUtils.isEmpty(str) ? com.kwad.sdk.core.kwai.c.bG(str) : str;
    }

    public static String bn(String str) {
        return (TextUtils.isEmpty(str) || !com.kwad.sdk.core.kwai.c.bI(str)) ? str : com.kwad.sdk.core.kwai.c.bH(str);
    }

    public abstract void a(SharedPreferences sharedPreferences);

    public abstract void b(SharedPreferences.Editor editor);

    public abstract void f(JSONObject jSONObject);

    public final String getKey() {
        return this.mKey;
    }

    @Nullable
    public T getValue() {
        return this.adA;
    }

    public final void setValue(T t2) {
        this.adA = t2;
    }

    public final T vj() {
        return this.adz;
    }
}
