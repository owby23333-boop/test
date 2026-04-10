package com.anythink.core.common.h;

import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.AdError;
import com.anythink.core.c.d;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.e;
import com.anythink.core.common.g.i;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.anythink.core.common.f.c {
    /* JADX INFO: Access modifiers changed from: private */
    public static String b(long j2, long j3, e eVar, ATBaseAdAdapter aTBaseAdAdapter) {
        Map<String, Object> networkInfoMap;
        try {
            networkInfoMap = aTBaseAdAdapter.getNetworkInfoMap();
        } catch (Throwable unused) {
        }
        String string = networkInfoMap != null ? new JSONObject(networkInfoMap).toString() : "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pl_id", eVar.W());
            jSONObject.put("req_id", eVar.X());
            jSONObject.put("show_id", eVar.l());
            jSONObject.put("unit_id", eVar.x());
            jSONObject.put("nw_firm_id", eVar.H());
            jSONObject.put("scenario_id", eVar.C);
            jSONObject.put("rv_start_ts", j2);
            jSONObject.put("r_callback_ts", j3);
            jSONObject.put("rv_play_dur", j3 - j2);
            jSONObject.put("tp_bid_id", eVar.e());
            jSONObject.put("extra_info", string);
            jSONObject.put("user_id", aTBaseAdAdapter.getUserId());
            jSONObject.put("extra_data", aTBaseAdAdapter.getUserCustomData());
            jSONObject.put("curr_ts", System.currentTimeMillis());
            jSONObject.put(d.a.f6717i, j.a(eVar, aTBaseAdAdapter).toString());
            return jSONObject.toString();
        } catch (Throwable unused2) {
            return "";
        }
    }

    @Override // com.anythink.core.common.f.c
    public final void a(final long j2, final long j3, final ATBaseAdAdapter aTBaseAdAdapter, final e eVar) {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.h.d.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (aTBaseAdAdapter.getUnitGroupInfo().S() != 1) {
                        return;
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (j3 != 0 && jElapsedRealtime >= j3) {
                        jElapsedRealtime = j3;
                    }
                    long j4 = jElapsedRealtime;
                    final String strW = eVar.W();
                    com.anythink.core.c.d dVarA = com.anythink.core.c.e.a(n.a().g()).a(strW);
                    JSONObject jSONObject = new JSONObject(a.a(dVarA.u()));
                    int iOptInt = jSONObject.optInt("a");
                    b bVarA = a.a(jSONObject.optString("b"), d.b(j2, j4, eVar, aTBaseAdAdapter));
                    if (TextUtils.isEmpty(bVarA.a())) {
                        com.anythink.core.common.j.c.a(eVar, dVarA, "", bVarA.b());
                    } else {
                        new c(n.a().g(), iOptInt, bVarA.a(), eVar, dVarA).a(0, new i() { // from class: com.anythink.core.common.h.d.1.1
                            @Override // com.anythink.core.common.g.i
                            public final void onLoadCanceled(int i2) {
                            }

                            @Override // com.anythink.core.common.g.i
                            public final void onLoadError(int i2, String str, AdError adError) {
                                String str2 = "S2S reward error! PlacementId: " + strW + ", " + adError.printStackTrace();
                            }

                            @Override // com.anythink.core.common.g.i
                            public final void onLoadFinish(int i2, Object obj) {
                                if (n.a().A()) {
                                    String str = "S2S reward succeeded. PlacementId: " + strW;
                                }
                            }

                            @Override // com.anythink.core.common.g.i
                            public final void onLoadStart(int i2) {
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
