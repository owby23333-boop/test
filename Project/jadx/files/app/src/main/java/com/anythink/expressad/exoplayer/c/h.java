package com.anythink.expressad.exoplayer.c;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteBuffer f8751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g<?, h, ?> f8752d;

    private h(g<?, h, ?> gVar) {
        this.f8752d = gVar;
    }

    private ByteBuffer a(long j2, int i2) {
        ((f) this).a = j2;
        ByteBuffer byteBuffer = this.f8751c;
        if (byteBuffer == null || byteBuffer.capacity() < i2) {
            this.f8751c = ByteBuffer.allocateDirect(i2).order(ByteOrder.nativeOrder());
        }
        this.f8751c.position(0);
        this.f8751c.limit(i2);
        return this.f8751c;
    }

    @Override // com.anythink.expressad.exoplayer.c.f
    public final void e() {
        this.f8752d.a(this);
    }

    @Override // com.anythink.expressad.exoplayer.c.a
    public final void a() {
        super.a();
        ByteBuffer byteBuffer = this.f8751c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }
}
