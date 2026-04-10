package com.anythink.expressad.exoplayer.c;

import com.umeng.message.proguard.ad;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.anythink.expressad.exoplayer.c.a {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8735c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f8736d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteBuffer f8737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f8738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f8739g;

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public e(int i2) {
        this.f8739g = i2;
    }

    public static e e() {
        return new e(0);
    }

    @Override // com.anythink.expressad.exoplayer.c.a
    public final void a() {
        super.a();
        ByteBuffer byteBuffer = this.f8737e;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final void d(int i2) {
        ByteBuffer byteBuffer = this.f8737e;
        if (byteBuffer == null) {
            this.f8737e = e(i2);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = this.f8737e.position();
        int i3 = i2 + iPosition;
        if (iCapacity >= i3) {
            return;
        }
        ByteBuffer byteBufferE = e(i3);
        if (iPosition > 0) {
            this.f8737e.position(0);
            this.f8737e.limit(iPosition);
            byteBufferE.put(this.f8737e);
        }
        this.f8737e = byteBufferE;
    }

    public final boolean f() {
        return this.f8737e == null && this.f8739g == 0;
    }

    public final boolean g() {
        return c(1073741824);
    }

    public final void h() {
        this.f8737e.flip();
    }

    private ByteBuffer e(int i2) {
        int i3 = this.f8739g;
        if (i3 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f8737e;
        throw new IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i2 + ad.f20406s);
    }
}
