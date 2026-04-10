package com.bytedance.pangle.gz;

import android.util.Pair;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
abstract class js {
    static Pair<ByteBuffer, Long> z(RandomAccessFile randomAccessFile) throws IOException {
        if (randomAccessFile.length() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairZ = z(randomAccessFile, 0);
        return pairZ != null ? pairZ : z(randomAccessFile, 65535);
    }

    private static Pair<ByteBuffer, Long> z(RandomAccessFile randomAccessFile, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i, length - 22)) + 22);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        int iDl = dl(byteBufferAllocate);
        if (iDl == -1) {
            return null;
        }
        byteBufferAllocate.position(iDl);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) iDl)));
    }

    private static int dl(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i = iCapacity - 22;
        int iMin = Math.min(i, 65535);
        for (int i2 = 0; i2 <= iMin; i2++) {
            int i3 = i - i2;
            if (byteBuffer.getInt(i3) == 101010256 && z(byteBuffer, i3 + 20) == i2) {
                return i3;
            }
        }
        return -1;
    }

    public static final boolean z(RandomAccessFile randomAccessFile, long j) throws IOException {
        long j2 = j - 20;
        if (j2 < 0) {
            return false;
        }
        randomAccessFile.seek(j2);
        return randomAccessFile.readInt() == 1347094023;
    }

    public static long z(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return g(byteBuffer, byteBuffer.position() + 16);
    }

    public static void z(ByteBuffer byteBuffer, long j) {
        a(byteBuffer);
        z(byteBuffer, byteBuffer.position() + 16, j);
    }

    public static long g(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return g(byteBuffer, byteBuffer.position() + 12);
    }

    private static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int z(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & UShort.MAX_VALUE;
    }

    private static long g(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    private static void z(ByteBuffer byteBuffer, int i, long j) {
        if (j < 0 || j > 4294967295L) {
            throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j)));
        }
        byteBuffer.putInt(byteBuffer.position() + i, (int) j);
    }
}
