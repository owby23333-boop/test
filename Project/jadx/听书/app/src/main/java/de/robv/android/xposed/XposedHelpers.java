package de.robv.android.xposed;

import android.content.res.Resources;
import bdrfccth.b;
import dalvik.system.DexFile;
import de.robv.android.xposed.XC_MethodHook;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public final class XposedHelpers {
    private static final HashMap<String, Field> fieldCache = new HashMap<>();
    private static final HashMap<String, Method> methodCache = new HashMap<>();
    private static final HashMap<String, Constructor<?>> constructorCache = new HashMap<>();
    private static final WeakHashMap<Object, HashMap<String, Object>> additionalFields = new WeakHashMap<>();
    private static final HashMap<String, ThreadLocal<AtomicInteger>> sMethodDepth = new HashMap<>();

    public static final class ClassNotFoundError extends Error {
        private static final long serialVersionUID = -1070936889459514628L;

        public ClassNotFoundError(String str, Throwable th) {
            super(str, th);
        }

        public ClassNotFoundError(Throwable th) {
            super(th);
        }
    }

    public static final class InvocationTargetError extends Error {
        private static final long serialVersionUID = -1070936889459514628L;

        public InvocationTargetError(Throwable th) {
            super(th);
        }
    }

    private XposedHelpers() {
    }

    public static byte[] assetAsByteArray(Resources resources, String str) {
        return inputStreamToByteArray(resources.getAssets().open(str));
    }

    public static Object callMethod(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return findMethodBestMatch(obj.getClass(), str, clsArr, objArr).invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new InvocationTargetError(e3.getCause());
        }
    }

    public static Object callMethod(Object obj, String str, Object... objArr) {
        try {
            return findMethodBestMatch(obj.getClass(), str, objArr).invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new InvocationTargetError(e3.getCause());
        }
    }

    public static Object callStaticMethod(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            return findMethodBestMatch(cls, str, clsArr, objArr).invoke(null, objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new InvocationTargetError(e3.getCause());
        }
    }

    public static Object callStaticMethod(Class<?> cls, String str, Object... objArr) {
        try {
            return findMethodBestMatch(cls, str, objArr).invoke(null, objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new InvocationTargetError(e3.getCause());
        }
    }

    public static void closeSilently(DexFile dexFile) {
        if (dexFile != null) {
            try {
                dexFile.close();
            } catch (IOException e) {
            }
        }
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static void closeSilently(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
            }
        }
    }

    public static int decrementMethodDepth(String str) {
        return getMethodDepthCounter(str).get().decrementAndGet();
    }

    public static boolean fileContains(File file, String str) throws Throwable {
        String line;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            do {
                try {
                    line = bufferedReader2.readLine();
                    if (line == null) {
                        closeSilently(bufferedReader2);
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    closeSilently(bufferedReader);
                    throw th;
                }
            } while (!line.contains(str));
            closeSilently(bufferedReader2);
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(Class<?> cls, Object... objArr) {
        if (objArr.length == 0 || !(objArr[objArr.length - 1] instanceof XC_MethodHook)) {
            throw new IllegalArgumentException("no callback defined");
        }
        return XposedBridge.hookMethod(findConstructorExact(cls, getParameterClasses(cls.getClassLoader(), objArr)), (XC_MethodHook) objArr[objArr.length - 1]);
    }

    public static XC_MethodHook.Unhook findAndHookConstructor(String str, ClassLoader classLoader, Object... objArr) {
        return findAndHookConstructor(findClass(str, classLoader), objArr);
    }

    public static XC_MethodHook.Unhook findAndHookMethod(Class<?> cls, String str, Object... objArr) {
        if (objArr.length == 0 || !(objArr[objArr.length - 1] instanceof XC_MethodHook)) {
            throw new IllegalArgumentException("no callback defined");
        }
        return XposedBridge.hookMethod(findMethodExact(cls, str, getParameterClasses(cls.getClassLoader(), objArr)), (XC_MethodHook) objArr[objArr.length - 1]);
    }

    public static XC_MethodHook.Unhook findAndHookMethod(String str, ClassLoader classLoader, String str2, Object... objArr) {
        return findAndHookMethod(findClass(str, classLoader), str2, objArr);
    }

    public static Class<?> findClass(String str, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = XposedBridge.BOOTCLASSLOADER;
        }
        try {
            return b.a(str, classLoader);
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundError(e);
        }
    }

    public static Class<?> findClassIfExists(String str, ClassLoader classLoader) {
        try {
            return findClass(str, classLoader);
        } catch (ClassNotFoundError e) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Constructor<?> findConstructorBestMatch(java.lang.Class<?> r8, java.lang.Class<?>... r9) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r8.getName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = getParametersString(r9)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "#bestmatch"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r1 = de.robv.android.xposed.XposedHelpers.constructorCache
            boolean r2 = r1.containsKey(r0)
            if (r2 == 0) goto L36
            java.lang.Object r8 = r1.get(r0)
            java.lang.reflect.Constructor r8 = (java.lang.reflect.Constructor) r8
            if (r8 == 0) goto L30
            return r8
        L30:
            java.lang.NoSuchMethodError r8 = new java.lang.NoSuchMethodError
            r8.<init>(r0)
            throw r8
        L36:
            java.lang.reflect.Constructor r2 = findConstructorExact(r8, r9)     // Catch: java.lang.NoSuchMethodError -> L3e
            r1.put(r0, r2)     // Catch: java.lang.NoSuchMethodError -> L3e
            return r2
        L3e:
            r1 = move-exception
            java.lang.reflect.Constructor[] r8 = r8.getDeclaredConstructors()
            int r1 = r8.length
            r2 = 0
            r3 = 0
            r4 = r2
        L47:
            if (r3 >= r1) goto L6f
            r5 = r8[r3]
            java.lang.Class[] r6 = r5.getParameterTypes()
            boolean r6 = bdrfccth.b.a(r9, r6)
            if (r6 == 0) goto L6c
            if (r4 == 0) goto L6b
            java.lang.Class[] r6 = r5.getParameterTypes()
            java.lang.Class[] r7 = r4.getParameterTypes()
            float r6 = ouffkkj.a.a(r9, r6)
            float r7 = ouffkkj.a.a(r9, r7)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L6c
        L6b:
            r4 = r5
        L6c:
            int r3 = r3 + 1
            goto L47
        L6f:
            if (r4 == 0) goto L7b
            r8 = 1
            r4.setAccessible(r8)
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r8 = de.robv.android.xposed.XposedHelpers.constructorCache
            r8.put(r0, r4)
            return r4
        L7b:
            java.lang.NoSuchMethodError r8 = new java.lang.NoSuchMethodError
            r8.<init>(r0)
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r9 = de.robv.android.xposed.XposedHelpers.constructorCache
            r9.put(r0, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: de.robv.android.xposed.XposedHelpers.findConstructorBestMatch(java.lang.Class, java.lang.Class[]):java.lang.reflect.Constructor");
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> cls, Class<?>[] clsArr, Object[] objArr) {
        Class<?>[] parameterTypes = null;
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr[i] == null) {
                if (parameterTypes == null) {
                    parameterTypes = getParameterTypes(objArr);
                }
                clsArr[i] = parameterTypes[i];
            }
        }
        return findConstructorBestMatch(cls, clsArr);
    }

    public static Constructor<?> findConstructorBestMatch(Class<?> cls, Object... objArr) {
        return findConstructorBestMatch(cls, getParameterTypes(objArr));
    }

    public static Constructor<?> findConstructorExact(Class<?> cls, Class<?>... clsArr) {
        String str = cls.getName() + getParametersString(clsArr) + "#exact";
        HashMap<String, Constructor<?>> map = constructorCache;
        if (map.containsKey(str)) {
            Constructor<?> constructor = map.get(str);
            if (constructor != null) {
                return constructor;
            }
            throw new NoSuchMethodError(str);
        }
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            map.put(str, declaredConstructor);
            return declaredConstructor;
        } catch (NoSuchMethodException e) {
            constructorCache.put(str, null);
            throw new NoSuchMethodError(str);
        }
    }

    public static Constructor<?> findConstructorExact(Class<?> cls, Object... objArr) {
        return findConstructorExact(cls, getParameterClasses(cls.getClassLoader(), objArr));
    }

    public static Constructor<?> findConstructorExact(String str, ClassLoader classLoader, Object... objArr) {
        return findConstructorExact(findClass(str, classLoader), getParameterClasses(classLoader, objArr));
    }

    public static Constructor<?> findConstructorExactIfExists(Class<?> cls, Object... objArr) {
        try {
            return findConstructorExact(cls, objArr);
        } catch (ClassNotFoundError | NoSuchMethodError e) {
            return null;
        }
    }

    public static Constructor<?> findConstructorExactIfExists(String str, ClassLoader classLoader, Object... objArr) {
        try {
            return findConstructorExact(str, classLoader, objArr);
        } catch (ClassNotFoundError | NoSuchMethodError e) {
            return null;
        }
    }

    public static Field findField(Class<?> cls, String str) {
        String str2 = cls.getName() + '#' + str;
        HashMap<String, Field> map = fieldCache;
        if (map.containsKey(str2)) {
            Field field = map.get(str2);
            if (field != null) {
                return field;
            }
            throw new NoSuchFieldError(str2);
        }
        try {
            Field fieldFindFieldRecursiveImpl = findFieldRecursiveImpl(cls, str);
            fieldFindFieldRecursiveImpl.setAccessible(true);
            map.put(str2, fieldFindFieldRecursiveImpl);
            return fieldFindFieldRecursiveImpl;
        } catch (NoSuchFieldException e) {
            fieldCache.put(str2, null);
            throw new NoSuchFieldError(str2);
        }
    }

    public static Field findFieldIfExists(Class<?> cls, String str) {
        try {
            return findField(cls, str);
        } catch (NoSuchFieldError e) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001b, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.reflect.Field findFieldRecursiveImpl(java.lang.Class<?> r2, java.lang.String r3) throws java.lang.NoSuchFieldException {
        /*
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.NoSuchFieldException -> L5
            return r2
        L5:
            r0 = move-exception
        L6:
            java.lang.Class r2 = r2.getSuperclass()
            if (r2 == 0) goto L1b
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L1b
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.NoSuchFieldException -> L19
            return r2
        L19:
            r1 = move-exception
            goto L6
        L1b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: de.robv.android.xposed.XposedHelpers.findFieldRecursiveImpl(java.lang.Class, java.lang.String):java.lang.reflect.Field");
    }

    public static Field findFirstFieldByExactType(Class<?> cls, Class<?> cls2) {
        Class<?> superclass = cls;
        do {
            for (Field field : superclass.getDeclaredFields()) {
                if (field.getType() == cls2) {
                    field.setAccessible(true);
                    return field;
                }
            }
            superclass = superclass.getSuperclass();
        } while (superclass != null);
        throw new NoSuchFieldError("Field of type " + cls2.getName() + " in class " + cls.getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Method findMethodBestMatch(java.lang.Class<?> r12, java.lang.String r13, java.lang.Class<?>... r14) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r12.getName()
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 35
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r13)
            java.lang.String r1 = getParametersString(r14)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "#bestmatch"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r1 = de.robv.android.xposed.XposedHelpers.methodCache
            boolean r2 = r1.containsKey(r0)
            if (r2 == 0) goto L40
            java.lang.Object r12 = r1.get(r0)
            java.lang.reflect.Method r12 = (java.lang.reflect.Method) r12
            if (r12 == 0) goto L3a
            return r12
        L3a:
            java.lang.NoSuchMethodError r12 = new java.lang.NoSuchMethodError
            r12.<init>(r0)
            throw r12
        L40:
            java.lang.reflect.Method r2 = findMethodExact(r12, r13, r14)     // Catch: java.lang.NoSuchMethodError -> L48
            r1.put(r0, r2)     // Catch: java.lang.NoSuchMethodError -> L48
            return r2
        L48:
            r1 = move-exception
            r1 = 0
            r2 = 1
            r3 = r1
            r4 = r2
        L4d:
            java.lang.reflect.Method[] r5 = r12.getDeclaredMethods()
            int r6 = r5.length
            r7 = 0
            r8 = r7
        L54:
            if (r8 >= r6) goto L93
            r9 = r5[r8]
            if (r4 != 0) goto L65
            int r10 = r9.getModifiers()
            boolean r10 = java.lang.reflect.Modifier.isPrivate(r10)
            if (r10 == 0) goto L65
            goto L90
        L65:
            java.lang.String r10 = r9.getName()
            boolean r10 = r10.equals(r13)
            if (r10 == 0) goto L90
            java.lang.Class[] r10 = r9.getParameterTypes()
            boolean r10 = bdrfccth.b.a(r14, r10)
            if (r10 == 0) goto L90
            if (r3 == 0) goto L8f
            java.lang.Class[] r10 = r9.getParameterTypes()
            java.lang.Class[] r11 = r3.getParameterTypes()
            float r10 = ouffkkj.a.a(r14, r10)
            float r11 = ouffkkj.a.a(r14, r11)
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 >= 0) goto L90
        L8f:
            r3 = r9
        L90:
            int r8 = r8 + 1
            goto L54
        L93:
            java.lang.Class r12 = r12.getSuperclass()
            if (r12 != 0) goto Lb0
            if (r3 == 0) goto La5
            r3.setAccessible(r2)
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r12 = de.robv.android.xposed.XposedHelpers.methodCache
            r12.put(r0, r3)
            return r3
        La5:
            java.lang.NoSuchMethodError r12 = new java.lang.NoSuchMethodError
            r12.<init>(r0)
            java.util.HashMap<java.lang.String, java.lang.reflect.Method> r13 = de.robv.android.xposed.XposedHelpers.methodCache
            r13.put(r0, r1)
            throw r12
        Lb0:
            r4 = r7
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: de.robv.android.xposed.XposedHelpers.findMethodBestMatch(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    public static Method findMethodBestMatch(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?>[] parameterTypes = null;
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr[i] == null) {
                if (parameterTypes == null) {
                    parameterTypes = getParameterTypes(objArr);
                }
                clsArr[i] = parameterTypes[i];
            }
        }
        return findMethodBestMatch(cls, str, clsArr);
    }

    public static Method findMethodBestMatch(Class<?> cls, String str, Object... objArr) {
        return findMethodBestMatch(cls, str, getParameterTypes(objArr));
    }

    public static Method findMethodExact(Class<?> cls, String str, Class<?>... clsArr) {
        String str2 = cls.getName() + '#' + str + getParametersString(clsArr) + "#exact";
        HashMap<String, Method> map = methodCache;
        if (map.containsKey(str2)) {
            Method method = map.get(str2);
            if (method != null) {
                return method;
            }
            throw new NoSuchMethodError(str2);
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            map.put(str2, declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException e) {
            methodCache.put(str2, null);
            throw new NoSuchMethodError(str2);
        }
    }

    public static Method findMethodExact(Class<?> cls, String str, Object... objArr) {
        return findMethodExact(cls, str, getParameterClasses(cls.getClassLoader(), objArr));
    }

    public static Method findMethodExact(String str, ClassLoader classLoader, String str2, Object... objArr) {
        return findMethodExact(findClass(str, classLoader), str2, getParameterClasses(classLoader, objArr));
    }

    public static Method findMethodExactIfExists(Class<?> cls, String str, Object... objArr) {
        try {
            return findMethodExact(cls, str, objArr);
        } catch (ClassNotFoundError | NoSuchMethodError e) {
            return null;
        }
    }

    public static Method findMethodExactIfExists(String str, ClassLoader classLoader, String str2, Object... objArr) {
        try {
            return findMethodExact(str, classLoader, str2, objArr);
        } catch (ClassNotFoundError | NoSuchMethodError e) {
            return null;
        }
    }

    public static Method[] findMethodsByExactParameters(Class<?> cls, Class<?> cls2, Class<?>... clsArr) {
        LinkedList linkedList = new LinkedList();
        for (Method method : cls.getDeclaredMethods()) {
            if (cls2 == null || cls2 == method.getReturnType()) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (clsArr.length == parameterTypes.length) {
                    int i = 0;
                    while (true) {
                        if (i >= clsArr.length) {
                            method.setAccessible(true);
                            linkedList.add(method);
                            break;
                        }
                        if (clsArr[i] != parameterTypes[i]) {
                            break;
                        }
                        i++;
                    }
                }
            }
        }
        return (Method[]) linkedList.toArray(new Method[linkedList.size()]);
    }

    public static Object getAdditionalInstanceField(Object obj, String str) {
        Object obj2;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (str == null) {
            throw new NullPointerException("key must not be null");
        }
        WeakHashMap<Object, HashMap<String, Object>> weakHashMap = additionalFields;
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

    public static Object getAdditionalStaticField(Class<?> cls, String str) {
        return getAdditionalInstanceField(cls, str);
    }

    public static Object getAdditionalStaticField(Object obj, String str) {
        return getAdditionalInstanceField(obj.getClass(), str);
    }

    public static boolean getBooleanField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getBoolean(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static byte getByteField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getByte(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static char getCharField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getChar(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static Class<?>[] getClassesAsArray(Class<?>... clsArr) {
        return clsArr;
    }

    public static double getDoubleField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getDouble(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static int getFirstParameterIndexByType(Member member, Class<?> cls) {
        Class<?>[] parameterTypes = member instanceof Method ? ((Method) member).getParameterTypes() : ((Constructor) member).getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i] == cls) {
                return i;
            }
        }
        throw new NoSuchFieldError("No parameter of type " + cls + " found in " + member);
    }

    public static float getFloatField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getFloat(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static int getIntField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getInt(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static long getLongField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getLong(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static String getMD5Sum(String str) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[8192];
            while (true) {
                int i = fileInputStream.read(bArr);
                if (i <= 0) {
                    fileInputStream.close();
                    return new BigInteger(1, messageDigest.digest()).toString(16);
                }
                messageDigest.update(bArr, 0, i);
            }
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }

    public static int getMethodDepth(String str) {
        return getMethodDepthCounter(str).get().get();
    }

    private static ThreadLocal<AtomicInteger> getMethodDepthCounter(String str) {
        ThreadLocal<AtomicInteger> threadLocal;
        HashMap<String, ThreadLocal<AtomicInteger>> map = sMethodDepth;
        synchronized (map) {
            threadLocal = map.get(str);
            if (threadLocal == null) {
                threadLocal = new ThreadLocal<AtomicInteger>() { // from class: de.robv.android.xposed.XposedHelpers.1
                    @Override // java.lang.ThreadLocal
                    public AtomicInteger initialValue() {
                        return new AtomicInteger();
                    }
                };
                map.put(str, threadLocal);
            }
        }
        return threadLocal;
    }

    public static Object getObjectField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).get(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static Method getOverriddenMethod(Method method) {
        int modifiers = method.getModifiers();
        if (!Modifier.isStatic(modifiers) && !Modifier.isPrivate(modifiers)) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<? super Object> superclass = method.getDeclaringClass().getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
                try {
                    Method declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    int modifiers2 = declaredMethod.getModifiers();
                    if (!Modifier.isPrivate(modifiers2)) {
                        if (!Modifier.isAbstract(modifiers2)) {
                            return declaredMethod;
                        }
                    }
                    return null;
                } catch (NoSuchMethodException e) {
                }
            }
        }
        return null;
    }

    public static Set<Method> getOverriddenMethods(Class<?> cls) {
        HashSet hashSet = new HashSet();
        for (Method method : cls.getDeclaredMethods()) {
            Method overriddenMethod = getOverriddenMethod(method);
            if (overriddenMethod != null) {
                hashSet.add(overriddenMethod);
            }
        }
        return hashSet;
    }

    private static Class<?>[] getParameterClasses(ClassLoader classLoader, Object[] objArr) {
        Class<?>[] clsArr = null;
        for (int length = objArr.length - 1; length >= 0; length--) {
            Object obj = objArr[length];
            if (obj == null) {
                throw new ClassNotFoundError("parameter type must not be null", null);
            }
            if (!(obj instanceof XC_MethodHook)) {
                if (clsArr == null) {
                    clsArr = new Class[length + 1];
                }
                if (obj instanceof Class) {
                    clsArr[length] = (Class) obj;
                } else {
                    if (!(obj instanceof String)) {
                        throw new ClassNotFoundError("parameter type must either be specified as Class or String", null);
                    }
                    clsArr[length] = findClass((String) obj, classLoader);
                }
            }
        }
        return clsArr == null ? new Class[0] : clsArr;
    }

    public static int getParameterIndexByType(Member member, Class<?> cls) {
        Class<?>[] parameterTypes = member instanceof Method ? ((Method) member).getParameterTypes() : ((Constructor) member).getParameterTypes();
        int i = -1;
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (parameterTypes[i2] == cls) {
                if (i != -1) {
                    throw new NoSuchFieldError("More than one parameter of type " + cls + " found in " + member);
                }
                i = i2;
            }
        }
        if (i != -1) {
            return i;
        }
        throw new NoSuchFieldError("No parameter of type " + cls + " found in " + member);
    }

    public static Class<?>[] getParameterTypes(Object... objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            clsArr[i] = obj != null ? obj.getClass() : null;
        }
        return clsArr;
    }

    private static String getParametersString(Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder("(");
        boolean z = true;
        for (Class<?> cls : clsArr) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            if (cls != null) {
                sb.append(cls.getCanonicalName());
            } else {
                sb.append("null");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static short getShortField(Object obj, String str) {
        try {
            return findField(obj.getClass(), str).getShort(obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static boolean getStaticBooleanField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getBoolean(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static byte getStaticByteField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getByte(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static char getStaticCharField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getChar(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static double getStaticDoubleField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getDouble(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static float getStaticFloatField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getFloat(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static int getStaticIntField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getInt(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static long getStaticLongField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getLong(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static Object getStaticObjectField(Class<?> cls, String str) {
        try {
            return findField(cls, str).get(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static short getStaticShortField(Class<?> cls, String str) {
        try {
            return findField(cls, str).getShort(null);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static Object getSurroundingThis(Object obj) {
        return getObjectField(obj, "this$0");
    }

    public static int incrementMethodDepth(String str) {
        return getMethodDepthCounter(str).get().incrementAndGet();
    }

    public static byte[] inputStreamToByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static Object newInstance(Class<?> cls, Class<?>[] clsArr, Object... objArr) {
        try {
            return findConstructorBestMatch(cls, clsArr, objArr).newInstance(objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InstantiationException e3) {
            throw new InstantiationError(e3.getMessage());
        } catch (InvocationTargetException e4) {
            throw new InvocationTargetError(e4.getCause());
        }
    }

    public static Object newInstance(Class<?> cls, Object... objArr) {
        try {
            return findConstructorBestMatch(cls, objArr).newInstance(objArr);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (InstantiationException e3) {
            throw new InstantiationError(e3.getMessage());
        } catch (InvocationTargetException e4) {
            throw new InvocationTargetError(e4.getCause());
        }
    }

    public static Object removeAdditionalInstanceField(Object obj, String str) {
        Object objRemove;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (str == null) {
            throw new NullPointerException("key must not be null");
        }
        WeakHashMap<Object, HashMap<String, Object>> weakHashMap = additionalFields;
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

    public static Object removeAdditionalStaticField(Class<?> cls, String str) {
        return removeAdditionalInstanceField(cls, str);
    }

    public static Object removeAdditionalStaticField(Object obj, String str) {
        return removeAdditionalInstanceField(obj.getClass(), str);
    }

    public static Object setAdditionalInstanceField(Object obj, String str, Object obj2) {
        HashMap<String, Object> map;
        Object objPut;
        if (obj == null) {
            throw new NullPointerException("object must not be null");
        }
        if (str == null) {
            throw new NullPointerException("key must not be null");
        }
        WeakHashMap<Object, HashMap<String, Object>> weakHashMap = additionalFields;
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

    public static Object setAdditionalStaticField(Class<?> cls, String str, Object obj) {
        return setAdditionalInstanceField(cls, str, obj);
    }

    public static Object setAdditionalStaticField(Object obj, String str, Object obj2) {
        return setAdditionalInstanceField(obj.getClass(), str, obj2);
    }

    public static void setBooleanField(Object obj, String str, boolean z) {
        try {
            findField(obj.getClass(), str).setBoolean(obj, z);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setByteField(Object obj, String str, byte b) {
        try {
            findField(obj.getClass(), str).setByte(obj, b);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setCharField(Object obj, String str, char c) {
        try {
            findField(obj.getClass(), str).setChar(obj, c);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setDoubleField(Object obj, String str, double d) {
        try {
            findField(obj.getClass(), str).setDouble(obj, d);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setFloatField(Object obj, String str, float f) {
        try {
            findField(obj.getClass(), str).setFloat(obj, f);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setIntField(Object obj, String str, int i) {
        try {
            findField(obj.getClass(), str).setInt(obj, i);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setLongField(Object obj, String str, long j) {
        try {
            findField(obj.getClass(), str).setLong(obj, j);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setObjectField(Object obj, String str, Object obj2) {
        try {
            findField(obj.getClass(), str).set(obj, obj2);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setShortField(Object obj, String str, short s) {
        try {
            findField(obj.getClass(), str).setShort(obj, s);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticBooleanField(Class<?> cls, String str, boolean z) {
        try {
            findField(cls, str).setBoolean(null, z);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticByteField(Class<?> cls, String str, byte b) {
        try {
            findField(cls, str).setByte(null, b);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticCharField(Class<?> cls, String str, char c) {
        try {
            findField(cls, str).setChar(null, c);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticDoubleField(Class<?> cls, String str, double d) {
        try {
            findField(cls, str).setDouble(null, d);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticFloatField(Class<?> cls, String str, float f) {
        try {
            findField(cls, str).setFloat(null, f);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticIntField(Class<?> cls, String str, int i) {
        try {
            findField(cls, str).setInt(null, i);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticLongField(Class<?> cls, String str, long j) {
        try {
            findField(cls, str).setLong(null, j);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticObjectField(Class<?> cls, String str, Object obj) {
        try {
            findField(cls, str).set(null, obj);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static void setStaticShortField(Class<?> cls, String str, short s) {
        try {
            findField(cls, str).setShort(null, s);
        } catch (IllegalAccessException e) {
            XposedBridge.log(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }
}
