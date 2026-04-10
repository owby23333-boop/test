package com.baidu.tts.adapter.tts;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.bridge.engine.SynthesizeListener;
import com.baidu.tts.bridge.engine.executor.IEngineExecutor;
import com.baidu.tts.bridge.play.PlayListener;
import com.baidu.tts.bridge.play.executor.IPlayExecutor;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.MethodEnum;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;
import com.baidu.tts.param.TtsParams;

/* JADX INFO: loaded from: classes2.dex */
public class TtsAdapter implements ITtsAdapter {
    private static final String TAG = "TtsAdapter";
    private IEngineExecutor mEngine;
    private IPlayExecutor mPlayExecutor;
    private PlayListener mPlayerListener;
    private SynthesizeListener mSynToPlayListener;
    private SynthesizeListener mSynthesizeListener;
    private TtsListener mTtsListener;

    public TtsAdapter(IEngineExecutor iEngineExecutor, IPlayExecutor iPlayExecutor, TtsParams ttsParams) {
        this.mEngine = iEngineExecutor;
        this.mPlayExecutor = iPlayExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSpeakBag(ResponseBag responseBag) {
        TextParams textParams = responseBag.getTextParams();
        if (textParams == null) {
            return false;
        }
        return MethodEnum.isSpeak(textParams.getMethodEnum());
    }

    @Override // com.baidu.tts.life.ILife
    public TtsError create() {
        TtsError ttsErrorCreate = this.mEngine.create();
        this.mPlayExecutor.create();
        setSynToPlayListener();
        return ttsErrorCreate;
    }

    @Override // com.baidu.tts.life.ILife
    public void destroy() {
        LoggerProxy.d(TAG, "before engine destroy");
        this.mEngine.destroy();
        LoggerProxy.d(TAG, "after engine destroy");
        this.mPlayExecutor.destroy();
        LoggerProxy.d(TAG, "after player destroy");
    }

    @Override // com.baidu.tts.adapter.tts.ITtsAdapter
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return this.mEngine.freeCustomResource(customResourceParams);
    }

    @Override // com.baidu.tts.adapter.tts.ITtsAdapter
    public IPlayExecutor getPlayExecutor() {
        return this.mPlayExecutor;
    }

