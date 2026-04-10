package com.mibi.sdk.common.account;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes13.dex */
public enum AccountLevel {
    SYSTEM("system"),
    GUEST("guest");

    private final String mLevelStr;

    AccountLevel(String str) {
        this.mLevelStr = str;
    }

    public static AccountLevel get(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (AccountLevel accountLevel : values()) {
                if (str.equalsIgnoreCase(accountLevel.mLevelStr)) {
                    return accountLevel;
                }
            }
        }
        return SYSTEM;
    }
}
