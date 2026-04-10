package com.bytedance.embedapplog;

import android.content.Context;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class io extends tb {
    @Override // com.bytedance.embedapplog.tb
    public String dl() {
        return "d_i0";
    }

    public io(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.bytedance.embedapplog.tb
    protected String g() {
        JSONArray jSONArrayOptJSONArray = this.f301a.optJSONArray("path");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return "";
        }
        int length = jSONArrayOptJSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                strArr[i] = jSONArrayOptJSONArray.getString(i);
            } catch (JSONException e) {
                js.g("__kite" + dl() + "jsonArray parse error " + e.getMessage());
            }
        }
        if (js.g()) {
            js.z("__kite" + dl() + " plist size: " + length);
        }
        try {
            return z(strArr);
        } catch (Exception e2) {
            if (e2.getCause() != null) {
                this.dl = e2.getCause().getMessage();
            } else {
                this.dl = e2.getMessage();
            }
            return "";
        }
    }

    public String z(String[] strArr) {
        try {
            int[] dI0Result = TTEncryptUtils.getDI0Result(strArr);
            if (dI0Result == null || dI0Result.length <= 0) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            for (int i = 0; i < dI0Result.length; i++) {
                jSONObject.put(strArr[i], dI0Result[i]);
            }
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
