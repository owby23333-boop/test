package com.dangdang.reader.dread.jni;

import android.text.TextUtils;
import com.dangdang.reader.dread.data.ParagraphText;
import com.dangdang.reader.dread.jni.BaseJniWarp;
import com.dangdang.zframework.log.LogM;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes10.dex */
public class ParagraphTextHandler {
    private int mEndEmtIndex;
    private int mStartEmtIndex;
    private String mText = "";

    private boolean isIllegality() {
        int i;
        int i2;
        return TextUtils.isEmpty(this.mText) || (i = this.mStartEmtIndex) < 0 || (i2 = this.mEndEmtIndex) < 0 || (i == 0 && i2 == 0);
    }

    public ParagraphText getParagraphText() {
        ParagraphText paragraphText = new ParagraphText();
        paragraphText.setText(this.mText);
        paragraphText.setStartEmtIndex(new BaseJniWarp.ElementIndex(this.mStartEmtIndex));
        paragraphText.setEndEmtIndex(new BaseJniWarp.ElementIndex(this.mEndEmtIndex));
        return paragraphText;
    }

    public void onParagraphText(String str, int i, int i2) {
        this.mText = str;
        this.mStartEmtIndex = i;
        this.mEndEmtIndex = i2;
        if (isIllegality()) {
            StringBuffer stringBuffer = new StringBuffer("[");
            stringBuffer.append(str);
            stringBuffer.append("][");
            stringBuffer.append(this.mStartEmtIndex + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.mEndEmtIndex);
            stringBuffer.append("]");
            pringLog(" onParagraphText: " + ((Object) stringBuffer));
        }
    }

    public void pringLog(String str) {
        LogM.i(getClass().getSimpleName(), str);
    }

    public void pringLogE(String str) {
        LogM.e(getClass().getSimpleName(), str);
    }
}
