package com.baidu.tts.bridge.engine.executor;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.engine.SynthesizeListener;
import com.baidu.tts.bridge.engine.synthesizer.ISynthesizer;
import com.baidu.tts.enumtype.CommandEnum;
import com.baidu.tts.life.ASafeLife;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AEngineExecutor extends ASafeLife implements IEngineExecutor {
    protected volatile AEngineState mState;
    protected List<SynthesizeListener> mSynthesizeListeners = new ArrayList();
    protected ISynthesizer mSynthesizer;

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return this.mState.freeCustomResource(customResourceParams);
    }

    public AEngineState getState() {
        return this.mState;
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return this.mState.loadCustomResource(customResourceParams);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mState.loadEnglishModel(englishModelParams);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public int loadModel(ModelParams modelParams) {
        return this.mState.loadModel(modelParams);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void registerSynthesizeListener(SynthesizeListener synthesizeListener) {
        this.mState.registerSynthesizeListener(synthesizeListener);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void removeSynthesizeListener(SynthesizeListener synthesizeListener) {
        this.mState.removeSynthesizeListener(synthesizeListener);
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected TtsError safeCreate() {
        return this.mState.create();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeDestroy() {
        this.mState.destroy();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safePause() {
        this.mState.pause();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeResume() {
        this.mState.resume();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeStart() {
        this.mState.start();
    }

    @Override // com.baidu.tts.life.ASafeLife
    protected void safeStop() {
        this.mState.stop();
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void setParam(Object obj) {
        this.mState.setParam(obj);
    }

    public void setState(AEngineState aEngineState) {
        this.mState = aEngineState;
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void setSynthesizer(ISynthesizer iSynthesizer) {
        this.mState.setSynthesizer(iSynthesizer);
    }

    @Override // com.baidu.tts.bridge.engine.executor.IEngineExecutor
    public void synthesize(TextParams textParams) {
        this.mState.synthesize(textParams);
    }

    void synthesizeDataArrived(ResponseBag responseBag) {
        if (isNeedToNotify()) {
            if (responseBag == null) {
                responseBag = new ResponseBag();
            }
            responseBag.setCommandEnum(CommandEnum.SYN_DATA);
            List<SynthesizeListener> list = this.mSynthesizeListeners;
            if (list != null) {
                for (SynthesizeListener synthesizeListener : list) {
                    if (synthesizeListener != null) {
                        synthesizeListener.onSynthesizeDataArrived(responseBag);
                    }
                }
            }
        }
    }

    void synthesizeError(ResponseBag responseBag) {
        if (responseBag == null) {
            responseBag = new ResponseBag();
        }
        responseBag.setCommandEnum(CommandEnum.SYN_ERROR);
        List<SynthesizeListener> list = this.mSynthesizeListeners;
        if (list != null) {
            for (SynthesizeListener synthesizeListener : list) {
                if (synthesizeListener != null) {
                    synthesizeListener.onError(responseBag);
                }
            }
        }
    }

    void synthesizeFinished(ResponseBag responseBag) {
        if (isNeedToNotify()) {
            if (responseBag == null) {
                responseBag = new ResponseBag();
            }
            responseBag.setCommandEnum(CommandEnum.SYN_FINISH);
            List<SynthesizeListener> list = this.mSynthesizeListeners;
            if (list != null) {
                for (SynthesizeListener synthesizeListener : list) {
                    if (synthesizeListener != null) {
                        synthesizeListener.onSynthesizeFinished(responseBag);
                    }
                }
            }
        }
    }

    void synthesizePaused(ResponseBag responseBag) {
        if (responseBag == null) {
            responseBag = new ResponseBag();
        }
        responseBag.setCommandEnum(CommandEnum.SYN_PAUSE);
        List<SynthesizeListener> list = this.mSynthesizeListeners;
        if (list != null) {
            for (SynthesizeListener synthesizeListener : list) {
                if (synthesizeListener != null) {
                    synthesizeListener.onSynthesizePaused(responseBag);
                }
            }
        }
    }

    void synthesizeStart(ResponseBag responseBag) {
        if (isNeedToNotify()) {
            if (responseBag == null) {
                responseBag = new ResponseBag();
            }
            responseBag.setCommandEnum(CommandEnum.SYN_START);
            List<SynthesizeListener> list = this.mSynthesizeListeners;
            if (list != null) {
                for (SynthesizeListener synthesizeListener : list) {
                    if (synthesizeListener != null) {
                        synthesizeListener.onSynthesizeStart(responseBag);
                    }
                }
            }
        }
    }

    void synthesizeStop(ResponseBag responseBag) {
        if (responseBag == null) {
            responseBag = new ResponseBag();
        }
        responseBag.setCommandEnum(CommandEnum.SYN_STOP);
        List<SynthesizeListener> list = this.mSynthesizeListeners;
        if (list != null) {
            for (SynthesizeListener synthesizeListener : list) {
                if (synthesizeListener != null) {
                    synthesizeListener.onSynthesizeStop(responseBag);
                }
            }
        }
    }
}
