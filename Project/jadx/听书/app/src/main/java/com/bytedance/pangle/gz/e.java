package com.bytedance.pangle.gz;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
abstract class e {
    private static final byte[] z = new byte[8];

    static class z {
        public final byte[] g;
        public final ByteBuffer z;

        z(ByteBuffer byteBuffer, byte[] bArr) {
            this.z = byteBuffer;
            this.g = bArr;
        }
    }

    static z z(RandomAccessFile randomAccessFile, i iVar, fo foVar) throws NoSuchAlgorithmException, DigestException, IOException, SecurityException {
        int i = g(randomAccessFile.length() - (iVar.dl - iVar.g))[r0.length - 1];
        int i2 = i + 4096;
        ByteBuffer byteBufferZ = foVar.z(i2);
        byteBufferZ.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer byteBufferZ2 = z(byteBufferZ, 0, i);
        int i3 = i + 64;
        ByteBuffer byteBufferZ3 = z(byteBufferZ, i, i3);
        ByteBuffer byteBufferZ4 = z(byteBufferZ, i3, i2);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        z(randomAccessFile, iVar, byteBufferZ2, byteBufferWrap, byteBufferZ3, byteBufferZ4);
        byteBufferZ.position(i3 + byteBufferZ4.limit());
        byteBufferZ.putInt(byteBufferZ4.limit() + 64 + 4);
        byteBufferZ.flip();
        return new z(byteBufferZ, bArr);
    }

    private static void z(RandomAccessFile randomAccessFile, i iVar, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) throws NoSuchAlgorithmException, DigestException, IOException {
        z(iVar);
        long j = iVar.dl - iVar.g;
        int[] iArrG = g(randomAccessFile.length() - j);
        if (byteBuffer != null) {
            byte[] bArrZ = z(randomAccessFile, iVar, z, iArrG, byteBuffer);
            if (byteBuffer2 != null) {
                byteBuffer2.put(bArrZ);
                byteBuffer2.flip();
            }
        }
        if (byteBuffer3 != null) {
            byteBuffer3.order(ByteOrder.LITTLE_ENDIAN);
            z(byteBuffer3, randomAccessFile.length(), iArrG.length - 1, z);
        }
        if (byteBuffer4 != null) {
            byteBuffer4.order(ByteOrder.LITTLE_ENDIAN);
            z(byteBuffer4, iVar.g, j, iVar.f514a);
        }
    }

    private static class g implements uy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f513a;
        private final MessageDigest dl;
        private final ByteBuffer g;
        private final byte[] gc;
        private int z;

