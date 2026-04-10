package com.baidu.tts.state.tts;

import android.content.Context;
import com.baidu.tts.adapter.tts.TtsAdapter;
import com.baidu.tts.adapter.tts.Ttser;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthClient;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.bridge.engine.EngineFactory;
import com.baidu.tts.bridge.engine.executor.IEngineExecutor;
import com.baidu.tts.bridge.play.executor.PlayExecutor;
import com.baidu.tts.enumtype.EngineEnum;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.TtsEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;
import com.baidu.tts.param.TtsParams;
import com.baidu.tts.prototype.IPrototype;

/* JADX INFO: loaded from: classes2.dex */
public class Tts implements ITts {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private TtsEnum mTtsEnum;
    private TtsListener mTtsListener;
    private Ttser mTtser;
    private TtsParams mTtsParams = new TtsParams();
    private UninitialState mUninitialState = new UninitialState(this);
    private InitializedState mInitializedState = new InitializedState(this);
    private volatile ATtsState mState = this.mUninitialState;

    /* JADX INFO: renamed from: com.baidu.tts.state.tts.Tts$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$tts$enumtype$TtsEnum = new int[TtsEnum.values().length];

        static {
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsEnum[TtsEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsEnum[TtsEnum.OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsEnum[TtsEnum.MIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public AuthInfo auth(TtsEnum ttsEnum) {
        return this.mState.auth(ttsEnum);
    }

    @Override // com.baidu.tts.life.ILife
    public TtsError create() {
        return this.mState.create();
    }

    @Override // com.baidu.tts.life.ILife
    public void destroy() {
        this.mState.destroy();
    }

    public void errorTts(TtsError ttsError) {
        errorTts(ResponseBag.newResponseBag(ttsError));
    }

    public int errorUninitial() {
        if (this.mTtsListener == null) {
            throw new IllegalStateException(TtsErrorEnum.TTS_UNINITIAL.getMessage());
        }
        errorTts(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.TTS_UNINITIAL));
        return -1;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return this.mState.freeCustomResource(customResourceParams);
    }

    public InitializedState getInitializedState() {
        return this.mInitializedState;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsEnum getMode() {
        return this.mState.getMode();
    }

    ATtsState getState() {
        return this.mState;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsListener getTtsListener() {
        return this.mState.getTtsListener();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public TtsParams getTtsParams() {
        return this.mState.getTtsParams();
    }

    public UninitialState getUninitialState() {
        return this.mUninitialState;
    }

    public boolean isInitialized() {
        return this.mInitializedState == this.mState;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return this.mState.loadCustomResource(customResourceParams);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mState.loadEnglishModel(englishModelParams);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int loadModel(ModelParams modelParams) {
        return this.mState.loadModel(modelParams);
    }

    AuthInfo machineAuth(TtsEnum ttsEnum) {
        return AuthClient.getInstance().auth(ttsEnum, this.mTtsParams);
    }

    TtsError machineCreate() {
        IPrototype onlineSynthesizerParams;
        if (this.mTtsEnum == null) {
            this.mTtsEnum = TtsEnum.ONLINE;
        }
        if (this.mTtsParams == null) {
            this.mTtsParams = new TtsParams();
        }
        PersistentPool.getInstance().create();
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$tts$enumtype$TtsEnum[this.mTtsEnum.ordinal()];
        IEngineExecutor iEngineExecutorCreateEngine = null;
        if (i2 == 1) {
            iEngineExecutorCreateEngine = EngineFactory.getInstance().createEngine(EngineEnum.ONLINE);
            onlineSynthesizerParams = this.mTtsParams.getOnlineSynthesizerParams();
        } else if (i2 == 2) {
            iEngineExecutorCreateEngine = EngineFactory.getInstance().createEngine(EngineEnum.OFFLINE);
            onlineSynthesizerParams = this.mTtsParams.getOfflineSynthesizerParams();
        } else if (i2 != 3) {
            onlineSynthesizerParams = null;
        } else {
            iEngineExecutorCreateEngine = EngineFactory.getInstance().createEngine(EngineEnum.MIX);
            onlineSynthesizerParams = this.mTtsParams.getEngineParams();
        }
        if (iEngineExecutorCreateEngine == null || onlineSynthesizerParams == null) {
            return TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.TTS_UNINITIAL);
        }
        iEngineExecutorCreateEngine.setParam(onlineSynthesizerParams);
        PlayExecutor playExecutor = new PlayExecutor();
        playExecutor.setPlayerParams(this.mTtsParams.getPlayerParams());
        this.mTtser = new Ttser();
        this.mTtser.setTtsAdapter(new TtsAdapter(iEngineExecutorCreateEngine, playExecutor, this.mTtsParams));
        TtsListener ttsListener = this.mTtsListener;
        if (ttsListener != null) {
            this.mTtser.setTtsListener(ttsListener);
        }
        return this.mTtser.create();
    }

    void machineDestroy() {
        this.mTtser.destroy();
        AuthClient.getInstance().clear();
        PersistentPool.getInstance().destroy();
        this.mTtsParams = new TtsParams();
    }

    int machineFreeCustomResource(CustomResourceParams customResourceParams) {
        return this.mTtser.freeCustomResource(customResourceParams);
    }

    TtsEnum machineGetMode() {
        return this.mTtsEnum;
    }

    TtsListener machineGetTtsListener() {
        return this.mTtsListener;
    }

    TtsParams machineGetTtsParams() {
        return this.mTtsParams;
    }

    int machineLoadCustomResource(CustomResourceParams customResourceParams) {
        return this.mTtser.loadCustomResource(customResourceParams);
    }

    int machineLoadEnglishModel(EnglishModelParams englishModelParams) {
        return this.mTtser.loadEnglishModel(englishModelParams);
    }

    int machineLoadModel(ModelParams modelParams) {
        return this.mTtser.loadModel(modelParams);
    }

    void machinePause() {
        this.mTtser.pause();
    }

    void machineResume() {
        this.mTtser.resume();
    }

    int machineSetAudioAttributes(int i2, int i3) {
        try {
            return this.mTtser.getTtsAdapter().getPlayExecutor().setAudioAttributes(i2, i3);
        } catch (Exception unused) {
            return -1;
        }
    }

    int machineSetAudioSampleRate(int i2) {
        try {
            return this.mTtser.getTtsAdapter().getPlayExecutor().setAudioSampleRate(i2);
        } catch (Exception unused) {
            return -1;
        }
    }

    int machineSetAudioStreamType(int i2) {
        try {
            return this.mTtser.getTtsAdapter().getPlayExecutor().setAudioStreamType(i2);
        } catch (Exception unused) {
            return -1;
        }
    }

    void machineSetContext(Context context) {
        PersistentPool.getInstance().setContext(context);
    }

    void machineSetMode(TtsEnum ttsEnum) {
        this.mTtsEnum = ttsEnum;
    }

    int machineSetParam(KeyEnum keyEnum, String str) {
        TtsParams ttsParams = this.mTtsParams;
        if (ttsParams != null) {
            return ttsParams.setParam(keyEnum, str);
        }
        return 0;
    }

    int machineSetStereoVolume(float f2, float f3) {
        return this.mTtser.setStereoVolume(f2, f3);
    }

    void machineSetTtsListener(TtsListener ttsListener) {
        if (ttsListener == null || ttsListener == this.mTtsListener) {
            return;
        }
        this.mTtsListener = ttsListener;
        Ttser ttser = this.mTtser;
        if (ttser != null) {
            ttser.setTtsListener(this.mTtsListener);
        }
    }

    void machineSetTtser(Ttser ttser) {
        this.mTtser = ttser;
    }

    void machineSpeak(TextParams textParams) {
        this.mTtser.speak(textParams);
    }

    void machineStart() {
        this.mTtser.start();
    }

    void machineStop() {
        this.mTtser.stop();
    }

    void machineSynthesize(TextParams textParams) {
        this.mTtser.synthesize(textParams);
    }

    @Override // com.baidu.tts.life.ILife
    public void pause() {
        this.mState.pause();
    }

    @Override // com.baidu.tts.life.ILife
    public void resume() {
        this.mState.resume();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioAttributes(int i2, int i3) {
        return this.mState.setAudioAttributes(i2, i3);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioSampleRate(int i2) {
        return this.mState.setAudioSampleRate(i2);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setAudioStreamType(int i2) {
        return this.mState.setAudioStreamType(i2);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setContext(Context context) {
        this.mState.setContext(context);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setMode(TtsEnum ttsEnum) {
        this.mState.setMode(ttsEnum);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setParam(KeyEnum keyEnum, String str) {
        return this.mState.setParam(keyEnum, str);
    }

    void setState(ATtsState aTtsState) {
        this.mState = aTtsState;
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public int setStereoVolume(float f2, float f3) {
        return this.mState.setStereoVolume(f2, f3);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void setTtsListener(TtsListener ttsListener) {
        this.mState.setTtsListener(ttsListener);
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void speak(TextParams textParams) {
        this.mState.speak(textParams);
    }

    @Override // com.baidu.tts.life.ILife
    public void start() {
        this.mState.start();
    }

    @Override // com.baidu.tts.life.ILife
    public void stop() {
        this.mState.stop();
    }

    @Override // com.baidu.tts.aop.tts.ITts
    public void synthesize(TextParams textParams) {
        this.mState.synthesize(textParams);
    }

    public void errorTts(ResponseBag responseBag) {
        TtsListener ttsListener = this.mTtsListener;
        if (ttsListener != null) {
            ttsListener.onError(responseBag);
        }
    }
}
