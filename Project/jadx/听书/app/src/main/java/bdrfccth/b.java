package bdrfccth;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import kotlin.text.Typography;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f65a;
    public static final HashMap b;
    public static final HashMap c;

    static {
        String.valueOf('.');
        String.valueOf(Typography.dollar);
        HashMap map = new HashMap();
        f65a = map;
        map.put(Boolean.TYPE, Boolean.class);
        map.put(Byte.TYPE, Byte.class);
        map.put(Character.TYPE, Character.class);
        map.put(Short.TYPE, Short.class);
        map.put(Integer.TYPE, Integer.class);
        map.put(Long.TYPE, Long.class);
        map.put(Double.TYPE, Double.class);
        map.put(Float.TYPE, Float.class);
        Class cls = Void.TYPE;
        map.put(cls, cls);
        b = new HashMap();
        for (Class cls2 : map.keySet()) {
            Class cls3 = (Class) f65a.get(cls2);
            if (!cls2.equals(cls3)) {
                b.put(cls3, cls2);
            }
        }
        HashMap map2 = new HashMap();
        c = map2;
        HashMap map3 = new HashMap();
        map2.put("int", "I");
        map3.put("I", "int");
        map2.put(TypedValues.Custom.S_BOOLEAN, "Z");
        map3.put("Z", TypedValues.Custom.S_BOOLEAN);
        map2.put(TypedValues.Custom.S_FLOAT, "F");
        map3.put("F", TypedValues.Custom.S_FLOAT);
        map2.put("long", "J");
        map3.put("J", "long");
        map2.put("short", ExifInterface.LATITUDE_SOUTH);
        map3.put(ExifInterface.LATITUDE_SOUTH, "short");
        map2.put("byte", "B");
        map3.put("B", "byte");
        map2.put("double", "D");
        map3.put("D", "double");
        map2.put("char", "C");
        map3.put("C", "char");
    }

    public static Class a(String str, ClassLoader classLoader) throws ClassNotFoundException {
        try {
            HashMap map = c;
            return map.containsKey(str) ? Class.forName("[" + ((String) map.get(str)), false, classLoader).getComponentType() : Class.forName(a(str), false, classLoader);
        } catch (ClassNotFoundException e) {
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                try {
                    return a(str.substring(0, iLastIndexOf) + Typography.dollar + str.substring(iLastIndexOf + 1), classLoader);
                } catch (ClassNotFoundException e2) {
                    throw e;
                }
            }
            throw e;
        }
    }

    public static String a(String str) {
        int i = d.f66a;
        if (str != null && str.length() != 0) {
            int length = str.length();
            char[] cArr = new char[length];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Character.isWhitespace(str.charAt(i3))) {
                    cArr[i2] = str.charAt(i3);
                    i2++;
                }
            }
            if (i2 != length) {
                str = new String(cArr, 0, i2);
            }
        }
        if (str == null) {
            throw new NullPointerException("className must not be null.");
        }
        if (!str.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        while (str.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            str = str.substring(0, str.length() - 2);
            sb.append("[");
        }
        String str2 = (String) c.get(str);
        if (str2 != null) {
            sb.append(str2);
        } else {
            sb.append("L").append(str).append(";");
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(Class cls, Class cls2, boolean z) {
        if (cls2 == 0) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive()) {
                if (cls.isPrimitive()) {
                    cls = (Class) f65a.get(cls);
                }
                if (cls == null) {
                    return false;
                }
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = (Class) b.get(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (!cls.isPrimitive()) {
            return cls2.isAssignableFrom(cls);
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        Class cls3 = Integer.TYPE;
        if (cls3.equals(cls)) {
            return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        }
        Class cls4 = Long.TYPE;
        if (cls4.equals(cls)) {
            return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
        }
        if (Boolean.TYPE.equals(cls)) {
            return false;
        }
        Class cls5 = Double.TYPE;
        if (cls5.equals(cls)) {
            return false;
        }
        Class cls6 = Float.TYPE;
        if (cls6.equals(cls)) {
            return cls5.equals(cls2);
        }
        if (Character.TYPE.equals(cls)) {
            return cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
        }
        Class cls7 = Short.TYPE;
        if (cls7.equals(cls)) {
            return cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
        }
        if (Byte.TYPE.equals(cls)) {
            return cls7.equals(cls2) || cls3.equals(cls2) || cls4.equals(cls2) || cls6.equals(cls2) || cls5.equals(cls2);
        }
        return false;
    }

    public static boolean a(Class[] clsArr, Class[] clsArr2) {
        if ((clsArr == null && clsArr2 != null && clsArr2.length > 0) || ((clsArr2 == null && clsArr != null && clsArr.length > 0) || (clsArr != null && clsArr2 != null && clsArr.length != clsArr2.length))) {
            return false;
        }
        if (clsArr == null) {
            clsArr = a.b;
        }
        if (clsArr2 == null) {
            clsArr2 = a.b;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (!a(clsArr[i], clsArr2[i], true)) {
                return false;
            }
        }
        return true;
    }
}
