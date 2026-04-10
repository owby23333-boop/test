package com.bykv.vk.openvk.component.video.z.g;

import com.bykv.vk.openvk.component.video.z.g.fo;
import com.bykv.vk.openvk.component.video.z.g.wp;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
abstract class z implements kb {
    private static final AtomicLong i = new AtomicLong();
    protected volatile String e;
    protected volatile fo fo;
    protected final com.bykv.vk.openvk.component.video.z.g.g.dl g;
    protected com.bykv.vk.openvk.component.video.z.g.a.z gc;
    protected volatile String gz;
    protected volatile List<fo.g> m;
    protected volatile wp uy;
    protected volatile com.bykv.vk.openvk.component.video.z.g.z.z z;
    protected final AtomicInteger dl = new AtomicInteger();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicLong f118a = new AtomicLong();
    protected volatile boolean kb = false;
    public final long wp = i.incrementAndGet();
    private final AtomicInteger v = new AtomicInteger(0);
    private int pf = -1;

    public z(com.bykv.vk.openvk.component.video.z.g.z.z zVar, com.bykv.vk.openvk.component.video.z.g.g.dl dlVar) {
        this.z = zVar;
        this.g = dlVar;
    }

    public void z() {
        this.v.compareAndSet(0, 1);
    }

    public boolean g() {
        return this.v.get() == 1;
    }

    protected void dl() {
        this.v.compareAndSet(0, 2);
    }

    public boolean a() {
        return this.v.get() == 2;
    }

    protected void gc() throws com.bykv.vk.openvk.component.video.z.g.dl.z {
        if (g()) {
            throw new com.bykv.vk.openvk.component.video.z.g.dl.z();
        }
    }

    protected com.bykv.vk.openvk.component.video.z.g.gc.z z(wp.z zVar, int i2, int i3, String str) throws IOException {
        com.bykv.vk.openvk.component.video.z.g.gc.g gVarG = com.bykv.vk.openvk.component.video.z.g.gc.dl.z().g();
        com.bykv.vk.openvk.component.video.z.g.gc.gc gcVar = new com.bykv.vk.openvk.component.video.z.g.gc.gc();
        HashMap map = new HashMap();
        gcVar.g = zVar.z;
        gcVar.z = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            gcVar.z = 4;
        }
        List<fo.g> list = this.m;
        if (list != null && !list.isEmpty()) {
            for (fo.g gVar : list) {
                if (!HttpHeaders.RANGE.equalsIgnoreCase(gVar.z) && !HttpHeaders.CONNECTION.equalsIgnoreCase(gVar.z) && !"Proxy-Connection".equalsIgnoreCase(gVar.z) && !HttpHeaders.HOST.equalsIgnoreCase(gVar.z)) {
                    map.put(gVar.z, gVar.g);
                }
            }
        }
        String strZ = com.bykv.vk.openvk.component.video.z.dl.z.z(i2, i3);
        if (strZ != null) {
            map.put(HttpHeaders.RANGE, strZ);
        }
        if (gc.m) {
            map.put(HttpHeaders.CACHE_CONTROL, "no-cache");
        }
        a aVarDl = a.dl();
        m mVarZ = m.z();
        boolean z = this.fo == null;
        dl dlVarZ = z ? aVarDl.z() : mVarZ.g();
        dl dlVarG = z ? aVarDl.g() : mVarZ.dl();
        if (dlVarZ != null || dlVarG != null) {
            if (dlVarZ != null) {
                gcVar.dl = dlVarZ.z(zVar.g);
            }
            if (dlVarG != null) {
                gcVar.f112a = dlVarG.z(zVar.g);
            }
        }
        gcVar.gc = map;
        if (this.kb) {
            this.kb = false;
            return null;
        }
        return gVarG.z(gcVar);
    }

    protected int m() {
        if (this.fo != null) {
            return this.fo.dl.z;
        }
        return this.z instanceof com.bykv.vk.openvk.component.video.z.g.z.g ? 1 : 0;
    }

    protected boolean e() {
        return m() == 1;
    }

    protected void z(int i2, int i3) {
        if (i2 <= 0 || i3 < 0) {
            return;
        }
        int i4 = gc.e;
        int iM = m();
        if (i4 == 1 || (i4 == 2 && iM == 1)) {
            int i5 = (int) ((i3 / i2) * 100.0f);
            if (i5 > 100) {
                i5 = 100;
            }
            synchronized (this) {
                if (i5 <= this.pf) {
                    return;
                }
                this.pf = i5;
                com.bykv.vk.openvk.component.video.z.dl.z.z(new Runnable() { // from class: com.bykv.vk.openvk.component.video.z.g.z.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z.this.gc != null) {
                            wp wpVar = z.this.uy;
                            int unused = z.this.pf;
                        }
                    }
                });
            }
        }
    }
}
