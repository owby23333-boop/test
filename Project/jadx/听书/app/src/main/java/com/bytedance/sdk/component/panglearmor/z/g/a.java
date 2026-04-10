package com.bytedance.sdk.component.panglearmor.z.g;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes2.dex */
public class a implements g {
    private final long dl;
    private final long g;
    private final FileChannel z;

    public a(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.z = fileChannel;
        this.g = j;
        this.dl = j2;
    }

    @Override // com.bytedance.sdk.component.panglearmor.z.g.g
    public long z() {
        long j = this.dl;
        if (j != -1) {
            return j;
        }
        try {
            return this.z.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.panglearmor.z.g.g
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public a z(long j, long j2) {
        long jZ = z();
        z(j, j2, jZ);
        return (j == 0 && j2 == jZ) ? this : new a(this.z, this.g + j, j2);
    }

    public void z(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        z(j, i, z());
        if (i == 0) {
            return;
        }
        if (i > byteBuffer.remaining()) {
            throw new BufferOverflowException();
        }
        long j2 = this.g + j;
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i);
            while (i > 0) {
                synchronized (this.z) {
                    this.z.position(j2);
                    i2 = this.z.read(byteBuffer);
                }
                j2 += (long) i2;
                i -= i2;
            }
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    @Override // com.bytedance.sdk.component.panglearmor.z.g.g
    public ByteBuffer z(long j, int i) throws IOException {
        if (i < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        z(j, i, byteBufferAllocate);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    private static void z(long j, long j2, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        if (j > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + j3 + ")");
        }
        long j4 = j + j2;
        if (j4 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j4 > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + j3 + ")");
        }
    }
}
