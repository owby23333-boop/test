package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class StatisticsInterceptor extends AInterceptor {
    private static final String TAG = "StatisticsInterceptor";

    @Override // com.baidu.tts.aop.AInterceptor
    protected Object handleBefore(Object obj, Method method, Object[] objArr) {
        LoggerProxy.d(TAG, "statistics");
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.AInterceptor
    protected void registerInterceptMethods() {
        this.mInterceptMethods.add("speak");
        this.mInterceptMethods.add("synthesize");
    }
}
