package com.baidu.tts.aop.ttslistener;

import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public interface TtsListener {
    void onError(ResponseBag responseBag);

    void onPlayFinished(ResponseBag responseBag);

    void onPlayProgressUpdate(ResponseBag responseBag);

    void onPlayStart(ResponseBag responseBag);

    void onSynthesizeDataArrived(ResponseBag responseBag);

    void onSynthesizeFinished(ResponseBag responseBag);

    void onSynthesizeStart(ResponseBag responseBag);
}
