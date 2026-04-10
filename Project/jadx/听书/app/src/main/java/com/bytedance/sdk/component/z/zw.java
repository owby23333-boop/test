package com.bytedance.sdk.component.z;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public enum zw {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    static zw z(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.equals("protected", lowerCase)) {
            return PROTECTED;
        }
        if (TextUtils.equals("private", lowerCase)) {
            return PRIVATE;
        }
        return PUBLIC;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == PRIVATE ? "private" : this == PROTECTED ? "protected" : "public";
    }
}
