package com.dangdang.reader.dread.data;

import android.text.TextUtils;
import com.dangdang.reader.dread.jni.BaseJniWarp;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes10.dex */
public class ParagraphText {
    private int code;
    private BaseJniWarp.ElementIndex endEmtIndex;
    private BaseJniWarp.ElementIndex startEmtIndex;
    private String text = "";
    private boolean isTip = false;

    public BaseJniWarp.ElementIndex getEndEmtIndex() {
        return this.endEmtIndex;
    }

    public int getEndIndexToInt() {
        BaseJniWarp.ElementIndex elementIndex = this.endEmtIndex;
        if (elementIndex == null) {
            return 0;
        }
        return elementIndex.getIndex();
    }

    public BaseJniWarp.ElementIndex getStartEmtIndex() {
        return this.startEmtIndex;
    }

    public int getStartIndexToInt() {
        BaseJniWarp.ElementIndex elementIndex = this.startEmtIndex;
        if (elementIndex == null) {
            return 0;
        }
        return elementIndex.getIndex();
    }

    public String getText() {
        if (this.text == null) {
            this.text = "";
        }
        return this.text;
    }

    public int getTextLen() {
        return getEndIndexToInt() - getStartIndexToInt();
    }

    public boolean isIllegality() {
        return TextUtils.isEmpty(this.text) || (getStartIndexToInt() == 0 && getEndIndexToInt() == 0);
    }

    public boolean isTip() {
        return this.isTip;
    }

    public void setEndEmtIndex(BaseJniWarp.ElementIndex elementIndex) {
        this.endEmtIndex = elementIndex;
    }

    public void setStartEmtIndex(BaseJniWarp.ElementIndex elementIndex) {
        this.startEmtIndex = elementIndex;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTip(boolean z) {
        this.isTip = z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("[");
        stringBuffer.append(this.text);
        stringBuffer.append("][");
        stringBuffer.append(getStartIndexToInt() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + getEndIndexToInt());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
