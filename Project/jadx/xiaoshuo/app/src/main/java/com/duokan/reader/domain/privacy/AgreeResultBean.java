package com.duokan.reader.domain.privacy;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class AgreeResultBean {
    private String code;
    private String msg;
    private String requestId;
    private String result;

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getResult() {
        return this.result;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setResult(String str) {
        this.result = str;
    }
}
