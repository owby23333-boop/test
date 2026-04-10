package com.bytedance.pangle.g;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class h implements k {
    private final ByteBuffer a;

    h(ByteBuffer byteBuffer) {
        this.a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.a.capacity();
    }

    @Override // com.bytedance.pangle.g.k
    public final void a(j jVar, long j2, int i2) {
        ByteBuffer byteBufferSlice;
        synchronized (this.a) {
            this.a.position(0);
            int i3 = (int) j2;
            this.a.limit(i2 + i3);
            this.a.position(i3);
            byteBufferSlice = this.a.slice();
        }
        jVar.a(byteBufferSlice);
    }
}
