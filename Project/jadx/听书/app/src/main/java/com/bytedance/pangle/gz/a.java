package com.bytedance.pangle.gz;

import android.content.pm.Signature;
import com.bytedance.pangle.gz.dl;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static pf z(String str, int i) throws Throwable {
        RandomAccessFile randomAccessFile;
        int[] iArr;
        if (i > 3) {
            throw new p(4, "No signature found in package of version " + i + " or newer for package " + str);
        }
        RandomAccessFile randomAccessFile2 = null;
        Signature[] signatureArr = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
            } catch (Throwable th) {
                th = th;
            }
            try {
                try {
                    m.z(str, randomAccessFile, -262969152, 1896449818);
                    try {
                        try {
                            dl.C0109dl c0109dlZ = dl.z(randomAccessFile, str);
                            Signature[] signatureArrZ = z(new Certificate[][]{c0109dlZ.z});
                            if (c0109dlZ.g != null) {
                                int size = c0109dlZ.g.z.size();
                                Signature[] signatureArr2 = new Signature[size];
                                iArr = new int[c0109dlZ.g.g.size()];
                                for (int i2 = 0; i2 < size; i2++) {
                                    signatureArr2[i2] = new Signature(c0109dlZ.g.z.get(i2).getEncoded());
                                    iArr[i2] = c0109dlZ.g.g.get(i2).intValue();
                                }
                                signatureArr = signatureArr2;
                            } else {
                                iArr = null;
                            }
                            pf pfVar = new pf(signatureArrZ, 3, signatureArr, iArr);
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused) {
                            }
                            return pfVar;
                        } catch (Exception e) {
                            throw new p(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e);
                        }
                    } catch (v e2) {
                        if (i >= 3) {
                            throw new p(4, "No APK Signature Scheme v3 signature in package ".concat(String.valueOf(str)), e2);
                        }
                        if (i > 2) {
                            throw new p(4, "No signature found in package of version " + i + " or newer for package " + str);
                        }
                        try {
                            try {
                                pf pfVar2 = new pf(z(g.z(randomAccessFile, str)), 2);
                                try {
                                    randomAccessFile.close();
                                } catch (Exception unused2) {
                                }
                                return pfVar2;
                            } catch (Exception e3) {
                                throw new p(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                            }
                        } catch (v e4) {
                            if (i >= 2) {
                                throw new p(4, "No APK Signature Scheme v2 signature in package ".concat(String.valueOf(str)), e4);
                            }
                            if (i > 1) {
                                throw new p(4, "No signature found in package of version " + i + " or newer for package " + str);
                            }
                            pf pfVarZ = z.z(str, true);
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused3) {
                            }
                            return pfVarZ;
                        }
                    }
                } catch (Exception e5) {
                    throw new p(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e5);
                }
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            throw new p(6, "failed to read apk file, minSignatureSchemeVersion : " + i + ", apkPath : " + str);
        }
    }

    public static Signature[] z(Certificate[][] certificateArr) throws CertificateEncodingException {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (com.bytedance.pangle.util.fo.a()) {
                Constructor constructorZ = com.bytedance.pangle.g.g.z.z((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (constructorZ != null) {
                    constructorZ.setAccessible(true);
                }
                if (constructorZ != null && constructorZ.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) constructorZ.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        com.bytedance.sdk.openadsdk.api.m.z(e);
                    } catch (InstantiationException e2) {
                        com.bytedance.sdk.openadsdk.api.m.z(e2);
                    } catch (InvocationTargetException e3) {
                        com.bytedance.sdk.openadsdk.api.m.z(e3);
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
