package com.bytedance.adsdk.z.z.z;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.adsdk.z.z.g.e;
import com.bytedance.adsdk.z.z.g.m;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes2.dex */
public abstract class fo<R extends com.bytedance.adsdk.z.z.g.m, W extends com.bytedance.adsdk.z.z.g.e> {
    private static final String e = "fo";
    private static final Rect v = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<Bitmap, Canvas> f281a;
    protected int dl;
    private final Handler fo;
    private W fv;
    protected ByteBuffer gc;
    private final com.bytedance.adsdk.z.z.dl.g gz;
    private final AtomicBoolean i;
    private R js;
    private final Set<Bitmap> ls;
    protected volatile Rect m;
    private final Object p;
    private final Runnable pf;
    private volatile g q;
    private boolean tb;
    private int uy;
    private final Set<z> wp;
    protected List<gz<R, W>> z = new ArrayList();
    protected int g = -1;
    private Integer kb = null;

    private enum g {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    public interface z {
        void g();

        void g(ByteBuffer byteBuffer);

        void z();
    }

    private String pf() {
        return "";
    }

    protected abstract W a();

    protected abstract R dl(com.bytedance.adsdk.z.z.g.m mVar);

    protected abstract void dl();

    protected abstract int g();

    protected abstract Rect g(R r) throws IOException;

    protected abstract void z(gz<R, W> gzVar);

    protected Bitmap z(int i, int i2) {
        synchronized (this.p) {
            Iterator<Bitmap> it = this.ls.iterator();
            Bitmap bitmapCreateBitmap = null;
            while (it.hasNext()) {
                int i3 = i * i2 * 4;
                Bitmap next = it.next();
                if (next != null && next.getAllocationByteCount() >= i3) {
                    it.remove();
                    if ((next.getWidth() != i || next.getHeight() != i2) && i > 0 && i2 > 0) {
                        next.reconfigure(i, i2, Bitmap.Config.ARGB_4444);
                    }
                    next.eraseColor(0);
                    return next;
                }
                bitmapCreateBitmap = next;
            }
            if (i <= 0 || i2 <= 0) {
                return null;
            }
            try {
                bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_4444);
            } catch (Exception e2) {
                com.bytedance.sdk.component.utils.wp.z(e2);
            } catch (OutOfMemoryError e3) {
                com.bytedance.sdk.component.utils.wp.z(e3);
            }
            return bitmapCreateBitmap;
        }
    }

    protected void z(Bitmap bitmap) {
        synchronized (this.p) {
            if (bitmap != null) {
                this.ls.add(bitmap);
            }
        }
    }

