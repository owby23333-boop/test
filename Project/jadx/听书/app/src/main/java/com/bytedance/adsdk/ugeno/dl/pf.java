package com.bytedance.adsdk.ugeno.dl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.dl.fo;
import com.bytedance.adsdk.ugeno.g.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uy f230a;
    private com.bytedance.adsdk.ugeno.g.dl<View> dl;
    private tb e;
    private fo fo;
    private gz fv;
    private JSONObject g;
    private fv gc;
    private js gz;
    private kb iq;
    private m js;
    private v kb;
    private boolean ls;
    private iq m;
    private List<String> p;
    private com.bytedance.adsdk.ugeno.gc.z.z pf;
    private float q;
    private float tb;
    private String uy;
    private JSONObject wp;
    private Context z;
    private boolean i = true;
    private boolean v = false;

    public pf(Context context) {
        this.z = context;
    }

    public void z(String str, v vVar) {
        this.kb = vVar;
        this.uy = str;
        if (vVar != null) {
            this.g = vVar.z();
        }
    }

    public com.bytedance.adsdk.ugeno.g.dl<View> z(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.g = jSONObject2;
        iq iqVar = this.m;
        if (iqVar != null) {
            iqVar.z();
        }
        fo foVar = new fo(jSONObject, jSONObject2, jSONObject3);
        this.fo = foVar;
        foVar.z(this.tb, this.q);
        this.pf = new com.bytedance.adsdk.ugeno.gc.z.z();
        fv fvVar = this.gc;
        if (fvVar instanceof com.bytedance.adsdk.ugeno.dl.z.g) {
            ((com.bytedance.adsdk.ugeno.dl.z.g) fvVar).z(this.fo.g());
        }
        this.dl = z(this.fo.z(), (com.bytedance.adsdk.ugeno.g.dl<View>) null);
        kb kbVar = this.iq;
        if (kbVar != null) {
            kbVar.g();
            if (this.iq.dl()) {
                this.iq.z(this.gz);
            }
            this.iq.z(this.m);
        }
        iq iqVar2 = this.m;
        if (iqVar2 != null) {
            iqVar2.g();
            this.dl.z(this.m);
            this.m.dl();
        }
        g(this.dl);
        if (this.m != null) {
            q qVar = new q();
            qVar.z(0);
            qVar.z(this.dl);
            this.m.z(qVar);
        }
        return this.dl;
    }

    public com.bytedance.adsdk.ugeno.g.dl<View> z(fo.z zVar, com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
        List<fo.z> listDl;
        z.C0045z c0045zGz = null;
        if (!fo.a(zVar)) {
            return null;
        }
        gz gzVar = this.fv;
        if (gzVar != null) {
            gzVar.z(zVar);
        }
        String strDl = zVar.dl();
        g gVarZ = a.z(strDl);
        g gVar = gVarZ;
        if (gVarZ == null) {
            this.ls = true;
            if (this.p == null) {
                this.p = new ArrayList();
            }
            this.p.add(strDl);
            strDl = "View";
            zVar.z("View");
            g gVarZ2 = a.z("View");
            gVar = gVarZ2;
            if (gVarZ2 == null) {
                return null;
            }
        }
        com.bytedance.adsdk.ugeno.g.dl dlVarZ = gVar.z(this.z);
        if (dlVarZ == null) {
            return null;
        }
        JSONObject jSONObjectA = zVar.a();
        dlVarZ.e(com.bytedance.adsdk.ugeno.a.g.z(zVar.z(), this.g));
        dlVarZ.gz(strDl);
        dlVarZ.dl(jSONObjectA);
        dlVarZ.z(zVar);
        dlVarZ.g(this.g);
        fo foVar = this.fo;
        if (foVar == null) {
            dlVarZ.dl(true);
        } else {
            dlVarZ.dl(foVar.a());
        }
        dlVarZ.z(this.kb);
        dlVarZ.z(this.pf);
        Iterator<String> itKeys = jSONObjectA.keys();
        if (dlVar instanceof com.bytedance.adsdk.ugeno.g.z) {
            com.bytedance.adsdk.ugeno.g.z zVar2 = (com.bytedance.adsdk.ugeno.g.z) dlVar;
            c0045zGz = zVar2.gz();
            dlVarZ.z(zVar2);
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strZ = com.bytedance.adsdk.ugeno.a.g.z(jSONObjectA.optString(next), this.g);
            dlVarZ.z(next, strZ);
            kb kbVar = this.iq;
            if (kbVar != null) {
                kbVar.z(next, strZ);
            }
            if (c0045zGz != null) {
                c0045zGz.z(this.z, next, strZ);
            }
        }
        if (c0045zGz != null) {
            dlVarZ.z(c0045zGz.z());
        }
        if (dlVarZ instanceof com.bytedance.adsdk.ugeno.g.z) {
            List<fo.z> listGc = zVar.gc();
            if (listGc == null || listGc.size() <= 0) {
                if (TextUtils.equals(dlVarZ.lq(), "RecyclerLayout") && (listDl = this.fo.dl()) != null && listDl.size() > 0) {
                    Iterator<fo.z> it = listDl.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.g.dl<View> dlVarZ2 = z(it.next(), (com.bytedance.adsdk.ugeno.g.dl<View>) dlVarZ);
                        if (dlVarZ2 != null && dlVarZ2.eo()) {
                            ((com.bytedance.adsdk.ugeno.g.z) dlVarZ).z(dlVarZ2);
                        }
                    }
                }
                return dlVarZ;
            }
            if (TextUtils.equals(dlVarZ.lq(), "Swiper") && listGc.size() != 1) {
                com.bytedance.sdk.component.utils.wp.a("UGTemplateEngine", "Swiper must be only one widget");
            }
            try {
                Collections.sort(listGc, new Comparator<fo.z>() { // from class: com.bytedance.adsdk.ugeno.dl.pf.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                    public int compare(fo.z zVar3, fo.z zVar4) {
                        return zVar3.a().optInt("order", 0) - zVar4.a().optInt("order", 0);
                    }
                });
            } catch (Throwable unused) {
            }
            Iterator<fo.z> it2 = listGc.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.g.dl<View> dlVarZ3 = z(it2.next(), (com.bytedance.adsdk.ugeno.g.dl<View>) dlVarZ);
                if (dlVarZ3 != null && !dlVarZ3.bv()) {
                    ((com.bytedance.adsdk.ugeno.g.z) dlVarZ).z(dlVarZ3, dlVarZ3.hh());
                }
            }
        }
        this.dl = dlVarZ;
        return dlVarZ;
    }

    public com.bytedance.adsdk.ugeno.g.dl<View> z(JSONObject jSONObject) {
        iq iqVar = this.m;
        if (iqVar != null) {
            iqVar.z();
        }
        fo foVar = new fo(jSONObject, this.g);
        this.fo = foVar;
        fv fvVar = this.gc;
        if (fvVar instanceof com.bytedance.adsdk.ugeno.dl.z.g) {
            ((com.bytedance.adsdk.ugeno.dl.z.g) fvVar).z(foVar.g());
        }
        this.dl = g(this.fo.z(), null);
        iq iqVar2 = this.m;
        if (iqVar2 != null) {
            iqVar2.g();
            this.dl.z(this.m);
        }
        return this.dl;
    }

    public com.bytedance.adsdk.ugeno.g.dl<View> z(fo.z zVar) {
        com.bytedance.adsdk.ugeno.g.dl<View> dlVarG = g(zVar, null);
        this.dl = dlVarG;
        return dlVarG;
    }

    public com.bytedance.adsdk.ugeno.g.dl<View> g(fo.z zVar, com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
        List<fo.z> listDl;
        z.C0045z c0045zGz = null;
        if (!fo.a(zVar)) {
            return null;
        }
        gz gzVar = this.fv;
        if (gzVar != null) {
            gzVar.g(zVar);
        }
        String strDl = zVar.dl();
        g gVarZ = a.z(strDl);
        if (gVarZ == null) {
            this.ls = true;
            if (this.p == null) {
                this.p = new ArrayList();
            }
            this.p.add(strDl);
            return null;
        }
        com.bytedance.adsdk.ugeno.g.dl dlVarZ = gVarZ.z(this.z);
        if (dlVarZ == null) {
            return null;
        }
        dlVarZ.e(com.bytedance.adsdk.ugeno.a.g.z(zVar.z(), this.g));
        dlVarZ.gz(strDl);
        dlVarZ.dl(zVar.a());
        dlVarZ.z(zVar);
        dlVarZ.z(this.kb);
        if (dlVar instanceof com.bytedance.adsdk.ugeno.g.z) {
            com.bytedance.adsdk.ugeno.g.z zVar2 = (com.bytedance.adsdk.ugeno.g.z) dlVar;
            dlVarZ.z(zVar2);
            c0045zGz = zVar2.gz();
        }
        Iterator<String> itKeys = zVar.a().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strZ = com.bytedance.adsdk.ugeno.a.g.z(zVar.a().optString(next), this.g);
            dlVarZ.z(next, strZ);
            if (c0045zGz != null) {
                c0045zGz.z(this.z, next, strZ);
            }
        }
        if (dlVarZ instanceof com.bytedance.adsdk.ugeno.g.z) {
            List<fo.z> listGc = zVar.gc();
            if (listGc == null || listGc.size() <= 0) {
                if (TextUtils.equals(dlVarZ.lq(), "RecyclerLayout") && (listDl = this.fo.dl()) != null && listDl.size() > 0) {
                    Iterator<fo.z> it = listDl.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.g.dl<View> dlVarG = g(it.next(), dlVarZ);
                        if (dlVarG != null && dlVarG.eo()) {
                            ((com.bytedance.adsdk.ugeno.g.z) dlVarZ).z(dlVarG);
                        }
                    }
                }
                return dlVarZ;
            }
            if (TextUtils.equals(dlVarZ.lq(), "Swiper") && listGc.size() != 1) {
                com.bytedance.sdk.component.utils.wp.a("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<fo.z> it2 = listGc.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.g.dl<View> dlVarG2 = g(it2.next(), dlVarZ);
                if (dlVarG2 != null && dlVarG2.eo()) {
                    ((com.bytedance.adsdk.ugeno.g.z) dlVarZ).z(dlVarG2);
                }
            }
        }
        if (c0045zGz != null) {
            dlVarZ.z(c0045zGz.z());
        }
        this.dl = dlVarZ;
        return dlVarZ;
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        List<com.bytedance.adsdk.ugeno.g.dl<View>> listE;
        if (dlVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.g.z zVarGk = dlVar.gk();
        if (zVarGk != null) {
            z.C0045z c0045zGz = zVarGk.gz();
            Iterator<String> itKeys = dlVar.io().keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strZ = com.bytedance.adsdk.ugeno.a.g.z(dlVar.io().optString(next), this.g);
                dlVar.z(next, strZ);
                c0045zGz.z(this.z, next, strZ);
            }
            dlVar.z(c0045zGz.z());
        }
        if (!(dlVar instanceof com.bytedance.adsdk.ugeno.g.z) || (listE = ((com.bytedance.adsdk.ugeno.g.z) dlVar).e()) == null || listE.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.g.dl<View>> it = listE.iterator();
        while (it.hasNext()) {
            z(it.next());
        }
    }

    public void g(JSONObject jSONObject) {
        iq iqVar = this.m;
        if (iqVar != null) {
            iqVar.dl();
        }
        this.g = jSONObject;
        z(this.dl, jSONObject);
        g(this.dl);
        if (this.m != null) {
            q qVar = new q();
            qVar.z(0);
            qVar.z(this.dl);
            this.m.z(qVar);
        }
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, JSONObject jSONObject) {
        if (dlVar == null) {
            return;
        }
        if (dlVar instanceof com.bytedance.adsdk.ugeno.g.z) {
            dlVar.z(jSONObject);
            List<com.bytedance.adsdk.ugeno.g.dl<View>> listE = ((com.bytedance.adsdk.ugeno.g.z) dlVar).e();
            if (listE == null || listE.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.g.dl<View>> it = listE.iterator();
            while (it.hasNext()) {
                z(it.next(), jSONObject);
            }
            return;
        }
        dlVar.z(jSONObject);
    }

    private void g(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
        List<com.bytedance.adsdk.ugeno.g.dl<View>> listE;
        if (dlVar == null) {
            return;
        }
        JSONObject jSONObjectIo = dlVar.io();
        Iterator<String> itKeys = jSONObjectIo.keys();
        com.bytedance.adsdk.ugeno.g.z zVarGk = dlVar.gk();
        z.C0045z c0045zGz = zVarGk != null ? zVarGk.gz() : null;
        dl(dlVar);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strZ = com.bytedance.adsdk.ugeno.a.g.z(jSONObjectIo.optString(next), this.g);
            dlVar.z(next, strZ);
            if (c0045zGz != null) {
                c0045zGz.z(this.z, next, strZ);
            }
        }
        dlVar.z(this.f230a);
        dlVar.z(this.gc);
        dlVar.z(this.e);
        kb kbVar = this.iq;
        if (kbVar != null) {
            dlVar.z(kbVar);
        }
        m mVar = this.js;
        if (mVar != null) {
            dlVar.z(mVar);
        }
        if ((dlVar instanceof com.bytedance.adsdk.ugeno.g.z) && (listE = ((com.bytedance.adsdk.ugeno.g.z) dlVar).e()) != null && listE.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.g.dl<View>> it = listE.iterator();
            while (it.hasNext()) {
                g(it.next());
            }
        }
        if (c0045zGz != null) {
            dlVar.z(c0045zGz.z());
        }
        dlVar.g();
    }

    private void dl(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        try {
            if (!dlVar.h() || dlVar.l() == null || dlVar.l().m() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", dlVar.l().m());
            this.g.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void z(uy uyVar) {
        this.f230a = uyVar;
    }

    public void z(fv fvVar) {
        com.bytedance.adsdk.ugeno.dl.z.z zVarGc = com.bytedance.adsdk.ugeno.a.z().gc();
        if (zVarGc == null) {
            this.gc = fvVar;
            return;
        }
        com.bytedance.adsdk.ugeno.dl.z.g gVarZ = zVarGc.z(fvVar);
        if (gVarZ == null) {
            this.gc = fvVar;
            return;
        }
        gVarZ.z(this.wp);
        gVarZ.z(this.i);
        gVarZ.g(this.v);
        fo foVar = this.fo;
        if (foVar != null) {
            gVarZ.z(foVar.g());
        }
        this.gc = gVarZ;
    }

    public void z(tb tbVar) {
        this.e = tbVar;
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.g.dl<View>> listE;
        if (dlVar == null) {
            return;
        }
        dlVar.z(str, objArr);
        if (!(dlVar instanceof com.bytedance.adsdk.ugeno.g.z) || (listE = ((com.bytedance.adsdk.ugeno.g.z) dlVar).e()) == null || listE.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.g.dl<View>> it = listE.iterator();
        while (it.hasNext()) {
            z(it.next(), str, objArr);
        }
    }

    public boolean z() {
        return this.ls;
    }

    public List<String> g() {
        return this.p;
    }

    public void z(gz gzVar) {
        this.fv = gzVar;
    }
}
