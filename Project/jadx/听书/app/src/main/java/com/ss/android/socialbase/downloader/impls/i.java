package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.a.h;
import com.ss.android.socialbase.downloader.a.mc;
import com.ss.android.socialbase.downloader.a.wj;
import com.ss.android.socialbase.downloader.downloader.kb;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class i extends kb.z {
    private static final String z = "i";
    private final com.ss.android.socialbase.downloader.downloader.pf g = new ls(true);

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(com.ss.android.socialbase.downloader.e.z zVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.g(com.ss.android.socialbase.downloader.pf.e.z(zVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean g(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.g(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void dl(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.dl(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void a(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.a(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public long gc(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return 0L;
        }
        return pfVar.gc(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public int m(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return 0;
        }
        return pfVar.m(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean e(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.e(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public com.ss.android.socialbase.downloader.e.dl gz(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return pfVar.gz(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public List<com.ss.android.socialbase.downloader.e.dl> z(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return pfVar.z(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public List<com.ss.android.socialbase.downloader.e.g> fo(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return pfVar.fo(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public int z(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return 0;
        }
        return pfVar.z(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public com.ss.android.socialbase.downloader.e.dl g(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return pfVar.g(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public List<com.ss.android.socialbase.downloader.e.dl> g(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return pfVar.g(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public List<com.ss.android.socialbase.downloader.e.dl> dl(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return pfVar.dl(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public List<com.ss.android.socialbase.downloader.e.dl> a(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return pfVar.gc(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public List<com.ss.android.socialbase.downloader.e.dl> g() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return pfVar.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void g(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar != null) {
            pfVar.g(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void g(int i, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.g(i, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void dl(int i, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.g(i, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void uy(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.uy(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, int i2, com.ss.android.socialbase.downloader.a.uy uyVar, int i3, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.g(i, i2, com.ss.android.socialbase.downloader.pf.e.z(uyVar), com.ss.android.socialbase.downloader.pf.m.gc(i3), z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void g(int i, int i2, com.ss.android.socialbase.downloader.a.uy uyVar, int i3, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, i2, com.ss.android.socialbase.downloader.pf.e.z(uyVar), com.ss.android.socialbase.downloader.pf.m.gc(i3), z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, int i2, com.ss.android.socialbase.downloader.a.uy uyVar, int i3, boolean z2, boolean z3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, i2, com.ss.android.socialbase.downloader.pf.e.z(uyVar), com.ss.android.socialbase.downloader.pf.m.gc(i3), z2, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.z(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, Notification notification) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(true, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean m() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.g();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean dl() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.dl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public List<com.ss.android.socialbase.downloader.e.dl> gc(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return pfVar.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean kb(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.wp(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void wp(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.kb(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean a() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.gc();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void a(int i, boolean z2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.a.z().g(i, z2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public int i(int i) throws RemoteException {
        return com.ss.android.socialbase.downloader.downloader.a.z().g(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(com.ss.android.socialbase.downloader.e.g gVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(gVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.dl(dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean v(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.v(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void pf(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.pf(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, int i2, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, i2, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, int i2, int i3, long j) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, i2, i3, j);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, int i2, int i3, int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, i2, i3, i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public boolean ls(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return false;
        }
        return pfVar.ls(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void gc() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.m();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.g(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void g(int i, List<com.ss.android.socialbase.downloader.e.g> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(wj wjVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(com.ss.android.socialbase.downloader.pf.e.z(wjVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, int i2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public h p(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.pf.e.z(pfVar.p(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public mc fv(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.pf.e.z(pfVar.fv(i));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public void z(int i, h hVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return;
        }
        pfVar.z(i, com.ss.android.socialbase.downloader.pf.e.z(hVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.kb
    public com.ss.android.socialbase.downloader.a.gz js(int i) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.pf pfVar = this.g;
        if (pfVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.pf.e.z(pfVar.js(i));
    }
}
