package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1807a;

    public cb(Context context) {
        if (Engine.loadSuccess) {
            String strGhi = Engine.getInstance(context).ghi();
            if (TextUtils.isEmpty(strGhi)) {
                return;
            }
            try {
                this.f1807a = new JSONObject(strGhi);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f1807a;
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
