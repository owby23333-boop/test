package miuix.reflect;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class ReflectionHelper {
    private static Class<?>[] PRIMITIVE_CLASSES;
    static HashMap<String, Class<?>> PRIMITIVE_TYPE;
    private static String[] SIGNATURE_OF_PRIMTIVE_CLASSES;
    private static Map<String, Constructor> sConstructorCache;
    private static Map<String, Field> sFieldCache;
    private static Method sForNameMethod;
    private static Method sGetDeclaredConstructorMethod;
    private static Method sGetDeclaredFieldMethod;
    private static Method sGetDeclaredMethodMethod;
    private static Method sGetMethod;
    private static Method sInvokeMethod;
    private static Map<String, Method> sMethodCache;
    private static Method sNewInstanceMethod;
    private static Method sSetAccessibleMethod;
    private static Method sSetMethod;

    static {
        HashMap<String, Class<?>> map = new HashMap<>();
        PRIMITIVE_TYPE = map;
        map.put("byte", Byte.TYPE);
        PRIMITIVE_TYPE.put("short", Short.TYPE);
        HashMap<String, Class<?>> map2 = PRIMITIVE_TYPE;
        Class<?> cls = Integer.TYPE;
        map2.put("int", cls);
        HashMap<String, Class<?>> map3 = PRIMITIVE_TYPE;
        Class<?> cls2 = Long.TYPE;
        map3.put("long", cls2);
        PRIMITIVE_TYPE.put("char", Character.TYPE);
        HashMap<String, Class<?>> map4 = PRIMITIVE_TYPE;
        Class<?> cls3 = Boolean.TYPE;
        map4.put(TypedValues.Custom.S_BOOLEAN, cls3);
        HashMap<String, Class<?>> map5 = PRIMITIVE_TYPE;
        Class<?> cls4 = Float.TYPE;
        map5.put("float", cls4);
        PRIMITIVE_TYPE.put("double", Double.TYPE);
        PRIMITIVE_TYPE.put("byte[]", byte[].class);
        PRIMITIVE_TYPE.put("short[]", short[].class);
        PRIMITIVE_TYPE.put("int[]", int[].class);
        PRIMITIVE_TYPE.put("long[]", long[].class);
        PRIMITIVE_TYPE.put("char[]", char[].class);
        PRIMITIVE_TYPE.put("boolean[]", boolean[].class);
        PRIMITIVE_TYPE.put("float[]", float[].class);
        PRIMITIVE_TYPE.put("double[]", double[].class);
        PRIMITIVE_CLASSES = new Class[]{cls3, Byte.TYPE, Character.TYPE, Short.TYPE, cls, cls2, cls4, Double.TYPE, Void.TYPE};
        SIGNATURE_OF_PRIMTIVE_CLASSES = new String[]{com.market.sdk.reflect.Field.BOOLEAN_SIGNATURE_PRIMITIVE, "B", "C", "S", com.market.sdk.reflect.Field.INT_SIGNATURE_PRIMITIVE, com.market.sdk.reflect.Field.LONG_SIGNATURE_PRIMITIVE, com.market.sdk.reflect.Field.FLOAT_SIGNATURE_PRIMITIVE, "D", "V"};
        sMethodCache = new HashMap();
        sFieldCache = new HashMap();
        sConstructorCache = new HashMap();
        sInvokeMethod = null;
        sGetDeclaredFieldMethod = null;
        sGetDeclaredMethodMethod = null;
        sSetAccessibleMethod = null;
        sGetDeclaredConstructorMethod = null;
        sNewInstanceMethod = null;
        sForNameMethod = null;
        sSetMethod = null;
        sGetMethod = null;
    }

    private static Class forNameInternal(String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sForNameMethod == null) {
            sForNameMethod = Class.class.getMethod("forName", String.class);
        }
        return (Class) sForNameMethod.invoke(null, str);
    }

    private static String generateConstructorCacheKey(Class<?> cls, Class<?>... clsArr) {
        return cls.toString() + "/" + Arrays.toString(clsArr);
    }

    private static String generateFieldCacheKey(Class<?> cls, String str) {
        return cls.toString() + "/" + str;
    }

    private static String generateMethodCacheKey(Class<?> cls, String str, Class<?>[] clsArr) {
        return cls.toString() + "/" + str + "/" + Arrays.toString(clsArr);
    }

    public static Class<?> getClass(String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return forNameInternal(str);
    }

    public static Constructor getConstructor(Class<?> cls, Class<?>... clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String strGenerateConstructorCacheKey = generateConstructorCacheKey(cls, clsArr);
        Constructor constructor = sConstructorCache.get(strGenerateConstructorCacheKey);
        if (constructor != null) {
            return constructor;
        }
        Constructor declaredConstructorInternal = getDeclaredConstructorInternal(cls, clsArr);
        setAccessibleInternal(declaredConstructorInternal, true);
        sConstructorCache.put(strGenerateConstructorCacheKey, declaredConstructorInternal);
        return declaredConstructorInternal;
    }

    public static <T> T getConstructorInstance(Class<?> cls, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Constructor constructor = getConstructor(cls, clsArr);
        if (constructor == null) {
            return null;
        }
        return (T) newInstanceInternal(constructor, objArr);
    }

    private static Constructor getDeclaredConstructorInternal(Object obj, Class<?>... clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sGetDeclaredConstructorMethod == null) {
            sGetDeclaredConstructorMethod = Class.class.getMethod("getDeclaredConstructor", Class[].class);
        }
        return (Constructor) sGetDeclaredConstructorMethod.invoke(obj, clsArr);
    }

    private static Field getDeclaredFieldInternal(Object obj, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sGetDeclaredFieldMethod == null) {
            sGetDeclaredFieldMethod = Class.class.getMethod("getDeclaredField", String.class);
        }
        return (Field) sGetDeclaredFieldMethod.invoke(obj, str);
    }

    private static Method getDeclaredMethodInternal(Object obj, String str, Class<?>... clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sGetDeclaredMethodMethod == null) {
            sGetDeclaredMethodMethod = Class.class.getMethod("getDeclaredMethod", String.class, Class[].class);
        }
        return (Method) sGetDeclaredMethodMethod.invoke(obj, str, clsArr);
    }

    public static Object getEnumConstant(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return Enum.valueOf(Class.forName(str), str2);
            } catch (ClassCastException | ClassNotFoundException | IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public static Field getField(Class<?> cls, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String strGenerateFieldCacheKey = generateFieldCacheKey(cls, str);
        Field field = sFieldCache.get(strGenerateFieldCacheKey);
        if (field != null) {
            return field;
        }
        Field declaredFieldInternal = getDeclaredFieldInternal(cls, str);
        setAccessibleInternal(declaredFieldInternal, true);
        sFieldCache.put(strGenerateFieldCacheKey, declaredFieldInternal);
        return declaredFieldInternal;
    }

    public static <T> T getFieldValue(Class<?> cls, Object obj, String str) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field field = getField(cls, str);
        if (field == null) {
            return null;
        }
        return (T) getInternal(field, obj);
    }

    private static Object getInternal(Object obj, Object obj2) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sGetMethod == null) {
            sGetMethod = Field.class.getMethod("get", Object.class);
        }
        return sGetMethod.invoke(obj, obj2);
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String strGenerateMethodCacheKey = generateMethodCacheKey(cls, str, clsArr);
        Method method = sMethodCache.get(strGenerateMethodCacheKey);
        if (method != null) {
            return method;
        }
        Method declaredMethodInternal = getDeclaredMethodInternal(cls, str, clsArr);
        setAccessibleInternal(declaredMethodInternal, true);
        sMethodCache.put(strGenerateMethodCacheKey, declaredMethodInternal);
        return declaredMethodInternal;
    }

    public static String getMethodSignature(Class<?> cls, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        if (clsArr != null) {
            for (Class<?> cls2 : clsArr) {
                sb.append(getSignature(cls2));
            }
        }
        sb.append(')');
        sb.append(getSignature(cls));
        return sb.toString();
    }

    public static String getSignature(Class<?> cls) {
        int i = 0;
        while (true) {
            Class<?>[] clsArr = PRIMITIVE_CLASSES;
            if (i >= clsArr.length) {
                return getSignature(cls.getName());
            }
            if (cls == clsArr[i]) {
                return SIGNATURE_OF_PRIMTIVE_CLASSES[i];
            }
            i++;
        }
    }

    public static void invoke(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = getMethod(cls, str, clsArr);
        if (method != null) {
            invokeInternal(method, obj, objArr);
        }
    }

    private static Object invokeInternal(Object obj, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sInvokeMethod == null) {
            sInvokeMethod = Method.class.getMethod("invoke", Object.class, Object[].class);
        }
        return sInvokeMethod.invoke(obj, objArr);
    }

    public static <T> T invokeObject(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = getMethod(cls, str, clsArr);
        if (method != null) {
            return (T) invokeInternal(method, obj, objArr);
        }
        return null;
    }

    private static <T> T newInstanceInternal(Object obj, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sNewInstanceMethod == null) {
            sNewInstanceMethod = Constructor.class.getMethod("newInstance", Object[].class);
        }
        return (T) sNewInstanceMethod.invoke(obj, objArr);
    }

    private static void setAccessibleInternal(Object obj, boolean z) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sSetAccessibleMethod == null) {
            sSetAccessibleMethod = AccessibleObject.class.getMethod("setAccessible", Boolean.TYPE);
        }
        sSetAccessibleMethod.invoke(obj, Boolean.valueOf(z));
    }

    public static void setFieldValue(Class<?> cls, Object obj, String str, Object obj2) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field field = getField(cls, str);
        if (field != null) {
            setInternal(field, obj, obj2);
        }
    }

    private static void setInternal(Object obj, Object obj2, Object obj3) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sSetMethod == null) {
            sSetMethod = Field.class.getMethod("set", Object.class, Object.class);
        }
        sSetMethod.invoke(obj, obj2, obj3);
    }

    public static Class<?> strTypeToClass(String str) {
        try {
            return strTypeToClassThrows(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static Class<?> strTypeToClassThrows(String str) throws ClassNotFoundException {
        if (PRIMITIVE_TYPE.containsKey(str)) {
            return PRIMITIVE_TYPE.get(str);
        }
        if (!str.contains(Consts.DOT)) {
            str = "java.lang." + str;
        }
        return Class.forName(str);
    }

    public static Class<?>[] strTypesToClass(String[] strArr) throws ClassNotFoundException {
        if (strArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = strTypeToClassThrows(strArr[i]);
        }
        return clsArr;
    }

    private static String generateMethodCacheKey(Class<?> cls, String str, String str2) {
        return cls.toString() + "/" + str + "/" + str2;
    }

    public static void invoke(Class<?> cls, Object obj, String str, Class<?> cls2, Class<?>[] clsArr, Object... objArr) {
        try {
            Method method = getMethod(cls, str, getMethodSignature(cls2, clsArr), clsArr);
            if (method != null) {
                method.invoke(obj, objArr);
            }
        } catch (Exception unused) {
        }
    }

    public static String getSignature(String str) {
        int i = 0;
        while (true) {
            Class<?>[] clsArr = PRIMITIVE_CLASSES;
            if (i >= clsArr.length) {
                break;
            }
            if (clsArr[i].getName().equals(str)) {
                str = SIGNATURE_OF_PRIMTIVE_CLASSES[i];
            }
            i++;
        }
        String strReplace = str.replace(Consts.DOT, "/");
        if (strReplace.startsWith("[")) {
            return strReplace;
        }
        return "L" + strReplace + ";";
    }

    public static Method getMethod(Class<?> cls, String str, String str2, Class<?>... clsArr) {
        try {
            String strGenerateMethodCacheKey = generateMethodCacheKey(cls, str, str2);
            Method method = sMethodCache.get(strGenerateMethodCacheKey);
            if (method != null) {
                return method;
            }
            Method method2 = cls.getMethod(str, clsArr);
            sMethodCache.put(strGenerateMethodCacheKey, method2);
            return method2;
        } catch (Exception unused) {
            return null;
        }
    }
}
