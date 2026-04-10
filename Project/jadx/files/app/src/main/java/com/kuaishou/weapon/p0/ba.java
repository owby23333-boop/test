package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ba {
    private JSONObject a;
    private int b;

    public ba(Context context, int i2, String str, boolean z2) {
        if (Engine.loadSuccess && z2) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(cj.f16631f).intValue(), 0, i2, str);
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return g.a(context, g.f16729i) != -1;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int a() {
        return this.b;
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

    public JSONObject b() {
        return this.a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|2|56|3|54|4|(8:50|5|(5:8|(2:10|(2:12|(3:16|(1:22)|23)))|24|(1:26)(1:61)|6)|60|27|(1:29)|58|30)|52|31|43|(1:45)(1:46)) */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00cc A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject c() {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.ba.c():org.json.JSONObject");
    }
}
