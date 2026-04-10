package com.duokan.reader.domain.job;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class JobInfo implements Serializable {
    protected final Class<?> mJobClass;
    protected final String mJobName;
    protected long mInitialTime = 0;
    protected long mIntervalTime = 0;
    protected int mRepeatCount = 0;
    protected long mExpirationTime = 0;
    protected int mFlags = 0;
    protected Serializable mParams = null;
    protected int mExecCount = 0;

    public JobInfo(String str, Class<?> cls) {
        this.mJobName = str;
        this.mJobClass = cls;
    }

    public String getJobName() {
        return this.mJobName;
    }

    public <T> T getParams() {
        return (T) this.mParams;
    }
}
