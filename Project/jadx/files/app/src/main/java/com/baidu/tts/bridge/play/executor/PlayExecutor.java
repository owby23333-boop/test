package com.baidu.tts.bridge.play.executor;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.play.PlayListener;
import com.baidu.tts.bridge.play.PlayerFactory;
import com.baidu.tts.bridge.play.player.IPlayer;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.concurrency.LimitQueueThreadPoolExecutor;
import com.baidu.tts.enumtype.TimeOutEnum;
import com.baidu.tts.param.AllPlayerParams;
import com.baidu.tts.param.ResponseBag;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class PlayExecutor extends APlayExecutor {
    private static final String TAG = "PlayQueueMachine";
    private ThreadPoolExecutor mExecutorService;
    private IPlayer mPlayer;
    private UninitialPlayState mUninitialState = new UninitialPlayState(this);
    private InitializedPlayState mInitializedState = new InitializedPlayState(this);
    private RunningPlayState mRunningState = new RunningPlayState(this);
    private PausePlayState mPauseState = new PausePlayState(this);

    private class PlayWork implements Runnable {
        private ResponseBag mResponseBag;

        public PlayWork(ResponseBag responseBag) {
            this.mResponseBag = responseBag;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoggerProxy.d(PlayExecutor.TAG, "enter run");
            PlayExecutor.this.mPlayer.put(this.mResponseBag);
            LoggerProxy.d(PlayExecutor.TAG, "end run");
        }
    }

    public PlayExecutor() {
        this.mState = this.mUninitialState;
        this.mPlayer = PlayerFactory.getInstance().createPlayer();
    }

    public InitializedPlayState getInitializedState() {
        return this.mInitializedState;
    }

    public PausePlayState getPauseState() {
        return this.mPauseState;
    }

    public RunningPlayState getRunningState() {
        return this.mRunningState;
    }

    public UninitialPlayState getUninitialState() {
        return this.mUninitialState;
    }

    @Override // com.baidu.tts.life.ASafeLife
    public boolean isPaused() {
        return this.mState == this.mPauseState;
    }

    @Override // com.baidu.tts.life.ASafeLife
    public boolean isStopped() {
        return Thread.currentThread().isInterrupted() || this.mState == this.mInitializedState;
    }

    TtsError machineCreate() {
        this.mPlayer.setPlayListener(new PlayListener() { // from class: com.baidu.tts.bridge.play.executor.PlayExecutor.1
            @Override // com.baidu.tts.bridge.play.PlayListener
            public void onError(ResponseBag responseBag) {
                PlayExecutor.this.playError(responseBag);
            }

            @Override // com.baidu.tts.bridge.play.PlayListener
            public void onPlayFinished(ResponseBag responseBag) {
                PlayExecutor.this.playFinished(responseBag);
            }

            @Override // com.baidu.tts.bridge.play.PlayListener
            public void onPlayPaused(ResponseBag responseBag) {
            }

            @Override // com.baidu.tts.bridge.play.PlayListener
            public void onPlayProgressUpdate(ResponseBag responseBag) {
                PlayExecutor.this.playProgressUpdate(responseBag);
            }

            @Override // com.baidu.tts.bridge.play.PlayListener
            public void onPlayStart(ResponseBag responseBag) {
                PlayExecutor.this.playStart(responseBag);
            }

            @Override // com.baidu.tts.bridge.play.PlayListener
            public void onPlayStop(ResponseBag responseBag) {
            }
        });
        return this.mPlayer.initial();
    }

    void machineDestroy() {
        this.mPlayer.release();
    }

    void machinePause() {
        this.mPlayer.pause();
    }

    void machinePlay() {
        this.mPlayer.play();
    }

    void machinePut(ResponseBag responseBag) {
        this.mExecutorService.execute(new PlayWork(responseBag));
    }

    void machineResume() {
        this.mPlayer.resume();
    }

    int machineSetAudioSampleRate(int i2) {
        return this.mPlayer.setAudioSampleRate(i2);
    }

    int machineSetAudioStreamType(int i2) {
        return this.mPlayer.setAudioStreamType(i2);
    }

    void machineSetPlayerListener(PlayListener playListener) {
        this.mPlayListener = playListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> void machineSetPlayerParams(T t2) {
        this.mPlayer.setParam(((AllPlayerParams) t2).getAudioTrackPlayerParams());
    }

    int machineSetStereoVolume(float f2, float f3) {
        return this.mPlayer.setStereoVolume(f2, f3);
    }

    void machineStart() {
        this.mExecutorService = new LimitQueueThreadPoolExecutor(200, "bdtts-PlayExecutorPoolThread");
    }

    void machineStop() {
        this.mPlayer.stop();
        ThreadPoolExecutor threadPoolExecutor = this.mExecutorService;
        if (threadPoolExecutor != null) {
            if (!threadPoolExecutor.isShutdown()) {
                this.mExecutorService.shutdownNow();
            }
            try {
                LoggerProxy.d(TAG, "before await");
                LoggerProxy.d(TAG, "after await isTer=" + this.mExecutorService.awaitTermination(TimeOutEnum.DEFAULT.getMillSeconds(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException unused) {
                LoggerProxy.d(TAG, "InterruptedException");
            }
            this.mExecutorService = null;
        }
    }

    public int machinesetAudioAttributes(int i2, int i3) {
        return this.mPlayer.setAudioAttributes(i2, i3);
    }
}
