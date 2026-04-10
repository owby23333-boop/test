package com.bytedance.pangle.g;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
abstract class g {
    private static final byte[] a = new byte[8];

    static class a {
        public final ByteBuffer a;
        public final byte[] b;

        a(ByteBuffer byteBuffer, byte[] bArr) {
            this.a = byteBuffer;
            this.b = bArr;
        }
    }

    static class b implements j {
        private int a;
        private final ByteBuffer b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MessageDigest f14587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final byte[] f14588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f14589e;

        /* synthetic */ b(byte[] bArr, ByteBuffer byteBuffer, byte b) {
            this(bArr, byteBuffer);
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(ByteBuffer byteBuffer) throws DigestException {
            byteBuffer.position();
            int iRemaining = byteBuffer.remaining();
            while (iRemaining > 0) {
                int iMin = Math.min(iRemaining, 4096 - this.a);
                byteBuffer.limit(byteBuffer.position() + iMin);
                this.f14587c.update(byteBuffer);
                iRemaining -= iMin;
                this.a += iMin;
                if (this.a == 4096) {
                    MessageDigest messageDigest = this.f14587c;
                    byte[] bArr = this.f14588d;
                    messageDigest.digest(bArr, 0, bArr.length);
                    this.b.put(this.f14588d);
                    this.f14587c.update(this.f14589e);
                    this.a = 0;
                }
            }
        }

        final void b() {
            int iPosition = this.b.position() % 4096;
            if (iPosition == 0) {
                return;
            }
            this.b.put(ByteBuffer.allocate(4096 - iPosition));
        }

        private b(byte[] bArr, ByteBuffer byteBuffer) {
            this.f14588d = new byte[32];
            this.f14589e = bArr;
            this.b = byteBuffer.slice();
            this.f14587c = MessageDigest.getInstance("SHA-256");
            this.f14587c.update(this.f14589e);
            this.a = 0;
        }

        public final void a() {
            if (this.a == 0) {
                return;
            }
            throw new IllegalStateException("Buffer is not empty: " + this.a);
        }
    }

    static a a(RandomAccessFile randomAccessFile, m mVar, i iVar) throws DigestException, IOException {
        int[] iArrA = a(randomAccessFile.length() - (mVar.f14592c - mVar.b));
        int i2 = iArrA[iArrA.length - 1];
        int i3 = i2 + 4096;
        ByteBuffer byteBufferA = iVar.a(i3);
        byteBufferA.order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer byteBufferA2 = a(byteBufferA, 0, i2);
        int i4 = i2 + 64;
        ByteBuffer byteBufferA3 = a(byteBufferA, i2, i4);
        ByteBuffer byteBufferA4 = a(byteBufferA, i4, i3);
        byte[] bArr = new byte[32];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        long j2 = mVar.b;
        if (j2 % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
            throw new IllegalArgumentException("APK Signing Block does not start at the page  boundary: " + mVar.b);
        }
        long j3 = mVar.f14592c;
        if ((j3 - j2) % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM != 0) {
            throw new IllegalArgumentException("Size of APK Signing Block is not a multiple of 4096: " + (mVar.f14592c - mVar.b));
        }
        long j4 = j3 - j2;
        int[] iArrA2 = a(randomAccessFile.length() - j4);
        if (byteBufferA2 != null) {
            byte[] bArrA = a(randomAccessFile, mVar, a, iArrA2, byteBufferA2);
            if (byteBufferWrap != null) {
                byteBufferWrap.put(bArrA);
                byteBufferWrap.flip();
            }
        }
        if (byteBufferA3 != null) {
            byteBufferA3.order(ByteOrder.LITTLE_ENDIAN);
            long length = randomAccessFile.length();
            byte[] bArr2 = a;
            if (bArr2.length != 8) {
                throw new IllegalArgumentException("salt is not 8 bytes long");
            }
            byteBufferA3.put("TrueBrew".getBytes());
            byteBufferA3.put((byte) 1);
            byteBufferA3.put((byte) 0);
            byteBufferA3.put((byte) 12);
            byteBufferA3.put((byte) 7);
            byteBufferA3.putShort((short) 1);
            byteBufferA3.putShort((short) 1);
            byteBufferA3.putInt(0);
            byteBufferA3.putInt(0);
            byteBufferA3.putLong(length);
            byteBufferA3.put((byte) 2);
            byteBufferA3.put((byte) 0);
            byteBufferA3.put(bArr2);
            a(byteBufferA3, 22);
            byteBufferA3.flip();
        }
        if (byteBufferA4 != null) {
            byteBufferA4.order(ByteOrder.LITTLE_ENDIAN);
            long j5 = mVar.b;
            long j6 = mVar.f14593d;
            byteBufferA4.putInt(24);
            byteBufferA4.putShort((short) 1);
            a(byteBufferA4, 2);
            byteBufferA4.putLong(j5);
            byteBufferA4.putLong(j4);
            byteBufferA4.putInt(20);
            byteBufferA4.putShort((short) 2);
            a(byteBufferA4, 2);
            byteBufferA4.putLong(j6 + 16);
            byteBufferA4.putInt(c(j5));
            a(byteBufferA4, 4);
            byteBufferA4.flip();
        }
        byteBufferA.position(i4 + byteBufferA4.limit());
        byteBufferA.putInt(byteBufferA4.limit() + 64 + 4);
        byteBufferA.flip();
        return new a(byteBufferA, bArr);
    }

