package com.yuewen;

import com.duokan.bean.HotWordList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public final class xf1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final HotWordList f19876b;

    public xf1() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ xf1 d(xf1 xf1Var, int i, HotWordList hotWordList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = xf1Var.f19875a;
        }
        if ((i2 & 2) != 0) {
            hotWordList = xf1Var.f19876b;
        }
        return xf1Var.c(i, hotWordList);
    }

    public final int a() {
        return this.f19875a;
    }

    @NotNull
    public final HotWordList b() {
        return this.f19876b;
    }

    @NotNull
    public final xf1 c(int i, @NotNull HotWordList hotWordList) {
        Intrinsics.checkNotNullParameter(hotWordList, "hotWordList");
        return new xf1(i, hotWordList);
    }

    @NotNull
    public final HotWordList e() {
        return this.f19876b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xf1)) {
            return false;
        }
        xf1 xf1Var = (xf1) obj;
        return this.f19875a == xf1Var.f19875a && Intrinsics.areEqual(this.f19876b, xf1Var.f19876b);
    }

    public final int f() {
        return this.f19875a;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f19875a) * 31) + this.f19876b.hashCode();
    }

    @NotNull
    public String toString() {
        return "HotWordUIState(userType=" + this.f19875a + ", hotWordList=" + this.f19876b + ")";
    }

    public xf1(int i, @NotNull HotWordList hotWordList) {
        Intrinsics.checkNotNullParameter(hotWordList, "hotWordList");
        this.f19875a = i;
        this.f19876b = hotWordList;
    }

    public /* synthetic */ xf1(int i, HotWordList hotWordList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i, (i2 & 2) != 0 ? new HotWordList(null, 1, null) : hotWordList);
    }
}
