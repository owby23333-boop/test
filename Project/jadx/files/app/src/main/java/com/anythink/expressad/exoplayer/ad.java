package com.anythink.expressad.exoplayer;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.a.a;
import com.anythink.expressad.exoplayer.b.b;
import com.anythink.expressad.exoplayer.h;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.w;
import com.anythink.expressad.exoplayer.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public class ad implements h, w.e, w.g {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f8465x = "SimpleExoPlayer";
    private final a A;
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.l.g> B;
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.g.f> C;
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.l.h> D;
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.b.g> E;
    private final com.anythink.expressad.exoplayer.a.a F;
    private m G;
    private m H;
    private Surface I;
    private boolean J;
    private int K;
    private SurfaceHolder L;
    private TextureView M;
    private com.anythink.expressad.exoplayer.c.d N;
    private com.anythink.expressad.exoplayer.c.d O;
    private int P;
    private com.anythink.expressad.exoplayer.b.b Q;
    private float R;
    private com.anythink.expressad.exoplayer.h.s S;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected final y[] f8466w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final h f8467y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Handler f8468z;

    private final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.anythink.expressad.exoplayer.b.g, com.anythink.expressad.exoplayer.g.f, com.anythink.expressad.exoplayer.l.h {
        private a() {
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(com.anythink.expressad.exoplayer.c.d dVar) {
            ad.this.N = dVar;
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(dVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void b(com.anythink.expressad.exoplayer.c.d dVar) {
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).b(dVar);
            }
            ad.this.G = null;
            ad.this.N = null;
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void c(com.anythink.expressad.exoplayer.c.d dVar) {
            ad.this.O = dVar;
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).c(dVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void d(com.anythink.expressad.exoplayer.c.d dVar) {
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).d(dVar);
            }
            ad.this.H = null;
            ad.this.O = null;
            ad.this.P = 0;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            ad.this.a(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ad.this.a((Surface) null, true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            ad.this.a(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ad.this.a((Surface) null, false);
        }

        /* synthetic */ a(ad adVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(String str, long j2, long j3) {
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(str, j2, j3);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void b(String str, long j2, long j3) {
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).b(str, j2, j3);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(m mVar) {
            ad.this.G = mVar;
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(mVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void b(m mVar) {
            ad.this.H = mVar;
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).b(mVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(int i2, long j2) {
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(i2, j2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(int i2, int i3, int i4, float f2) {
            Iterator it = ad.this.B.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.g) it.next()).a(i2, i3);
            }
            Iterator it2 = ad.this.D.iterator();
            while (it2.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it2.next()).a(i2, i3, i4, f2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(Surface surface) {
            if (ad.this.I == surface) {
                Iterator it = ad.this.B.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            Iterator it2 = ad.this.D.iterator();
            while (it2.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it2.next()).a(surface);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void a(int i2) {
            ad.this.P = i2;
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).a(i2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void a(int i2, long j2, long j3) {
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).a(i2, j2, j3);
            }
        }

        @Override // com.anythink.expressad.exoplayer.g.f
        public final void a(com.anythink.expressad.exoplayer.g.a aVar) {
            Iterator it = ad.this.C.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.g.f) it.next()).a(aVar);
            }
        }
    }

    @Deprecated
    public interface b extends com.anythink.expressad.exoplayer.l.g {
    }

    protected ad(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, p pVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        new a.C0180a();
        this(abVar, hVar, pVar, gVar, (byte) 0);
    }

    @Deprecated
    private int K() {
        return af.f(this.Q.f8522d);
    }

    private com.anythink.expressad.exoplayer.a.a L() {
        return this.F;
    }

    private com.anythink.expressad.exoplayer.b.b M() {
        return this.Q;
    }

    private float N() {
        return this.R;
    }

    private m O() {
        return this.G;
    }

    private m P() {
        return this.H;
    }

    private int Q() {
        return this.P;
    }

    private com.anythink.expressad.exoplayer.c.d R() {
        return this.N;
    }

    private com.anythink.expressad.exoplayer.c.d S() {
        return this.O;
    }

    private void T() {
        TextureView textureView = this.M;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() == this.A) {
                this.M.setSurfaceTextureListener(null);
            }
            this.M = null;
        }
        SurfaceHolder surfaceHolder = this.L;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.A);
            this.L = null;
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int A() {
        return this.f8467y.A();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long B() {
        return this.f8467y.B();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int C() {
        return this.f8467y.C();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.h.af D() {
        return this.f8467y.D();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.i.g E() {
        return this.f8467y.E();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final ae F() {
        return this.f8467y.F();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final Object G() {
        return this.f8467y.G();
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final int H() {
        return this.K;
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void I() {
        a((Surface) null);
    }

    public final boolean J() {
        return d() == 3 && f();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final w.g b() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final w.e c() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean f() {
        return this.f8467y.f();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int g() {
        return this.f8467y.g();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean h() {
        return this.f8467y.h();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean i() {
        return this.f8467y.i();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void j() {
        this.F.a();
        this.f8467y.j();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final v k() {
        return this.f8467y.k();
    }

    @Override // com.anythink.expressad.exoplayer.w
    @Nullable
    public final Object l() {
        return this.f8467y.l();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void m() {
        c(false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void n() {
        this.f8467y.n();
        T();
        Surface surface = this.I;
        if (surface != null) {
            if (this.J) {
                surface.release();
            }
            this.I = null;
        }
        com.anythink.expressad.exoplayer.h.s sVar = this.S;
        if (sVar != null) {
            sVar.a(this.F);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int o() {
        return this.f8467y.o();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int p() {
        return this.f8467y.p();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int q() {
        return this.f8467y.q();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int r() {
        return this.f8467y.r();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long s() {
        return this.f8467y.s();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long t() {
        return this.f8467y.t();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long u() {
        return this.f8467y.u();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int v() {
        return this.f8467y.v();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean w() {
        return this.f8467y.w();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean x() {
        return this.f8467y.x();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean y() {
        return this.f8467y.y();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int z() {
        return this.f8467y.z();
    }

    protected ad(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, p pVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, byte b2) {
        this(abVar, hVar, pVar, gVar, com.anythink.expressad.exoplayer.k.c.a);
    }

    @Deprecated
    private void c(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.retainAll(Collections.singleton(this.F));
        if (fVar != null) {
            a(fVar);
        }
    }

    @Deprecated
    private void e(int i2) {
        com.anythink.expressad.exoplayer.b.b bVarA = new b.a().b(af.d(i2)).a(af.e(i2)).a();
        this.Q = bVarA;
        for (y yVar : this.f8466w) {
            if (yVar.a() == 1) {
                this.f8467y.a(yVar).a(3).a(bVarA).i();
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void d(int i2) {
        this.K = i2;
        for (y yVar : this.f8466w) {
            if (yVar.a() == 2) {
                this.f8467y.a(yVar).a(4).a(Integer.valueOf(i2)).i();
            }
        }
    }

    private ad(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, p pVar, @Nullable com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.k.c cVar) {
        this.A = new a(this, (byte) 0);
        this.B = new CopyOnWriteArraySet<>();
        this.C = new CopyOnWriteArraySet<>();
        this.D = new CopyOnWriteArraySet<>();
        this.E = new CopyOnWriteArraySet<>();
        this.f8468z = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        Handler handler = this.f8468z;
        a aVar = this.A;
        this.f8466w = abVar.a(handler, aVar, aVar, aVar, gVar);
        this.R = 1.0f;
        this.P = 0;
        this.Q = com.anythink.expressad.exoplayer.b.b.a;
        this.K = 1;
        this.f8467y = new j(this.f8466w, hVar, pVar, cVar);
        this.F = a.C0180a.a(this.f8467y, cVar);
        a((w.c) this.F);
        this.D.add(this.F);
        this.E.add(this.F);
        a((com.anythink.expressad.exoplayer.g.f) this.F);
        if (gVar instanceof com.anythink.expressad.exoplayer.d.d) {
            ((com.anythink.expressad.exoplayer.d.d) gVar).a(this.f8468z, this.F);
        }
    }

    @Deprecated
    private void c(com.anythink.expressad.exoplayer.l.h hVar) {
        this.D.remove(hVar);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(Surface surface) {
        if (surface == null || surface != this.I) {
            return;
        }
        a((Surface) null);
    }

    @Deprecated
    private void c(com.anythink.expressad.exoplayer.b.g gVar) {
        this.E.remove(gVar);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(Surface surface) {
        T();
        a(surface, false);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null || surfaceHolder != this.L) {
            return;
        }
        a((SurfaceHolder) null);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void c(boolean z2) {
        this.f8467y.c(z2);
        com.anythink.expressad.exoplayer.h.s sVar = this.S;
        if (sVar != null) {
            sVar.a(this.F);
            this.S = null;
            this.F.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    @Override // com.anythink.expressad.exoplayer.w.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.SurfaceHolder r2) {
        /*
            r1 = this;
            r1.T()
            r1.L = r2
            if (r2 != 0) goto L8
            goto L1a
        L8:
            com.anythink.expressad.exoplayer.ad$a r0 = r1.A
            r2.addCallback(r0)
            android.view.Surface r2 = r2.getSurface()
            if (r2 == 0) goto L1a
            boolean r0 = r2.isValid()
            if (r0 == 0) goto L1a
            goto L1b
        L1a:
            r2 = 0
        L1b:
            r0 = 0
            r1.a(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.ad.a(android.view.SurfaceHolder):void");
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        if (holder == null || holder != this.L) {
            return;
        }
        a((SurfaceHolder) null);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int d() {
        return this.f8467y.d();
    }

    @Deprecated
    private void d(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.remove(fVar);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(TextureView textureView) {
        if (textureView == null || textureView != this.M) {
            return;
        }
        a((TextureView) null);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int c(int i2) {
        return this.f8467y.c(i2);
    }

    private void b(com.anythink.expressad.exoplayer.a.b bVar) {
        this.F.b(bVar);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(SurfaceView surfaceView) {
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(TextureView textureView) {
        T();
        this.M = textureView;
        Surface surface = null;
        if (textureView != null) {
            textureView.getSurfaceTextureListener();
            textureView.setSurfaceTextureListener(this.A);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            if (surfaceTexture != null) {
                surface = new Surface(surfaceTexture);
            }
        }
        a(surface, true);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(com.anythink.expressad.exoplayer.l.g gVar) {
        this.B.remove(gVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final g e() {
        return this.f8467y.e();
    }

    @Deprecated
    private void b(b bVar) {
        b((com.anythink.expressad.exoplayer.l.g) bVar);
    }

    private void b(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.remove(fVar);
    }

    @Deprecated
    private void b(com.anythink.expressad.exoplayer.l.h hVar) {
        this.D.add(hVar);
    }

    @Deprecated
    private void b(com.anythink.expressad.exoplayer.b.g gVar) {
        this.E.add(gVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(w.c cVar) {
        this.f8467y.b(cVar);
    }

    private void a(com.anythink.expressad.exoplayer.a.b bVar) {
        this.F.a(bVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(boolean z2) {
        this.f8467y.b(z2);
    }

    private void a(com.anythink.expressad.exoplayer.b.b bVar) {
        this.Q = bVar;
        for (y yVar : this.f8466w) {
            if (yVar.a() == 1) {
                this.f8467y.a(yVar).a(3).a(bVar).i();
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(int i2) {
        this.F.a();
        this.f8467y.b(i2);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void b(h.c... cVarArr) {
        this.f8467y.b(cVarArr);
    }

    public final void a(float f2) {
        this.R = f2;
        for (y yVar : this.f8466w) {
            if (yVar.a() == 1) {
                this.f8467y.a(yVar).a(2).a(Float.valueOf(f2)).i();
            }
        }
    }

    @TargetApi(23)
    @Deprecated
    private void a(@Nullable PlaybackParams playbackParams) {
        v vVar;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            vVar = new v(playbackParams.getSpeed(), playbackParams.getPitch());
        } else {
            vVar = null;
        }
        a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(com.anythink.expressad.exoplayer.l.g gVar) {
        this.B.add(gVar);
    }

    @Deprecated
    private void a(b bVar) {
        this.B.clear();
        if (bVar != null) {
            a((com.anythink.expressad.exoplayer.l.g) bVar);
        }
    }

    private void a(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.add(fVar);
    }

    @Deprecated
    private void a(com.anythink.expressad.exoplayer.l.h hVar) {
        this.D.retainAll(Collections.singleton(this.F));
        if (hVar != null) {
            this.D.add(hVar);
        }
    }

    @Deprecated
    private void a(com.anythink.expressad.exoplayer.b.g gVar) {
        this.E.retainAll(Collections.singleton(this.F));
        if (gVar != null) {
            this.E.add(gVar);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final Looper a() {
        return this.f8467y.a();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(w.c cVar) {
        this.f8467y.a(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar) {
        a(sVar, true, true);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z2, boolean z3) {
        com.anythink.expressad.exoplayer.h.s sVar2 = this.S;
        if (sVar2 != sVar) {
            if (sVar2 != null) {
                sVar2.a(this.F);
                this.F.b();
            }
            sVar.a(this.f8468z, this.F);
            this.S = sVar;
        }
        this.f8467y.a(sVar, z2, z3);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(boolean z2) {
        this.f8467y.a(z2);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i2) {
        this.f8467y.a(i2);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(long j2) {
        this.F.a();
        this.f8467y.a(j2);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i2, long j2) {
        this.F.a();
        this.f8467y.a(i2, j2);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(@Nullable v vVar) {
        this.f8467y.a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(@Nullable ac acVar) {
        this.f8467y.a(acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(h.c... cVarArr) {
        this.f8467y.a(cVarArr);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final x a(x.b bVar) {
        return this.f8467y.a(bVar);
    }

    private static h a(y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, p pVar, com.anythink.expressad.exoplayer.k.c cVar) {
        return new j(yVarArr, hVar, pVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z2) {
        ArrayList arrayList = new ArrayList();
        for (y yVar : this.f8466w) {
            if (yVar.a() == 2) {
                arrayList.add(this.f8467y.a(yVar).a(1).a(surface).i());
            }
        }
        Surface surface2 = this.I;
        if (surface2 != null && surface2 != surface) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((x) it.next()).k();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                this.f8467y.c(false);
            }
            if (this.J) {
                this.I.release();
            }
        }
        this.I = surface;
        this.J = z2;
    }
}
