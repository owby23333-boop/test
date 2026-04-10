package com.anythink.expressad.exoplayer.d;

import com.anythink.expressad.exoplayer.k.af;
import com.taobao.aranger.constant.Constants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class a {
    private static final String a = "ClearKeyUtil";

    private a() {
    }

    public static byte[] a(byte[] bArr) {
        if (af.a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(af.a(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray(Constants.PARAM_KEYS);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                sb.append("{\"k\":\"");
                sb.append(b(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(b(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return af.c(sb.toString());
        } catch (JSONException unused) {
            String str = "Failed to adjust response data: " + af.a(bArr);
            return bArr;
        }
    }

    private static byte[] b(byte[] bArr) {
        return af.a >= 27 ? bArr : af.c(af.a(bArr).replace('+', '-').replace('/', '_'));
    }

    private static String b(String str) {
        return str.replace('-', '+').replace('_', '/');
    }

    private static String a(String str) {
        return str.replace('+', '-').replace('/', '_');
    }
}
