package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.aop.AProxyFactory;
import com.baidu.tts.aop.IInterceptor;
import com.baidu.tts.aop.IInterceptorHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TtsListenerFactory extends AProxyFactory<TtsListener> {
    private TtsListener mTtsListener;

    public TtsListenerFactory(TtsListener ttsListener) {
        this.mTtsListener = ttsListener;
    }

    @Override // com.baidu.tts.aop.IProxyFactory
    public IInterceptorHandler createInterceptorHandler() {
        TtsListenerInterceptorHandler ttsListenerInterceptorHandler = new TtsListenerInterceptorHandler();
        ttsListenerInterceptorHandler.registerMethods();
        return ttsListenerInterceptorHandler;
    }

    @Override // com.baidu.tts.aop.IProxyFactory
    public List<IInterceptor> createInterceptors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ProgressCorrectInterceptor());
        return arrayList;
    }

    @Override // com.baidu.tts.aop.IProxyFactory
    public TtsListener createProxied() {
        return this.mTtsListener;
    }
}
