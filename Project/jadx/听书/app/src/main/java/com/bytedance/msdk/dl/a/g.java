package com.bytedance.msdk.dl.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.msdk.gz.h;
import com.bytedance.msdk.gz.io;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.p;
import com.bytedance.msdk.gz.q;
import com.bytedance.msdk.gz.v;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.model.AdnName;
import java.lang.ref.SoftReference;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements com.bytedance.msdk.dl.g.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.msdk.g.dl f428a;
    protected com.bytedance.msdk.dl.m.z.g dl;
    protected com.bytedance.msdk.core.uy.g e;
    protected com.bytedance.msdk.z.g.m fo;
    protected String gc;
    protected SoftReference<Context> gz;
    protected com.bytedance.msdk.api.a.z.g i;
    protected com.bytedance.msdk.api.z.g m;
    protected com.bytedance.sdk.openadsdk.ls.dl.z.g v;
    protected boolean uy = false;
    protected int kb = 0;
    protected volatile boolean wp = false;
    private final Comparator<com.bytedance.msdk.core.uy.uy> z = new Comparator<com.bytedance.msdk.core.uy.uy>() { // from class: com.bytedance.msdk.dl.a.g.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.msdk.core.uy.uy uyVar, com.bytedance.msdk.core.uy.uy uyVar2) {
            int iIo;
            int iIo2;
            if (uyVar.io() == uyVar2.io()) {
                iIo = uyVar.uf();
                iIo2 = uyVar2.uf();
            } else {
                iIo = uyVar.io();
                iIo2 = uyVar2.io();
            }
            return iIo - iIo2;
        }
    };
    protected final Comparator<com.bytedance.msdk.core.uy.uy> pf = new Comparator<com.bytedance.msdk.core.uy.uy>() { // from class: com.bytedance.msdk.dl.a.g.2
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(com.bytedance.msdk.core.uy.uy uyVar, com.bytedance.msdk.core.uy.uy uyVar2) {
            if (uyVar.zw() > uyVar2.zw()) {
                return -1;
            }
            return uyVar.zw() < uyVar2.zw() ? 1 : 0;
        }
    };

    @Override // com.bytedance.msdk.dl.g.z.z
    public void e() {
    }

    @Override // com.bytedance.msdk.dl.g.z.z
    public void g(com.bytedance.msdk.api.z zVar) {
    }

    @Override // com.bytedance.msdk.dl.g.z.z
    public void gz() {
    }

    @Override // com.bytedance.msdk.dl.g.z.z
    public void z(String str) {
    }

    @Override // com.bytedance.msdk.dl.g.z.z
    public void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.api.z zVar) {
    }

    public g(Context context) {
        this.gz = new SoftReference<>(context);
    }

    protected void z(com.bytedance.msdk.api.z.g gVar) {
        com.bytedance.msdk.dl.m.z.g gVarZ = com.bytedance.msdk.dl.m.z.g.z(this.gz, gVar, this);
        this.dl = gVarZ;
        com.bytedance.msdk.api.z.g gVarJs = gVarZ.js();
        this.m = gVarJs;
        this.gc = gVarJs.zw();
        this.dl.h().put("allow_show_close_btn", Boolean.valueOf(gVar.fv()));
        this.e = this.dl.wp();
    }

    protected com.bytedance.msdk.dl.dl.z.e fo() {
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "ad load start.....");
        if (com.bytedance.msdk.core.g.g().x()) {
            com.bytedance.msdk.gc.m.z((com.bytedance.msdk.g.dl) null, this.dl.js(), js.z(), 3);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bytedance.msdk.dl.dl.z.kb());
        arrayList.add(new com.bytedance.msdk.dl.dl.z.wp());
        arrayList.add(new com.bytedance.msdk.dl.dl.z.gc());
        arrayList.add(new com.bytedance.msdk.dl.dl.z.dl());
        arrayList.add(new com.bytedance.msdk.dl.dl.z.i());
        arrayList.add(new com.bytedance.msdk.dl.dl.z.m());
        arrayList.add(new com.bytedance.msdk.dl.dl.z.gz());
        arrayList.add(new com.bytedance.msdk.dl.dl.z.g());
        arrayList.add(new com.bytedance.msdk.dl.dl.z.a());
        com.bytedance.msdk.dl.dl.z.e eVar = new com.bytedance.msdk.dl.dl.z.e(arrayList);
        eVar.z(this.dl);
        return eVar;
    }

    public void z() {
        com.bytedance.msdk.g.dl dlVar = this.f428a;
        if (dlVar != null) {
            dlVar.fv();
        }
        this.dl.eo();
        this.fo = null;
    }

    public List<com.bytedance.msdk.api.g> uy() {
        return this.dl.uf();
    }

    public List<com.bytedance.msdk.api.dl> kb() {
        if (!com.bytedance.msdk.core.g.g().io()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.g.dl dlVar : this.dl.uy()) {
            if (dlVar != null) {
                arrayList.add(v.z(this.m, dlVar, false));
            }
        }
        return arrayList;
    }

    public List<com.bytedance.msdk.api.dl> wp() {
        if (!com.bytedance.msdk.core.g.g().io()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.g.dl dlVar : this.dl.tb()) {
            if (dlVar != null) {
                arrayList.add(v.z(this.m, dlVar, false));
            }
        }
        return arrayList;
    }

    public void z(com.bytedance.msdk.g.dl dlVar) {
        if (com.bytedance.msdk.core.g.g().x()) {
            com.bytedance.msdk.gc.m.z(dlVar, this.m, js.z(), 2);
        }
    }

    public static int g(String str) {
        if (!com.bytedance.msdk.core.gz.i.z().gz(str)) {
            com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--: 命中展示频次");
            return 840041;
        }
        if (com.bytedance.msdk.core.gz.i.z().dl(str)) {
            return 0;
        }
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "--==--: 命中展示间隔");
        return 840042;
    }

    protected boolean i() {
        boolean zDl = io.dl(com.bytedance.msdk.core.g.getContext());
        boolean zG = io.g(com.bytedance.msdk.core.g.getContext());
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.gc) + "setting 下发是否为弱网执行：" + com.bytedance.msdk.core.g.g().wp() + "，当前网络环境：2G-type=" + zDl + ",3G-type=" + zG);
        if (com.bytedance.msdk.core.g.g().wp()) {
            return zDl || zG;
        }
        return false;
    }

    @DungeonFlag
    public void z(List<com.bytedance.msdk.g.dl> list) {
        boolean z;
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.msdk.core.a.z.z(this.m, this.e, list, this.dl.uy());
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((com.bytedance.msdk.g.dl) it.next());
        }
        if (this.dl.uy().size() == 0) {
            return;
        }
        ArrayList<com.bytedance.msdk.g.dl> arrayList2 = new ArrayList();
        arrayList2.addAll(this.dl.uy());
        com.bytedance.msdk.g.dl dlVarDl = dl(list);
        for (com.bytedance.msdk.g.dl dlVar : arrayList2) {
            Iterator<com.bytedance.msdk.g.dl> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                com.bytedance.msdk.g.dl next = it2.next();
                if (next != null && dlVar != null && next == dlVar) {
                    z = false;
                    break;
                }
            }
            if (z) {
                z(dlVarDl, dlVar, 1);
            }
        }
    }

    private com.bytedance.msdk.g.dl dl(com.bytedance.msdk.g.dl dlVar) {
        LinkedList<com.bytedance.msdk.g.dl> linkedList = new LinkedList();
        com.bytedance.msdk.dl.m.z.g gVar = this.dl;
        if (gVar != null) {
            if (gVar.uy() != null && this.dl.uy().size() != 0) {
                linkedList.addAll(this.dl.uy());
            }
            if (this.dl.gz() != null && this.dl.gz().size() != 0) {
                linkedList.addAll(this.dl.gz());
            }
            if (this.dl.e() != null && this.dl.e().size() != 0) {
                linkedList.addAll(this.dl.e());
            }
        }
        com.bytedance.msdk.g.dl dlVar2 = null;
        if (linkedList.size() != 0 && dlVar != null) {
            double dU = Double.MIN_NORMAL;
            for (com.bytedance.msdk.g.dl dlVar3 : linkedList) {
                if (dlVar3.u() < dlVar.u() && dlVar3.u() > dU) {
                    dU = dlVar3.u();
                    dlVar2 = dlVar3;
                }
            }
        }
        return dlVar2;
    }

    private com.bytedance.msdk.g.dl dl(List<com.bytedance.msdk.g.dl> list) {
        com.bytedance.msdk.g.dl dlVar = null;
        if (list != null && list.size() != 0) {
            if (list.size() == 1) {
                return list.get(0);
            }
            double dU = Double.MIN_NORMAL;
            for (com.bytedance.msdk.g.dl dlVar2 : list) {
                if (dlVar2.u() > dU) {
                    dU = dlVar2.u();
                    dlVar = dlVar2;
                }
            }
        }
        return dlVar;
    }

    @DungeonFlag
    private void a(com.bytedance.msdk.g.dl dlVar) {
        HashMap map;
        if (dlVar == null || this.m == null) {
            return;
        }
        if (TextUtils.equals(dlVar.lw(), MediationConstant.ADN_XIAOMI)) {
            HashMap map2 = new HashMap();
            map2.put(MediationConstant.KEY_ECPM, Long.valueOf((long) dlVar.u()));
            dlVar.g(map2);
            return;
        }
        if (this.m.eo()) {
            if (dlVar.wx() || dlVar.k() || dlVar.hn()) {
                if (TextUtils.equals(dlVar.lw(), "baidu")) {
                    map = new HashMap();
                    if (com.bytedance.msdk.core.g.g().qd()) {
                        com.bytedance.msdk.g.dl dlVarDl = dl(dlVar);
                        map.put(MediationConstant.KEY_ECPM, Integer.valueOf(dlVarDl != null ? (int) dlVarDl.u() : 0));
                        map.put("adn", 10);
                        map.put("ad_t", 7);
                        map.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map.put("bid_t", 3);
                    } else if (com.bytedance.msdk.core.g.g().zx()) {
                        com.bytedance.msdk.g.dl dlVarDl2 = dl(dlVar);
                        int iU = dlVarDl2 != null ? (int) dlVarDl2.u() : 0;
                        int iU2 = (int) dlVar.u();
                        int iNextInt = new SecureRandom().nextInt(21) + 10;
                        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "-------baidu_bid_win firstAdEcpm = " + iU2 + " secondAdEcpm =" + iU + " randomNumber = " + iNextInt);
                        map.put(MediationConstant.KEY_ECPM, Integer.valueOf(Math.max(iU2 - iNextInt, iU)));
                        map.put("adn", 10);
                        map.put("ad_t", 7);
                        map.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map.put("bid_t", 4);
                    } else {
                        map.put(MediationConstant.KEY_ECPM, 0);
                        map.put("adn", 10);
                        map.put("ad_t", 7);
                        map.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                        map.put("bid_t", 4);
                    }
                } else if (TextUtils.equals(dlVar.lw(), MediationConstant.ADN_KS)) {
                    map = new HashMap();
                    if (com.bytedance.msdk.core.g.g().b()) {
                        com.bytedance.msdk.g.dl dlVarDl3 = dl(dlVar);
                        map.put("bidEcpm", Double.valueOf(dlVar.u()));
                        map.put("lossBidEcpm", Double.valueOf(dlVarDl3 != null ? dlVarDl3.u() : 0.0d));
                    } else {
                        map.put("bidEcpm", 0);
                        map.put("lossBidEcpm", 0);
                    }
                } else {
                    map = null;
                }
                dlVar.g(map);
            }
        }
    }

    @DungeonFlag
    protected void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.g.dl dlVar2, int i) {
        if (dlVar2 == null || this.m == null || i <= 0) {
            return;
        }
        if (TextUtils.equals(dlVar2.lw(), MediationConstant.ADN_XIAOMI)) {
            HashMap map = new HashMap();
            map.put(MediationConstant.KEY_ECPM, Long.valueOf(dlVar != null ? (long) dlVar.u() : 0L));
            map.put(MediationConstant.KEY_REASON, "其他");
            map.put("adn_id", 1);
            dlVar2.z((Map<String, Object>) map);
            return;
        }
        if (this.m.eo()) {
            HashMap map2 = new HashMap();
            map2.put(MediationConstant.BIDDING_LOSE_REASON, com.bytedance.sdk.openadsdk.core.ti.z.g.z(i));
            map2.put("bidding_lose_reason_NUM", Integer.valueOf(i));
            if (TextUtils.equals(dlVar2.lw(), "baidu")) {
                if (com.bytedance.msdk.core.g.g().qd()) {
                    map2.put(MediationConstant.KEY_ECPM, Integer.valueOf(dlVar != null ? (int) dlVar.u() : 0));
                    map2.put("adn", 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 3);
                    map2.put(MediationConstant.KEY_REASON, 203);
                    map2.put("is_s", 1);
                    map2.put("is_c", 2);
                } else if (com.bytedance.msdk.core.g.g().zx()) {
                    map2.put(MediationConstant.KEY_ECPM, Integer.valueOf(dlVar != null ? (int) dlVar.u() : 0));
                    map2.put("adn", 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 4);
                    map2.put(MediationConstant.KEY_REASON, 203);
                    map2.put("is_s", 1);
                    map2.put("is_c", 2);
                } else {
                    map2.put(MediationConstant.KEY_ECPM, 0);
                    map2.put("adn", 10);
                    map2.put("ad_t", 7);
                    map2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    map2.put("bid_t", 4);
                    map2.put(MediationConstant.KEY_REASON, 203);
                    map2.put("is_s", 1);
                    map2.put("is_c", 2);
                }
            } else if (TextUtils.equals(dlVar2.lw(), MediationConstant.ADN_KS)) {
                if (com.bytedance.msdk.core.g.g().b()) {
                    map2.put("failureCode", 2);
                    map2.put("bidEcpm", Double.valueOf(dlVar != null ? dlVar.u() : 0.0d));
                    map2.put("adType", 2);
                    map2.put(MediationConstant.KEY_ADN_NAME, AdnName.OTHER);
                } else {
                    map2.put("failureCode", 0);
                    map2.put("bidEcpm", 0);
                    map2.put("adType", 2);
                    map2.put(MediationConstant.KEY_ADN_NAME, AdnName.OTHER);
                }
            }
            dlVar2.z((Map<String, Object>) map2);
        }
    }

    public HashMap<String, com.bytedance.msdk.g.dl> g(List<com.bytedance.msdk.g.dl> list) {
        HashMap<String, com.bytedance.msdk.g.dl> map = new HashMap<>();
        if (list != null && list.size() > 0) {
            for (com.bytedance.msdk.g.dl dlVar : list) {
                if (dlVar != null) {
                    map.put(dlVar.yz(), dlVar);
                }
            }
        }
        return map;
    }

    public void g(com.bytedance.msdk.g.dl dlVar) {
        com.bytedance.msdk.api.z.g gVar = this.m;
        int iGz = dlVar.gz(gVar != null ? gVar.z() : null);
        dlVar.fo(3);
        dlVar.uy(iGz);
    }

    public List<com.bytedance.msdk.core.uy.uy> g() {
        boolean z;
        List<com.bytedance.msdk.core.uy.uy> arrayList = new ArrayList<>();
        com.bytedance.msdk.dl.m.z.g gVar = this.dl;
        if (gVar == null || this.e == null || gVar.m()) {
            return arrayList;
        }
        Map<Integer, List<com.bytedance.msdk.core.uy.uy>> mapSy = this.e.sy();
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : mapSy.keySet()) {
            if (num != null) {
                arrayList2.add(num);
            }
        }
        com.bytedance.msdk.core.e.g.z(arrayList2);
        int i = 0;
        if (arrayList2.size() > 0) {
            int i2 = 0;
            z = false;
            while (i < arrayList2.size()) {
                Integer num2 = (Integer) arrayList2.get(i);
                if (num2 != null) {
                    int iIntValue = num2.intValue();
                    if (iIntValue == -100) {
                        i2 = 1;
                    }
                    if (iIntValue < -100) {
                        z = true;
                    }
                    if (mapSy.get(Integer.valueOf(iIntValue)) != null) {
                        arrayList.addAll(mapSy.get(Integer.valueOf(iIntValue)));
                    }
                }
                i++;
            }
            i = i2;
        } else {
            z = false;
        }
        if (i == 0 && this.e.x() && !h.g(this.dl.uy())) {
            for (com.bytedance.msdk.g.dl dlVar : this.dl.uy()) {
                if (this.e != null && (dlVar.wx() || dlVar.k())) {
                    com.bytedance.msdk.core.uy.uy uyVarM = this.e.m(dlVar.yz());
                    if (uyVarM != null) {
                        arrayList.add(uyVarM);
                    }
                }
            }
        }
        if (!z) {
            List<com.bytedance.msdk.core.uy.uy> listV = v();
            if (!h.z(listV)) {
                arrayList.addAll(listV);
            }
        }
        Iterator<com.bytedance.msdk.core.uy.uy> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                it.remove();
            }
        }
        if (this.e.gk() || this.e.x()) {
            return a(arrayList);
        }
        Collections.sort(arrayList, this.z);
        return arrayList;
    }

    private List<com.bytedance.msdk.core.uy.uy> a(List<com.bytedance.msdk.core.uy.uy> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.bytedance.msdk.core.uy.uy> it = list.iterator();
        while (it.hasNext()) {
            com.bytedance.msdk.core.uy.uy next = it.next();
            if (next.lq()) {
                it.remove();
                arrayList2.add(next);
            } else if (next.gk() || next.mc() || next.x()) {
                it.remove();
                com.bytedance.msdk.core.uy.uy uyVar = new com.bytedance.msdk.core.uy.uy();
                uyVar.gc(next.fv());
                uyVar.uy(next.js());
                uyVar.dl(next.pf());
                uyVar.a(next.gz());
                uyVar.z(next.e());
                uyVar.kb(next.io());
                uyVar.wp(next.uf());
                uyVar.fo(next.i());
                uyVar.m(new StringBuilder().append(next.zw()).toString());
                uyVar.g(next.v());
                uyVar.e(next.sy());
                uyVar.gz(next.hh());
                uyVar.z(next.l());
                com.bytedance.msdk.g.dl dlVarZ = z(uyVar);
                if (dlVarZ != null) {
                    uyVar.m(new StringBuilder().append(dlVarZ.sf()).toString());
                }
                arrayList.add(uyVar);
            }
        }
        list.addAll(arrayList);
        Collections.sort(list, this.pf);
        Collections.sort(arrayList2, this.z);
        list.addAll(0, arrayList2);
        return list;
    }

    private com.bytedance.msdk.g.dl z(com.bytedance.msdk.core.uy.uy uyVar) {
        if (uyVar == null) {
            return null;
        }
        String strFv = uyVar.fv();
        String strDl = uyVar.l() != null ? uyVar.l().dl() : null;
        if (TextUtils.isEmpty(strFv)) {
            return null;
        }
        for (com.bytedance.msdk.g.dl dlVar : this.dl.e()) {
            if (dlVar != null && strFv.equals(dlVar.yz())) {
                return dlVar;
            }
        }
        for (com.bytedance.msdk.g.dl dlVar2 : this.dl.gz()) {
            if (dlVar2 != null && strFv.equals(dlVar2.yz())) {
                return dlVar2;
            }
        }
        for (com.bytedance.msdk.g.dl dlVar3 : this.dl.uy()) {
            if (dlVar3 != null) {
                if (dlVar3.hn() && !TextUtils.isEmpty(strDl) && !TextUtils.isEmpty(dlVar3.wj())) {
                    if (strFv.equals(dlVar3.yz()) && strDl.equals(dlVar3.wj())) {
                        return dlVar3;
                    }
                } else if (strFv.equals(dlVar3.yz())) {
                    return dlVar3;
                }
            }
        }
        return null;
    }

    protected List<com.bytedance.msdk.core.uy.uy> v() {
        com.bytedance.msdk.core.uy.g gVar = this.e;
        if (gVar == null || gVar.t() == null || this.e.t().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (com.bytedance.msdk.core.uy.uy uyVar : this.e.t()) {
            if (uyVar != null && uyVar.js() == 100) {
                arrayList.add(uyVar);
            }
        }
        return arrayList;
    }

    public com.bytedance.msdk.api.dl pf() {
        if (this.f428a == null || p.z()) {
            return null;
        }
        return v.z(this.m, this.f428a, true);
    }

    public com.bytedance.msdk.api.dl ls() {
        List<com.bytedance.msdk.g.dl> listTb;
        com.bytedance.msdk.api.z.g gVar = this.m;
        if ((gVar != null && !gVar.f() && !com.bytedance.msdk.core.g.g().io()) || (listTb = this.dl.tb()) == null || listTb.size() == 0) {
            return null;
        }
        return v.z(this.m, listTb.get(0), false);
    }

    public int p() {
        com.bytedance.msdk.g.dl dlVar = this.f428a;
        if (dlVar != null) {
            return dlVar.me();
        }
        return -1;
    }

    public Map<String, Object> fv() {
        com.bytedance.msdk.g.dl dlVar = this.f428a;
        Map<String, Object> mapH = dlVar != null ? dlVar.h() : null;
        if (mapH == null) {
            mapH = dl(this.gc);
        }
        com.bytedance.msdk.g.dl dlVar2 = this.f428a;
        if (dlVar2 != null && dlVar2.ec() != null) {
            mapH.putAll(this.f428a.ec());
        }
        if (p.z()) {
            String strZ = p.z(v.z(this.m, this.f428a, true));
            if (!TextUtils.isEmpty(strZ)) {
                mapH.put("get_show_ecpm_info", strZ);
            }
        }
        return mapH;
    }

    public static Map<String, Object> dl(String str) {
        q qVar = new q();
        qVar.put(MediationConstant.KEY_GM_PRIME_RIT, str);
        return qVar;
    }

    public int js() {
        com.bytedance.msdk.api.z.g gVar = this.m;
        if (gVar != null) {
            return gVar.gc();
        }
        return 0;
    }

    public com.bytedance.msdk.api.z.g tb() {
        return this.m;
    }

    public void z(com.bytedance.msdk.api.a.z.g gVar) {
        this.i = gVar;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
        this.v = gVar;
    }
}
