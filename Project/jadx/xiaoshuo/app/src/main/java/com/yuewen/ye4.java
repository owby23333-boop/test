package com.yuewen;

import com.dangdang.reader.domain.GroupType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ye4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f20334a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20335b = "";
    public int c = 0;
    public String d = "";
    public String e = "";
    public double f = w51.l;
    public long g = 0;
    public long h = 0;
    public long i = 0;

    public static ye4 a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ye4 ye4Var = new ye4();
        try {
            ye4Var.f20334a = jSONObject.optInt("consume_type");
            ye4Var.f20335b = jSONObject.optString("coupon_id");
            ye4Var.c = jSONObject.optInt("status");
            ye4Var.e = jSONObject.optString("name");
            ye4Var.d = jSONObject.optString("description");
            ye4Var.f = jSONObject.optDouble("value");
            ye4Var.g = jSONObject.optLong("start_time") * 1000;
            ye4Var.h = jSONObject.optLong("expire_time") * 1000;
            ye4Var.i = jSONObject.optLong(GroupType.TypeColumn.CREATE_TIME) * 1000;
            return ye4Var;
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<ye4> b(JSONArray jSONArray) {
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

    public String c() {
        return this.f20335b;
    }

    public String d() {
        int i = this.f20334a;
        return i == 10 ? "month_continuous" : i == 11 ? "month" : i == 12 ? "season" : i == 13 ? "year" : i == 20 ? "limited" : "";
    }

    public long e() {
        return this.i;
    }

    public String f() {
        return this.d;
    }

    public long g() {
        return this.h;
    }

    public String h() {
        return this.e;
    }

    public long i() {
        return this.g;
    }

    public double j() {
        return this.f;
    }

    public final boolean k() {
        return this.c != 0;
    }

    public boolean l() {
        return !k() && m();
    }

    public final boolean m() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return i() < jCurrentTimeMillis && g() > jCurrentTimeMillis;
    }
}
