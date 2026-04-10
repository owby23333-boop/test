package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1183a;
    private String dl;
    private String e;
    private JSONArray fo;
    private String g;
    private String gc;
    private String gz;
    private JSONArray i;
    private String kb;
    private String m;
    private String uy;
    private HashMap<String, String> v = new HashMap<>();
    private float wp;
    private String z;

    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.v.put(str, str2);
    }

    public HashMap<String, String> z() {
        return this.v;
    }

    public String g() {
        return this.gc;
    }

    public void z(String str) {
        this.gc = str;
    }

    public float dl() {
        return this.wp;
    }

    public void z(float f) {
        this.wp = f;
    }

    public JSONArray a() {
        return this.i;
    }

    public void z(JSONArray jSONArray) {
        this.i = jSONArray;
    }

    public String gc() {
        return this.z;
    }

    public void g(String str) {
        this.z = str;
    }

    public String m() {
        return this.g;
    }

    public void dl(String str) {
        this.g = str;
    }

    public String e() {
        return this.dl;
    }

    public void a(String str) {
        this.dl = str;
    }

    public String gz() {
        return this.f1183a;
    }

    public void gc(String str) {
        this.f1183a = str;
    }

    public String fo() {
        return this.m;
    }

    public void m(String str) {
        this.m = str;
    }

    public String uy() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public String kb() {
        return this.gz;
    }

    public void gz(String str) {
        this.gz = str;
    }

    public JSONArray wp() {
        return this.fo;
    }

    public void g(JSONArray jSONArray) {
        this.fo = jSONArray;
    }

    public String i() {
        return this.uy;
    }

    public void fo(String str) {
        this.uy = str;
    }

    public String v() {
        return this.kb;
    }

    public void uy(String str) {
        this.kb = str;
    }
}
