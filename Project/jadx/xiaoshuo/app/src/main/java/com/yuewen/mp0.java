package com.yuewen;

import com.dangdang.reader.domain.GroupType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14419a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14420b = 0;
    public long c = 0;
    public long d = 0;

    public static mp0 a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        mp0 mp0Var = new mp0();
        try {
            mp0Var.f14419a = jSONObject.optInt("used");
            mp0Var.f14420b = jSONObject.optLong("start") * 1000;
            mp0Var.c = jSONObject.optLong("expire") * 1000;
            mp0Var.d = jSONObject.optLong(GroupType.TypeColumn.CREATE_TIME) * 1000;
            return mp0Var;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<mp0> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(a(jSONArray.getJSONObject(i)));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    public long c() {
        return this.d;
    }

    public final long d() {
        return this.c;
    }

    public final long e() {
        return this.f14420b;
    }

    public final boolean f() {
        return this.f14419a != 0;
    }

    public boolean g() {
        return !f() && h();
    }

    public final boolean h() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return e() < jCurrentTimeMillis && d() > jCurrentTimeMillis;
    }
}
