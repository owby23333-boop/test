package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.bytedance.pangle.g.c;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 21)
public final class d {
    public static o a(String str) throws Throwable {
        RandomAccessFile randomAccessFile;
        int[] iArr;
        Signature[] signatureArr = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
            } catch (Exception unused) {
                throw new q(6, "failed to read apk file, minSignatureSchemeVersion : 1, apkPath : ".concat(String.valueOf(str)));
            }
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            try {
                f.a(str, randomAccessFile, -262969152, 1896449818);
                try {
                    try {
                        try {
                            m mVar = f.a.get(str).get(-262969152);
                            if (mVar == null) {
                                throw new n("findVerifiedSigner, No APK Signature Scheme v3 signature in package");
                            }
                            c.C0302c c0302cA = c.a(randomAccessFile, mVar);
                            Signature[] signatureArrA = a(new Certificate[][]{c0302cA.a});
                            if (c0302cA.b != null) {
                                signatureArr = new Signature[c0302cA.b.a.size()];
                                iArr = new int[c0302cA.b.b.size()];
                                for (int i2 = 0; i2 < signatureArr.length; i2++) {
                                    signatureArr[i2] = new Signature(c0302cA.b.a.get(i2).getEncoded());
                                    iArr[i2] = c0302cA.b.b.get(i2).intValue();
                                }
                            } else {
                                iArr = null;
                            }
                            o oVar = new o(signatureArrA, 3, signatureArr, iArr);
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused2) {
                            }
                            return oVar;
                        } catch (n unused3) {
                            m mVar2 = f.a.get(str).get(1896449818);
                            if (mVar2 == null) {
                                throw new n("findVerifiedSigner, No APK Signature Scheme v2 signature in package");
                            }
                            o oVar2 = new o(a(b.a(randomAccessFile, mVar2).a));
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused4) {
                            }
                            return oVar2;
                        } catch (Exception e2) {
                            throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e2);
                        }
                    } catch (Exception e3) {
                        throw new q(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                    }
                } catch (n unused5) {
                    o oVarA = a.a(str);
                    try {
                        randomAccessFile.close();
                    } catch (Exception unused6) {
                    }
                    return oVarA;
                }
            } catch (Exception e4) {
                throw new q(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e4);
            }
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception unused7) {
                }
            }
            throw th;
        }
    }

    public static Signature[] a(Certificate[][] certificateArr) {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i2 = 0; i2 < certificateArr.length; i2++) {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 21 && i3 <= 28) {
                Constructor constructorA = com.bytedance.pangle.b.b.a.a((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (constructorA != null) {
                    constructorA.setAccessible(true);
                }
                if (constructorA != null && constructorA.isAccessible()) {
                    try {
                        signatureArr[i2] = (Signature) constructorA.newInstance(certificateArr[i2]);
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                    } catch (InstantiationException e3) {
                        e3.printStackTrace();
                    } catch (InvocationTargetException e4) {
                        e4.printStackTrace();
                    }
                }
            } else {
                signatureArr[i2] = new Signature(certificateArr[i2][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