    public fo(com.bytedance.adsdk.z.z.dl.g gVar, z zVar) {
        HashSet hashSet = new HashSet();
        this.wp = hashSet;
        this.i = new AtomicBoolean(true);
        this.pf = new Runnable() { // from class: com.bytedance.adsdk.z.z.z.fo.1
            @Override // java.lang.Runnable
            public void run() {
                if (fo.this.i.get()) {
                    return;
                }
                if (fo.this.p()) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    fo.this.fo.postDelayed(this, Math.max(0L, fo.this.fv() - (System.currentTimeMillis() - jCurrentTimeMillis)));
                    Iterator it = fo.this.wp.iterator();
                    while (it.hasNext()) {
                        ((z) it.next()).g(fo.this.gc);
                    }
                    return;
                }
                fo.this.fo();
            }
        };
        this.dl = 1;
        this.ls = new HashSet();
        this.p = new Object();
        this.f281a = new WeakHashMap();
        this.fv = (W) a();
        this.js = null;
        this.tb = false;
        this.q = g.IDLE;
        this.gz = gVar;
        if (zVar != null) {
            hashSet.add(zVar);
        }
        this.fo = com.bytedance.sdk.component.uy.g.z.z().g();
    }

    public void z(final z zVar) {
        this.fo.post(new Runnable() { // from class: com.bytedance.adsdk.z.z.z.fo.2
            @Override // java.lang.Runnable
            public void run() {
                fo.this.wp.add(zVar);
            }
        });
    }

    public void g(final z zVar) {
        this.fo.post(new Runnable() { // from class: com.bytedance.adsdk.z.z.z.fo.3
            @Override // java.lang.Runnable
            public void run() {
                fo.this.wp.remove(zVar);
            }
        });
    }

    public void gc() {
        this.fo.post(new Runnable() { // from class: com.bytedance.adsdk.z.z.z.fo.4
            @Override // java.lang.Runnable
            public void run() {
                if (fo.this.wp.size() == 0) {
                    fo.this.fo();
                }
            }
        });
    }

    public Rect m() {
        if (this.m == null) {
            if (this.q == g.FINISHING) {
                com.bytedance.sdk.component.utils.wp.a(e, "In finishing,do not interrupt");
            }
            final Thread threadCurrentThread = Thread.currentThread();
            this.fo.post(new Runnable() { // from class: com.bytedance.adsdk.z.z.z.fo.5
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            if (fo.this.m == null) {
                                if (fo.this.js != null) {
                                    fo.this.js.d_();
                                } else {
                                    fo foVar = fo.this;
                                    foVar.js = foVar.dl(foVar.gz.g());
                                }
                                fo foVar2 = fo.this;
                                foVar2.z(foVar2.g(foVar2.js));
                            }
                        } catch (Exception e2) {
                            com.bytedance.sdk.component.utils.wp.z(e2);
                            fo.this.m = fo.v;
                        }
                    } finally {
                        LockSupport.unpark(threadCurrentThread);
                    }
                }
            });
            LockSupport.park(threadCurrentThread);
        }
        return this.m == null ? v : this.m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Rect rect) {
        this.m = rect;
        int iWidth = rect.width() * rect.height();
        int i = this.dl;
        this.gc = ByteBuffer.allocate(((iWidth / (i * i)) + 1) * 4);
        if (this.fv == null) {
            this.fv = (W) a();
        }
    }

    public int e() {
        return this.z.size();
    }

    public void gz() {
        if (this.m == v) {
            return;
        }
        if (this.q == g.RUNNING || this.q == g.INITIALIZING) {
            com.bytedance.sdk.component.utils.wp.z(e, pf() + " Already started");
            return;
        }
        if (this.q == g.FINISHING) {
            com.bytedance.sdk.component.utils.wp.a(e, pf() + " Processing,wait for finish at " + this.q);
        }
        this.q = g.INITIALIZING;
        if (Looper.myLooper() == this.fo.getLooper()) {
            z();
        } else {
            this.fo.post(new Runnable() { // from class: com.bytedance.adsdk.z.z.z.fo.6
                @Override // java.lang.Runnable
                public void run() {
                    fo.this.z();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.i.compareAndSet(true, false);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (this.z.size() == 0) {
                try {
                    R r = this.js;
                    if (r == null) {
                        this.js = (R) dl(this.gz.g());
                    } else {
                        r.d_();
                    }
                    z(g(this.js));
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.wp.z(th);
                }
            }
            String str = e;
            com.bytedance.sdk.component.utils.wp.z(str, pf() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.q = g.RUNNING;
            if (ls() == 0 || !this.tb) {
                this.g = -1;
                this.pf.run();
                Iterator<z> it = this.wp.iterator();
                while (it.hasNext()) {
                    it.next().z();
                }
                return;
            }
            com.bytedance.sdk.component.utils.wp.z(str, pf() + " No need to started");
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.wp.z(e, pf() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - jCurrentTimeMillis));
            this.q = g.RUNNING;
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.fo.removeCallbacks(this.pf);
        this.z.clear();
        synchronized (this.p) {
            for (Bitmap bitmap : this.ls) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
            this.ls.clear();
        }
        if (this.gc != null) {
            this.gc = null;
        }
        this.f281a.clear();
        try {
            if (this.js != null) {
                this.js = null;
            }
        } catch (IOException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        dl();
        this.q = g.IDLE;
        Iterator<z> it = this.wp.iterator();
        while (it.hasNext()) {
            it.next().g();
        }
    }

    public void fo() {
        if (this.m == v) {
            return;
        }
        if (this.q == g.FINISHING || this.q == g.IDLE) {
            com.bytedance.sdk.component.utils.wp.z(e, pf() + "No need to stop");
            return;
        }
        if (this.q == g.INITIALIZING) {
            com.bytedance.sdk.component.utils.wp.a(e, pf() + "Processing,wait for finish at " + this.q);
        }
        this.q = g.FINISHING;
        if (Looper.myLooper() == this.fo.getLooper()) {
            v();
        } else {
            this.fo.post(new Runnable() { // from class: com.bytedance.adsdk.z.z.z.fo.7
                @Override // java.lang.Runnable
                public void run() {
                    fo.this.v();
                }
            });
        }
    }

    public boolean uy() {
        return this.q == g.RUNNING || this.q == g.INITIALIZING;
    }

    public void kb() {
        this.fo.post(new Runnable() { // from class: com.bytedance.adsdk.z.z.z.fo.8
            @Override // java.lang.Runnable
            public void run() {
                fo.this.uy = 0;
                fo.this.g = -1;
                fo.this.tb = false;
            }
        });
    }

    public int wp() {
        return this.dl;
    }

    public boolean g(int i, int i2) {
        final int iDl = dl(i, i2);
        if (iDl == this.dl) {
            return false;
        }
        final boolean zUy = uy();
        this.fo.removeCallbacks(this.pf);
        this.fo.post(new Runnable() { // from class: com.bytedance.adsdk.z.z.z.fo.9
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                fo.this.v();
                try {
                    fo.this.dl = iDl;
                    fo foVar = fo.this;
                    foVar.z(foVar.g(foVar.dl(foVar.gz.g())));
                    if (zUy) {
                        fo.this.z();
                    }
                } catch (IOException e2) {
                    com.bytedance.sdk.component.utils.wp.z(e2);
                }
            }
        });
        return true;
    }

    protected int dl(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int iMin = Math.min(m().width() / i, m().height() / i2);
            while (true) {
                int i4 = i3 * 2;
                if (i4 > iMin) {
                    break;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    private int ls() {
        Integer num = this.kb;
        return num != null ? num.intValue() : g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        if (!uy() || this.z.size() == 0) {
            return false;
        }
        if (ls() <= 0 || this.uy < ls() - 1) {
            return true;
        }
        if (this.uy == ls() - 1 && this.g < e() - 1) {
            return true;
        }
        this.tb = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long fv() {
        int i = this.g + 1;
        this.g = i;
        if (i >= e()) {
            this.g = 0;
            this.uy++;
        }
        gz<R, W> gzVarZ = z(this.g);
        if (gzVarZ == null) {
            return 0L;
        }
        z(gzVarZ);
        return gzVarZ.wp;
    }

    public gz<R, W> z(int i) {
        if (i < 0 || i >= this.z.size()) {
            return null;
        }
        return this.z.get(i);
    }
}
