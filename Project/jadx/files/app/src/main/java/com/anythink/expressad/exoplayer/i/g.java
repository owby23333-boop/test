package com.anythink.expressad.exoplayer.i;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public final int a;
    private final f[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9567c;

    public g(f... fVarArr) {
        this.b = fVarArr;
        this.a = fVarArr.length;
    }

    @Nullable
    public final f a(int i2) {
        return this.b[i2];
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((g) obj).b);
    }

    public final int hashCode() {
        if (this.f9567c == 0) {
            this.f9567c = Arrays.hashCode(this.b) + 527;
        }
        return this.f9567c;
    }

    public final f[] a() {
        return (f[]) this.b.clone();
    }
}
