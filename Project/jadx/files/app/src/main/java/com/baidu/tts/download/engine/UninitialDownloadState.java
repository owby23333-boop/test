package com.baidu.tts.download.engine;

import com.baidu.tts.aop.tts.TtsError;

/* JADX INFO: loaded from: classes2.dex */
public class UninitialDownloadState extends ADownloadState {
    public UninitialDownloadState(DownloadEngine downloadEngine) {
        super(downloadEngine);
    }

    @Override // com.baidu.tts.download.engine.ADownloadState, com.baidu.tts.life.ILife
    public TtsError create() {
        changeState((ADownloadState) this.mMachine.getInitializedState());
        return null;
    }
}
