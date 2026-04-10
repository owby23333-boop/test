package com.baidu.tts.download.engine;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.life.ILife;
import com.baidu.tts.state.IState;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ADownloadState implements IState<ADownloadState>, ILife {
    protected DownloadEngine mMachine;

    public ADownloadState(DownloadEngine downloadEngine) {
        this.mMachine = downloadEngine;
    }

    @Override // com.baidu.tts.life.ILife
    public TtsError create() {
        return null;
    }

    @Override // com.baidu.tts.life.ILife
    public void destroy() {
    }

    public EngineDownloadHandler download(DownloadRecord downloadRecord) {
        return null;
    }

    @Override // com.baidu.tts.life.ILife
    public void pause() {
    }

    @Override // com.baidu.tts.life.ILife
    public void resume() {
    }

    @Override // com.baidu.tts.life.ILife
    public void start() {
    }

    @Override // com.baidu.tts.life.ILife
    public void stop() {
    }

    @Override // com.baidu.tts.state.IState
    public void changeState(ADownloadState aDownloadState) {
        this.mMachine.setState(aDownloadState);
    }
}
