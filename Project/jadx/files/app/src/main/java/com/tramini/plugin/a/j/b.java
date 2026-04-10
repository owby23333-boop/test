package com.tramini.plugin.a.j;

import com.tramini.plugin.a.a.c;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static b b;
    private Map<Integer, Runnable> a;

    private b() {
    }

    public static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    public final void a(Runnable runnable) {
        if (this.a == null) {
            this.a = new HashMap(3);
        }
        this.a.put(2, runnable);
    }

    public final synchronized void a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        a(1, str, jSONObject, jSONObject2);
    }

    private synchronized void a(int i2, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        l.c.a.a.a aVarB = l.c.a.a.b.a(c.c().a()).b();
        if (aVarB == null) {
            return;
        }
        com.tramini.plugin.a.g.c cVar = aVarB.e().get(str);
        int iNextInt = 5000;
        if (cVar != null) {
            iNextInt = cVar.b;
            int i3 = cVar.f19337c;
            if (iNextInt == 0 && i3 == 0) {
                iNextInt = 0;
            } else if (iNextInt != i3) {
                iNextInt += new Random().nextInt(i3 - iNextInt);
            }
        }
        c.c().a(new a(this, str, jSONObject, jSONObject2, i2), iNextInt);
    }

    public final void a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", 14);
            jSONObject.put("setting_id", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(0, str, (JSONObject) null, jSONObject);
    }

    public final void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        JSONObject jSONObject5 = new JSONObject();
        try {
            jSONObject5.put("sdk_time", System.currentTimeMillis());
            jSONObject5.put("type", 16);
            jSONObject5.put("setting_id", str2);
            jSONObject5.put("it_lps", jSONObject2);
            jSONObject5.put("it_lvn", jSONObject3);
            jSONObject5.put("it_lvc", jSONObject4);
        } catch (Throwable unused) {
        }
        a(2, str, jSONObject, jSONObject5);
    }

    public final void a(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            jSONObject2.put("sdk_time", System.currentTimeMillis());
            jSONObject2.put("type", 17);
            jSONObject2.put("setting_id", str2);
        } catch (Throwable unused) {
        }
        a(3, str, jSONObject, jSONObject2);
    }
}
