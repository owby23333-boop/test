package com.anythink.core.common.k;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.common.e.ae;
import com.anythink.core.common.e.ai;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.api.v2.GMAdConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static com.anythink.core.common.e.e a(String str, String str2, String str3, com.anythink.core.c.d dVar, String str4, int i2, int i3, int i4, Map<String, Object> map) {
        com.anythink.core.common.e.e eVar = new com.anythink.core.common.e.e();
        eVar.x(str2);
        eVar.y(str);
        eVar.p(str3);
        eVar.m(str4);
        eVar.s(i2);
        eVar.t(i3);
        eVar.f7244r = 0;
        eVar.f7243q = 2;
        eVar.f7245s = 0;
        a(eVar, dVar);
        eVar.R();
        eVar.C(com.anythink.core.common.b.n.a().j());
        eVar.D(i4);
        a(map, eVar);
        return eVar;
    }

    public static void a(Map<String, Object> map, com.anythink.core.common.e.e eVar) {
        if (map != null) {
            Object obj = map.get(ATAdConst.KEY.CP_PLACEMENT_ID);
            if (obj != null) {
                eVar.u(obj.toString());
            }
            Object obj2 = map.get(ATAdConst.KEY.CP_LOAD_MODE);
            if (obj2 instanceof Integer) {
                eVar.B(Integer.parseInt(obj2.toString()));
            }
        }
    }

    public static com.anythink.core.common.e.e a(ATBaseAdAdapter aTBaseAdAdapter, com.anythink.core.common.e.e eVar, ai aiVar) {
        aTBaseAdAdapter.setUnitGroupInfo(aiVar);
        aTBaseAdAdapter.setRefresh(eVar.F() == 1);
        try {
            eVar.f7247u = aTBaseAdAdapter.getNetworkSDKVersion();
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(eVar.T())) {
            eVar.v(aTBaseAdAdapter.getNetworkName());
        }
        eVar.e(aTBaseAdAdapter.getClass().getName());
        aTBaseAdAdapter.setTrackingInfo(eVar);
        return eVar;
    }

    public static void a(com.anythink.core.common.e.e eVar, ai aiVar, int i2, boolean z2) {
        com.anythink.core.common.e.m mVarN;
        com.anythink.core.common.e.s sVarE;
        ae.a aVarA = z2 ? com.anythink.core.a.a.a(com.anythink.core.common.b.n.a().g()).a(eVar.W(), aiVar.t()) : null;
        eVar.c(aiVar.l());
        eVar.u(aiVar.c());
        eVar.l(aiVar.t());
        eVar.l(aiVar.C());
        eVar.m(aiVar.D());
        eVar.f(aiVar.U());
        eVar.o(i2);
        eVar.n(aiVar.g());
        eVar.q(aVarA != null ? aVarA.f7145e : 0);
        eVar.r(aVarA != null ? aVarA.f7144d : 0);
        if (aiVar.M()) {
            if (aiVar.aa()) {
                com.anythink.core.common.e.m mVarN2 = aiVar.N();
                if (mVarN2 != null) {
                    eVar.d(mVarN2.f7350o);
                    eVar.a(mVarN2.f7350o);
                }
            } else {
                eVar.d(aiVar.x());
                eVar.a(aiVar.ag());
            }
        } else {
            eVar.d(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
            eVar.a(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        }
        if (aiVar.j()) {
            if (aiVar.V() != 2) {
                if (aiVar.aa()) {
                    com.anythink.core.common.e.m mVarN3 = aiVar.N();
                    if (mVarN3 != null) {
                        eVar.b(mVarN3.f7350o * eVar.g());
                        eVar.i(mVarN3.f7351p);
                    }
                } else {
                    eVar.b(aiVar.x() * eVar.g());
                    eVar.i("exact");
                }
            }
        } else {
            eVar.b(aiVar.J());
            String strG = aiVar.G();
            if (TextUtils.isEmpty(strG)) {
                strG = "publisher_defined";
            }
            eVar.i(strG);
        }
        eVar.n(aiVar.i());
        eVar.f(aiVar.y());
        eVar.ao = aiVar.u();
        eVar.ap = aiVar.v();
        eVar.aq = aiVar.w();
        eVar.k(aiVar.F());
        eVar.e(aiVar.V());
        try {
            JSONObject jSONObject = new JSONObject(aiVar.g());
            JSONObject jSONObject2 = new JSONObject();
            if (35 == aiVar.c()) {
                String strOptString = jSONObject.optString("my_oid");
                com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(eVar.W());
                if (dVarA != null && (sVarE = dVarA.e(strOptString)) != null) {
                    jSONObject2.put("o_id", strOptString);
                    jSONObject2.put(GMAdConstant.EXTRA_CID, sVarE.q());
                }
            }
            if ("0".equals(eVar.Y()) && (3 == aiVar.l() || 7 == aiVar.l())) {
                String strOptString2 = jSONObject.optString("layout_type");
                if (TextUtils.isEmpty(strOptString2) || strOptString2.equals("0")) {
                    strOptString2 = "2";
                }
                jSONObject2.put("tpl_type", strOptString2);
            }
            if (28 == aiVar.c() && (mVarN = aiVar.N()) != null) {
                jSONObject2.put("origin_price", mVarN.originPrice);
            }
            eVar.q(jSONObject2.toString());
        } catch (Throwable unused) {
        }
        com.anythink.core.common.e.m mVarN4 = aiVar.N();
        eVar.c(mVarN4 != null ? mVarN4.f7342g : "");
        eVar.w(aiVar.Y());
        eVar.v(aiVar.d());
    }

    public static void a(com.anythink.core.common.e.e eVar, com.anythink.core.c.d dVar) {
        if (eVar == null || dVar == null) {
            return;
        }
        if (dVar.X() == Integer.parseInt("1")) {
            eVar.o("1");
        } else {
            eVar.o("0");
        }
        eVar.E(dVar.O());
        eVar.w(dVar.U());
        eVar.v(dVar.ae());
        eVar.z(String.valueOf(dVar.X()));
        eVar.j(dVar.K());
        eVar.k(dVar.J());
        eVar.c(dVar.x());
        eVar.d(dVar.y());
        eVar.b(dVar.I());
        eVar.a(dVar.L());
        eVar.c(dVar.M());
        eVar.a(dVar.k());
        eVar.b(dVar.l());
        eVar.t(dVar.c());
    }

    public static void a(Context context, com.anythink.core.common.e.e eVar) {
        ae aeVar;
        int i2;
        int i3;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map<String, ae> mapA = com.anythink.core.a.a.a(context).a(Integer.parseInt(eVar.Y()));
        if (mapA != null) {
            i2 = 0;
            i3 = 0;
            for (ae aeVar2 : mapA.values()) {
                i2 += aeVar2.f7139c;
                i3 += aeVar2.f7140d;
            }
            aeVar = mapA.get(eVar.W());
        } else {
            aeVar = null;
            i2 = 0;
            i3 = 0;
        }
        eVar.g(i2 + 1);
        eVar.h(i3 + 1);
        eVar.i((aeVar != null ? aeVar.f7139c : 0) + 1);
        eVar.j((aeVar != null ? aeVar.f7140d : 0) + 1);
        new StringBuilder("Check cap waite time:").append(System.currentTimeMillis() - jCurrentTimeMillis);
    }
}
