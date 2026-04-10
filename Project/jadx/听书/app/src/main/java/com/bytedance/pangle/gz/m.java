package com.bytedance.pangle.gz;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.ArrayMap;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class m {
    static final HashMap<String, SparseArray<i>> z = new HashMap<>();

    static void z(Map<Integer, byte[]> map, RandomAccessFile randomAccessFile, i iVar) throws SecurityException {
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
        boolean z3 = false;
        if (!arrayMap.isEmpty()) {
            try {
                z(arrayMap, randomAccessFile.getFD(), iVar);
                z2 = false;
            } catch (IOException e) {
                throw new SecurityException("Cannot get FD", e);
            }
        }
        if (map.containsKey(3)) {
            z(map.get(3), randomAccessFile, iVar);
        } else {
            z3 = z2;
        }
        if (z3) {
            throw new SecurityException("No known digest exists for integrity check");
        }
    }

    private static void z(Map<Integer, byte[]> map, FileDescriptor fileDescriptor, i iVar) throws SecurityException {
        wp wpVar = new wp(fileDescriptor, 0L, iVar.g);
        wp wpVar2 = new wp(fileDescriptor, iVar.dl, iVar.f514a - iVar.dl);
        ByteBuffer byteBufferDuplicate = iVar.gc.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        js.z(byteBufferDuplicate, iVar.g);
        gz gzVar = new gz(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] bArrZ = z(iArr, new kb[]{wpVar, wpVar2, gzVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), bArrZ[i2])) {
                    throw new SecurityException(g(i3) + " digest of contents did not verify");
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    private static byte[][] z(int[] iArr, kb[] kbVarArr) throws DigestException {
        String str;
        kb[] kbVarArr2 = kbVarArr;
        long j = 0;
        long jZ = 0;
        for (kb kbVar : kbVarArr2) {
            jZ += z(kbVar.z());
        }
        if (jZ >= 2097151) {
            throw new DigestException("Too many chunks: ".concat(String.valueOf(jZ)));
        }
        int i = (int) jZ;
        byte[][] bArr = new byte[iArr.length][];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bArr2 = new byte[(gc(iArr[i2]) * i) + 5];
            bArr2[0] = 90;
            z(i, bArr2, 1);
            bArr[i2] = bArr2;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int length = iArr.length;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        int i3 = 0;
        while (true) {
            str = " digest not supported";
            if (i3 >= iArr.length) {
                break;
            }
            String strG = g(iArr[i3]);
            try {
                messageDigestArr[i3] = MessageDigest.getInstance(strG);
                i3++;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(strG + " digest not supported", e);
            }
        }
        z zVar = new z(messageDigestArr);
        int length2 = kbVarArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length2) {
            kb kbVar2 = kbVarArr2[i4];
            int i7 = length2;
            int i8 = i6;
            z zVar2 = zVar;
            String str2 = str;
            long jZ2 = kbVar2.z();
            long j2 = j;
            while (jZ2 > j) {
                int iMin = (int) Math.min(jZ2, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                z(iMin, bArr3, 1);
                for (int i9 = 0; i9 < length; i9++) {
                    messageDigestArr[i9].update(bArr3);
                }
                z zVar3 = zVar2;
                try {
                    kbVar2.z(zVar3, j2, iMin);
                    zVar2 = zVar3;
                    int i10 = 0;
                    while (i10 < iArr.length) {
                        int i11 = iArr[i10];
                        byte[] bArr4 = bArr3;
                        byte[] bArr5 = bArr[i10];
                        int iGc = gc(i11);
                        kb kbVar3 = kbVar2;
                        MessageDigest messageDigest = messageDigestArr[i10];
                        int i12 = length;
                        int iDigest = messageDigest.digest(bArr5, (i8 * iGc) + 5, iGc);
                        if (iDigest != iGc) {
                            throw new RuntimeException("Unexpected output size of " + messageDigest.getAlgorithm() + " digest: " + iDigest);
                        }
                        i10++;
                        bArr3 = bArr4;
                        kbVar2 = kbVar3;
                        length = i12;
                    }
                    long j3 = iMin;
                    j2 += j3;
                    jZ2 -= j3;
                    i8++;
                    bArr3 = bArr3;
                    j = 0;
                } catch (IOException e2) {
                    throw new DigestException("Failed to digest chunk #" + i8 + " of section #" + i5, e2);
                }
            }
            i5++;
            i4++;
            kbVarArr2 = kbVarArr;
            i6 = i8;
            zVar = zVar2;
            str = str2;
            length2 = i7;
            j = 0;
        }
        String str3 = str;
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String strG2 = g(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(strG2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(strG2 + str3, e3);
            }
        }
        return bArr6;
    }

    static byte[] z(byte[] bArr, long j, i iVar) throws SecurityException {
        if (bArr.length != 40) {
            throw new SecurityException("Verity digest size is wrong: " + bArr.length);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.position(32);
        if (byteBufferOrder.getLong() != j - (iVar.dl - iVar.g)) {
            throw new SecurityException("APK content size did not verify");
        }
        return Arrays.copyOfRange(bArr, 0, 32);
    }

    private static void z(byte[] bArr, RandomAccessFile randomAccessFile, i iVar) throws SecurityException {
        try {
            if (Arrays.equals(z(bArr, randomAccessFile.length(), iVar), e.z(randomAccessFile, iVar, new fo() { // from class: com.bytedance.pangle.gz.m.1
                @Override // com.bytedance.pangle.gz.fo
                public ByteBuffer z(int i) {
                    return ByteBuffer.allocate(i);
                }
            }).g)) {
            } else {
                throw new SecurityException("APK verity digest of contents did not verify");
            }
        } catch (IOException | DigestException | NoSuchAlgorithmException e) {
            throw new SecurityException("Error during verification", e);
        }
    }

    static Pair<ByteBuffer, Long> z(RandomAccessFile randomAccessFile) throws v, IOException {
        Pair<ByteBuffer, Long> pairZ = js.z(randomAccessFile);
        if (pairZ != null) {
            return pairZ;
        }
        throw new v("Not an APK file: ZIP End of Central Directory record not found");
    }

    static long z(ByteBuffer byteBuffer, long j) throws v {
        long jZ = js.z(byteBuffer);
        if (jZ > j) {
            throw new v("ZIP Central Directory offset out of range: " + jZ + ". ZIP End of Central Directory offset: " + j);
        }
        if (js.g(byteBuffer) + jZ == j) {
            return jZ;
        }
        throw new v("ZIP Central Directory is not immediately followed by End of Central Directory");
    }

    private static long z(long j) {
        return ((j + PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) - 1) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    static int z(int i, int i2) {
        return g(z(i), z(i2));
    }

    private static int g(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2 || i2 == 3) {
                return -1;
            }
            throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
        }
        if (i == 2) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return 0;
                }
                if (i2 != 3) {
                    throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
                }
            }
            return 1;
        }
        if (i != 3) {
            throw new IllegalArgumentException("Unknown digestAlgorithm1: ".concat(String.valueOf(i)));
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return -1;
        }
        if (i2 == 3) {
            return 0;
        }
        throw new IllegalArgumentException("Unknown digestAlgorithm2: ".concat(String.valueOf(i2)));
    }

    static int z(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        if (i == 1057 || i == 1059 || i == 1061) {
            return 3;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                return 1;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    static String g(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        if (i == 3) {
            return "SHA-256";
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    private static int gc(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        if (i == 3) {
            return 32;
        }
        throw new IllegalArgumentException("Unknown content digest algorthm: ".concat(String.valueOf(i)));
    }

    static String dl(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i == 769) {
            return "DSA";
        }
        if (i == 1057) {
            return "RSA";
        }
        if (i == 1059) {
            return "EC";
        }
        if (i == 1061) {
            return "DSA";
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return "RSA";
            default:
                throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
        }
    }

    static Pair<String, ? extends AlgorithmParameterSpec> a(int i) {
        if (i != 513) {
            if (i == 514) {
                return Pair.create("SHA512withECDSA", null);
            }
            if (i != 769) {
                if (i != 1057) {
                    if (i != 1059) {
                        if (i != 1061) {
                            switch (i) {
                                case 257:
                                    return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                    return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
                                case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                                    break;
                                case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                                    return Pair.create("SHA512withRSA", null);
                                default:
                                    throw new IllegalArgumentException("Unknown signature algorithm: 0x" + Long.toHexString(i & (-1)));
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

    static ByteBuffer z(ByteBuffer byteBuffer, int i, int i2) {
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

    static ByteBuffer z(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
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

    static ByteBuffer z(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            throw new IOException("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new IOException("Length-prefixed field longer than remaining buffer. Field length: " + i + ", remaining: " + byteBuffer.remaining());
        }
        return z(byteBuffer, i);
    }

    static byte[] g(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i > byteBuffer.remaining()) {
            throw new IOException("Underflow while reading length-prefixed value. Length: " + i + ", available: " + byteBuffer.remaining());
        }
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return bArr;
    }

    static void z(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >>> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >>> 16) & 255);
        bArr[i2 + 3] = (byte) ((i >>> 24) & 255);
    }

    static Pair<ByteBuffer, Long> z(RandomAccessFile randomAccessFile, long j) throws v, IOException {
        if (j < 32) {
            throw new v("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(j)));
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - ((long) byteBufferAllocate.capacity()));
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        if (byteBufferAllocate.getLong(8) != 2334950737559900225L || byteBufferAllocate.getLong(16) != 3617552046287187010L) {
            return null;
        }
        long j2 = byteBufferAllocate.getLong(0);
        if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
            throw new v("APK Signing Block size out of range: ".concat(String.valueOf(j2)));
        }
        int i = (int) (8 + j2);
        long j3 = j - ((long) i);
        if (j3 < 0) {
            throw new v("APK Signing Block offset out of range: ".concat(String.valueOf(j3)));
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 != j2) {
            throw new v("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
    }

    static void z(String str, RandomAccessFile randomAccessFile, int... iArr) throws v, IOException {
        HashSet hashSet;
        int i;
        long j;
        int i2;
        ByteBuffer byteBuffer;
        String str2 = str;
        z.put(str2, new SparseArray<>());
        Pair<ByteBuffer, Long> pairZ = z(randomAccessFile);
        ByteBuffer byteBuffer2 = (ByteBuffer) pairZ.first;
        long jLongValue = ((Long) pairZ.second).longValue();
        if (js.z(randomAccessFile, jLongValue)) {
            throw new v("ZIP64 APK not supported");
        }
        long jZ = z(byteBuffer2, jLongValue);
        Pair<ByteBuffer, Long> pairZ2 = z(randomAccessFile, jZ);
        if (pairZ2 == null) {
            return;
        }
        ByteBuffer byteBuffer3 = (ByteBuffer) pairZ2.first;
        long jLongValue2 = ((Long) pairZ2.second).longValue();
        dl(byteBuffer3);
        int i3 = 8;
        ByteBuffer byteBufferZ = z(byteBuffer3, 8, byteBuffer3.capacity() - 24);
        HashSet hashSet2 = new HashSet();
        for (int i4 : iArr) {
            hashSet2.add(Integer.valueOf(i4));
        }
        while (byteBufferZ.hasRemaining() && byteBufferZ.remaining() >= i3) {
            long j2 = byteBufferZ.getLong();
            if (j2 < 4 || j2 > 2147483647L) {
                return;
            }
            int i5 = (int) j2;
            int iPosition = byteBufferZ.position() + i5;
            if (i5 > byteBufferZ.remaining()) {
                return;
            }
            int i6 = byteBufferZ.getInt();
            if (hashSet2.contains(Integer.valueOf(i6))) {
                hashSet = hashSet2;
                i = iPosition;
                j = jZ;
                i2 = i3;
                z.get(str2).put(i6, new i(z(byteBufferZ, i5 - 4), jLongValue2, jZ, jLongValue, byteBuffer2));
                byteBuffer = byteBufferZ;
            } else {
                hashSet = hashSet2;
                i = iPosition;
                j = jZ;
                i2 = i3;
                byteBuffer = byteBufferZ;
            }
            byteBuffer.position(i);
            hashSet2 = hashSet;
            byteBufferZ = byteBuffer;
            jZ = j;
            i3 = i2;
            str2 = str;
        }
    }

    private static void dl(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static class z implements uy {
        private final MessageDigest[] z;

        z(MessageDigest[] messageDigestArr) {
            this.z = messageDigestArr;
        }

        @Override // com.bytedance.pangle.gz.uy
        public void z(ByteBuffer byteBuffer) {
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            for (MessageDigest messageDigest : this.z) {
                byteBufferSlice.position(0);
                messageDigest.update(byteBufferSlice);
            }
        }
    }
}
