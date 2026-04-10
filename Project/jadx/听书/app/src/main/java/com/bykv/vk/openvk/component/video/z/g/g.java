package com.bykv.vk.openvk.component.video.z.g;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.z.g.fo;
import com.bykv.vk.openvk.component.video.z.g.gz;
import com.bykv.vk.openvk.component.video.z.g.wp;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class g extends com.bykv.vk.openvk.component.video.z.g.z {
    private volatile com.bykv.vk.openvk.component.video.z.g.dl.g fv;
    final Object i;
    private final InterfaceC0031g ls;
    private volatile gz.z p;
    private final int pf;
    final Object v;

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.z.g.g$g, reason: collision with other inner class name */
    public interface InterfaceC0031g {
        void z(g gVar);
    }

    g(z zVar) {
        super(zVar.f108a, zVar.gc);
        this.pf = zVar.e;
        this.ls = zVar.fo;
        this.i = this;
        this.e = zVar.z;
        this.gz = zVar.g;
        this.m = zVar.m;
        this.uy = zVar.dl;
        this.fo = zVar.gz;
        this.v = zVar.uy;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.z.z(this.gz);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            uy();
        } catch (Throwable unused) {
        }
        this.f118a.set(SystemClock.elapsedRealtime() - jElapsedRealtime);
        this.z.g(this.gz);
        InterfaceC0031g interfaceC0031g = this.ls;
        if (interfaceC0031g != null) {
            interfaceC0031g.z(this);
        }
    }

    gz.z gz() {
        return this.p;
    }

    com.bykv.vk.openvk.component.video.z.g.dl.g fo() {
        return this.fv;
    }

    private boolean uy() throws com.bykv.vk.openvk.component.video.z.g.dl.z {
        while (this.uy.z()) {
            gc();
            wp.z zVarG = this.uy.g();
            try {
                z(zVarG);
                return true;
            } catch (com.bykv.vk.openvk.component.video.z.g.dl.dl unused) {
                zVarG.z();
                Boolean.valueOf(e());
                String str = this.e;
            } catch (com.bykv.vk.openvk.component.video.z.g.dl.g e) {
                this.fv = e;
                return false;
            } catch (gz.z e2) {
                this.p = e2;
                Boolean.valueOf(e());
                String str2 = this.e;
                return false;
            } catch (IOException e3) {
                if (e3 instanceof SocketTimeoutException) {
                    zVarG.g();
                }
                if (!g()) {
                    Boolean.valueOf(e());
                    String str3 = this.e;
                }
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01c9, code lost:
    
        dl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ce, code lost:
    
        if (com.bykv.vk.openvk.component.video.z.g.gc.dl == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01d0, code lost:
    
        com.bytedance.sdk.component.utils.wp.z("TAG_PROXY_DownloadTask", "download succeed, no need to cancel call");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d7, code lost:
    
        com.bykv.vk.openvk.component.video.z.dl.z.z(r6.a());
        r4.z();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01e1, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(com.bykv.vk.openvk.component.video.z.g.wp.z r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.z.g.g.z(com.bykv.vk.openvk.component.video.z.g.wp$z):void");
    }

    static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        com.bykv.vk.openvk.component.video.z.g.z.z f108a;
        wp dl;
        int e;
        InterfaceC0031g fo;
        String g;
        com.bykv.vk.openvk.component.video.z.g.g.dl gc;
        fo gz;
        List<fo.g> m;
        Object uy;
        String z;

        z() {
        }

        z z(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("rawKey == null");
            }
            this.z = str;
            return this;
        }

        z g(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("key == null");
            }
            this.g = str;
            return this;
        }

        z z(wp wpVar) {
            if (wpVar == null) {
                throw new IllegalArgumentException("urls is empty");
            }
            this.dl = wpVar;
            return this;
        }

        z z(com.bykv.vk.openvk.component.video.z.g.z.z zVar) {
            if (zVar == null) {
                throw new IllegalArgumentException("cache == null");
            }
            this.f108a = zVar;
            return this;
        }

        z z(com.bykv.vk.openvk.component.video.z.g.g.dl dlVar) {
            if (dlVar == null) {
                throw new IllegalArgumentException("db == null");
            }
            this.gc = dlVar;
            return this;
        }

        z z(List<fo.g> list) {
            this.m = list;
            return this;
        }

        z z(int i) {
            this.e = i;
            return this;
        }

        z z(InterfaceC0031g interfaceC0031g) {
            this.fo = interfaceC0031g;
            return this;
        }

        z z(fo foVar) {
            this.gz = foVar;
            return this;
        }

        z z(Object obj) {
            this.uy = obj;
            return this;
        }

        g z() {
            if (this.f108a == null || this.gc == null || TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.g) || this.dl == null) {
                throw new IllegalArgumentException();
            }
            return new g(this);
        }
    }
}
