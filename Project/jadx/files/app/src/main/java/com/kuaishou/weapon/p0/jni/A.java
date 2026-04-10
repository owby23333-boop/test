package com.kuaishou.weapon.p0.jni;

import android.content.Context;
import com.kuaishou.weapon.p0.Cdo;
import com.kuaishou.weapon.p0.w;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class A {
    private static int flag;
    private static JSONArray jsonObject;

    public A(Context context, int i2) {
        flag = i2;
        if (Engine.loadSuccess) {
            Engine.getInstance(context).qrs();
        } else {
            setA(context);
        }
    }

    public static String getE(String str) {
        try {
            Cdo cdoA = Cdo.a();
            if (cdoA != null) {
                return cdoA.a(str, "");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONArray getJsonObject() {
        return jsonObject;
    }

    public static void setA(Context context) {
        if (context != null) {
            jsonObject = new w(context).b(flag);
        }
    }

    public static void setE(String str, String str2) {
        try {
            Cdo cdoA = Cdo.a();
            if (cdoA != null) {
                cdoA.b(str, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void setJsonObject(JSONArray jSONArray) {
        jsonObject = jSONArray;
    }
}
