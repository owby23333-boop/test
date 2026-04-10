package com.baidu.tts.bridge.engine.synthesizer;

import android.content.Context;
import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.AuthClient;
import com.baidu.tts.auth.OnlineAuth;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.AudioDataFormat;
import com.baidu.tts.enumtype.AudioEncoderFormat;
import com.baidu.tts.enumtype.Bitrate;
import com.baidu.tts.enumtype.EngineEnum;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.SampleRateEnum;
import com.baidu.tts.enumtype.TimeOutEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.enumtype.UrlEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.flyweight.persistent.PersistentPool;
import com.baidu.tts.network.HttpClientUtil;
import com.baidu.tts.network.TtsResponseHandler;
import com.baidu.tts.param.BaseSynthesizerParams;
import com.baidu.tts.param.CustomResourceParams;
import com.baidu.tts.param.EnglishModelParams;
import com.baidu.tts.param.ModelParams;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.param.TextParams;
import com.baidu.tts.throwable.TokenNullException;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.SharedPreferencesUtils;
import com.baidu.tts.tools.StringTool;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineSynthesizer extends ASynthesizer {
    private static final String TAG = "OnlineSynthesizer";
    private double bitrate;
    private OnlineSynthesizerParams mSynthesizerParams;

    private class OnceHttpRequestWork implements Callable<ResponseBag> {
        private HttpClientUtil mHttpClinet;
        private int mIndex;
        private OnlineSynthesizerParams mParams;
        private ResponseBag mResponseBag;
        private SessionInfo mSessionInfo;
        private TextParams mTextParams;

        public OnceHttpRequestWork(int i2, SessionInfo sessionInfo, TextParams textParams, OnlineSynthesizerParams onlineSynthesizerParams, ResponseBag responseBag) {
            this.mIndex = i2;
            this.mSessionInfo = sessionInfo;
            this.mTextParams = textParams;
            this.mParams = onlineSynthesizerParams;
            this.mResponseBag = responseBag;
        }

        public void stop() {
            HttpClientUtil httpClientUtil = this.mHttpClinet;
            if (httpClientUtil != null) {
                httpClientUtil.stop();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public ResponseBag call() throws Exception {
            try {
                String httpEntity = OnlineSynthesizer.this.getHttpEntity(this.mIndex, this.mSessionInfo.mSn, this.mTextParams, this.mParams);
                String requestProtocol = this.mParams.getRequestProtocol();
                if (this.mIndex == 1) {
                    String requestMode = this.mParams.getRequestMode();
                    if (this.mParams.getUrl() != null) {
                        this.mSessionInfo.mServerIp = this.mParams.getUrl();
                        if ("1".equals(requestMode)) {
                            String host = new URL(this.mParams.getUrl()).getHost();
                            String hostAddress = InetAddress.getByName(host).getHostAddress();
                            this.mSessionInfo.mServerIp = this.mParams.getUrl().replace(host, hostAddress);
                            LoggerProxy.d(OnlineSynthesizer.TAG, "localDNS: " + hostAddress);
                        }
                    } else if ("1".equals(requestMode)) {
                        this.mSessionInfo.mServerIp = UrlEnum.TTS_SERVER.getIpUrlByProtocol(requestProtocol);
                    } else {
                        this.mSessionInfo.mServerIp = UrlEnum.TTS_SERVER.getUrlByProtocol(requestProtocol);
                    }
                    LoggerProxy.d(OnlineSynthesizer.TAG, "serverIp=" + this.mSessionInfo.mServerIp);
                }
                if (this.mSessionInfo.mServerIp == null) {
                    this.mResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_SERVER_IP_IS_NULL));
                    return this.mResponseBag;
                }
                this.mHttpClinet = new HttpClientUtil();
                int timeout = this.mParams.getTimeout();
                LoggerProxy.d(OnlineSynthesizer.TAG, "timeout=" + timeout);
                this.mHttpClinet.setTimeOut(timeout);
                TtsResponseHandler ttsResponseHandler = new TtsResponseHandler(this.mResponseBag);
                String proxyHost = this.mParams.getProxyHost();
                if (proxyHost != null) {
                    int proxyPort = this.mParams.getProxyPort();
                    LoggerProxy.d(OnlineSynthesizer.TAG, "--> proxy host=" + proxyHost + "--port=" + proxyPort);
                    this.mHttpClinet.setProxy(proxyHost, proxyPort);
                }
                if (this.mSessionInfo.mServerIp == null) {
                    this.mResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_SERVER_IP_IS_NULL));
                } else if (!Thread.currentThread().isInterrupted()) {
                    LoggerProxy.d(OnlineSynthesizer.TAG, "before post");
                    this.mHttpClinet.post(this.mSessionInfo.mServerIp, httpEntity, ttsResponseHandler);
                    LoggerProxy.d(OnlineSynthesizer.TAG, "after post");
                }
                return this.mResponseBag;
            } catch (TokenNullException unused) {
                this.mResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_TOKEN_IS_NULL));
                return this.mResponseBag;
            }
        }
    }

    public static class OnlineSynthesizerParams extends BaseSynthesizerParams<OnlineSynthesizerParams> {
        private static Set<String> mKeys = new HashSet();
        private static final long serialVersionUID = -953876865698529870L;
        private String mApiKey;
        private String mAudioCtrl;
        private String mBackground;
        private String mEngPron;
        private String mKey;
        private String mNumPron;
        private String mProductId;
        private String mProxyHost;
        private String mPunc;
        private String mSecretKey;
        private String mStyle;
        private String mTerritory;
        private String mTextCtrl;
        private String mUrl;
        private AudioEncoderFormat mAudioEncode = AudioEncoderFormat.OPUS;
        private Bitrate mAudioRate = Bitrate.OPUS_16K;
        private String mSpeaker = "0";
        private int mRetry = 5;
        private int mRetryTimeInterval = 1000;
        private int mTimeout = TimeOutEnum.DEFAULT.getMillSecondsInt();
        private int mProxyPort = -1;
        private String mRequestProtocol = "https";
        private String mRequestMode = "1";

        static {
            mKeys.add(KeyEnum.SPEED.getFullName());
        }

        public static boolean isExist(String str) {
            return mKeys.contains(str);
        }

        public String getApiKey() {
            return this.mApiKey;
        }

        public String getAudioCtrl() {
            return this.mAudioCtrl;
        }

        public AudioEncoderFormat getAudioEncode() {
            return this.mAudioEncode;
        }

        public String getAudioEncodeTag() {
            return this.mAudioEncode.getTag();
        }

        public Bitrate getAudioRate() {
            return this.mAudioRate;
        }

        public String getBackground() {
            return this.mBackground;
        }

        public String getBitrateTag() {
            return this.mAudioRate.getTag();
        }

        public String getEngPron() {
            return this.mEngPron;
        }

        public String getKey() {
            return this.mKey;
        }

        public String getNumPron() {
            return this.mNumPron;
        }

        public String getProductId() {
            return this.mProductId;
        }

        public String getProxyHost() {
            return this.mProxyHost;
        }

        public int getProxyPort() {
            return this.mProxyPort;
        }

        public String getPunc() {
            return this.mPunc;
        }

        public String getRequestMode() {
            return this.mRequestMode;
        }

        public String getRequestProtocol() {
            return this.mRequestProtocol;
        }

        public int getRetry() {
            return this.mRetry;
        }

        public int getRetryTimeInterval() {
            return this.mRetryTimeInterval;
        }

        public String getSecretKey() {
            return this.mSecretKey;
        }

        public String getSpeaker() {
            return this.mSpeaker;
        }

        public String getStyle() {
            return this.mStyle;
        }

        public String getTerritory() {
            return this.mTerritory;
        }

        public String getTextCtrl() {
            return this.mTextCtrl;
        }

        public int getTimeout() {
            return this.mTimeout;
        }

        public String getUrl() {
            return this.mUrl;
        }

        public void setApiKey(String str) {
            this.mApiKey = str;
        }

        public void setAudioCtrl(String str) {
            this.mAudioCtrl = str;
        }

        public int setAudioEncode(AudioEncoderFormat audioEncoderFormat) {
            if (audioEncoderFormat == null) {
                return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
            }
            this.mAudioEncode = audioEncoderFormat;
            return 0;
        }

        public void setAudioRate(Bitrate bitrate) {
            this.mAudioRate = bitrate;
        }

        public void setBackground(String str) {
            this.mBackground = str;
        }

        public void setEngPron(String str) {
            this.mEngPron = str;
        }

        public void setKey(String str) {
            this.mKey = str;
        }

        public void setNumPron(String str) {
            this.mNumPron = str;
        }

        public void setProductId(String str) {
            this.mProductId = str;
        }

        public void setProxyHost(String str) {
            this.mProxyHost = str;
        }

        public void setProxyPort(int i2) {
            this.mProxyPort = i2;
        }

        public void setPunc(String str) {
            this.mPunc = str;
        }

        public void setRequestMode(String str) {
            this.mRequestMode = str;
        }

        public void setRequestProtocol(String str) {
            this.mRequestProtocol = str;
        }

        public void setRetry(int i2) {
            this.mRetry = i2;
        }

        public void setRetryTimeInterval(int i2) {
            this.mRetryTimeInterval = i2;
        }

        public void setSecretKey(String str) {
            this.mSecretKey = str;
        }

        public void setSpeaker(String str) {
            this.mSpeaker = str;
        }

        public void setStyle(String str) {
            this.mStyle = str;
        }

        public void setTerritory(String str) {
            this.mTerritory = str;
        }

        public void setTextCtrl(String str) {
            this.mTextCtrl = str;
        }

        public void setTimeout(int i2) {
            this.mTimeout = i2;
        }

        public void setUrl(String str) {
            this.mUrl = str;
        }
    }

    private class SessionInfo {
        String mServerIp;
        String mSn = CommonUtility.generateSerialNumber();

        public SessionInfo() {
        }
    }

    private class SynthesizeWork implements Callable<TtsError>, SpeechDecoder.OnDecodedDataListener {
        private ResponseBag mCallbackResponseBag;
        private SessionInfo mSessionInfo;
        private TextParams mTextParams;
        private SampleRateEnum sampleRateEnum = SampleRateEnum.HZ16K;
        private int lastProgress = 0;
        private int mIndex = 1;
        byte[] decodedAudios = new byte[0];
        private SpeechDecoder mSpeechDecoder = new SpeechDecoder();

        public SynthesizeWork(TextParams textParams) {
            this.mTextParams = textParams;
            this.mSessionInfo = OnlineSynthesizer.this.new SessionInfo();
        }

        private byte[] byteMerger(byte[] bArr, byte[] bArr2) {
            byte[] bArr3 = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
            return bArr3;
        }

        private boolean isFinish(ResponseBag responseBag) {
            return !isResponseRight(responseBag) || responseBag.getCount() < 0;
        }

        private boolean isResponseRight(ResponseBag responseBag) {
            return responseBag != null && responseBag.getTtsError() == null && responseBag.getErrNo() == 0;
        }

        private void setNewResponseBag(int i2) {
            LoggerProxy.d(OnlineSynthesizer.TAG, "mindex=" + this.mIndex + " progress=" + i2);
            ResponseBag responseBagShallowClone = this.mCallbackResponseBag.shallowClone();
            responseBagShallowClone.setAudioData(this.decodedAudios);
            responseBagShallowClone.setEngineType(EngineEnum.ONLINE.getType());
            responseBagShallowClone.setAudioDataFormat(AudioDataFormat.PCM);
            responseBagShallowClone.setIndex(this.mIndex);
            responseBagShallowClone.setProgress(i2);
            OnlineSynthesizer.this.synthesizeDataArrived(responseBagShallowClone);
            this.mIndex++;
            this.decodedAudios = new byte[0];
        }

        @Override // com.baidu.speechsynthesizer.utility.SpeechDecoder.OnDecodedDataListener
        public void onDecodedData(byte[] bArr) {
            try {
                this.decodedAudios = byteMerger(this.decodedAudios, bArr);
                int length = this.decodedAudios.length;
                if (length >= 3200) {
                    int length2 = this.mCallbackResponseBag.getAudioData().length;
                    int progress = this.mCallbackResponseBag.getProgress();
                    double d2 = length;
                    Double.isNaN(d2);
                    double d3 = d2 / 32000.0d;
                    double d4 = length2 * 8;
                    double d5 = OnlineSynthesizer.this.bitrate;
                    Double.isNaN(d4);
                    double d6 = d3 / (d4 / d5);
                    double d7 = this.lastProgress;
                    double d8 = progress - this.lastProgress;
                    Double.isNaN(d8);
                    double d9 = d6 * d8;
                    double d10 = this.mIndex;
                    Double.isNaN(d10);
                    Double.isNaN(d7);
                    setNewResponseBag((int) (d7 + (d9 * d10)));
                }
                if (bArr.length == 0) {
                    if (length < 3200) {
                        setNewResponseBag(this.mCallbackResponseBag.getProgress());
                    }
                    this.lastProgress = this.mCallbackResponseBag.getProgress();
                    this.mIndex = 1;
                    if (this.mCallbackResponseBag.getCount() < 0) {
                        this.lastProgress = 0;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public TtsError call() throws Exception {
            ResponseBag responseBagStartOnceHttpRequest;
            SpeechDecoder.setOnDecodedDataListener(this);
            int i2 = 0;
            do {
                i2++;
                LoggerProxy.d(OnlineSynthesizer.TAG, "count=" + i2);
                responseBagStartOnceHttpRequest = OnlineSynthesizer.this.startOnceHttpRequest(i2, this.mSessionInfo, this.mTextParams);
                if (isResponseRight(responseBagStartOnceHttpRequest)) {
                    if (i2 == 1) {
                        this.sampleRateEnum = responseBagStartOnceHttpRequest.getSampleRate();
                    } else {
                        responseBagStartOnceHttpRequest.setSampleRate(this.sampleRateEnum);
                    }
                    this.mCallbackResponseBag = responseBagStartOnceHttpRequest;
                    byte[] audioData = responseBagStartOnceHttpRequest.getAudioData();
                    if (audioData == null) {
                        return TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR);
                    }
                    if (OnlineSynthesizer.this.mSynthesizerParams.getAudioEncode() == AudioEncoderFormat.PCM) {
                        OnlineSynthesizer.this.synthesizeDataArrived(responseBagStartOnceHttpRequest);
                    } else if (audioData.length == 0 && i2 == 1) {
                        OnlineSynthesizer.this.synthesizeDataArrived(responseBagStartOnceHttpRequest);
                    } else {
                        int iDecodeWithCallback = this.mSpeechDecoder.decodeWithCallback(audioData, responseBagStartOnceHttpRequest.getCount());
                        LoggerProxy.d(OnlineSynthesizer.TAG, "Decoder ret : " + iDecodeWithCallback);
                        if (iDecodeWithCallback != 0 && i2 == 1) {
                            throw new Exception("Audio Decoder failed");
                        }
                    }
                }
            } while (!isFinish(responseBagStartOnceHttpRequest));
            if (responseBagStartOnceHttpRequest != null) {
                return responseBagStartOnceHttpRequest.getTtsError();
            }
            LoggerProxy.d(OnlineSynthesizer.TAG, "response is null");
            return TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_CALL_EXCEPTION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getHttpEntity(int i2, String str, TextParams textParams, OnlineSynthesizerParams onlineSynthesizerParams) throws TokenNullException {
        String strUrlEncoded = null;
        if (onlineSynthesizerParams == null) {
            return null;
        }
        HashMap map = new HashMap();
        map.put(KeyEnum.INDEX.getShortName(), String.valueOf(i2));
        map.put(KeyEnum.SERIAL_NUMBER.getShortName(), str);
        map.put(KeyEnum.PLATFORM.getFullName(), "Android");
        PersistentPool persistentPool = PersistentPool.getInstance();
        map.put(KeyEnum.VERSION.getShortName(), persistentPool.getVersion());
        String productId = onlineSynthesizerParams.getProductId();
        if (!StringTool.isEmpty(productId)) {
            map.put(KeyEnum.PRODUCT_ID.getShortName(), productId);
        }
        String key = onlineSynthesizerParams.getKey();
        if (!StringTool.isEmpty(key)) {
            map.put(KeyEnum.KEY.getShortName(), key);
        }
        textParams.setTextEncode(onlineSynthesizerParams.getTextEncodeCharset());
        String textEncode = textParams.getTextEncode();
        if (i2 == 1) {
            try {
                map.put(KeyEnum.TEXT.getShortName(), URLEncoder.encode(textParams.getText(), textEncode));
                map.put(KeyEnum.CTP.getShortName(), persistentPool.getString(KeyEnum.CTP.getShortName()));
                String deviceId = persistentPool.getDeviceId();
                if (deviceId != null) {
                    map.put(KeyEnum.CUID.getShortName(), deviceId);
                }
                if (StringTool.isEmpty(productId)) {
                    LoggerProxy.d(TAG, "before online auth");
                    OnlineAuth.OnlineResult onlineResultAuthOnline = AuthClient.getInstance().authOnline(onlineSynthesizerParams);
                    LoggerProxy.d(TAG, "after online auth");
                    if (!onlineResultAuthOnline.isValid()) {
                        throw new TokenNullException();
                    }
                    map.put(KeyEnum.TOKEN.getShortName(), onlineResultAuthOnline.getAccessToken());
                }
                map.put(KeyEnum.TEXT_ENCODE.getShortName(), onlineSynthesizerParams.getTextEncodeTag());
                map.put(KeyEnum.AUDIO_ENCODE.getShortName(), onlineSynthesizerParams.getAudioEncodeTag());
                map.put(KeyEnum.BITRATE.getShortName(), onlineSynthesizerParams.getBitrateTag());
                this.bitrate = onlineSynthesizerParams.getAudioEncode().getSupportBitrates()[Integer.parseInt(onlineSynthesizerParams.getBitrateTag())].getBitrate();
                map.put(KeyEnum.SPEAKER.getShortName(), onlineSynthesizerParams.getSpeaker());
                map.put(KeyEnum.NUMBER.getShortName(), onlineSynthesizerParams.getNumPron());
                map.put(KeyEnum.ENGINE.getShortName(), onlineSynthesizerParams.getEngPron());
                map.put(KeyEnum.STYLE.getShortName(), onlineSynthesizerParams.getStyle());
                map.put(KeyEnum.BACKGROUND.getShortName(), onlineSynthesizerParams.getBackground());
                map.put(KeyEnum.TERRITORY.getShortName(), onlineSynthesizerParams.getTerritory());
                map.put(KeyEnum.PUNCTUATION.getShortName(), onlineSynthesizerParams.getPunc());
                map.put(KeyEnum.LANGUAGE.getShortName(), onlineSynthesizerParams.getLanguage());
                map.put(KeyEnum.SPEED.getShortName(), onlineSynthesizerParams.getSpeed());
                map.put(KeyEnum.PITCH.getShortName(), onlineSynthesizerParams.getPitch());
                map.put(KeyEnum.VOLUME.getShortName(), onlineSynthesizerParams.getVolume());
                map.put(KeyEnum.OPEN_XML.getShortName(), onlineSynthesizerParams.getOpenXml());
                String audioCtrl = onlineSynthesizerParams.getAudioCtrl();
                if (audioCtrl != null) {
                    map.put(KeyEnum.AUDIO_CTRL.getShortName(), audioCtrl);
                }
                String textCtrl = onlineSynthesizerParams.getTextCtrl();
                if (textCtrl != null) {
                    map.put(KeyEnum.TEXT_CTRL.getShortName(), textCtrl);
                }
                Context context = persistentPool.getContext();
                int iNextInt = SharedPreferencesUtils.getInt(context, KeyEnum.CUID_NUM.getShortName());
                if (iNextInt < 0) {
                    iNextInt = new Random().nextInt(100000000);
                    SharedPreferencesUtils.putInt(context, KeyEnum.CUID_NUM.getShortName(), iNextInt);
                }
                map.put(KeyEnum.CUID_NUM.getShortName(), iNextInt + "");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        try {
            strUrlEncoded = CommonUtility.urlEncoded(map);
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        LoggerProxy.d(TAG, "request params: " + strUrlEncoded);
        return strUrlEncoded;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResponseBag startOnceHttpRequest(int i2, SessionInfo sessionInfo, TextParams textParams) throws InterruptedException {
        ResponseBag responseBagNewResponseBag = ResponseBag.newResponseBag(textParams);
        OnceHttpRequestWork onceHttpRequestWork = new OnceHttpRequestWork(i2, sessionInfo, textParams, this.mSynthesizerParams.shallowClone(), responseBagNewResponseBag);
        FutureTask futureTask = new FutureTask(onceHttpRequestWork);
        Thread thread = new Thread(futureTask);
        thread.setName("bdtts-OnlineSynthesizer");
        thread.start();
        try {
            return (ResponseBag) futureTask.get(r8.getTimeout(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            futureTask.cancel(true);
            onceHttpRequestWork.stop();
            throw e2;
        } catch (ExecutionException e3) {
            e3.printStackTrace();
            responseBagNewResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_GET_EXECUTION_EXCEPTION, e3.getCause()));
            return responseBagNewResponseBag;
        } catch (TimeoutException e4) {
            LoggerProxy.d(TAG, "startOnceHttpRequest timeout");
            futureTask.cancel(true);
            onceHttpRequestWork.stop();
            responseBagNewResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_GET_TIMEOUT, e4));
            return responseBagNewResponseBag;
        }
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int freeCustomResource(CustomResourceParams customResourceParams) {
        return TtsErrorEnum.ONLINE_UNSUPPORTED_OPERATION.getId();
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadCustomResource(CustomResourceParams customResourceParams) {
        return TtsErrorEnum.ONLINE_UNSUPPORTED_OPERATION.getId();
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadEnglishModel(EnglishModelParams englishModelParams) {
        return TtsErrorEnum.ONLINE_UNSUPPORTED_OPERATION.getId();
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public int loadModel(ModelParams modelParams) {
        return TtsErrorEnum.ONLINE_UNSUPPORTED_OPERATION.getId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public <OnlineSynthesizerParams> void setParam(OnlineSynthesizerParams onlinesynthesizerparams) {
        this.mSynthesizerParams = (OnlineSynthesizerParams) onlinesynthesizerparams;
    }

    @Override // com.baidu.tts.bridge.engine.synthesizer.ASynthesizer, com.baidu.tts.bridge.engine.synthesizer.ISynthesizer
    public TtsError synthesize(TextParams textParams) throws InterruptedException {
        try {
            return new SynthesizeWork(textParams).call();
        } catch (InterruptedException e2) {
            throw e2;
        } catch (Exception e3) {
            e3.printStackTrace();
            return TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_CALL_EXCEPTION, e3);
        }
    }
}
