package com.a.a;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.xiaomi.verificationsdk.internal.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.UShort;

/* JADX INFO: loaded from: classes.dex */
public class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f1618a;

    public g(ByteBuffer byteBuffer) {
        this.f1618a = byteBuffer.slice();
    }

    private static int a(int i, int i2) {
        return b(b(i), b(i2));
    }

    private static int b(int i) {
        if (i == 513) {
            return 1;
        }
        if (i == 514) {
            return 2;
        }
        if (i == 769) {
            return 1;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                return 1;
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return 2;
            default:
                String strValueOf = String.valueOf(Long.toHexString(i));
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(strValueOf) : new String("Unknown signature algorithm: 0x"));
        }
    }

    private static Pair<ByteBuffer, Long> c(RandomAccessFile randomAccessFile) throws d, IOException {
        Pair<ByteBuffer, Long> pairA;
        if (randomAccessFile.length() < 22) {
            pairA = null;
        } else {
            pairA = a(randomAccessFile, 0);
            if (pairA == null) {
                pairA = a(randomAccessFile, 65535);
            }
        }
        if (pairA != null) {
            return pairA;
        }
        long length = randomAccessFile.length();
        StringBuilder sb = new StringBuilder(102);
        sb.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
        sb.append(length);
        sb.append(" bytes");
        throw new d(sb.toString());
    }

    private static int d(int i) {
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 64;
        }
        StringBuilder sb = new StringBuilder(44);
        sb.append("Unknown content digest algorthm: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String e(int i) {
        if (i == 513 || i == 514) {
            return "EC";
        }
        if (i == 769) {
            return "DSA";
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return com.alipay.sdk.m.p.d.f1901a;
            default:
                String strValueOf = String.valueOf(Long.toHexString(i));
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(strValueOf) : new String("Unknown signature algorithm: 0x"));
        }
    }

    private static Pair<String, ? extends AlgorithmParameterSpec> f(int i) {
        if (i == 513) {
            return Pair.create("SHA256withECDSA", null);
        }
        if (i == 514) {
            return Pair.create("SHA512withECDSA", null);
        }
        if (i == 769) {
            return Pair.create("SHA256withDSA", null);
        }
        switch (i) {
            case 257:
                return Pair.create("SHA256withRSA/PSS", new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1));
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                return Pair.create("SHA512withRSA/PSS", new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1));
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
                return Pair.create("SHA256withRSA", null);
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return Pair.create("SHA512withRSA", null);
            default:
                String strValueOf = String.valueOf(Long.toHexString(i));
                throw new IllegalArgumentException(strValueOf.length() != 0 ? "Unknown signature algorithm: 0x".concat(strValueOf) : new String("Unknown signature algorithm: 0x"));
        }
    }

    private static int b(int i, int i2) {
        if (i == 1) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return -1;
            }
            StringBuilder sb = new StringBuilder(37);
            sb.append("Unknown digestAlgorithm2: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i != 2) {
            StringBuilder sb2 = new StringBuilder(37);
            sb2.append("Unknown digestAlgorithm1: ");
            sb2.append(i);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 0;
        }
        StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Unknown digestAlgorithm2: ");
        sb3.append(i2);
        throw new IllegalArgumentException(sb3.toString());
    }

    private static String c(int i) {
        if (i == 1) {
            return "SHA-256";
        }
        if (i == 2) {
            return "SHA-512";
        }
        StringBuilder sb = new StringBuilder(44);
        sb.append("Unknown content digest algorthm: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private static ByteBuffer d(ByteBuffer byteBuffer) throws d {
        e(byteBuffer);
        ByteBuffer byteBufferA = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i = 0;
        while (byteBufferA.hasRemaining()) {
            i++;
            if (byteBufferA.remaining() < 8) {
                StringBuilder sb = new StringBuilder(70);
                sb.append("Insufficient data to read size of APK Signing Block entry #");
                sb.append(i);
                throw new d(sb.toString());
            }
            long j = byteBufferA.getLong();
            if (j < 4 || j > 2147483647L) {
                StringBuilder sb2 = new StringBuilder(76);
                sb2.append("APK Signing Block entry #");
                sb2.append(i);
                sb2.append(" size out of range: ");
                sb2.append(j);
                throw new d(sb2.toString());
            }
            int i2 = (int) j;
            int iPosition = byteBufferA.position() + i2;
            if (i2 > byteBufferA.remaining()) {
                int iRemaining = byteBufferA.remaining();
                StringBuilder sb3 = new StringBuilder(91);
                sb3.append("APK Signing Block entry #");
                sb3.append(i);
                sb3.append(" size out of range: ");
                sb3.append(i2);
                sb3.append(", available: ");
                sb3.append(iRemaining);
                throw new d(sb3.toString());
            }
            if (byteBufferA.getInt() == 1896449818) {
                return b(byteBufferA, i2 - 4);
            }
            byteBufferA.position(iPosition);
        }
        throw new d("No APK Signature Scheme v2 block in APK Signing Block");
    }

    private static void e(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    @Override // com.a.a.a
    public long a() {
        return this.f1618a.capacity();
    }

    private static long a(long j) {
        return ((j + 1048576) - 1) / 1048576;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.a.a.c b(java.io.RandomAccessFile r12) throws com.a.a.d, java.io.IOException {
        /*
            android.util.Pair r0 = c(r12)
            java.lang.Object r1 = r0.first
            r10 = r1
            java.nio.ByteBuffer r10 = (java.nio.ByteBuffer) r10
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r8 = r0.longValue()
            r0 = 20
            long r0 = r8 - r0
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L29
            r12.seek(r0)
            int r0 = r12.readInt()
            r1 = 1347094023(0x504b0607, float:1.3624679E10)
            if (r0 != r1) goto L29
            r0 = 1
            goto L2a
        L29:
            r0 = 0
        L2a:
            if (r0 != 0) goto L4c
            long r6 = a(r10, r8)
            android.util.Pair r12 = a(r12, r6)
            java.lang.Object r0 = r12.first
            java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
            java.lang.Object r12 = r12.second
            java.lang.Long r12 = (java.lang.Long) r12
            long r4 = r12.longValue()
            java.nio.ByteBuffer r3 = d(r0)
            com.a.a.c r12 = new com.a.a.c
            r11 = 0
            r2 = r12
            r2.<init>(r3, r4, r6, r8, r10, r11)
            return r12
        L4c:
            com.a.a.d r12 = new com.a.a.d
            java.lang.String r0 = "ZIP64 APK not supported"
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.a.a.g.b(java.io.RandomAccessFile):com.a.a.c");
    }

    private static byte[] c(ByteBuffer byteBuffer) throws IOException {
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IOException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i];
            byteBuffer.get(bArr);
            return bArr;
        }
        int iRemaining = byteBuffer.remaining();
        StringBuilder sb = new StringBuilder(90);
        sb.append("Underflow while reading length-prefixed value. Length: ");
        sb.append(i);
        sb.append(", available: ");
        sb.append(iRemaining);
        throw new IOException(sb.toString());
    }

    private static long a(ByteBuffer byteBuffer, int i) {
        return ((long) byteBuffer.getInt(i)) & 4294967295L;
    }

    private static ByteBuffer b(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer.remaining() < 4) {
            int iRemaining = byteBuffer.remaining();
            StringBuilder sb = new StringBuilder(93);
            sb.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
            sb.append(iRemaining);
            throw new IOException(sb.toString());
        }
        int i = byteBuffer.getInt();
        if (i < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i <= byteBuffer.remaining()) {
            return b(byteBuffer, i);
        }
        int iRemaining2 = byteBuffer.remaining();
        StringBuilder sb2 = new StringBuilder(101);
        sb2.append("Length-prefixed field longer than remaining buffer. Field length: ");
        sb2.append(i);
        sb2.append(", remaining: ");
        sb2.append(iRemaining2);
        throw new IOException(sb2.toString());
    }

    private static long a(ByteBuffer byteBuffer, long j) throws d {
        a(byteBuffer);
        long jA = a(byteBuffer, byteBuffer.position() + 16);
        if (jA < j) {
            a(byteBuffer);
            if (a(byteBuffer, byteBuffer.position() + 12) + jA == j) {
                return jA;
            }
            throw new d("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        StringBuilder sb = new StringBuilder(122);
        sb.append("ZIP Central Directory offset out of range: ");
        sb.append(jA);
        sb.append(". ZIP End of Central Directory offset: ");
        sb.append(j);
        throw new d(sb.toString());
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(17);
            sb.append("size: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
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

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, int i) throws IOException {
        int i2;
        if (i < 0 || i > 65535) {
            StringBuilder sb = new StringBuilder(27);
            sb.append("maxCommentSize: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
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
        a(byteBufferAllocate);
        int iCapacity = byteBufferAllocate.capacity();
        if (iCapacity >= 22) {
            int i3 = iCapacity - 22;
            int iMin = Math.min(i3, 65535);
            for (int i4 = 0; i4 < iMin; i4++) {
                i2 = i3 - i4;
                if (byteBufferAllocate.getInt(i2) == 101010256 && (byteBufferAllocate.getShort(i2 + 20) & UShort.MAX_VALUE) == i4) {
                    break;
                }
            }
            i2 = -1;
        } else {
            i2 = -1;
        }
        if (i2 == -1) {
            return null;
        }
        byteBufferAllocate.position(i2);
        ByteBuffer byteBufferSlice = byteBufferAllocate.slice();
        byteBufferSlice.order(ByteOrder.LITTLE_ENDIAN);
        return Pair.create(byteBufferSlice, Long.valueOf(jCapacity + ((long) i2)));
    }

    private static Pair<ByteBuffer, Long> a(RandomAccessFile randomAccessFile, long j) throws d, IOException {
        if (j < 32) {
            StringBuilder sb = new StringBuilder(87);
            sb.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
            sb.append(j);
            throw new d(sb.toString());
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(24);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBufferAllocate.order(byteOrder);
        randomAccessFile.seek(j - ((long) byteBufferAllocate.capacity()));
        randomAccessFile.readFully(byteBufferAllocate.array(), byteBufferAllocate.arrayOffset(), byteBufferAllocate.capacity());
        if (byteBufferAllocate.getLong(8) != com.bytedance.hume.readapk.a.f2079b || byteBufferAllocate.getLong(16) != com.bytedance.hume.readapk.a.f2078a) {
            throw new d("No APK Signing Block before ZIP Central Directory");
        }
        long j2 = byteBufferAllocate.getLong(0);
        if (j2 < byteBufferAllocate.capacity() || j2 > 2147483639) {
            StringBuilder sb2 = new StringBuilder(57);
            sb2.append("APK Signing Block size out of range: ");
            sb2.append(j2);
            throw new d(sb2.toString());
        }
        int i = (int) (8 + j2);
        long j3 = j - ((long) i);
        if (j3 < 0) {
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("APK Signing Block offset out of range: ");
            sb3.append(j3);
            throw new d(sb3.toString());
        }
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i);
        byteBufferAllocate2.order(byteOrder);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(byteBufferAllocate2.array(), byteBufferAllocate2.arrayOffset(), byteBufferAllocate2.capacity());
        long j4 = byteBufferAllocate2.getLong(0);
        if (j4 == j2) {
            return Pair.create(byteBufferAllocate2, Long.valueOf(j3));
        }
        StringBuilder sb4 = new StringBuilder(103);
        sb4.append("APK Signing Block sizes in header and footer do not match: ");
        sb4.append(j4);
        sb4.append(" vs ");
        sb4.append(j2);
        throw new d(sb4.toString());
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i, int i2) {
        if (i2 < 8) {
            StringBuilder sb = new StringBuilder(38);
            sb.append("end < start: ");
            sb.append(i2);
            sb.append(" < 8");
            throw new IllegalArgumentException(sb.toString());
        }
        int iCapacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            StringBuilder sb2 = new StringBuilder(41);
            sb2.append("end > capacity: ");
            sb2.append(i2);
            sb2.append(" > ");
            sb2.append(iCapacity);
            throw new IllegalArgumentException(sb2.toString());
        }
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

    private static void a(int i, byte[] bArr, int i2) {
        bArr[1] = (byte) i;
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) (i >>> 16);
        bArr[4] = (byte) (i >>> 24);
    }

    private static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static void a(Map<Integer, byte[]> map, FileChannel fileChannel, long j, long j2, long j3, ByteBuffer byteBuffer) {
        if (map.isEmpty()) {
            throw new SecurityException("No digests provided");
        }
        b bVar = new b(fileChannel, 0L, j);
        b bVar2 = new b(fileChannel, j2, j3 - j2);
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        a(byteBufferDuplicate);
        int iPosition = byteBufferDuplicate.position() + 16;
        if (j < 0 || j > 4294967295L) {
            StringBuilder sb = new StringBuilder(47);
            sb.append("uint32 value of out range: ");
            sb.append(j);
            throw new IllegalArgumentException(sb.toString());
        }
        byteBufferDuplicate.putInt(byteBufferDuplicate.position() + iPosition, (int) j);
        g gVar = new g(byteBufferDuplicate);
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        try {
            byte[][] bArrA = a(iArr, new a[]{bVar, bVar2, gVar});
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = iArr[i2];
                if (!MessageDigest.isEqual(map.get(Integer.valueOf(i3)), bArrA[i2])) {
                    throw new SecurityException(String.valueOf(c(i3)).concat(" digest of contents did not verify"));
                }
            }
        } catch (DigestException e) {
            throw new SecurityException("Failed to compute digest(s) of contents", e);
        }
    }

    @Override // com.a.a.a
    public void a(MessageDigest[] messageDigestArr, long j, int i) {
        ByteBuffer byteBufferSlice;
        synchronized (this.f1618a) {
            int i2 = (int) j;
            this.f1618a.position(i2);
            this.f1618a.limit(i2 + i);
            byteBufferSlice = this.f1618a.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            byteBufferSlice.position(0);
            messageDigest.update(byteBufferSlice);
        }
    }

    private static boolean a(int i) {
        if (i == 513 || i == 514 || i == 769) {
            return true;
        }
        switch (i) {
            case 257:
            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME /* 259 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME /* 260 */:
                return true;
            default:
                return false;
        }
    }

    private static X509Certificate[] a(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException {
        ByteBuffer byteBufferB = b(byteBuffer);
        ByteBuffer byteBufferB2 = b(byteBuffer);
        byte[] bArrC = c(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrC2 = null;
        int i = 0;
        int i2 = -1;
        byte[] bArrC3 = null;
        while (byteBufferB2.hasRemaining()) {
            i++;
            try {
                ByteBuffer byteBufferB3 = b(byteBufferB2);
                if (byteBufferB3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = byteBufferB3.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (a(i3) && (i2 == -1 || a(i3, i2) > 0)) {
                    bArrC3 = c(byteBufferB3);
                    i2 = i3;
                }
            } catch (IOException | BufferUnderflowException e) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Failed to parse signature record #");
                sb.append(i);
                throw new SecurityException(sb.toString(), e);
            }
        }
        if (i2 == -1) {
            if (i == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strE = e(i2);
        Pair<String, ? extends AlgorithmParameterSpec> pairF = f(i2);
        String str = (String) pairF.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairF.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strE).generatePublic(new X509EncodedKeySpec(bArrC));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferB);
            if (!signature.verify(bArrC3)) {
                throw new SecurityException(String.valueOf(str).concat(" signature did not verify"));
            }
            byteBufferB.clear();
            ByteBuffer byteBufferB4 = b(byteBufferB);
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            while (byteBufferB4.hasRemaining()) {
                i4++;
                try {
                    ByteBuffer byteBufferB5 = b(byteBufferB4);
                    if (byteBufferB5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i5 = byteBufferB5.getInt();
                    arrayList2.add(Integer.valueOf(i5));
                    if (i5 == i2) {
                        bArrC2 = c(byteBufferB5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    StringBuilder sb2 = new StringBuilder(42);
                    sb2.append("Failed to parse digest record #");
                    sb2.append(i4);
                    throw new IOException(sb2.toString(), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iB = b(i2);
            byte[] bArrPut = map.put(Integer.valueOf(iB), bArrC2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrC2)) {
                throw new SecurityException(String.valueOf(c(iB)).concat(" contents digest does not match the digest specified by a preceding signer"));
            }
            ByteBuffer byteBufferB6 = b(byteBufferB);
            ArrayList arrayList3 = new ArrayList();
            int i6 = 0;
            while (byteBufferB6.hasRemaining()) {
                i6++;
                byte[] bArrC4 = c(byteBufferB6);
                try {
                    arrayList3.add(new e((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrC4)), bArrC4));
                } catch (CertificateException e3) {
                    StringBuilder sb3 = new StringBuilder(41);
                    sb3.append("Failed to decode certificate #");
                    sb3.append(i6);
                    throw new SecurityException(sb3.toString(), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (Arrays.equals(bArrC, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
            }
            throw new SecurityException("Public key mismatch between certificate and signature record");
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 27);
            sb4.append("Failed to verify ");
            sb4.append(str);
            sb4.append(" signature");
            throw new SecurityException(sb4.toString(), e4);
        }
    }

    private static byte[][] a(int[] iArr, a[] aVarArr) throws DigestException {
        a[] aVarArr2 = aVarArr;
        long j = 0;
        long jA = 0;
        for (a aVar : aVarArr2) {
            jA += a(aVar.a());
        }
        if (jA >= 2097151) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Too many chunks: ");
            sb.append(jA);
            throw new DigestException(sb.toString());
        }
        int i = (int) jA;
        byte[][] bArr = new byte[iArr.length][];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            byte[] bArr2 = new byte[(d(iArr[i2]) * i) + 5];
            bArr2[0] = 90;
            a(i, bArr2, 1);
            bArr[i2] = bArr2;
        }
        byte[] bArr3 = new byte[5];
        bArr3[0] = -91;
        int length = iArr.length;
        MessageDigest[] messageDigestArr = new MessageDigest[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            String strC = c(iArr[i3]);
            try {
                messageDigestArr[i3] = MessageDigest.getInstance(strC);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(String.valueOf(strC).concat(" digest not supported"), e);
            }
        }
        int length2 = aVarArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length2) {
            a aVar2 = aVarArr2[i4];
            int i7 = length2;
            int i8 = i4;
            long jA2 = aVar2.a();
            long j2 = j;
            while (jA2 > j) {
                int iMin = (int) Math.min(jA2, 1048576L);
                a(iMin, bArr3, 1);
                for (int i9 = 0; i9 < length; i9++) {
                    messageDigestArr[i9].update(bArr3);
                }
                try {
                    aVar2.a(messageDigestArr, j2, iMin);
                    int i10 = 0;
                    while (i10 < iArr.length) {
                        int i11 = iArr[i10];
                        byte[] bArr4 = bArr3;
                        byte[] bArr5 = bArr[i10];
                        int iD = d(i11);
                        a aVar3 = aVar2;
                        MessageDigest messageDigest = messageDigestArr[i10];
                        int i12 = length;
                        int iDigest = messageDigest.digest(bArr5, (i5 * iD) + 5, iD);
                        if (iDigest != iD) {
                            String algorithm = messageDigest.getAlgorithm();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(algorithm).length() + 46);
                            sb2.append("Unexpected output size of ");
                            sb2.append(algorithm);
                            sb2.append(" digest: ");
                            sb2.append(iDigest);
                            throw new RuntimeException(sb2.toString());
                        }
                        i10++;
                        bArr3 = bArr4;
                        aVar2 = aVar3;
                        length = i12;
                    }
                    long j3 = iMin;
                    j2 += j3;
                    jA2 -= j3;
                    i5++;
                    bArr3 = bArr3;
                    j = 0;
                } catch (IOException e2) {
                    StringBuilder sb3 = new StringBuilder(59);
                    sb3.append("Failed to digest chunk #");
                    sb3.append(i5);
                    sb3.append(" of section #");
                    sb3.append(i6);
                    throw new DigestException(sb3.toString(), e2);
                }
            }
            i6++;
            i4 = i8 + 1;
            aVarArr2 = aVarArr;
            length2 = i7;
            j = 0;
        }
        byte[][] bArr6 = new byte[iArr.length][];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            int i14 = iArr[i13];
            byte[] bArr7 = bArr[i13];
            String strC2 = c(i14);
            try {
                bArr6[i13] = MessageDigest.getInstance(strC2).digest(bArr7);
            } catch (NoSuchAlgorithmException e3) {
                throw new RuntimeException(String.valueOf(strC2).concat(" digest not supported"), e3);
            }
        }
        return bArr6;
    }

    private static X509Certificate[][] a(RandomAccessFile randomAccessFile) throws d, IOException {
        return a(randomAccessFile.getChannel(), b(randomAccessFile));
    }

    public static X509Certificate[][] a(String str) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, Constants.RANDOM_LONG);
        try {
            X509Certificate[][] x509CertificateArrA = a(randomAccessFile);
            randomAccessFile.close();
            return x509CertificateArrA;
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException unused) {
            }
        }
    }

    private static X509Certificate[][] a(FileChannel fileChannel, c cVar) {
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferB = b(cVar.f1614a);
                int i = 0;
                while (byteBufferB.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(a(b(byteBufferB), map, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        StringBuilder sb = new StringBuilder(48);
                        sb.append("Failed to parse/verify signer #");
                        sb.append(i);
                        sb.append(" block");
                        throw new SecurityException(sb.toString(), e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (map.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                a(map, fileChannel, cVar.f1615b, cVar.c, cVar.d, cVar.e);
                return (X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]);
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }
}