    @Override // com.baidu.tts.adapter.tts.ITtsAdapter
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return this.mEngine.loadCustomResource(customResourceParams);
    }

    @Override // com.baidu.tts.adapter.tts.ITtsAdapter
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mEngine.loadEnglishModel(englishModelParams);
    }

    @Override // com.baidu.tts.adapter.tts.ITtsAdapter
    public int loadModel(ModelParams modelParams) {
        return this.mEngine.loadModel(modelParams);
    }

    @Override // com.baidu.tts.life.ILife
    public void pause() {
        this.mEngine.pause();
        this.mPlayExecutor.pause();
    }

    @Override // com.baidu.tts.life.ILife
    public void resume() {
        this.mEngine.resume();
        this.mPlayExecutor.resume();
    }

    protected void setPlayListener(IPlayExecutor iPlayExecutor) {
        if (this.mPlayerListener == null) {
            this.mPlayerListener = new PlayListener() { // from class: com.baidu.tts.adapter.tts.TtsAdapter.2
                @Override // com.baidu.tts.bridge.play.PlayListener
                public void onError(ResponseBag responseBag) {
                    if (TtsAdapter.this.mTtsListener != null) {
                        TtsAdapter.this.mTtsListener.onError(responseBag);
                    }
                }

                @Override // com.baidu.tts.bridge.play.PlayListener
                public void onPlayFinished(ResponseBag responseBag) {
                    if (TtsAdapter.this.mTtsListener != null) {
                        try {
                            TtsAdapter.this.mTtsListener.onPlayFinished(responseBag);
                        } catch (Exception e2) {
                            String str = "onPlayFinished exception e=" + e2.toString();
                        }
                    }
                }

                @Override // com.baidu.tts.bridge.play.PlayListener
                public void onPlayPaused(ResponseBag responseBag) {
                }

                @Override // com.baidu.tts.bridge.play.PlayListener
                public void onPlayProgressUpdate(ResponseBag responseBag) {
                    if (TtsAdapter.this.mTtsListener != null) {
                        TtsAdapter.this.mTtsListener.onPlayProgressUpdate(responseBag);
                    }
                }

                @Override // com.baidu.tts.bridge.play.PlayListener
                public void onPlayStart(ResponseBag responseBag) {
                    if (TtsAdapter.this.mTtsListener != null) {
                        TtsAdapter.this.mTtsListener.onPlayStart(responseBag);
                    }
                }

                @Override // com.baidu.tts.bridge.play.PlayListener
                public void onPlayStop(ResponseBag responseBag) {
                    LoggerProxy.d(TtsAdapter.TAG, "onPlayStop");
                }
            };
        }
        iPlayExecutor.setPlayListener(this.mPlayerListener);
    }

    @Override // com.baidu.tts.adapter.tts.ITtsAdapter
    public int setStereoVolume(float f2, float f3) {
        return this.mPlayExecutor.setStereoVolume(f2, f3);
    }

    protected void setSynToPlayListener() {
        this.mSynToPlayListener = new SynthesizeListener() { // from class: com.baidu.tts.adapter.tts.TtsAdapter.3
            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onError(ResponseBag responseBag) {
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeDataArrived(ResponseBag responseBag) {
                if (TtsAdapter.this.isSpeakBag(responseBag)) {
                    TtsAdapter.this.mPlayExecutor.put(responseBag);
                }
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeFinished(ResponseBag responseBag) {
                if (TtsAdapter.this.isSpeakBag(responseBag)) {
                    TtsAdapter.this.mPlayExecutor.put(responseBag);
                }
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizePaused(ResponseBag responseBag) {
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeStart(ResponseBag responseBag) {
                if (TtsAdapter.this.isSpeakBag(responseBag)) {
                    TtsAdapter.this.mPlayExecutor.put(responseBag);
                }
            }

            @Override // com.baidu.tts.bridge.engine.SynthesizeListener
            public void onSynthesizeStop(ResponseBag responseBag) {
            }
        };
        this.mEngine.registerSynthesizeListener(this.mSynToPlayListener);
    }

    protected void setSynthesizeListener(IEngineExecutor iEngineExecutor) {
        if (this.mSynthesizeListener == null) {
            this.mSynthesizeListener = new SynthesizeListener() { // from class: com.baidu.tts.adapter.tts.TtsAdapter.1
                @Override // com.baidu.tts.bridge.engine.SynthesizeListener
                public void onError(ResponseBag responseBag) {
                    if (TtsAdapter.this.mTtsListener != null) {
                        TtsAdapter.this.mTtsListener.onError(responseBag);
                    }
                }

                @Override // com.baidu.tts.bridge.engine.SynthesizeListener
                public void onSynthesizeDataArrived(ResponseBag responseBag) {
                    if (TtsAdapter.this.mTtsListener != null) {
                        TtsAdapter.this.mTtsListener.onSynthesizeDataArrived(responseBag);
                    }
                }

                @Override // com.baidu.tts.bridge.engine.SynthesizeListener
                public void onSynthesizeFinished(ResponseBag responseBag) {
                    if (TtsAdapter.this.mTtsListener != null) {
                        TtsAdapter.this.mTtsListener.onSynthesizeFinished(responseBag);
                    }
                }

                @Override // com.baidu.tts.bridge.engine.SynthesizeListener
                public void onSynthesizePaused(ResponseBag responseBag) {
                }

                @Override // com.baidu.tts.bridge.engine.SynthesizeListener
                public void onSynthesizeStart(ResponseBag responseBag) {
                    if (TtsAdapter.this.mTtsListener != null) {
                        TtsAdapter.this.mTtsListener.onSynthesizeStart(responseBag);
                    }
                }

                @Override // com.baidu.tts.bridge.engine.SynthesizeListener
                public void onSynthesizeStop(ResponseBag responseBag) {
                    LoggerProxy.d(TtsAdapter.TAG, "onSynthesizeStop");
                }
            };
        }
        iEngineExecutor.registerSynthesizeListener(this.mSynthesizeListener);
    }

    @Override // com.baidu.tts.adapter.tts.ITtsAdapter
    public void setTtsListener(TtsListener ttsListener) {
        this.mTtsListener = ttsListener;
        setSynthesizeListener(this.mEngine);
        setPlayListener(this.mPlayExecutor);
    }

    @Override // com.baidu.tts.adapter.tts.ITtsAdapter
    public void speak(TextParams textParams) {
        this.mPlayExecutor.play();
        this.mEngine.synthesize(textParams);
    }

    @Override // com.baidu.tts.life.ILife
    public void start() {
        this.mEngine.start();
        this.mPlayExecutor.start();
    }

    @Override // com.baidu.tts.life.ILife
    public void stop() {
        LoggerProxy.d(TAG, "before engine stop");
        this.mEngine.stop();
        LoggerProxy.d(TAG, "after engine stop");
        this.mPlayExecutor.stop();
        LoggerProxy.d(TAG, "after play stop");
    }

    @Override // com.baidu.tts.adapter.tts.ITtsAdapter
    public void synthesize(TextParams textParams) {
        this.mEngine.synthesize(textParams);
    }
}
