package com.baidu.tts.param;

import com.baidu.tts.enumtype.CharSetEnum;
import com.baidu.tts.enumtype.LanguageEnum;
import com.baidu.tts.prototype.APrototype;

/* JADX INFO: loaded from: classes2.dex */
public class BaseSynthesizerParams<T> extends APrototype<T> {
    private static final long serialVersionUID = -7170476940580696189L;
    private String mAuthSN;
    private String mSpeed = "5";
    private String mPitch = "5";
    private String mVolume = "5";
    private String mLanguage = LanguageEnum.ZH.getShortName();
    private CharSetEnum mTextEncode = CharSetEnum.UTF8;
    private String mOpenXml = "0";

    public String getAuthSN() {
        return this.mAuthSN;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public String getOpenXml() {
        return this.mOpenXml;
    }

    public long getOpenXmlLong() {
        try {
            return Long.parseLong(this.mOpenXml);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String getPitch() {
        return this.mPitch;
    }

    public long getPitchLong() {
        return Long.parseLong(this.mPitch);
    }

    public String getSpeed() {
        return this.mSpeed;
    }

    public long getSpeedLong() {
        return Long.parseLong(this.mSpeed);
    }

    public CharSetEnum getTextEncode() {
        return this.mTextEncode;
    }

    public String getTextEncodeCharset() {
        return this.mTextEncode.getCharset();
    }

    public String getTextEncodeTag() {
        return this.mTextEncode.getTag();
    }

    public String getVolume() {
        return this.mVolume;
    }

    public long getVolumeLong() {
        return Long.parseLong(this.mVolume);
    }

    public void setAuthSN(String str) {
        this.mAuthSN = str;
    }

    public void setLanguage(String str) {
        this.mLanguage = str;
    }

    public void setOpenXml(String str) {
        this.mOpenXml = str;
    }

    public void setPitch(String str) {
        this.mPitch = str;
    }

    public void setSpeed(String str) {
        this.mSpeed = str;
    }

    public void setTextEncode(CharSetEnum charSetEnum) {
        this.mTextEncode = charSetEnum;
    }

    public void setVolume(String str) {
        this.mVolume = str;
    }
}
