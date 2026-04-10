package com.getkeepsafe.relinker.f;

import com.getkeepsafe.relinker.f.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Section64Header.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends c.d {
    public j(f fVar, c.b bVar, int i2) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(bVar.a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        this.a = fVar.e(byteBufferAllocate, bVar.f14843c + ((long) (i2 * bVar.f14846f)) + 44);
    }
}
