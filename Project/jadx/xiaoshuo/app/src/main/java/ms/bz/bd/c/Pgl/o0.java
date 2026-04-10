package ms.bz.bd.c.Pgl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.xiaomi.onetrack.api.at;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes9.dex */
public class o0 {
    static String bf;
    static String e;

    @SuppressLint({"MissingPermission"})
    public static synchronized String bf(Context context) {
        TelephonyManager telephonyManager;
        String str = e;
        if (str != null) {
            return n1.e(str);
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService(at.d);
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            throw new NullPointerException("null TM");
        }
        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbly.e("676574537562736372696265724964")), new Class[0]);
        declaredMethod.setAccessible(true);
        bf = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
        return n1.e(bf);
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String e(Context context) {
        TelephonyManager telephonyManager;
        String str = e;
        if (str != null) {
            return n1.e(str);
        }
        try {
            telephonyManager = (TelephonyManager) context.getSystemService(at.d);
        } catch (Throwable unused) {
        }
        if (telephonyManager == null) {
            throw new NullPointerException("null TM");
        }
        Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbly.e("6765744465766963654964")), new Class[0]);
        declaredMethod.setAccessible(true);
        e = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
        return n1.e(e);
    }
}
