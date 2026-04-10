package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f1813a;
    private int b;

    public ch(Context context, int i) {
        this.f1813a = context;
        this.b = i;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (h.a(this.f1813a, "re_po_rt").b(df.y, 1) != 1) {
                return null;
            }
            try {
                JSONArray jSONArrayA = new x().a(this.f1813a);
                if (jSONArrayA != null && jSONArrayA.length() > 0) {
                    jSONObject.put("10000", jSONArrayA);
                    jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Mo().Mn()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Mo().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Mo().getAppId()));
                }
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        try {
            JSONObject jSONObjectA2 = new cm(str, ck.l).a(this.f1813a);
            if (jSONObjectA2 != null && (jSONObjectA = a()) != null && jSONObjectA.length() != 0) {
                jSONObjectA2.put("module_section", jSONObjectA);
                return jSONObjectA2.toString();
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