    private static long b(long j2) {
        return ((j2 + PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) - 1) / PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
    }

    private static int c(long j2) {
        int i2 = (int) j2;
        if (i2 == j2) {
            return i2;
        }
        throw new ArithmeticException("integer overflow");
    }

    private static void a(j jVar, k kVar, int i2) {
        long jA = kVar.a();
        long j2 = 0;
        while (jA > 0) {
            int iMin = (int) Math.min(jA, i2);
            kVar.a(jVar, j2, iMin);
            long j3 = iMin;
            j2 += j3;
            jA -= j3;
        }
    }

    private static byte[] a(RandomAccessFile randomAccessFile, m mVar, byte[] bArr, int[] iArr, ByteBuffer byteBuffer) throws DigestException, IOException {
        byte b2 = 0;
        b bVar = new b(bArr, a(byteBuffer, iArr[iArr.length - 2], iArr[iArr.length - 1]), b2);
        a(bVar, new l(randomAccessFile.getFD(), 0L, mVar.b), 1048576);
        long j2 = mVar.f14593d + 16;
        FileDescriptor fd = randomAccessFile.getFD();
        long j3 = mVar.f14592c;
        a(bVar, new l(fd, j3, j2 - j3), 1048576);
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(c(mVar.b));
        byteBufferOrder.flip();
        bVar.a(byteBufferOrder);
        long j4 = j2 + 4;
        a(bVar, new l(randomAccessFile.getFD(), j4, randomAccessFile.length() - j4), 1048576);
        int length = (int) (randomAccessFile.length() % PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        if (length != 0) {
            bVar.a(ByteBuffer.allocate(4096 - length));
        }
        bVar.a();
        bVar.b();
        for (int length2 = iArr.length - 3; length2 >= 0; length2--) {
            int i2 = length2 + 1;
            ByteBuffer byteBufferA = a(byteBuffer, iArr[i2], iArr[length2 + 2]);
            ByteBuffer byteBufferA2 = a(byteBuffer, iArr[length2], iArr[i2]);
            h hVar = new h(byteBufferA);
            b bVar2 = new b(bArr, byteBufferA2, b2);
            a(bVar2, hVar, 4096);
            bVar2.a();
            bVar2.b();
        }
        byte[] bArr2 = new byte[32];
        b bVar3 = new b(bArr, ByteBuffer.wrap(bArr2), b2);
        bVar3.a(a(byteBuffer, 0, 4096));
        bVar3.a();
        return bArr2;
    }

    private static int[] a(long j2) {
        ArrayList arrayList = new ArrayList();
        do {
            j2 = b(j2) * 32;
            arrayList.add(Long.valueOf(b(j2) * PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM));
        } while (j2 > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        int[] iArr = new int[arrayList.size() + 1];
        int i2 = 0;
        iArr[0] = 0;
        while (i2 < arrayList.size()) {
            int i3 = i2 + 1;
            iArr[i3] = iArr[i2] + c(((Long) arrayList.get((arrayList.size() - i2) - 1)).longValue());
            i2 = i3;
        }
        return iArr;
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2, int i3) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(0);
        byteBufferDuplicate.limit(i3);
        byteBufferDuplicate.position(i2);
        return byteBufferDuplicate.slice();
    }

    private static void a(ByteBuffer byteBuffer, int i2) {
        byteBuffer.position(byteBuffer.position() + i2);
    }
}
