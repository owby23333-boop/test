package com.yxcorp.kuaishou.addfp.android.b;

import android.content.Context;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static File a(Context context, boolean z2) {
        Method method;
        Method method2;
        Object objInvoke;
        int length;
        int i2;
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method3 = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            method = cls.getMethod("getPath", new Class[0]);
            method2 = cls.getMethod("isRemovable", new Class[0]);
            objInvoke = method3.invoke(storageManager, new Object[0]);
            length = Array.getLength(objInvoke);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        for (i2 = 0; i2 < length; i2++) {
            Object obj = Array.get(objInvoke, i2);
            String str = (String) method.invoke(obj, new Object[0]);
            if (z2 == ((Boolean) method2.invoke(obj, new Object[0])).booleanValue() && !TextUtils.isEmpty(str)) {
                return new File(str);
            }
            return Environment.getExternalStorageDirectory();
        }
        return Environment.getExternalStorageDirectory();
    }

    private static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr3[i2] = (byte) i2;
        }
        if (bArr2.length == 0) {
            bArr3 = null;
        } else {
            int length = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < 256; i4++) {
                i3 = ((bArr2[length] & 255) + (bArr3[i4] & 255) + i3) & 255;
                byte b = bArr3[i4];
                bArr3[i4] = bArr3[i3];
                bArr3[i3] = b;
                length = (length + 1) % bArr2.length;
            }
        }
        byte[] bArr4 = new byte[bArr.length];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < bArr.length; i7++) {
            i5 = (i5 + 1) & 255;
            i6 = ((bArr3[i5] & 255) + i6) & 255;
            byte b2 = bArr3[i5];
            bArr3[i5] = bArr3[i6];
            bArr3[i6] = b2;
            int i8 = ((bArr3[i5] & 255) + (bArr3[i6] & 255)) & 255;
            bArr4[i7] = (byte) (bArr3[i8] ^ bArr[i7]);
            bArr4[i7] = (byte) (bArr4[i7] ^ 42);
        }
        return bArr4;
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] bArrA = a(bArr, bArr2);
                    if (bArrA != null) {
                        if (bArrA.length > 0) {
                        }
                    }
                    return bArrA;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr2 != null) {
            try {
                if (bArr2.length > 0 && bArr != null && bArr.length > 0) {
                    byte[] bArrA = a(bArr, bArr2);
                    if (bArrA != null) {
                        if (bArrA.length > 0) {
                        }
                    }
                    return bArrA;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
