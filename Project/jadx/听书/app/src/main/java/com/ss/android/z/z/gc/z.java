package com.ss.android.z.z.gc;

/* JADX INFO: loaded from: classes4.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2125a;
    public String dl;
    public String g;
    public String gc;
    public String z;

    public z(C0485z c0485z) {
        this.g = "";
        this.z = c0485z.z;
        this.g = c0485z.g;
        this.dl = c0485z.dl;
        this.f2125a = c0485z.f2126a;
        this.gc = c0485z.gc;
    }

    /* JADX INFO: renamed from: com.ss.android.z.z.gc.z$z, reason: collision with other inner class name */
    public static class C0485z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2126a;
        private String dl;
        private String g;
        private String gc;
        private String z;

        public C0485z z(String str) {
            this.z = str;
            return this;
        }

        public C0485z g(String str) {
            this.g = str;
            return this;
        }

        public C0485z dl(String str) {
            this.f2126a = str;
            return this;
        }

        public C0485z a(String str) {
            this.gc = str;
            return this;
        }

        public z z() {
            return new z(this);
        }
    }
}
