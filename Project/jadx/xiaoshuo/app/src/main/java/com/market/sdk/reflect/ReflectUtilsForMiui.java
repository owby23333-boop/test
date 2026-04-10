package com.market.sdk.reflect;

import com.alibaba.android.arouter.utils.Consts;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes7.dex */
public class ReflectUtilsForMiui {
    public static final String OBJECT_CONSTRUCTOR = "<init>";
    private static final String SURROUNDING_THIS_POINTER = "this$0";
    private static Class<?>[] PRIMITIVE_CLASSES = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
    private static String[] SIGNATURE_OF_PRIMTIVE_CLASSES = {Field.BOOLEAN_SIGNATURE_PRIMITIVE, "B", "C", "S", Field.INT_SIGNATURE_PRIMITIVE, Field.LONG_SIGNATURE_PRIMITIVE, Field.FLOAT_SIGNATURE_PRIMITIVE, "D", "V"};
    private static final WeakHashMap<Object, HashMap<String, Object>> sAdditionalFields = new WeakHashMap<>();

    public ReflectUtilsForMiui() throws InstantiationException {
        throw new InstantiationException("Cannot instantiate utility class");
    }

    public static Object getAdditionalField(Object obj, String str) {
        Object obj2;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (str == null) {
            throw new NullPointerException("fieldName must not be null");
        }
        WeakHashMap<Object, HashMap<String, Object>> weakHashMap = sAdditionalFields;
        synchronized (weakHashMap) {
            HashMap<String, Object> map = weakHashMap.get(obj);
            if (map == null) {
                return null;
            }
            synchronized (map) {
                obj2 = map.get(str);
            }
            return obj2;
        }
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

    public static Object getSurroundingThis(Object obj) throws java.lang.NoSuchFieldException {
        return Field.of(obj.getClass(), SURROUNDING_THIS_POINTER, getSignature(obj.getClass())).get(obj);
    }

    public static Object removeAdditionalField(Object obj, String str) {
        Object objRemove;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (str == null) {
            throw new NullPointerException("fieldName must not be null");
        }
        WeakHashMap<Object, HashMap<String, Object>> weakHashMap = sAdditionalFields;
        synchronized (weakHashMap) {
            HashMap<String, Object> map = weakHashMap.get(obj);
            if (map == null) {
                return null;
            }
            synchronized (map) {
                objRemove = map.remove(str);
            }
            return objRemove;
        }
    }

    public static Object setAdditionalField(Object obj, String str, Object obj2) {
        HashMap<String, Object> map;
        Object objPut;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (str == null) {
            throw new NullPointerException("fieldName must not be null");
        }
        WeakHashMap<Object, HashMap<String, Object>> weakHashMap = sAdditionalFields;
        synchronized (weakHashMap) {
            map = weakHashMap.get(obj);
            if (map == null) {
                map = new HashMap<>();
                weakHashMap.put(obj, map);
            }
        }
        synchronized (map) {
            objPut = map.put(str, obj2);
        }
        return objPut;
    }

    public static void updateField(Class<?> cls, Object obj, Object obj2, Object obj3) throws IllegalArgumentException {
        if (cls == null && obj == null) {
            throw new IllegalArgumentException("clazz and holder cannot be all null");
        }
        if (cls == null) {
            cls = obj.getClass();
        }
        while (cls != null) {
            for (java.lang.reflect.Field field : cls.getDeclaredFields()) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) == obj2) {
                        field.set(obj, obj3);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            cls = cls.getSuperclass();
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

    public static String getSignature(Class<?>[] clsArr, Class<?> cls) {
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
}
