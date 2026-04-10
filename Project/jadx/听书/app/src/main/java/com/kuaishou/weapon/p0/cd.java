package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1809a;

    public cd(Context context) {
        if (Engine.loadSuccess) {
            String strHij = Engine.getInstance(context).hij();
            if (TextUtils.isEmpty(strHij)) {
                return;
            }
            try {
                this.f1809a = new JSONObject(strHij);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f1809a;
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
