package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cg {
    private Context a;
    private int b;

    public cg(Context context, int i2) {
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
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            if (h.a(this.a, "re_po_rt").b(de.f16702w, 1) == 1 && (jSONArrayA = new x().a(this.a)) != null && jSONArrayA.length() > 0) {
                jSONObject.put("10000", jSONArrayA);
                try {
                    jSONObject.put("11203", bg.b(com.kwad.sdk.c.b.AI().AG()));
                    jSONObject.put("11301", bg.c(com.kwad.sdk.c.b.AI().AH()));
                    jSONObject.put("11302", bg.c(com.kwad.sdk.c.b.AI().getSdkVersion()));
                    jSONObject.put("11303", bg.c(com.kwad.sdk.c.b.AI().getAppId()));
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }
}
