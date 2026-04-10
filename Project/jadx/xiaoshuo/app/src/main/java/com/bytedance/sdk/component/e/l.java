package com.bytedance.sdk.component.e;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class l {
    public final String bf;
    public final String d;
    public final int e;
    public final String ga;
    public final String p;
    public final String tg;
    public final String v;
    public final String vn;

    public static final class e {
        private String bf;
        private String d;
        private String e;
        private String ga;
        private String p;
        private String tg;
        private String vn;

        private e() {
        }

        public e bf(String str) {
            this.bf = str;
            return this;
        }

        public e d(String str) {
            this.d = str;
            return this;
        }

        public e e(String str) {
            this.e = str;
            return this;
        }

        public e ga(String str) {
            this.ga = str;
            return this;
        }

        public e p(String str) {
            this.p = str;
            return this;
        }

        public e tg(String str) {
            this.tg = str;
            return this;
        }

        public e vn(String str) {
            this.vn = str;
            return this;
        }

        public l e() {
            return new l(this);
        }
    }

    public static e e() {
        return new e();
    }

    public String toString() {
        return "methodName: " + this.tg + ", params: " + this.ga + ", callbackId: " + this.vn + ", type: " + this.d + ", version: " + this.bf + ", ";
    }

    private l(String str, int i) {
        this.bf = null;
        this.d = null;
        this.tg = null;
        this.ga = null;
        this.vn = str;
        this.p = null;
        this.e = i;
        this.v = null;
    }

    public static l e(String str, int i) {
        return new l(str, i);
    }

    public static boolean e(l lVar) {
        return lVar == null || lVar.e != 1 || TextUtils.isEmpty(lVar.tg) || TextUtils.isEmpty(lVar.ga);
    }

    private l(e eVar) {
        this.bf = eVar.e;
        this.d = eVar.bf;
        this.tg = eVar.d;
        this.ga = eVar.tg;
        this.vn = eVar.ga;
        this.p = eVar.vn;
        this.e = 1;
        this.v = eVar.p;
    }
}
