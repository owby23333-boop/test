package com.taobao.aranger.utils;

import android.content.Context;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.annotation.method.UIThread;
import com.taobao.aranger.annotation.parameter.WeakRef;
import com.taobao.aranger.annotation.parameter.inout;
import com.taobao.aranger.annotation.parameter.out;
import com.taobao.aranger.annotation.type.Callback;
import com.taobao.aranger.core.handler.invoc.CallbackInvocationHandler;
import com.taobao.aranger.core.ipc.provider.ClientServiceProvider;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ParameterTransformer {
    public static Object[] unWrapperParameters(ParameterWrapper[] parameterWrapperArr, List<Integer> list) throws IPCException {
        if (parameterWrapperArr == null) {
            return new Object[0];
        }
        int length = parameterWrapperArr.length;
        Object[] objArr = new Object[length];
        for (int i2 = 0; i2 < length; i2++) {
            ParameterWrapper parameterWrapper = parameterWrapperArr[i2];
            if (parameterWrapper == null) {
                objArr[i2] = null;
            } else {
                Class<?> classType = TypeCenter.getInstance().getClassType(parameterWrapper);
                if (classType != null && classType.isInterface() && classType.getAnnotation(Callback.class) != null) {
                    String[] strArrSplit = parameterWrapper.getTimeStamp().split(";");
                    String str = strArrSplit[0];
                    objArr[i2] = Proxy.newProxyInstance(classType.getClassLoader(), new Class[]{classType}, new CallbackInvocationHandler(parameterWrapper.getClientServiceBinder(), str, Integer.parseInt(strArrSplit[1])));
                    IPCRecycle.getInstance().register(parameterWrapper.getClientServiceBinder(), objArr[i2], str);
                } else if (classType == null || !Context.class.isAssignableFrom(classType)) {
                    if (parameterWrapper.getFlowFlag() != 0) {
                        list.add(Integer.valueOf(i2));
                    }
                    objArr[i2] = classType != null ? parameterWrapper.getData() : null;
                } else {
                    objArr[i2] = ARanger.getContext();
                }
            }
        }
        return objArr;
    }

    public static ParameterWrapper[] wrapperParameters(Method method, Object[] objArr) {
        if (objArr == null) {
            return new ParameterWrapper[0];
        }
        ParameterWrapper[] parameterWrapperArr = new ParameterWrapper[objArr.length];
        Class<?>[] parameterTypes = method == null ? new Class[objArr.length] : method.getParameterTypes();
        Annotation[][] parameterAnnotations = method == null ? (Annotation[][]) Array.newInstance((Class<?>) Annotation.class, objArr.length, 0) : method.getParameterAnnotations();
        Annotation[] annotations = method == null ? new Annotation[0] : method.getAnnotations();
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (parameterTypes[i2] != null && parameterTypes[i2].isInterface() && parameterTypes[i2].getAnnotation(Callback.class) != null) {
                Object obj = objArr[i2];
                String timeStamp = TimeStampGenerator.getTimeStamp();
                if (obj != null) {
                    parameterWrapperArr[i2] = ParameterWrapper.obtain().setParameterName(parameterTypes[i2].getName()).setClientServiceBinder(ClientServiceProvider.getClientService()).setTimeStamp(timeStamp + ";" + obj.hashCode());
                } else {
                    parameterWrapperArr[i2] = ParameterWrapper.obtain();
                }
                if (parameterAnnotations[i2] != null && obj != null) {
                    CallbackManager.getInstance().addCallback(timeStamp, obj, TypeUtils.arrayContainsAnnotation(parameterAnnotations[i2], WeakRef.class), TypeUtils.arrayContainsAnnotation(annotations, UIThread.class));
                }
            } else if (objArr[i2] instanceof Context) {
                parameterWrapperArr[i2] = ParameterWrapper.obtain().setParameterName(Context.class.getName());
            } else {
                boolean zArrayContainsAnnotation = TypeUtils.arrayContainsAnnotation(parameterAnnotations[i2], out.class);
                boolean zArrayContainsAnnotation2 = TypeUtils.arrayContainsAnnotation(parameterAnnotations[i2], inout.class);
                if (!zArrayContainsAnnotation && !zArrayContainsAnnotation2) {
                    parameterWrapperArr[i2] = ParameterWrapper.obtain().setData(objArr[i2]);
                } else if (zArrayContainsAnnotation2) {
                    parameterWrapperArr[i2] = ParameterWrapper.obtain().setFlowFlag(2).setData(objArr[i2]);
                } else {
                    parameterWrapperArr[i2] = ParameterWrapper.obtain().setFlowFlag(1).setData(objArr[i2]);
                }
            }
        }
        return parameterWrapperArr;
    }
}
