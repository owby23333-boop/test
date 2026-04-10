package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1783a;

    public bb(Context context, int i, String str, boolean z) {
        if (Engine.loadSuccess && z) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f).intValue(), 0, i, str);
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f1783a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            return g.a(context, g.i) != -1;
        } catch (Exception unused) {
            return false;
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f1783a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a() {
        return this.f1783a;
    }
}
