package com.getkeepsafe.relinker.f;

import com.getkeepsafe.relinker.f.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Program64Header.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends c.AbstractC0315c {
    public h(f fVar, c.b bVar, long j2) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = bVar.b + (j2 * ((long) bVar.f14844d));
        this.a = fVar.e(byteBufferAllocate, j3);
        this.b = fVar.c(byteBufferAllocate, 8 + j3);
        this.f14847c = fVar.c(byteBufferAllocate, 16 + j3);
        this.f14848d = fVar.c(byteBufferAllocate, j3 + 40);
    }
}
