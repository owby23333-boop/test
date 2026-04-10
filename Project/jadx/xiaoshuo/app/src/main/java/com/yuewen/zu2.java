package com.yuewen;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;

/* JADX INFO: loaded from: classes17.dex */
public final class zu2 extends h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public String f20985a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public ConcurrentHashMap<String, Object> f20986b = new ConcurrentHashMap<>();
    public long c;

    @Override // com.yuewen.h2
    @NotNull
    public String d() {
        return "TRACK_QUALITY_RELOGIN";
    }

    @Override // com.yuewen.h2
    public void g(@NotNull String hash, int i, @NotNull String message) throws JSONException {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(message, "message");
        if (this.c == 0) {
            return;
        }
        i("loginCostTime", Long.valueOf(k()));
        this.c = 0L;
        n();
        super.g(hash, i, message);
    }

    @Override // com.yuewen.h2
    @NotNull
    public synchronized String h() {
        this.f20985a = super.h();
        this.c = System.currentTimeMillis();
        return this.f20985a;
    }

    public final void i(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f20986b.put(key, value);
    }

    @NotNull
    public final String j() {
        return this.f20985a;
    }

    public final long k() {
        return System.currentTimeMillis() - this.c;
    }

    public final long l() {
        return this.c;
    }

    public final void m(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f20985a = str;
    }

    public final void n() throws JSONException {
        super.e(this.f20985a, this.f20986b);
        this.f20986b.clear();
    }
}
