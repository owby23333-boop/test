package com.yuewen;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes14.dex */
public final class c63 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9561b;

    public c63(int i, boolean z) {
        this.f9560a = i;
        this.f9561b = z;
    }

    public final int a() {
        return this.f9560a;
    }

    public final boolean b() {
        return this.f9561b;
    }

    public /* synthetic */ c63(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z);
    }
}
