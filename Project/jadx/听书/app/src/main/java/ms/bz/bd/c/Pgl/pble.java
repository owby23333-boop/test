package ms.bz.bd.c.Pgl;

import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import com.google.common.base.Ascii;
import java.lang.reflect.Field;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes4.dex */
public final class pble {
    private static volatile String g = "";
    private static volatile int z = -1;

    public static String g(Context context) {
        try {
            if (g == "") {
                g = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable unused) {
        }
        return g;
    }

    public static int z(Context context) {
        if (z <= 0) {
            try {
                z = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
            }
        }
        return z;
    }

    public static Activity z() {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "41fbe3", new byte[]{36, Base64.padSymbol, 17, 4, 85, 45, 51, 94, 54, 34, 53, 125, 52, Ascii.NAK, 78, 45, 33, Ascii.EM, 35, 43, 17, 59, 7, 19, 91, 32}));
            Object objInvoke = cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "16e3d0", new byte[]{35, 33, 4, 85, 94, 41, 38, 54, 55, 119, 41, 34, Ascii.US, 83, 66, 19, 58, 5, 49, 98, 36}), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b1b05a", new byte[]{126, Ascii.DC2, Ascii.DC2, 80, 3, 96, 104, 4, 58, 101, 96}));
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "604944", new byte[]{55, 51, 82, 94, 14, 39}));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e96982", new byte[]{117, 56, 81, 68, 17, 44, 114, 1}));
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "422625", new byte[]{36, 57, 126, 69});
        }
        return null;
    }
}
