package com.bytedance.msdk.core.uy;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements Comparable<gc> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f409a;
    private int dl;
    private double g;
    private String z;

    public gc(String str, double d, int i, int i2) {
        this.z = str;
        this.g = d;
        this.dl = i;
        this.f409a = i2;
    }

    public String z() {
        return this.z;
    }

    public double g() {
        return this.g;
    }

    public int dl() {
        return this.dl;
    }

    public int a() {
        return this.f409a;
    }

    public String toString() {
        return "{mCsjRitId:" + this.z + ",mEcpm:" + this.g + ",mLoadSort:" + this.dl + ",mShowSort:" + this.f409a + "}";
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(gc gcVar) {
        if (gcVar == null) {
            return 1;
        }
        if (this.g > gcVar.g()) {
            return -1;
        }
        if (this.g < gcVar.g() || this.dl > gcVar.dl()) {
            return 1;
        }
        if (this.dl < gcVar.dl()) {
            return -1;
        }
        if (this.f409a > gcVar.a()) {
            return 1;
        }
        return this.f409a < gcVar.a() ? -1 : 0;
    }
}
