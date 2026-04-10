package com.ss.android.socialbase.downloader.pf;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.a.e;
import com.ss.android.socialbase.downloader.a.eo;
import com.ss.android.socialbase.downloader.a.fo;
import com.ss.android.socialbase.downloader.a.fv;
import com.ss.android.socialbase.downloader.a.gk;
import com.ss.android.socialbase.downloader.a.gz;
import com.ss.android.socialbase.downloader.a.h;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.i;
import com.ss.android.socialbase.downloader.a.io;
import com.ss.android.socialbase.downloader.a.iq;
import com.ss.android.socialbase.downloader.a.js;
import com.ss.android.socialbase.downloader.a.kb;
import com.ss.android.socialbase.downloader.a.l;
import com.ss.android.socialbase.downloader.a.ls;
import com.ss.android.socialbase.downloader.a.m;
import com.ss.android.socialbase.downloader.a.mc;
import com.ss.android.socialbase.downloader.a.na;
import com.ss.android.socialbase.downloader.a.p;
import com.ss.android.socialbase.downloader.a.pf;
import com.ss.android.socialbase.downloader.a.q;
import com.ss.android.socialbase.downloader.a.sy;
import com.ss.android.socialbase.downloader.a.tb;
import com.ss.android.socialbase.downloader.a.uf;
import com.ss.android.socialbase.downloader.a.un;
import com.ss.android.socialbase.downloader.a.uy;
import com.ss.android.socialbase.downloader.a.v;
import com.ss.android.socialbase.downloader.a.wj;
import com.ss.android.socialbase.downloader.a.zw;
import com.ss.android.socialbase.downloader.e.z;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class e {
    private static Handler z = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.e.z z(final com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new z.AbstractBinderC0475z() { // from class: com.ss.android.socialbase.downloader.pf.e.1
            @Override // com.ss.android.socialbase.downloader.e.z
            public com.ss.android.socialbase.downloader.e.dl z() throws RemoteException {
                return aVar.z();
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public com.ss.android.socialbase.downloader.a.m g() throws RemoteException {
                return e.z(aVar.m());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public com.ss.android.socialbase.downloader.a.uy g(int i) throws RemoteException {
                return e.z(aVar.dl(m.gc(i)), i != com.ss.android.socialbase.downloader.g.gz.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public int z(int i) throws RemoteException {
                return aVar.g(m.gc(i));
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public com.ss.android.socialbase.downloader.a.uy z(int i, int i2) throws RemoteException {
                return e.z(aVar.z(m.gc(i), i2), i != com.ss.android.socialbase.downloader.g.gz.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public h dl() throws RemoteException {
                return e.z(aVar.uy());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public mc a() throws RemoteException {
                return e.z(aVar.kb());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public com.ss.android.socialbase.downloader.a.fo gc() throws RemoteException {
                return e.z(aVar.dl());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public com.ss.android.socialbase.downloader.a.e m() throws RemoteException {
                return e.z(aVar.a());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public kb uy() throws RemoteException {
                return e.z(aVar.gc());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public zw e() throws RemoteException {
                return e.z(aVar.gz());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public eo gz() throws RemoteException {
                return e.z(aVar.e());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public p fo() throws RemoteException {
                return e.z(aVar.fo());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public com.ss.android.socialbase.downloader.a.gz kb() throws RemoteException {
                return e.z(aVar.v());
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public int wp() throws RemoteException {
                return aVar.q().size();
            }

            @Override // com.ss.android.socialbase.downloader.e.z
            public i dl(int i) throws RemoteException {
                return e.z(aVar.m(i));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.a.uy z(final hh hhVar, final boolean z2) {
        if (hhVar == null) {
            return null;
        }
        return new uy.z() { // from class: com.ss.android.socialbase.downloader.pf.e.12
            @Override // com.ss.android.socialbase.downloader.a.uy
            public int z() throws RemoteException {
                return hhVar.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void z(final com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.z(dlVar);
                        }
                    });
                } else {
                    hhVar.z(dlVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void g(final com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.g(dlVar);
                        }
                    });
                } else {
                    hhVar.g(dlVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void dl(final com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.dl(dlVar);
                        }
                    });
                } else {
                    hhVar.dl(dlVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void a(final com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.a(dlVar);
                        }
                    });
                } else {
                    hhVar.a(dlVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void gc(final com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.gc(dlVar);
                        }
                    });
                } else {
                    hhVar.gc(dlVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void z(final com.ss.android.socialbase.downloader.e.dl dlVar, final com.ss.android.socialbase.downloader.gc.z zVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.z(dlVar, zVar);
                        }
                    });
                } else {
                    hhVar.z(dlVar, zVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void m(final com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.m(dlVar);
                        }
                    });
                } else {
                    hhVar.m(dlVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void e(final com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.gz(dlVar);
                        }
                    });
                } else {
                    hhVar.gz(dlVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void gz(final com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.fo(dlVar);
                        }
                    });
                } else {
                    hhVar.fo(dlVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void g(final com.ss.android.socialbase.downloader.e.dl dlVar, final com.ss.android.socialbase.downloader.gc.z zVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.g(dlVar, zVar);
                        }
                    });
                } else {
                    hhVar.g(dlVar, zVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void dl(final com.ss.android.socialbase.downloader.e.dl dlVar, final com.ss.android.socialbase.downloader.gc.z zVar) throws RemoteException {
                if (z2) {
                    e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            hhVar.dl(dlVar, zVar);
                        }
                    });
                } else {
                    hhVar.dl(dlVar, zVar);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.uy
            public void fo(final com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                hh hhVar2 = hhVar;
                if (hhVar2 instanceof tb) {
                    if (z2) {
                        e.z.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.pf.e.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((tb) hhVar).e(dlVar);
                            }
                        });
                    } else {
                        ((tb) hhVar2).e(dlVar);
                    }
                }
            }
        };
    }

    public static h z(final gk gkVar) {
        if (gkVar == null) {
            return null;
        }
        return new h.z() { // from class: com.ss.android.socialbase.downloader.pf.e.23
            @Override // com.ss.android.socialbase.downloader.a.h
            public void z(int i, com.ss.android.socialbase.downloader.e.dl dlVar, String str, String str2) throws RemoteException {
                gkVar.z(i, dlVar, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.a.h
            public boolean z(boolean z2) throws RemoteException {
                return gkVar.z(z2);
            }

            @Override // com.ss.android.socialbase.downloader.a.h
            public String z() throws RemoteException {
                return gkVar.z();
            }
        };
    }

    public static mc z(final un unVar) {
        if (unVar == null) {
            return null;
        }
        return new mc.z() { // from class: com.ss.android.socialbase.downloader.pf.e.26
            @Override // com.ss.android.socialbase.downloader.a.mc
            public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                return unVar.z(dlVar);
            }

            @Override // com.ss.android.socialbase.downloader.a.mc
            public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                return unVar.g(dlVar);
            }

            @Override // com.ss.android.socialbase.downloader.a.mc
            public boolean dl(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                return unVar.dl(dlVar);
            }
        };
    }

    public static eo z(final com.ss.android.socialbase.downloader.downloader.tb tbVar) {
        if (tbVar == null) {
            return null;
        }
        return new eo.z() { // from class: com.ss.android.socialbase.downloader.pf.e.27
            @Override // com.ss.android.socialbase.downloader.a.eo
            public long z(int i, int i2) throws RemoteException {
                return tbVar.z(i, i2);
            }
        };
    }

    public static zw z(final uf ufVar) {
        if (ufVar == null) {
            return null;
        }
        return new zw.z() { // from class: com.ss.android.socialbase.downloader.pf.e.28
            @Override // com.ss.android.socialbase.downloader.a.zw
            public boolean z(iq iqVar) throws RemoteException {
                return ufVar.z(e.z(iqVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.a.gz z(final q qVar) {
        if (qVar == null) {
            return null;
        }
        return new gz.z() { // from class: com.ss.android.socialbase.downloader.pf.e.29
            @Override // com.ss.android.socialbase.downloader.a.gz
            public Uri z(String str, String str2) throws RemoteException {
                return qVar.z(str, str2);
            }
        };
    }

    public static io z(final iq iqVar) {
        if (iqVar == null) {
            return null;
        }
        return new io() { // from class: com.ss.android.socialbase.downloader.pf.e.30
            @Override // com.ss.android.socialbase.downloader.a.io
            public void z(List<String> list) {
                try {
                    iqVar.z(list);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.io
            public boolean z() {
                try {
                    return iqVar.z();
                } catch (RemoteException e) {
                    wp.z(e);
                    return false;
                }
            }
        };
    }

    public static p z(final js jsVar) {
        if (jsVar == null) {
            return null;
        }
        return new p.z() { // from class: com.ss.android.socialbase.downloader.pf.e.31
            @Override // com.ss.android.socialbase.downloader.a.p
            public boolean z(long j, long j2, ls lsVar) throws RemoteException {
                return jsVar.z(j, j2, e.z(lsVar));
            }
        };
    }

    public static fv z(final ls lsVar) {
        if (lsVar == null) {
            return null;
        }
        return new fv() { // from class: com.ss.android.socialbase.downloader.pf.e.2
            @Override // com.ss.android.socialbase.downloader.a.fv
            public void z() {
                try {
                    lsVar.z();
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.a.e z(final pf pfVar) {
        if (pfVar == null) {
            return null;
        }
        return new e.z() { // from class: com.ss.android.socialbase.downloader.pf.e.3
            @Override // com.ss.android.socialbase.downloader.a.e
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i) throws RemoteException {
                pfVar.z(dlVar, zVar, i);
            }
        };
    }

    public static kb z(final l lVar) {
        if (lVar == null) {
            return null;
        }
        return new kb.z() { // from class: com.ss.android.socialbase.downloader.pf.e.4
            @Override // com.ss.android.socialbase.downloader.a.kb
            public void z(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    lVar.z(new JSONObject(str));
                } catch (JSONException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.kb
            public String z() throws RemoteException {
                return lVar.g();
            }

            @Override // com.ss.android.socialbase.downloader.a.kb
            public int[] g() throws RemoteException {
                l lVar2 = lVar;
                if (lVar2 instanceof com.ss.android.socialbase.downloader.a.a) {
                    return ((com.ss.android.socialbase.downloader.a.a) lVar2).z();
                }
                return null;
            }
        };
    }

    public static com.ss.android.socialbase.downloader.a.m z(final com.ss.android.socialbase.downloader.downloader.uy uyVar) {
        if (uyVar == null) {
            return null;
        }
        return new m.z() { // from class: com.ss.android.socialbase.downloader.pf.e.5
            @Override // com.ss.android.socialbase.downloader.a.m
            public int z(long j) throws RemoteException {
                return uyVar.z(j);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.a.fo z(final sy syVar) {
        if (syVar == null) {
            return null;
        }
        return new fo.z() { // from class: com.ss.android.socialbase.downloader.pf.e.6
            @Override // com.ss.android.socialbase.downloader.a.fo
            public boolean z() throws RemoteException {
                return syVar.z();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.e.a z(com.ss.android.socialbase.downloader.e.z zVar) {
        if (zVar == null) {
            return null;
        }
        try {
            com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(zVar.z());
            aVar.z(z(zVar.g())).z(z(zVar.dl())).z(z(zVar.gc())).z(z(zVar.m())).z(z(zVar.uy())).z(z(zVar.e())).z(z(zVar.fo())).z(z(zVar.kb())).z(z(zVar.a())).z(z(zVar.gz()));
            com.ss.android.socialbase.downloader.a.uy uyVarG = zVar.g(com.ss.android.socialbase.downloader.g.gz.MAIN.ordinal());
            if (uyVarG != null) {
                aVar.z(uyVarG.hashCode(), z(uyVarG));
            }
            com.ss.android.socialbase.downloader.a.uy uyVarG2 = zVar.g(com.ss.android.socialbase.downloader.g.gz.SUB.ordinal());
            if (uyVarG2 != null) {
                aVar.g(uyVarG2.hashCode(), z(uyVarG2));
            }
            com.ss.android.socialbase.downloader.a.uy uyVarG3 = zVar.g(com.ss.android.socialbase.downloader.g.gz.NOTIFICATION.ordinal());
            if (uyVarG3 != null) {
                aVar.dl(uyVarG3.hashCode(), z(uyVarG3));
            }
            z(aVar, zVar, com.ss.android.socialbase.downloader.g.gz.MAIN);
            z(aVar, zVar, com.ss.android.socialbase.downloader.g.gz.SUB);
            z(aVar, zVar, com.ss.android.socialbase.downloader.g.gz.NOTIFICATION);
            z(aVar, zVar);
            return aVar;
        } catch (RemoteException e) {
            wp.z(e);
            return null;
        }
    }

    private static void z(com.ss.android.socialbase.downloader.e.a aVar, com.ss.android.socialbase.downloader.e.z zVar, com.ss.android.socialbase.downloader.g.gz gzVar) throws RemoteException {
        SparseArray<hh> sparseArray = new SparseArray<>();
        for (int i = 0; i < zVar.z(gzVar.ordinal()); i++) {
            com.ss.android.socialbase.downloader.a.uy uyVarZ = zVar.z(gzVar.ordinal(), i);
            if (uyVarZ != null) {
                sparseArray.put(uyVarZ.z(), z(uyVarZ));
            }
        }
        aVar.z(sparseArray, gzVar);
    }

    private static void z(com.ss.android.socialbase.downloader.e.a aVar, com.ss.android.socialbase.downloader.e.z zVar) throws RemoteException {
        for (int i = 0; i < zVar.wp(); i++) {
            i iVarDl = zVar.dl(i);
            if (iVarDl != null) {
                aVar.z(z(iVarDl));
            }
        }
    }

    public static gk z(final h hVar) {
        if (hVar == null) {
            return null;
        }
        return new gk() { // from class: com.ss.android.socialbase.downloader.pf.e.7
            @Override // com.ss.android.socialbase.downloader.a.gk
            public void z(int i, com.ss.android.socialbase.downloader.e.dl dlVar, String str, String str2) {
                try {
                    hVar.z(i, dlVar, str, str2);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.gk
            public boolean z(boolean z2) {
                try {
                    return hVar.z(z2);
                } catch (RemoteException e) {
                    wp.z(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.gk
            public String z() {
                try {
                    return hVar.z();
                } catch (RemoteException e) {
                    wp.z(e);
                    return null;
                }
            }
        };
    }

    public static v z(final i iVar) {
        if (iVar == null) {
            return null;
        }
        return new v() { // from class: com.ss.android.socialbase.downloader.pf.e.8
            @Override // com.ss.android.socialbase.downloader.a.v
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar) throws com.ss.android.socialbase.downloader.gc.z {
                try {
                    iVar.z(dlVar);
                } catch (RemoteException e) {
                    throw new com.ss.android.socialbase.downloader.gc.z(1008, e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.v
            public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    return iVar.g(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                    return false;
                }
            }
        };
    }

    public static i z(final v vVar) {
        if (vVar == null) {
            return null;
        }
        return new i.z() { // from class: com.ss.android.socialbase.downloader.pf.e.9
            @Override // com.ss.android.socialbase.downloader.a.i
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                try {
                    vVar.z(dlVar);
                } catch (com.ss.android.socialbase.downloader.gc.z e) {
                    throw new IllegalArgumentException(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.i
            public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) throws RemoteException {
                return vVar.g(dlVar);
            }
        };
    }

    public static un z(final mc mcVar) {
        if (mcVar == null) {
            return null;
        }
        return new un() { // from class: com.ss.android.socialbase.downloader.pf.e.10
            @Override // com.ss.android.socialbase.downloader.a.un
            public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    return mcVar.z(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.un
            public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    return mcVar.g(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.un
            public boolean dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    return mcVar.dl(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.uy z(final com.ss.android.socialbase.downloader.a.m mVar) {
        if (mVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.uy() { // from class: com.ss.android.socialbase.downloader.pf.e.11
            @Override // com.ss.android.socialbase.downloader.downloader.uy
            public int z(long j) {
                try {
                    return mVar.z(j);
                } catch (RemoteException e) {
                    wp.z(e);
                    return 0;
                }
            }
        };
    }

    public static pf z(final com.ss.android.socialbase.downloader.a.e eVar) {
        if (eVar == null) {
            return null;
        }
        return new pf() { // from class: com.ss.android.socialbase.downloader.pf.e.13
            @Override // com.ss.android.socialbase.downloader.a.pf
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar, int i) {
                if (dlVar == null) {
                    return;
                }
                try {
                    eVar.z(dlVar, zVar, i);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }
        };
    }

    public static l z(final kb kbVar) {
        if (kbVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.a.a() { // from class: com.ss.android.socialbase.downloader.pf.e.14
            @Override // com.ss.android.socialbase.downloader.a.l
            public void z(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    kbVar.z(jSONObject.toString());
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.l
            public String g() {
                try {
                    return kbVar.z();
                } catch (RemoteException e) {
                    wp.z(e);
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.a
            public int[] z() {
                try {
                    return kbVar.g();
                } catch (RemoteException e) {
                    wp.z(e);
                    return null;
                }
            }
        };
    }

    public static uf z(final zw zwVar) {
        if (zwVar == null) {
            return null;
        }
        return new uf() { // from class: com.ss.android.socialbase.downloader.pf.e.15
            @Override // com.ss.android.socialbase.downloader.a.uf
            public boolean z(io ioVar) {
                try {
                    return zwVar.z(e.z(ioVar));
                } catch (RemoteException e) {
                    wp.z(e);
                    return false;
                }
            }
        };
    }

    public static iq z(final io ioVar) {
        if (ioVar == null) {
            return null;
        }
        return new iq.z() { // from class: com.ss.android.socialbase.downloader.pf.e.16
            @Override // com.ss.android.socialbase.downloader.a.iq
            public void z(List<String> list) {
                ioVar.z(list);
            }

            @Override // com.ss.android.socialbase.downloader.a.iq
            public boolean z() {
                return ioVar.z();
            }
        };
    }

    public static wj z(final na naVar) {
        if (naVar == null) {
            return null;
        }
        return new wj.z() { // from class: com.ss.android.socialbase.downloader.pf.e.17
            @Override // com.ss.android.socialbase.downloader.a.wj
            public void z(int i, int i2) {
                naVar.z(i, i2);
            }
        };
    }

    public static na z(final wj wjVar) {
        if (wjVar == null) {
            return null;
        }
        return new na() { // from class: com.ss.android.socialbase.downloader.pf.e.18
            @Override // com.ss.android.socialbase.downloader.a.na
            public void z(int i, int i2) {
                try {
                    wjVar.z(i, i2);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }
        };
    }

    public static js z(final p pVar) {
        if (pVar == null) {
            return null;
        }
        return new js() { // from class: com.ss.android.socialbase.downloader.pf.e.19
            @Override // com.ss.android.socialbase.downloader.a.js
            public boolean z(long j, long j2, fv fvVar) {
                try {
                    return pVar.z(j, j2, e.z(fvVar));
                } catch (RemoteException e) {
                    wp.z(e);
                    return false;
                }
            }
        };
    }

    public static ls z(final fv fvVar) {
        if (fvVar == null) {
            return null;
        }
        return new ls.z() { // from class: com.ss.android.socialbase.downloader.pf.e.20
            @Override // com.ss.android.socialbase.downloader.a.ls
            public void z() throws RemoteException {
                fvVar.z();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.tb z(final eo eoVar) {
        if (eoVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.tb() { // from class: com.ss.android.socialbase.downloader.pf.e.21
            @Override // com.ss.android.socialbase.downloader.downloader.tb
            public long z(int i, int i2) {
                try {
                    return eoVar.z(i, i2);
                } catch (RemoteException e) {
                    wp.z(e);
                    return 0L;
                }
            }
        };
    }

    public static sy z(final com.ss.android.socialbase.downloader.a.fo foVar) {
        if (foVar == null) {
            return null;
        }
        return new sy() { // from class: com.ss.android.socialbase.downloader.pf.e.22
            @Override // com.ss.android.socialbase.downloader.a.sy
            public boolean z() {
                try {
                    return foVar.z();
                } catch (RemoteException e) {
                    wp.z(e);
                    return false;
                }
            }
        };
    }

    public static q z(final com.ss.android.socialbase.downloader.a.gz gzVar) {
        if (gzVar == null) {
            return null;
        }
        return new q() { // from class: com.ss.android.socialbase.downloader.pf.e.24
            @Override // com.ss.android.socialbase.downloader.a.q
            public Uri z(String str, String str2) {
                try {
                    return gzVar.z(str, str2);
                } catch (RemoteException e) {
                    wp.z(e);
                    return null;
                }
            }
        };
    }

    public static hh z(final com.ss.android.socialbase.downloader.a.uy uyVar) {
        if (uyVar == null) {
            return null;
        }
        return new tb() { // from class: com.ss.android.socialbase.downloader.pf.e.25
            @Override // com.ss.android.socialbase.downloader.a.tb
            public void e(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    uyVar.fo(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    uyVar.z(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void g(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    uyVar.g(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    uyVar.dl(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void a(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    uyVar.a(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void gc(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    uyVar.gc(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
                try {
                    uyVar.z(dlVar, zVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void m(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    uyVar.m(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void gz(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    uyVar.e(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void fo(com.ss.android.socialbase.downloader.e.dl dlVar) {
                try {
                    uyVar.gz(dlVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void g(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
                try {
                    uyVar.g(dlVar, zVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }

            @Override // com.ss.android.socialbase.downloader.a.hh
            public void dl(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
                try {
                    uyVar.dl(dlVar, zVar);
                } catch (RemoteException e) {
                    wp.z(e);
                }
            }
        };
    }
}
