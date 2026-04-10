package com.anythink.expressad.exoplayer.e;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static final l a = new l(0, 0);
    public final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9021c;

    public l(long j2, long j3) {
        this.b = j2;
        this.f9021c = j3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (this.b == lVar.b && this.f9021c == lVar.f9021c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.b) * 31) + ((int) this.f9021c);
    }

    public final String toString() {
        return "[timeUs=" + this.b + ", position=" + this.f9021c + "]";
    }
}
