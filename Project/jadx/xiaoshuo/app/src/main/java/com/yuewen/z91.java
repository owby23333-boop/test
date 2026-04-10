package com.yuewen;

import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes14.dex */
public final class z91 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final DrawableCrossFadeFactory f20714a;

    static {
        DrawableCrossFadeFactory drawableCrossFadeFactoryBuild = new DrawableCrossFadeFactory.Builder(500).setCrossFadeEnabled(true).build();
        Intrinsics.checkNotNullExpressionValue(drawableCrossFadeFactoryBuild, "<clinit>");
        f20714a = drawableCrossFadeFactoryBuild;
    }

    @NotNull
    public static final DrawableCrossFadeFactory a() {
        return f20714a;
    }
}
