package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ay {
    private JSONObject a;

    public ay(Context context, int i2) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f16628c).intValue(), 2, i2 < 10 ? 10 : i2, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    private String b(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(String str) {
        try {
            String strB = b(str);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            return new JSONObject(strB);
        } catch (Exception unused) {
            return null;
        }
    }
}
