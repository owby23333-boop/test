package anet.channel.strategy;

import java.io.Serializable;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class ConnHistoryItem implements Serializable {
    byte a = 0;
    long b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f432c = 0;

    ConnHistoryItem() {
    }

    void a(boolean z2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - (z2 ? this.b : this.f432c) > 10000) {
            this.a = (byte) ((this.a << 1) | (!z2 ? 1 : 0));
            if (z2) {
                this.b = jCurrentTimeMillis;
            } else {
                this.f432c = jCurrentTimeMillis;
            }
        }
    }

    boolean b() {
        return (this.a & 1) == 1;
    }

    boolean c() {
        return a() >= 3 && System.currentTimeMillis() - this.f432c <= 300000;
    }

    boolean d() {
        long j2 = this.b;
        long j3 = this.f432c;
        if (j2 <= j3) {
            j2 = j3;
        }
        return j2 != 0 && System.currentTimeMillis() - j2 > 86400000;
    }

    int a() {
        int i2 = 0;
        for (int i3 = this.a & 255; i3 > 0; i3 >>= 1) {
            i2 += i3 & 1;
        }
        return i2;
    }
}
