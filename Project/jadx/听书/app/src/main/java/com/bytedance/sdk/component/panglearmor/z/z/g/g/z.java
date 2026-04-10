package com.bytedance.sdk.component.panglearmor.z.z.g.g;

import android.util.Pair;
import com.bytedance.sdk.component.panglearmor.z.g.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    public static long z(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return g(byteBuffer, byteBuffer.position() + 16);
    }

    public static long g(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return g(byteBuffer, byteBuffer.position() + 12);
    }

    public static int dl(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return z(byteBuffer, byteBuffer.position() + 10);
    }

    public static Pair<ByteBuffer, Long> z(g gVar) throws IOException {
        if (gVar.z() < 22) {
            return null;
        }
        Pair<ByteBuffer, Long> pairZ = z(gVar, 0);
        return pairZ != null ? pairZ : z(gVar, 65535);
    }

    private static Pair<ByteBuffer, Long> z(g gVar, int i) throws IOException {
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i)));
        }
        long jZ = gVar.z();
        if (jZ < 22) {
            return null;
        }
        int iMin = ((int) Math.min(i, jZ - 22)) + 22;
        long j = jZ - ((long) iMin);
        ByteBuffer byteBufferZ = gVar.z(j, iMin);
        byteBufferZ.order(ByteOrder.LITTLE_ENDIAN);
        int iGc = gc(byteBufferZ);
        if (iGc == -1) {
            return null;
        }
        byteBufferZ.position(iGc);
        ByteBuffer byteBufferSlice = byteBufferZ.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return new Pair<>(byteBufferSlice, Long.valueOf(j + ((long) iGc)));
    }

    private static int gc(ByteBuffer byteBuffer) {
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

    static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static int z(ByteBuffer byteBuffer, int i) {
        return byteBuffer.getShort(i) & UShort.MAX_VALUE;
    }

    static long g(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }
}
