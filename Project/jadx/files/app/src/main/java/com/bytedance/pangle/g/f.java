package com.bytedance.pangle.g;

import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class f {
    static final HashMap<String, SparseArray<m>> a = new HashMap<>();

    static class a implements j {
        private final MessageDigest[] a;

        a(MessageDigest[] messageDigestArr) {
            this.a = messageDigestArr;
        }

        @Override // com.bytedance.pangle.g.j
        public final void a(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.a) {
                byteBufferSlice.position(0);
                messageDigest.update(byteBufferSlice);
            }
        }
    }

    @RequiresApi(api = 21)
    static void a(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, m mVar) {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        ArrayMap arrayMap = new ArrayMap();
        boolean z2 = true;
        if (map.containsKey(1)) {
            arrayMap.put(1, map.get(1));
        }
        if (map.containsKey(2)) {
            arrayMap.put(2, map.get(2));
        }
        if (!arrayMap.isEmpty()) {
            try {
                a(arrayMap, randomAccessFile.getFD(), mVar);
                z2 = false;
            } catch (IOException e2) {
                throw new SecurityException("Cannot get FD", e2);
            }
        }
        if (map.containsKey(3)) {
            try {
                if (!Arrays.equals(a(map.get(3), randomAccessFile.length(), mVar), g.a(randomAccessFile, mVar, new i() { // from class: com.bytedance.pangle.g.f.1
                    @Override // com.bytedance.pangle.g.i
                    public final ByteBuffer a(int i2) {
                        return ByteBuffer.allocate(i2);
                    }
                }).b)) {
                    throw new SecurityException("APK verity digest of contents did not verify");
                }
                z2 = false;
            } catch (IOException | DigestException | NoSuchAlgorithmException e3) {
                throw new SecurityException("Error during verification", e3);
            }
        }
        if (z2) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    static String b(int i2) {
        if (i2 == 1) {
            return "SHA-256";
        }
        if (i2 == 2) {
            return "SHA-512";
        }
        if (i2 == 3) {
            return "SHA-256";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i2)));
    }

    static String c(int i2) {
        if (i2 == 513 || i2 == 514) {
            return "EC";
        }
        if (i2 == 769) {
            return "DSA";
        }
        if (i2 == 1057) {
            return "RSA";
        }
        if (i2 == 1059) {
            return "EC";
        }
        if (i2 == 1061) {
            return "DSA";
        }
        switch (i2) {
            case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
            case 258:
            case 259:
            case 260:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    static Pair<String, ? extends AlgorithmParameterSpec> d(int i2) {
        if (i2 != 513) {
            if (i2 == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i2 != 769) {
                if (i2 != 1057) {
                    if (i2 != 1059) {
                        if (i2 != 1061) {
                            switch (i2) {
                                case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case 258:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case 259:
                                    break;
                                case 260:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
                            }
                        }
                    }
                }
                return Pair.create("SHA256withRSA", null);
            }
            return Pair.create("SHA256withDSA", null);
        }
        return Pair.create("SHA256withECDSA", null);
    }

    private static int e(int i2) {
        if (i2 == 1) {
            return 32;
        }
        if (i2 == 2) {
            return 64;
        }
        if (i2 == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i2)));
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i2)));
        }
        int iLimit = byteBuffer.limit();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (i3 < iPosition || i3 > iLimit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i3);
        try {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.order(byteBuffer.order());
            byteBuffer.position(i3);
            return byteBufferSlice;
        } finally {
            byteBuffer.limit(iLimit);
        }
    }

    static byte[] b(ByteBuffer byteBuffer) throws IOException {
        int i2 = byteBuffer.getInt();
        if (i2 >= 0) {
            if (i2 <= byteBuffer.remaining()) {
                byte[] bArr = new byte[i2];
                byteBuffer.get(bArr);
                return bArr;
            }
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i2 + ", available: " + byteBuffer.remaining());
        }
        throw new IOException("Negative length");
    }

    private static void a(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, m mVar) {
        l lVar = new l(fileDescriptor, 0L, mVar.b);
        long j2 = mVar.f14592c;
        l lVar2 = new l(fileDescriptor, j2, mVar.f14593d - j2);
        ByteBuffer byteBufferDuplicate = mVar.f14594e.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        long j3 = mVar.b;
        s.a(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() + 16;
        if (j3 >= 0 && j3 <= 4294967295L) {
            byteBufferDuplicate.putInt(byteBufferDuplicate.position() + iPosition, (int) j3);
            h hVar = new h(byteBufferDuplicate);
            int[] iArr = new int[map.size()];
            Iterator<Integer> it = map.keySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                iArr[i2] = it.next().intValue();
                i2++;
            }
            try {
                byte[][] bArrA = a(iArr, new k[]{lVar, lVar2, hVar});
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    int i4 = iArr[i3];
                    if (!MessageDigest.isEqual(map.get(Integer.valueOf(i4)), bArrA[i3])) {
                        throw new SecurityException(b(i4) + " digest of contents did not verify");
                    }
                }
                return;
            } catch (DigestException e2) {
                throw new SecurityException("Failed to compute digest(s) of contents", e2);
            }
        }
        throw new IllegalArgumentException("uint32 value of out range: ".concat(String.valueOf(j3)));
    }

    private static byte[][] a(int[] iArr, k[] kVarArr) throws DigestException {
        int i2;
        long j2;
        long j3 = 0;
        long jA = 0;
        int i3 = 0;
        while (true) {
            i2 = 3;
            j2 = 1048576;
            if (i3 >= 3) {
                break;
            }
            jA += ((kVarArr[i3].a() + 1048576) - 1) / 1048576;
            i3++;
        }
        if (jA < 2097151) {
            int i4 = (int) jA;
            byte[][] bArr = new byte[iArr.length][];
            for (int i5 = 0; i5 < iArr.length; i5++) {
                byte[] bArr2 = new byte[(e(iArr[i5]) * i4) + 5];
                bArr2[0] = 90;
                a(i4, bArr2);
                bArr[i5] = bArr2;
            }
            byte[] bArr3 = new byte[5];
            bArr3[0] = -91;
            MessageDigest[] messageDigestArr = new MessageDigest[iArr.length];
            for (int i6 = 0; i6 < iArr.length; i6++) {
                String strB = b(iArr[i6]);
                try {
                    messageDigestArr[i6] = MessageDigest.getInstance(strB);
                } catch (NoSuchAlgorithmException e2) {
                    throw new RuntimeException(strB + " digest not supported", e2);
                }
            }
            a aVar = new a(messageDigestArr);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i7 < i2) {
                k kVar = kVarArr[i7];
                long j4 = j3;
                int i10 = i7;
                long jA2 = kVar.a();
                while (jA2 > j3) {
                    int iMin = (int) Math.min(jA2, j2);
                    a(iMin, bArr3);
                    for (MessageDigest messageDigest : messageDigestArr) {
                        messageDigest.update(bArr3);
                    }
                    long j5 = j4;
                    try {
                        kVar.a(aVar, j5, iMin);
                        int i11 = 0;
                        while (i11 < iArr.length) {
                            int i12 = iArr[i11];
                            k kVar2 = kVar;
                            byte[] bArr4 = bArr[i11];
                            int iE = e(i12);
                            byte[] bArr5 = bArr3;
                            MessageDigest messageDigest2 = messageDigestArr[i11];
                            MessageDigest[] messageDigestArr2 = messageDigestArr;
                            int iDigest = messageDigest2.digest(bArr4, (i9 * iE) + 5, iE);
                            if (iDigest != iE) {
                                throw new RuntimeException("Unexpected output size of " + messageDigest2.getAlgorithm() + " digest: " + iDigest);
                            }
                            i11++;
                            kVar = kVar2;
                            bArr3 = bArr5;
                            messageDigestArr = messageDigestArr2;
                        }
                        k kVar3 = kVar;
                        long j6 = iMin;
                        long j7 = j5 + j6;
                        jA2 -= j6;
                        i9++;
                        j3 = 0;
                        j2 = 1048576;
                        kVar = kVar3;
                        bArr3 = bArr3;
                        j4 = j7;
                    } catch (IOException e3) {
                        throw new DigestException("Failed to digest chunk #" + i9 + " of section #" + i8, e3);
                    }
                }
                i8++;
                i7 = i10 + 1;
                j3 = 0;
                i2 = 3;
                j2 = 1048576;
            }
            byte[][] bArr6 = new byte[iArr.length][];
            for (int i13 = 0; i13 < iArr.length; i13++) {
                int i14 = iArr[i13];
                byte[] bArr7 = bArr[i13];
                String strB2 = b(i14);
                try {
                    bArr6[i13] = MessageDigest.getInstance(strB2).digest(bArr7);
                } catch (NoSuchAlgorithmException e4) {
                    throw new RuntimeException(strB2 + " digest not supported", e4);
                }
            }
            return bArr6;
        }
        throw new DigestException("Too many chunks: ".concat(String.valueOf(jA)));
    }

    static byte[] a(byte[] bArr, long j2, m mVar) {
        if (bArr.length == 40) {
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.position(32);
            if (byteBufferOrder.getLong() == j2 - (mVar.f14592c - mVar.b)) {
                return Arrays.copyOfRange(bArr, 0, 32);
            }
            throw new SecurityException("APK content size did not verify");
        }
        throw new SecurityException("Verity digest size is wrong: " + bArr.length);
    }

    static int a(int i2, int i3) {
        int iA = a(i2);
        int iA2 = a(i3);
        if (iA == 1) {
            if (iA2 == 1) {
                return 0;
            }
            if (iA2 == 2 || iA2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(iA2)));
        }
        if (iA == 2) {
            if (iA2 != 1) {
                if (iA2 == 2) {
                    return 0;
                }
                if (iA2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(iA2)));
                }
            }
            return 1;
        }
        if (iA != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(iA)));
        }
        if (iA2 == 1) {
            return 1;
        }
        if (iA2 == 2) {
            return -1;
        }
        if (iA2 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(iA2)));
    }

    static int a(int i2) {
        if (i2 == 513) {
            return 1;
        }
        if (i2 == 514) {
            return 2;
        }
        if (i2 == 769) {
            return 1;
        }
        if (i2 == 1057 || i2 == 1059 || i2 == 1061) {
            return 3;
        }
        switch (i2) {
            case InputDeviceCompat.SOURCE_KEYBOARD /* 257 */:
            case 259:
                return 1;
            case 258:
            case 260:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i2 & (-1)));
        }
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i2) {
        if (i2 >= 8) {
            int iCapacity = byteBuffer.capacity();
            if (i2 <= byteBuffer.capacity()) {
                int iLimit = byteBuffer.limit();
                int iPosition = byteBuffer.position();
                try {
                    byteBuffer.position(0);
                    byteBuffer.limit(i2);
                    byteBuffer.position(8);
                    ByteBuffer byteBufferSlice = byteBuffer.slice();
                    byteBufferSlice.order(byteBuffer.order());
                    return byteBufferSlice;
                } finally {
                    byteBuffer.position(0);
                    byteBuffer.limit(iLimit);
                    byteBuffer.position(iPosition);
                }
            }
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + iCapacity);
        }
        throw new IllegalArgumentException("end < start: " + i2 + " < 8");
    }

    static ByteBuffer a(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() >= 4) {
            int i2 = byteBuffer.getInt();
            if (i2 >= 0) {
                if (i2 <= byteBuffer.remaining()) {
                    return b(byteBuffer, i2);
                }
                throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i2 + ", remaining: " + byteBuffer.remaining());
            }
            throw new IllegalArgumentException("Negative length");
        }
        throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
    }

    private static void a(int i2, byte[] bArr) {
        bArr[1] = (byte) (i2 & 255);
        bArr[2] = (byte) ((i2 >>> 8) & 255);
        bArr[3] = (byte) ((i2 >>> 16) & 255);
        bArr[4] = (byte) ((i2 >>> 24) & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.lang.String r23, java.io.RandomAccessFile r24, int... r25) throws com.bytedance.pangle.g.n, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.g.f.a(java.lang.String, java.io.RandomAccessFile, int[]):void");
    }
}
