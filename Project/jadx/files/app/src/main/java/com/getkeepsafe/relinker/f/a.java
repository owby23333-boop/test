package com.getkeepsafe.relinker.f;

import com.getkeepsafe.relinker.f.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Dynamic32Structure.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends c.a {
    public a(f fVar, c.b bVar, long j2, int i2) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(bVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = j2 + ((long) (i2 * 8));
        this.a = fVar.e(byteBufferAllocate, j3);
        this.b = fVar.e(byteBufferAllocate, j3 + 4);
    }
}
