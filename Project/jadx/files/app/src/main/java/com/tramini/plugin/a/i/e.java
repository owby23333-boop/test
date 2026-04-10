package com.tramini.plugin.a.i;

import android.text.TextUtils;
import com.tramini.plugin.a.i.f;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {

    final class a implements f.d {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.tramini.plugin.a.i.f.d
        public final boolean a(Object obj) {
            return (obj instanceof List) || obj.getClass().getName().contains(this.a);
        }

        @Override // com.tramini.plugin.a.i.f.d
        public final f.b b(Object obj) {
            try {
                if (!(obj instanceof List)) {
                    return f.b.a(obj);
                }
                List list = (List) obj;
                if (list != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        Object obj2 = list.get(i2);
                        if (obj2.getClass().getName().contains(this.a)) {
                            return f.b.a(obj2);
                        }
                    }
                    return f.b.a();
                }
                return f.b.a();
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public static com.tramini.plugin.a.g.a a(JSONObject jSONObject, com.tramini.plugin.a.g.c cVar, String str, String str2) {
        return a(f.a(jSONObject.optString("in_na"), str), jSONObject.optString("pre"), jSONObject.optString("clna"), jSONObject, cVar.f19339e, str2);
    }

    private static com.tramini.plugin.a.g.a a(Object obj, String str, String str2, JSONObject jSONObject, JSONArray jSONArray, String str3) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (!TextUtils.equals(str3, "0")) {
                obj = f.a(obj, str, stringBuffer, new a(str2));
            }
            if (obj == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    String strOptString = jSONArray.optString(i2);
                    Object objA = f.a(obj, jSONObject.optString(strOptString));
                    if (objA != null) {
                        String string = objA.toString();
                        if (!TextUtils.isEmpty(string)) {
                            jSONObject2.put(strOptString, string);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            if (jSONObject2.length() > 0) {
                com.tramini.plugin.a.g.a aVar = new com.tramini.plugin.a.g.a();
                aVar.a = jSONObject2;
                return aVar;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }
}
