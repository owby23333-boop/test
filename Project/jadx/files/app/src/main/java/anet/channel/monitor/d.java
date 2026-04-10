package anet.channel.monitor;

import anet.channel.util.ALog;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class d implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f353d;

    d(b bVar, long j2, long j3, long j4) {
        this.f353d = bVar;
        this.a = j2;
        this.b = j3;
        this.f352c = j4;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.a++;
        b.f342e += this.a;
        if (b.a == 1) {
            b.f341d = this.b - this.f352c;
        }
        int i2 = b.a;
        if (i2 >= 2 && i2 <= 3) {
            long j2 = this.f352c;
            long j3 = b.f340c;
            if (j2 >= j3) {
                b.f341d += this.b - j2;
            } else if (j2 < j3) {
                long j4 = this.b;
                if (j4 >= j3) {
                    b.f341d += j4 - j2;
                    b.f341d -= b.f340c - j2;
                }
            }
        }
        b.b = this.f352c;
        b.f340c = this.b;
        if (b.a == 3) {
            b.f346i = (long) this.f353d.f351n.a(b.f342e, b.f341d);
            b.f343f++;
            b.b(this.f353d);
            if (b.f343f > 30) {
                this.f353d.f351n.a();
                b.f343f = 3L;
            }
            double d2 = (b.f346i * 0.68d) + (b.f345h * 0.27d) + (b.f344g * 0.05d);
            b.f344g = b.f345h;
            b.f345h = b.f346i;
            if (b.f346i < b.f344g * 0.65d || b.f346i > b.f344g * 2.0d) {
                b.f346i = d2;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(b.f342e), "mKalmanTimeUsed", Long.valueOf(b.f341d), "speed", Double.valueOf(b.f346i), "mSpeedKalmanCount", Long.valueOf(b.f343f));
            }
            if (this.f353d.f350m > 5 || b.f343f == 2) {
                a.a().a(b.f346i);
                this.f353d.f350m = 0;
                this.f353d.f349l = b.f346i < b.f347j ? 1 : 5;
                ALog.i("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
            }
            b.f341d = 0L;
            b.f342e = 0L;
            b.a = 0;
        }
    }
}
