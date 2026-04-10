package com.baidu.tts.aop.tts;

import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;
import com.baidu.tts.state.tts.Tts;
import com.baidu.tts.tools.ResourceTools;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ArgsCheckInterceptor extends AInterceptor {
    private static final String TAG = "ArgsCheckInterceptor";

    private void notifyError(Object obj, ResponseBag responseBag) {
        TtsListener ttsListener = ((Tts) obj).getTtsListener();
        if (ttsListener != null) {
            ttsListener.onError(responseBag);
        }
    }

    private Object simpleNotifyError(Object obj, TextParams textParams, TtsErrorEnum ttsErrorEnum) {
        ResponseBag responseBagNewResponseBag = ResponseBag.newResponseBag(textParams);
        responseBagNewResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(ttsErrorEnum));
        notifyError(obj, responseBagNewResponseBag);
        return AInterceptorHandler.END;
    }

    @Override // com.baidu.tts.aop.AInterceptor
    protected Object handleBefore(Object obj, Method method, Object[] objArr) {
        TextParams textParams = (TextParams) objArr[0];
        String text = textParams.getText();
        LoggerProxy.d(TAG, "text=" + text);
        return ResourceTools.isTextValid(text) == null ? AInterceptorHandler.DEFAULT : simpleNotifyError(obj, textParams, TtsErrorEnum.TEXT_IS_TOO_LONG);
    }

    @Override // com.baidu.tts.aop.AInterceptor
    protected void registerInterceptMethods() {
        this.mInterceptMethods.add("speak");
        this.mInterceptMethods.add("synthesize");
    }
}
