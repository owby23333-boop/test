package com.anythink.expressad.exoplayer;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static final v a = new v(1.0f);
    public final float b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f10069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10070d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f10071e;

    public v(float f2) {
        this(f2, 1.0f, false);
    }

    public final long a(long j2) {
        return j2 * ((long) this.f10071e);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && v.class == obj.getClass()) {
            v vVar = (v) obj;
            if (this.b == vVar.b && this.f10069c == vVar.f10069c && this.f10070d == vVar.f10070d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Float.floatToRawIntBits(this.b) + 527) * 31) + Float.floatToRawIntBits(this.f10069c)) * 31) + (this.f10070d ? 1 : 0);
    }

    public v(float f2, float f3) {
        this(f2, f3, false);
    }

    public v(float f2, float f3, boolean z2) {
        com.anythink.expressad.exoplayer.k.a.a(f2 > 0.0f);
        com.anythink.expressad.exoplayer.k.a.a(f3 > 0.0f);
        this.b = f2;
        this.f10069c = f3;
        this.f10070d = z2;
        this.f10071e = Math.round(f2 * 1000.0f);
    }
}
