package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class aq {
    private JSONObject a;

    public aq(Context context, int i2) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f16628c).intValue(), 3, i2, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set b(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject != null) {
            try {
                String strOptString = jSONObject.optString(str, null);
                if (!TextUtils.isEmpty(strOptString) && strOptString.length() > 3) {
                    HashSet hashSet = new HashSet();
                    JSONArray jSONArray = new JSONArray(strOptString);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        hashSet.add(Integer.valueOf(Integer.valueOf((String) jSONArray.get(i2), 16).intValue()));
                    }
                    return hashSet;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
