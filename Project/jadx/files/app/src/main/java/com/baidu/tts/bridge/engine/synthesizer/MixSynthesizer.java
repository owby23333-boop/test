package com.baidu.tts.bridge.engine.synthesizer;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.engine.SynthesizeListener;
import com.baidu.tts.bridge.engine.synthesizer.OfflineSynthesizer;
import com.baidu.tts.bridge.engine.synthesizer.OnlineSynthesizer;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.param.AllSynthesizerParams;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;

/* JADX INFO: loaded from: classes2.dex */
public class MixSynthesizer extends ASynthesizer {
    private static final String TAG = "MixSynthesizer";
    private AllSynthesizerParams mAllSynthesizerParams;
    private TtsError mOfflineInitialError;
    private int mTextSynthesizeStartPosition = 0;
    private int mCount = 0;
    private OnlineSynthesizer mOnlineSynthesizer = new OnlineSynthesizer();
    private OfflineSynthesizer mOfflineSynthesizer = new OfflineSynthesizer();
    private MixStrategy mMixStrategy = new MixStrategy();

    /* JADX INFO: Access modifiers changed from: private */
    public ResponseBag fix(ResponseBag responseBag) {
        int count = responseBag.getCount();
        responseBag.setCount(count >= 0 ? count + this.mCount : count - this.mCount);
        responseBag.setProgress(responseBag.getProgress() + this.mTextSynthesizeStartPosition);
        return responseBag;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return this.mOfflineSynthesizer.freeCustomResource(customResourceParams);
    }

    public MixStrategy getMixStrategy() {
        return this.mMixStrategy;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError initial() {
        this.mOnlineSynthesizer.setSynthesizeListener(new SynthesizeListener() { // from class: com.baidu.tts.bridge.engine.synthesizer.MixSynthesizer.1
            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onError(ResponseBag responseBag) {
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeDataArrived(ResponseBag responseBag) {
                MixSynthesizer.this.mCount = responseBag.getCount();
                MixSynthesizer.this.mTextSynthesizeStartPosition = responseBag.getProgress();
                MixSynthesizer.this.synthesizeDataArrived(responseBag);
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
        this.mOfflineSynthesizer.setSynthesizeListener(new SynthesizeListener() { // from class: com.baidu.tts.bridge.engine.synthesizer.MixSynthesizer.2
            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onError(ResponseBag responseBag) {
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeDataArrived(ResponseBag responseBag) {
                MixSynthesizer mixSynthesizer = MixSynthesizer.this;
                mixSynthesizer.synthesizeDataArrived(mixSynthesizer.fix(responseBag));
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
        this.mOnlineSynthesizer.initial();
        this.mOfflineInitialError = this.mOfflineSynthesizer.initial();
        if (this.mOfflineInitialError != null) {
            return TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.MIX_ENGINE_OFFLINE_INIT_FAILURE);
        }
        return null;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return this.mOfflineSynthesizer.loadCustomResource(customResourceParams);
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mOfflineSynthesizer.loadEnglishModel(englishModelParams);
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadModel(ModelParams modelParams) {
        if (this.mOfflineInitialError == null) {
            return this.mOfflineSynthesizer.loadModel(modelParams);
        }
        String textModelPath = modelParams.getTextModelPath();
        String speechModelPath = modelParams.getSpeechModelPath();
        OfflineSynthesizer.OfflineSynthesizerParams offlineSynthesizerParams = this.mAllSynthesizerParams.getOfflineSynthesizerParams();
        offlineSynthesizerParams.setTextDatPath(textModelPath);
        offlineSynthesizerParams.setSpeechDatPath(speechModelPath);
        this.mOfflineInitialError = this.mOfflineSynthesizer.initial();
        TtsError ttsError = this.mOfflineInitialError;
        if (ttsError == null) {
            return 0;
        }
        return ttsError.getDetailCode();
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError release() {
        this.mOnlineSynthesizer.release();
        this.mOfflineSynthesizer.release();
        this.mMixStrategy.setAllSynthesizerParams(null);
        return null;
    }

    public void setMixStrategy(MixStrategy mixStrategy) {
        this.mMixStrategy = mixStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public <AllSynthesizerParams> void setParam(AllSynthesizerParams allsynthesizerparams) {
        this.mAllSynthesizerParams = (AllSynthesizerParams) allsynthesizerparams;
        OnlineSynthesizer.OnlineSynthesizerParams onlineSynthesizerParams = this.mAllSynthesizerParams.getOnlineSynthesizerParams();
        onlineSynthesizerParams.setRetry(3);
        onlineSynthesizerParams.setRetryTimeInterval(500);
        this.mOnlineSynthesizer.setParam(onlineSynthesizerParams);
        this.mOfflineSynthesizer.setParam(this.mAllSynthesizerParams.getOfflineSynthesizerParams());
        this.mMixStrategy.setAllSynthesizerParams(this.mAllSynthesizerParams);
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError synthesize(TextParams textParams) throws InterruptedException {
        this.mCount = 0;
        this.mTextSynthesizeStartPosition = 0;
        if (!this.mMixStrategy.isOnlineValid()) {
            return this.mOfflineSynthesizer.synthesize(textParams);
        }
        TtsError ttsErrorSynthesize = this.mOnlineSynthesizer.synthesize(textParams);
        if (ttsErrorSynthesize == null) {
            return ttsErrorSynthesize;
        }
        LoggerProxy.d(TAG, "online synthesize tts error=" + ttsErrorSynthesize.getDetailMessage());
        TtsErrorEnum errorEnum = ttsErrorSynthesize.getErrorEnum();
        if (errorEnum != TtsErrorEnum.ONLINE_ENGINE_HTTP_REQUEST_FAILURE && errorEnum != TtsErrorEnum.ONLINE_ENGINE_GET_TIMEOUT && errorEnum != TtsErrorEnum.ONLINE_AUTH_TIMEOUT_EXCEPTION && errorEnum != TtsErrorEnum.ONLINE_ENGINE_SERVER_IP_IS_NULL) {
            return ttsErrorSynthesize;
        }
        String text = textParams.getText();
        int length = text.length();
        int i2 = this.mTextSynthesizeStartPosition;
        textParams.setText(length > i2 ? text.substring(i2) : text.substring(text.length() - 1));
        return this.mOfflineSynthesizer.synthesize(textParams);
    }
}
