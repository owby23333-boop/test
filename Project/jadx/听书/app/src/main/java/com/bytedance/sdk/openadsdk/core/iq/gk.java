package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class gk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f1163a;
    private int dl;
    private int g;
    private boolean gc;
    private String m;
    private String z;

    public String z() {
        return this.z;
    }

    public void z(String str) {
        this.z = str;
    }

    public int g() {
        return this.g;
    }

    public void z(int i) {
        this.g = i;
    }

    public int dl() {
        return this.dl;
    }

    public void g(int i) {
        this.dl = i;
    }

    public double a() {
        return this.f1163a;
    }

    public void z(double d) {
        this.f1163a = d;
    }

    public boolean gc() {
        return !TextUtils.isEmpty(this.z) && this.g > 0 && this.dl > 0;
    }

    public boolean m() {
        return this.gc;
    }

    public void z(boolean z2) {
        this.gc = z2;
    }

    public String e() {
        return this.m;
    }

    public void g(String str) {
        this.m = str;
    }

    public static com.bytedance.sdk.openadsdk.ls.dl.g.wp z(gk gkVar) {
        if (gkVar == null || !gkVar.gc()) {
            return null;
        }
        return new z(gkVar.dl(), gkVar.g(), gkVar.z(), gkVar.a());
    }

    public static final com.bytedance.sdk.openadsdk.ls.dl.g.wp z(int i, int i2, String str, double d) {
        return new z(i, i2, str, d);
    }

    private static final class z extends com.bytedance.sdk.openadsdk.ls.dl.g.wp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f1164a;
        private String dl;
        private int g;
        private int z;

        public z(int i, int i2, String str, double d) {
            this.z = i;
            this.g = i2;
            this.dl = str;
            this.f1164a = d;
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
        public int z() {
            return this.z;
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
        public int g() {
            return this.g;
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
        public String dl() {
            return this.dl;
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
        public double a() {
            return this.f1164a;
        }

        @Override // com.bytedance.sdk.openadsdk.ls.dl.g.wp
        public boolean gc() {
            String str;
            return this.z > 0 && this.g > 0 && (str = this.dl) != null && str.length() > 0;
        }
    }
}
