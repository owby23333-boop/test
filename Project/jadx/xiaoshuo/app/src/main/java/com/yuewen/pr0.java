package com.yuewen;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class pr0 {
    public static final String A = "DK-HEITI";
    public static final /* synthetic */ boolean B = false;
    public static final String l = "FALLBACK_FONT";
    public static final String m = "DEFAULT_FONT_ZH";
    public static final String n = "DEFAULT_FONT_EN";
    public static final String o = "CUSTOM_FONT_ZH";
    public static final String p = "CUSTOM_FONT_EN";
    public static final String q = "DK-SERIF";
    public static final String r = "DK-CODE";
    public static final String s = "DK-SYMBOL";
    public static final String t = "DK-MATH";
    public static final String u = "DK-XIHEITI";
    public static final String v = "DK-SONGTI";
    public static final String w = "DK-FANGSONG";
    public static final String x = "DK-KAITI";
    public static final String y = "DK-XIAOBIAOSONG";
    public static final String z = "DK-DENGXIAN";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16108b;
    public Rect c;
    public Rect d;
    public boolean e;
    public int f;
    public double g;
    public double h;
    public double i;
    public final HashMap<String, String> j;
    public int k;

    public pr0() {
        this.f16107a = -1;
        this.f16108b = -1;
        this.c = new Rect(0, 0, 0, 0);
        this.d = new Rect(0, 0, 0, 0);
        this.e = false;
        this.f = 0;
        this.g = w51.l;
        this.h = w51.l;
        this.i = w51.l;
        this.k = 0;
        this.j = new HashMap<>();
    }

    public static pr0 f(String str) {
        try {
            return new pr0(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean a(pr0 pr0Var) {
        if (this.f16107a != pr0Var.f16107a || this.f16108b != pr0Var.f16108b || this.e != pr0Var.e) {
            return false;
        }
        Rect rect = this.c;
        int i = rect.left;
        Rect rect2 = pr0Var.c;
        if (i == rect2.left && rect.top == rect2.top && rect.right == rect2.right && rect.bottom == rect2.bottom) {
            Rect rect3 = this.d;
            int i2 = rect3.left;
            Rect rect4 = pr0Var.d;
            if (i2 != rect4.left || rect3.top != rect4.top || rect3.right != rect4.right || rect3.bottom != rect4.bottom || this.f != pr0Var.f || this.k != pr0Var.k || Double.compare(this.g, pr0Var.g) != 0 || Double.compare(this.h, pr0Var.h) != 0 || Double.compare(this.i, pr0Var.i) != 0 || this.j.size() != pr0Var.j.size()) {
                return false;
            }
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                String str = pr0Var.j.get(key);
                if (str == null || !str.equals(value)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Rect b() {
        Rect rect = this.d;
        int i = rect.left;
        Rect rect2 = this.c;
        return new Rect(i, rect2.top + rect.top, rect.right, rect2.bottom + rect.bottom);
    }

    public Rect c() {
        Rect rectB = b();
        return new Rect(rectB.left, rectB.top, this.f16107a - rectB.right, this.f16108b - rectB.bottom);
    }

    public boolean d() {
        return false;
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("page_width", this.f16107a);
            jSONObject.put("page_height", this.f16108b);
            jSONObject.put("bleed_enabled", this.e);
            jSONObject.put(so2.va, this.f);
            jSONObject.put("line_gap", this.g);
            jSONObject.put("para_spacing", this.h);
            jSONObject.put("bottom_status_top", this.k);
            jSONObject.put("first_line_indent", this.i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, this.c.left);
            jSONArray.put(1, this.c.top);
            jSONArray.put(2, this.c.right);
            jSONArray.put(3, this.c.bottom);
            jSONObject.put("page_outer_padding", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, this.d.left);
            jSONArray2.put(1, this.d.top);
            jSONArray2.put(2, this.d.right);
            jSONArray2.put(3, this.d.bottom);
            jSONObject.put("page_inner_padding", jSONArray2);
            JSONArray jSONArray3 = new JSONArray();
            for (Map.Entry<String, String> entry : this.j.entrySet()) {
                jSONArray3.put(entry.getKey());
                jSONArray3.put(entry.getValue());
            }
            jSONObject.put("font_map", jSONArray3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        return a((pr0) obj);
    }

    public String toString() {
        return e().toString();
    }

    public pr0(JSONObject jSONObject) throws JSONException {
        this.f16107a = -1;
        this.f16108b = -1;
        this.c = new Rect(0, 0, 0, 0);
        this.d = new Rect(0, 0, 0, 0);
        this.e = false;
        this.f = 0;
        this.g = w51.l;
        this.h = w51.l;
        this.i = w51.l;
        this.k = 0;
        this.f16107a = jSONObject.getInt("page_width");
        this.f16108b = jSONObject.getInt("page_height");
        this.k = jSONObject.getInt("bottom_status_top");
        this.e = jSONObject.optBoolean("bleed_enabled", false);
        this.f = jSONObject.getInt(so2.va);
        this.g = jSONObject.getDouble("line_gap");
        this.h = jSONObject.getDouble("para_spacing");
        this.i = jSONObject.getDouble("first_line_indent");
        JSONArray jSONArray = jSONObject.getJSONArray("page_outer_padding");
        this.c = new Rect(jSONArray.getInt(0), jSONArray.getInt(1), jSONArray.getInt(2), jSONArray.getInt(3));
        JSONArray jSONArray2 = jSONObject.getJSONArray("page_inner_padding");
        this.d = new Rect(jSONArray2.getInt(0), jSONArray2.getInt(1), jSONArray2.getInt(2), jSONArray2.getInt(3));
        JSONArray jSONArray3 = jSONObject.getJSONArray("font_map");
        this.j = new HashMap<>();
        for (int i = 0; i < jSONArray3.length(); i += 2) {
            this.j.put(jSONArray3.getString(i), jSONArray3.getString(i + 1));
        }
    }

    public pr0(pr0 pr0Var) {
        this.f16107a = -1;
        this.f16108b = -1;
        this.c = new Rect(0, 0, 0, 0);
        this.d = new Rect(0, 0, 0, 0);
        this.e = false;
        this.f = 0;
        this.g = w51.l;
        this.h = w51.l;
        this.i = w51.l;
        this.k = 0;
        this.f16107a = pr0Var.f16107a;
        this.f16108b = pr0Var.f16108b;
        this.c = pr0Var.c;
        this.d = pr0Var.d;
        this.k = pr0Var.k;
        this.e = pr0Var.e;
        this.f = pr0Var.f;
        this.g = pr0Var.g;
        this.h = pr0Var.h;
        this.i = pr0Var.i;
        this.j = new HashMap<>(pr0Var.j);
    }
}
