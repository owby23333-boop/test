package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.v;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.z.z.g.p;
import com.ss.android.z.z.g.uf;

/* JADX INFO: loaded from: classes4.dex */
public class uy {
    private static volatile uy z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.g.z.z f2015a;
    private final gz dl;
    private final com.ss.android.z.z.z g;
    private com.ss.android.g.z.g gc;
    private long m;

    public static uy z(final Context context) {
        if (z == null) {
            synchronized (uy.class) {
                if (z == null) {
                    com.ss.android.downloadlib.gc.g.z(new Runnable() { // from class: com.ss.android.downloadlib.uy.1
                        @Override // java.lang.Runnable
                        public void run() {
                            uy unused = uy.z = new uy(context);
                        }
                    });
                }
            }
        }
        return z;
    }

    private uy(Context context) {
        this.dl = gz.z();
        this.g = new m();
        this.m = System.currentTimeMillis();
        g(context);
        this.f2015a = z.z();
    }

    private void g(Context context) {
        wp.z(context);
        com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext());
        com.ss.android.downloadlib.addownload.g.m.z().g();
        com.ss.android.socialbase.appdownloader.a.kb().z(wp.getContext(), "misc_config", new com.ss.android.downloadlib.dl.e(), new com.ss.android.downloadlib.dl.m(context), new dl());
        com.ss.android.downloadlib.dl.a aVar = new com.ss.android.downloadlib.dl.a();
        com.ss.android.socialbase.appdownloader.a.kb().z(aVar);
        com.ss.android.socialbase.downloader.downloader.e.g(context).z(aVar);
        com.ss.android.socialbase.appdownloader.a.kb().z(new v());
        com.ss.android.socialbase.downloader.downloader.dl.z(new com.ss.android.downloadlib.dl.gc());
        com.ss.android.socialbase.appdownloader.a.kb().z(com.ss.android.downloadlib.m.dl.z());
    }

    public com.ss.android.z.z.z z() {
        return this.g;
    }

    public com.ss.android.z.z.z z(String str) {
        com.ss.android.z.z.g.m mVarG = e.z().g();
        if (mVarG != null && mVarG.z(str)) {
            return mVarG.g(str);
        }
        return this.g;
    }

    public long g() {
        return this.m;
    }

    public void dl() {
        this.m = System.currentTimeMillis();
    }

    public com.ss.android.g.z.z a() {
        return this.f2015a;
    }

    public com.ss.android.g.z.g gc() {
        if (this.gc == null) {
            this.gc = g.z();
        }
        return this.gc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public gz gz() {
        return this.dl;
    }

    public void z(final Context context, final int i, final com.ss.android.z.z.dl.a aVar, final com.ss.android.z.z.dl.dl dlVar) {
        com.ss.android.downloadlib.gc.g.z(new Runnable() { // from class: com.ss.android.downloadlib.uy.4
            @Override // java.lang.Runnable
            public void run() {
                uy.this.gz().z(context, i, aVar, dlVar);
            }
        });
    }

    public void z(final String str, final long j, final int i, final com.ss.android.z.z.dl.g gVar, final com.ss.android.z.z.dl.z zVar, final uf ufVar, final p pVar) {
        com.ss.android.downloadlib.gc.g.z(new Runnable() { // from class: com.ss.android.downloadlib.uy.5
            @Override // java.lang.Runnable
            public void run() {
                uy.this.gz().z(str, j, i, gVar, zVar, ufVar, pVar);
            }
        });
    }

    public void z(final String str, final long j, final int i, final com.ss.android.z.z.dl.g gVar, final com.ss.android.z.z.dl.z zVar) {
        com.ss.android.downloadlib.gc.g.z(new Runnable() { // from class: com.ss.android.downloadlib.uy.6
            @Override // java.lang.Runnable
            public void run() {
                uy.this.gz().z(str, j, i, gVar, zVar);
            }
        });
    }

    public void z(final String str, final long j, final int i, final com.ss.android.z.z.dl.g gVar, final com.ss.android.z.z.dl.z zVar, final p pVar) {
        com.ss.android.downloadlib.gc.g.z(new Runnable() { // from class: com.ss.android.downloadlib.uy.7
            @Override // java.lang.Runnable
            public void run() {
                uy.this.gz().z(str, j, i, gVar, zVar, pVar);
            }
        });
    }

    public void z(final String str, final int i) {
        com.ss.android.downloadlib.gc.g.z(new Runnable() { // from class: com.ss.android.downloadlib.uy.2
            @Override // java.lang.Runnable
            public void run() {
                uy.this.gz().z(str, i);
            }
        });
    }

    public void z(final String str, final boolean z2) {
        com.ss.android.downloadlib.gc.g.z(new Runnable() { // from class: com.ss.android.downloadlib.uy.3
            @Override // java.lang.Runnable
            public void run() {
                uy.this.gz().z(str, z2);
            }
        });
    }

    public void z(com.ss.android.z.z.dl.z.z zVar) {
        gz().z(zVar);
    }

    public String m() {
        return wp.v();
    }

    public void e() {
        gc.z().m();
    }

    public com.ss.android.socialbase.downloader.e.dl g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.a.kb().z(wp.getContext(), str);
    }

    public com.ss.android.socialbase.downloader.e.dl z(String str, String str2, boolean z2) {
        if (TextUtils.isEmpty(str2) && z2) {
            return g(str);
        }
        return com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).g(str, str2);
    }
}
