package com.bytedance.sdk.openadsdk.upie;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1483a;
    private String dl;
    private JSONObject e;
    private String g;
    private int gc;
    private long m;
    private String z;

    public String z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public int a() {
        return this.f1483a;
    }

    public int gc() {
        return this.gc;
    }

    public long m() {
        return this.m;
    }

    public JSONObject e() {
        return this.e;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.upie.z$z, reason: collision with other inner class name */
    public static class C0226z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f1484a;
        private String dl;
        private JSONObject e;
        private String g;
        private int gc;
        private long m;
        private String z;

        public C0226z z(String str) {
            this.z = str;
            return this;
        }

        public C0226z g(String str) {
            this.g = str;
            return this;
        }

        public C0226z dl(String str) {
            this.dl = str;
            return this;
        }

        public C0226z z(int i) {
            this.f1484a = i;
            return this;
        }

        public C0226z g(int i) {
            this.gc = i;
            return this;
        }

        public C0226z z(long j) {
            this.m = j;
            return this;
        }

        public C0226z z(JSONObject jSONObject) {
            this.e = jSONObject;
            return this;
        }

        public z z() {
            z zVar = new z();
            zVar.z = this.z;
            zVar.g = this.g;
            zVar.dl = this.dl;
            zVar.f1483a = this.f1484a;
            zVar.gc = this.gc;
            zVar.m = this.m;
            zVar.e = this.e;
            return zVar;
        }
    }
}
