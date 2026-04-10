package com.baidu.tts.bridge.play;

import com.baidu.tts.param.ResponseBag;

/* JADX INFO: loaded from: classes2.dex */
public interface PlayListener {
    void onError(ResponseBag responseBag);

    void onPlayFinished(ResponseBag responseBag);

    void onPlayPaused(ResponseBag responseBag);

    void onPlayProgressUpdate(ResponseBag responseBag);

    void onPlayStart(ResponseBag responseBag);

    void onPlayStop(ResponseBag responseBag);
}
