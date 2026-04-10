package com.bytedance.sdk.component.z;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f859a;
    public final String dl;
    public final String e;
    public final String g;
    public final String gc;
    public final String gz;
    public final String m;
    public final int z;

    public static z z() {
        return new z();
    }

    public static ls z(String str, int i) {
        return new ls(str, i);
    }

    private ls(String str, int i) {
        this.g = null;
        this.dl = null;
        this.f859a = null;
        this.gc = null;
        this.m = str;
        this.e = null;
        this.z = i;
        this.gz = null;
    }

    private ls(z zVar) {
        this.g = zVar.z;
        this.dl = zVar.g;
        this.f859a = zVar.dl;
        this.gc = zVar.f860a;
        this.m = zVar.gc;
        this.e = zVar.m;
        this.z = 1;
        this.gz = zVar.e;
    }

    public static boolean z(ls lsVar) {
        return lsVar == null || lsVar.z != 1 || TextUtils.isEmpty(lsVar.f859a) || TextUtils.isEmpty(lsVar.gc);
    }

    public String toString() {
        return "methodName: " + this.f859a + ", params: " + this.gc + ", callbackId: " + this.m + ", type: " + this.dl + ", version: " + this.g + ", ";
    }

    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f860a;
        private String dl;
        private String e;
        private String g;
        private String gc;
        private String m;
        private String z;

        private z() {
        }

        public z z(String str) {
            this.z = str;
            return this;
        }

        public z g(String str) {
            this.g = str;
            return this;
        }

        public z dl(String str) {
            this.dl = str;
            return this;
        }

        public z a(String str) {
            this.f860a = str;
            return this;
        }

        public z gc(String str) {
            this.gc = str;
            return this;
        }

        public z m(String str) {
            this.m = str;
            return this;
        }

        public z e(String str) {
            this.e = str;
            return this;
        }

        public ls z() {
            return new ls(this);
        }
    }
}
