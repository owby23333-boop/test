package com.bytedance.pangle.gz;

import android.content.pm.Signature;
import android.util.ArraySet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class pf {
    public static final pf z = new pf(null, 0, null, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArraySet<PublicKey> f515a;
    public final int dl;
    public final Signature[] g;
    public final Signature[] gc;
    public final int[] m;

    public static ArraySet<PublicKey> z(Signature[] signatureArr) throws CertificateException {
        Method method;
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e) {
                com.bytedance.sdk.openadsdk.api.m.z(e);
                method = null;
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    com.bytedance.sdk.openadsdk.api.m.z(e2);
                } catch (InvocationTargetException e3) {
                    com.bytedance.sdk.openadsdk.api.m.z(e3);
                } catch (Exception e4) {
                    com.bytedance.sdk.openadsdk.api.m.z(e4);
                }
            }
        }
        return arraySet;
    }

    public static boolean z(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.a.z((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.a.z((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean z(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public pf(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.g = signatureArr;
        this.dl = i;
        this.f515a = arraySet;
        this.gc = signatureArr2;
        this.m = iArr;
    }

    public pf(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) throws CertificateException {
        this(signatureArr, i, z(signatureArr), signatureArr2, iArr);
    }

    public pf(Signature[] signatureArr, int i) throws CertificateException {
        this(signatureArr, i, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pf)) {
            return false;
        }
        pf pfVar = (pf) obj;
        if (this.dl != pfVar.dl || !z(this.g, pfVar.g)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.f515a;
        if (arraySet != null) {
            if (!arraySet.equals(pfVar.f515a)) {
                return false;
            }
        } else if (pfVar.f515a != null) {
            return false;
        }
        return Arrays.equals(this.gc, pfVar.gc) && Arrays.equals(this.m, pfVar.m);
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.g) * 31) + this.dl) * 31;
        ArraySet<PublicKey> arraySet = this.f515a;
        return ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.gc)) * 31) + Arrays.hashCode(this.m);
    }
}
