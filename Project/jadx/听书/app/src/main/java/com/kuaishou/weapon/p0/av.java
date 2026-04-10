package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f1776a;

    public av(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.c).intValue(), 4, i, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f1776a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f1776a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            if (string.length() > 2) {
                return string;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
