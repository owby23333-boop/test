package com.bytedance.msdk.api.a;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f354a;
    private boolean dl;
    private String e;
    private String fo;
    private int g;
    private int[] gc;
    private Map<String, String> gz;
    private String[] m;
    private boolean z;

    private wp(z zVar) {
        this.z = zVar.z;
        this.g = zVar.g;
        this.dl = zVar.dl;
        this.f354a = zVar.f355a;
        this.gc = zVar.gc;
        this.m = zVar.m;
        this.e = zVar.e;
        this.gz = zVar.gz;
        this.fo = zVar.fo;
    }

    public static class z {
        private boolean z = false;
        private int g = 0;
        private boolean dl = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f355a = false;
        private int[] gc = {4, 3, 5};
        private String[] m = new String[0];
        private String e = "";
        private final Map<String, String> gz = new HashMap();
        private String fo = "";

        public z z(boolean z) {
            this.z = z;
            return this;
        }

        public z z(int i) {
            this.g = i;
            return this;
        }

        public z g(boolean z) {
            this.dl = z;
            return this;
        }

        public z z(int... iArr) {
            this.gc = iArr;
            return this;
        }

        public z z(String str) {
            this.e = str;
            return this;
        }

        public z z(Map<String, String> map) {
            this.gz.putAll(map);
            return this;
        }

        public z g(String str) {
            this.fo = str;
            return this;
        }

        public wp z() {
            return new wp(this);
        }
    }

    public boolean z() {
        return this.z;
    }

    public int g() {
        return this.g;
    }

    public boolean dl() {
        return this.dl;
    }

    public boolean a() {
        return this.f354a;
    }

    public int[] gc() {
        return this.gc;
    }

    public String[] m() {
        return this.m;
    }

    public String e() {
        return this.e;
    }

    public Map<String, String> gz() {
        return this.gz;
    }

    public String fo() {
        return this.fo;
    }
}
