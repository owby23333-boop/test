package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public final class h1 {
    static String g;
    static String z;

    public static synchronized String g(Context context) {
        TelephonyManager telephonyManager;
        String str = z;
        if (str != null) {
            return q1.z(str);
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            throw new NullPointerException("null TM");
        }
        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.z("676574537562736372696265724964")), new Class[0]);
        declaredMethod.setAccessible(true);
        g = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
        return q1.z(g);
    }

    public static synchronized String z(Context context) {
        TelephonyManager telephonyManager;
        String str = z;
        if (str != null) {
            return q1.z(str);
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            throw new NullPointerException("null TM");
        }
        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbla.z("6765744465766963654964")), new Class[0]);
        declaredMethod.setAccessible(true);
        z = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
        return q1.z(z);
    }
}
