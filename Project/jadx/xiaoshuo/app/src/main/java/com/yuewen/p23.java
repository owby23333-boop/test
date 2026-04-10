package com.yuewen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class p23 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15920b;
    public final int c;

    public p23(int i, int i2, int i3) {
        this.f15919a = i;
        this.f15920b = i2;
        this.c = i3;
    }

    @Nullable
    public static p23 b(@NonNull JSONObject jSONObject) {
        try {
            return new p23(jSONObject.optInt("sum"), jSONObject.optInt("process"), jSONObject.optInt("award"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean a() {
        return this.f15920b >= this.f15919a;
    }
}
