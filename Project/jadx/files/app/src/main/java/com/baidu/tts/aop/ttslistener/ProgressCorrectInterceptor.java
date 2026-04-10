package com.baidu.tts.aop.ttslistener;

import android.text.TextUtils;
import com.baidu.tts.aop.AInterceptor;
import com.baidu.tts.aop.AInterceptorHandler;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.param.ResponseBag;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class ProgressCorrectInterceptor extends AInterceptor {
    private static final String TAG = "ProgressCorrectInterceptor";

    @Override // com.baidu.tts.aop.AInterceptor
    protected Object handleBefore(Object obj, Method method, Object[] objArr) {
        ResponseBag responseBag = (ResponseBag) objArr[0];
        if (responseBag != null) {
            String textPrefix = responseBag.getTextParams().getTextPrefix();
            if (!TextUtils.isEmpty(textPrefix)) {
                int length = textPrefix.length();
                int progress = responseBag.getProgress();
                int i2 = progress > length ? progress - length : 0;
                LoggerProxy.d(TAG, "prefixLength=" + length + "--progress=" + progress);
                ResponseBag responseBagShallowClone = responseBag.shallowClone();
                responseBagShallowClone.setProgress(i2);
                objArr[0] = responseBagShallowClone;
            }
        }
        return AInterceptorHandler.DEFAULT;
    }

    @Override // com.baidu.tts.aop.AInterceptor
    protected void registerInterceptMethods() {
        this.mInterceptMethods.add("onSynthesizeDataArrived");
        this.mInterceptMethods.add("onPlayProgressUpdate");
    }
}
