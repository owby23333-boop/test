package com.anythink.expressad.exoplayer.b;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.v;
import com.umeng.message.proguard.ad;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface h {
    public static final long a = Long.MIN_VALUE;

    public static final class a extends Exception {
        public a(Throwable th) {
            super(th);
        }

        public a(String str) {
            super(str);
        }
    }

    public static final class b extends Exception {
        public final int a;

        public b(int i2, int i3, int i4, int i5) {
            super("AudioTrack init failed: " + i2 + ", Config(" + i3 + ", " + i4 + ", " + i5 + ad.f20406s);
            this.a = i2;
        }
    }

    public interface c {
        void a();

        void a(int i2);

        void a(int i2, long j2, long j3);
    }

    public static final class d extends Exception {
        public final int a;

        public d(int i2) {
            super("AudioTrack write failed: ".concat(String.valueOf(i2)));
            this.a = i2;
        }
    }

    long a(boolean z2);

    v a(v vVar);

    void a();

    void a(float f2);

    void a(int i2, int i3, int i4, @Nullable int[] iArr, int i5, int i6);

    void a(com.anythink.expressad.exoplayer.b.b bVar);

    void a(c cVar);

    boolean a(int i2);

    boolean a(ByteBuffer byteBuffer, long j2);

    void b();

    void b(int i2);

    void c();

    void c(int i2);

    boolean d();

    boolean e();

    v f();

    void g();

    void h();

    void i();

    void j();
}