        private g(byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException {
            this.f513a = new byte[32];
            this.gc = bArr;
            this.g = byteBuffer.slice();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            this.dl = messageDigest;
            messageDigest.update(bArr);
            this.z = 0;
        }

        @Override // com.bytedance.pangle.gz.uy
        public void z(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.z);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.dl.update(byteBuffer);
                iRemaining -= iMin;
                int i = this.z + iMin;
                this.z = i;
                if (i == 4096) {
                    MessageDigest messageDigest = this.dl;
                    byte[] bArr = this.f513a;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.g.put(this.f513a);
                    this.dl.update(this.gc);
                    this.z = 0;
                }
            }
        }

        public void z() throws DigestException {
            if (this.z != 0) {
                throw new IllegalStateException("Buffer is not empty: " + this.z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            int iPosition = this.g.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.g.put(ByteBuffer.allocate(4096 - iPosition));
        }
    }

    private static void z(uy uyVar, kb kbVar, int i) throws DigestException, IOException {
        long jZ = kbVar.z();
        long j = 0;
        while (jZ > 0) {
            int iMin = (int) Math.min(jZ, i);
            kbVar.z(uyVar, j, iMin);
            long j2 = iMin;
            j += j2;
            jZ -= j2;
        }
    }

    private static void z(RandomAccessFile randomAccessFile, i iVar, byte[] bArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        g gVar = new g(bArr, byteBuffer);
        z(gVar, new wp(randomAccessFile.getFD(), 0L, iVar.g), 1048576);
        long j = iVar.f514a + 16;
        z(gVar, new wp(randomAccessFile.getFD(), iVar.dl, j - iVar.dl), 1048576);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(z(iVar.g));
        byteBufferOrder.flip();
        gVar.z(byteBufferOrder);
        long j2 = j + 4;
        z(gVar, new wp(randomAccessFile.getFD(), j2, randomAccessFile.length() - j2), 1048576);
        int length = (int) (randomAccessFile.length() % 4096);
        if (length != 0) {
            gVar.z(ByteBuffer.allocate(4096 - length));
        }
        gVar.z();
        gVar.g();
    }

    private static byte[] z(RandomAccessFile randomAccessFile, i iVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws NoSuchAlgorithmException, DigestException, IOException {
        z(randomAccessFile, iVar, bArr, z(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]));
        int length = iArr.length - 3;
        while (true) {
            if (length >= 0) {
                int i = length + 1;
                ByteBuffer byteBufferZ = z(byteBuffer, iArr[i], iArr[length + 2]);
                ByteBuffer byteBufferZ2 = z(byteBuffer, iArr[length], iArr[i]);
                gz gzVar = new gz(byteBufferZ);
                g gVar = new g(bArr, byteBufferZ2);
                z(gVar, gzVar, 4096);
                gVar.z();
                gVar.g();
                length--;
            } else {
                byte[] bArr2 = new byte[32];
                g gVar2 = new g(bArr, ByteBuffer.wrap(bArr2));
                gVar2.z(z(byteBuffer, 0, 4096));
                gVar2.z();
                return bArr2;
            }
        }
    }

    private static ByteBuffer z(ByteBuffer byteBuffer, long j, int i, byte[] bArr) {
        if (bArr.length != 8) {
            throw new IllegalArgumentException("salt is not 8 bytes long");
        }
        byteBuffer.put("TrueBrew".getBytes());
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) 0);
        byteBuffer.put((byte) 12);
        byteBuffer.put((byte) 7);
        byteBuffer.putShort((short) 1);
        byteBuffer.putShort((short) 1);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putLong(j);
        byteBuffer.put((byte) 2);
        byteBuffer.put((byte) 0);
        byteBuffer.put(bArr);
        z(byteBuffer, 22);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static ByteBuffer z(ByteBuffer byteBuffer, long j, long j2, long j3) {
        byteBuffer.putInt(24);
        byteBuffer.putShort((short) 1);
        z(byteBuffer, 2);
        byteBuffer.putLong(j);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(20);
        byteBuffer.putShort((short) 2);
        z(byteBuffer, 2);
        byteBuffer.putLong(j3 + 16);
        byteBuffer.putInt(z(j));
        z(byteBuffer, 4);
        byteBuffer.flip();
        return byteBuffer;
    }

    private static int[] g(long j) {
        ArrayList arrayList = new ArrayList();
        do {
            j = z(j, 4096L) * 32;
            arrayList.add(Long.valueOf(z(j, 4096L) * 4096));
        } while (j > 4096);
        int[] iArr = new int[arrayList.size() + 1];
        int i = 0;
        iArr[0] = 0;
        while (i < arrayList.size()) {
            int i2 = i + 1;
            iArr[i2] = iArr[i] + z(((Long) arrayList.get((arrayList.size() - i) - 1)).longValue());
            i = i2;
        }
        return iArr;
    }

    private static void z(i iVar) {
        if (iVar.g % 4096 != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + iVar.g);
        }
        if ((iVar.dl - iVar.g) % 4096 != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (iVar.dl - iVar.g));
        }
    }

    private static ByteBuffer z(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i2);
        byteBufferDuplicate.position(i);
        return byteBufferDuplicate.slice();
    }

    private static void z(ByteBuffer byteBuffer, int i) {
        byteBuffer.position(byteBuffer.position() + i);
    }

    private static long z(long j, long j2) {
        return ((j + j2) - 1) / j2;
    }

    public static int z(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("integer overflow");
    }
}
