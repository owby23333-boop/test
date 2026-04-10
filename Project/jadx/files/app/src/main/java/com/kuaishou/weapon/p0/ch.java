package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch {
    private Context a;
    private int b;

    public ch(Context context, int i2) {
        this.a = context;
        this.b = i2;
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        try {
            JSONObject jSONObjectA2 = new cl(str, cj.f16635j).a(this.a);
            if (jSONObjectA2 == null || (jSONObjectA = a()) == null) {
                return null;
            }
            jSONObjectA2.put("module_section", jSONObjectA);
            return jSONObjectA2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a() {
        JSONArray jSONArrayA;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            if (!WeaponHI.as) {
                return null;
            }
            h hVarA = h.a(this.a, "re_po_rt");
            int iB = hVarA.b(de.f16692m, 0);
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (iB == 1 && ((zE || zE2) && (jSONArrayA = new w(this.a).a(0)) != null)) {
                jSONObject.put("10000", jSONArrayA);
                try {
                    jSONObject.put("11301", bg.c(com.kwad.sdk.c.b.AI().AH()));
                    jSONObject.put("11302", bg.c(com.kwad.sdk.c.b.AI().getSdkVersion()));
                    jSONObject.put("11303", bg.c(com.kwad.sdk.c.b.AI().getAppId()));
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
}
