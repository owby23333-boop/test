package com.baidu.tts.download.engine;

/* JADX INFO: loaded from: classes2.dex */
public class InitializedDownloadState extends ADownloadState {
    public InitializedDownloadState(DownloadEngine downloadEngine) {
        super(downloadEngine);
    }

    @Override // com.baidu.tts.download.engine.ADownloadState, com.baidu.tts.life.ILife
    public void destroy() {
        changeState((ADownloadState) this.mMachine.getUninitialState());
    }

    @Override // com.baidu.tts.download.engine.ADownloadState
    public EngineDownloadHandler download(DownloadRecord downloadRecord) {
        start();
        if (this.mMachine.getState() != this) {
            return this.mMachine.download(downloadRecord);
        }
        return null;
    }

    @Override // com.baidu.tts.download.engine.ADownloadState, com.baidu.tts.life.ILife
    public void start() {
        this.mMachine.machineNewExecutor();
        changeState((ADownloadState) this.mMachine.getDownloadingState());
    }
}
