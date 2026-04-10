package com.baidu.tts.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AInterceptor implements IInterceptor {
    protected List<String> mInterceptMethods = new ArrayList();

    public AInterceptor() {
        registerInterceptMethods();
    }

    private boolean canIntercept(String str) {
        return this.mInterceptMethods.contains(str);
    }

    @Override // com.baidu.tts.aop.IInterceptor
    public Object after(Object obj, Method method, Object[] objArr, Object obj2) {
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.IInterceptor
    public Object before(Object obj, Method method, Object[] objArr) {
        return canIntercept(method.getName()) ? handleBefore(obj, method, objArr) : AInterceptorHandler.DEFAULT;
    }

    protected abstract Object handleBefore(Object obj, Method method, Object[] objArr);

    protected abstract void registerInterceptMethods();
}
