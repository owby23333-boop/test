package com.bytedance.msdk.m.g;

import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.bytedance.msdk.api.a.uy;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static void z(com.bytedance.sdk.openadsdk.ls.a aVar) {
        com.bytedance.sdk.openadsdk.ls.dl.dl.z zVar = new com.bytedance.sdk.openadsdk.ls.dl.dl.z(com.bytedance.msdk.core.z.kb().ti().sparseArray());
        aVar.z(8475, com.bytedance.sdk.openadsdk.ls.dl.a.z(z(zVar.kb())));
        aVar.z(8457, com.bytedance.sdk.openadsdk.ls.dl.a.z(z(zVar.pf())));
        aVar.z(1, Boolean.valueOf(com.bytedance.msdk.e.z.z.z().fo()));
    }

    public static void z(com.bytedance.sdk.openadsdk.ls.a aVar, com.bytedance.sdk.openadsdk.ls.a aVar2) {
        aVar.z(8424, com.bytedance.sdk.openadsdk.ls.dl.a.z(aVar2.g()));
    }

    public static SparseArray<Object> z(com.bytedance.sdk.openadsdk.mediation.init.z.g.z.z zVar) {
        if (zVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        aVarZ.z(8458, Boolean.valueOf(zVar.gc()));
        aVarZ.z(8459, zVar.kb());
        aVarZ.z(8460, zVar.z());
        aVarZ.z(8461, Boolean.valueOf(zVar.g()));
        aVarZ.z(8310, new gz(zVar.dl()));
        aVarZ.z(8462, zVar.a());
        aVarZ.z(8463, zVar.m());
        aVarZ.z(8464, zVar.e());
        aVarZ.z(8465, Boolean.valueOf(zVar.gz()));
        aVarZ.z(8466, Boolean.valueOf(zVar.fo()));
        aVarZ.z(8467, Boolean.valueOf(zVar.uy()));
        return aVarZ.g();
    }

    public static SparseArray<Object> z(com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar) {
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        if (aVar != null) {
            aVarZ.z(8311, new z(aVar.ls()));
            aVarZ.z(8023, Boolean.valueOf(aVar.dl()));
            aVarZ.z(8024, Boolean.valueOf(aVar.z()));
            aVarZ.z(8025, Boolean.valueOf(aVar.gc()));
            aVarZ.z(8026, Boolean.valueOf(aVar.g()));
            aVarZ.z(8480, Boolean.valueOf(aVar.a()));
            aVarZ.z(8479, Boolean.valueOf(aVar.m()));
            aVarZ.z(8312, aVar.fo() != null ? new m(aVar.fo()) : null);
            aVarZ.z(8483, aVar.fo());
            aVarZ.z(8484, aVar.uy());
            aVarZ.z(8485, aVar.v());
            aVarZ.z(8486, aVar.wp());
            aVarZ.z(8487, aVar.kb());
            aVarZ.z(8554, aVar.pf());
            aVarZ.z(8549, Boolean.valueOf(aVar.e()));
        } else {
            aVarZ.z(8311, new z(null));
            aVarZ.z(8023, Boolean.TRUE);
            aVarZ.z(8024, Boolean.TRUE);
            aVarZ.z(8025, Boolean.TRUE);
            aVarZ.z(8026, Boolean.TRUE);
            aVarZ.z(8480, Boolean.TRUE);
            aVarZ.z(8479, Boolean.TRUE);
            aVarZ.z(8312, new m(null));
            aVarZ.z(8483, null);
            aVarZ.z(8484, "");
            aVarZ.z(8485, "");
            aVarZ.z(8486, "");
            aVarZ.z(8487, "");
            aVarZ.z(8549, Boolean.TRUE);
        }
        return aVarZ.g();
    }

    private static class z extends e {
        public z(com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g gVar) {
            super(gVar);
        }

        @Override // com.bytedance.msdk.m.g.e
        public boolean z() {
            int iSv = com.bytedance.msdk.core.g.g().sv();
            if (iSv > 0) {
                return true;
            }
            if (iSv < 0) {
                return false;
            }
            return super.z();
        }

        @Override // com.bytedance.msdk.m.g.e
        public boolean g() {
            int iF = com.bytedance.msdk.core.g.g().f();
            if (iF > 0) {
                return false;
            }
            if (iF < 0) {
                return true;
            }
            return super.g();
        }
    }

    public static void z() {
        uy.z(new com.bytedance.sdk.openadsdk.ls.dl.dl.z(com.bytedance.msdk.core.z.kb().ti().sparseArray()).kb());
    }

    public static JSONObject g() {
        try {
            JSONObject jSONObject = new JSONObject();
            Map<String, com.bytedance.msdk.z.z.a> mapG = g.z().g();
            if (mapG != null && mapG.size() > 0) {
                for (Map.Entry<String, com.bytedance.msdk.z.z.a> entry : mapG.entrySet()) {
                    String key = entry.getKey();
                    com.bytedance.msdk.z.z.a value = entry.getValue();
                    long jGc = value.gc();
                    int iM = value.m();
                    if (jGc != 0) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(NotificationCompat.CATEGORY_STATUS, iM);
                        jSONObject2.put("duration", jGc);
                        jSONObject.put(key, jSONObject2);
                        value.e();
                    }
                }
            }
            if (com.bytedance.sdk.gromore.init.gc.m > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(NotificationCompat.CATEGORY_STATUS, 1);
                jSONObject3.put("duration", com.bytedance.sdk.gromore.init.gc.m);
                jSONObject3.put("plugin", gk.g() ? 1 : 0);
                jSONObject.put(MediationConstant.ADN_PANGLE, jSONObject3);
                com.bytedance.sdk.gromore.init.gc.m = 0L;
            }
            if (com.bytedance.sdk.gromore.init.gc.e > 0) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(NotificationCompat.CATEGORY_STATUS, 1);
                jSONObject4.put("duration", com.bytedance.sdk.gromore.init.gc.e);
                jSONObject4.put("plugin", gk.g() ? 1 : 0);
                jSONObject.put("fusion", jSONObject4);
                com.bytedance.sdk.gromore.init.gc.e = 0L;
            }
            if (com.bytedance.msdk.m.g.z.a() != null && com.bytedance.msdk.m.g.z.a().z() != null && com.bytedance.msdk.m.g.z.a().z().size() > 0) {
                for (Map.Entry<String, com.bytedance.msdk.api.a.z.g.m.z> entry2 : com.bytedance.msdk.m.g.z.a().z().entrySet()) {
                    String key2 = entry2.getKey();
                    com.bytedance.msdk.api.a.z.g.m.z value2 = entry2.getValue();
                    long jGc2 = value2.gc();
                    int iM2 = value2.m();
                    if (jGc2 != 0) {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(NotificationCompat.CATEGORY_STATUS, iM2);
                        jSONObject5.put("duration", jGc2);
                        jSONObject.put(key2, jSONObject5);
                        value2.e();
                    }
                }
            }
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
