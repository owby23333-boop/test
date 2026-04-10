package com.ss.android.socialbase.downloader.fo;

/* JADX INFO: loaded from: classes4.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2070a;
    private double dl = -1.0d;
    private final int g;
    private final double z;

    public a(double d) {
        this.z = d;
        this.g = d == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void z(double d) {
        double d2 = 1.0d - this.z;
        int i = this.f2070a;
        if (i > this.g) {
            this.dl = Math.exp((d2 * Math.log(this.dl)) + (this.z * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.dl = Math.exp((d3 * Math.log(this.dl)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.dl = d;
        }
        this.f2070a++;
    }

    public double z() {
        return this.dl;
    }
}
