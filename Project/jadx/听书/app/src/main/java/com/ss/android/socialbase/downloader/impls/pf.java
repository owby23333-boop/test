package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.na;
import com.ss.android.socialbase.downloader.a.q;
import com.ss.android.socialbase.downloader.a.un;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.kb;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class pf implements com.ss.android.socialbase.downloader.downloader.ls, com.ss.android.socialbase.downloader.downloader.pf {
    private static final String z = "pf";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.pf f2094a = new ls();
    private com.ss.android.socialbase.downloader.downloader.p<CSJIndependentProcessDownloadService> dl;
    private volatile com.ss.android.socialbase.downloader.downloader.kb g;

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
    }

    public pf() {
        com.ss.android.socialbase.downloader.downloader.p<CSJIndependentProcessDownloadService> pVarSy = com.ss.android.socialbase.downloader.downloader.dl.sy();
        this.dl = pVarSy;
        pVarSy.z(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.z(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, boolean z2) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.z(i, z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean g(int i) {
        if (this.g == null) {
            return false;
        }
        try {
            return this.g.g(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void dl(int i) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.dl(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void a(int i) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.a(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z() {
        if (this.g == null) {
            return;
        }
        try {
            this.g.z();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public long gc(int i) {
        if (this.g == null) {
            return 0L;
        }
        try {
            return this.g.gc(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public int m(int i) {
        if (this.g == null) {
            return 0;
        }
        try {
            return this.g.m(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean e(int i) {
        if (this.g == null) {
            return false;
        }
        try {
            return this.g.e(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public com.ss.android.socialbase.downloader.e.dl gz(int i) {
        if (this.g == null) {
            return this.f2094a.gz(i);
        }
        try {
            return this.g.gz(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> z(String str) {
        if (this.g == null) {
            return this.f2094a.z(str);
        }
        try {
            return this.g.z(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.g> fo(int i) {
        if (this.g == null) {
            return this.f2094a.fo(i);
        }
        try {
            return this.g.fo(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public int z(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.dl.z(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public com.ss.android.socialbase.downloader.e.dl g(String str, String str2) {
        return gz(z(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> g(String str) {
        if (this.g == null) {
            return this.f2094a.g(str);
        }
        try {
            return this.g.g(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) {
        if (this.g == null) {
            return this.f2094a.dl(str);
        }
        try {
            return this.g.dl(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> a() {
        if (this.g == null) {
            return this.f2094a.a();
        }
        try {
            return this.g.g();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(List<String> list) {
        if (this.g == null) {
            this.f2094a.z(list);
            return;
        }
        try {
            this.g.z(list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(List<String> list) {
        if (this.g == null) {
            this.f2094a.g(list);
            return;
        }
        try {
            this.g.g(list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(int i, boolean z2) {
        if (this.g == null) {
            this.f2094a.g(i, z2);
            return;
        }
        try {
            this.g.g(i, z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void uy(int i) {
        if (this.g == null) {
            this.f2094a.uy(i);
            return;
        }
        try {
            this.g.uy(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z2) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.g(i, i2, com.ss.android.socialbase.downloader.pf.e.z(hhVar, gzVar != com.ss.android.socialbase.downloader.g.gz.SUB), gzVar.ordinal(), z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z2, boolean z3) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.z(i, i2, com.ss.android.socialbase.downloader.pf.e.z(hhVar, gzVar != com.ss.android.socialbase.downloader.g.gz.SUB), gzVar.ordinal(), z2, z3);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(int i, int i2, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z2) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.z(i, i2, com.ss.android.socialbase.downloader.pf.e.z(hhVar, gzVar != com.ss.android.socialbase.downloader.g.gz.SUB), gzVar.ordinal(), z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (this.g == null) {
            return this.f2094a.z(dlVar);
        }
        try {
            this.g.z(dlVar);
            return false;
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, Notification notification) {
        if (this.g == null) {
            com.ss.android.socialbase.downloader.m.z.a(z, "startForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.m.z.dl(z, "aidlService.startForeground, id = ".concat(String.valueOf(i)));
        try {
            this.g.z(i, notification);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(boolean z2, boolean z3) {
        if (this.g == null) {
            com.ss.android.socialbase.downloader.m.z.a(z, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.m.z.dl(z, "aidlService.stopForeground");
        try {
            this.g.z(z3);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean g() {
        if (this.g == null) {
            com.ss.android.socialbase.downloader.m.z.a(z, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.m.z.dl(z, "aidlService.isServiceForeground");
        try {
            return this.g.m();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean dl() {
        return com.ss.android.socialbase.downloader.downloader.dl.j();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> a(String str) {
        if (this.g == null) {
            return this.f2094a.a(str);
        }
        try {
            return this.g.gc(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> gc(String str) {
        if (this.g == null) {
            return null;
        }
        try {
            return this.g.a(str);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.downloader.p<CSJIndependentProcessDownloadService> pVar;
        if (aVar == null || (pVar = this.dl) == null) {
            return;
        }
        pVar.g(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.downloader.p<CSJIndependentProcessDownloadService> pVar;
        if (aVar == null || (pVar = this.dl) == null) {
            return;
        }
        pVar.dl(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean wp(int i) {
        if (this.g == null) {
            return false;
        }
        try {
            return this.g.kb(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void kb(int i) {
        com.ss.android.socialbase.downloader.downloader.p<CSJIndependentProcessDownloadService> pVar = this.dl;
        if (pVar != null) {
            pVar.z(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.p<CSJIndependentProcessDownloadService> pVar = this.dl;
        if (pVar != null) {
            pVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean gc() {
        if (this.g == null) {
            return this.f2094a.gc();
        }
        try {
            return this.g.a();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.g(i, list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void dl(int i, boolean z2) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.a(i, z2);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public int i(int i) {
        if (this.g == null) {
            return com.ss.android.socialbase.downloader.downloader.a.z().g(i);
        }
        try {
            return this.g.i(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(com.ss.android.socialbase.downloader.e.g gVar) {
        if (this.g == null) {
            this.f2094a.z(gVar);
            return;
        }
        try {
            this.g.z(gVar);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (this.g == null) {
            return this.f2094a.dl(dlVar);
        }
        try {
            return this.g.g(dlVar);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean v(int i) {
        if (this.g == null) {
            return this.f2094a.v(i);
        }
        try {
            return this.g.v(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void pf(int i) {
        if (this.g == null) {
            this.f2094a.pf(i);
            return;
        }
        try {
            this.g.pf(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, long j) {
        if (this.g == null) {
            this.f2094a.z(i, i2, j);
            return;
        }
        try {
            this.g.z(i, i2, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, int i3, long j) {
        if (this.g == null) {
            this.f2094a.z(i, i2, i3, j);
            return;
        }
        try {
            this.g.z(i, i2, i3, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, int i3, int i4) {
        if (this.g == null) {
            this.f2094a.z(i, i2, i3, i4);
            return;
        }
        try {
            this.g.z(i, i2, i3, i4);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean ls(int i) {
        if (this.g == null) {
            return this.f2094a.ls(i);
        }
        try {
            return this.g.ls(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void m() {
        if (this.g == null) {
            this.f2094a.m();
            return;
        }
        try {
            this.g.gc();
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        if (this.g == null) {
            this.f2094a.g(i, list);
            return;
        }
        try {
            this.g.z(i, list);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean e() {
        return this.g != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(na naVar) {
        if (this.g != null) {
            try {
                this.g.z(com.ss.android.socialbase.downloader.pf.e.z(naVar));
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2) {
        if (this.g != null) {
            try {
                this.g.z(i, i2);
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public gk p(int i) {
        if (this.g == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.pf.e.z(this.g.p(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public un fv(int i) {
        if (this.g == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.pf.e.z(this.g.fv(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, gk gkVar) {
        if (this.g != null) {
            try {
                this.g.z(i, com.ss.android.socialbase.downloader.pf.e.z(gkVar));
            } catch (RemoteException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public q js(int i) {
        if (this.g == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.downloader.pf.e.z(this.g.js(i));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ls
    public void z(IBinder iBinder) {
        this.g = kb.z.z(iBinder);
        if (com.ss.android.socialbase.downloader.pf.m.z()) {
            z(new na() { // from class: com.ss.android.socialbase.downloader.impls.pf.1
                @Override // com.ss.android.socialbase.downloader.a.na
                public void z(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).g(i);
                        }
                    } else {
                        com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).z(i);
                        List<com.ss.android.socialbase.downloader.e.g> listFo = wp.z(false).fo(i);
                        if (listFo != null) {
                            wp.z(true).z(i, com.ss.android.socialbase.downloader.pf.m.z(listFo));
                        }
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ls
    public void gz() {
        this.g = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, long j) {
        if (this.g == null) {
            return;
        }
        try {
            this.g.z(i, j);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }
}
