package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ci {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1814a;
    private int b;

    public ci(Context context, int i) {
        this.f1814a = context;
        this.b = i;
    }

    public JSONObject a() {
        JSONArray jSONArrayA;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            if (!WeaponHI.as) {
                return null;
            }
            h hVarA = h.a(this.f1814a, "re_po_rt");
            int iB = hVarA.b(df.o, 0);
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (iB == 1 && ((zE || zE2) && (jSONArrayA = new w(this.f1814a).a(0)) != null)) {
                jSONObject.put("10000", jSONArrayA);
                try {
                    jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Mo().Mn()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Mo().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Mo().getAppId()));
                } catch (Throwable unused) {
                }
                jSONObject.put("11007", System.currentTimeMillis() - jCurrentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        try {
            JSONObject jSONObjectA2 = new cm(str, ck.l).a(this.f1814a);
            if (jSONObjectA2 == null || (jSONObjectA = a()) == null) {
                return null;
            }
            jSONObjectA2.put("module_section", jSONObjectA);
            return jSONObjectA2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
