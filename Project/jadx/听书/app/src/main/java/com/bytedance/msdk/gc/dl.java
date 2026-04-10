package com.bytedance.msdk.gc;

import android.content.Context;
import com.bytedance.msdk.gc.g;
import com.bytedance.msdk.gz.sy;
import com.bytedance.sdk.component.gz.z.z;
import com.bytedance.sdk.component.utils.wp;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static final AtomicLong g = new AtomicLong(0);
    private static volatile boolean z;

    public static void z() {
        z = true;
    }

    public static boolean g() {
        return z;
    }

    public static void z(Context context) {
        int iSy = com.bytedance.msdk.core.g.g().sy();
        com.bytedance.sdk.component.gz.g.z.z(new z.C0136z().z(new fo()).g(com.bytedance.sdk.component.gz.g.a.g.z.z(iSy, iSy, 172800000L)).g(com.bytedance.msdk.core.z.kb().i()).z(new uy()).z(kb.z).z("csj_mediation").z(context).z());
        com.bytedance.sdk.component.gz.g.z.g("csj_mediation");
    }

    public static void z(Context context, a aVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.g.g().v()) {
            Context context2 = context == null ? com.bytedance.msdk.core.g.getContext() : context;
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            jSONObject.put("eventIndex", g.getAndIncrement());
            jSONObject.put("is_main_process", sy.z(context));
            jSONObject.put("is_cypher_v4", com.bytedance.msdk.core.g.z().z());
            if (com.bytedance.msdk.core.z.kb().fo()) {
                jSONObject.put("e2e_test_flag", "1");
            }
            if (aVar != null) {
                aVar.z("event_id", UUID.randomUUID().toString());
            }
            JSONObject jSONObjectZ = z.z(aVar, jSONObject);
            if (!z) {
                g.z().z(aVar, jSONObjectZ);
            } else {
                z(context2, aVar, jSONObjectZ);
            }
        }
    }

    public static void g(Context context) {
        try {
            List<g.z> listG = g.z().g();
            if (listG != null) {
                for (g.z zVar : listG) {
                    if (zVar != null) {
                        z(context, zVar.z(), zVar.g());
                    }
                }
            }
            g.z().dl();
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private static void z(Context context, a aVar, JSONObject jSONObject) {
        if (com.bytedance.sdk.component.gz.g.z.z("csj_mediation")) {
            z(context);
        }
        e eVarZ = e.z(context, aVar, jSONObject);
        com.bytedance.msdk.gz.a.g.z(eVarZ, true);
        com.bytedance.sdk.component.gz.g.a.z.z zVar = new com.bytedance.sdk.component.gz.g.a.z.z(eVarZ.z, eVarZ);
        zVar.z((byte) 3);
        zVar.g((byte) 2);
        com.bytedance.sdk.component.gz.g.z.z(zVar, "csj_mediation");
    }

    public static void dl() {
        com.bytedance.sdk.component.gz.g.z.a("csj_mediation");
    }
}
