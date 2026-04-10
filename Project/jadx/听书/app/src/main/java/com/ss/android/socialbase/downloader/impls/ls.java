package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.na;
import com.ss.android.socialbase.downloader.a.q;
import com.ss.android.socialbase.downloader.a.un;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ls implements com.ss.android.socialbase.downloader.downloader.pf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f2093a;
    private final com.ss.android.socialbase.downloader.downloader.p dl;
    private final com.ss.android.socialbase.downloader.downloader.wp g;
    private final z z;

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void startService() {
    }

    public ls() {
        this(false);
    }

    public ls(boolean z) {
        this.z = com.ss.android.socialbase.downloader.downloader.dl.h();
        this.g = com.ss.android.socialbase.downloader.downloader.dl.io();
        if (!z) {
            this.dl = com.ss.android.socialbase.downloader.downloader.dl.uf();
        } else {
            this.dl = com.ss.android.socialbase.downloader.downloader.dl.sy();
        }
        this.f2093a = com.ss.android.socialbase.downloader.i.z.dl().g("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.gc(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, boolean z) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.z(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean g(int i) {
        z zVar = this.z;
        if (zVar != null) {
            return zVar.v(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void dl(int i) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.m(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void a(int i) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.e(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z() {
        z zVar = this.z;
        if (zVar != null) {
            zVar.g();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> g(String str) {
        com.ss.android.socialbase.downloader.downloader.wp wpVar = this.g;
        if (wpVar != null) {
            return wpVar.g(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> a() {
        com.ss.android.socialbase.downloader.downloader.wp wpVar = this.g;
        if (wpVar != null) {
            return wpVar.g();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(List<String> list) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.z(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(List<String> list) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.g(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public long gc(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarG;
        com.ss.android.socialbase.downloader.downloader.wp wpVar = this.g;
        if (wpVar == null || (dlVarG = wpVar.g(i)) == null) {
            return 0L;
        }
        int iUx = dlVarG.ux();
        if (iUx <= 1) {
            return dlVarG.sf();
        }
        List<com.ss.android.socialbase.downloader.e.g> listDl = this.g.dl(i);
        if (listDl == null || listDl.size() != iUx) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.pf.m.g(listDl);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public int m(int i) {
        com.ss.android.socialbase.downloader.e.dl dlVarA;
        z zVar = this.z;
        if (zVar == null || (dlVarA = zVar.a(i)) == null) {
            return 0;
        }
        return dlVarA.p();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean e(int i) {
        z zVar = this.z;
        if (zVar != null) {
            return zVar.z(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public com.ss.android.socialbase.downloader.e.dl gz(int i) {
        z zVar = this.z;
        if (zVar != null) {
            return zVar.a(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> z(String str) {
        z zVar = this.z;
        if (zVar != null) {
            return zVar.z(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.g> fo(int i) {
        return this.g.dl(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public com.ss.android.socialbase.downloader.e.dl g(String str, String str2) {
        return gz(com.ss.android.socialbase.downloader.downloader.dl.z(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public int z(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.dl.z(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) {
        com.ss.android.socialbase.downloader.downloader.wp wpVar = this.g;
        if (wpVar != null) {
            return wpVar.dl(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(int i, boolean z) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.g(i, z);
        }
    }

    public void a(int i, boolean z) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.dl(i, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void uy(int i) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.i(i);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.g(i, i2, hhVar, gzVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z, boolean z2) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.z(i, i2, hhVar, gzVar, z, z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(int i, int i2, hh hhVar, com.ss.android.socialbase.downloader.g.gz gzVar, boolean z) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.z(i, i2, hhVar, gzVar, z);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null) {
            return false;
        }
        boolean z = com.ss.android.socialbase.downloader.pf.m.z(dlVar.p(), dlVar.kb(), dlVar.gz());
        if (z) {
            if (com.ss.android.socialbase.downloader.pf.z.z(33554432)) {
                g(dlVar.e(), true);
            } else {
                a(dlVar.e(), true);
            }
        }
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.p pVar = this.dl;
        if (pVar != null) {
            pVar.z(i, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(boolean z, boolean z2) {
        com.ss.android.socialbase.downloader.downloader.p pVar = this.dl;
        if (pVar != null) {
            pVar.z(z2);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean g() {
        com.ss.android.socialbase.downloader.downloader.p pVar = this.dl;
        if (pVar != null) {
            return pVar.g();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean dl() {
        return com.ss.android.socialbase.downloader.downloader.dl.j();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> a(String str) {
        com.ss.android.socialbase.downloader.downloader.wp wpVar = this.g;
        if (wpVar != null) {
            return wpVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public List<com.ss.android.socialbase.downloader.e.dl> gc(String str) {
        z zVar = this.z;
        if (zVar != null) {
            return zVar.g(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.downloader.p pVar = this.dl;
        if (pVar != null) {
            pVar.g(aVar);
        } else if (aVar != null) {
            com.ss.android.socialbase.downloader.gz.z.z(aVar.gc(), aVar.z(), new com.ss.android.socialbase.downloader.gc.z(1003, "downloadServiceHandler is null"), aVar.z() != null ? aVar.z().p() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(com.ss.android.socialbase.downloader.e.a aVar) {
        com.ss.android.socialbase.downloader.downloader.p pVar = this.dl;
        if (pVar != null) {
            pVar.dl(aVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean wp(int i) {
        z zVar = this.z;
        if (zVar != null) {
            return zVar.kb(i);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void kb(int i) {
        com.ss.android.socialbase.downloader.m.z.z(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean gc() {
        return this.g.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        this.g.g(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        this.g.z(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void dl(int i, boolean z) {
        com.ss.android.socialbase.downloader.downloader.a.z().z(i, z);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public int i(int i) {
        return com.ss.android.socialbase.downloader.downloader.a.z().z(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(com.ss.android.socialbase.downloader.e.g gVar) {
        this.g.z(gVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
        return this.g.z(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean v(int i) {
        return this.g.gc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void pf(int i) {
        this.g.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, long j) {
        this.g.z(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, int i3, long j) {
        this.g.z(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2, int i3, int i4) {
        this.g.z(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean ls(int i) {
        return this.g.m(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void m() {
        this.g.dl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) {
        this.g.g(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public boolean e() {
        com.ss.android.socialbase.downloader.downloader.p pVar;
        return this.f2093a && (pVar = this.dl) != null && pVar.z();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(na naVar) {
        com.ss.android.socialbase.downloader.downloader.dl.z(naVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, int i2) {
        if (com.ss.android.socialbase.downloader.downloader.dl.a() != null) {
            for (na naVar : com.ss.android.socialbase.downloader.downloader.dl.a()) {
                if (naVar != null) {
                    naVar.z(i2, i);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public gk p(int i) {
        z zVar = this.z;
        if (zVar != null) {
            return zVar.fo(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public un fv(int i) {
        z zVar = this.z;
        un unVarGz = zVar != null ? zVar.gz(i) : null;
        return unVarGz == null ? com.ss.android.socialbase.downloader.downloader.dl.eo() : unVarGz;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, gk gkVar) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.z(i, gkVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public q js(int i) {
        z zVar = this.z;
        if (zVar != null) {
            return zVar.uy(i);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.pf
    public void z(int i, long j) {
        z zVar = this.z;
        if (zVar != null) {
            zVar.g(i, j);
        }
    }
}
