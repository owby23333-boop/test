package com.bytedance.embedapplog.util;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f304a;
    private final String[] dl;
    private final String e;
    private final String[] g;
    private final String gc;
    private final String m;
    private final String z;

    private z(C0063z c0063z) {
        this.z = c0063z.z;
        this.g = c0063z.g;
        this.dl = c0063z.dl;
        this.f304a = c0063z.f305a;
        this.gc = c0063z.gc;
        this.m = c0063z.m;
        this.e = c0063z.e;
    }

    /* JADX INFO: renamed from: com.bytedance.embedapplog.util.z$z, reason: collision with other inner class name */
    public static class C0063z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f305a;
        private String[] dl;
        private String e;
        private String[] g;
        private String gc;
        private String m;
        private String z;

        public C0063z z(String str) {
            this.z = str;
            return this;
        }

        public C0063z z(String[] strArr) {
            this.g = strArr;
            return this;
        }

        public C0063z g(String[] strArr) {
            this.dl = strArr;
            return this;
        }

        public C0063z g(String str) {
            this.f305a = str;
            return this;
        }

        public C0063z dl(String str) {
            this.gc = str;
            return this;
        }

        public C0063z a(String str) {
            this.e = str;
            return this;
        }

        public z z() {
            return new z(this);
        }
    }

    public String z() {
        return this.z;
    }

    public String[] g() {
        return this.g;
    }

    public String dl() {
        return this.f304a;
    }

    public String a() {
        return this.gc;
    }

    public static z z(int i) {
        return g.z(i);
    }
}
