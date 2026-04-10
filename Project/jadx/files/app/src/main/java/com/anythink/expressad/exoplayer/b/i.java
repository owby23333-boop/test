package com.anythink.expressad.exoplayer.b;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
final class i {
    private static final int a = 0;
    private static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8532c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f8533d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f8534e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8535f = 5000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8536g = 10000000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8537h = 500000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f8538i = 500000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private final a f8539j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8540k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f8541l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f8542m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f8543n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f8544o;

    @TargetApi(19)
    private static final class a {
        private final AudioTrack a;
        private final AudioTimestamp b = new AudioTimestamp();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f8545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f8546d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f8547e;

        public a(AudioTrack audioTrack) {
            this.a = audioTrack;
        }

        public final boolean a() {
            boolean timestamp = this.a.getTimestamp(this.b);
            if (timestamp) {
                long j2 = this.b.framePosition;
                if (this.f8546d > j2) {
                    this.f8545c++;
                }
                this.f8546d = j2;
                this.f8547e = j2 + (this.f8545c << 32);
            }
            return timestamp;
        }

        public final long b() {
            return this.b.nanoTime / 1000;
        }

        public final long c() {
            return this.f8547e;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    private @interface b {
    }

    public i(AudioTrack audioTrack) {
        if (af.a >= 19) {
            this.f8539j = new a(audioTrack);
            e();
        } else {
            this.f8539j = null;
            a(3);
        }
    }

    public final boolean a(long j2) {
        a aVar = this.f8539j;
        if (aVar == null || j2 - this.f8543n < this.f8542m) {
            return false;
        }
        this.f8543n = j2;
        boolean zA = aVar.a();
        int i2 = this.f8540k;
        if (i2 == 0) {
            if (!zA) {
                if (j2 - this.f8541l <= 500000) {
                    return zA;
                }
                a(3);
                return zA;
            }
            if (this.f8539j.b() < this.f8541l) {
                return false;
            }
            this.f8544o = this.f8539j.c();
            a(1);
            return zA;
        }
        if (i2 == 1) {
            if (!zA) {
                e();
                return zA;
            }
            if (this.f8539j.c() <= this.f8544o) {
                return zA;
            }
            a(2);
            return zA;
        }
        if (i2 == 2) {
            if (zA) {
                return zA;
            }
            e();
            return zA;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return zA;
            }
            throw new IllegalStateException();
        }
        if (!zA) {
            return zA;
        }
        e();
        return zA;
    }

    public final void b() {
        if (this.f8540k == 4) {
            e();
        }
    }

    public final boolean c() {
        int i2 = this.f8540k;
        return i2 == 1 || i2 == 2;
    }

    public final boolean d() {
        return this.f8540k == 2;
    }

    public final void e() {
        if (this.f8539j != null) {
            a(0);
        }
    }

    public final long f() {
        a aVar = this.f8539j;
        return aVar != null ? aVar.b() : com.anythink.expressad.exoplayer.b.b;
    }

    public final long g() {
        a aVar = this.f8539j;
        if (aVar != null) {
            return aVar.c();
        }
        return -1L;
    }

    public final void a() {
        a(4);
    }

    private void a(int i2) {
        this.f8540k = i2;
        if (i2 == 0) {
            this.f8543n = 0L;
            this.f8544o = -1L;
            this.f8541l = System.nanoTime() / 1000;
            this.f8542m = 5000L;
            return;
        }
        if (i2 == 1) {
            this.f8542m = 5000L;
            return;
        }
        if (i2 == 2 || i2 == 3) {
            this.f8542m = 10000000L;
        } else {
            if (i2 == 4) {
                this.f8542m = 500000L;
                return;
            }
            throw new IllegalStateException();
        }
    }
}
