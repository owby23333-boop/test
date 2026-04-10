package com.getkeepsafe.relinker.f;

import com.getkeepsafe.relinker.f.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Program32Header.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends c.AbstractC0315c {
    public g(f fVar, c.b bVar, long j2) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(bVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = bVar.b + (j2 * ((long) bVar.f14844d));
        this.a = fVar.e(byteBufferAllocate, j3);
        this.b = fVar.e(byteBufferAllocate, 4 + j3);
        this.f14847c = fVar.e(byteBufferAllocate, 8 + j3);
        this.f14848d = fVar.e(byteBufferAllocate, j3 + 20);
    }
}
