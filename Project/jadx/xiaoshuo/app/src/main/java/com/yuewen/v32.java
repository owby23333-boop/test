package com.yuewen;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes17.dex */
public class v32 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final JSONObject f18878b;

    public v32(@NotNull String routePath) {
        Intrinsics.checkNotNullParameter(routePath, "routePath");
        this.f18877a = routePath;
        this.f18878b = new JSONObject();
    }

    @NotNull
    public final JSONObject a() {
        return this.f18878b;
    }

    @NotNull
    public final String b() {
        return this.f18877a;
    }

    @NotNull
    public final v32 c(@NotNull String name, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (obj == null) {
            return this;
        }
        try {
            this.f18878b.put(name, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }
}
