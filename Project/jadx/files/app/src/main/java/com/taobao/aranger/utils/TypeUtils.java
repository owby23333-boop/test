package com.taobao.aranger.utils;

import android.content.ComponentName;
import android.text.TextUtils;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.annotation.type.ServiceName;
import com.taobao.aranger.core.ipc.provider.ARangerProvider;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeUtils {
    private TypeUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean arrayContainsAnnotation(Annotation[] annotationArr, Class<? extends Annotation> cls) {
        if (annotationArr != null && cls != null) {
            for (Annotation annotation : annotationArr) {
                if (cls.isInstance(annotation)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String basicNameConvert(java.lang.String r1) {
        /*
            int r0 = r1.hashCode()
            switch(r0) {
                case -2056817302: goto L4e;
                case -527879800: goto L44;
                case -515992664: goto L3a;
                case 155276373: goto L30;
                case 344809556: goto L26;
                case 398507100: goto L1c;
                case 398795216: goto L12;
                case 761287205: goto L8;
                default: goto L7;
            }
        L7:
            goto L58
        L8:
            java.lang.String r0 = "java.lang.Double"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L58
            r0 = 3
            goto L59
        L12:
            java.lang.String r0 = "java.lang.Long"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L58
            r0 = 2
            goto L59
        L1c:
            java.lang.String r0 = "java.lang.Byte"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L58
            r0 = 6
            goto L59
        L26:
            java.lang.String r0 = "java.lang.Boolean"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L58
            r0 = 1
            goto L59
        L30:
            java.lang.String r0 = "java.lang.Character"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L58
            r0 = 7
            goto L59
        L3a:
            java.lang.String r0 = "java.lang.Short"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L58
            r0 = 4
            goto L59
        L44:
            java.lang.String r0 = "java.lang.Float"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L58
            r0 = 5
            goto L59
        L4e:
            java.lang.String r0 = "java.lang.Integer"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L58
            r0 = 0
            goto L59
        L58:
            r0 = -1
        L59:
            switch(r0) {
                case 0: goto L72;
                case 1: goto L6f;
                case 2: goto L6c;
                case 3: goto L69;
                case 4: goto L66;
                case 5: goto L63;
                case 6: goto L60;
                case 7: goto L5d;
                default: goto L5c;
            }
        L5c:
            return r1
        L5d:
            java.lang.String r1 = "char"
            return r1
        L60:
            java.lang.String r1 = "byte"
            return r1
        L63:
            java.lang.String r1 = "float"
            return r1
        L66:
            java.lang.String r1 = "short"
            return r1
        L69:
            java.lang.String r1 = "double"
            return r1
        L6c:
            java.lang.String r1 = "long"
            return r1
        L6f:
            java.lang.String r1 = "boolean"
            return r1
        L72:
            java.lang.String r1 = "int"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.aranger.utils.TypeUtils.basicNameConvert(java.lang.String):java.lang.String");
    }

    private static boolean classAssignable(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        int length = clsArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (clsArr2[i2] != null && !primitiveMatch(clsArr[i2], clsArr2[i2]) && !clsArr[i2].isAssignableFrom(clsArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void convertObjectToArray(java.lang.String r3, java.lang.Object r4, java.lang.Object r5) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.aranger.utils.TypeUtils.convertObjectToArray(java.lang.String, java.lang.Object, java.lang.Object):void");
    }

    public static String[] convertParameterTypes(ParameterWrapper[] parameterWrapperArr) throws IPCException {
        if (parameterWrapperArr == null) {
            return new String[0];
        }
        int length = parameterWrapperArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            ParameterWrapper parameterWrapper = parameterWrapperArr[i2];
            strArr[i2] = parameterWrapper == null ? null : getClassId(parameterWrapper.getClassType());
        }
        return strArr;
    }

    public static String getClassId(Class<?> cls) {
        return cls.getName();
    }

    public static Constructor<?> getConstructor(Class<?> cls, Class<?>[] clsArr) throws IPCException {
        String constructorId = getConstructorId(cls, clsArr);
        Constructor constructor = TypeCenter.getInstance().getConstructor(constructorId);
        if (constructor != null) {
            return constructor;
        }
        for (Constructor constructor2 : cls.getConstructors()) {
            if (classAssignable(constructor2.getParameterTypes(), clsArr)) {
                if (constructor != null) {
                    throw new IPCException(15, "The class " + cls.getName() + " has too many constructors whose  parameter types match the required types.");
                }
                TypeCenter.getInstance().registerConstructor(constructorId, constructor2);
                constructor = constructor2;
            }
        }
        if (constructor != null) {
            return constructor;
        }
        throw new IPCException(16, "The class " + cls.getName() + " do not have a constructor whose  parameter types match the required types.");
    }

    private static String getConstructorId(Class cls, Class[] clsArr) {
        return cls.getSimpleName() + '(' + getMethodParameters((Class<?>[]) clsArr) + ')';
    }

    static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) throws IPCException {
        Method method = null;
        for (Method method2 : cls.getMethods()) {
            if (method2.getName().equals(str) && classAssignable(method2.getParameterTypes(), clsArr)) {
                if (method != null) {
                    throw new IPCException(14, "There are more than one method named " + str + " of the class " + cls.getName() + " matching the parameters!");
                }
                method = method2;
            }
        }
        if (method == null) {
            return null;
        }
        if (method.getReturnType() == cls2) {
            return method;
        }
        throw new IPCException(17, "The method named " + str + " of the class " + cls.getName() + " matches the parameter types but not the return type. The return type is " + method.getReturnType().getName() + " but the required type is " + cls2.getName() + ". The method in the local interface must exactly match the method in the remote class.");
    }

    public static String getMethodId(String str, ParameterWrapper[] parameterWrapperArr) {
        return str + '(' + getMethodParameters(parameterWrapperArr) + ')';
    }

    private static String getMethodParameters(ParameterWrapper[] parameterWrapperArr) {
        StringBuilder sb = new StringBuilder();
        int length = parameterWrapperArr.length;
        if (length == 0) {
            return sb.toString();
        }
        sb.append(basicNameConvert(parameterWrapperArr[0].getName()));
        for (int i2 = 1; i2 < length; i2++) {
            sb.append(",");
            sb.append(basicNameConvert(parameterWrapperArr[i2].getName()));
        }
        return sb.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getObjectArraySize(java.lang.String r2, java.lang.Object r3) {
        /*
            int r0 = r2.hashCode()
            r1 = 2891(0xb4b, float:4.051E-42)
            if (r0 == r1) goto L62
            r1 = 2904(0xb58, float:4.07E-42)
            if (r0 == r1) goto L58
            r1 = 2911(0xb5f, float:4.079E-42)
            if (r0 == r1) goto L4e
            r1 = 2894(0xb4e, float:4.055E-42)
            if (r0 == r1) goto L44
            r1 = 2895(0xb4f, float:4.057E-42)
            if (r0 == r1) goto L3a
            switch(r0) {
                case 2887: goto L30;
                case 2888: goto L26;
                case 2889: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L6c
        L1c:
            java.lang.String r0 = "[D"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L6c
            r2 = 7
            goto L6d
        L26:
            java.lang.String r0 = "[C"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L6c
            r2 = 2
            goto L6d
        L30:
            java.lang.String r0 = "[B"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L6c
            r2 = 1
            goto L6d
        L3a:
            java.lang.String r0 = "[J"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L6c
            r2 = 5
            goto L6d
        L44:
            java.lang.String r0 = "[I"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L6c
            r2 = 4
            goto L6d
        L4e:
            java.lang.String r0 = "[Z"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L6c
            r2 = 0
            goto L6d
        L58:
            java.lang.String r0 = "[S"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L6c
            r2 = 3
            goto L6d
        L62:
            java.lang.String r0 = "[F"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L6c
            r2 = 6
            goto L6d
        L6c:
            r2 = -1
        L6d:
            switch(r2) {
                case 0: goto L90;
                case 1: goto L8c;
                case 2: goto L88;
                case 3: goto L84;
                case 4: goto L80;
                case 5: goto L7c;
                case 6: goto L78;
                case 7: goto L74;
                default: goto L70;
            }
        L70:
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            int r2 = r3.length
            return r2
        L74:
            double[] r3 = (double[]) r3
            int r2 = r3.length
            return r2
        L78:
            float[] r3 = (float[]) r3
            int r2 = r3.length
            return r2
        L7c:
            long[] r3 = (long[]) r3
            int r2 = r3.length
            return r2
        L80:
            int[] r3 = (int[]) r3
            int r2 = r3.length
            return r2
        L84:
            short[] r3 = (short[]) r3
            int r2 = r3.length
            return r2
        L88:
            char[] r3 = (char[]) r3
            int r2 = r3.length
            return r2
        L8c:
            byte[] r3 = (byte[]) r3
            int r2 = r3.length
            return r2
        L90:
            boolean[] r3 = (boolean[]) r3
            int r2 = r3.length
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.aranger.utils.TypeUtils.getObjectArraySize(java.lang.String, java.lang.Object):int");
    }

    private static boolean primitiveMatch(Class<?> cls, Class<?> cls2) {
        if (!cls.isPrimitive() && !cls2.isPrimitive()) {
            return false;
        }
        if (cls == cls2) {
            return true;
        }
        if (cls.isPrimitive()) {
            return primitiveMatch(cls2, cls);
        }
        if (cls == Boolean.class && cls2 == Boolean.TYPE) {
            return true;
        }
        if (cls == Byte.class && cls2 == Byte.TYPE) {
            return true;
        }
        if (cls == Character.class && cls2 == Character.TYPE) {
            return true;
        }
        if (cls == Short.class && cls2 == Short.TYPE) {
            return true;
        }
        if (cls == Integer.class && cls2 == Integer.TYPE) {
            return true;
        }
        if (cls == Long.class && cls2 == Long.TYPE) {
            return true;
        }
        if (cls == Float.class && cls2 == Float.TYPE) {
            return true;
        }
        if (cls == Double.class && cls2 == Double.TYPE) {
            return true;
        }
        return cls == Void.class && cls2 == Void.TYPE;
    }

    public static void validateComponentName(ComponentName componentName) throws IPCException {
        if (componentName == null) {
            throw new IPCException(28, "the component name is null!");
        }
        if (TextUtils.isEmpty(componentName.getClassName()) || TextUtils.isEmpty(componentName.getPackageName())) {
            throw new IPCException(28, "the package name or provider class name in component is null!");
        }
        if (ARanger.getContext().getPackageName().equals(componentName.getPackageName())) {
            try {
                if (!ARangerProvider.class.isAssignableFrom(Class.forName(componentName.getClassName()))) {
                    throw new IPCException(20, "Only class extends ARangerProvider can be passed as the parameters.");
                }
            } catch (ClassNotFoundException unused) {
                throw new IPCException(20, "The " + componentName.getClassName() + " class not found, please check the provider class name.");
            }
        }
    }

    public static void validateServiceInterface(Class<?> cls) throws IPCException {
        if (cls == null) {
            throw new IPCException(20, "Class object is null.");
        }
        if (!cls.isInterface()) {
            throw new IPCException(20, "Only interfaces can be passed as the parameters.");
        }
        if (cls.getAnnotation(ServiceName.class) == null) {
            throw new IPCException(20, "the interfaces must have ServiceName annotation.");
        }
    }

    public static String getMethodId(String str, String[] strArr) {
        return str + '(' + getMethodParameters(strArr) + ')';
    }

    public static String[] convertParameterTypes(Class[] clsArr) {
        if (clsArr == null) {
            return new String[0];
        }
        int length = clsArr.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            Class cls = clsArr[i2];
            strArr[i2] = cls == null ? null : getClassId(cls);
        }
        return strArr;
    }

    private static String getMethodParameters(Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        int length = clsArr.length;
        if (length == 0) {
            return sb.toString();
        }
        sb.append(basicNameConvert(getClassId(clsArr[0])));
        for (int i2 = 1; i2 < length; i2++) {
            sb.append(",");
            sb.append(basicNameConvert(getClassId(clsArr[i2])));
        }
        return sb.toString();
    }

    private static String getMethodParameters(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        if (length == 0) {
            return sb.toString();
        }
        sb.append(basicNameConvert(strArr[0]));
        for (int i2 = 1; i2 < length; i2++) {
            sb.append(",");
            sb.append(basicNameConvert(strArr[i2]));
        }
        return sb.toString();
    }
}
