package com.yuewen;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes12.dex */
public interface yp1 {
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
