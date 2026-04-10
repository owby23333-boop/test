package com.yuewen;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class ad2 implements wc2, yf2<Map<String, ? extends Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<String, Object> f8475a;

    public ad2(@NotNull Map<String, ? extends Object> uploadParams) {
        Intrinsics.checkNotNullParameter(uploadParams, "uploadParams");
        this.f8475a = uploadParams;
    }

    @Override // com.yuewen.yf2
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Object> b() {
        return this.f8475a;
    }
}
