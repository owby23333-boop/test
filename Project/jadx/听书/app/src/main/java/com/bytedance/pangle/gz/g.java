package com.bytedance.pangle.gz;

import android.util.ArrayMap;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
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
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static boolean z(int i) {
        if (i == 513 || i == 514 || i == 769 || i == 1057 || i == 1059 || i == 1061) {
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

    public static X509Certificate[][] z(RandomAccessFile randomAccessFile, String str) throws v, SecurityException, IOException {
        i iVar = m.z.get(str).get(1896449818);
        if (iVar == null) {
            throw new v("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
        }
        return z(randomAccessFile, iVar, true).z;
    }

    private static z z(RandomAccessFile randomAccessFile, i iVar, boolean z2) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        ArrayList arrayList = new ArrayList();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferZ = m.z(iVar.z);
                int i = 0;
                while (byteBufferZ.hasRemaining()) {
                    i++;
                    try {
                        arrayList.add(z(m.z(byteBufferZ), arrayMap, certificateFactory));
                    } catch (IOException | SecurityException | BufferUnderflowException e) {
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0) {
                    throw new SecurityException("No signers found");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (z2) {
                    m.z(arrayMap, randomAccessFile, iVar);
                }
                return new z((X509Certificate[][]) arrayList.toArray(new X509Certificate[arrayList.size()][]), arrayMap.containsKey(3) ? m.z((byte[]) arrayMap.get(3), randomAccessFile.length(), iVar) : null);
            } catch (IOException e2) {
                throw new SecurityException("Failed to read list of signers", e2);
            }
        } catch (CertificateException e3) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e3);
        }
    }

    private static X509Certificate[] z(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ByteBuffer byteBufferZ = m.z(byteBuffer);
        ByteBuffer byteBufferZ2 = m.z(byteBuffer);
        byte[] bArrG = m.g(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrG2 = null;
        int i = 0;
        int i2 = -1;
        byte[] bArrG3 = null;
        while (byteBufferZ2.hasRemaining()) {
            i++;
            try {
                ByteBuffer byteBufferZ3 = m.z(byteBufferZ2);
                if (byteBufferZ3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i3 = byteBufferZ3.getInt();
                arrayList.add(Integer.valueOf(i3));
                if (z(i3) && (i2 == -1 || m.z(i3, i2) > 0)) {
                    bArrG3 = m.g(byteBufferZ3);
                    i2 = i3;
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i)), e);
            }
        }
        if (i2 == -1) {
            if (i == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strDl = m.dl(i2);
        Pair<String, ? extends AlgorithmParameterSpec> pairA = m.a(i2);
        String str = (String) pairA.first;
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) pairA.second;
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance(strDl).generatePublic(new X509EncodedKeySpec(bArrG));
            Signature signature = Signature.getInstance(str);
            signature.initVerify(publicKeyGeneratePublic);
            if (algorithmParameterSpec != null) {
                signature.setParameter(algorithmParameterSpec);
            }
            signature.update(byteBufferZ);
            if (!signature.verify(bArrG3)) {
                throw new SecurityException(str + " signature did not verify");
            }
            byteBufferZ.clear();
            ByteBuffer byteBufferZ4 = m.z(byteBufferZ);
            ArrayList arrayList2 = new ArrayList();
            int i4 = 0;
            while (byteBufferZ4.hasRemaining()) {
                i4++;
                try {
                    ByteBuffer byteBufferZ5 = m.z(byteBufferZ4);
                    if (byteBufferZ5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i5 = byteBufferZ5.getInt();
                    arrayList2.add(Integer.valueOf(i5));
                    if (i5 == i2) {
                        bArrG2 = m.g(byteBufferZ5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i4)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iZ = m.z(i2);
            byte[] bArrPut = map.put(Integer.valueOf(iZ), bArrG2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrG2)) {
                throw new SecurityException(m.g(iZ) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferZ6 = m.z(byteBufferZ);
            ArrayList arrayList3 = new ArrayList();
            int i6 = 0;
            while (byteBufferZ6.hasRemaining()) {
                i6++;
                byte[] bArrG4 = m.g(byteBufferZ6);
                try {
                    arrayList3.add(new ls((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrG4)), bArrG4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i6)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrG, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            z(m.z(byteBufferZ));
            return (X509Certificate[]) arrayList3.toArray(new X509Certificate[arrayList3.size()]);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static void z(ByteBuffer byteBuffer) throws IOException, SecurityException {
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferZ = m.z(byteBuffer);
            if (byteBufferZ.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferZ.remaining());
            }
            if (byteBufferZ.getInt() == -1091571699) {
                if (byteBufferZ.remaining() < 4) {
                    throw new IOException("V2 Signature Scheme Stripping Protection Attribute  value too small. Expected 4 bytes, but found " + byteBufferZ.remaining());
                }
                if (byteBufferZ.getInt() == 3) {
                    throw new SecurityException("V2 signature indicates APK is signed using APK Signature Scheme v3, but none was found. Signature stripped?");
                }
            }
        }
    }

    public static class z {
        public final byte[] g;
        public final X509Certificate[][] z;

        public z(X509Certificate[][] x509CertificateArr, byte[] bArr) {
            this.z = x509CertificateArr;
            this.g = bArr;
        }
    }
}
