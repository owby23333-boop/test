package com.baidu.tts.param;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.enumtype.AudioDataFormat;
import com.baidu.tts.enumtype.AudioEncoderFormat;
import com.baidu.tts.enumtype.CommandEnum;
import com.baidu.tts.enumtype.SampleRateEnum;
import com.baidu.tts.prototype.APrototype;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseBag extends APrototype<ResponseBag> {
    private static final long serialVersionUID = -7449936783334306492L;
    private byte[] mAudioData;
    private AudioDataFormat mAudioDataFormat;
    private AudioEncoderFormat mAudioEncoderFormat;
    private CommandEnum mCommandEnum;
    private int mCount;
    private int mEngineType;
    private String mErrMsg;
    private int mErrNo;
    public int mIndex;
    private int mProgress;
    private SampleRateEnum mSampleRate = SampleRateEnum.HZ16K;
    private String mSerialNumber;
    private TextParams mTextParams;
    private TtsError mTtsError;

    public static ResponseBag newResponseBag(TextParams textParams) {
        ResponseBag responseBag = new ResponseBag();
        responseBag.setTextParams(textParams);
        return responseBag;
    }

    public byte[] getAudioData() {
        return this.mAudioData;
    }

    public AudioDataFormat getAudioDataFormat() {
        return this.mAudioDataFormat;
    }

    public AudioEncoderFormat getAudioEncoderFormat() {
        return this.mAudioEncoderFormat;
    }

    public CommandEnum getCommandEnum() {
        return this.mCommandEnum;
    }

    public int getCount() {
        return this.mCount;
    }

    public int getEngineType() {
        return this.mEngineType;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public int getErrNo() {
        return this.mErrNo;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public int getProgress() {
        return this.mProgress;
    }

    public SampleRateEnum getSampleRate() {
        return this.mSampleRate;
    }

    public String getSerialNumber() {
        return this.mSerialNumber;
    }

    public TextParams getTextParams() {
        return this.mTextParams;
    }

    public TtsError getTtsError() {
        return this.mTtsError;
    }

    public ResponseBag newResponseBagCloneTextParams() {
        return newResponseBag(this.mTextParams);
    }

    public void setAudioData(byte[] bArr) {
        this.mAudioData = bArr;
    }

    public void setAudioDataFormat(AudioDataFormat audioDataFormat) {
        this.mAudioDataFormat = audioDataFormat;
    }

    public void setAudioEncoderFormat(AudioEncoderFormat audioEncoderFormat) {
        this.mAudioEncoderFormat = audioEncoderFormat;
    }

    public void setCommandEnum(CommandEnum commandEnum) {
        this.mCommandEnum = commandEnum;
    }

    public void setCount(int i2) {
        this.mCount = i2;
    }

    public void setEngineType(int i2) {
        this.mEngineType = i2;
    }

    public void setErrMsg(String str) {
        this.mErrMsg = str;
    }

    public void setErrNo(int i2) {
        this.mErrNo = i2;
    }

    public void setIndex(int i2) {
        this.mIndex = i2;
    }

    public void setProgress(int i2) {
        this.mProgress = i2;
    }

    public void setSampleRate(SampleRateEnum sampleRateEnum) {
        this.mSampleRate = sampleRateEnum;
    }

    public void setSerialNumber(String str) {
        this.mSerialNumber = str;
    }

    public void setTextParams(TextParams textParams) {
        this.mTextParams = textParams;
    }

    public void setTtsError(TtsError ttsError) {
        this.mTtsError = ttsError;
    }

    public static ResponseBag newResponseBag(TtsError ttsError) {
        ResponseBag responseBag = new ResponseBag();
        responseBag.setTtsError(ttsError);
        return responseBag;
    }

    public static ResponseBag newResponseBag(TextParams textParams, TtsError ttsError) {
        ResponseBag responseBagNewResponseBag = newResponseBag(textParams);
        responseBagNewResponseBag.setTtsError(ttsError);
        return responseBagNewResponseBag;
    }
}
