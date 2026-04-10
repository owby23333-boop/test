package com.baidu.tts.download.engine;

/* JADX INFO: loaded from: classes2.dex */
public class PauseDownloadState extends ADownloadState {
    public PauseDownloadState(DownloadEngine downloadEngine) {
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
        resume();
        if (this.mMachine.getState() != this) {
            return this.mMachine.download(downloadRecord);
        }
        return null;
    }

    @Override // com.baidu.tts.download.engine.ADownloadState, com.baidu.tts.life.ILife
    public void resume() {
        changeState((ADownloadState) this.mMachine.getDownloadingState());
    }

    @Override // com.baidu.tts.download.engine.ADownloadState, com.baidu.tts.life.ILife
    public void stop() {
        this.mMachine.machineStop();
        changeState((ADownloadState) this.mMachine.getInitializedState());
    }
}
