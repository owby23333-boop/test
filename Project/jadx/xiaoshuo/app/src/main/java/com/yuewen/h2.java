package com.yuewen;

import com.yuewen.y32;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* JADX INFO: loaded from: classes17.dex */
public abstract class h2 {
    public h2() {
        y32.f20206a.f(d(), c());
    }

    public void a(@NotNull String hash, @NotNull String erDesc) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(erDesc, "erDesc");
        if (b() == null) {
            return;
        }
        y32.f20206a.a(d(), hash, erDesc);
    }

    @Nullable
    public y32.a b() {
        return y32.f20206a.d(d());
    }

    @NotNull
    public lr1<String> c() {
        return new lr1<>();
    }

    @NotNull
    public abstract String d();

    public void e(@NotNull String hash, @NotNull ConcurrentHashMap<String, Object> map) throws JSONException {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(map, "map");
        if (b() == null) {
            return;
        }
        y32.f20206a.m(hash, map);
    }

    public void f(@NotNull String hash, @NotNull v32 data) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(data, "data");
        if (b() == null) {
            return;
        }
        y32.f20206a.n(d(), hash, data, true);
    }

    public void g(@NotNull String hash, int i, @NotNull String message) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        Intrinsics.checkNotNullParameter(message, "message");
        if (b() == null) {
            return;
        }
        y32.f20206a.q(d(), hash, i, message);
    }

    @NotNull
    public String h() {
        return b() == null ? "" : y32.s(y32.f20206a, d(), null, 2, null);
    }
}
