package com.anythink.core.b.d;

import com.anythink.core.c.d;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.e;
import com.anythink.core.common.l;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    static final String a = "a";

    public static void a(final String str, final d dVar, final String str2, final int i2, final List<ai> list, final long j2, final int i3, final int i4) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.d.a.1
            @Override // java.lang.Runnable
            public final void run() {
                JSONArray jSONArray = new JSONArray();
                e eVar = new e();
                eVar.x(str);
                eVar.y(str2);
                StringBuilder sb = new StringBuilder();
                sb.append(dVar.X());
                eVar.z(sb.toString());
                eVar.w(dVar.U());
                eVar.t(i2);
                eVar.e(j2);
                eVar.f(System.currentTimeMillis());
                eVar.E(dVar.O());
                eVar.v(dVar.ae());
                eVar.D(i3);
                eVar.f7243q = i4;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    ai aiVar = (ai) list.get(i5);
                    if (aiVar.l() != 7 && aiVar.j()) {
                        try {
                            int iO = aiVar.o();
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("sorttype", iO);
                            jSONObject.put("unit_id", aiVar.t());
                            jSONObject.put("bidresult", aiVar.P());
                            jSONObject.put("bidprice", aiVar.M() ? String.valueOf(aiVar.x()) : "0");
                            jSONObject.put(l.am, aiVar.M() ? String.valueOf(aiVar.ag()) : "0");
                            jSONObject.put("nw_firm_id", String.valueOf(aiVar.c()));
                            jSONObject.put("tp_bid_id", aiVar.N() != null ? aiVar.N().f7342g : null);
                            jSONObject.put("rl_bid_status", aiVar.O());
                            jSONObject.put("errormsg", aiVar.z());
                            jSONArray.put(jSONObject);
                        } catch (Exception unused) {
                        }
                    }
                }
                eVar.s(jSONArray.toString());
                com.anythink.core.common.j.a.a(n.a().g()).a(11, eVar);
            }
        });
    }
}
