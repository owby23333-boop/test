package com.anythink.core.common;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationBidManager;
import com.anythink.core.common.e.ah;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.aj;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile a a;
    private final String b = a.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, ConcurrentHashMap<String, aj>> f6743c = new ConcurrentHashMap<>();

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public static void b(String str, ai aiVar) {
        if (aiVar == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("Clean own ad cache :");
        sb.append(aiVar.t());
        sb.append("|||");
        sb.append(aiVar.l());
        sb.append("|||");
        sb.append(aiVar.c());
        int iL = aiVar.l();
        if (iL != 3) {
            if (iL == 4) {
                com.anythink.core.basead.b.a();
                Context contextG = com.anythink.core.common.b.n.a().g();
                com.anythink.core.basead.b.a();
                com.anythink.core.basead.b.b(contextG, com.anythink.core.basead.b.a(str, aiVar.t(), aiVar.c()));
                return;
            }
            if (iL != 7) {
                return;
            }
        }
        com.anythink.core.common.e.m mVarN = aiVar.N();
        com.anythink.core.b.f.a().a(aiVar.t());
        com.anythink.core.b.f.a();
        com.anythink.core.b.f.b(aiVar.t());
        if (mVarN == null || TextUtils.isEmpty(mVarN.token)) {
            return;
        }
        mVarN.b();
        com.anythink.core.common.a.a.a().b(com.anythink.core.common.b.n.a().g(), mVarN.token);
    }

    public final aj a(String str, int i2, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list, long j2) {
        synchronized (v.a().a(str)) {
            ConcurrentHashMap<String, aj> concurrentHashMap = this.f6743c.get(str);
            ai unitGroupInfo = aTBaseAdAdapter.getUnitGroupInfo();
            String strT = aTBaseAdAdapter.getUnitGroupInfo().t();
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.f6743c.put(str, concurrentHashMap);
            }
            aj ajVar = concurrentHashMap.get(strT);
            if (ajVar == null) {
                ajVar = new aj();
                ajVar.a = i2;
                ajVar.b = aTBaseAdAdapter.getTrackingInfo().X();
                concurrentHashMap.put(strT, ajVar);
            } else {
                ajVar.a = i2;
                ajVar.b = aTBaseAdAdapter.getTrackingInfo().X();
            }
            com.anythink.core.common.e.b bVarA = ajVar.a();
            if (bVarA != null && TextUtils.equals(w.a().b(str), bVarA.h().X())) {
                return ajVar;
            }
            if (list != null && list.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (BaseAd baseAd : list) {
                    baseAd.setTrackingInfo(aTBaseAdAdapter.getTrackingInfo().N());
                    com.anythink.core.common.e.b bVar = new com.anythink.core.common.e.b();
                    bVar.b(i2);
                    bVar.a(aTBaseAdAdapter);
                    bVar.a(baseAd);
                    bVar.c(System.currentTimeMillis());
                    bVar.b(j2);
                    bVar.a(aTBaseAdAdapter.getTrackingInfo().X());
                    bVar.a(unitGroupInfo.A());
                    arrayList.add(bVar);
                }
                ajVar.a(arrayList);
            } else {
                com.anythink.core.common.e.b bVar2 = new com.anythink.core.common.e.b();
                bVar2.b(i2);
                bVar2.a(aTBaseAdAdapter);
                bVar2.c(System.currentTimeMillis());
                bVar2.b(j2);
                bVar2.a(aTBaseAdAdapter.getTrackingInfo().X());
                bVar2.a(unitGroupInfo.A());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(bVar2);
                ajVar.a(arrayList2);
            }
            return ajVar;
        }
    }

    public final com.anythink.core.common.e.b a(Context context, String str) {
        synchronized (v.a().a(str)) {
            List<com.anythink.core.common.e.b> listA = a(context, str, false, false, false, null);
            if (listA == null || listA.size() <= 0) {
                return null;
            }
            return listA.get(0);
        }
    }

    public final com.anythink.core.common.e.b a(Context context, String str, boolean z2, boolean z3, Map<String, Object> map) {
        synchronized (v.a().a(str)) {
            List<com.anythink.core.common.e.b> listA = a(context, str, z2, z3, false, map);
            if (listA == null || listA.size() <= 0) {
                return null;
            }
            return listA.get(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x03d0 A[Catch: all -> 0x0505, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x001c, B:9:0x0044, B:11:0x0046, B:13:0x005c, B:16:0x0063, B:17:0x0066, B:20:0x0079, B:22:0x007f, B:24:0x008e, B:25:0x0091, B:27:0x0097, B:29:0x009e, B:31:0x00a8, B:117:0x02fc, B:33:0x00cf, B:35:0x00e6, B:36:0x00ff, B:38:0x0105, B:46:0x0120, B:49:0x0131, B:54:0x013f, B:57:0x014b, B:59:0x0183, B:63:0x01a1, B:65:0x01ae, B:66:0x01b3, B:68:0x01b5, B:69:0x01be, B:73:0x01d8, B:74:0x01e0, B:79:0x01ef, B:82:0x01f9, B:104:0x0255, B:106:0x026c, B:108:0x0287, B:110:0x02aa, B:111:0x02b1, B:113:0x02b3, B:114:0x02bb, B:115:0x02ce, B:40:0x010c, B:42:0x0116, B:116:0x02e5, B:120:0x030b, B:122:0x0311, B:124:0x0318, B:125:0x031b, B:127:0x031d, B:129:0x0325, B:131:0x032b, B:134:0x0336, B:136:0x033f, B:140:0x035f, B:141:0x036a, B:142:0x037f, B:144:0x0381, B:151:0x0394, B:154:0x039c, B:156:0x03aa, B:157:0x03ae, B:159:0x03b4, B:161:0x03c0, B:166:0x03d0, B:191:0x049a, B:195:0x049f, B:199:0x04ce, B:202:0x04ea, B:203:0x0503, B:147:0x0389), top: B:212:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.anythink.core.common.e.b> a(android.content.Context r37, java.lang.String r38, boolean r39, boolean r40, boolean r41, java.util.Map<java.lang.String, java.lang.Object> r42) {
        /*
            Method dump skipped, instruction units count: 1290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.a.a(android.content.Context, java.lang.String, boolean, boolean, boolean, java.util.Map):java.util.List");
    }

    private static void a(String str, com.anythink.core.common.e.b bVar) {
        try {
            ai unitGroupInfo = bVar.e().getUnitGroupInfo();
            com.anythink.core.common.e.m mVarN = unitGroupInfo.N();
            if (mVarN != null) {
                com.anythink.core.common.e.e eVarH = bVar.h();
                ai aiVarC = com.anythink.core.b.f.a().c(str);
                double dA = com.anythink.core.common.k.g.a(aiVarC);
                com.anythink.core.common.e.r rVar = new com.anythink.core.common.e.r();
                rVar.a = 1;
                rVar.b = dA;
                rVar.f7378e = eVarH;
                rVar.f7376c = aiVarC;
                rVar.f7377d = unitGroupInfo;
                mVarN.a(rVar, true);
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(ATBaseAdAdapter aTBaseAdAdapter, String str, String str2, com.anythink.core.c.d dVar, ai aiVar, int i2, Map<String, Object> map) {
        Map<String, Object> mapC = v.a().c(str2);
        int[] iArr = {0};
        if (mapC.containsKey(ah.O)) {
            try {
                iArr[0] = ((Integer) mapC.get(ah.O)).intValue();
            } catch (Throwable unused) {
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(aiVar.c());
        com.anythink.core.common.e.e eVarA = com.anythink.core.common.k.s.a(str, str2, "", dVar, sb.toString(), 1, 0, iArr[0], map);
        com.anythink.core.common.k.s.a(eVarA, aiVar, i2, true);
        com.anythink.core.common.k.s.a(aTBaseAdAdapter, eVarA, aiVar);
        eVarA.f7243q = 3;
        eVarA.g(aTBaseAdAdapter.getNetworkPlacementId());
        aTBaseAdAdapter.setRefresh(false);
    }

    private static void a(JSONArray jSONArray, int i2, String str, int i3, String str2, boolean z2, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("priority", i2);
            jSONObject.put("unit_id", str);
            jSONObject.put("nw_firm_id", i3);
            jSONObject.put("nw_ver", str2);
            jSONObject.put("result", z2 ? 1 : 0);
            if (i4 != -1) {
                jSONObject.put("reason", i4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        jSONArray.put(jSONObject);
    }

    public final void a(String str, String str2) {
        aj ajVarRemove;
        synchronized (v.a().a(str)) {
            ConcurrentHashMap<String, aj> concurrentHashMap = this.f6743c.get(str);
            if (concurrentHashMap != null && concurrentHashMap.size() > 0 && (ajVarRemove = concurrentHashMap.remove(str2)) != null) {
                ajVarRemove.c();
            }
        }
    }

    public final void a(String str, String str2, com.anythink.core.common.e.b bVar) {
        aj ajVar;
        synchronized (v.a().a(str)) {
            if (bVar == null) {
                return;
            }
            ConcurrentHashMap<String, aj> concurrentHashMap = this.f6743c.get(str);
            if (concurrentHashMap != null && concurrentHashMap.size() > 0 && (ajVar = concurrentHashMap.get(str2)) != null) {
                ajVar.a(bVar);
                if (!ajVar.d()) {
                    concurrentHashMap.remove(str2);
                }
            }
        }
    }

    public final void a(final Context context, final com.anythink.core.common.e.b bVar) {
        final ATBaseAdAdapter aTBaseAdAdapterE = bVar.e();
        final com.anythink.core.common.e.e eVarH = bVar.h();
        ai unitGroupInfo = aTBaseAdAdapterE != null ? aTBaseAdAdapterE.getUnitGroupInfo() : null;
        if (eVarH != null) {
            v.a().b(eVarH.W()).a(eVarH.X(), unitGroupInfo != null ? com.anythink.core.common.k.g.a(unitGroupInfo) : PangleAdapterUtils.CPM_DEFLAUT_VALUE, unitGroupInfo);
            b(eVarH.W(), unitGroupInfo);
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.a.a.a(context).a(eVarH.Y(), eVarH.W(), eVarH.x());
                    com.anythink.core.a.c.a();
                    com.anythink.core.a.c.a(eVarH.W());
                    com.anythink.core.a.c.a().a(eVarH.W(), eVarH.x());
                    a.this.a(eVarH.W(), eVarH.x(), bVar);
                    MediationBidManager mediationBidManagerB = com.anythink.core.b.f.a().b();
                    if (mediationBidManagerB != null) {
                        mediationBidManagerB.notifyWinnerDisplay(eVarH.W(), aTBaseAdAdapterE.getUnitGroupInfo());
                    }
                }
            });
        }
    }

    public final com.anythink.core.common.e.b a(String str, ai aiVar) {
        com.anythink.core.common.e.m mVarA;
        ConcurrentHashMap<String, aj> concurrentHashMap;
        if (((aiVar.l() != 3 && aiVar.l() != 7) || ((mVarA = com.anythink.core.b.f.a().a(aiVar)) != null && !mVarA.a())) && (concurrentHashMap = this.f6743c.get(str)) != null) {
            aj ajVar = concurrentHashMap.get(aiVar.t());
            com.anythink.core.common.e.b bVarA = ajVar != null ? ajVar.a() : null;
            if (bVarA != null && bVarA.j()) {
                return bVarA;
            }
            if (bVarA != null) {
                a(str, bVarA);
                bVarA.k();
            }
        }
        return null;
    }

    public final void a(String str, String str2, com.anythink.core.c.d dVar) {
        com.anythink.core.common.e.b bVarA;
        synchronized (v.a().a(str)) {
            ConcurrentHashMap<String, aj> concurrentHashMap = this.f6743c.get(str);
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                Iterator<Map.Entry<String, aj>> it = concurrentHashMap.entrySet().iterator();
                while (it != null && it.hasNext()) {
                    aj value = it.next().getValue();
                    if (value != null && (bVarA = value.a()) != null) {
                        if (bVarA.j()) {
                            if (!bVarA.b().equals(str2)) {
                                com.anythink.core.common.e.e eVarN = bVarA.e().getTrackingInfo().N();
                                eVarN.f7248v = str2;
                                eVarN.f7243q = 4;
                                com.anythink.core.common.k.s.a(eVarN, dVar);
                                com.anythink.core.common.j.c.a(eVarN, bVarA.b());
                                value.a(eVarN);
                            }
                        } else {
                            a(str, bVarA);
                            bVarA.k();
                        }
                    }
                }
            }
        }
    }

    private List<com.anythink.core.common.e.b> a(String str, boolean z2) {
        ConcurrentHashMap<String, aj> concurrentHashMap = this.f6743c.get(str);
        if (concurrentHashMap == null) {
            return null;
        }
        Iterator<Map.Entry<String, aj>> it = concurrentHashMap.entrySet().iterator();
        ArrayList arrayList = new ArrayList(3);
        com.anythink.core.common.e.b bVar = null;
        while (it.hasNext()) {
            aj value = it.next().getValue();
            com.anythink.core.common.e.b bVarA = value != null ? value.a() : null;
            boolean z3 = false;
            if (bVarA != null && bVarA.j()) {
                z3 = true;
                if (z2) {
                    arrayList.add(bVarA);
                } else if (bVar == null || com.anythink.core.common.k.g.a(bVar.e().getUnitGroupInfo()) < com.anythink.core.common.k.g.a(bVarA.e().getUnitGroupInfo())) {
                    bVar = bVarA;
                }
            }
            if (!z3 && bVarA != null) {
                a(str, bVarA);
                bVarA.k();
            }
        }
        if (z2) {
            Collections.sort(arrayList);
        } else if (bVar != null) {
            arrayList.add(bVar);
        }
        return arrayList;
    }
}
