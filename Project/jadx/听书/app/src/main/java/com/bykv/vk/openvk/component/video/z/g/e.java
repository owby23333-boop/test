package com.bykv.vk.openvk.component.video.z.g;

import android.os.SystemClock;
import android.util.Log;
import com.bykv.vk.openvk.component.video.z.g.fo;
import com.bykv.vk.openvk.component.video.z.g.g;
import com.bykv.vk.openvk.component.video.z.g.gz;
import com.bykv.vk.openvk.component.video.z.g.wp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes2.dex */
class e extends com.bykv.vk.openvk.component.video.z.g.z {
    private final Socket i;
    private volatile com.bykv.vk.openvk.component.video.z.g.g ls;
    private volatile boolean p;
    private final a pf;
    private final dl v;

    public interface dl {
        void g(e eVar);

        void z(e eVar);
    }

    e(z zVar) {
        super(zVar.z, zVar.g);
        this.p = true;
        this.i = zVar.dl;
        this.v = zVar.f106a;
        this.pf = a.dl();
    }

    private g gz() {
        try {
            this.fo = fo.z(this.i.getInputStream());
            OutputStream outputStream = this.i.getOutputStream();
            com.bykv.vk.openvk.component.video.z.g.z.z zVar = this.fo.dl.z == 1 ? gc.z : gc.g;
            if (zVar == null) {
                if (gc.dl) {
                    com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", "cache is null");
                }
                return null;
            }
            this.z = zVar;
            this.e = this.fo.dl.g;
            this.gz = this.fo.dl.dl;
            this.uy = new wp(this.fo.dl.e);
            this.m = this.fo.g;
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_ProxyTask", "request from MediaPlayer:    " + this.fo.toString());
            }
            return new g(outputStream, this.fo.dl.f107a);
        } catch (fo.a e) {
            com.bykv.vk.openvk.component.video.z.dl.z.z(this.i);
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
            if (this.z != null) {
                Boolean.valueOf(e());
            }
            String str = this.e;
            return null;
        } catch (IOException e2) {
            com.bykv.vk.openvk.component.video.z.dl.z.z(this.i);
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
            }
            if (this.z != null) {
                Boolean.valueOf(e());
            }
            String str2 = this.e;
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.bykv.vk.openvk.component.video.z.g.g.z zVarQuery;
        g gVarGz = gz();
        if (gVarGz == null) {
            return;
        }
        dl dlVar = this.v;
        if (dlVar != null) {
            dlVar.z(this);
        }
        this.z.z(this.gz);
        if (gc.gz != 0 && ((zVarQuery = this.g.query(this.gz, this.fo.dl.z)) == null || this.z.dl(this.gz).length() < zVarQuery.dl)) {
            this.pf.z(e(), this.gz);
        }
        try {
            z(gVarGz);
        } catch (com.bykv.vk.openvk.component.video.z.g.dl.z e) {
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
            }
        } catch (Throwable th) {
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", Log.getStackTraceString(th));
            }
        }
        this.z.g(this.gz);
        this.pf.z(e(), null);
        z();
        com.bykv.vk.openvk.component.video.z.dl.z.z(this.i);
        dl dlVar2 = this.v;
        if (dlVar2 != null) {
            dlVar2.g(this);
        }
    }

    private boolean z(g gVar) throws Throwable {
        while (this.uy.z()) {
            gc();
            wp.z zVarG = this.uy.g();
            try {
                z(gVar, zVarG);
                return true;
            } catch (com.bykv.vk.openvk.component.video.z.g.dl.a e) {
                if (gc.dl) {
                    com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", Log.getStackTraceString(e));
                }
                return true;
            } catch (com.bykv.vk.openvk.component.video.z.g.dl.dl unused) {
                zVarG.z();
                Boolean.valueOf(e());
                String str = this.e;
            } catch (com.bykv.vk.openvk.component.video.z.g.dl.g e2) {
                if (gc.dl) {
                    com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", Log.getStackTraceString(e2));
                }
                return false;
            } catch (gz.z e3) {
                if (gc.dl) {
                    com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", Log.getStackTraceString(e3));
                }
                this.p = false;
                Boolean.valueOf(e());
                String str2 = this.e;
            } catch (IOException e4) {
                if (e4 instanceof SocketTimeoutException) {
                    zVarG.g();
                }
                if (g()) {
                    if (gc.dl) {
                        if ("Canceled".equalsIgnoreCase(e4.getMessage())) {
                            com.bytedance.sdk.component.utils.wp.g("TAG_PROXY_ProxyTask", "okhttp call canceled");
                        } else {
                            com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", Log.getStackTraceString(e4));
                        }
                    }
                } else {
                    Boolean.valueOf(e());
                    String str3 = this.e;
                }
            } catch (Exception e5) {
                if (gc.dl) {
                    com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", Log.getStackTraceString(e5));
                }
            }
        }
        return false;
    }

    private void z(g gVar, wp.z zVar) throws Throwable {
        if ("HEAD".equalsIgnoreCase(this.fo.z.z)) {
            g(gVar, zVar);
        } else {
            dl(gVar, zVar);
        }
    }

    private void g(g gVar, wp.z zVar) throws IOException, com.bykv.vk.openvk.component.video.z.g.dl.a {
        byte[] bArrZ = z(this.g.query(this.gz, this.fo.dl.z), gVar, zVar);
        if (bArrZ == null) {
            return;
        }
        gVar.z(bArrZ, 0, bArrZ.length);
    }

    private void dl(g gVar, wp.z zVar) throws Throwable {
        if (this.p) {
            File fileDl = this.z.dl(this.gz);
            long length = fileDl.length();
            com.bykv.vk.openvk.component.video.z.g.g.z zVarQuery = this.g.query(this.gz, this.fo.dl.z);
            int iG = gVar.g();
            if (length > gVar.g()) {
                if (gc.dl) {
                    com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_ProxyTask", "cache hit, remainSize: " + (length - ((long) iG)));
                }
                z(zVarQuery, fileDl, gVar, zVar);
                return;
            }
        }
        a(gVar, zVar);
    }

    private byte[] z(com.bykv.vk.openvk.component.video.z.g.g.z zVar, g gVar, wp.z zVar2) throws IOException {
        if (zVar != null) {
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_ProxyTask", "get header from db");
            }
            return com.bykv.vk.openvk.component.video.z.dl.z.z(zVar, gVar.g()).getBytes(com.bykv.vk.openvk.component.video.z.dl.z.z);
        }
        com.bykv.vk.openvk.component.video.z.g.gc.z zVarZ = z(zVar2, 0, -1, "HEAD");
        if (zVarZ == null) {
            return null;
        }
        try {
            String strZ = com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ, false, false);
            if (strZ != null) {
                throw new com.bykv.vk.openvk.component.video.z.g.dl.dl(strZ + ", rawKey: " + this.e + ", url: " + zVar2);
            }
            com.bykv.vk.openvk.component.video.z.g.g.z zVarZ2 = com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ, this.g, this.gz, this.fo.dl.z);
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.g("TAG_PROXY_ProxyTask", "get header from network");
            }
            return com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ2, gVar.g()).getBytes(com.bykv.vk.openvk.component.video.z.dl.z.z);
        } finally {
            com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ.a());
        }
    }

    private void z(com.bykv.vk.openvk.component.video.z.g.g.z zVar, File file, g gVar, wp.z zVar2) throws Throwable {
        final com.bytedance.sdk.component.uy.gz gzVar;
        gz gzVar2;
        com.bykv.vk.openvk.component.video.z.g.g gVar2;
        if (!gVar.z()) {
            byte[] bArrZ = z(zVar, gVar, zVar2);
            gc();
            if (bArrZ == null) {
                return;
            } else {
                gVar.z(bArrZ, 0, bArrZ.length);
            }
        }
        gz gzVar3 = null;
        if (zVar == null && (zVar = this.g.query(this.gz, this.fo.dl.z)) == null) {
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            z(null, gVar, zVar2);
            zVar = this.g.query(this.gz, this.fo.dl.z);
            if (zVar == null) {
                throw new com.bykv.vk.openvk.component.video.z.g.dl.dl("failed to get header, rawKey: " + this.e + ", url: " + zVar2);
            }
        }
        if (file.length() >= zVar.dl || !((gVar2 = this.ls) == null || gVar2.g() || gVar2.a())) {
            gzVar = null;
        } else {
            com.bykv.vk.openvk.component.video.z.g.g gVarZ = new g.z().z(this.z).z(this.g).z(this.e).g(this.gz).z(new wp(zVar2.z)).z(this.m).z(this.fo).z(new g.InterfaceC0031g() { // from class: com.bykv.vk.openvk.component.video.z.g.e.1
                @Override // com.bykv.vk.openvk.component.video.z.g.g.InterfaceC0031g
                public void z(com.bykv.vk.openvk.component.video.z.g.g gVar3) {
                    e.this.dl.addAndGet(gVar3.dl.get());
                    e.this.f118a.addAndGet(gVar3.f118a.get());
                    synchronized (gVar3.i) {
                        gVar3.i.notifyAll();
                    }
                    if (gVar3.a()) {
                        e.this.pf.z(e.this.e(), null);
                    }
                }
            }).z();
            this.ls = gVarZ;
            gzVar = new com.bytedance.sdk.component.uy.gz(gVarZ, null, 10, 1);
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("processCacheNetWorkConcurrent") { // from class: com.bykv.vk.openvk.component.video.z.g.e.2
                @Override // java.lang.Runnable
                public void run() {
                    gzVar.run();
                }
            });
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            gzVar2 = new gz(file, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            gzVar2.z(gVar.g());
            int iMin = this.fo.dl.gc > 0 ? Math.min(zVar.dl, this.fo.dl.gc) : zVar.dl;
            while (gVar.g() < iMin) {
                gc();
                int iZ = gzVar2.z(bArr);
                if (iZ <= 0) {
                    com.bykv.vk.openvk.component.video.z.g.g gVar3 = this.ls;
                    if (gVar3 != null) {
                        com.bykv.vk.openvk.component.video.z.g.dl.g gVarFo = gVar3.fo();
                        if (gVarFo != null) {
                            throw gVarFo;
                        }
                        gz.z zVarGz = gVar3.gz();
                        if (zVarGz != null) {
                            throw zVarGz;
                        }
                    }
                    if (gVar3 != null && !gVar3.g() && !gVar3.a()) {
                        gc();
                        synchronized (gVar3.i) {
                            try {
                                gVar3.i.wait(1000L);
                            } catch (InterruptedException e) {
                                com.bytedance.sdk.component.utils.wp.z(e);
                            }
                        }
                    }
                    if (gc.dl) {
                        com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", "download task has finished!!!");
                    }
                    throw new com.bykv.vk.openvk.component.video.z.g.dl.dl("illegal state download task has finished, rawKey: " + this.e + ", url: " + zVar2);
                }
                gVar.g(bArr, 0, iZ);
                gc();
            }
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_ProxyTask", "read cache file complete: " + gVar.g() + ", " + iMin);
            }
            dl();
            gzVar2.z();
            if (gzVar != null) {
                try {
                    gzVar.get();
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.wp.z(th2);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            gzVar3 = gzVar2;
            if (gzVar3 != null) {
                gzVar3.z();
            }
            if (gzVar != null) {
                try {
                    gzVar.get();
                } catch (Throwable th4) {
                    com.bytedance.sdk.component.utils.wp.z(th4);
                }
            }
            throw th;
        }
    }

    private void a(g gVar, wp.z zVar) throws Throwable {
        String strZ;
        gz gzVar;
        fo();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int iG = gVar.g();
        com.bykv.vk.openvk.component.video.z.g.gc.z zVarZ = z(zVar, iG, this.fo.dl.gc, "GET");
        if (zVarZ == null) {
            return;
        }
        gz gzVar2 = null;
        int i = 0;
        try {
            strZ = com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ, false, true);
        } catch (Throwable th) {
            th = th;
        }
        if (strZ != null) {
            throw new com.bykv.vk.openvk.component.video.z.g.dl.dl(strZ + ", rawKey: " + this.e + ", url: " + zVar);
        }
        com.bykv.vk.openvk.component.video.z.g.g.z zVarQuery = this.g.query(this.gz, m());
        int iZ = com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ);
        if (zVarQuery != null && zVarQuery.dl != iZ) {
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + zVarQuery.dl + ", " + iZ + ", key: " + this.gz);
            }
            throw new com.bykv.vk.openvk.component.video.z.g.dl.g("Content-Length not match, old length: " + zVarQuery.dl + ", new length: " + iZ + ", rawKey: " + this.e + ", currentUrl: " + zVar + ", previousInfo: " + zVarQuery.gc);
        }
        if (!gVar.z()) {
            String strZ2 = com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ, iG);
            gc();
            byte[] bytes = strZ2.getBytes(com.bykv.vk.openvk.component.video.z.dl.z.z);
            gVar.z(bytes, 0, bytes.length);
        }
        gc();
        File fileA = this.z.a(this.gz);
        if (this.p && fileA != null && fileA.length() >= gVar.g()) {
            com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ, this.g, this.gz, this.fo.dl.z);
            try {
                gzVar = new gz(fileA, "rwd");
                try {
                    try {
                        gzVar.z(gVar.g());
                    } catch (Throwable th2) {
                        th = th2;
                        gzVar2 = gzVar;
                    }
                } catch (gz.z e) {
                    e = e;
                    com.bytedance.sdk.component.utils.wp.z(e);
                    gzVar = null;
                }
            } catch (gz.z e2) {
                e = e2;
            }
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_ProxyTask", "can write to cache file in network task, cache file size: " + fileA.length() + ", from: " + gVar.g());
            }
        } else {
            if (gc.dl) {
                com.bytedance.sdk.component.utils.wp.g("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + fileA.length() + ", from: " + gVar.g());
            }
            gzVar = null;
        }
        com.bykv.vk.openvk.component.video.z.g.g.z zVarQuery2 = this.g.query(this.gz, m());
        int i2 = zVarQuery2 == null ? 0 : zVarQuery2.dl;
        byte[] bArr = new byte[8192];
        InputStream inputStreamA = zVarZ.a();
        int i3 = 0;
        while (true) {
            try {
                int i4 = inputStreamA.read(bArr);
                if (i4 < 0) {
                    break;
                }
                gc();
                if (i4 > 0) {
                    gVar.g(bArr, 0, i4);
                    i3 += i4;
                    if (gzVar != null) {
                        try {
                            gzVar.z(bArr, 0, i4);
                        } catch (Throwable th3) {
                            gzVar.z();
                            try {
                                if (gc.dl) {
                                    com.bytedance.sdk.component.utils.wp.a("TAG_PROXY_ProxyTask", "append to cache file error in network task!!! " + Log.getStackTraceString(th3));
                                }
                                gzVar = null;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                    }
                    z(i2, gVar.g());
                }
                gc();
            } catch (Throwable th5) {
                th = th5;
                gzVar2 = gzVar;
            }
            th = th5;
            gzVar2 = gzVar;
            i = i3;
            com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ.a());
            if (gzVar2 != null) {
                gzVar2.z();
            }
            this.dl.addAndGet(i);
            this.f118a.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
            throw th;
        }
        if (gc.dl) {
            com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_ProxyTask", "read from net complete!");
        }
        dl();
        com.bykv.vk.openvk.component.video.z.dl.z.z(zVarZ.a());
        if (gzVar != null) {
            gzVar.z();
        }
        this.dl.addAndGet(i3);
        this.f118a.addAndGet(SystemClock.elapsedRealtime() - jElapsedRealtime);
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.z
    public void z() {
        super.z();
        fo();
    }

    private void fo() {
        com.bykv.vk.openvk.component.video.z.g.g gVar = this.ls;
        this.ls = null;
        if (gVar != null) {
            gVar.z();
        }
    }

    private static class g {
        private boolean dl;
        private int g;
        private final OutputStream z;

        g(OutputStream outputStream, int i) {
            this.z = outputStream;
            this.g = i;
        }

        boolean z() {
            return this.dl;
        }

        void z(byte[] bArr, int i, int i2) throws com.bykv.vk.openvk.component.video.z.g.dl.a {
            if (this.dl) {
                return;
            }
            try {
                this.z.write(bArr, i, i2);
                this.dl = true;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.component.video.z.g.dl.a(e);
            }
        }

        void g(byte[] bArr, int i, int i2) throws com.bykv.vk.openvk.component.video.z.g.dl.a {
            try {
                this.z.write(bArr, i, i2);
                this.g += i2;
            } catch (IOException e) {
                throw new com.bykv.vk.openvk.component.video.z.g.dl.a(e);
            }
        }

        int g() {
            return this.g;
        }
    }

    static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        dl f106a;
        Socket dl;
        com.bykv.vk.openvk.component.video.z.g.g.dl g;
        com.bykv.vk.openvk.component.video.z.g.z.z z;

        z() {
        }

        z z(com.bykv.vk.openvk.component.video.z.g.g.dl dlVar) {
            if (dlVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.g = dlVar;
            return this;
        }

        z z(Socket socket) {
            if (socket == null) {
                throw new IllegalArgumentException("socket == null");
            }
            this.dl = socket;
            return this;
        }

        z z(dl dlVar) {
            this.f106a = dlVar;
            return this;
        }

        e z() {
            if (this.g == null || this.dl == null) {
                throw new IllegalArgumentException();
            }
            return new e(this);
        }
    }
}
