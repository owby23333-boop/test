package com.baidu.tts.param;

import android.text.TextUtils;
import com.baidu.tts.enumtype.MethodEnum;
import com.baidu.tts.prototype.APrototype;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public class TextParams extends APrototype<TextParams> {
    private static final String DEFAULT_UTTERANCE_ID = "0";
    private static final long serialVersionUID = -3350808489641333018L;
    private MethodEnum mMethodEnum;
    private String mText;
    private String mTextEncode;
    private String mTextPrefix;
    private String mUtteranceId = "0";

    public TextParams(String str, String str2) {
        setText(str);
        setUtteranceId(str2);
    }

    public void buildSynthesizeText() {
        if (TextUtils.isEmpty(this.mTextPrefix)) {
            return;
        }
        this.mText = this.mTextPrefix + this.mText;
    }

    public MethodEnum getMethodEnum() {
        return this.mMethodEnum;
    }

    public String getText() {
        return this.mText;
    }

    public byte[] getTextBytes() {
        try {
            return this.mText.getBytes(this.mTextEncode);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getTextEncode() {
        return this.mTextEncode;
    }

    public String getTextPrefix() {
        return this.mTextPrefix;
    }

    public String getUtteranceId() {
        return this.mUtteranceId;
    }

    public void setMethodEnum(MethodEnum methodEnum) {
        this.mMethodEnum = methodEnum;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTextEncode(String str) {
        this.mTextEncode = str;
    }

    public void setTextPrefix(String str) {
        this.mTextPrefix = str;
    }

    public void setUtteranceId(String str) {
        if (str == null) {
            str = "0";
        }
        this.mUtteranceId = str;
    }
}
