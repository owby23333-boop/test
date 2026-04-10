package com.anythink.expressad.exoplayer;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class ac {
    public static final ac a = new ac(0, 0);
    public static final ac b = new ac(Long.MAX_VALUE, Long.MAX_VALUE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ac f8460c = new ac(Long.MAX_VALUE, 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ac f8461d = new ac(0, Long.MAX_VALUE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ac f8462e = a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f8463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f8464g;

    public ac(long j2, long j3) {
        com.anythink.expressad.exoplayer.k.a.a(j2 >= 0);
        com.anythink.expressad.exoplayer.k.a.a(j3 >= 0);
        this.f8463f = j2;
        this.f8464g = j3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ac.class == obj.getClass()) {
            ac acVar = (ac) obj;
            if (this.f8463f == acVar.f8463f && this.f8464g == acVar.f8464g) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.f8463f) * 31) + ((int) this.f8464g);
    }
}
