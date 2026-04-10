package com.baidu.tts.client;

import com.baidu.tts.enumtype.TtsErrorEnum;
import com.baidu.tts.tools.ResourceTools;

/* JADX INFO: loaded from: classes2.dex */
public class SpeechSynthesizeBag {
    private String mText;
    private String mUtteranceId;

    public String getText() {
        return this.mText;
    }

    public String getUtteranceId() {
        return this.mUtteranceId;
    }

    public int setText(String str) {
        TtsErrorEnum ttsErrorEnumIsTextValid = ResourceTools.isTextValid(str);
        if (ttsErrorEnumIsTextValid != null) {
            return ttsErrorEnumIsTextValid.getId();
        }
        this.mText = str;
        return 0;
    }

    public void setUtteranceId(String str) {
        this.mUtteranceId = str;
    }
}
