package com.bytedance.sdk.component.panglearmor.z.z.g.z;

import com.bytedance.sdk.component.panglearmor.z.z.z.g;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static dl z(com.bytedance.sdk.component.panglearmor.z.g.g gVar, com.bytedance.sdk.component.panglearmor.z.z.dl.g gVar2, int i) throws Exception {
        try {
            g.z zVarZ = com.bytedance.sdk.component.panglearmor.z.z.z.g.z(gVar, gVar2);
            long jZ = zVarZ.z();
            com.bytedance.sdk.component.panglearmor.z.g.g gVarG = zVarZ.g();
            ByteBuffer byteBufferZ = gVarG.z(0L, (int) gVarG.z());
            byteBufferZ.order(ByteOrder.LITTLE_ENDIAN);
            return new dl(z(byteBufferZ, i), jZ, gVar2.z(), gVar2.a(), gVar2.gc());
        } catch (Exception e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    public static ByteBuffer z(ByteBuffer byteBuffer, int i) throws Exception {
        z(byteBuffer);
        ByteBuffer byteBufferZ = z(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (byteBufferZ.hasRemaining()) {
            i2++;
            if (byteBufferZ.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i2)));
            }
            long j = byteBufferZ.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int iPosition = byteBufferZ.position() + i3;
            if (i3 > byteBufferZ.remaining()) {
                throw new Exception("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + byteBufferZ.remaining());
            }
            if (byteBufferZ.getInt() == i) {
                return g(byteBufferZ, i3 - 4);
            }
            byteBufferZ.position(iPosition);
        }
        throw new Exception("No APK Signature Scheme block in APK Signing Block with ID: ".concat(String.valueOf(i)));
    }

    public static void z(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static ByteBuffer z(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int iCapacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            return byteBufferSlice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(iLimit);
            byteBuffer.position(iPosition);
        }
    }

    private static ByteBuffer g(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i)));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i2 = i + iPosition;
        if (i2 < iPosition || i2 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    public static ByteBuffer g(ByteBuffer byteBuffer) throws Exception {
        if (byteBuffer.remaining() < 4) {
            throw new Exception("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new Exception("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
        return g(byteBuffer, i);
    }

    public static byte[] dl(ByteBuffer byteBuffer) throws Exception {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new Exception("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new Exception("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }
}
