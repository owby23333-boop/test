package com.baidu.tts.tools;

import android.text.TextUtils;
import com.umeng.message.proguard.ad;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class SqlTool {
    public static String addPlaceholders(int i2) {
        if (i2 < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("?");
        for (int i3 = 1; i3 < i2; i3++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public static String buildConditions(String str, String... strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArr) {
            if (!StringTool.isEmpty(str2)) {
                arrayList.add(str2);
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            sb.append((String) it.next());
        }
        while (it.hasNext()) {
            String str3 = (String) it.next();
            sb.append(" " + str + " ");
            sb.append(str3);
        }
        return sb.toString();
    }

    public static String buildInCondition(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(str)) {
            return null;
        }
        return str + " in (" + addPlaceholders(strArr.length) + ad.f20406s;
    }

    private static String getField(Method method, Method method2, Object obj) {
        String result;
        String result2 = getResult(method, obj);
        if (result2 == null || (result = getResult(method2, obj)) == null) {
            return null;
        }
        return result2 + " " + result;
    }

    private static String getResult(Method method, Object obj) {
        try {
            return (String) method.invoke(obj, null);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String[] getSQLformat(String str, String[] strArr, String[] strArr2, String[] strArr3) {
        String[] strArr4 = new String[strArr.length + 1 + strArr2.length + strArr3.length];
        strArr4[0] = str;
        System.arraycopy(strArr, 0, strArr4, 1, strArr.length);
        System.arraycopy(strArr2, 0, strArr4, strArr.length + 1, strArr2.length);
        System.arraycopy(strArr3, 0, strArr4, strArr.length + 1 + strArr2.length, strArr3.length);
        return strArr4;
    }

    public static String sqlCreateTable(String str, Object[] objArr) {
        if (str != null && objArr != null) {
            Object obj = objArr[0];
            Class<?> cls = obj.getClass();
            try {
                Method supportedMethod = ReflectTool.getSupportedMethod(cls, "getColumnName", null);
                Method supportedMethod2 = ReflectTool.getSupportedMethod(cls, "getDataType", null);
                StringBuilder sb = new StringBuilder("create Table " + str);
                String field = getField(supportedMethod, supportedMethod2, obj);
                if (field != null) {
                    sb.append(" (" + field);
                    int length = objArr.length;
                    for (int i2 = 1; i2 < length; i2++) {
                        sb.append(",");
                        sb.append(getField(supportedMethod, supportedMethod2, objArr[i2]));
                    }
                    sb.append(ad.f20406s);
                    return sb.toString();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static String sqlDropTable(String str) {
        return "drop table if exists " + str;
    }
}
