package com.yuewen;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* JADX INFO: loaded from: classes17.dex */
public final class eu1 extends h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final eu1 f10957a = new eu1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static String f10958b = "";

    @NotNull
    public static ConcurrentHashMap<String, Object> c = new ConcurrentHashMap<>();
    public static long d;

    @Override // com.yuewen.h2
    @NotNull
    public String d() {
        return "TRACK_QUALITY_LOGIN";
    }

    @Override // com.yuewen.h2
    public void g(@NotNull String hash, int i, @NotNull String message) throws JSONException {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(message, "message");
        i("loginCostTime", Long.valueOf(k()));
        n();
        super.g(hash, i, message);
    }

    @Override // com.yuewen.h2
    @NotNull
    public synchronized String h() {
        f10958b = super.h();
        d = System.currentTimeMillis();
        return f10958b;
    }

    public final void i(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        c.put(key, value);
    }

    @NotNull
    public final String j() {
        return f10958b;
    }

    public final long k() {
        return System.currentTimeMillis() - d;
    }

    public final long l() {
        return d;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f10958b = str;
    }

    public final void n() throws JSONException {
        super.e(f10958b, c);
        c.clear();
    }
}
