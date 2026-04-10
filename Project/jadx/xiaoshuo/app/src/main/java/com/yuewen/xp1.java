package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public interface xp1 {
    default String a() {
        String value = getValue();
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        return String.format("%s=%s;", getKey(), value);
    }

    int getIndex();

    String getKey();

    String getValue();
}
