package com.umeng.analytics.pro;

/* JADX INFO: compiled from: ShortStack.java */
/* JADX INFO: loaded from: classes4.dex */
public class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private short[] f2180a;
    private int b = -1;

    public au(int i) {
        this.f2180a = new short[i];
    }

    public short a() {
        short[] sArr = this.f2180a;
        int i = this.b;
        this.b = i - 1;
        return sArr[i];
    }

    public void a(short s) {
        if (this.f2180a.length == this.b + 1) {
            d();
        }
        short[] sArr = this.f2180a;
        int i = this.b + 1;
        this.b = i;
        sArr[i] = s;
    }

    private void d() {
        short[] sArr = this.f2180a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f2180a = sArr2;
    }

    public short b() {
        return this.f2180a[this.b];
    }

    public void c() {
        this.b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<ShortStack vector:[");
        for (int i = 0; i < this.f2180a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.b) {
                sb.append(">>");
            }
            sb.append((int) this.f2180a[i]);
            if (i == this.b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }
}
