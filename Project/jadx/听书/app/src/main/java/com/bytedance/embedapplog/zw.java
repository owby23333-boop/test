package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zw extends tb {
    @Override // com.bytedance.embedapplog.tb
    public String dl() {
        return "d_a0";
    }

    public zw(Context context, JSONObject jSONObject) {
        super(context, jSONObject);
    }

    @Override // com.bytedance.embedapplog.tb
    protected String g() {
        JSONArray jSONArrayOptJSONArray = this.f301a.optJSONArray("path");
        if (jSONArrayOptJSONArray == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                String string = jSONArrayOptJSONArray.getString(i);
                jSONObject.put(string, z(string));
            } catch (Exception e) {
                if (e.getCause() != null) {
                    this.dl = e.getCause().getMessage();
                } else {
                    this.dl = e.getMessage();
                }
            }
        }
        return jSONObject.toString();
    }

    public String z(String str) {
        try {
            String dA0Result = TTEncryptUtils.getDA0Result(str);
            if (js.g()) {
                js.z("__kite", "p：" + str + " r:" + dA0Result);
            }
            return !TextUtils.isEmpty(dA0Result) ? dA0Result : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
