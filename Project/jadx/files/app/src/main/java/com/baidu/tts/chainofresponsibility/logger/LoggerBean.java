package com.baidu.tts.chainofresponsibility.logger;

import com.baidu.tts.prototype.APrototype;

/* JADX INFO: loaded from: classes2.dex */
public class LoggerBean extends APrototype<LoggerBean> {
    private static final long serialVersionUID = -2547374096403914637L;
    private String mClassName;
    private int mLevel;
    private String mMessage;
    private String mTag;

    public String getClassName() {
        return this.mClassName;
    }

    public int getLevel() {
        return this.mLevel;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setClassName(String str) {
        this.mClassName = str;
    }

    public void setLevel(int i2) {
        this.mLevel = i2;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setTag(String str) {
        this.mTag = str;
    }
}
