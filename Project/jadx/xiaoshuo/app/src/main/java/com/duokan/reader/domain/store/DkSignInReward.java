package com.duokan.reader.domain.store;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DkSignInReward implements Serializable {
    private final String mName;
    private final int mType;
    private final String mValue;

    public DkSignInReward(String str, String str2, int i) {
        this.mName = str;
        this.mValue = str2;
        this.mType = i;
    }

    public String name() {
        return this.mName.replace("书币", "书豆");
    }

    public int type() {
        return this.mType;
    }

    public String value() {
        return this.mValue;
    }
}
