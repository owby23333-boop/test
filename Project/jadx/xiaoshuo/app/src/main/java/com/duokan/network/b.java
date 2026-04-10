package com.duokan.network;

import com.duokan.network.a;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes17.dex */
public final class b {
    public static final <T> T a(@NotNull a<? extends T> aVar, T t) {
        T t2;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        a.b bVar = aVar instanceof a.b ? (a.b) aVar : null;
        return (bVar == null || (t2 = (T) bVar.h()) == null) ? t : t2;
    }
}
