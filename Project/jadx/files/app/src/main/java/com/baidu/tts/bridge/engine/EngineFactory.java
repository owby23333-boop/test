package com.baidu.tts.bridge.engine;

import com.baidu.tts.bridge.engine.executor.EngineExecutor;
import com.baidu.tts.bridge.engine.executor.IEngineExecutor;
import com.baidu.tts.bridge.engine.synthesizer.ISynthesizer;
import com.baidu.tts.bridge.engine.synthesizer.MixSynthesizer;
import com.baidu.tts.bridge.engine.synthesizer.OfflineSynthesizer;
import com.baidu.tts.bridge.engine.synthesizer.OnlineSynthesizer;
import com.baidu.tts.enumtype.EngineEnum;

/* JADX INFO: loaded from: classes2.dex */
public class EngineFactory {
    private static volatile EngineFactory mInstance;

    /* JADX INFO: renamed from: com.baidu.tts.bridge.engine.EngineFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$tts$enumtype$EngineEnum = new int[EngineEnum.values().length];

        static {
            try {
                $SwitchMap$com$baidu$tts$enumtype$EngineEnum[EngineEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$EngineEnum[EngineEnum.OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$EngineEnum[EngineEnum.MIX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private EngineFactory() {
    }

    private IEngineExecutor createMixTtsEngine() {
        return createEngine(new MixSynthesizer());
    }

    private IEngineExecutor createOfflineTtsEngine() {
        return createEngine(new OfflineSynthesizer());
    }

    private IEngineExecutor createOnlineTtsEngine() {
        return createEngine(new OnlineSynthesizer());
    }

    public static EngineFactory getInstance() {
        if (mInstance == null) {
            synchronized (EngineFactory.class) {
                if (mInstance == null) {
                    mInstance = new EngineFactory();
                }
            }
        }
        return mInstance;
    }

    public IEngineExecutor createEngine(EngineEnum engineEnum) {
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$tts$enumtype$EngineEnum[engineEnum.ordinal()];
        if (i2 == 1) {
            return createOnlineTtsEngine();
        }
        if (i2 == 2) {
            return createOfflineTtsEngine();
        }
        if (i2 != 3) {
            return null;
        }
        return createMixTtsEngine();
    }

    private IEngineExecutor createEngine(ISynthesizer iSynthesizer) {
        EngineExecutor engineExecutor = new EngineExecutor();
        engineExecutor.setSynthesizer(iSynthesizer);
        return engineExecutor;
    }
}
