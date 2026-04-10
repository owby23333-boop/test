package com.yuewen;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class zc2 implements wc2, yf2<Map<String, ? extends Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<String, Object> f20736a;

    public zc2(@NotNull Map<String, ? extends Object> uploadParams) {
        Intrinsics.checkNotNullParameter(uploadParams, "uploadParams");
        this.f20736a = uploadParams;
    }

    @Override // com.yuewen.yf2
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Object> b() {
        return this.f20736a;
    }
}
