package com.ss.android.socialbase.downloader.network;

import com.yuewen.w51;

/* JADX INFO: loaded from: classes4.dex */
class tg {
    private final int bf;
    private double d = -1.0d;
    private final double e;
    private int tg;

    public tg(double d) {
        this.e = d;
        this.bf = d == w51.l ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    public void e(double d) {
        double d2 = 1.0d - this.e;
        int i = this.tg;
        if (i > this.bf) {
            this.d = Math.exp((d2 * Math.log(this.d)) + (this.e * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.d = Math.exp((d3 * Math.log(this.d)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.d = d;
        }
        this.tg++;
    }

    public double e() {
        return this.d;
    }
}
