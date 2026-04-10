package com.bytedance.sdk.component.adexpress.dynamic.tg;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private double ga;
    private double p;
    private String v;
    private int vn;
    public Map<String, d> e = new HashMap();
    public Map<String, d> bf = new HashMap();
    public Map<String, d> d = new HashMap();
    private double tg = Math.random();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.tg.bf$bf, reason: collision with other inner class name */
    public static class C0084bf {
        int bf;
        int d;
        float e;
        float ga;
        double tg;

        public static JSONObject e(C0084bf c0084bf) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_SIZE, c0084bf.e);
                jSONObject.put("letterSpacing", c0084bf.bf);
                jSONObject.put("lineHeight", c0084bf.tg);
                jSONObject.put("maxWidth", c0084bf.ga);
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_WEIGHT, c0084bf.d);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static class d {
        float bf;
        float e;

        public d() {
        }

        public String toString() {
            return "UnitSize{width=" + this.e + ", height=" + this.bf + '}';
        }

        public d(float f, float f2) {
            this.e = f;
            this.bf = f2;
        }
    }

    public static class e implements Cloneable {
        boolean bf;
        float d;
        float e;

        public Object clone() {
            try {
                return (e) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public bf(double d2, int i, double d3, String str) {
        this.ga = d2;
        this.vn = i;
        this.p = d3;
        this.v = str;
    }

    private d ga(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar, float f, float f2) {
        String str = vVar.d() + "_" + f + "_" + f2;
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        d dVarVn = vn(vVar, f, f2);
        this.d.put(str, dVarVn);
        return dVarVn;
    }

    private d vn(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar, float f, float f2) {
        new d();
        com.bytedance.sdk.component.adexpress.dynamic.d.vn vnVarTg = vVar.m().tg();
        vVar.m().bf();
        vnVarTg.i();
        float fL = vnVarTg.l();
        int iJ = vnVarTg.j();
        double dRt = vnVarTg.rt();
        int iYl = vnVarTg.yl();
        boolean zBx = vnVarTg.bx();
        boolean zRb = vnVarTg.rb();
        int iBm = vnVarTg.bm();
        C0084bf c0084bf = new C0084bf();
        c0084bf.e = fL;
        c0084bf.bf = iJ;
        c0084bf.d = iYl;
        c0084bf.tg = dRt;
        c0084bf.ga = f;
        return e(vVar.m().bf(), c0084bf, zBx, zRb, iBm, vVar);
    }

    public d bf(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar, float f, float f2) {
        d dVar = new d();
        if (vVar.m().tg() == null) {
            return dVar;
        }
        d dVarGa = ga(vVar, f, f2);
        float f3 = dVarGa.e;
        float f4 = dVarGa.bf;
        dVar.e = Math.min(f3, f);
        dVar.bf = Math.min(f4, f2);
        return dVar;
    }

    public d d(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar, float f, float f2) {
        if (vVar == null) {
            return null;
        }
        d dVarE = e(vVar);
        if (dVarE != null && (dVarE.e != 0.0f || dVarE.bf != 0.0f)) {
            return dVarE;
        }
        d dVarTg = tg(vVar, f, f2);
        e(vVar, dVarTg);
        return dVarTg;
    }

    public d e(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(vVar.m().bf()) && vVar.m().tg().yf() == null) {
            return new d(0.0f, 0.0f);
        }
        if (TextUtils.equals(vVar.m().getType(), "creative-playable-bait")) {
            return new d(0.0f, 0.0f);
        }
        float fV = vVar.v();
        float fZk = vVar.zk();
        com.bytedance.sdk.component.adexpress.dynamic.d.vn vnVarTg = vVar.m().tg();
        String strLc = vnVarTg.lc();
        String strZa = vnVarTg.za();
        float fBh = vVar.bh();
        float fT = vVar.t();
        float fS = vVar.s();
        float fW = vVar.w();
        if (TextUtils.equals(strLc, "fixed")) {
            f = Math.min(fV, f);
            if (TextUtils.equals(strZa, "auto")) {
                f3 = bf(vVar, f - fS, f2 - fW).bf;
                fZk = f3 + fW;
            }
        } else if (TextUtils.equals(strLc, "auto")) {
            d dVarBf = bf(vVar, f - fS, f2 - fW);
            f = dVarBf.e + fS;
            if (TextUtils.equals(strZa, "auto")) {
                f3 = dVarBf.bf;
                fZk = f3 + fW;
            }
        } else if (!TextUtils.equals(strLc, "flex")) {
            f = fV;
        } else if (TextUtils.equals(strZa, "auto")) {
            f3 = bf(vVar, f - fS, f2 - fW).bf;
            fZk = f3 + fW;
        }
        if (TextUtils.equals(strZa, "scale")) {
            float fRound = Math.round((f - fBh) / fZk) + fT;
            if (fRound > f2) {
                f = Math.round((f2 - fT) * fZk) + fBh;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strZa, "fixed")) {
            f2 = Math.min(fZk + fT, f2);
        } else if (!TextUtils.equals(strZa, "flex")) {
            f2 = fZk;
        }
        d dVar = new d();
        dVar.e = f;
        dVar.bf = f2;
        return dVar;
    }

    public d tg(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar, float f, float f2) {
        float fMin;
        d dVar = new d();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            dVar.e = 0.0f;
            dVar.bf = 0.0f;
            return dVar;
        }
        if (vVar.f()) {
            return e(vVar, f, f2);
        }
        float fV = vVar.v();
        float fZk = vVar.zk();
        float fS = vVar.s();
        float fW = vVar.w();
        com.bytedance.sdk.component.adexpress.dynamic.d.vn vnVarTg = vVar.m().tg();
        String strLc = vnVarTg.lc();
        String strZa = vnVarTg.za();
        float fMin2 = ((TextUtils.equals(strLc, "flex") || TextUtils.equals(strLc, "auto")) ? f : Math.min(fV, f)) - fS;
        if (TextUtils.equals(strZa, "scale")) {
            fMin = Math.round(fMin2 / fZk) + fW;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fW) * fZk);
            }
        } else {
            fMin = (TextUtils.equals(strZa, "auto") || TextUtils.equals(strZa, "flex")) ? f2 : Math.min(fZk, f2);
        }
        float f4 = fMin - fW;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> listL = vVar.l();
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> it = listL.iterator();
        float fMax = 0.0f;
        float f5 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> it2 = it;
            List<com.bytedance.sdk.component.adexpress.dynamic.d.v> next = it.next();
            d dVar2 = dVar;
            d dVarBf = bf(next, fMin2, f4);
            if (bf(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, dVarBf.e);
            }
            f5 += dVarBf.bf;
            it = it2;
            dVar = dVar2;
        }
        d dVar3 = dVar;
        if (TextUtils.equals(strLc, "auto")) {
            if (f3 == listL.size()) {
                fMin2 = f;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list : listL) {
                    d(list);
                    bf(list, fMax, f4);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strZa, "auto")) {
            if (f5 <= f2) {
                f4 = f5;
            } else {
                e(listL, fMin2, f4);
            }
        } else if ((TextUtils.equals(strZa, "fixed") || TextUtils.equals(strZa, "flex")) && f4 < f5) {
            e(listL, fMin2, f4);
        }
        dVar3.e = Math.min(fMin2 + fS, f);
        dVar3.bf = Math.min(f4 + fW, f2);
        return dVar3;
    }

    private d d(List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list, float f, float f2) {
        float fMax;
        tg(list);
        d dVar = new d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.d.v vVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.d.vn vnVarTg = vVar.m().tg();
            if (vnVarTg.ot() == 1 || vnVarTg.ot() == 2) {
                arrayList.add(vVar);
            }
            if (vnVarTg.ot() != 1 && vnVarTg.ot() != 2) {
                arrayList2.add(vVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d((com.bytedance.sdk.component.adexpress.dynamic.d.v) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return dVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.d.v> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(d(it2.next(), f, f2).e));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.d.v vVar2 = arrayList2.get(i);
            String strLc = vVar2.m().tg().lc();
            float fV = vVar2.v();
            boolean zEquals = TextUtils.equals(strLc, "flex");
            if (TextUtils.equals(strLc, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> listL = vVar2.l();
                if (listL == null || listL.size() <= 0) {
                    zEquals = false;
                } else {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> it3 = listL.iterator();
                    while (it3.hasNext()) {
                        if (bf(it3.next())) {
                            zEquals = true;
                            break;
                        }
                    }
                    zEquals = false;
                }
            }
            e eVar = new e();
            if (!zEquals) {
                fV = ((Float) arrayList3.get(i)).floatValue();
            }
            eVar.e = fV;
            eVar.bf = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            eVar.d = fMax;
            arrayList4.add(eVar);
            i++;
        }
        e(arrayList4, f, arrayList2);
        List<e> listE = m.e(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listE.get(i2).e;
            if (((Float) arrayList3.get(i2)).floatValue() != listE.get(i2).e) {
                tg(arrayList2.get(i2));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.d.v> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i3++;
            if (!bf(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        fMax = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.bytedance.sdk.component.adexpress.dynamic.d.v vVar3 = arrayList2.get(i4);
            d dVarD = d(vVar3, listE.get(i4).e, f2);
            if (!bf(vVar3)) {
                fMax = Math.max(fMax, dVarD.bf);
            }
            arrayList5.add(dVarD);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((d) it5.next()).bf));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.bytedance.sdk.component.adexpress.dynamic.d.v vVar4 = arrayList2.get(i5);
                if (bf(vVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    tg(vVar4);
                    d(vVar4, listE.get(i5).e, fMax);
                }
            }
        }
        dVar.e = f3;
        dVar.bf = fMax;
        return dVar;
    }

    private boolean bf(List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list) {
        boolean z;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> listL;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.d.v> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (TextUtils.equals(it.next().m().tg().lc(), "flex")) {
                z = true;
                break;
            }
        }
        if (z) {
            return true;
        }
        while (true) {
            boolean z2 = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.d.v vVar : list) {
                if (TextUtils.equals(vVar.m().tg().lc(), "auto") && (listL = vVar.l()) != null) {
                    int i = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list2 : listL) {
                        i++;
                        if (!bf(list2)) {
                            break;
                        }
                        if (i == list2.size()) {
                            z2 = true;
                        }
                    }
                }
            }
            return z2;
        }
    }

    private String ga(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar) {
        return vVar.d();
    }

    private d bf(List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list, float f, float f2) {
        d dVarE = e(list);
        if (dVarE != null && (dVarE.e != 0.0f || dVarE.bf != 0.0f)) {
            return dVarE;
        }
        d dVarD = d(list, f, f2);
        e(list, dVarD);
        return dVarD;
    }

    private boolean bf(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar) {
        if (vVar == null) {
            return false;
        }
        if (TextUtils.equals(vVar.m().tg().za(), "flex")) {
            return true;
        }
        return d(vVar);
    }

    private d e(String str, C0084bf c0084bf, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.d.v vVar) {
        return wu.e(str, vVar.m().getType(), C0084bf.e(c0084bf).toString(), z, z2, i, vVar, this.ga, this.vn, this.p, this.v);
    }

    private void e(List<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (e(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list2 : list) {
            e eVar = new e();
            boolean zE = e(list2, !z);
            eVar.e = zE ? 1.0f : bf(list2, f, f2).bf;
            eVar.bf = !zE;
            arrayList.add(eVar);
        }
        List<e> listE = m.e(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((e) arrayList.get(i)).e != listE.get(i).e) {
                List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list3 = list.get(i);
                d(list3);
                bf(list3, f, listE.get(i).e);
            }
        }
    }

    private void tg(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar) {
        this.e.remove(ga(vVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> listL = vVar.l();
        if (listL == null || listL.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> it = listL.iterator();
        while (it.hasNext()) {
            d(it.next());
        }
    }

    private String tg(List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strD = list.get(i).d();
            if (i < list.size() - 1) {
                sb.append(strD);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            } else {
                sb.append(strD);
            }
        }
        return sb.toString();
    }

    private boolean e(List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list, boolean z) {
        boolean z2;
        for (com.bytedance.sdk.component.adexpress.dynamic.d.v vVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.d.vn vnVarTg = vVar.m().tg();
            String strZa = vnVarTg.za();
            if (TextUtils.equals(strZa, "flex") || (z && ((TextUtils.equals(vnVarTg.lc(), "flex") && TextUtils.equals(vnVarTg.za(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.d.ga.e.get(vVar.m().getType()).intValue() == 7) || TextUtils.equals(strZa, "flex")))) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (z2) {
            return true;
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.d.v> it = list.iterator();
        while (it.hasNext()) {
            if (d(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean d(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> listL;
        if (!vVar.f() && TextUtils.equals(vVar.m().tg().za(), "auto") && (listL = vVar.l()) != null && listL.size() > 0) {
            if (listL.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.d.v> it = listL.get(0).iterator();
                while (it.hasNext()) {
                    if (!bf(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.d.v>> it2 = listL.iterator();
            while (it2.hasNext()) {
                if (e(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void e(List<e> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list2) {
        float f2 = 0.0f;
        for (e eVar : list) {
            if (eVar.bf) {
                f2 += eVar.e;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).bf && list2.get(i2).y()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    e eVar2 = list.get(i3);
                    if (eVar2.bf && list2.get(i3).y()) {
                        eVar2.e -= fCeil;
                    }
                }
            }
        }
    }

    private void d(List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.bf.remove(tg(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.d.v> it = list.iterator();
        while (it.hasNext()) {
            tg(it.next());
        }
    }

    public void e() {
        this.d.clear();
        this.e.clear();
        this.bf.clear();
    }

    public d e(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar) {
        return this.e.get(ga(vVar));
    }

    public d e(List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list) {
        return this.bf.get(tg(list));
    }

    private void e(com.bytedance.sdk.component.adexpress.dynamic.d.v vVar, d dVar) {
        this.e.put(ga(vVar), dVar);
    }

    private void e(List<com.bytedance.sdk.component.adexpress.dynamic.d.v> list, d dVar) {
        this.bf.put(tg(list), dVar);
    }
}
