package com.baidu.tts.bridge.engine.synthesizer;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.AuthClient;
import com.baidu.tts.auth.OfflineAuth;
import com.baidu.tts.bridge.play.player.PlayCache2Tts;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.emstatistics.SynthesizeResultDb;
import com.baidu.tts.enumtype.AudioDataFormat;
import com.baidu.tts.enumtype.CharSetEnum;
import com.baidu.tts.enumtype.EngineEnum;
import com.baidu.tts.enumtype.SampleRateEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.factory.base.NameThreadFactory;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.param.BaseSynthesizerParams;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.ResourceTools;
import com.baidu.tts.tools.SharedPreferencesUtils;
import com.baidu.tts.tools.StringTool;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class OfflineSynthesizer extends ASynthesizer {
    private static final String TAG = "OfflineSynthesizer";
    private SynthesizeResultDb mStatDb;
    private OfflineSynthesizerParams mSynthesizerParams;
    private long[] pTTSHandle = new long[1];

    public static class OfflineSynthesizerParams extends BaseSynthesizerParams<OfflineSynthesizerParams> {
        public static final int AUDIO_FORMAT = 16;
        public static final int BACKGROUND = 9;
        public static final int BILINGUAL_MODE = 22;
        public static final int CODING_FORMAT = 4;
        public static final int DIGIT_MODE = 3;
        public static final int DOMAIN = 17;
        public static final int DOMAIN_SYNTH = 20;
        public static final int ENG_MODE = 15;
        public static final int MAX_VALUE = 24;
        public static final int ONE_MODE = 13;
        public static final int OPEN_XML = 10;
        public static final int PCM_TYPE = 19;
        public static final int PERSON = 1;
        public static final int PITCH = 7;
        public static final int PUNC_MODE = 11;
        public static final int SAMPLE_RATE = 23;
        public static final int SPEC = 8;
        public static final int SPEED = 6;
        public static final int SYMBOL_FILTER = 12;
        public static final int TWO_MODE = 14;
        public static final int VOCODER_OPTIM_LEVEL = 18;
        public static final int VOICE_STYLE = 2;
        public static final int VOLUME = 5;
        private static final long serialVersionUID = 4858844853486699610L;
        private String mAppCode;
        private String mSpeechDatPath;
        private String mTextDatPath;
        private String mTtsLicenseFilePath;
        private String mVocoderOptimLevel = "0";
        private String mSampleRate = "0";
        private String mDomainSynth = "0";
        private String mSpec = "5";
        private String mBilingualMode = "1";

        public String getAppCode() {
            return this.mAppCode;
        }

        public long getBiligualModeLong() {
            try {
                return Long.parseLong(this.mBilingualMode);
            } catch (Exception unused) {
                return 0L;
            }
        }

        public String getDomainSynth() {
            return this.mDomainSynth;
        }

        public long getDomainSynthLong() {
            try {
                return Long.parseLong(this.mDomainSynth);
            } catch (Exception unused) {
                return 0L;
            }
        }

        public String getSampleRate() {
            return this.mSampleRate;
        }

        public long getSampleRateLong() {
            try {
                return Long.parseLong(this.mSampleRate);
            } catch (Exception unused) {
                return 0L;
            }
        }

        public String getSpec() {
            return this.mSpec;
        }

        public String getSpeechDatPath() {
            return this.mSpeechDatPath;
        }

        public String getTextDatPath() {
            return this.mTextDatPath;
        }

        public String getTtsLicenseFilePath() {
            return this.mTtsLicenseFilePath;
        }

        public String getVocoderOptimLevel() {
            return this.mVocoderOptimLevel;
        }

        public long getVocoderOptimLevelLong() {
            try {
                return Long.parseLong(this.mVocoderOptimLevel);
            } catch (Exception unused) {
                return 0L;
            }
        }

        public void setAppCode(String str) {
            this.mAppCode = str;
        }

        public int setBiligualMode(String str) {
            if (!DataTool.isLong(str)) {
                return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
            }
            this.mBilingualMode = str;
            return 0;
        }

        public int setDomainSynth(String str) {
            if (!DataTool.isLong(str)) {
                return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
            }
            this.mDomainSynth = str;
            return 0;
        }

        public void setSampleRate(String str) {
            this.mSampleRate = str;
        }

        public void setSpec(String str) {
            this.mSpec = str;
        }

        public void setSpeechDatPath(String str) {
            this.mSpeechDatPath = str;
        }

        public void setTextDatPath(String str) {
            this.mTextDatPath = str;
        }

        public void setTtsLicenseFilePath(String str) {
            this.mTtsLicenseFilePath = str;
        }

        public int setVocoderOptimLevel(String str) {
            if (!DataTool.isLong(str)) {
                return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
            }
            this.mVocoderOptimLevel = str;
            return 0;
        }
    }

    private class SynthesizeWork implements Callable<TtsError>, EmbeddedSynthesizerEngine.OnNewDataListener {
        private TextParams mTextParams;
        private int mCount = 0;
        private SampleRateEnum sampleRateEnum = SampleRateEnum.HZ16K;
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool(new NameThreadFactory("bdtts-OfflineSynthesizer"));

        public SynthesizeWork(TextParams textParams) {
            this.mTextParams = textParams;
        }

        @Override // com.baidu.tts.jni.EmbeddedSynthesizerEngine.OnNewDataListener
        public int onNewData(byte[] bArr, int i2) {
            this.mCount++;
            ResponseBag responseBagNewResponseBag = ResponseBag.newResponseBag(this.mTextParams);
            responseBagNewResponseBag.setEngineType(EngineEnum.OFFLINE.getType());
            responseBagNewResponseBag.setAudioDataFormat(AudioDataFormat.PCM);
            responseBagNewResponseBag.setAudioData(bArr);
            responseBagNewResponseBag.setProgress(i2);
            responseBagNewResponseBag.setSampleRate(this.sampleRateEnum);
            responseBagNewResponseBag.setIndex(this.mCount);
            responseBagNewResponseBag.setCount(this.mCount);
            OfflineSynthesizer.this.synthesizeDataArrived(responseBagNewResponseBag);
            if (!Thread.currentThread().isInterrupted()) {
                return 0;
            }
            LoggerProxy.d(OfflineSynthesizer.TAG, "interrupted to interrupt syn");
            return -1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public TtsError call() throws Exception {
            OfflineAuth.OfflineResult offlineResultAuthOffline = AuthClient.getInstance().authOffline(OfflineSynthesizer.this.mSynthesizerParams);
            if (offlineResultAuthOffline == null) {
                return TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_ENGINE_AUTH_NULL);
            }
            if (!offlineResultAuthOffline.isValid()) {
                return offlineResultAuthOffline.getError();
            }
            long jBdTTSGetParam = EmbeddedSynthesizerEngine.bdTTSGetParam(OfflineSynthesizer.this.pTTSHandle[0], 23);
            if (jBdTTSGetParam == 24000) {
                this.sampleRateEnum = SampleRateEnum.HZ24K;
                if (PlayCache2Tts.getEnableAecPlay()) {
                    PlayCache2Tts.setSampleRate((int) jBdTTSGetParam);
                }
            } else if (jBdTTSGetParam == 16000) {
                this.sampleRateEnum = SampleRateEnum.HZ16K;
                if (PlayCache2Tts.getEnableAecPlay()) {
                    PlayCache2Tts.setSampleRate((int) jBdTTSGetParam);
                }
            }
            LoggerProxy.d(OfflineSynthesizer.TAG, " sampleRate:" + jBdTTSGetParam + " sampleRateEnum:" + this.sampleRateEnum.getHz());
            String volume = OfflineSynthesizer.this.mSynthesizerParams.getVolume();
            if (volume.matches("\\d+(.\\d+)?")) {
                if (volume.indexOf(".") > 0) {
                    EmbeddedSynthesizerEngine.bdTTSSetParamFloat(OfflineSynthesizer.this.pTTSHandle[0], 5, Float.parseFloat(volume));
                } else {
                    EmbeddedSynthesizerEngine.bdTTSSetParam(OfflineSynthesizer.this.pTTSHandle[0], 5, Long.parseLong(volume));
                }
            }
            String speed = OfflineSynthesizer.this.mSynthesizerParams.getSpeed();
            if (speed.matches("\\d+(.\\d+)?")) {
                if (speed.indexOf(".") > 0) {
                    EmbeddedSynthesizerEngine.bdTTSSetParamFloat(OfflineSynthesizer.this.pTTSHandle[0], 6, Float.parseFloat(speed));
                } else {
                    EmbeddedSynthesizerEngine.bdTTSSetParam(OfflineSynthesizer.this.pTTSHandle[0], 6, Long.parseLong(speed));
                }
            }
            String pitch = OfflineSynthesizer.this.mSynthesizerParams.getPitch();
            if (pitch.matches("\\d+(.\\d+)?")) {
                if (pitch.indexOf(".") > 0) {
                    EmbeddedSynthesizerEngine.bdTTSSetParamFloat(OfflineSynthesizer.this.pTTSHandle[0], 7, Float.parseFloat(pitch));
                } else {
                    EmbeddedSynthesizerEngine.bdTTSSetParam(OfflineSynthesizer.this.pTTSHandle[0], 7, Long.parseLong(pitch));
                }
            }
            String spec = OfflineSynthesizer.this.mSynthesizerParams.getSpec();
            if (spec.matches("\\d+(.\\d+)?")) {
                if (spec.indexOf(".") > 0) {
                    EmbeddedSynthesizerEngine.bdTTSSetParamFloat(OfflineSynthesizer.this.pTTSHandle[0], 8, Float.parseFloat(spec));
                } else {
                    EmbeddedSynthesizerEngine.bdTTSSetParam(OfflineSynthesizer.this.pTTSHandle[0], 8, Long.parseLong(spec));
                }
            }
            LoggerProxy.d(OfflineSynthesizer.TAG, "engineResult = " + EmbeddedSynthesizerEngine.bdTTSSetParam(OfflineSynthesizer.this.pTTSHandle[0], 0, 0L));
            EmbeddedSynthesizerEngine.bdTTSSetParam(OfflineSynthesizer.this.pTTSHandle[0], 18, OfflineSynthesizer.this.mSynthesizerParams.getVocoderOptimLevelLong());
            EmbeddedSynthesizerEngine.bdTTSSetParam(OfflineSynthesizer.this.pTTSHandle[0], 10, OfflineSynthesizer.this.mSynthesizerParams.getOpenXmlLong());
            EmbeddedSynthesizerEngine.bdTTSSetParam(OfflineSynthesizer.this.pTTSHandle[0], 22, OfflineSynthesizer.this.mSynthesizerParams.getBiligualModeLong());
            EmbeddedSynthesizerEngine.setOnNewDataListener(this);
            this.mTextParams.setTextEncode(CharSetEnum.GBK.getCharset());
            byte[] textBytes = this.mTextParams.getTextBytes();
            LoggerProxy.d(OfflineSynthesizer.TAG, "before bdttssynthesis");
            int iBdTTSSynthesis = EmbeddedSynthesizerEngine.bdTTSSynthesis(OfflineSynthesizer.this.pTTSHandle[0], textBytes, textBytes.length);
            LoggerProxy.d(OfflineSynthesizer.TAG, "after bdttssynthesis result = " + iBdTTSSynthesis);
            Context context = PersistentPool.getInstance().getContext();
            if (iBdTTSSynthesis == 0) {
                SharedPreferencesUtils.putLong(context, "Success_Count", SharedPreferencesUtils.getLong(context, "Success_Count", 0L) + 1);
                return null;
            }
            SharedPreferencesUtils.putLong(context, "Fail_Count", SharedPreferencesUtils.getLong(context, "Fail_Count", 0L) + 1);
            return TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_ENGINE_SYNTHESIZE_ERROR, iBdTTSSynthesis);
        }
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return EmbeddedSynthesizerEngine.bdTTSDomainDataUninit(this.pTTSHandle[0]);
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError initial() {
        if (this.mSynthesizerParams == null) {
            this.mSynthesizerParams = new OfflineSynthesizerParams();
        }
        OfflineAuth.OfflineResult offlineResultAuthOffline = AuthClient.getInstance().authOffline(this.mSynthesizerParams);
        if (!offlineResultAuthOffline.isValid()) {
            return offlineResultAuthOffline.getError();
        }
        String textDatPath = this.mSynthesizerParams.getTextDatPath();
        String speechDatPath = this.mSynthesizerParams.getSpeechDatPath();
        String licenseFilePath = offlineResultAuthOffline.getLicenseFilePath();
        this.mSynthesizerParams.setTtsLicenseFilePath(licenseFilePath);
        String strBdTTSGetDatParam = !StringTool.isEmpty(speechDatPath) ? EmbeddedSynthesizerEngine.bdTTSGetDatParam(speechDatPath) : "";
        byte[] bArrStringToByteArrayAddNull = ResourceTools.stringToByteArrayAddNull(textDatPath);
        byte[] bArrStringToByteArrayAddNull2 = ResourceTools.stringToByteArrayAddNull(speechDatPath);
        byte[] bArrStringToByteArrayAddNull3 = ResourceTools.stringToByteArrayAddNull(licenseFilePath);
        Context context = PersistentPool.getInstance().getContext();
        LoggerProxy.d(TAG, "before bdTTSEngineInit SpeechInfo: " + strBdTTSGetDatParam);
        SharedPreferencesUtils.putString(context, "offline_speechDatInfo", strBdTTSGetDatParam);
        int iBdTTSEngineInit = EmbeddedSynthesizerEngine.bdTTSEngineInit(context, bArrStringToByteArrayAddNull, bArrStringToByteArrayAddNull2, bArrStringToByteArrayAddNull3, this.pTTSHandle);
        LoggerProxy.d(TAG, "engine init ret = " + iBdTTSEngineInit);
        if (iBdTTSEngineInit == 0) {
            return null;
        }
        return TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_ENGINE_INIT_FAILED, iBdTTSEngineInit, "bdTTSEngineInit result not 0");
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return EmbeddedSynthesizerEngine.bdTTSDomainDataInit(ResourceTools.stringToByteArrayAddNull(customResourceParams.getCustomModelPath()), this.pTTSHandle[0]);
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        String speechModelPath = englishModelParams.getSpeechModelPath();
        String textModelPath = englishModelParams.getTextModelPath();
        boolean zIsEmpty = TextUtils.isEmpty(speechModelPath);
        if (TextUtils.isEmpty(textModelPath) || zIsEmpty) {
            return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
        }
        int iLoadEnglishEngine = EmbeddedSynthesizerEngine.loadEnglishEngine(ResourceTools.stringToByteArrayAddNull(textModelPath), ResourceTools.stringToByteArrayAddNull(speechModelPath), this.pTTSHandle[0]);
        LoggerProxy.d(TAG, "loadEnglishModel ret=" + iLoadEnglishEngine);
        return iLoadEnglishEngine;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadModel(ModelParams modelParams) {
        String speechModelPath = modelParams.getSpeechModelPath();
        String textModelPath = modelParams.getTextModelPath();
        String ttsLicenseFilePath = this.mSynthesizerParams.getTtsLicenseFilePath();
        boolean zIsEmpty = TextUtils.isEmpty(speechModelPath);
        boolean zIsEmpty2 = TextUtils.isEmpty(textModelPath);
        boolean zIsEmpty3 = TextUtils.isEmpty(ttsLicenseFilePath);
        byte[] bArrStringToByteArrayAddNull = ResourceTools.stringToByteArrayAddNull(ttsLicenseFilePath);
        if (zIsEmpty && zIsEmpty2) {
            return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
        }
        if (zIsEmpty3) {
            return TtsErrorEnum.OFFLINE_ENGINE_AUTH_LICENSE_FILE_INVALID.getId();
        }
        Context context = PersistentPool.getInstance().getContext();
        return (!zIsEmpty2 ? EmbeddedSynthesizerEngine.bdTTSReInitData(context, ResourceTools.stringToByteArrayAddNull(textModelPath), bArrStringToByteArrayAddNull, this.pTTSHandle[0]) : 0) + (zIsEmpty ? 0 : EmbeddedSynthesizerEngine.bdTTSReInitData(context, ResourceTools.stringToByteArrayAddNull(speechModelPath), bArrStringToByteArrayAddNull, this.pTTSHandle[0]));
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError release() {
        EmbeddedSynthesizerEngine.bdTTSEngineUninit(this.pTTSHandle[0]);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public <OfflineSynthesizerParams> void setParam(OfflineSynthesizerParams offlinesynthesizerparams) {
        this.mSynthesizerParams = (OfflineSynthesizerParams) offlinesynthesizerparams;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError synthesize(TextParams textParams) throws InterruptedException {
        try {
            return new SynthesizeWork(textParams).call();
        } catch (InterruptedException e2) {
            throw e2;
        } catch (Exception e3) {
            return TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.OFFLINE_ENGINE_CALL_EXCEPTION, e3);
        }
    }
}
