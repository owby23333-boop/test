package com.anythink.expressad.exoplayer.h.b;

import android.util.SparseArray;
import com.anythink.expressad.exoplayer.e.k;
import com.anythink.expressad.exoplayer.e.m;
import com.anythink.expressad.exoplayer.k.s;
import com.anythink.expressad.exoplayer.m;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.anythink.expressad.exoplayer.e.g {
    public final com.anythink.expressad.exoplayer.e.e a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m f9250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SparseArray<a> f9251d = new SparseArray<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f9252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f9253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private k f9254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private m[] f9255h;

    public interface b {
        com.anythink.expressad.exoplayer.e.m a(int i2);
    }

    private d(com.anythink.expressad.exoplayer.e.e eVar, int i2, m mVar) {
        this.a = eVar;
        this.b = i2;
        this.f9250c = mVar;
    }

    private k b() {
        return this.f9254g;
    }

    private m[] c() {
        return this.f9255h;
    }

    public final void a(b bVar, long j2) {
        this.f9253f = bVar;
        if (!this.f9252e) {
            this.a.a(this);
            if (j2 != com.anythink.expressad.exoplayer.b.b) {
                this.a.a(0L, j2);
            }
            this.f9252e = true;
            return;
        }
        com.anythink.expressad.exoplayer.e.e eVar = this.a;
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            j2 = 0;
        }
        eVar.a(0L, j2);
        for (int i2 = 0; i2 < this.f9251d.size(); i2++) {
            this.f9251d.valueAt(i2).a(bVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void c_() {
        m[] mVarArr = new m[this.f9251d.size()];
        for (int i2 = 0; i2 < this.f9251d.size(); i2++) {
            mVarArr[i2] = this.f9251d.valueAt(i2).a;
        }
        this.f9255h = mVarArr;
    }

    private static final class a implements com.anythink.expressad.exoplayer.e.m {
        public m a;
        private final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f9256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final m f9257d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private com.anythink.expressad.exoplayer.e.m f9258e;

        public a(int i2, int i3, m mVar) {
            this.b = i2;
            this.f9256c = i3;
            this.f9257d = mVar;
        }

        public final void a(b bVar) {
            if (bVar == null) {
                this.f9258e = new com.anythink.expressad.exoplayer.e.d();
                return;
            }
            this.f9258e = bVar.a(this.f9256c);
            m mVar = this.a;
            if (mVar != null) {
                this.f9258e.a(mVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final void a(m mVar) {
            m mVar2 = this.f9257d;
            if (mVar2 != null) {
                mVar = mVar.a(mVar2);
            }
            this.a = mVar;
            this.f9258e.a(this.a);
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final int a(com.anythink.expressad.exoplayer.e.f fVar, int i2, boolean z2) {
            return this.f9258e.a(fVar, i2, z2);
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final void a(s sVar, int i2) {
            this.f9258e.a(sVar, i2);
        }

        @Override // com.anythink.expressad.exoplayer.e.m
        public final void a(long j2, int i2, int i3, int i4, m.a aVar) {
            this.f9258e.a(j2, i2, i3, i4, aVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final com.anythink.expressad.exoplayer.e.m a(int i2, int i3) {
        a aVar = this.f9251d.get(i2);
        if (aVar == null) {
            com.anythink.expressad.exoplayer.k.a.b(this.f9255h == null);
            aVar = new a(i2, i3, i3 == this.b ? this.f9250c : null);
            aVar.a(this.f9253f);
            this.f9251d.put(i2, aVar);
        }
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.e.g
    public final void a(k kVar) {
        this.f9254g = kVar;
    }
}
