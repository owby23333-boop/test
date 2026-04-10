package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class v {
    private float bf;
    private String bh;
    private float d;
    private String e;
    private float ga;
    private List<v> m;
    private float p;
    private boolean t;
    private float tg;
    private float v;
    private float vn;
    private v wu;
    private List<List<v>> xu;
    private ga zk;
    private Map<String, String> s = new HashMap();
    private Map<Integer, String> w = new HashMap();

    public Map<Integer, String> bf() {
        return this.w;
    }

    public int bh() {
        vn vnVarTg = this.zk.tg();
        return vnVarTg.rm() + vnVarTg.q();
    }

    public boolean cv() {
        return this.zk.tg().vs() < 0 || this.zk.tg().em() < 0 || this.zk.tg().z() < 0 || this.zk.tg().ev() < 0;
    }

    public String d() {
        return this.e;
    }

    public Map<String, String> dt() {
        return this.s;
    }

    public String e() {
        return this.bh;
    }

    public boolean f() {
        List<v> list = this.m;
        return list == null || list.size() <= 0;
    }

    public float ga() {
        return this.ga;
    }

    public boolean k() {
        return this.t;
    }

    public List<List<v>> l() {
        return this.xu;
    }

    public ga m() {
        return this.zk;
    }

    public float p() {
        return this.d;
    }

    public void pe() {
        List<List<v>> list = this.xu;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<v> list2 : this.xu) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.xu = arrayList;
    }

    public float s() {
        vn vnVarTg = this.zk.tg();
        return bh() + vnVarTg.t() + vnVarTg.s() + (vnVarTg.wu() * 2.0f);
    }

    public int t() {
        vn vnVarTg = this.zk.tg();
        return vnVarTg.b() + vnVarTg.r();
    }

    public float tg() {
        return this.tg;
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.e + "', x=" + this.bf + ", y=" + this.d + ", width=" + this.vn + ", height=" + this.p + ", remainWidth=" + this.v + ", rootBrick=" + this.zk + ", childrenBrickUnits=" + this.m + '}';
    }

    public float v() {
        return this.vn;
    }

    public float vn() {
        return this.bf;
    }

    public float w() {
        vn vnVarTg = this.zk.tg();
        return t() + vnVarTg.w() + vnVarTg.bh() + (vnVarTg.wu() * 2.0f);
    }

    public List<v> wu() {
        return this.m;
    }

    public v xu() {
        return this.wu;
    }

    public boolean y() {
        return TextUtils.equals(this.zk.tg().lc(), "flex");
    }

    public float zk() {
        return this.p;
    }

    public void bf(String str) {
        this.e = str;
    }

    public void d(float f) {
        this.bf = f;
    }

    public void e(String str) {
        this.bh = str;
    }

    public void ga(float f) {
        this.vn = f;
    }

    public void p(float f) {
        this.v = f;
    }

    public void tg(float f) {
        this.d = f;
    }

    public void vn(float f) {
        this.p = f;
    }

    public void bf(float f) {
        this.ga = f;
    }

    public void e(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.w.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void bf(List<List<v>> list) {
        this.xu = list;
    }

    public void e(float f) {
        this.tg = f;
    }

    public void e(ga gaVar) {
        this.zk = gaVar;
    }

    public void e(List<v> list) {
        this.m = list;
    }

    public void e(v vVar) {
        this.wu = vVar;
    }

    public void e(boolean z) {
        this.t = z;
    }

    public void e(String str, String str2) {
        this.s.put(str, str2);
    }

    public String e(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zk.getType());
        sb.append(":");
        sb.append(this.e);
        if (this.zk.tg() != null) {
            sb.append(":");
            sb.append(this.zk.tg().rk());
        }
        sb.append(":");
        sb.append(i);
        return sb.toString();
    }
}
