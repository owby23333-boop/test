package com.bytedance.sdk.component.adexpress.dynamic.dl;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f554a;
    private float dl;
    private float e;
    private gc fo;
    private float g;
    private float gc;
    private float gz;
    private String i;
    private gz kb;
    private float m;
    private List<gz> uy;
    private boolean v;
    private List<List<gz>> wp;
    private String z;
    private Map<String, String> pf = new HashMap();
    private Map<Integer, String> ls = new HashMap();

    public String z() {
        return this.i;
    }

    public void z(String str) {
        this.i = str;
    }

    public Map<Integer, String> g() {
        return this.ls;
    }

    public void z(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.ls.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String dl() {
        return this.z;
    }

    public void g(String str) {
        this.z = str;
    }

    public float a() {
        return this.f554a;
    }

    public void z(float f) {
        this.f554a = f;
    }

    public float gc() {
        return this.gc;
    }

    public void g(float f) {
        this.gc = f;
    }

    public float m() {
        return this.g;
    }

    public void dl(float f) {
        this.g = f;
    }

    public float e() {
        return this.dl;
    }

    public void a(float f) {
        this.dl = f;
    }

    public float gz() {
        return this.m;
    }

    public void gc(float f) {
        this.m = f;
    }

    public float fo() {
        return this.e;
    }

    public void m(float f) {
        this.e = f;
    }

    public void e(float f) {
        this.gz = f;
    }

    public gc uy() {
        return this.fo;
    }

    public void z(gc gcVar) {
        this.fo = gcVar;
    }

    public List<gz> kb() {
        return this.uy;
    }

    public void z(List<gz> list) {
        this.uy = list;
    }

    public void z(gz gzVar) {
        this.kb = gzVar;
    }

    public gz wp() {
        return this.kb;
    }

    public int i() {
        m mVarGc = this.fo.gc();
        return mVarGc.y() + mVarGc.ec();
    }

    public int v() {
        m mVarGc = this.fo.gc();
        return mVarGc.t() + mVarGc.vm();
    }

    public float pf() {
        m mVarGc = this.fo.gc();
        return i() + mVarGc.pf() + mVarGc.ls() + (mVarGc.wp() * 2.0f);
    }

    public float ls() {
        m mVarGc = this.fo.gc();
        return v() + mVarGc.p() + mVarGc.v() + (mVarGc.wp() * 2.0f);
    }

    public void g(List<List<gz>> list) {
        this.wp = list;
    }

    public List<List<gz>> p() {
        return this.wp;
    }

    public boolean fv() {
        List<gz> list = this.uy;
        return list == null || list.size() <= 0;
    }

    public boolean js() {
        return this.v;
    }

    public void z(boolean z) {
        this.v = z;
    }

    public Map<String, String> tb() {
        return this.pf;
    }

    public void z(String str, String str2) {
        this.pf.put(str, str2);
    }

    public void q() {
        List<List<gz>> list = this.wp;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<gz> list2 : this.wp) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.wp = arrayList;
    }

    public boolean iq() {
        return TextUtils.equals(this.fo.gc().l(), "flex");
    }

    public String zw() {
        return this.fo.gc().zw();
    }

    public void dl(String str) {
        this.fo.gc().m(str);
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.z + "', x=" + this.g + ", y=" + this.dl + ", width=" + this.m + ", height=" + this.e + ", remainWidth=" + this.gz + ", rootBrick=" + this.fo + ", childrenBrickUnits=" + this.uy + '}';
    }

    public boolean io() {
        return this.fo.gc().ja() < 0 || this.fo.gc().wn() < 0 || this.fo.gc().sd() < 0 || this.fo.gc().tf() < 0;
    }

    public String z(int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.fo.getType());
        sb.append(":");
        sb.append(this.z);
        if (this.fo.gc() != null) {
            sb.append(":");
            sb.append(this.fo.gc().yt());
        }
        sb.append(":");
        sb.append(i);
        if (this.fo.gc() != null) {
            sb.append(":");
            String strEo = this.fo.gc().eo();
            strEo.hashCode();
            switch (strEo) {
                case "9":
                case "16":
                case "29":
                    i2 = 1;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String strEo2 = this.fo.gc().eo();
            strEo2.hashCode();
            if (strEo2.equals("17") || strEo2.equals("18")) {
                i2 = (i2 * 10) + 2;
            }
            String strEo3 = this.fo.gc().eo();
            strEo3.hashCode();
            switch (strEo3) {
                case "0":
                case "5":
                case "10":
                case "12":
                case "13":
                case "20":
                case "22":
                case "24":
                case "29":
                    i2 = (i2 * 10) + 3;
                    break;
            }
            sb.append(i2);
        }
        return sb.toString();
    }
}
