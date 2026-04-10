package com.yuewen;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class th3 implements sh3, sp1<String, Set<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Set<String> f17987b;

    public th3(@NotNull String key, @NotNull Set<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f17986a = key;
        this.f17987b = value;
    }

    @Override // com.yuewen.sp1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.f17986a;
    }

    @Override // com.yuewen.sp1
    @NotNull
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public Set<String> getValue() {
        return this.f17987b;
    }
}
