package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.l;
import com.ss.android.socialbase.downloader.a.oq;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    private static final String z = "m";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final wp f2062a;
    private com.ss.android.socialbase.downloader.e.dl dl;
    private SparseArray<hh> e;
    private SparseArray<hh> fo;
    private final boolean g;
    private final Handler gc;
    private SparseArray<hh> gz;
    private com.ss.android.socialbase.downloader.a.pf ls;
    private com.ss.android.socialbase.downloader.e.a m;
    private l p;
    private long pf;
    private int v;
    private boolean uy = false;
    private volatile long kb = 0;
    private final AtomicLong wp = new AtomicLong();
    private boolean i = false;

    public m(com.ss.android.socialbase.downloader.e.a aVar, Handler handler) {
        this.m = aVar;
        uy();
        this.gc = handler;
        this.f2062a = dl.io();
        com.ss.android.socialbase.downloader.e.dl dlVarZ = aVar.z();
        if (dlVarZ != null) {
            this.g = com.ss.android.socialbase.downloader.i.z.z(dlVarZ.e()).z("fix_start_with_file_exist_update_error");
        } else {
            this.g = false;
        }
    }

    private void uy() {
        com.ss.android.socialbase.downloader.e.a aVar = this.m;
        if (aVar != null) {
            this.dl = aVar.z();
            this.e = this.m.z(com.ss.android.socialbase.downloader.g.gz.MAIN);
            this.fo = this.m.z(com.ss.android.socialbase.downloader.g.gz.NOTIFICATION);
            this.gz = this.m.z(com.ss.android.socialbase.downloader.g.gz.SUB);
            this.ls = this.m.a();
            this.p = this.m.gc();
        }
    }

    public void z() {
        if (this.dl.pd()) {
            return;
        }
        this.dl.a(1);
        kb();
    }

    private void kb() {
        ExecutorService executorServiceKb = dl.kb();
        if (executorServiceKb != null) {
            executorServiceKb.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.m.1
                @Override // java.lang.Runnable
                public void run() {
                    m.this.f2062a.fo(m.this.dl.e());
                    m.this.z(1, (com.ss.android.socialbase.downloader.gc.z) null);
                }
            });
        }
    }

    public void g() {
        if (this.dl.pd()) {
            this.dl.gm();
            return;
        }
        this.f2062a.e(this.dl.e());
        if (this.dl.ey()) {
            z(6, (com.ss.android.socialbase.downloader.gc.z) null);
        }
        z(2, (com.ss.android.socialbase.downloader.gc.z) null);
    }

    public void z(long j, String str, String str2) {
        this.dl.e(j);
        this.dl.gc(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.dl.gz())) {
            this.dl.m(str2);
        }
        try {
            this.f2062a.z(this.dl.e(), j, str, str2);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        z(3, (com.ss.android.socialbase.downloader.gc.z) null);
        this.pf = this.dl.gz(j);
        this.v = this.dl.vk();
        this.uy = true;
        com.ss.android.socialbase.downloader.impls.fv.z().gc();
    }

    public boolean z(long j) {
        this.wp.addAndGet(j);
        this.dl.m(j);
        long jUptimeMillis = SystemClock.uptimeMillis();
        return z(jUptimeMillis, g(jUptimeMillis));
    }

    public void dl() {
        z(-4, (com.ss.android.socialbase.downloader.gc.z) null);
    }

    public void a() {
        this.dl.a(-2);
        try {
            this.f2062a.a(this.dl.e(), this.dl.sf());
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        z(-2, (com.ss.android.socialbase.downloader.gc.z) null);
    }

    public void gc() {
        this.dl.a(-7);
        try {
            this.f2062a.uy(this.dl.e());
        } catch (SQLiteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        z(-7, (com.ss.android.socialbase.downloader.gc.z) null);
    }

    public void z(com.ss.android.socialbase.downloader.gc.z zVar, boolean z2) {
        this.dl.fo(false);
        this.wp.set(0L);
        g(zVar, z2);
    }

    public void z(com.ss.android.socialbase.downloader.e.g gVar, com.ss.android.socialbase.downloader.gc.z zVar, boolean z2) {
        this.dl.fo(false);
        this.wp.set(0L);
        this.f2062a.gz(this.dl.e());
        z(z2 ? 10 : 9, zVar, true);
    }

    public void z(com.ss.android.socialbase.downloader.gc.z zVar) {
        this.dl.fo(false);
        g(zVar);
    }

    private void g(com.ss.android.socialbase.downloader.gc.z zVar) {
        Log.getStackTraceString(new Throwable());
        if (zVar != null && zVar.getCause() != null && (zVar.getCause() instanceof SQLiteFullException)) {
            try {
                this.f2062a.m(this.dl.e());
            } catch (SQLiteException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        } else {
            try {
                try {
                    this.f2062a.g(this.dl.e(), this.dl.sf());
                } catch (SQLiteException unused) {
                    this.f2062a.m(this.dl.e());
                }
            } catch (SQLiteException e2) {
                com.bytedance.sdk.component.utils.wp.z(e2);
            }
        }
        com.ss.android.socialbase.downloader.gc.z zVarDl = dl(zVar);
        this.dl.z(zVarDl);
        z(zVarDl instanceof com.ss.android.socialbase.downloader.gc.m ? -2 : -1, zVarDl);
        if (com.ss.android.socialbase.downloader.i.z.z(this.dl.e()).z("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.fv.z().z(this.dl);
        }
    }

    private com.ss.android.socialbase.downloader.gc.z dl(com.ss.android.socialbase.downloader.gc.z zVar) {
        Context contextXl;
        if (com.ss.android.socialbase.downloader.i.z.z(this.dl.e()).z("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.pf.m.fo(zVar) || (contextXl = dl.xl()) == null || com.ss.android.socialbase.downloader.pf.m.dl(contextXl)) {
            return zVar;
        }
        return new com.ss.android.socialbase.downloader.gc.z(this.dl.io() ? 1013 : 1049, zVar.g());
    }

    public void m() {
        this.dl.fo(false);
        if (!this.dl.nb() && this.dl.sf() != this.dl.s()) {
            com.ss.android.socialbase.downloader.m.z.g(z, this.dl.a());
            z(new com.ss.android.socialbase.downloader.gc.e(AnalyticsListener.EVENT_DRM_SESSION_RELEASED, "current bytes is not equals to total bytes, bytes changed with process : " + this.dl.yw()));
            return;
        }
        if (this.dl.sf() <= 0) {
            com.ss.android.socialbase.downloader.m.z.g(z, this.dl.a());
            z(new com.ss.android.socialbase.downloader.gc.e(AnalyticsListener.EVENT_DRM_KEYS_REMOVED, "curBytes is 0, bytes changed with process : " + this.dl.yw()));
            return;
        }
        if (!this.dl.nb() && this.dl.s() <= 0) {
            com.ss.android.socialbase.downloader.m.z.g(z, this.dl.a());
            z(new com.ss.android.socialbase.downloader.gc.e(1044, "TotalBytes is 0, bytes changed with process : " + this.dl.yw()));
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(z, this.dl.gz() + " onCompleted start save file as target name");
        l lVarGc = this.p;
        com.ss.android.socialbase.downloader.e.a aVar = this.m;
        if (aVar != null) {
            lVarGc = aVar.gc();
        }
        com.ss.android.socialbase.downloader.pf.m.z(this.dl, lVarGc, new oq() { // from class: com.ss.android.socialbase.downloader.downloader.m.2
            @Override // com.ss.android.socialbase.downloader.a.oq
            public void z() {
                m.this.wp();
            }

            @Override // com.ss.android.socialbase.downloader.a.oq
            public void z(com.ss.android.socialbase.downloader.gc.z zVar) {
                com.ss.android.socialbase.downloader.m.z.g(m.z, "saveFileAsTargetName onFailed : " + (zVar != null ? zVar.g() : ""));
                m.this.z(zVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wp() {
        try {
            com.ss.android.socialbase.downloader.m.z.g(z, "saveFileAsTargetName onSuccess");
            try {
                i();
                this.dl.uy(false);
                this.dl.gz(false);
                z(-3, (com.ss.android.socialbase.downloader.gc.z) null);
                this.f2062a.dl(this.dl.e(), this.dl.s());
                this.f2062a.a(this.dl.e());
                this.f2062a.i(this.dl.e());
            } catch (com.ss.android.socialbase.downloader.gc.z e) {
                z(e);
            }
        } catch (Throwable th) {
            z(new com.ss.android.socialbase.downloader.gc.z(1008, com.ss.android.socialbase.downloader.pf.m.g(th, "onCompleted")));
        }
    }

    public void e() throws com.ss.android.socialbase.downloader.gc.z {
        if (this.g) {
            i();
            com.ss.android.socialbase.downloader.m.z.g(z, "onCompleteForFileExist");
            this.dl.gz(true);
            z(-3, (com.ss.android.socialbase.downloader.gc.z) null);
            this.f2062a.dl(this.dl.e(), this.dl.s());
            this.f2062a.a(this.dl.e());
            this.f2062a.z(this.dl);
            this.f2062a.i(this.dl.e());
            return;
        }
        i();
        com.ss.android.socialbase.downloader.m.z.g(z, "onCompleteForFileExist");
        this.dl.gz(true);
        z(-3, (com.ss.android.socialbase.downloader.gc.z) null);
        this.f2062a.dl(this.dl.e(), this.dl.s());
        this.f2062a.a(this.dl.e());
        this.f2062a.i(this.dl.e());
    }

    public void z(String str) throws com.ss.android.socialbase.downloader.gc.z {
        com.ss.android.socialbase.downloader.m.z.g(z, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.dl.gz());
        if (this.g) {
            com.ss.android.socialbase.downloader.pf.m.z(this.dl, str);
            i();
            this.dl.gz(true);
            z(-3, (com.ss.android.socialbase.downloader.gc.z) null);
            this.f2062a.z(this.dl);
            return;
        }
        this.f2062a.z(this.dl);
        com.ss.android.socialbase.downloader.pf.m.z(this.dl, str);
        this.dl.gz(true);
        i();
        z(-3, (com.ss.android.socialbase.downloader.gc.z) null);
    }

    private void i() throws com.ss.android.socialbase.downloader.gc.z {
        List<com.ss.android.socialbase.downloader.a.v> listQ = this.m.q();
        if (listQ.isEmpty()) {
            return;
        }
        com.ss.android.socialbase.downloader.e.dl dlVar = this.dl;
        z(11, (com.ss.android.socialbase.downloader.gc.z) null);
        this.f2062a.z(dlVar);
        for (com.ss.android.socialbase.downloader.a.v vVar : listQ) {
            try {
                if (vVar.g(dlVar)) {
                    vVar.z(dlVar);
                    this.f2062a.z(dlVar);
                }
            } catch (com.ss.android.socialbase.downloader.gc.z e) {
                throw e;
            } catch (Throwable th) {
                throw new com.ss.android.socialbase.downloader.gc.z(1071, th);
            }
        }
    }

    private boolean z(long j, boolean z2) {
        boolean z3 = false;
        if (this.dl.sf() == this.dl.s()) {
            try {
                this.f2062a.z(this.dl.e(), this.dl.sf());
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            return false;
        }
        if (this.uy) {
            this.uy = false;
            this.dl.a(4);
        }
        if (this.dl.gw() && z2) {
            z3 = true;
        }
        z(4, (com.ss.android.socialbase.downloader.gc.z) null, z3);
        return z2;
    }

    private boolean g(long j) {
        boolean z2 = true;
        if (!this.i) {
            this.i = true;
            return true;
        }
        long j2 = j - this.kb;
        if (this.wp.get() < this.pf && j2 < this.v) {
            z2 = false;
        }
        if (z2) {
            this.kb = j;
            this.wp.set(0L);
        }
        return z2;
    }

    private void g(com.ss.android.socialbase.downloader.gc.z zVar, boolean z2) {
        this.f2062a.gz(this.dl.e());
        z(z2 ? 7 : 5, zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, com.ss.android.socialbase.downloader.gc.z zVar) {
        z(i, zVar, true);
    }

    public void gz() {
        this.dl.a(8);
        this.dl.z(com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.z zVarH = dl.h();
        if (zVarH != null) {
            zVarH.z(this.dl.e(), this.m.wp(), 8);
        }
    }

    private void z(int i, com.ss.android.socialbase.downloader.gc.z zVar, boolean z2) {
        SparseArray<hh> sparseArray;
        SparseArray<hh> sparseArray2;
        int iP = this.dl.p();
        if (iP == -3 && i == 4) {
            return;
        }
        uy();
        if (i != 4 && com.ss.android.socialbase.downloader.g.m.gc(i)) {
            this.dl.e(false);
            if (com.ss.android.socialbase.downloader.g.m.a(i)) {
                this.dl.r();
            }
        }
        if (!this.dl.zz()) {
            com.ss.android.socialbase.downloader.gz.z.z(this.m, zVar, i);
        }
        if (i == 6) {
            this.dl.a(2);
        } else if (i == -6) {
            this.dl.a(-3);
        } else {
            this.dl.a(i);
        }
        if (iP == -3 || iP == -1) {
            if (this.dl.fp() == com.ss.android.socialbase.downloader.g.fo.DELAY_RETRY_DOWNLOADING) {
                this.dl.z(com.ss.android.socialbase.downloader.g.fo.DELAY_RETRY_DOWNLOADED);
            }
            if (this.dl.vt() == com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_DOWNLOADING) {
                this.dl.z(com.ss.android.socialbase.downloader.g.z.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.dl.yw() == com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.dl.z(com.ss.android.socialbase.downloader.g.g.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.pf.dl.z(i, this.gz, true, this.dl, zVar);
        if (i == -4) {
            return;
        }
        if (z2 && this.gc != null && (((sparseArray = this.e) != null && sparseArray.size() > 0) || ((sparseArray2 = this.fo) != null && sparseArray2.size() > 0 && (this.dl.k() || this.dl.cb())))) {
            this.gc.obtainMessage(i, this.dl.e(), this.m.wp(), zVar).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.z zVarH = dl.h();
        if (zVarH != null) {
            zVarH.z(this.dl.e(), this.m.wp(), i);
        }
    }
}
