package com.xiaomi.accountsdk.account.data;

import com.xiaomi.ad.y;
import com.yuewen.gm;

/* JADX INFO: loaded from: classes5.dex */
public enum Gender {
    MALE(y.k),
    FEMALE(gm.a.f11595a);

    private String mGender;

    Gender(String str) {
        this.mGender = str;
    }

    public String getType() {
        return this.mGender;
    }
}
