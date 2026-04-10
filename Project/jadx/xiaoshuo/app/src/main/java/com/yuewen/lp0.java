package com.yuewen;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class lp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13960a = 0;

    public static lp0 a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        lp0 lp0Var = new lp0();
        try {
            lp0Var.f13960a = jSONObject.optLong("start_time") * 1000;
            return lp0Var;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<lp0> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("awards");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONArray jSONArrayOptJSONArray = jSONArray2.getJSONObject(i).optJSONArray("claim_range");
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                        arrayList.add(a(jSONArrayOptJSONArray.getJSONObject(i3)));
                    }
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public long c() {
        return this.f13960a;
    }
}
