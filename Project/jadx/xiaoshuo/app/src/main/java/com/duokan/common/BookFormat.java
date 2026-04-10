package com.duokan.common;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes12.dex */
public enum BookFormat {
    UNKNOWN,
    EPUB,
    TXT,
    PDF,
    SBK,
    ABK,
    PIRATE;

    public static BookFormat fromString(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNKNOWN;
        }
        try {
            return valueOf(str);
        } catch (Throwable unused) {
            return UNKNOWN;
        }
    }
}
