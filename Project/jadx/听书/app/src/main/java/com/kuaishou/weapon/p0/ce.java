package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1810a;

    public ce(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String strAbc = Engine.abc();
            if (TextUtils.isEmpty(strAbc)) {
                return;
            }
            try {
                this.f1810a = new JSONObject(strAbc);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f1810a;
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
