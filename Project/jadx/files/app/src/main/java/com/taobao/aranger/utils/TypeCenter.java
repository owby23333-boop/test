package com.taobao.aranger.utils;

import android.text.TextUtils;
import com.taobao.aranger.core.wrapper.BaseWrapper;
import com.taobao.aranger.core.wrapper.MethodWrapper;
import com.taobao.aranger.exception.IPCException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class TypeCenter {
    private static volatile TypeCenter sInstance;
    private final ConcurrentHashMap<String, Class<?>> mRawClassMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Method>> mRawMethodMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Constructor<?>> mRawConstructorMap = new ConcurrentHashMap<>();

    private TypeCenter() {
    }

    private Class<?>[] getClassTypes(String[] strArr) throws IPCException {
        if (strArr == null) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[strArr.length];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            clsArr[i2] = getClassType(strArr[i2]);
        }
        return clsArr;
    }

    public static TypeCenter getInstance() {
        if (sInstance == null) {
            synchronized (TypeCenter.class) {
                if (sInstance == null) {
                    sInstance = new TypeCenter();
                }
            }
        }
        return sInstance;
    }

    public Class<?> getClassType(String str) throws IPCException {
        Class<?> cls;
        Class<?> cls2 = this.mRawClassMap.get(str);
        if (cls2 != null) {
            return cls2;
        }
        switch (str) {
            case "boolean":
                cls = Boolean.TYPE;
                break;
            case "byte":
                cls = Byte.TYPE;
                break;
            case "char":
                cls = Character.TYPE;
                break;
            case "short":
                cls = Short.TYPE;
                break;
            case "int":
                cls = Integer.TYPE;
                break;
            case "long":
                cls = Long.TYPE;
                break;
            case "float":
                cls = Float.TYPE;
                break;
            case "double":
                cls = Double.TYPE;
                break;
            case "void":
                cls = Void.TYPE;
                break;
            default:
                try {
                    cls = Class.forName(str);
                    break;
                } catch (ClassNotFoundException e2) {
                    throw new IPCException(21, e2);
                }
                break;
        }
        this.mRawClassMap.putIfAbsent(str, cls);
        return cls;
    }

    Constructor getConstructor(String str) {
        if (this.mRawConstructorMap.containsKey(str)) {
            return this.mRawConstructorMap.get(str);
        }
        return null;
    }

    public Method getMethod(Class<?> cls, MethodWrapper methodWrapper) throws IPCException {
        String methodId = TypeUtils.getMethodId(methodWrapper.getName(), methodWrapper.getParameterTypes());
        ConcurrentHashMap<String, Method> concurrentHashMap = this.mRawMethodMap.get(cls.getName()) == null ? new ConcurrentHashMap<>() : this.mRawMethodMap.get(cls.getName());
        Method method = concurrentHashMap.get(methodId);
        if (method != null) {
            return method;
        }
        Method method2 = TypeUtils.getMethod(cls, methodId.substring(0, methodId.indexOf(40)), getClassTypes(methodWrapper.getParameterTypes()), getClassType(methodWrapper.getReturnType()));
        if (method2 != null) {
            concurrentHashMap.putIfAbsent(methodId, method2);
            this.mRawMethodMap.putIfAbsent(cls.getName(), concurrentHashMap);
            return method2;
        }
        throw new IPCException(12, "Method not found: " + methodId + " in class " + cls.getName());
    }

    void registerConstructor(String str, Constructor constructor) {
        this.mRawConstructorMap.putIfAbsent(str, constructor);
    }

    public Class<?> getClassType(BaseWrapper baseWrapper) throws IPCException {
        String name = baseWrapper.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        return getClassType(name);
    }
}
