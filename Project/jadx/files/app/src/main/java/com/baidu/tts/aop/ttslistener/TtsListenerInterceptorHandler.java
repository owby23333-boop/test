package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.aop.AInterceptorHandler;

/* JADX INFO: loaded from: classes2.dex */
public class TtsListenerInterceptorHandler extends AInterceptorHandler {
    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void registerMethods() {
        registerMethod("onSynthesizeDataArrived");
        registerMethod("onPlayProgressUpdate");
    }
}
