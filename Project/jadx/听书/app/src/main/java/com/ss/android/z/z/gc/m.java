package com.ss.android.z.z.gc;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    private String g;
    private String z;

    public m(z zVar) {
        this.z = zVar.z;
        this.g = zVar.g;
    }

    public String z() {
        return this.z;
    }

    public static class z {
        private String g;
        private String z;

        public z z(String str) {
            this.z = str;
            return this;
        }

        public z g(String str) {
            this.g = str;
            return this;
        }

        public m z() {
            return new m(this);
        }
    }
}
