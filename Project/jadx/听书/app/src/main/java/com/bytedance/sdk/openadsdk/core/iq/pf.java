package com.bytedance.sdk.openadsdk.core.iq;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f1189a;
    public double dl;
    public double g;
    public double z;

    public pf(double d, double d2, double d3, double d4) {
        this.z = d;
        this.g = d2;
        this.dl = d3;
        this.f1189a = d4;
    }

    public boolean z(double d, double d2) {
        double d3 = this.dl;
        if (d3 <= 0.0d) {
            return false;
        }
        double d4 = this.f1189a;
        if (d4 <= 0.0d) {
            return false;
        }
        double d5 = this.z;
        if (d <= d5 || d >= d5 + d3) {
            return false;
        }
        double d6 = this.g;
        return d2 > d6 && d2 < d6 + d4;
    }

    public static pf z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("point");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("size");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() != 2 || jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
            return null;
        }
        return new pf(jSONArrayOptJSONArray.optDouble(0), jSONArrayOptJSONArray.optDouble(1), jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1));
    }

    public static JSONObject z(pf pfVar) {
        if (pfVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, pfVar.z);
            jSONArray.put(1, pfVar.g);
            jSONObject.put("point", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, pfVar.dl);
            jSONArray2.put(1, pfVar.f1189a);
            jSONObject.put("size", jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z("xeasy", "json:" + e.getMessage());
            return null;
        }
    }

    public static double z(pf pfVar, pf pfVar2) {
        if (pfVar == null || pfVar2 == null) {
            return 0.0d;
        }
        double d = pfVar.z;
        double d2 = pfVar.g;
        double d3 = pfVar.dl + d;
        double d4 = pfVar.f1189a + d2;
        double d5 = pfVar2.z;
        double d6 = pfVar2.g;
        double d7 = pfVar2.dl + d5;
        double d8 = pfVar2.f1189a + d6;
        double dMax = Math.max(d, d5);
        double dMax2 = Math.max(d2, d6);
        double dMin = (Math.min(d3, d7) - dMax) * (Math.min(d4, d8) - dMax2);
        if (d2 >= d8 || d3 <= d5 || d4 <= d6 || d >= d7) {
            return 0.0d;
        }
        return dMin;
    }

    public static pf g(pf pfVar, pf pfVar2) {
        if (pfVar == null) {
            return pfVar2;
        }
        if (pfVar2 == null) {
            return null;
        }
        double d = pfVar.z;
        double d2 = pfVar.g;
        double d3 = pfVar.dl + d;
        double d4 = pfVar.f1189a + d2;
        double d5 = pfVar2.z;
        double d6 = pfVar2.g;
        double d7 = pfVar2.dl + d5;
        double d8 = pfVar2.f1189a + d6;
        double dMin = Math.min(d, d5);
        double dMin2 = Math.min(d2, d6);
        return new pf(dMin, dMin2, Math.abs(Math.max(d3, d7) - dMin), Math.abs(Math.max(d4, d8) - dMin2));
    }
}
