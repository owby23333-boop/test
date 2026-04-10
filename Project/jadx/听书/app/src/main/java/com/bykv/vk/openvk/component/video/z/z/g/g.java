package com.bykv.vk.openvk.component.video.z.z.g;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.gc.z;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f121a;
    private a g;
    private File gc;
    private Context z;
    private volatile boolean dl = false;
    private final List<z.InterfaceC0028z> m = new ArrayList();
    private volatile boolean e = false;

    public g(Context context, a aVar) {
        this.f121a = null;
        this.gc = null;
        this.z = context;
        this.g = aVar;
        this.f121a = com.bykv.vk.openvk.component.video.z.gc.dl.g(aVar.gc(), aVar.p());
        this.gc = com.bykv.vk.openvk.component.video.z.gc.dl.dl(aVar.gc(), aVar.p());
    }

    public void z(z.InterfaceC0028z interfaceC0028z) {
        if (this.e) {
            synchronized (z.InterfaceC0028z.class) {
                this.m.add(interfaceC0028z);
            }
            return;
        }
        this.m.add(interfaceC0028z);
        if (g()) {
            com.bykv.vk.openvk.component.video.api.m.dl.z("VideoPreload", "Cache file is exist");
            this.g.fo(1);
            z(this.g, 200);
            dl.z(this.g);
            return;
        }
        this.e = true;
        this.g.fo(0);
        dl();
    }

    private boolean g() {
        if (this.gc.exists()) {
            return true;
        }
        if (!this.g.i()) {
            if (this.f121a.length() >= this.g.m()) {
                return true;
            }
            if (this.g.g() > 0 && this.f121a.length() >= this.g.g()) {
                return true;
            }
        }
        return false;
    }

    private void dl() {
        wp.z zVar;
        if (com.bykv.vk.openvk.component.video.api.dl.dl() != null) {
            zVar = com.bykv.vk.openvk.component.video.api.dl.dl().g();
        } else {
            zVar = new wp.z("v_preload");
        }
        zVar.z(this.g.js(), TimeUnit.MILLISECONDS).g(this.g.tb(), TimeUnit.MILLISECONDS).dl(this.g.q(), TimeUnit.MILLISECONDS);
        wp wpVarZ = zVar.z();
        v.z zVar2 = new v.z();
        final long length = this.f121a.length();
        int iM = this.g.m();
        boolean zI = this.g.i();
        int iG = this.g.g();
        if (iG > 0) {
            if (iG >= this.g.wp()) {
                zI = true;
            } else {
                iM = iG;
            }
        }
        if (zI) {
            zVar2.z("RANGE", "bytes=" + length + "-").z(this.g.ls()).z().g();
        } else {
            zVar2.z("RANGE", "bytes=" + length + "-" + iM).z(this.g.ls()).z().g();
        }
        wpVarZ.z(zVar2.g()).z(new com.bytedance.sdk.component.g.z.dl() { // from class: com.bykv.vk.openvk.component.video.z.z.g.g.1
            @Override // com.bytedance.sdk.component.g.z.dl
            public void onFailure(com.bytedance.sdk.component.g.z.g gVar, IOException iOException) {
                g gVar2 = g.this;
                gVar2.z(gVar2.g, 601, iOException.getMessage());
                dl.z(g.this.g);
            }

            /* JADX WARN: Removed duplicated region for block: B:74:0x01fa A[Catch: all -> 0x023a, TryCatch #7 {all -> 0x023a, blocks: (B:72:0x01ea, B:74:0x01fa, B:75:0x01fe), top: B:93:0x01ea }] */
            @Override // com.bytedance.sdk.component.g.z.dl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onResponse(com.bytedance.sdk.component.g.z.g r22, com.bytedance.sdk.component.g.z.ls r23) throws java.io.IOException {
                /*
                    Method dump skipped, instruction units count: 632
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.component.video.z.z.g.g.AnonymousClass1.onResponse(com.bytedance.sdk.component.g.z.g, com.bytedance.sdk.component.g.z.ls):void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public a z() {
        return this.g;
    }

    public void z(boolean z) {
        this.dl = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(a aVar, int i) {
        synchronized (z.InterfaceC0028z.class) {
            for (z.InterfaceC0028z interfaceC0028z : this.m) {
                if (interfaceC0028z != null) {
                    interfaceC0028z.z(aVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(a aVar, int i, String str) {
        synchronized (z.InterfaceC0028z.class) {
            for (z.InterfaceC0028z interfaceC0028z : this.m) {
                if (interfaceC0028z != null) {
                    interfaceC0028z.z(aVar, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(a aVar, int i) {
        synchronized (z.InterfaceC0028z.class) {
            for (z.InterfaceC0028z interfaceC0028z : this.m) {
                if (interfaceC0028z != null) {
                    interfaceC0028z.g(aVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            this.gc.delete();
            this.f121a.delete();
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gc() {
        try {
            if (this.f121a.renameTo(this.gc)) {
            } else {
                throw new IOException("Error renaming file " + this.f121a + " to " + this.gc + " for completion!");
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
            com.bykv.vk.openvk.component.video.api.m.dl.z("VideoPreload", th.getMessage());
        }
    }
}
