package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class bz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1803a;

    public bz(Context context) {
        if (Engine.loadSuccess) {
            String strFgh = Engine.getInstance(context).fgh();
            if (TextUtils.isEmpty(strFgh)) {
                return;
            }
            try {
                this.f1803a = new JSONObject(strFgh);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f1803a;
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
