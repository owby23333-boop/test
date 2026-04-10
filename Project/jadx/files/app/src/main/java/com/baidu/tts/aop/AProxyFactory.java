package com.baidu.tts.aop;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AProxyFactory<T> implements IProxyFactory<T> {
    @Override // com.baidu.tts.aop.IProxyFactory
    public T makeProxy() {
        T tCreateProxied = createProxied();
        IInterceptorHandler iInterceptorHandlerCreateInterceptorHandler = createInterceptorHandler();
        List<IInterceptor> listCreateInterceptors = createInterceptors();
        return (iInterceptorHandlerCreateInterceptorHandler == null || listCreateInterceptors == null) ? tCreateProxied : (T) iInterceptorHandlerCreateInterceptorHandler.bind(tCreateProxied, listCreateInterceptors);
    }
}
