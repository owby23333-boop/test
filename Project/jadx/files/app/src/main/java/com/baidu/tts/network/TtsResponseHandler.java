package com.baidu.tts.network;

import com.anythink.expressad.foundation.g.a;
import com.baidu.tts.adapter.audiotransition.AudioDecoder;
import com.baidu.tts.adapter.audiotransition.AudioDecoderAdapter;
import com.baidu.tts.bridge.engine.synthesizer.OnlineSynthesizer;
import com.baidu.tts.bridge.play.player.PlayCache2Tts;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.enumtype.SampleRateEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.flyweight.error.TtsErrorPool;
import com.baidu.tts.param.ResponseBag;
import com.baidu.tts.tools.CommonUtility;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TtsResponseHandler extends ResponseHandler {
    private static final String TAG = "TtsResponseHandler";
    private AudioDecoder<byte[], byte[]> mAudioDecoder = new AudioDecoder<>();
    private OnlineSynthesizer.OnlineSynthesizerParams mOnlineEngineParams;
    private ResponseBag mResponseBag;

    public TtsResponseHandler(ResponseBag responseBag) {
        this.mResponseBag = responseBag;
        this.mAudioDecoder.setVoiceDecoderAdapter(new AudioDecoderAdapter());
        this.mAudioDecoder.initial();
    }

    private void parseAudioData(byte[] bArr) {
        byte[] bytes;
        int iIndexOf;
        try {
            bytes = ("----BD**TTS++LIB").getBytes(a.bN);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bytes = null;
        }
        int iIndexOf2 = CommonUtility.indexOf(bArr, bytes, 0);
        if (iIndexOf2 < 0) {
            this.mResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR));
            return;
        }
        int iIndexOf3 = bytes != null ? CommonUtility.indexOf(bArr, bytes, bytes.length + iIndexOf2) : 0;
        if (iIndexOf3 < 0) {
            this.mResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_HTTP_REQUEST_PARSE_ERROR));
            return;
        }
        try {
            parseJSON(new String(CommonUtility.copyBytesOfRange(bArr, iIndexOf2 + bytes.length, iIndexOf3), a.bN));
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
        }
        if (bytes == null || (iIndexOf = CommonUtility.indexOf(bArr, bytes, bytes.length + iIndexOf3)) < 0) {
            return;
        }
        this.mResponseBag.setAudioData(CommonUtility.copyBytesOfRange(bArr, iIndexOf3 + bytes.length, iIndexOf));
    }

    private void parseJSON(byte[] bArr) {
        String str;
        try {
            str = new String(bArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        parseJSON(str);
    }

    @Override // com.baidu.tts.network.ResponseHandler
    public void onFailure(int i2, Map<String, List<String>> map, String str, byte[] bArr, Throwable th) {
        LoggerProxy.d(TAG, "onFailure error = " + th.getMessage());
        this.mResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_HTTP_REQUEST_FAILURE, i2, null, th));
    }

    @Override // com.baidu.tts.network.ResponseHandler
    public void onSuccess(int i2, Map<String, List<String>> map, String str, byte[] bArr) {
        if ("application/json".equals(str)) {
            parseJSON(bArr);
        } else {
            parseAudioData(bArr);
        }
    }

    public void setOnlineEngineParams(OnlineSynthesizer.OnlineSynthesizerParams onlineSynthesizerParams) {
        this.mOnlineEngineParams = onlineSynthesizerParams;
    }

    private void parseJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int iOptInt = jSONObject.optInt(KeyEnum.ERROR_NUMBER.getShortName());
            LoggerProxy.d(TAG, "parseJSON errNo=" + iOptInt);
            this.mResponseBag.setErrNo(iOptInt);
            if (iOptInt != 0) {
                this.mResponseBag.setTtsError(TtsErrorPool.getInstance().getTtsError(TtsErrorEnum.ONLINE_ENGINE_REQUEST_RESULT_ERROR, iOptInt, jSONObject.getString(KeyEnum.ERROR_MESSAGE.getShortName())));
                return;
            }
            this.mResponseBag.setSerialNumber(jSONObject.optString(KeyEnum.SERIAL_NUMBER.getShortName()));
            this.mResponseBag.setCount(jSONObject.optInt(KeyEnum.INDEX.getShortName()));
            this.mResponseBag.setProgress(jSONObject.optInt(KeyEnum.PERCENT.getFullName()));
            int iOptInt2 = jSONObject.optInt(KeyEnum.RESPONSE_SAMPLE_RATE.getFullName());
            if (iOptInt2 == 8000) {
                this.mResponseBag.setSampleRate(SampleRateEnum.HZ8K);
            } else if (iOptInt2 == 16000) {
                this.mResponseBag.setSampleRate(SampleRateEnum.HZ16K);
            } else if (iOptInt2 == 24000) {
                this.mResponseBag.setSampleRate(SampleRateEnum.HZ24K);
            }
            if (PlayCache2Tts.getEnableAecPlay()) {
                PlayCache2Tts.setSampleRate(iOptInt2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
