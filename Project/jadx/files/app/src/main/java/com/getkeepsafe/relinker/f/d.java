package com.getkeepsafe.relinker.f;

import com.getkeepsafe.relinker.f.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: Elf32Header.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends c.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f14849g;

    public d(boolean z2, f fVar) throws IOException {
        this.a = z2;
        this.f14849g = fVar;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.order(z2 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        fVar.b(byteBufferAllocate, 16L);
        this.b = fVar.e(byteBufferAllocate, 28L);
        this.f14843c = fVar.e(byteBufferAllocate, 32L);
        this.f14844d = fVar.b(byteBufferAllocate, 42L);
        this.f14845e = fVar.b(byteBufferAllocate, 44L);
        this.f14846f = fVar.b(byteBufferAllocate, 46L);
        fVar.b(byteBufferAllocate, 48L);
        fVar.b(byteBufferAllocate, 50L);
    }

    @Override // com.getkeepsafe.relinker.f.c.b
    public c.d a(int i2) throws IOException {
        return new i(this.f14849g, this, i2);
    }

    @Override // com.getkeepsafe.relinker.f.c.b
    public c.AbstractC0315c a(long j2) throws IOException {
        return new g(this.f14849g, this, j2);
    }

    @Override // com.getkeepsafe.relinker.f.c.b
    public c.a a(long j2, int i2) throws IOException {
        return new a(this.f14849g, this, j2, i2);
    }
}
