package com.xiaomi.passport.ui.onetrack;

import com.dangdang.reader.Constants;
import com.yuewen.i60;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes8.dex */
public class SystemInfoUtils {
    public static String getMIUISystemVersion() {
        return getSystemProperty("ro.miui.ui.version.name", Constants.OTHERS);
    }

    public static String getMiOSVersion() {
        return getSystemProperty(i60.w, Constants.OTHERS);
    }

    private static String getSystemProperty(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return str2;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return str2;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return str2;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return str2;
        }
    }
}
