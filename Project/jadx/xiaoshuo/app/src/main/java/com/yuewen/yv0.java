package com.yuewen;

import com.duokan.statistics.base.tool.expose.ExposeEvent;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class yv0 extends ExposeEvent {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yv0(@we2 @NotNull String page) {
        super(h01.Z3, page);
        Intrinsics.checkNotNullParameter(page, "page");
    }
}
