package com.getkeepsafe.relinker.f;

import com.getkeepsafe.relinker.f.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Dynamic64Structure.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends c.a {
    public b(f fVar, c.b bVar, long j2, int i2) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j3 = j2 + ((long) (i2 * 16));
        this.a = fVar.c(byteBufferAllocate, j3);
        this.b = fVar.c(byteBufferAllocate, j3 + 8);
    }
}
