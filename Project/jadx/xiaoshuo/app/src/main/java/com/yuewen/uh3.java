package com.yuewen;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class uh3 implements sh3, sp1<String, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Object f18464b;

    public uh3(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f18463a = key;
        this.f18464b = value;
    }

    @Override // com.yuewen.sp1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.f18463a;
    }

    @Override // com.yuewen.sp1
    @NotNull
    public Object getValue() {
        return this.f18464b;
    }
}
