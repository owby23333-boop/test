package com.amgcyo.cuttadon.api.entity.other;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
public class DnsResult implements Serializable {
    public static final int DATA_EMPTY = 105;
    public static final int HOST_NOT_FOUND = 103;
    public static final int MAIN_URL_EMPTY = 107;
    public static final int OHTHER_ERROR = 106;
    public static final int SUCCESSFUL = 100;
    public static final int TRY_AGAIN = 102;
    public static final String TXT = "TXT";
    public static final int TYPE_NOT_FOUND = 104;
    public static final int UNRECOVERABLE = 101;
    private long answersMinTtl;
    private int code;
    private String domain;
    private String msg;

    public DnsResult() {
    }

    public long getAnswersMinTtl() {
        return this.answersMinTtl;
    }

    public int getCode() {
        return this.code;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setAnswersMinTtl(long j2) {
        this.answersMinTtl = j2;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    @NotNull
    public String toString() {
        return "DnsResult{code=" + this.code + ", msg='" + this.msg + "', answersMinTtl=" + this.answersMinTtl + ", domain='" + this.domain + "'}";
    }

    public DnsResult(int i2, String str) {
        this.code = i2;
        this.msg = str;
    }

    public DnsResult(long j2, int i2, String str, String str2) {
        this.code = i2;
        this.msg = str;
        this.answersMinTtl = j2;
        this.domain = str2;
    }
}
