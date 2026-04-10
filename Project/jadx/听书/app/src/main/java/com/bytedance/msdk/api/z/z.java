package com.bytedance.msdk.api.z;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements dl {
    private int dl;
    private boolean e;
    private String g;
    private int gz;
    private int kb;
    private String m;
    private JSONObject uy;
    private String wp;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f369a = 1;
    private int gc = 0;
    public int z = 0;
    private int fo = 2;

    @Override // com.bytedance.msdk.api.z.dl
    public String z() {
        return this.g;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void z(String str) {
        this.g = str;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void z(int i) {
        this.dl = i;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int g() {
        return this.dl;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int dl() {
        return this.f369a;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void g(int i) {
        this.f369a = i;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void dl(int i) {
        this.gc = i;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int a() {
        return this.gc;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int gc() {
        return this.z;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void a(int i) {
        this.z = i;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public String m() {
        return this.m;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void g(String str) {
        this.m = str;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public boolean e() {
        return this.e;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void gc(int i) {
        this.gz = i;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int gz() {
        return this.gz;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void m(int i) {
        this.fo = i;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int fo() {
        return this.fo;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void z(JSONObject jSONObject) {
        this.uy = jSONObject;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public JSONObject uy() {
        return this.uy;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public int kb() {
        return this.kb;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void e(int i) {
        this.kb = i;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public void dl(String str) {
        this.wp = str;
    }

    @Override // com.bytedance.msdk.api.z.dl
    public String wp() {
        return this.wp;
    }
}
