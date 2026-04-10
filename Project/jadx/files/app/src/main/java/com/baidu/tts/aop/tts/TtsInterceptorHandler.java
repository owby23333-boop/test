package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptorHandler;

/* JADX INFO: loaded from: classes2.dex */
public class TtsInterceptorHandler extends AInterceptorHandler {
    @Override // com.baidu.tts.aop.IInterceptorHandler
    public void registerMethods() {
        registerMethod("speak");
        registerMethod("synthesize");
        registerMethod("setTtsListener");
    }
}
