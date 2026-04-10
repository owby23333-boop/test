package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class bc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1784a;

    public bc(Context context, String str, int i) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(i, 0, cu.a() ? 1 : 0, str);
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f1784a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f1784a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
