package com.bytedance.sdk.component.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    public static byte[] bf(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bitmap.getByteCount());
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static String e(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        String strEncodeToString = null;
        if (bitmap == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (Throwable unused) {
                if (byteArrayOutputStream != null) {
                }
                return strEncodeToString;
            }
        } catch (Throwable unused2) {
            byteArrayOutputStream = null;
        }
        try {
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        } catch (Throwable unused3) {
        }
        return strEncodeToString;
    }

    public static Bitmap e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Bitmap e(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (i <= 0 || i2 <= 0) {
            return bitmap;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (i < width && i2 < height) {
                Matrix matrix = new Matrix();
                matrix.postScale(i / width, i2 / height);
                return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
            }
            return bitmap;
        } catch (Throwable th) {
            wu.e(th.getMessage());
            return null;
        }
    }
}
