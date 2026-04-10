package com.anythink.expressad.exoplayer.i;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.ae;
import com.anythink.expressad.exoplayer.i.f;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends b {
    private final int a;

    @Nullable
    private final Object b;

    public d(ae aeVar, int i2) {
        this(aeVar, i2, 0, null);
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final void a(long j2, long j3) {
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int b() {
        return 0;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    public final int c() {
        return this.a;
    }

    @Override // com.anythink.expressad.exoplayer.i.f
    @Nullable
    public final Object d() {
        return this.b;
    }

    public d(ae aeVar, int i2, int i3, @Nullable Object obj) {
        super(aeVar, i2);
        this.a = i3;
        this.b = obj;
    }

    public static final class a implements f.a {
        private final int a;

        @Nullable
        private final Object b;

        public a() {
            this.a = 0;
            this.b = null;
        }

        private d b(ae aeVar, int... iArr) {
            com.anythink.expressad.exoplayer.k.a.a(iArr.length == 1);
            return new d(aeVar, iArr[0], this.a, this.b);
        }

        @Override // com.anythink.expressad.exoplayer.i.f.a
        public final /* synthetic */ f a(ae aeVar, int[] iArr) {
            com.anythink.expressad.exoplayer.k.a.a(iArr.length == 1);
            return new d(aeVar, iArr[0], this.a, this.b);
        }

        private a(int i2, @Nullable Object obj) {
            this.a = i2;
            this.b = obj;
        }
    }
}
