package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class au {
    private JSONObject a;
    private boolean b;

    public au(Context context) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f16632g).intValue(), 0, 200, "");
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
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean a() {
        return this.b;
    }

    public List b(String str) {
        JSONObject jSONObject = this.a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            String strA = i.a("98bb0a15913e0654348b", "0805");
            JSONArray jSONArray = new JSONArray(string);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string2 = jSONArray.getString(i2);
                if (string2.contains(strA)) {
                    this.b = true;
                } else {
                    arrayList.add(string2);
                }
            }
            if (arrayList.size() > 0) {
                return arrayList;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
