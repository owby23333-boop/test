package com.anythink.expressad.exoplayer.b;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final b a = new a().a();
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f8521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AudioAttributes f8523e;

    public static final class a {
        private int a = 0;
        private int b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f8524c = 1;

        private a c(int i2) {
            this.b = i2;
            return this;
        }

        public final a a(int i2) {
            this.a = i2;
            return this;
        }

        public final a b(int i2) {
            this.f8524c = i2;
            return this;
        }

        public final b a() {
            return new b(this.a, this.b, this.f8524c, (byte) 0);
        }
    }

    /* synthetic */ b(int i2, int i3, int i4, byte b) {
        this(i2, i3, i4);
    }

    @TargetApi(21)
    final AudioAttributes a() {
        if (this.f8523e == null) {
            this.f8523e = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.f8521c).setUsage(this.f8522d).build();
        }
        return this.f8523e;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.b == bVar.b && this.f8521c == bVar.f8521c && this.f8522d == bVar.f8522d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.b + 527) * 31) + this.f8521c) * 31) + this.f8522d;
    }

    private b(int i2, int i3, int i4) {
        this.b = i2;
        this.f8521c = i3;
        this.f8522d = i4;
    }
}
