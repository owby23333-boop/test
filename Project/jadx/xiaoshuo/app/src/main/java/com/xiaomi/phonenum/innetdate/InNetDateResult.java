package com.xiaomi.phonenum.innetdate;

import com.xiaomi.phonenum.bean.Error;

/* JADX INFO: loaded from: classes8.dex */
public class InNetDateResult {
    private Error error;
    private long inNetDate;
    private String massage;
    private String phoneNum;

    public InNetDateResult(long j, String str) {
        this.inNetDate = j;
        this.phoneNum = str;
    }

    public Error getError() {
        return isSuccess() ? Error.NONE : this.error;
    }

    public long getInNetDate() {
        return this.inNetDate;
    }

    public String getMassage() {
        return this.massage;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public boolean isFailure() {
        return !isSuccess();
    }

    public boolean isSuccess() {
        return this.error == null;
    }

    public String toString() {
        return "IabResult: " + getMassage() + " date:" + this.inNetDate;
    }

    public InNetDateResult(Error error) {
        this(error, error.toString());
    }

    public InNetDateResult(Error error, String str) {
        this.error = error;
        this.massage = str;
    }
}
