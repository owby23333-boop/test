package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
final class o {
    public static final o a = new o(null, 0, null, null, null);

    @Nullable
    public final Signature[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14595c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final ArraySet<PublicKey> f14596d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Signature[] f14597e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final int[] f14598f;

    public o(Signature[] signatureArr, int i2, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.b = signatureArr;
        this.f14595c = i2;
        this.f14596d = arraySet;
        this.f14597e = signatureArr2;
        this.f14598f = iArr;
    }

    private static ArraySet<PublicKey> a(Signature[] signatureArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method methodA = com.bytedance.pangle.b.a.a.a(Signature.class, "getPublicKey", new Class[0]);
            if (methodA != null && methodA.isAccessible()) {
                try {
                    arraySet.add((PublicKey) methodA.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f14595c != oVar.f14595c || !a(this.b, oVar.b)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.f14596d;
        if (arraySet != null) {
            if (!arraySet.equals(oVar.f14596d)) {
                return false;
            }
        } else if (oVar.f14596d != null) {
            return false;
        }
        return Arrays.equals(this.f14597e, oVar.f14597e) && Arrays.equals(this.f14598f, oVar.f14598f);
    }

    public final int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.b) * 31) + this.f14595c) * 31;
        ArraySet<PublicKey> arraySet = this.f14596d;
        return ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f14597e)) * 31) + Arrays.hashCode(this.f14598f);
    }

    public o(Signature[] signatureArr, int i2, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i2, a(signatureArr), signatureArr2, iArr);
    }

    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.d.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.d.a((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }
}
