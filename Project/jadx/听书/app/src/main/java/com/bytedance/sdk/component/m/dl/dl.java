package com.bytedance.sdk.component.m.dl;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.m.a.fo;
import com.bytedance.sdk.component.m.h;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.m.tb;
import com.bytedance.sdk.component.m.uy;
import com.bytedance.sdk.component.m.v;
import com.bytedance.sdk.component.m.wp;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f762a;
    private String dl;
    private Bitmap.Config e;
    private int fo;
    private Queue<fo> fv;
    private String g;
    private io gc;
    private boolean gk;
    private int gz;
    private ExecutorService h;
    private int hh;
    private volatile boolean i;
    private com.bytedance.sdk.component.m.dl.z io;
    private int iq;
    private final Handler js;
    private int kb;
    private boolean l;
    private h ls;
    private ImageView.ScaleType m;
    private int p;
    private boolean pf;
    private com.bytedance.sdk.component.m.gz q;
    private int sy;
    private boolean tb;
    private com.bytedance.sdk.component.m.g uf;
    private uy uy;
    private boolean v;
    private WeakReference<ImageView> wp;
    private tb x;
    Future<?> z;
    private m zw;

    private dl(g gVar) {
        this.fv = new LinkedBlockingQueue();
        this.js = new Handler(Looper.getMainLooper());
        this.tb = true;
        this.g = gVar.f763a;
        this.gc = new z(gVar.z);
        this.wp = new WeakReference<>(gVar.g);
        this.m = gVar.gc;
        this.e = gVar.m;
        this.gz = gVar.e;
        this.fo = gVar.gz;
        this.kb = gVar.fo;
        this.p = gVar.uy;
        this.ls = gVar.kb;
        this.uf = z(gVar);
        if (!TextUtils.isEmpty(gVar.dl)) {
            g(gVar.dl);
            z(gVar.dl);
        }
        this.v = gVar.wp;
        this.pf = gVar.i;
        this.zw = gVar.ls;
        this.uy = gVar.p;
        this.hh = gVar.js;
        this.sy = gVar.fv;
        this.h = gVar.q;
        this.l = gVar.tb;
        this.gk = gVar.iq;
        this.x = gVar.zw;
        this.fv.add(new com.bytedance.sdk.component.m.a.dl());
    }

    private com.bytedance.sdk.component.m.g z(g gVar) {
        if (gVar.pf != null) {
            return gVar.pf;
        }
        if (!TextUtils.isEmpty(gVar.v)) {
            return com.bytedance.sdk.component.m.dl.z.z.z(new File(gVar.v));
        }
        return com.bytedance.sdk.component.m.dl.z.z.z();
    }

    public int z() {
        return this.sy;
    }

    public int g() {
        return this.hh;
    }

    @Override // com.bytedance.sdk.component.m.wp
    public String getUrl() {
        return this.g;
    }

    public io dl() {
        return this.gc;
    }

    @Override // com.bytedance.sdk.component.m.wp
    public String getRawCacheKey() {
        return this.f762a;
    }

    public void z(String str) {
        this.f762a = str;
    }

    @Override // com.bytedance.sdk.component.m.wp
    public String getMemoryCacheKey() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.component.m.wp
    public Bitmap.Config getBitmapConfig() {
        return this.e;
    }

    public void g(String str) {
        WeakReference<ImageView> weakReference = this.wp;
        if (weakReference != null && weakReference.get() != null) {
            this.wp.get().setTag(1094453505, str);
        }
        this.dl = str;
    }

    @Override // com.bytedance.sdk.component.m.wp
    public ImageView.ScaleType getScaleType() {
        return this.m;
    }

    public Bitmap.Config a() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.m.wp
    public int getWidth() {
        return this.gz;
    }

    @Override // com.bytedance.sdk.component.m.wp
    public int getHeight() {
        return this.fo;
    }

    public int gc() {
        return this.kb;
    }

    public boolean m() {
        return this.v;
    }

    public boolean e() {
        return this.pf;
    }

    public void z(boolean z2) {
        this.tb = z2;
    }

    public boolean gz() {
        return this.tb;
    }

    public com.bytedance.sdk.component.m.gz fo() {
        return this.q;
    }

    public void z(com.bytedance.sdk.component.m.gz gzVar) {
        this.q = gzVar;
    }

    public int uy() {
        return this.iq;
    }

    public void z(int i) {
        this.iq = i;
    }

    public com.bytedance.sdk.component.m.dl.z kb() {
        return this.io;
    }

    public void z(com.bytedance.sdk.component.m.dl.z zVar) {
        this.io = zVar;
    }

    public m wp() {
        return this.zw;
    }

    public com.bytedance.sdk.component.m.g i() {
        return this.uf;
    }

    public boolean z(fo foVar) {
        if (this.i) {
            return false;
        }
        return this.fv.add(foVar);
    }

    public boolean v() {
        return this.l;
    }

    public tb pf() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public wp p() {
        m mVar;
        try {
            mVar = this.zw;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.a("ImageRequest", e.getMessage());
        }
        if (mVar == null) {
            io ioVar = this.gc;
            if (ioVar != null) {
                ioVar.onFailed(1005, "not init !", null);
            }
            return this;
        }
        ExecutorService executorServiceM = this.h == null ? mVar.m() : null;
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.m.dl.dl.1
            @Override // java.lang.Runnable
            public void run() {
                fo foVar;
                while (!dl.this.i && (foVar = (fo) dl.this.fv.poll()) != null) {
                    try {
                        if (dl.this.ls != null) {
                            dl.this.ls.onStepStart(foVar.z(), dl.this);
                        }
                        foVar.z(dl.this);
                        if (dl.this.ls != null) {
                            dl.this.ls.onStepEnd(foVar.z(), dl.this);
                        }
                    } catch (Throwable th) {
                        dl.this.z(2000, th.getMessage(), th);
                        if (dl.this.ls != null) {
                            dl.this.ls.onStepEnd("exception", dl.this);
                            return;
                        }
                        return;
                    }
                }
                if (dl.this.i) {
                    dl.this.z(1003, "canceled", null);
                }
            }
        };
        if (this.gk) {
            runnable.run();
        } else {
            ExecutorService executorService = this.h;
            if (executorService != null) {
                this.z = executorService.submit(runnable);
            } else if (executorServiceM != null) {
                this.z = executorServiceM.submit(runnable);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str, Throwable th) {
        new com.bytedance.sdk.component.m.a.gz(i, str, th).z(this);
        this.fv.clear();
    }

    @Override // com.bytedance.sdk.component.m.wp
    public boolean cancelRequest() {
        this.i = true;
        Future<?> future = this.z;
        if (future != null) {
            return future.cancel(true);
        }
        return true;
    }

    public String ls() {
        return getRawCacheKey();
    }

    public static class g implements v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f763a;
        private String dl;
        private int e;
        private int fv;
        private ImageView g;
        private ImageView.ScaleType gc;
        private int gz;
        private boolean i;
        private boolean iq;
        private int js;
        private h kb;
        private m ls;
        private Bitmap.Config m;
        private uy p;
        private com.bytedance.sdk.component.m.g pf;
        private ExecutorService q;
        private boolean tb;
        private String v;
        private boolean wp;
        private io z;
        private tb zw;
        private int fo = 1;
        private int uy = 5;

        public g(m mVar) {
            this.ls = mVar;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v from(String str) {
            this.f763a = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v key(String str) {
            this.dl = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v cache(com.bytedance.sdk.component.m.g gVar) {
            this.pf = gVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v scaleType(ImageView.ScaleType scaleType) {
            this.gc = scaleType;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v config(Bitmap.Config config) {
            this.m = config;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v width(int i) {
            this.e = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v height(int i) {
            this.gz = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v type(int i) {
            this.fo = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v track(h hVar) {
            this.kb = hVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v headers(boolean z) {
            this.wp = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v requestTime(boolean z) {
            this.i = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v runIn(ExecutorService executorService) {
            this.q = executorService;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v cacheDir(String str) {
            this.v = str;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public wp to(io ioVar, int i) {
            this.uy = i;
            return to(ioVar);
        }

        @Override // com.bytedance.sdk.component.m.v
        public wp to(io ioVar) {
            this.z = ioVar;
            return new dl(this).p();
        }

        @Override // com.bytedance.sdk.component.m.v
        public wp to(ImageView imageView) {
            this.g = imageView;
            return new dl(this).p();
        }

        @Override // com.bytedance.sdk.component.m.v
        public v converter(uy uyVar) {
            this.p = uyVar;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v maxWidth(int i) {
            this.fv = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v maxHeight(int i) {
            this.js = i;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v sync(boolean z) {
            this.iq = z;
            return this;
        }

        @Override // com.bytedance.sdk.component.m.v
        public v loadSetp(tb tbVar) {
            this.zw = tbVar;
            return this;
        }
    }

    private class z implements io {
        private io g;

        public z(io ioVar) {
            this.g = ioVar;
        }

        @Override // com.bytedance.sdk.component.m.io
        public void onSuccess(final ls lsVar) {
            final ImageView imageView = (ImageView) dl.this.wp.get();
            if (imageView != null && dl.this.kb != 3 && z(imageView) && (lsVar.getResult() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) lsVar.getResult();
                dl.this.js.post(new Runnable() { // from class: com.bytedance.sdk.component.m.dl.dl.z.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (dl.this.uy != null && (lsVar.getResult() instanceof Bitmap)) {
                    uy uyVar = dl.this.uy;
                    Bitmap bitmap2 = (Bitmap) lsVar.getResult();
                    Bitmap bitmapCoverterTo = uyVar.coverterTo(bitmap2);
                    if (bitmapCoverterTo != null) {
                        lsVar.setResult(bitmapCoverterTo);
                    }
                }
            } catch (Throwable unused) {
            }
            if (dl.this.p == 5) {
                dl.this.js.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.component.m.dl.dl.z.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z.this.g != null) {
                            z.this.g.onSuccess(lsVar);
                        }
                    }
                });
                return;
            }
            io ioVar = this.g;
            if (ioVar != null) {
                ioVar.onSuccess(lsVar);
            }
        }

        private boolean z(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(dl.this.dl)) ? false : true;
        }

        @Override // com.bytedance.sdk.component.m.io
        public void onFailed(final int i, final String str, final Throwable th) {
            if (dl.this.p == 5) {
                dl.this.js.post(new Runnable() { // from class: com.bytedance.sdk.component.m.dl.dl.z.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z.this.g != null) {
                            z.this.g.onFailed(i, str, th);
                        }
                    }
                });
                return;
            }
            io ioVar = this.g;
            if (ioVar != null) {
                ioVar.onFailed(i, str, th);
            }
        }
    }
}
