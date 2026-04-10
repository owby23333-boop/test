package com.duokan.reader.domain.privacy;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class PrivacyServiceResult<T> {
    private String code;
    private T data;
    private String msg;
    private String result;
    private String timestamp;
    private String traceId;

    public String getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getResult() {
        return this.result;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public boolean isResultOk() {
        return "0".equals(this.result) && this.data != null;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }
}
