package com.bumptech.glide.load.k.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.util.k;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GifFrameLoader.java */
/* JADX INFO: loaded from: classes2.dex */
class g {
    private final GifDecoder a;
    private final Handler b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b> f13727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final com.bumptech.glide.i f13728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.x.e f13729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f13731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.h<Bitmap> f13733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f13734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f13735k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private a f13736l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Bitmap f13737m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private a f13738n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private d f13739o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f13740p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f13741q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f13742r;

    /* JADX INFO: compiled from: GifFrameLoader.java */
    @VisibleForTesting
    static class a extends com.bumptech.glide.request.k.c<Bitmap> {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final Handler f13743v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final int f13744w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private final long f13745x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private Bitmap f13746y;

        a(Handler handler, int i2, long j2) {
            this.f13743v = handler;
            this.f13744w = i2;
            this.f13745x = j2;
        }

        @Override // com.bumptech.glide.request.k.j
        public /* bridge */ /* synthetic */ void a(@NonNull Object obj, @Nullable com.bumptech.glide.request.l.d dVar) {
            a((Bitmap) obj, (com.bumptech.glide.request.l.d<? super Bitmap>) dVar);
        }

        Bitmap b() {
            return this.f13746y;
        }

        public void a(@NonNull Bitmap bitmap, @Nullable com.bumptech.glide.request.l.d<? super Bitmap> dVar) {
            this.f13746y = bitmap;
            this.f13743v.sendMessageAtTime(this.f13743v.obtainMessage(1, this), this.f13745x);
        }

        @Override // com.bumptech.glide.request.k.j
        public void b(@Nullable Drawable drawable) {
            this.f13746y = null;
        }
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    public interface b {
        void a();
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                g.this.a((a) message.obj);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            g.this.f13728d.clear((a) message.obj);
            return false;
        }
    }

    /* JADX INFO: compiled from: GifFrameLoader.java */
    @VisibleForTesting
    interface d {
        void a();
    }

    g(com.bumptech.glide.c cVar, GifDecoder gifDecoder, int i2, int i3, com.bumptech.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        this(cVar.d(), com.bumptech.glide.c.e(cVar.getContext()), gifDecoder, null, a(com.bumptech.glide.c.e(cVar.getContext()), i2, i3), iVar, bitmap);
    }

    private static com.bumptech.glide.load.c k() {
        return new com.bumptech.glide.o.d(Double.valueOf(Math.random()));
    }

    private void l() {
        if (!this.f13730f || this.f13731g) {
            return;
        }
        if (this.f13732h) {
            k.a(this.f13738n == null, "Pending target must be null when starting from the first frame");
            this.a.f();
            this.f13732h = false;
        }
        a aVar = this.f13738n;
        if (aVar != null) {
            this.f13738n = null;
            a(aVar);
            return;
        }
        this.f13731g = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.a.e());
        this.a.b();
        this.f13736l = new a(this.b, this.a.g(), jUptimeMillis);
        this.f13733i.apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.signatureOf(k())).mo48load((Object) this.a).into(this.f13736l);
    }

    private void m() {
        Bitmap bitmap = this.f13737m;
        if (bitmap != null) {
            this.f13729e.a(bitmap);
            this.f13737m = null;
        }
    }

    private void n() {
        if (this.f13730f) {
            return;
        }
        this.f13730f = true;
        this.f13735k = false;
        l();
    }

    private void o() {
        this.f13730f = false;
    }

    void a(com.bumptech.glide.load.i<Bitmap> iVar, Bitmap bitmap) {
        k.a(iVar);
        k.a(bitmap);
        this.f13737m = bitmap;
        this.f13733i = this.f13733i.apply((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.h().transform(iVar));
        this.f13740p = l.a(bitmap);
        this.f13741q = bitmap.getWidth();
        this.f13742r = bitmap.getHeight();
    }

    void b(b bVar) {
        this.f13727c.remove(bVar);
        if (this.f13727c.isEmpty()) {
            o();
        }
    }

    Bitmap c() {
        a aVar = this.f13734j;
        return aVar != null ? aVar.b() : this.f13737m;
    }

    int d() {
        a aVar = this.f13734j;
        if (aVar != null) {
            return aVar.f13744w;
        }
        return -1;
    }

    Bitmap e() {
        return this.f13737m;
    }

    int f() {
        return this.a.c();
    }

    int g() {
        return this.f13742r;
    }

    int h() {
        return this.a.d();
    }

    int i() {
        return this.a.h() + this.f13740p;
    }

    int j() {
        return this.f13741q;
    }

    ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    g(com.bumptech.glide.load.engine.x.e eVar, com.bumptech.glide.i iVar, GifDecoder gifDecoder, Handler handler, com.bumptech.glide.h<Bitmap> hVar, com.bumptech.glide.load.i<Bitmap> iVar2, Bitmap bitmap) {
        this.f13727c = new ArrayList();
        this.f13728d = iVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.f13729e = eVar;
        this.b = handler;
        this.f13733i = hVar;
        this.a = gifDecoder;
        a(iVar2, bitmap);
    }

    void a(b bVar) {
        if (!this.f13735k) {
            if (!this.f13727c.contains(bVar)) {
                boolean zIsEmpty = this.f13727c.isEmpty();
                this.f13727c.add(bVar);
                if (zIsEmpty) {
                    n();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    void a() {
        this.f13727c.clear();
        m();
        o();
        a aVar = this.f13734j;
        if (aVar != null) {
            this.f13728d.clear(aVar);
            this.f13734j = null;
        }
        a aVar2 = this.f13736l;
        if (aVar2 != null) {
            this.f13728d.clear(aVar2);
            this.f13736l = null;
        }
        a aVar3 = this.f13738n;
        if (aVar3 != null) {
            this.f13728d.clear(aVar3);
            this.f13738n = null;
        }
        this.a.clear();
        this.f13735k = true;
    }

    @VisibleForTesting
    void a(a aVar) {
        d dVar = this.f13739o;
        if (dVar != null) {
            dVar.a();
        }
        this.f13731g = false;
        if (this.f13735k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.f13730f) {
            if (this.f13732h) {
                this.b.obtainMessage(2, aVar).sendToTarget();
                return;
            } else {
                this.f13738n = aVar;
                return;
            }
        }
        if (aVar.b() != null) {
            m();
            a aVar2 = this.f13734j;
            this.f13734j = aVar;
            for (int size = this.f13727c.size() - 1; size >= 0; size--) {
                this.f13727c.get(size).a();
            }
            if (aVar2 != null) {
                this.b.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        l();
    }

    private static com.bumptech.glide.h<Bitmap> a(com.bumptech.glide.i iVar, int i2, int i3) {
        return iVar.asBitmap().apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.h.diskCacheStrategyOf(com.bumptech.glide.load.engine.h.b).useAnimationPool(true).skipMemoryCache(true).override(i2, i3));
    }
}
