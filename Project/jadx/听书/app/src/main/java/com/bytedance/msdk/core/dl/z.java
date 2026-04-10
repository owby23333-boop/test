package com.bytedance.msdk.core.dl;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f383a;
    private double dl;
    private double g;
    private String gc;
    private String kb;
    private int m;
    private String uy;
    private double z;
    private int e = 0;
    private int gz = 0;
    private int fo = 0;

    public z(double d, double d2, double d3, double d4, int i, String str) {
        this.z = d;
        this.g = d2;
        this.dl = d3;
        this.f383a = d4;
        this.gc = str;
        this.m = i;
    }

    public String toString() {
        return "adnName = " + this.uy + " adnRit = " + this.kb + ", send = " + this.e + ", fill = " + this.gz + ", show = " + this.fo + " localSsr = " + this.z + ", serviceSsr = " + this.dl + ", localSrr = " + this.g + ", serviceSrr = " + this.f383a + ", opt = " + this.gc + ", condition = " + this.m + ", compareBehaviorSsr = " + a() + ", compareBehaviorSrr = " + gc() + ", checkBehaviorRule = " + z();
    }

    public boolean z() {
        return a();
    }

    private boolean a() {
        return z(this.z, this.dl);
    }

    private boolean gc() {
        return z(this.g, this.f383a);
    }

    private boolean z(double d, double d2) {
        String str = this.gc;
        str.hashCode();
        switch (str) {
            case "1":
                if (d > d2) {
                }
                break;
            case "2":
                if (d < d2) {
                }
                break;
            case "3":
                if (d >= d2) {
                }
                break;
            case "4":
                if (d <= d2) {
                }
                break;
            case "5":
                if (d == d2) {
                }
                break;
        }
        return true;
    }

    public double g() {
        return this.z;
    }

    public double dl() {
        return this.g;
    }

    public void z(int i) {
        this.e = i;
    }

    public void g(int i) {
        this.gz = i;
    }

    public void dl(int i) {
        this.fo = i;
    }

    public void z(String str) {
        this.uy = str;
    }

    public void g(String str) {
        this.kb = str;
    }
}
