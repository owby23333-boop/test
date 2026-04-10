package com.bytedance.sdk.component.e;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public enum wl {
    PUBLIC,
    PROTECTED,
    PRIVATE;

    public static wl e(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        return TextUtils.equals("protected", lowerCase) ? PROTECTED : TextUtils.equals("private", lowerCase) ? PRIVATE : PUBLIC;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == PRIVATE ? "private" : this == PROTECTED ? "protected" : "public";
    }
}
