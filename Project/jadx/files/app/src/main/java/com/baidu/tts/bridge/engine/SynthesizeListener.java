package com.baidu.tts.bridge.engine;

import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public interface SynthesizeListener {
    void onError(ResponseBag responseBag);

    void onSynthesizeDataArrived(ResponseBag responseBag);

    void onSynthesizeFinished(ResponseBag responseBag);

    void onSynthesizePaused(ResponseBag responseBag);

    void onSynthesizeStart(ResponseBag responseBag);

    void onSynthesizeStop(ResponseBag responseBag);
}
