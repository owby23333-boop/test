package com.bytedance.pangle.util.z;

import android.util.Pair;
import com.bytedance.pangle.util.m;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static String z = "";

    public static String[] z(File file) {
        String str;
        String strZ = "";
        try {
            ByteBuffer byteBufferG = g(file);
            if (z(byteBufferG)) {
                strZ = m.z(byteBufferG.array());
                str = "";
            } else {
                str = "without v2 & v3 signature.";
            }
        } catch (Exception unused) {
            str = strZ;
        }
        return new String[]{strZ, z, str};
    }

    private static ByteBuffer g(File file) throws Exception {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th) {
            th = th;
        }
        try {
            Pair<ByteBuffer, Long> pairZ = z(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) pairZ.first;
            long jLongValue = ((Long) pairZ.second).longValue();
            if (dl.z(randomAccessFile, jLongValue)) {
                throw new Exception("ZIP64 APK not supported");
            }
            ByteBuffer byteBuffer2 = (ByteBuffer) z(randomAccessFile, z(byteBuffer, jLongValue)).first;
            randomAccessFile.close();
            return byteBuffer2;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    private static Pair<ByteBuffer, Long> z(RandomAccessFile randomAccessFile) throws Exception {
        Pair<ByteBuffer, Long> pairZ = dl.z(randomAccessFile);
        if (pairZ != null) {
            return pairZ;
        }
        throw new Exception("Not an APK file: ZIP End of Central Directory record not found");
    }

    private static long z(ByteBuffer byteBuffer, long j) throws Exception {
        long jZ = dl.z(byteBuffer);
        if (jZ > j) {
            throw new Exception("ZIP Central Directory offset out of range: " + jZ + ". ZIP End of Central Directory offset: " + j);
        }
        if (dl.g(byteBuffer) + jZ == j) {
            return jZ;
        }
        throw new Exception("ZIP Central Directory is not immediately followed by End of Central Directory");
    }

    static Pair<ByteBuffer, Long> z(RandomAccessFile randomAccessFile, long j) throws Exception {
        if (j < 32) {
            throw new Exception("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - ((long) byteBufferAllocate.capacity()));
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
            throw new Exception("No APK Signing Block before ZIP Central Directory");
        }
        long j2 = byteBufferAllocate.getLong(0);
        if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
            throw new Exception("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
        }
        int i = (int) (8 + j2);
        long j3 = j - ((long) i);
        if (j3 < 0) {
            throw new Exception("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 != j2) {
            throw new Exception("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
    }

    private static boolean z(ByteBuffer byteBuffer) throws Exception {
        g(byteBuffer);
        ByteBuffer byteBufferZ = z(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (byteBufferZ.hasRemaining()) {
            i++;
            if (byteBufferZ.remaining() < 8) {
                throw new Exception("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
            }
            long j = byteBufferZ.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + j);
            }
            int i2 = (int) j;
            int iPosition = byteBufferZ.position() + i2;
            if (i2 > byteBufferZ.remaining()) {
                throw new Exception("APK Signing Block entry #" + i + " size out of range: " + i2 + ", available: " + byteBufferZ.remaining());
            }
            int i3 = byteBufferZ.getInt();
            if (i3 == -262969152) {
                z = "V3";
                return true;
            }
            if (i3 == 1896449818) {
                z = "V2";
                return true;
            }
            byteBufferZ.position(iPosition);
        }
        return false;
    }

    private static void g(ByteBuffer byteBuffer) {
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
}
