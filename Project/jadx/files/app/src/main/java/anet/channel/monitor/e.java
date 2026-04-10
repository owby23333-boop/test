package anet.channel.monitor;

import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class e {
    private double b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private double f358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private double f359h;
    private long a = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private double f360i = PangleAdapterUtils.CPM_DEFLAUT_VALUE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private double f361j = PangleAdapterUtils.CPM_DEFLAUT_VALUE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private double f362k = PangleAdapterUtils.CPM_DEFLAUT_VALUE;

    e() {
    }

    public double a(double d2, double d3) {
        double d4 = d2 / d3;
        if (d4 < 8.0d) {
            if (this.a != 0) {
                return this.f362k;
            }
            this.f362k = d4;
            return this.f362k;
        }
        long j2 = this.a;
        if (j2 == 0) {
            this.f360i = d4;
            this.f359h = this.f360i;
            double d5 = this.f359h;
            this.f355d = d5 * 0.1d;
            this.f354c = 0.02d * d5;
            this.f356e = 0.1d * d5 * d5;
        } else if (j2 == 1) {
            this.f361j = d4;
            this.f359h = this.f361j;
        } else {
            double d6 = this.f361j;
            double d7 = d4 - d6;
            this.f360i = d6;
            this.f361j = d4;
            this.b = d4 / 0.95d;
            this.f358g = this.b - (this.f359h * 0.95d);
            char c2 = 0;
            double dSqrt = Math.sqrt(this.f355d);
            double d8 = this.f358g;
            if (d8 >= 4.0d * dSqrt) {
                this.f358g = (d8 * 0.75d) + (dSqrt * 2.0d);
                c2 = 1;
            } else if (d8 <= (-4.0d) * dSqrt) {
                this.f358g = (dSqrt * (-1.0d)) + (d8 * 0.75d);
                c2 = 2;
            }
            double d9 = this.f355d * 1.05d;
            double d10 = this.f358g;
            this.f355d = Math.min(Math.max(Math.abs(d9 - ((0.0025d * d10) * d10)), this.f355d * 0.8d), this.f355d * 1.25d);
            double d11 = this.f356e;
            this.f357f = d11 / ((0.9025d * d11) + this.f355d);
            this.f359h = this.f359h + (1.0526315789473684d * d7) + (this.f357f * this.f358g);
            if (c2 == 1) {
                this.f359h = Math.min(this.f359h, this.b);
            } else if (c2 == 2) {
                this.f359h = Math.max(this.f359h, this.b);
            }
            this.f356e = (1.0d - (0.95d * this.f357f)) * (this.f356e + this.f354c);
        }
        double d12 = this.f359h;
        if (d12 < PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            this.f362k = this.f361j * 0.7d;
            this.f359h = this.f362k;
        } else {
            this.f362k = d12;
        }
        return this.f362k;
    }

    public void a() {
        this.a = 0L;
        this.f362k = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
    }
}
