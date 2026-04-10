package com.bytedance.pangle.util.a;

import android.util.Pair;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i2) throws IOException {
        if (i2 < 0 || i2 > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i2)));
        }
        long length = randomAccessFile.length();
        if (length < 22) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(((int) Math.min(i2, length - 22)) + 22);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long jCapacity = length - ((long) byteBufferAllocate.capacity());
        randomAccessFile.seek(jCapacity);
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        int iB = b(byteBufferAllocate);
        if (iB == -1) {
            return null;
        }
        byteBufferAllocate.position(iB);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) iB)));
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int iCapacity = byteBuffer.capacity();
        if (iCapacity < 22) {
            return -1;
        }
        int i2 = iCapacity - 22;
        int iMin = Math.min(i2, 65535);
        for (int i3 = 0; i3 <= iMin; i3++) {
            int i4 = i2 - i3;
            if (byteBuffer.getInt(i4) == 101010256 && (byteBuffer.getShort(i4 + 20) & ISelectionInterface.HELD_NOTHING) == i3) {
                return i4;
            }
        }
        return -1;
    }

    static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    static long a(ByteBuffer byteBuffer, int i2) {
        return ((long) byteBuffer.getInt(i2)) & 4294967295L;
    }

    public static void a(ZipFile zipFile) {
        if (zipFile == null) {
            return;
        }
        try {
            zipFile.close();
        } catch (Throwable unused) {
        }
    }
}
