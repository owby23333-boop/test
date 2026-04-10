package com.baidu.tts.client;

import android.content.Context;
import android.os.Bundle;
import com.anythink.expressad.foundation.d.c;
import com.baidu.tts.adapter.speechsynthesizer.SpeechSynthesizerAdapter;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.bridge.play.player.PlayCache2Tts;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.AudioEncoderFormat;
import com.baidu.tts.enumtype.Bitrate;
import com.baidu.tts.enumtype.CharSetEnum;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.LanguageEnum;
import com.baidu.tts.enumtype.MixMode;
import com.baidu.tts.enumtype.SampleRateEnum;
import com.baidu.tts.enumtype.TimeOutEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SpeechSynthesizer {
    public static final int MAX_LIST_SIZE = 100;
    public static final int MAX_QUEUE_SIZE = 15000;
    public static final String REQUEST_DNS_OFF = "0";
    public static final String REQUEST_DNS_ON = "1";
    public static final String REQUEST_PROTOCOL_HTTP = "http";
    public static final String REQUEST_PROTOCOL_HTTPS = "https";
    private static final String TAG = "SpeechSynthesizer==";
    public static final String VERSION_NAME = "2.6.2.4";
    public static final String VERSION_NAME_CODE = "2.6.2.2.4";
    private SpeechSynthesizerAdapter mSynthesizerAdapter = new SpeechSynthesizerAdapter();
    public static final int ERROR_QUEUE_IS_FULL = TtsErrorEnum.TTS_QUEUE_IS_FULL.getId();
    public static final int ERROR_LIST_IS_TOO_LONG = TtsErrorEnum.TTS_LIST_IS_TOO_LONG.getId();
    public static final int ERROR_TEXT_IS_EMPTY = TtsErrorEnum.TEXT_IS_EMPTY.getId();
    public static final int ERROR_TEXT_IS_TOO_LONG = TtsErrorEnum.TEXT_IS_TOO_LONG.getId();
    public static final int ERROR_TEXT_ENCODE_IS_WRONG = TtsErrorEnum.TEXT_ENCODE_IS_WRONG.getId();
    public static final int ERROR_APP_ID_IS_INVALID = TtsErrorEnum.TTS_APP_ID_IS_INVALID.getId();
    public static final String PARAM_REQUEST_PROTOCOL = KeyEnum.getUniqueName(KeyEnum.REQUEST_PROTOCOL);
    public static final String PARAM_REQUEST_ENABLE_DNS = KeyEnum.getUniqueName(KeyEnum.REQUEST_ENABLE_DNS);
    public static final String PARAM_PROXY_HOST = KeyEnum.getUniqueName(KeyEnum.PROXY_HOST);
    public static final String PARAM_PROXY_PORT = KeyEnum.getUniqueName(KeyEnum.PROXY_PORT);
    public static final String PARAM_URL = KeyEnum.getUniqueName(KeyEnum.URL);
    public static final String PARAM_AUDIO_CTRL = KeyEnum.getUniqueName(KeyEnum.AUDIO_CTRL);
    public static final String PARAM_TEXT_CTRL = KeyEnum.getUniqueName(KeyEnum.TEXT_CTRL);
    public static final String PARAM_SPEED = KeyEnum.getUniqueName(KeyEnum.SPEED);
    public static final String PARAM_PITCH = KeyEnum.getUniqueName(KeyEnum.PITCH);
    public static final String PARAM_VOLUME = KeyEnum.getUniqueName(KeyEnum.VOLUME);
    public static final String PARAM_SPEC = KeyEnum.getUniqueName(KeyEnum.SPEC);
    public static final String PARAM_TTS_TEXT_MODEL_FILE = KeyEnum.getUniqueName(KeyEnum.TEXT_DAT_PATH);
    public static final String PARAM_TTS_SPEECH_MODEL_FILE = KeyEnum.getUniqueName(KeyEnum.SPEECH_DAT_PATH);
    public static final String PARAM_TTS_LICENCE_FILE = KeyEnum.getUniqueName(KeyEnum.TTS_LICENSE_FILE_PATH);
    public static final String PARAM_VOCODER_OPTIM_LEVEL = KeyEnum.getUniqueName(KeyEnum.TTS_VOCODER_OPTIMIZATION);
    public static final String PARAM_CUSTOM_SYNTH = KeyEnum.getUniqueName(KeyEnum.CUSTOM_SYNTH);
    public static final String PARAM_OPEN_XML = KeyEnum.getUniqueName(KeyEnum.OPEN_XML);
    public static final String PARAM_BILINGUAL_MODE = KeyEnum.getUniqueName(KeyEnum.BILINGUAL_MODE);
    public static final String PARAM_PRODUCT_ID = KeyEnum.getUniqueName(KeyEnum.PRODUCT_ID);
    public static final String PARAM_KEY = KeyEnum.getUniqueName(KeyEnum.KEY);
    public static final String PARAM_AUTH_SN = KeyEnum.getUniqueName(KeyEnum.AUTH_SERIAL_NUMBER);
    public static final String PARAM_LANGUAGE = KeyEnum.getUniqueName(KeyEnum.LANGUAGE);
    public static final String PARAM_AUDIO_ENCODE = KeyEnum.getUniqueName(KeyEnum.AUDIO_ENCODE);
    public static final String PARAM_AUDIO_RATE = KeyEnum.getUniqueName(KeyEnum.BITRATE);
    public static final String PARAM_SPEAKER = KeyEnum.getUniqueName(KeyEnum.SPEAKER);
    public static final String PARAM_MIX_MODE = KeyEnum.getUniqueName(KeyEnum.MIX_MODE);
    public static final String MIX_MODE_DEFAULT = MixMode.DEFAULT.name();
    public static final String MIX_MODE_HIGH_SPEED_NETWORK = MixMode.HIGH_SPEED_NETWORK.name();
    public static final String PARAM_MIX_MODE_TIMEOUT = KeyEnum.getUniqueName(KeyEnum.MIX_ONLINE_REQUEST_TIMEOUT);
    public static final String PARAM_MIX_TIMEOUT_TWO_SECOND = TimeOutEnum.TWO_SECOND.name();
    public static final String PARAM_MIX_TIMEOUT_THREE_SECOND = TimeOutEnum.THREE_SECOND.name();
    public static final String PARAM_MIX_TIMEOUT_FOUR_SECOND = TimeOutEnum.FOUR_SECOND.name();
    public static final String MIX_MODE_HIGH_SPEED_SYNTHESIZE = MixMode.HIGH_SPEED_SYNTHESIZE.name();
    public static final String MIX_MODE_HIGH_SPEED_SYNTHESIZE_WIFI = MixMode.HIGH_SPEED_SYNTHESIZE_WIFI.name();
    public static final String LANGUAGE_ZH = LanguageEnum.ZH.getShortName();
    public static final String LANGUAGE_EN = LanguageEnum.EN.getShortName();
    public static final String TEXT_ENCODE_GBK = CharSetEnum.GB18030.getTag();
    public static final String TEXT_ENCODE_BIG5 = CharSetEnum.BIG5.getTag();
    public static final String TEXT_ENCODE_UTF8 = CharSetEnum.UTF8.getTag();
    public static final String AUDIO_ENCODE_BV = AudioEncoderFormat.BV.getTag();
    public static final String AUDIO_ENCODE_AMR = AudioEncoderFormat.AMR.getTag();
    public static final String AUDIO_ENCODE_OPUS = AudioEncoderFormat.OPUS.getTag();
    public static final String AUDIO_ENCODE_MP3 = AudioEncoderFormat.MP3.getTag();
    public static final String AUDIO_ENCODE_PCM = AudioEncoderFormat.PCM.getTag();
    public static final int AUDIO_SAMPLERATE_8K = SampleRateEnum.HZ8K.getHz();
    public static final int AUDIO_SAMPLERATE_16K = SampleRateEnum.HZ16K.getHz();
    public static final int AUDIO_SAMPLERATE_24K = SampleRateEnum.HZ24K.getHz();
    public static final int AUDIO_SAMPLERATE_48K = SampleRateEnum.HZ48K.getHz();
    public static final String AUDIO_BITRATE_BV_16K = Bitrate.BV_16K.getTag();
    public static final String AUDIO_BITRATE_AMR_6K6 = Bitrate.AMR_6K6.getTag();
    public static final String AUDIO_BITRATE_AMR_8K85 = Bitrate.AMR_8K85.getTag();
    public static final String AUDIO_BITRATE_AMR_12K65 = Bitrate.AMR_12K65.getTag();
    public static final String AUDIO_BITRATE_AMR_14K25 = Bitrate.AMR_14K25.getTag();
    public static final String AUDIO_BITRATE_AMR_15K85 = Bitrate.AMR_15K85.getTag();
    public static final String AUDIO_BITRATE_AMR_18K25 = Bitrate.AMR_18K25.getTag();
    public static final String AUDIO_BITRATE_AMR_19K85 = Bitrate.AMR_19K85.getTag();
    public static final String AUDIO_BITRATE_AMR_23K05 = Bitrate.AMR_23K05.getTag();
    public static final String AUDIO_BITRATE_AMR_23K85 = Bitrate.AMR_23K85.getTag();
    public static final String AUDIO_BITRATE_OPUS_8K = Bitrate.OPUS_8K.getTag();
    public static final String AUDIO_BITRATE_OPUS_16K = Bitrate.OPUS_16K.getTag();
    public static final String AUDIO_BITRATE_OPUS_18K = Bitrate.OPUS_18K.getTag();
    public static final String AUDIO_BITRATE_OPUS_20K = Bitrate.OPUS_20K.getTag();
    public static final String AUDIO_BITRATE_OPUS_24K = Bitrate.OPUS_24K.getTag();
    public static final String AUDIO_BITRATE_OPUS_32K = Bitrate.OPUS_32K.getTag();
    public static final String AUDIO_BITRATE_PCM = Bitrate.PCM.getTag();
    private static volatile SpeechSynthesizer mInstance = null;

    private SpeechSynthesizer() {
    }

    public static SpeechSynthesizer getInstance() {
        LoggerProxy.d(TAG, "SpeechSynthesizer getInstance versionName:2.6.2.4");
        if (mInstance == null) {
            synchronized (SpeechSynthesizer.class) {
                if (mInstance == null) {
                    mInstance = new SpeechSynthesizer();
                }
            }
        }
        return mInstance;
    }

    public AuthInfo auth(TtsMode ttsMode) {
        LoggerProxy.d(TAG, "auth  ttsMode: " + ttsMode.getMode());
        return this.mSynthesizerAdapter.auth(ttsMode);
    }

    public int batchSpeak(List<SpeechSynthesizeBag> list) {
        return DataTool.isListEmpty(list) ? TtsErrorEnum.TTS_PARAMETER_INVALID.getId() : this.mSynthesizerAdapter.batchSpeak(list);
    }

    public int freeCustomResource() {
        LoggerProxy.d(TAG, "freeCustomResource: ");
        return this.mSynthesizerAdapter.freeCustomResource();
    }

    public synchronized int initTts(TtsMode ttsMode) {
        TtsError ttsErrorInitTts;
        LoggerProxy.d(TAG, "VersionName: 2.6.2.4 VersionName_CODE: 2.6.2.2.4 initTts ttsMode:" + ttsMode);
        ttsErrorInitTts = this.mSynthesizerAdapter.initTts(ttsMode);
        return ttsErrorInitTts == null ? 0 : ttsErrorInitTts.getDetailCode();
    }

    public String libVersion() {
        return this.mSynthesizerAdapter.libVersion();
    }

    public int loadCustomResource(String str) {
        LoggerProxy.d(TAG, "loadCustomResource: " + str);
        return this.mSynthesizerAdapter.loadCustomResource(str);
    }

    public int loadEnglishModel(String str, String str2) {
        return this.mSynthesizerAdapter.loadEnglishModel(str, str2);
    }

    public int loadModel(String str, String str2) {
        LoggerProxy.d(TAG, "loadModel: " + str + " " + str2);
        return this.mSynthesizerAdapter.loadModel(str, str2);
    }

    public synchronized int pause() {
        LoggerProxy.d(TAG, c.cb);
        return this.mSynthesizerAdapter.pause();
    }

    public synchronized int release() {
        LoggerProxy.d(TAG, "release");
        this.mSynthesizerAdapter.release();
        mInstance = null;
        return 0;
    }

    public synchronized int resume() {
        LoggerProxy.d(TAG, c.cc);
        return this.mSynthesizerAdapter.resume();
    }

    public int setApiKey(String str, String str2) {
        setParam(KeyEnum.API_KEY.name(), str);
        setParam(KeyEnum.SECRET_KEY.name(), str2);
        return 0;
    }

    public int setAppId(String str) {
        if (!StringTool.isAllNumber(str)) {
            return ERROR_APP_ID_IS_INVALID;
        }
        setParam(KeyEnum.APP_CODE.name(), str);
        return 0;
    }

    public int setAudioAttributes(int i2, int i3) {
        LoggerProxy.d(TAG, "setAudioAttributes usage:" + i2 + " contentType:" + i3);
        return this.mSynthesizerAdapter.setAudioAttributes(i2, i3);
    }

    public int setAudioSampleRate(int i2) {
        LoggerProxy.d(TAG, "setAudioSampleRate ");
        return this.mSynthesizerAdapter.setAudioSampleRate(i2);
    }

    public int setAudioStreamType(int i2) {
        LoggerProxy.d(TAG, "setAudioStreamType: " + i2);
        return this.mSynthesizerAdapter.setAudioStreamType(i2);
    }

    public void setContext(Context context) {
        LoggerProxy.d(TAG, "setContext");
        this.mSynthesizerAdapter.setContext(context);
    }

    public void setEnableAECPlay(boolean z2) {
        LoggerProxy.d(TAG, "setEnableAECPlay " + z2);
        PlayCache2Tts.setEnableAecPlay(z2);
    }

    public int setParam(String str, String str2) {
        LoggerProxy.d(TAG, "setParam key: " + str + " value:" + str2);
        return this.mSynthesizerAdapter.setParam(str, str2);
    }

    public void setSpeechSynthesizerListener(SpeechSynthesizerListener speechSynthesizerListener) {
        LoggerProxy.d(TAG, "setSpeechSynthesizerListener");
        this.mSynthesizerAdapter.setSpeechSynthesizerListener(speechSynthesizerListener);
    }

    public int setStereoVolume(float f2, float f3) {
        LoggerProxy.d(TAG, "setStereoVolume: " + f2 + " " + f3);
        return this.mSynthesizerAdapter.setStereoVolume(f2, f3);
    }

    public int speak(String str) {
        return speak(str, null);
    }

    public synchronized int stop() {
        LoggerProxy.d(TAG, "stop");
        return this.mSynthesizerAdapter.stop();
    }

    public int synthesize(String str) {
        return synthesize(str, null);
    }

    public int speak(SpeechSynthesizeBag speechSynthesizeBag) {
        try {
            return speak(speechSynthesizeBag.getText(), speechSynthesizeBag.getUtteranceId());
        } catch (Exception unused) {
            return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
        }
    }

    public int synthesize(SpeechSynthesizeBag speechSynthesizeBag) {
        try {
            return synthesize(speechSynthesizeBag.getText(), speechSynthesizeBag.getUtteranceId());
        } catch (Exception unused) {
            return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
        }
    }

    public int speak(String str, String str2) {
        return speak(str, str2, null);
    }

    public int synthesize(String str, String str2) {
        return synthesize(str, str2, null);
    }

    public int speak(String str, String str2, Bundle bundle) {
        LoggerProxy.d(TAG, "speak  text: " + str);
        return this.mSynthesizerAdapter.speak(str, str2, bundle);
    }

    public int synthesize(String str, String str2, Bundle bundle) {
        LoggerProxy.d(TAG, "synthesize  text: " + str);
        return this.mSynthesizerAdapter.synthesize(str, str2, bundle);
    }
}
