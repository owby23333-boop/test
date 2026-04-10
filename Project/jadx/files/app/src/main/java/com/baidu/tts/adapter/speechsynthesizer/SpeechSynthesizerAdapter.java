package com.baidu.tts.adapter.speechsynthesizer;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.tts.TtsFactory;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizeBag;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import com.baidu.tts.concurrency.LimitQueueThreadPoolExecutor;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.MethodEnum;
import com.baidu.tts.enumtype.TimeOutEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;
import com.baidu.tts.tools.ResourceTools;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class SpeechSynthesizerAdapter {
    private static final String TAG = "SpeechSynthesizerAdapter";
    private ThreadPoolExecutor mExecutor;
    private SpeechSynthesizerListener mSpeechSynthesizerListener;
    private TtsListener mTtsListener = new TtsListener() { // from class: com.baidu.tts.adapter.speechsynthesizer.SpeechSynthesizerAdapter.1
        private boolean isStopped(ResponseBag responseBag) {
            try {
                int i2 = AnonymousClass2.$SwitchMap$com$baidu$tts$enumtype$TtsErrorEnum[responseBag.getTtsError().getTtsErrorFlyweight().getTtsErrorEnum().ordinal()];
                return i2 == 1 || i2 == 2 || i2 == 3;
            } catch (Exception e2) {
                LoggerProxy.d(SpeechSynthesizerAdapter.TAG, "isStopped exception=" + e2.toString());
                return false;
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onError(ResponseBag responseBag) {
            if (SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener == null || isStopped(responseBag)) {
                return;
            }
            SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener.onError(SpeechSynthesizerAdapter.this.getUtteranceId(responseBag), SpeechSynthesizerAdapter.this.getSpeechError(responseBag));
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayFinished(ResponseBag responseBag) {
            if (SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener != null) {
                SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener.onSpeechFinish(SpeechSynthesizerAdapter.this.getUtteranceId(responseBag));
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayProgressUpdate(ResponseBag responseBag) {
            if (SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener != null) {
                SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener.onSpeechProgressChanged(SpeechSynthesizerAdapter.this.getUtteranceId(responseBag), responseBag.getProgress());
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onPlayStart(ResponseBag responseBag) {
            if (SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener != null) {
                SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener.onSpeechStart(SpeechSynthesizerAdapter.this.getUtteranceId(responseBag));
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onSynthesizeDataArrived(ResponseBag responseBag) {
            if (SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener != null) {
                SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener.onSynthesizeDataArrived(SpeechSynthesizerAdapter.this.getUtteranceId(responseBag), responseBag.getAudioData(), responseBag.getProgress(), responseBag.getEngineType());
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onSynthesizeFinished(ResponseBag responseBag) {
            if (SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener != null) {
                SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener.onSynthesizeFinish(SpeechSynthesizerAdapter.this.getUtteranceId(responseBag));
            }
        }

        @Override // com.baidu.tts.aop.ttslistener.TtsListener
        public void onSynthesizeStart(ResponseBag responseBag) {
            if (SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener != null) {
                SpeechSynthesizerAdapter.this.mSpeechSynthesizerListener.onSynthesizeStart(SpeechSynthesizerAdapter.this.getUtteranceId(responseBag));
            }
        }
    };
    private ITts mTts = newProxy();

    /* JADX INFO: renamed from: com.baidu.tts.adapter.speechsynthesizer.SpeechSynthesizerAdapter$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$tts$enumtype$TtsErrorEnum = new int[TtsErrorEnum.values().length];

        static {
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsErrorEnum[TtsErrorEnum.MIX_AUTH_INTERRUPTED_EXCEPTION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsErrorEnum[TtsErrorEnum.OFFLINE_AUTH_INTERRUPTED_EXCEPTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$tts$enumtype$TtsErrorEnum[TtsErrorEnum.ONLINE_AUTH_INTERRUPTED_EXCEPTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private class BatchSpeakWork implements Callable<Void> {
        List<SpeechSynthesizeBag> mBags;

        public BatchSpeakWork(List<SpeechSynthesizeBag> list) {
            this.mBags = list;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            int size;
            List<SpeechSynthesizeBag> list = this.mBags;
            if (list != null && (size = list.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    SpeechSynthesizeBag speechSynthesizeBag = this.mBags.get(i2);
                    if (speechSynthesizeBag != null) {
                        String text = speechSynthesizeBag.getText();
                        String utteranceId = speechSynthesizeBag.getUtteranceId();
                        if (TextUtils.isEmpty(utteranceId)) {
                            utteranceId = String.valueOf(i2);
                            speechSynthesizeBag.setUtteranceId(utteranceId);
                        }
                        if (Thread.currentThread().isInterrupted()) {
                            return null;
                        }
                        TextParams textParams = new TextParams(text, utteranceId);
                        textParams.setMethodEnum(MethodEnum.SPEAK);
                        SpeechSynthesizerAdapter.this.mTts.speak(textParams);
                    }
                }
            }
            return null;
        }
    }

    private class SpeakWork implements Callable<Void> {
        private String mText;
        private String mUtteranceId;

        public SpeakWork(String str, String str2) {
            this.mText = str;
            this.mUtteranceId = str2;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            TextParams textParams = new TextParams(this.mText, this.mUtteranceId);
            textParams.setMethodEnum(MethodEnum.SPEAK);
            SpeechSynthesizerAdapter.this.mTts.speak(textParams);
            return null;
        }
    }

    private class SynthesizeWork implements Callable<Void> {
        private String mText;
        private String mUtteranceId;

        public SynthesizeWork(String str, String str2) {
            this.mText = str;
            this.mUtteranceId = str2;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            TextParams textParams = new TextParams(this.mText, this.mUtteranceId);
            textParams.setMethodEnum(MethodEnum.SYNTHESIZE);
            SpeechSynthesizerAdapter.this.mTts.synthesize(textParams);
            return null;
        }
    }

    public SpeechSynthesizerAdapter() {
        this.mTts.setTtsListener(this.mTtsListener);
    }

    private int checkAndExecuteWork(String str, Callable<Void> callable) {
        TtsErrorEnum ttsErrorEnumIsTextValid = ResourceTools.isTextValid(str);
        return ttsErrorEnumIsTextValid == null ? executeWork(callable) : ttsErrorEnumIsTextValid.getId();
    }

    private int executeWork(Callable<Void> callable) {
        try {
            getExecutorService().submit(callable);
            return 0;
        } catch (RejectedExecutionException unused) {
            String str = " count=" + ((ThreadPoolExecutor) getExecutorService()).getQueue().size();
            return SpeechSynthesizer.ERROR_QUEUE_IS_FULL;
        } catch (Exception e2) {
            LoggerProxy.d(TAG, e2.toString());
            return SpeechSynthesizer.ERROR_QUEUE_IS_FULL;
        }
    }

    private synchronized ExecutorService getExecutorService() {
        if (this.mExecutor == null) {
            this.mExecutor = new LimitQueueThreadPoolExecutor(15000, "bdtts-SpeechSynthesizerPoolThread", new ThreadPoolExecutor.AbortPolicy());
        }
        return this.mExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpeechError getSpeechError(ResponseBag responseBag) {
        if (responseBag != null) {
            TtsError ttsError = responseBag.getTtsError();
            if (ttsError != null) {
                int detailCode = ttsError.getDetailCode();
                String detailMessage = ttsError.getDetailMessage();
                SpeechError speechError = new SpeechError();
                speechError.code = detailCode;
                speechError.description = detailMessage;
                return speechError;
            }
            LoggerProxy.d(TAG, "ttsError is null");
        }
        SpeechError speechError2 = new SpeechError();
        speechError2.code = TtsErrorEnum.TTS_ERROR_UNKNOW.getId();
        speechError2.description = TtsErrorEnum.TTS_ERROR_UNKNOW.getMessage();
        return speechError2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUtteranceId(ResponseBag responseBag) {
        TextParams textParams;
        if (responseBag != null && (textParams = responseBag.getTextParams()) != null) {
            return textParams.getUtteranceId();
        }
        LoggerProxy.d(TAG, "getUtteranceId null");
        return null;
    }

    private ITts newProxy() {
        return new TtsFactory().makeProxy();
    }

    private void stopExecutor() {
        ThreadPoolExecutor threadPoolExecutor = this.mExecutor;
        if (threadPoolExecutor != null) {
            if (!threadPoolExecutor.isShutdown()) {
                this.mExecutor.shutdownNow();
            }
            try {
                LoggerProxy.d(TAG, "isTerminated=" + this.mExecutor.awaitTermination(TimeOutEnum.DEFAULT.getMillSeconds(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException unused) {
                LoggerProxy.d(TAG, "InterruptedException");
            }
            this.mExecutor = null;
        }
    }

    public AuthInfo auth(TtsMode ttsMode) {
        return this.mTts.auth(ttsMode.getTtsEnum());
    }

    public int batchSpeak(List<SpeechSynthesizeBag> list) {
        return list.size() <= 100 ? executeWork(new BatchSpeakWork(list)) : SpeechSynthesizer.ERROR_LIST_IS_TOO_LONG;
    }

    int errorUninitial() {
        return -1;
    }

    public int freeCustomResource() {
        return this.mTts.freeCustomResource(null);
    }

    public TtsError initTts(TtsMode ttsMode) {
        this.mTts.setMode(ttsMode.getTtsEnum());
        return this.mTts.create();
    }

    public String libVersion() {
        return PersistentPool.getInstance().getVersion();
    }

    public int loadCustomResource(String str) {
        CustomResourceParams customResourceParams = new CustomResourceParams();
        customResourceParams.setCustomModelPath(str);
        return this.mTts.loadCustomResource(customResourceParams);
    }

    public int loadEnglishModel(String str, String str2) {
        EnglishModelParams englishModelParams = new EnglishModelParams();
        englishModelParams.setTextModelPath(str);
        englishModelParams.setSpeechModelPath(str2);
        return this.mTts.loadEnglishModel(englishModelParams);
    }

    public int loadModel(String str, String str2) {
        ModelParams modelParams = new ModelParams();
        modelParams.setSpeechModelPath(str);
        modelParams.setTextModelPath(str2);
        return this.mTts.loadModel(modelParams);
    }

    public int pause() {
        ITts iTts = this.mTts;
        if (iTts == null) {
            return 0;
        }
        iTts.pause();
        return 0;
    }

    public int release() {
        stopExecutor();
        try {
            if (this.mTts == null) {
                return 0;
            }
            this.mTts.destroy();
            this.mTts = null;
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public int resume() {
        ITts iTts = this.mTts;
        if (iTts == null) {
            return 0;
        }
        iTts.resume();
        return 0;
    }

    public int setAudioAttributes(int i2, int i3) {
        return this.mTts.setAudioAttributes(i2, i3);
    }

    public int setAudioSampleRate(int i2) {
        return this.mTts.setAudioSampleRate(i2);
    }

    public int setAudioStreamType(int i2) {
        return this.mTts.setAudioStreamType(i2);
    }

    public void setContext(Context context) {
        this.mTts.setContext(context);
    }

    public int setParam(String str, String str2) {
        try {
            return this.mTts.setParam(KeyEnum.valueOf(str), str2);
        } catch (Exception unused) {
            return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
        }
    }

    public void setSpeechSynthesizerListener(SpeechSynthesizerListener speechSynthesizerListener) {
        if (this.mSpeechSynthesizerListener != speechSynthesizerListener) {
            this.mSpeechSynthesizerListener = speechSynthesizerListener;
        }
    }

    public int setStereoVolume(float f2, float f3) {
        return this.mTts.setStereoVolume(f2, f3);
    }

    public int speak(String str, String str2, Bundle bundle) {
        return checkAndExecuteWork(str, new SpeakWork(str, str2));
    }

    public int stop() {
        stopExecutor();
        ITts iTts = this.mTts;
        if (iTts == null) {
            return 0;
        }
        iTts.stop();
        return 0;
    }

    public int synthesize(String str, String str2, Bundle bundle) {
        return checkAndExecuteWork(str, new SynthesizeWork(str, str2));
    }
}
