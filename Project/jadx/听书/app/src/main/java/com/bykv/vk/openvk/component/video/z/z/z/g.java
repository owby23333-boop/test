package com.bykv.vk.openvk.component.video.z.z.z;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class g implements dl {
    private static final HashMap<String, g> z = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f123a;
    private volatile long g;
    private File gc;
    private final a kb;
    private long m;
    private RandomAccessFile uy;
    private g wp;
    private final Object dl = new Object();
    private volatile long e = -1;
    private volatile boolean gz = false;
    private volatile boolean fo = false;

    public g(Context context, a aVar) {
        this.g = -2147483648L;
        this.m = 0L;
        this.uy = null;
        this.kb = aVar;
        try {
            this.f123a = com.bykv.vk.openvk.component.video.z.gc.dl.g(aVar.gc(), aVar.p());
            this.gc = com.bykv.vk.openvk.component.video.z.gc.dl.dl(aVar.gc(), aVar.p());
            if (e()) {
                this.uy = new RandomAccessFile(this.gc, "r");
            } else {
                this.uy = new RandomAccessFile(this.f123a, "rw");
            }
            if (e()) {
                return;
            }
            long length = this.f123a.length();
            this.m = length;
            if (length == aVar.wp() && this.m != 0) {
                boolean z2 = com.bykv.vk.openvk.component.video.api.m.g.z(com.bykv.vk.openvk.component.video.api.m.g.z(this.f123a), aVar.p());
                aVar.p();
                if (z2) {
                    z(this.m);
                    this.g = this.m;
                    return;
                }
            }
            if (!a()) {
                com.bykv.vk.openvk.component.video.api.m.dl.g("CSJ_MediaDLPlay", "no process lock, no download " + gc());
                return;
            }
            synchronized (g.class) {
                if (m()) {
                    gz();
                } else {
                    g gVar = this.wp;
                    if (gVar != null) {
                        this.g = gVar.z();
                    }
                }
            }
        } catch (Throwable unused) {
            com.bykv.vk.openvk.component.video.api.m.dl.g("CSJ_MediaDLPlay", "Error using file ", aVar.ls(), " as disc cache");
        }
    }

    private boolean a() {
        RandomAccessFile randomAccessFile = this.uy;
        if (randomAccessFile == null) {
            return false;
        }
        try {
            FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
            if (fileLockTryLock == null) {
                if (fileLockTryLock != null) {
                    try {
                        fileLockTryLock.close();
                    } catch (IOException unused) {
                    }
                }
                return false;
            }
            if (fileLockTryLock == null) {
                return true;
            }
            try {
                fileLockTryLock.close();
                return true;
            } catch (IOException unused2) {
                return true;
            }
        } catch (IOException unused3) {
            return false;
        }
    }

    private String gc() {
        a aVar = this.kb;
        return aVar == null ? "" : aVar.p();
    }

    private boolean m() {
        String strGc = gc();
        synchronized (g.class) {
            HashMap<String, g> map = z;
            g gVar = map.get(strGc);
            this.wp = gVar;
            if (gVar != null) {
                return false;
            }
            map.put(strGc, this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z2) {
        String strGc = gc();
        synchronized (g.class) {
            if (z2) {
                z.remove(strGc);
            } else {
                HashMap<String, g> map = z;
                if (map.get(strGc) == this) {
                    map.remove(strGc);
                }
            }
        }
    }

    public long z() {
        return this.g;
    }

    private boolean e() {
        return this.gc.exists() && this.gc.length() > 0;
    }

    private void gz() {
        wp.z zVar;
        if (com.bykv.vk.openvk.component.video.api.dl.dl() != null) {
            zVar = com.bykv.vk.openvk.component.video.api.dl.dl().g();
        } else {
            zVar = new wp.z("v_cache");
        }
        zVar.z(this.kb.js(), TimeUnit.MILLISECONDS).g(this.kb.tb(), TimeUnit.MILLISECONDS).dl(this.kb.q(), TimeUnit.MILLISECONDS);
        wp wpVarZ = zVar.z();
        new Object[]{"RANGE, bytes=", Long.valueOf(this.m), " file hash=", this.kb.p()};
        wpVarZ.z(new v.z().z("RANGE", "bytes=" + this.m + "-").z(this.kb.ls()).z().g()).z(new com.bytedance.sdk.component.g.z.dl() { // from class: com.bykv.vk.openvk.component.video.z.z.z.g.1
            @Override // com.bytedance.sdk.component.g.z.dl
            public void onFailure(com.bytedance.sdk.component.g.z.g gVar, IOException iOException) {
                g.this.fo = false;
                g.this.g = -1L;
                g.this.z(true);
            }

            /* JADX WARN: Code restructure failed: missing block: B:100:0x01bf, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:101:0x01c2, code lost:
            
                if (r21 == null) goto L103;
             */
            /* JADX WARN: Code restructure failed: missing block: B:102:0x01c4, code lost:
            
                r21.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:103:0x01c7, code lost:
            
                r2 = r19.z.f123a.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:104:0x01d7, code lost:
            
                if (r19.z.fo == false) goto L246;
             */
            /* JADX WARN: Code restructure failed: missing block: B:106:0x01e1, code lost:
            
                if (r2 != r19.z.g) goto L247;
             */
            /* JADX WARN: Code restructure failed: missing block: B:108:0x01e5, code lost:
            
                if (r2 <= r5) goto L248;
             */
            /* JADX WARN: Code restructure failed: missing block: B:109:0x01e7, code lost:
            
                r0 = r19.z;
                r0.z(r0.g);
             */
            /* JADX WARN: Code restructure failed: missing block: B:110:0x01f0, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:111:0x01f1, code lost:
            
                com.bykv.vk.openvk.component.video.api.m.dl.g("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:112:0x01f8, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:114:0x0203, code lost:
            
                if (com.bykv.vk.openvk.component.video.z.gc.dl.z(r19.z.uy, r0, r8, r12) == false) goto L235;
             */
            /* JADX WARN: Code restructure failed: missing block: B:115:0x0205, code lost:
            
                r8 = r8 + ((long) r12);
             */
            /* JADX WARN: Code restructure failed: missing block: B:116:0x0207, code lost:
            
                monitor-exit(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:118:0x020e, code lost:
            
                com.bytedance.sdk.component.utils.wp.g("CSJ_MediaDLPlay", "append error, try again：" + r8 + "  offset = " + r12 + " key= " + r19.z.kb.p() + " fb: " + r11.valid() + " channel " + r10.isOpen());
             */
            /* JADX WARN: Code restructure failed: missing block: B:119:0x025c, code lost:
            
                monitor-exit(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:120:0x025d, code lost:
            
                if (r16 == null) goto L124;
             */
            /* JADX WARN: Code restructure failed: missing block: B:121:0x025f, code lost:
            
                r16.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x0263, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:124:0x0265, code lost:
            
                if (r7 == null) goto L126;
             */
            /* JADX WARN: Code restructure failed: missing block: B:125:0x0267, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:126:0x026a, code lost:
            
                if (r21 == null) goto L128;
             */
            /* JADX WARN: Code restructure failed: missing block: B:127:0x026c, code lost:
            
                r21.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:128:0x026f, code lost:
            
                r2 = r19.z.f123a.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:129:0x027f, code lost:
            
                if (r19.z.fo == false) goto L249;
             */
            /* JADX WARN: Code restructure failed: missing block: B:131:0x0289, code lost:
            
                if (r2 != r19.z.g) goto L250;
             */
            /* JADX WARN: Code restructure failed: missing block: B:133:0x028f, code lost:
            
                if (r2 <= 0) goto L251;
             */
            /* JADX WARN: Code restructure failed: missing block: B:134:0x0291, code lost:
            
                r0 = r19.z;
                r0.z(r0.g);
             */
            /* JADX WARN: Code restructure failed: missing block: B:135:0x029a, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:136:0x029b, code lost:
            
                com.bykv.vk.openvk.component.video.api.m.dl.g("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:137:0x02a2, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:246:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:247:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:248:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:249:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:250:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:251:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:89:0x0187, code lost:
            
                r3 = r19.z.dl;
             */
            /* JADX WARN: Code restructure failed: missing block: B:90:0x018d, code lost:
            
                monitor-enter(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:92:0x0194, code lost:
            
                if (r19.z.gz == false) goto L113;
             */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x0196, code lost:
            
                com.bykv.vk.openvk.component.video.api.m.dl.g("CSJ_MediaDLPlay", "close stream " + r19.z.kb.p());
             */
            /* JADX WARN: Code restructure failed: missing block: B:94:0x01b4, code lost:
            
                monitor-exit(r3);
             */
            /* JADX WARN: Code restructure failed: missing block: B:95:0x01b5, code lost:
            
                if (r16 == null) goto L99;
             */
            /* JADX WARN: Code restructure failed: missing block: B:96:0x01b7, code lost:
            
                r16.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:97:0x01bb, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:99:0x01bd, code lost:
            
                if (r7 == null) goto L101;
             */
            @Override // com.bytedance.sdk.component.g.z.dl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.bytedance.sdk.component.g.z.g r20, com.bytedance.sdk.component.g.z.ls r21) throws java.io.IOException {
                /*
                    Method dump skipped, instruction units count: 1018
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.z.z.z.g.AnonymousClass1.onResponse(com.bytedance.sdk.component.g.z.g, com.bytedance.sdk.component.g.z.ls):void");
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.z.z.z.dl
    public int z(long j, byte[] bArr, int i, int i2) throws IOException {
        try {
            if (j == this.g) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            while (!this.gz) {
                synchronized (this.dl) {
                    long jFo = fo();
                    if (j < jFo) {
                        this.uy.seek(j);
                        i4 = this.uy.read(bArr, i, i2);
                    } else {
                        Object[] objArr = new Object[4];
                        Long.valueOf(j);
                        Long.valueOf(jFo);
                        i3 += 33;
                        this.dl.wait(33L);
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                if (i3 >= 10000) {
                    throw new SocketTimeoutException();
                }
            }
            return -1;
        } catch (Throwable th) {
            if (th instanceof IOException) {
                throw th;
            }
            throw new IOException();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.z.z.dl
    public void g() {
        try {
            if (!this.gz) {
                this.uy.close();
            }
            File file = this.f123a;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.gc;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } finally {
            try {
            } catch (Throwable th) {
            }
        }
        z(false);
        synchronized (this.dl) {
            this.gz = true;
        }
    }

    private long fo() {
        if (e()) {
            return this.gc.length();
        }
        return this.f123a.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j) throws IOException {
        synchronized (this.dl) {
            if (this.gc.exists() && this.gc.length() >= j) {
                Object[] objArr = new Object[3];
                this.kb.ls();
                this.kb.p();
                return;
            }
            try {
            } finally {
            }
            if (!this.f123a.renameTo(this.gc)) {
                throw new IOException("Error renaming file " + this.f123a + " to " + this.gc + " for completion!");
            }
            RandomAccessFile randomAccessFile = this.uy;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            if (!this.gz) {
                this.uy = new RandomAccessFile(this.gc, "rw");
            }
            Object[] objArr2 = new Object[3];
            this.kb.p();
            this.kb.ls();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.z.z.dl
    public long dl() throws IOException {
        if (e()) {
            this.g = this.gc.length();
        } else {
            synchronized (this.dl) {
                int i = 0;
                do {
                    if (this.g == -2147483648L) {
                        try {
                            g gVar = this.wp;
                            if (gVar != null) {
                                this.g = gVar.z();
                            }
                            i += 15;
                            this.dl.wait(5L);
                        } catch (InterruptedException e) {
                            com.bytedance.sdk.component.utils.wp.z(e);
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i <= 10000);
                return -1L;
            }
        }
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_MediaDLPlay", "totalLength= ", Long.valueOf(this.g));
        return this.g;
    }
}
