package com.baidu.tts.aop;

import com.baidu.tts.factory.IFactory;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IProxyFactory<T> extends IFactory {
    IInterceptorHandler createInterceptorHandler();

    List<IInterceptor> createInterceptors();

    T createProxied();

    T makeProxy();
}
