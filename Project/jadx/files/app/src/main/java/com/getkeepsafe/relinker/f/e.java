package com.getkeepsafe.relinker.f;

import com.getkeepsafe.relinker.f.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Elf64Header.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends c.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f14850g;

    public e(boolean z2, f fVar) throws IOException {
        this.a = z2;
        this.f14850g = fVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(z2 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        fVar.b(byteBufferAllocate, 16L);
        this.b = fVar.c(byteBufferAllocate, 32L);
        this.f14843c = fVar.c(byteBufferAllocate, 40L);
        this.f14844d = fVar.b(byteBufferAllocate, 54L);
        this.f14845e = fVar.b(byteBufferAllocate, 56L);
        this.f14846f = fVar.b(byteBufferAllocate, 58L);
        fVar.b(byteBufferAllocate, 60L);
        fVar.b(byteBufferAllocate, 62L);
    }

    @Override // com.getkeepsafe.relinker.f.c.b
    public c.d a(int i2) throws IOException {
        return new j(this.f14850g, this, i2);
    }

    @Override // com.getkeepsafe.relinker.f.c.b
    public c.AbstractC0315c a(long j2) throws IOException {
        return new h(this.f14850g, this, j2);
    }

    @Override // com.getkeepsafe.relinker.f.c.b
    public c.a a(long j2, int i2) throws IOException {
        return new b(this.f14850g, this, j2, i2);
    }
}
