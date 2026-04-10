package com.bykv.vk.openvk.component.video.z.a;

import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.z;
import com.bykv.vk.openvk.component.video.z.a.dl;
import com.bytedance.sdk.component.utils.l;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.bykv.vk.openvk.component.video.api.z, dl.a, dl.InterfaceC0030dl, dl.e, dl.g, dl.gc, dl.m, dl.z, l.z {
    private SurfaceHolder dl;
    private SurfaceTexture g;
    private int gc;
    private boolean hh;
    private boolean iq;
    private boolean kb;
    private boolean uy;
    private volatile l v;
    private volatile boolean wj;
    private ArrayList<Runnable> zw;
    private static final AtomicInteger z = new AtomicInteger(0);
    private static final SparseIntArray sy = new SparseIntArray();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f100a = 0;
    private boolean m = false;
    private volatile dl e = null;
    private final boolean gz = false;
    private boolean fo = false;
    private volatile int wp = 201;
    private long i = -1;
    private volatile boolean pf = false;
    private boolean ls = false;
    private long p = 0;
    private long fv = Long.MIN_VALUE;
    private long js = 0;
    private long tb = 0;
    private long q = 0;
    private int io = 0;
    private String uf = "0";
    private final List<WeakReference<z.InterfaceC0029z>> l = new CopyOnWriteArrayList();
    private com.bykv.vk.openvk.component.video.api.dl.a h = null;
    private boolean gk = false;
    private volatile int x = 200;
    private AtomicBoolean lq = new AtomicBoolean(false);
    private AtomicBoolean mc = new AtomicBoolean(false);
    private AtomicBoolean un = new AtomicBoolean(false);
    private Surface ti = null;
    private final Runnable eo = new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.e == null) {
                return;
            }
            long jJs = a.this.js();
            if (jJs > 0 && a.this.i() && a.this.fv != Long.MIN_VALUE) {
                try {
                    if (a.this.fv == jJs) {
                        if (!a.this.ls && a.this.js >= 400) {
                            a.this.g(701, 800);
                            a.this.ls = true;
                        }
                        a.this.js += (long) a.this.x;
                    } else {
                        if (a.this.ls) {
                            a.this.p += a.this.js;
                            a.this.g(702, 800);
                            com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "handleMsg:  bufferingDuration =", Long.valueOf(a.this.p), "  bufferCount =", Integer.valueOf(a.this.f100a));
                        }
                        a.this.js = 0L;
                        a.this.ls = false;
                    }
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "error:" + th.getMessage());
                }
            }
            if (a.this.fv() > 0) {
                if (a.this.fv != jJs) {
                    if (com.bykv.vk.openvk.component.video.api.dl.a()) {
                        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "run: lastCur = ", Long.valueOf(a.this.fv), "  curPosition = ", Long.valueOf(jJs));
                    }
                    a aVar = a.this;
                    aVar.z(jJs, aVar.fv());
                }
                a.this.fv = jJs;
            }
            if (!a.this.fo()) {
                if (a.this.v != null) {
                    a.this.v.postDelayed(this, a.this.x);
                }
            } else {
                a aVar2 = a.this;
                aVar2.z(aVar2.fv(), a.this.fv());
            }
        }
    };
    private final z oq = new z();
    private long na = 0;
    private long xl = 0;
    private boolean j = false;

    private boolean z(int i, int i2) {
        boolean z2 = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, long j2) {
        for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().z(this, j, j2);
            }
        }
    }

    public a(String str) {
        z("mda_" + str + "_" + z.addAndGet(1), (Looper) null);
    }

    private void z(String str, Looper looper) {
        this.io = 0;
        if (looper != null) {
            this.pf = true;
            this.v = new l(looper, this);
        } else if (this.v == null) {
            this.v = com.bytedance.sdk.component.uy.g.z.z().z(this, "csj_" + str);
        }
        this.j = true;
        zw();
    }

    private void iq() {
        this.p = 0L;
        this.f100a = 0;
        this.js = 0L;
        this.ls = false;
        this.fv = Long.MIN_VALUE;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(final boolean z2) {
        if (pf()) {
            return;
        }
        this.hh = z2;
        if (this.e != null) {
            this.e.z(z2);
        } else if (this.v != null) {
            this.v.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.11
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        a.this.e.z(z2);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        if (this.v != null) {
            this.v.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.12
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e == null) {
                        try {
                            a.this.e = new g();
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO_MEDIA", th.getMessage());
                        }
                        if (a.this.e == null) {
                            return;
                        }
                        dl unused = a.this.e;
                        a.this.uf = "0";
                        a.this.e.z((dl.gc) a.this);
                        a.this.e.z((dl.g) a.this);
                        a.this.e.z((dl.InterfaceC0030dl) a.this);
                        a.this.e.z((dl.z) a.this);
                        a.this.e.z((dl.m) a.this);
                        a.this.e.z((dl.a) a.this);
                        a.this.e.z((dl.e) a.this);
                        try {
                            a.this.e.dl(false);
                        } catch (Throwable unused2) {
                        }
                        a.this.fo = false;
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z() {
        if (pf() || this.e == null) {
            return;
        }
        if (this.wp != 206) {
            iq();
            this.wj = false;
            this.oq.z(true);
            g(0L);
            if (this.v != null) {
                this.v.removeCallbacks(this.eo);
                this.v.postDelayed(this.eo, this.x);
            }
        }
        this.lq.set(true);
        if ((this.mc.get() || this.un.get()) && this.v != null) {
            this.v.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.13
                @Override // java.lang.Runnable
                public void run() {
                    a.this.x();
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(boolean z2, long j, boolean z3) {
        if (pf()) {
            return;
        }
        zw();
        this.gk = z3;
        this.wj = false;
        z(z3);
        if (z2) {
            this.i = j;
            io();
        } else {
            g(j);
        }
        if (this.v != null) {
            this.v.removeCallbacks(this.eo);
            this.v.postDelayed(this.eo, this.x);
        }
        this.lq.set(true);
        if ((this.mc.get() || this.un.get()) && this.v != null) {
            this.v.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.14
                @Override // java.lang.Runnable
                public void run() {
                    a.this.x();
                }
            });
        }
    }

    private void g(long j) {
        this.oq.z(j);
        if (this.hh) {
            g(this.oq);
        } else if (g(this.h)) {
            g(this.oq);
        } else {
            z(this.oq);
        }
    }

    private boolean g(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        return aVar != null && aVar.e();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g() {
        if (pf() || this.v == null) {
            return;
        }
        this.lq.set(true);
        this.v.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.15
            @Override // java.lang.Runnable
            public void run() {
                if (!a.this.v() || a.this.e == null) {
                    return;
                }
                try {
                    a.this.e.gc();
                    com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "resume play exec start ");
                    for (WeakReference weakReference : a.this.l) {
                        if (weakReference != null && weakReference.get() != null) {
                            weakReference.get();
                        }
                    }
                    a.this.wp = 206;
                } catch (Throwable th) {
                    com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "play: catch exception ", th.getMessage());
                }
            }
        });
    }

    class z implements Runnable {
        private boolean dl;
        private long g;

        z() {
        }

        public void z(boolean z) {
            this.dl = z;
        }

        public void z(long j) {
            this.g = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.e != null) {
                try {
                    if (!this.dl) {
                        long jFo = a.this.e.fo();
                        a.this.i = Math.max(this.g, jFo);
                    }
                    long unused = a.this.i;
                } catch (Throwable unused2) {
                }
            }
            if (a.this.v != null) {
                a.this.v.sendEmptyMessageDelayed(100, 0L);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl() {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "pause: from outer");
        if (pf() || this.v == null) {
            return;
        }
        this.v.removeMessages(100);
        this.wj = true;
        if (!this.j) {
            if (this.iq || g(this.h)) {
                if (this.v != null) {
                    this.v.sendEmptyMessage(101);
                    return;
                }
                return;
            }
            z(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.16
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.v != null) {
                        a.this.v.sendEmptyMessage(101);
                    }
                }
            });
            return;
        }
        if (this.m || g(this.h)) {
            if (this.v != null) {
                this.v.sendEmptyMessage(101);
                return;
            }
            return;
        }
        z(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.17
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.v != null) {
                    a.this.v.sendEmptyMessage(101);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void gc() {
        if (pf()) {
            return;
        }
        this.kb = true;
        lq();
        if (this.v != null) {
            try {
                this.v.removeCallbacksAndMessages(null);
                if (this.e != null) {
                    this.v.sendEmptyMessage(103);
                }
                sy();
            } catch (Throwable unused) {
                sy();
            }
        }
    }

    private void io() {
        g(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.v != null) {
                    a.this.v.sendEmptyMessage(104);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void a() {
        if (pf()) {
            return;
        }
        g(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.v != null) {
                    a.this.v.sendEmptyMessage(105);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(final long j) {
        if (pf()) {
            return;
        }
        if (this.wp == 207 || this.wp == 206 || this.wp == 209) {
            g(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.4
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.v != null) {
                        a.this.v.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean m() {
        return this.m;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(final SurfaceTexture surfaceTexture) {
        if (pf()) {
            return;
        }
        this.g = surfaceTexture;
        g(true);
        g(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                a.this.zw();
                if (a.this.v != null) {
                    a.this.v.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(final SurfaceHolder surfaceHolder) {
        if (pf()) {
            return;
        }
        this.dl = surfaceHolder;
        g(true);
        g(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                a.this.zw();
                if (a.this.v != null) {
                    a.this.v.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public int tb() {
        if (pf()) {
            return 203;
        }
        return this.wp;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(final com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        if (pf()) {
            return;
        }
        this.h = aVar;
        if (aVar != null) {
            this.j = this.j && !aVar.e();
        }
        g(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.7
            @Override // java.lang.Runnable
            public void run() {
                a.this.zw();
                if (a.this.v != null) {
                    a.this.v.obtainMessage(107, aVar).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean i() {
        return (this.wp == 206 || (this.v != null && this.v.hasMessages(100))) && !this.wj;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean uy() {
        return q() || i() || v();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean v() {
        return ((this.wp != 207 && !this.wj) || this.v == null || this.v.hasMessages(100)) ? false : true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean pf() {
        return this.kb;
    }

    public boolean q() {
        return this.wp == 205;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean fo() {
        return this.wp == 209;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0112  */
    @Override // com.bytedance.sdk.component.utils.l.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(android.os.Message r17) {
        /*
            Method dump skipped, instruction units count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.z.a.a.z(android.os.Message):void");
    }

    private void z(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.e.z(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void uf() {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "releaseMediaPlayer: ");
        if (this.e == null) {
            return;
        }
        try {
            this.e.wp();
        } catch (Throwable unused) {
        }
        this.e.z((dl.g) null);
        this.e.z((dl.e) null);
        this.e.z((dl.z) null);
        this.e.z((dl.a) null);
        this.e.z((dl.InterfaceC0030dl) null);
        this.e.z((dl.gc) null);
        this.e.z((dl.m) null);
        try {
            this.e.kb();
        } catch (Throwable unused2) {
        }
    }

    private void sy() {
        l lVar = this.v;
        if (lVar == null || lVar.getLooper() == null) {
            return;
        }
        lVar.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.8
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.v == null || a.this.v.getLooper() == null) {
                    return;
                }
                try {
                    if (a.this.pf) {
                        a.this.v.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.uy.g.z.z().z(a.this.v);
                    }
                    a.this.v = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl.z
    public void z(dl dlVar, int i) {
        if (this.e != dlVar) {
            return;
        }
        for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().g(this, i);
            }
        }
    }

    private void hh() {
        SparseIntArray sparseIntArray = sy;
        Integer numValueOf = Integer.valueOf(sparseIntArray.get(this.io));
        if (numValueOf == null) {
            sparseIntArray.put(this.io, 1);
        } else {
            sparseIntArray.put(this.io, numValueOf.intValue() + 1);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl.g
    public void z(dl dlVar) {
        this.wp = 209;
        sy.delete(this.io);
        if (this.v != null) {
            this.v.removeCallbacks(this.eo);
        }
        for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().z(this);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl.InterfaceC0030dl
    public boolean z(dl dlVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO_MEDIA", "what=" + i + "extra=" + i2);
        hh();
        this.wp = 200;
        if (this.v != null) {
            this.v.removeCallbacks(this.eo);
        }
        if (z(i, i2)) {
            sy();
        }
        if (!this.lq.get()) {
            return true;
        }
        this.lq.set(false);
        com.bykv.vk.openvk.component.video.api.dl.g gVar = new com.bykv.vk.openvk.component.video.api.dl.g(i, i2);
        for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().z(this, gVar);
            }
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl.a
    public boolean g(dl dlVar, int i, int i2) {
        com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO_MEDIA", "what,extra:" + i + "," + i2);
        if (this.e != dlVar) {
            return false;
        }
        if (i2 == -1004) {
            com.bykv.vk.openvk.component.video.api.dl.g gVar = new com.bykv.vk.openvk.component.video.api.dl.g(i, i2);
            for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().z(this, gVar);
                }
            }
        }
        g(i, i2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, int i2) {
        if (i == 701) {
            this.na = SystemClock.elapsedRealtime();
            this.f100a++;
            for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().z(this, Integer.MAX_VALUE, 0, 0);
                }
            }
            com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.f100a));
            return;
        }
        if (i == 702) {
            if (this.na > 0) {
                this.xl += SystemClock.elapsedRealtime() - this.na;
                this.na = 0L;
            }
            for (WeakReference<z.InterfaceC0029z> weakReference2 : this.l) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    weakReference2.get().z((com.bykv.vk.openvk.component.video.api.z) this, Integer.MAX_VALUE);
                }
            }
            com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "bufferCount = ", Integer.valueOf(this.f100a), " mBufferTotalTime = ", Long.valueOf(this.xl));
            return;
        }
        if (this.j && i == 3) {
            com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "hasPendingPauseCommand:" + this.wj);
            x();
            l();
            z(this.gk);
            com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "onRenderStart");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl.gc
    public void g(dl dlVar) {
        if (pf()) {
            return;
        }
        this.wp = 205;
        try {
            com.bykv.vk.openvk.component.video.api.dl.a aVar = this.h;
            if (aVar != null) {
                float fPf = aVar.pf();
                if (fPf > 0.0f) {
                    com.bykv.vk.openvk.component.video.api.g gVar = new com.bykv.vk.openvk.component.video.api.g();
                    gVar.z(fPf);
                    this.e.z(gVar);
                }
            }
        } catch (Throwable unused) {
        }
        if (this.v != null) {
            if (this.wj) {
                h();
            } else {
                com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO_MEDIA", "onPrepared op_Start");
                this.v.sendMessage(this.v.obtainMessage(100, -1, -1));
            }
        }
        sy.delete(this.io);
        com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO_MEDIA", "onPrepared:" + this.j + " " + this.iq);
        if (!this.j && !this.iq) {
            l();
            this.iq = true;
        }
        for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().g(this);
            }
        }
    }

    private void l() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.q;
        for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().z(this, jElapsedRealtime);
            }
        }
        this.m = true;
    }

    private void h() {
        if (this.v != null) {
            this.v.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.e.e();
                        a.this.wp = 207;
                        a.this.wj = false;
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl.m
    public void dl(dl dlVar) {
        for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().z((com.bykv.vk.openvk.component.video.api.z) this, true);
            }
        }
    }

    private void z(Runnable runnable) {
        try {
            if (this.zw == null) {
                this.zw = new ArrayList<>();
            }
            this.zw.add(runnable);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO_MEDIA", th.getMessage());
        }
    }

    private void gk() {
        if (this.uy) {
            return;
        }
        this.uy = true;
        Iterator it = new ArrayList(this.zw).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.zw.clear();
        this.uy = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ArrayList<Runnable> arrayList = this.zw;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        gk();
    }

    private void lq() {
        ArrayList<Runnable> arrayList = this.zw;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.zw.clear();
    }

    private void g(Runnable runnable) {
        if (runnable == null || pf()) {
            return;
        }
        if (!this.kb) {
            runnable.run();
        } else {
            z(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(final boolean z2) {
        if (pf()) {
            return;
        }
        if (this.v == null) {
            com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_MEDIA", "quietPlay set opHandler is null");
        } else {
            this.v.post(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.a.a.10
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.pf() || a.this.e == null) {
                        return;
                    }
                    try {
                        a.this.gk = z2;
                        a.this.e.a(z2);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long ls() {
        if (this.ls) {
            long j = this.js;
            if (j > 0) {
                return this.p + j;
            }
        }
        return this.p;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int kb() {
        if (this.e == null || pf()) {
            return 0;
        }
        return this.e.i();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int wp() {
        if (this.e == null || pf()) {
            return 0;
        }
        return this.e.v();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int p() {
        return this.f100a;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl.e
    public void z(dl dlVar, int i, int i2, int i3, int i4) {
        for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().z((com.bykv.vk.openvk.component.video.api.z) this, i, i2);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long fv() {
        long j = this.tb;
        if (j != 0) {
            return j;
        }
        if (this.wp == 206 || this.wp == 207) {
            try {
                this.tb = this.e.uy();
            } catch (Throwable unused) {
            }
        }
        return this.tb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long js() {
        if (pf()) {
            return 0L;
        }
        if (this.wp == 206 || this.wp == 207) {
            try {
                return this.e.fo();
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl(boolean z2) {
        if (pf()) {
            return;
        }
        this.e.gc(z2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(z.InterfaceC0029z interfaceC0029z) {
        if (interfaceC0029z == null) {
            return;
        }
        for (WeakReference<z.InterfaceC0029z> weakReference : this.l) {
            if (weakReference != null && weakReference.get() == interfaceC0029z) {
                return;
            }
        }
        this.l.add(new WeakReference<>(interfaceC0029z));
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(int i) {
        if (pf()) {
            return;
        }
        this.x = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceHolder e() {
        return this.dl;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceTexture gz() {
        return this.g;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(int i) {
        this.gc = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(float f) {
        try {
            com.bykv.vk.openvk.component.video.api.g gVar = new com.bykv.vk.openvk.component.video.api.g();
            gVar.z(f);
            this.e.z(gVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
