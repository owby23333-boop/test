package ms.bz.bd.c.Pgl;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.ArrayMap;
import com.google.common.base.Ascii;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes9.dex */
public final class pbly {
    public static long e(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[256];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                outputStream.flush();
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static Activity e() {
        try {
            Class<?> cls = Class.forName((String) pblk.a(16777217, 0, 0L, "bd4047", new byte[]{114, 104, 67, 86, 4, 41, 101, Ascii.VT, 100, 112, 99, 40, 102, 71, Ascii.US, 41, 119, 76, 113, 121, 71, 110, 85, 65, 10, 36}));
            Object objInvoke = cls.getMethod((String) pblk.a(16777217, 0, 0L, "32b07c", new byte[]{33, 37, 3, 86, Ascii.CR, 122, 36, 50, 48, 116, 43, 38, Ascii.CAN, 80, 17, 64, 56, 1, 54, 97, 38}), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField((String) pblk.a(16777217, 0, 0L, "34a279", new byte[]{47, Ascii.ETB, 17, 82, 1, 56, 57, 1, 57, 103, 49}));
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() < 1) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField((String) pblk.a(16777217, 0, 0L, "cabd3a", new byte[]{98, 98, 4, 3, 9, 114}));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField((String) pblk.a(16777217, 0, 0L, "526a1d", new byte[]{37, 51, 81, Ascii.FS, Ascii.CAN, 122, 34, 10}));
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] e(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
