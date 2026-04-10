package com.anythink.expressad.exoplayer.h;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.aa;
import com.anythink.expressad.exoplayer.h.s;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends f<Void> {
    private final s a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9414c;

    private static final class a extends p {
        public a(com.anythink.expressad.exoplayer.ae aeVar) {
            super(aeVar);
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final int a(int i2, int i3, boolean z2) {
            int iA = this.b.a(i2, i3, z2);
            return iA == -1 ? b(z2) : iA;
        }

        @Override // com.anythink.expressad.exoplayer.h.p, com.anythink.expressad.exoplayer.ae
        public final int b(int i2, int i3, boolean z2) {
            int iB = this.b.b(i2, i3, z2);
            return iB == -1 ? a(z2) : iB;
        }
    }

    private static final class b extends com.anythink.expressad.exoplayer.h.a {
        private final com.anythink.expressad.exoplayer.ae b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9415c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f9416d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f9417e;

        public b(com.anythink.expressad.exoplayer.ae aeVar, int i2) {
            super(false, new aa.b(i2));
            this.b = aeVar;
            this.f9415c = aeVar.c();
            this.f9416d = aeVar.b();
            this.f9417e = i2;
            int i3 = this.f9415c;
            if (i3 > 0) {
                com.anythink.expressad.exoplayer.k.a.b(i2 <= Integer.MAX_VALUE / i3, "LoopingMediaSource contains too many periods");
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int a(int i2) {
            return i2 / this.f9415c;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int b() {
            return this.f9416d * this.f9417e;
        }

        @Override // com.anythink.expressad.exoplayer.ae
        public final int c() {
            return this.f9415c * this.f9417e;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int d(int i2) {
            return i2 * this.f9415c;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int e(int i2) {
            return i2 * this.f9416d;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final Object f(int i2) {
            return Integer.valueOf(i2);
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int b(int i2) {
            return i2 / this.f9416d;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final com.anythink.expressad.exoplayer.ae c(int i2) {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.h.a
        protected final int b(Object obj) {
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            return -1;
        }
    }

    private q(s sVar) {
        this(sVar, (byte) 0);
    }

    private void b(com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj) {
        this.f9414c = aeVar.c();
        int i2 = this.b;
        a(i2 != Integer.MAX_VALUE ? new b(aeVar, i2) : new a(aeVar), obj);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z2) {
        super.a(hVar, z2);
        a((Object) null, this.a);
    }

    private q(s sVar, byte b2) {
        com.anythink.expressad.exoplayer.k.a.a(true);
        this.a = sVar;
        this.b = Integer.MAX_VALUE;
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        if (this.b != Integer.MAX_VALUE) {
            return this.a.a(aVar.a(aVar.a % this.f9414c), bVar);
        }
        return this.a.a(aVar, bVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        this.a.a(rVar);
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.f9414c = 0;
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ void a(Void r1, s sVar, com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj) {
        com.anythink.expressad.exoplayer.ae aVar;
        this.f9414c = aeVar.c();
        int i2 = this.b;
        if (i2 != Integer.MAX_VALUE) {
            aVar = new b(aeVar, i2);
        } else {
            aVar = new a(aeVar);
        }
        a(aVar, obj);
    }
}
