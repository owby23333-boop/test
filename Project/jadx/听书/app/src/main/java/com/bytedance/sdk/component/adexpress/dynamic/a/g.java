package com.bytedance.sdk.component.adexpress.dynamic.a;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.utils.wp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private double e;
    private i fo;
    private double gc;
    private String gz;
    private int m;
    public Map<String, dl> z = new HashMap();
    public Map<String, dl> g = new HashMap();
    public Map<String, dl> dl = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f541a = Math.random();

    public g(double d, int i, double d2, String str, i iVar) {
        this.gc = d;
        this.m = i;
        this.e = d2;
        this.gz = str;
        this.fo = iVar;
    }

    public dl z(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(gzVar.uy().g()) && gzVar.uy().gc().tc() == null) {
            return new dl(0.0f, 0.0f);
        }
        if (TextUtils.equals(gzVar.uy().getType(), "creative-playable-bait")) {
            return new dl(0.0f, 0.0f);
        }
        float fGz = gzVar.gz();
        float fFo = gzVar.fo();
        com.bytedance.sdk.component.adexpress.dynamic.dl.m mVarGc = gzVar.uy().gc();
        String strL = mVarGc.l();
        String strHh = mVarGc.hh();
        float fI = gzVar.i();
        float fV = gzVar.v();
        float fPf = gzVar.pf();
        float fLs = gzVar.ls();
        if (TextUtils.equals(strL, "fixed")) {
            f = Math.min(fGz, f);
            if (TextUtils.equals(strHh, "auto")) {
                f3 = g(gzVar, f - fPf, f2 - fLs).g;
                fFo = f3 + fLs;
            }
        } else if (TextUtils.equals(strL, "auto")) {
            dl dlVarG = g(gzVar, f - fPf, f2 - fLs);
            f = dlVarG.z + fPf;
            if (TextUtils.equals(strHh, "auto")) {
                f3 = dlVarG.g;
                fFo = f3 + fLs;
            }
        } else if (!TextUtils.equals(strL, "flex")) {
            f = fGz;
        } else if (TextUtils.equals(strHh, "auto")) {
            f3 = g(gzVar, f - fPf, f2 - fLs).g;
            fFo = f3 + fLs;
        }
        if (TextUtils.equals(strHh, "scale")) {
            float fRound = Math.round((f - fI) / fFo) + fV;
            if (fRound > f2) {
                f = Math.round((f2 - fV) * fFo) + fI;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strHh, "fixed")) {
            f2 = Math.min(fFo + fV, f2);
        } else if (!TextUtils.equals(strHh, "flex")) {
            f2 = fFo;
        }
        dl dlVar = new dl();
        dlVar.z = f;
        dlVar.g = f2;
        return dlVar;
    }

    public dl g(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar, float f, float f2) {
        dl dlVar = new dl();
        if (gzVar.uy().gc() == null) {
            return dlVar;
        }
        dl dlVarGc = gc(gzVar, f, f2);
        float f3 = dlVarGc.z;
        float f4 = dlVarGc.g;
        dlVar.z = Math.min(f3, f);
        dlVar.g = Math.min(f4, f2);
        return dlVar;
    }

    private dl gc(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar, float f, float f2) {
        String str = gzVar.dl() + "_" + f + "_" + f2;
        if (this.dl.containsKey(str)) {
            return this.dl.get(str);
        }
        dl dlVarM = m(gzVar, f, f2);
        this.dl.put(str, dlVarM);
        return dlVarM;
    }

    private dl m(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar, float f, float f2) {
        com.bytedance.sdk.component.adexpress.dynamic.dl.m mVarGc = gzVar.uy().gc();
        float fFv = mVarGc.fv();
        int iGb = mVarGc.gb();
        double dBv = mVarGc.bv();
        int iSv = mVarGc.sv();
        boolean zJ = mVarGc.j();
        boolean zF = mVarGc.f();
        int iGp = mVarGc.gp();
        C0116g c0116g = new C0116g();
        c0116g.z = fFv;
        c0116g.g = iGb;
        c0116g.dl = iSv;
        c0116g.f542a = dBv;
        c0116g.gc = f;
        return z(gzVar.uy().g(), c0116g, zJ, zF, iGp, gzVar);
    }

    private dl z(String str, C0116g c0116g, boolean z2, boolean z3, int i, com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        return kb.z(str, gzVar.uy().getType(), C0116g.z(c0116g).toString(), z2, z3, i, gzVar, this.gc, this.m, this.e, this.gz, this.fo);
    }

    public dl dl(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar, float f, float f2) {
        if (gzVar == null) {
            return null;
        }
        dl dlVarZ = z(gzVar);
        if (dlVarZ != null && (dlVarZ.z != 0.0f || dlVarZ.g != 0.0f)) {
            return dlVarZ;
        }
        dl dlVarA = a(gzVar, f, f2);
        z(gzVar, dlVarA);
        return dlVarA;
    }

    public dl a(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar, float f, float f2) {
        float fMin;
        dl dlVar = new dl();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            dlVar.z = 0.0f;
            dlVar.g = 0.0f;
            return dlVar;
        }
        if (gzVar.fv()) {
            return z(gzVar, f, f2);
        }
        float fGz = gzVar.gz();
        float fFo = gzVar.fo();
        float fPf = gzVar.pf();
        float fLs = gzVar.ls();
        com.bytedance.sdk.component.adexpress.dynamic.dl.m mVarGc = gzVar.uy().gc();
        String strL = mVarGc.l();
        String strHh = mVarGc.hh();
        float fMin2 = ((TextUtils.equals(strL, "flex") || TextUtils.equals(strL, "auto")) ? f : Math.min(fGz, f)) - fPf;
        if (TextUtils.equals(strHh, "scale")) {
            fMin = Math.round(fMin2 / fFo) + fLs;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fLs) * fFo);
            }
        } else {
            fMin = (TextUtils.equals(strHh, "auto") || TextUtils.equals(strHh, "flex")) ? f2 : Math.min(fFo, f2);
        }
        float f4 = fMin - fLs;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> listP = gzVar.p();
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> it = listP.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> it2 = it;
            List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> next = it.next();
            dl dlVar2 = dlVar;
            dl dlVarG = g(next, fMin2, f4);
            if (g(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, dlVarG.z);
            }
            float f5 = f3;
            if (gzVar.uy().getType().equals("carousel")) {
                fMax2 = Math.max(gzVar.fo(), dlVarG.g);
            } else {
                fMax2 += dlVarG.g;
            }
            dlVar = dlVar2;
            it = it2;
            f3 = f5;
        }
        dl dlVar3 = dlVar;
        if (TextUtils.equals(strL, "auto")) {
            if (f3 == listP.size()) {
                fMin2 = f;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list : listP) {
                    dl(list);
                    g(list, fMax, f4);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strHh, "auto")) {
            if (fMax2 <= f2) {
                f4 = fMax2;
            } else {
                z(listP, fMin2, f4);
            }
        } else if ((TextUtils.equals(strHh, "fixed") || TextUtils.equals(strHh, "flex")) && f4 < fMax2) {
            z(listP, fMin2, f4);
        }
        dlVar3.z = Math.min(fMin2 + fPf, f);
        dlVar3.g = Math.min(f4 + fLs, f2);
        return dlVar3;
    }

    private void z(List<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> it = list.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (z(it.next(), false)) {
                z2 = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list2 : list) {
            z zVar = new z();
            boolean z3 = z(list2, !z2);
            zVar.z = z3 ? 1.0f : g(list2, f, f2).g;
            zVar.g = !z3;
            arrayList.add(zVar);
        }
        List<z> listZ = uy.z(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((z) arrayList.get(i)).z != listZ.get(i).z) {
                List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list3 = list.get(i);
                dl(list3);
                g(list3, f, listZ.get(i).z);
            }
        }
    }

    private boolean g(List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list) {
        boolean z2;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> listP;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            if (TextUtils.equals(it.next().uy().gc().l(), "flex")) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return true;
        }
        while (true) {
            boolean z3 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar : list) {
                if (TextUtils.equals(gzVar.uy().gc().l(), "auto") && (listP = gzVar.p()) != null) {
                    int i = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list2 : listP) {
                        i++;
                        if (!g(list2)) {
                            break;
                        }
                        if (i == list2.size()) {
                            z3 = true;
                        }
                    }
                }
            }
            return z3;
        }
    }

    private dl g(List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list, float f, float f2) {
        dl dlVarZ = z(list);
        if (dlVarZ != null && (dlVarZ.z != 0.0f || dlVarZ.g != 0.0f)) {
            return dlVarZ;
        }
        dl dlVarDl = dl(list, f, f2);
        z(list, dlVarDl);
        return dlVarDl;
    }

    private dl dl(List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list, float f, float f2) {
        float fMax;
        a(list);
        dl dlVar = new dl();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.dl.m mVarGc = gzVar.uy().gc();
            if (mVarGc.yx() == 1 || mVarGc.yx() == 2) {
                arrayList.add(gzVar);
            }
            if (mVarGc.yx() != 1 && mVarGc.yx() != 2) {
                arrayList2.add(gzVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            dl((com.bytedance.sdk.component.adexpress.dynamic.dl.gz) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return dlVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(dl(it2.next(), f, f2).z));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar2 = arrayList2.get(i);
            String strL = gzVar2.uy().gc().l();
            float fGz = gzVar2.gz();
            boolean zEquals = TextUtils.equals(strL, "flex");
            if (TextUtils.equals(strL, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> listP = gzVar2.p();
                if (listP == null || listP.size() <= 0) {
                    zEquals = false;
                } else {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> it3 = listP.iterator();
                    while (it3.hasNext()) {
                        if (g(it3.next())) {
                            zEquals = true;
                            break;
                        }
                    }
                    zEquals = false;
                }
            }
            z zVar = new z();
            if (!zEquals) {
                fGz = ((Float) arrayList3.get(i)).floatValue();
            }
            zVar.z = fGz;
            zVar.g = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            zVar.dl = fMax;
            arrayList4.add(zVar);
            i++;
        }
        z(arrayList4, f, arrayList2);
        List<z> listZ = uy.z(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listZ.get(i2).z;
            if (((Float) arrayList3.get(i2)).floatValue() != listZ.get(i2).z) {
                a(arrayList2.get(i2));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i3++;
            if (!g(it4.next())) {
                z2 = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z2 = true;
            }
        }
        fMax = z2 ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar3 = arrayList2.get(i4);
            dl dlVarDl = dl(gzVar3, listZ.get(i4).z, f2);
            if (!g(gzVar3)) {
                fMax = Math.max(fMax, dlVarDl.g);
            }
            arrayList5.add(dlVarDl);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((dl) it5.next()).g));
        }
        if (!z2) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar4 = arrayList2.get(i5);
                if (g(gzVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    a(gzVar4);
                    dl(gzVar4, listZ.get(i5).z, fMax);
                }
            }
        }
        dlVar.z = f3;
        dlVar.g = fMax;
        return dlVar;
    }

    private boolean g(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        if (gzVar == null) {
            return false;
        }
        if (TextUtils.equals(gzVar.uy().gc().hh(), "flex")) {
            return true;
        }
        return dl(gzVar);
    }

    private boolean dl(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> listP;
        if (!gzVar.fv() && TextUtils.equals(gzVar.uy().gc().hh(), "auto") && (listP = gzVar.p()) != null && listP.size() > 0) {
            if (listP.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> it = listP.get(0).iterator();
                while (it.hasNext()) {
                    if (!g(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> it2 = listP.iterator();
            while (it2.hasNext()) {
                if (z(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean z(List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list, boolean z2) {
        boolean z3;
        for (com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.dl.m mVarGc = gzVar.uy().gc();
            String strHh = mVarGc.hh();
            if (TextUtils.equals(strHh, "flex") || (z2 && ((TextUtils.equals(mVarGc.l(), "flex") && TextUtils.equals(mVarGc.hh(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.dl.gc.z.get(gzVar.uy().getType()).intValue() == 7) || TextUtils.equals(strHh, "flex")))) {
                z3 = true;
                break;
            }
        }
        z3 = false;
        if (z3) {
            return true;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> it = list.iterator();
        while (it.hasNext()) {
            if (dl(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void z(List<z> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list2) {
        float f2 = 0.0f;
        for (z zVar : list) {
            if (zVar.g) {
                f2 += zVar.z;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).g && list2.get(i2).iq()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    z zVar2 = list.get(i3);
                    if (zVar2.g && list2.get(i3).iq()) {
                        zVar2.z -= fCeil;
                    }
                }
            }
        }
    }

    public void z() {
        this.dl.clear();
        this.z.clear();
        this.g.clear();
    }

    public dl z(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        return this.z.get(gc(gzVar));
    }

    public dl z(List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list) {
        return this.g.get(a(list));
    }

    private void a(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        this.z.remove(gc(gzVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> listP = gzVar.p();
        if (listP == null || listP.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz>> it = listP.iterator();
        while (it.hasNext()) {
            dl(it.next());
        }
    }

    private void dl(List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.g.remove(a(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    private String gc(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar) {
        return gzVar.dl();
    }

    private String a(List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strDl = list.get(i).dl();
            if (i < list.size() - 1) {
                sb.append(strDl).append("-");
            } else {
                sb.append(strDl);
            }
        }
        return sb.toString();
    }

    private void z(com.bytedance.sdk.component.adexpress.dynamic.dl.gz gzVar, dl dlVar) {
        this.z.put(gc(gzVar), dlVar);
    }

    private void z(List<com.bytedance.sdk.component.adexpress.dynamic.dl.gz> list, dl dlVar) {
        this.g.put(a(list), dlVar);
    }

    static class dl {
        float g;
        float z;

        public dl() {
        }

        public dl(float f, float f2) {
            this.z = f;
            this.g = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.z + ", height=" + this.g + '}';
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.a.g$g, reason: collision with other inner class name */
    static class C0116g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        double f542a;
        int dl;
        int g;
        float gc;
        float z;

        C0116g() {
        }

        static JSONObject z(C0116g c0116g) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_SIZE, c0116g.z);
                jSONObject.put("letterSpacing", c0116g.g);
                jSONObject.put("lineHeight", c0116g.f542a);
                jSONObject.put("maxWidth", c0116g.gc);
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_WEIGHT, c0116g.dl);
            } catch (JSONException e) {
                wp.z(e);
            }
            return jSONObject;
        }
    }

    static class z implements Cloneable {
        float dl;
        boolean g;
        float z;

        z() {
        }

        public Object clone() {
            try {
                return (z) super.clone();
            } catch (CloneNotSupportedException e) {
                wp.z(e);
                return null;
            }
        }
    }
}
