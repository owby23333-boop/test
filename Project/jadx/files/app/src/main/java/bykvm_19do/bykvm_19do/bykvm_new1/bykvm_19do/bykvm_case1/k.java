package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class k {
    public static String a(String str) {
        Map<String, Object> mapD;
        if (bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.e() != null && (mapD = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.e().d()) != null) {
            Object obj = mapD.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return null;
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.b bVar, bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar) {
        if (aVar == null || aVar.a() == null || cVar == null) {
            return;
        }
        JSONObject jSONObjectA = aVar.a();
        long jOptLong = jSONObjectA.optLong("crash_time");
        int iB = b(a("aid"));
        String strA = bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.j().a();
        if (jOptLong <= 0 || iB <= 0 || TextUtils.isEmpty(strA) || "0".equals(strA) || TextUtils.isEmpty(cVar.a())) {
            return;
        }
        try {
            String str = "android_" + iB + "_" + strA + "_" + jOptLong + "_" + cVar;
            if (bVar == null || (jSONObjectA = bVar.a()) != null) {
                jSONObjectA.put("unique_key", str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static int b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                j.b(e2);
            }
        }
        return 0;
    }
}
