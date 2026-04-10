package com.baidu.tts.aop;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AInterceptorHandler implements IInterceptorHandler {
    public static final Object DEFAULT = 0;
    public static final Object END = 1;
    private static final String TAG = "AInterceptorHandler";
    protected List<IInterceptor> mInterceptors;
    protected List<String> mMethodNames = new ArrayList();
    protected Object mProxiedObj;

    protected Object afterInvoke(Object obj, Method method, Object[] objArr, Object obj2) {
        Object objAfter = DEFAULT;
        for (int size = this.mInterceptors.size() - 1; size >= 0; size--) {
            objAfter = this.mInterceptors.get(size).after(obj, method, objArr, obj2);
        }
        return objAfter;
    }

    protected Object beforeInvoke(Object obj, Method method, Object[] objArr) {
        Object objBefore = DEFAULT;
        int size = this.mInterceptors.size();
        for (int i2 = 0; i2 < size; i2++) {
            objBefore = this.mInterceptors.get(i2).before(obj, method, objArr);
            if (objBefore.equals(END)) {
                return objBefore;
            }
        }
        return objBefore;
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public Object bind(Object obj, List<IInterceptor> list) {
        this.mProxiedObj = obj;
        this.mInterceptors = list;
        Class<?> cls = this.mProxiedObj.getClass();
        Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
        LoggerProxy.d(TAG, "proxy=" + objNewProxyInstance);
        return objNewProxyInstance;
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public boolean canIntercept(String str) {
        return this.mMethodNames.contains(str);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (!canIntercept(method.getName())) {
            return method.invoke(this.mProxiedObj, objArr);
        }
        if (beforeInvoke(this.mProxiedObj, method, objArr).equals(END)) {
            return null;
        }
        Object objInvoke = method.invoke(this.mProxiedObj, objArr);
        LoggerProxy.d(TAG, "afterResult=" + afterInvoke(this.mProxiedObj, method, objArr, objInvoke));
        return objInvoke;
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void registerMethod(String str) {
        if (str != null) {
            this.mMethodNames.add(str);
        }
    }

    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void unregisterMethod(String str) {
        if (str != null) {
            this.mMethodNames.remove(str);
        }
    }
}
