package com.yuewen;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class yc2 implements wc2, sp1<String, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f20295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Object f20296b;

    public yc2(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f20295a = key;
        this.f20296b = value;
    }

    @Override // com.yuewen.sp1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.f20295a;
    }

    @Override // com.yuewen.sp1
    @NotNull
    public Object getValue() {
        return this.f20296b;
    }
}
