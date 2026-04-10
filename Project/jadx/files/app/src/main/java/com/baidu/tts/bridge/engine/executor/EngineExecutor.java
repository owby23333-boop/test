package com.baidu.tts.bridge.engine.executor;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.engine.SynthesizeListener;
import com.baidu.tts.bridge.engine.synthesizer.ISynthesizer;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.factory.base.NameThreadFactory;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class EngineExecutor extends AEngineExecutor {
    private static final String TAG = "EngineExecutor";
    private ExecutorService mExecutorService;
    private UninitialEngineState mUninitialState = new UninitialEngineState(this);
    private InitializedEngineState mInitializedState = new InitializedEngineState(this);
    private SynthesizeEngineState mSynthesizeState = new SynthesizeEngineState(this);
    private PauseEngineState mPauseState = new PauseEngineState(this);

    private class SynthesizeWork implements Callable<Void> {
        private TextParams mTextParams;

        public SynthesizeWork(TextParams textParams) {
            this.mTextParams = textParams;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            try {
                EngineExecutor.this.synthesizeStart(ResponseBag.newResponseBag(this.mTextParams));
                TtsError ttsErrorSynthesize = EngineExecutor.this.mSynthesizer.synthesize(this.mTextParams);
                if (ttsErrorSynthesize == null) {
                    EngineExecutor.this.synthesizeFinished(ResponseBag.newResponseBag(this.mTextParams));
                } else {
                    EngineExecutor.this.synthesizeError(ResponseBag.newResponseBag(this.mTextParams, ttsErrorSynthesize));
                }
            } catch (InterruptedException unused) {
            }
            return null;
        }
    }

    public EngineExecutor() {
        this.mState = this.mUninitialState;
    }

    private void synthesizeStop(boolean z2) {
        if (z2) {
            synthesizeStop((ResponseBag) null);
            return;
        }
        ResponseBag responseBag = new ResponseBag();
        responseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.TTS_ENGINE_STOP_FAILURE));
        synthesizeStop(responseBag);
    }

    public InitializedEngineState getInitializedEngineState() {
        return this.mInitializedState;
    }

    public PauseEngineState getPauseEngineState() {
        return this.mPauseState;
    }

    public SynthesizeEngineState getSynthesizeEngineState() {
        return this.mSynthesizeState;
    }

    public UninitialEngineState getUninitialEngineState() {
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
        if (this.mSynthesizeListeners == null) {
            this.mSynthesizeListeners = new ArrayList();
        }
        this.mSynthesizer.setSynthesizeListener(new SynthesizeListener() { // from class: com.baidu.tts.bridge.engine.executor.EngineExecutor.1
            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onError(ResponseBag responseBag) {
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeDataArrived(ResponseBag responseBag) {
                EngineExecutor.this.synthesizeDataArrived(responseBag);
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeFinished(ResponseBag responseBag) {
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizePaused(ResponseBag responseBag) {
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeStart(ResponseBag responseBag) {
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeStop(ResponseBag responseBag) {
            }
        });
        return this.mSynthesizer.initial();
    }

    void machineDestroy() {
        this.mSynthesizer.release();
        this.mSynthesizeListeners = null;
    }

    int machineFreeCustomResource(CustomResourceParams customResourceParams) {
        return this.mSynthesizer.freeCustomResource(customResourceParams);
    }

    int machineLoadCustomResource(CustomResourceParams customResourceParams) {
        return this.mSynthesizer.loadCustomResource(customResourceParams);
    }

    int machineLoadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mSynthesizer.loadEnglishModel(englishModelParams);
    }

    int machineLoadModel(ModelParams modelParams) {
        return this.mSynthesizer.loadModel(modelParams);
    }

    void machinePause() {
    }

    void machineRegisteSynthesizeListener(SynthesizeListener synthesizeListener) {
        if (this.mSynthesizeListeners == null) {
            this.mSynthesizeListeners = new ArrayList();
        }
        if (this.mSynthesizeListeners.contains(synthesizeListener)) {
            return;
        }
        this.mSynthesizeListeners.add(synthesizeListener);
    }

    void machineRemoveSynthesizeListener(SynthesizeListener synthesizeListener) {
        List<SynthesizeListener> list = this.mSynthesizeListeners;
        if (list != null) {
            list.remove(synthesizeListener);
        }
    }

    void machineResume() {
    }

    <T> void machineSetParam(T t2) {
        this.mSynthesizer.setParam(t2);
    }

    void machineSetSynthesizer(ISynthesizer iSynthesizer) {
        this.mSynthesizer = iSynthesizer;
    }

    void machineStart() {
        this.mExecutorService = Executors.newSingleThreadExecutor(new NameThreadFactory("bdtts-EngineExecutorPoolThread"));
    }

    void machineStop() {
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            if (!executorService.isShutdown()) {
                this.mExecutorService.shutdownNow();
            }
            try {
                LoggerProxy.d(TAG, "before awaitTermination");
                boolean zAwaitTermination = this.mExecutorService.awaitTermination(1000L, TimeUnit.MILLISECONDS);
                LoggerProxy.d(TAG, "after awaitTermination isTermination=" + zAwaitTermination);
                synthesizeStop(zAwaitTermination);
            } catch (InterruptedException unused) {
                synthesizeStop(false);
            }
            this.mExecutorService = null;
        }
    }

    void machineSynthesize(TextParams textParams) {
        this.mExecutorService.submit(new SynthesizeWork(textParams));
    }
}
