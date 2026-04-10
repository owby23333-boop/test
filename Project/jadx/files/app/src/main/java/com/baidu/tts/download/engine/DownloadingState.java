package com.baidu.tts.download.engine;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadingState extends ADownloadState {
    public DownloadingState(DownloadEngine downloadEngine) {
        super(downloadEngine);
    }

    @Override // com.baidu.tts.download.engine.ADownloadState, com.baidu.tts.life.ILife
    public void destroy() {
        stop();
        if (this.mMachine.getState() != this) {
            this.mMachine.destroy();
        }
    }

    @Override // com.baidu.tts.download.engine.ADownloadState
    public EngineDownloadHandler download(DownloadRecord downloadRecord) {
        return this.mMachine.machineDownload(downloadRecord);
    }

    @Override // com.baidu.tts.download.engine.ADownloadState, com.baidu.tts.life.ILife
    public void pause() {
        changeState((ADownloadState) this.mMachine.getPauseState());
    }

    @Override // com.baidu.tts.download.engine.ADownloadState, com.baidu.tts.life.ILife
    public void stop() {
        this.mMachine.machineStop();
        changeState((ADownloadState) this.mMachine.getInitializedState());
    }
}
