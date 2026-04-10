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
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    private static class z extends Exception {
    }

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

    public static C0109dl z(RandomAccessFile randomAccessFile, String str) throws v, IOException {
        i iVar = m.z.get(str).get(-262969152);
        if (iVar == null) {
            throw new v("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
        }
        return z(randomAccessFile, iVar, true);
    }

    private static C0109dl z(RandomAccessFile randomAccessFile, i iVar, boolean z2) throws SecurityException, IOException {
        ArrayMap arrayMap = new ArrayMap();
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            try {
                ByteBuffer byteBufferZ = m.z(iVar.z);
                int i = 0;
                C0109dl c0109dlZ = null;
                while (byteBufferZ.hasRemaining()) {
                    try {
                        c0109dlZ = z(m.z(byteBufferZ), arrayMap, certificateFactory);
                        i++;
                    } catch (z unused) {
                    } catch (IOException e) {
                        e = e;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (SecurityException e2) {
                        e = e2;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    } catch (BufferUnderflowException e3) {
                        e = e3;
                        throw new SecurityException("Failed to parse/verify signer #" + i + " block", e);
                    }
                }
                if (i <= 0 || c0109dlZ == null) {
                    throw new SecurityException("No signers found");
                }
                if (i != 1) {
                    throw new SecurityException("APK Signature Scheme V3 only supports one signer: multiple signers found.");
                }
                if (arrayMap.isEmpty()) {
                    throw new SecurityException("No content digests found");
                }
                if (z2) {
                    m.z(arrayMap, randomAccessFile, iVar);
                }
                if (arrayMap.containsKey(3)) {
                    c0109dlZ.dl = m.z((byte[]) arrayMap.get(3), randomAccessFile.length(), iVar);
                }
                return c0109dlZ;
            } catch (IOException e4) {
                throw new SecurityException("Failed to read list of signers", e4);
            }
        } catch (CertificateException e5) {
            throw new RuntimeException("Failed to obtain X.509 CertificateFactory", e5);
        }
    }

    private static C0109dl z(ByteBuffer byteBuffer, Map<Integer, byte[]> map, CertificateFactory certificateFactory) throws z, IOException, SecurityException {
        ByteBuffer byteBufferZ = m.z(byteBuffer);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        ByteBuffer byteBufferZ2 = m.z(byteBuffer);
        byte[] bArrG = m.g(byteBuffer);
        ArrayList arrayList = new ArrayList();
        byte[] bArrG2 = null;
        int i3 = 0;
        int i4 = -1;
        byte[] bArrG3 = null;
        while (byteBufferZ2.hasRemaining()) {
            i3++;
            try {
                ByteBuffer byteBufferZ3 = m.z(byteBufferZ2);
                if (byteBufferZ3.remaining() < 8) {
                    throw new SecurityException("Signature record too short");
                }
                int i5 = byteBufferZ3.getInt();
                arrayList.add(Integer.valueOf(i5));
                if (z(i5) && (i4 == -1 || m.z(i5, i4) > 0)) {
                    bArrG3 = m.g(byteBufferZ3);
                    i4 = i5;
                }
            } catch (IOException | BufferUnderflowException e) {
                throw new SecurityException("Failed to parse signature record #".concat(String.valueOf(i3)), e);
            }
        }
        if (i4 == -1) {
            if (i3 == 0) {
                throw new SecurityException("No signatures found");
            }
            throw new SecurityException("No supported signatures found");
        }
        String strDl = m.dl(i4);
        Pair<String, ? extends AlgorithmParameterSpec> pairA = m.a(i4);
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
            int i6 = 0;
            while (byteBufferZ4.hasRemaining()) {
                i6++;
                try {
                    ByteBuffer byteBufferZ5 = m.z(byteBufferZ4);
                    if (byteBufferZ5.remaining() < 8) {
                        throw new IOException("Record too short");
                    }
                    int i7 = byteBufferZ5.getInt();
                    arrayList2.add(Integer.valueOf(i7));
                    if (i7 == i4) {
                        bArrG2 = m.g(byteBufferZ5);
                    }
                } catch (IOException | BufferUnderflowException e2) {
                    throw new IOException("Failed to parse digest record #".concat(String.valueOf(i6)), e2);
                }
            }
            if (!arrayList.equals(arrayList2)) {
                throw new SecurityException("Signature algorithms don't match between digests and signatures records");
            }
            int iZ = m.z(i4);
            byte[] bArrPut = map.put(Integer.valueOf(iZ), bArrG2);
            if (bArrPut != null && !MessageDigest.isEqual(bArrPut, bArrG2)) {
                throw new SecurityException(m.g(iZ) + " contents digest does not match the digest specified by a preceding signer");
            }
            ByteBuffer byteBufferZ6 = m.z(byteBufferZ);
            ArrayList arrayList3 = new ArrayList();
            int i8 = 0;
            while (byteBufferZ6.hasRemaining()) {
                i8++;
                byte[] bArrG4 = m.g(byteBufferZ6);
                try {
                    arrayList3.add(new ls((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrG4)), bArrG4));
                } catch (CertificateException e3) {
                    throw new SecurityException("Failed to decode certificate #".concat(String.valueOf(i8)), e3);
                }
            }
            if (arrayList3.isEmpty()) {
                throw new SecurityException("No certificates listed");
            }
            if (!Arrays.equals(bArrG, ((X509Certificate) arrayList3.get(0)).getPublicKey().getEncoded())) {
                throw new SecurityException("Public key mismatch between certificate and signature record");
            }
            if (byteBufferZ.getInt() != i) {
                throw new SecurityException("minSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            if (byteBufferZ.getInt() != i2) {
                throw new SecurityException("maxSdkVersion mismatch between signed and unsigned in v3 signer block.");
            }
            return z(m.z(byteBufferZ), arrayList3, certificateFactory);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | SignatureException | InvalidKeySpecException e4) {
            throw new SecurityException("Failed to verify " + str + " signature", e4);
        }
    }

    private static C0109dl z(ByteBuffer byteBuffer, List<X509Certificate> list, CertificateFactory certificateFactory) throws IOException {
        X509Certificate[] x509CertificateArr = (X509Certificate[]) list.toArray(new X509Certificate[list.size()]);
        g gVarZ = null;
        while (byteBuffer.hasRemaining()) {
            ByteBuffer byteBufferZ = m.z(byteBuffer);
            if (byteBufferZ.remaining() < 4) {
                throw new IOException("Remaining buffer too short to contain additional attribute ID. Remaining: " + byteBufferZ.remaining());
            }
            if (byteBufferZ.getInt() == 1000370060) {
                if (gVarZ != null) {
                    throw new SecurityException("Encountered multiple Proof-of-rotation records when verifying APK Signature Scheme v3 signature");
                }
                gVarZ = z(byteBufferZ, certificateFactory);
                try {
                    if (gVarZ.z.size() > 0 && !Arrays.equals(gVarZ.z.get(gVarZ.z.size() - 1).getEncoded(), x509CertificateArr[0].getEncoded())) {
                        throw new SecurityException("Terminal certificate in Proof-of-rotation record does not match APK signing certificate");
                    }
                } catch (CertificateEncodingException e) {
                    throw new SecurityException("Failed to encode certificate when comparing Proof-of-rotation record and signing certificate", e);
                }
            }
        }
        return new C0109dl(x509CertificateArr, gVarZ);
    }

    private static g z(ByteBuffer byteBuffer, CertificateFactory certificateFactory) throws IOException, SecurityException {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        try {
            byteBuffer.getInt();
            HashSet hashSet = new HashSet();
            int i2 = -1;
            ls lsVar = null;
            while (byteBuffer.hasRemaining()) {
                i++;
                ByteBuffer byteBufferZ = m.z(byteBuffer);
                ByteBuffer byteBufferZ2 = m.z(byteBufferZ);
                int i3 = byteBufferZ.getInt();
                int i4 = byteBufferZ.getInt();
                byte[] bArrG = m.g(byteBufferZ);
                if (lsVar != null) {
                    Pair<String, ? extends AlgorithmParameterSpec> pairA = m.a(i2);
                    PublicKey publicKey = lsVar.getPublicKey();
                    Signature signature = Signature.getInstance((String) pairA.first);
                    signature.initVerify(publicKey);
                    if (pairA.second != null) {
                        signature.setParameter((AlgorithmParameterSpec) pairA.second);
                    }
                    signature.update(byteBufferZ2);
                    if (!signature.verify(bArrG)) {
                        throw new SecurityException("Unable to verify signature of certificate #" + i + " using " + ((String) pairA.first) + " when verifying Proof-of-rotation record");
                    }
                }
                byteBufferZ2.rewind();
                byte[] bArrG2 = m.g(byteBufferZ2);
                int i5 = byteBufferZ2.getInt();
                if (lsVar != null && i2 != i5) {
                    throw new SecurityException("Signing algorithm ID mismatch for certificate #" + i + " when verifying Proof-of-rotation record");
                }
                lsVar = new ls((X509Certificate) certificateFactory.generateCertificate(new ByteArrayInputStream(bArrG2)), bArrG2);
                if (hashSet.contains(lsVar)) {
                    throw new SecurityException("Encountered duplicate entries in Proof-of-rotation record at certificate #" + i + ".  All signing certificates should be unique");
                }
                hashSet.add(lsVar);
                arrayList.add(lsVar);
                arrayList2.add(Integer.valueOf(i3));
                i2 = i4;
            }
            return new g(arrayList, arrayList2);
        } catch (IOException e) {
            e = e;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (BufferUnderflowException e2) {
            e = e2;
            throw new IOException("Failed to parse Proof-of-rotation record", e);
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (InvalidKeyException e4) {
            e = e4;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (SignatureException e6) {
            e = e6;
            throw new SecurityException("Failed to verify signature over signed data for certificate #0 when verifying Proof-of-rotation record", e);
        } catch (CertificateException e7) {
            throw new SecurityException("Failed to decode certificate #0 when verifying Proof-of-rotation record", e7);
        }
    }

    public static class g {
        public final List<Integer> g;
        public final List<X509Certificate> z;

        public g(List<X509Certificate> list, List<Integer> list2) {
            this.z = list;
            this.g = list2;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.gz.dl$dl, reason: collision with other inner class name */
    public static class C0109dl {
        public byte[] dl;
        public final g g;
        public final X509Certificate[] z;

        public C0109dl(X509Certificate[] x509CertificateArr, g gVar) {
            this.z = x509CertificateArr;
            this.g = gVar;
        }
    }
}
