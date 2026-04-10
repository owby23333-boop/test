package com.bytedance.sdk.openadsdk.core.dt;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes10.dex */
public class ga {
    private String bf;
    private String d;
    private String e;
    private String ga;
    private float m;
    private JSONArray p;
    private String tg;
    private String v;
    private String vn;
    private JSONArray wu;
    private HashMap<String, String> xu = new HashMap<>();
    private String zk;

    public String bf() {
        return this.ga;
    }

    public float d() {
        return this.m;
    }

    public void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.xu.put(str, str2);
    }

    public String ga() {
        return this.e;
    }

    public JSONArray m() {
        return this.p;
    }

    public String p() {
        return this.d;
    }

    public JSONArray tg() {
        return this.wu;
    }

    public String v() {
        return this.tg;
    }

    public String vn() {
        return this.bf;
    }

    public String wu() {
        return this.v;
    }

    public String xu() {
        return this.zk;
    }

    public String zk() {
        return this.vn;
    }

    public void bf(String str) {
        this.e = str;
    }

    public void d(String str) {
        this.bf = str;
    }

    public void ga(String str) {
        this.tg = str;
    }

    public void p(String str) {
        this.v = str;
    }

    public void tg(String str) {
        this.d = str;
    }

    public void v(String str) {
        this.zk = str;
    }

    public void vn(String str) {
        this.vn = str;
    }

    public void bf(JSONArray jSONArray) {
        this.p = jSONArray;
    }

    public HashMap<String, String> e() {
        return this.xu;
    }

    public void e(String str) {
        this.ga = str;
    }

    public void e(float f) {
        this.m = f;
    }

    public void e(JSONArray jSONArray) {
        this.wu = jSONArray;
    }
}
