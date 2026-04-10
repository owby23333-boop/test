package com.baidu.tts.param;

import com.baidu.tts.bridge.engine.synthesizer.OfflineSynthesizer;
import com.baidu.tts.bridge.engine.synthesizer.OnlineSynthesizer;
import com.baidu.tts.enumtype.MixMode;
import com.baidu.tts.enumtype.TimeOutEnum;
import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.prototype.APrototype;
import com.baidu.tts.tools.DataTool;

/* JADX INFO: loaded from: classes2.dex */
public class AllSynthesizerParams extends APrototype<AllSynthesizerParams> {
    private static final long serialVersionUID = -4910008790560399764L;
    private MixMode mMixMode;
    private TimeOutEnum mMixOnlineRequestTimeout = TimeOutEnum.FOUR_SECOND;
    private OnlineSynthesizer.OnlineSynthesizerParams mOnlineSynthesizerParams = new OnlineSynthesizer.OnlineSynthesizerParams();
    private OfflineSynthesizer.OfflineSynthesizerParams mOfflineSynthesizerParams = new OfflineSynthesizer.OfflineSynthesizerParams();

    public MixMode getMixMode() {
        return this.mMixMode;
    }

    public TimeOutEnum getMixOnlineRequestTimeout() {
        return this.mMixOnlineRequestTimeout;
    }

    public OfflineSynthesizer.OfflineSynthesizerParams getOfflineSynthesizerParams() {
        return this.mOfflineSynthesizerParams;
    }

    public OnlineSynthesizer.OnlineSynthesizerParams getOnlineSynthesizerParams() {
        return this.mOnlineSynthesizerParams;
    }

    public void setMixMode(MixMode mixMode) {
        this.mMixMode = mixMode;
    }

    public void setMixOnlineRequestTimeout(TimeOutEnum timeOutEnum) {
        this.mMixOnlineRequestTimeout = timeOutEnum;
    }

    public void setOfflineSynthesizerParams(OfflineSynthesizer.OfflineSynthesizerParams offlineSynthesizerParams) {
        this.mOfflineSynthesizerParams = offlineSynthesizerParams;
    }

    public void setOnlineSynthesizerParams(OnlineSynthesizer.OnlineSynthesizerParams onlineSynthesizerParams) {
        this.mOnlineSynthesizerParams = onlineSynthesizerParams;
    }

    public int setOpenXml(String str) {
        if (!DataTool.isLong(str)) {
            return TtsErrorEnum.TTS_PARAMETER_INVALID.getId();
        }
        this.mOnlineSynthesizerParams.setOpenXml(str);
        this.mOfflineSynthesizerParams.setOpenXml(str);
        return 0;
    }

    public void setPitch(String str) {
        this.mOnlineSynthesizerParams.setPitch(str);
        this.mOfflineSynthesizerParams.setPitch(str);
    }

    public void setSpeed(String str) {
        this.mOnlineSynthesizerParams.setSpeed(str);
        this.mOfflineSynthesizerParams.setSpeed(str);
    }

    public void setVolume(String str) {
        this.mOnlineSynthesizerParams.setVolume(str);
        this.mOfflineSynthesizerParams.setVolume(str);
    }
}
