package com.yuewen;

import android.text.TextUtils;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public class gz3 {
    public static boolean a(TextView textView, String str) {
        if (textView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        textView.setText(str);
        return true;
    }
}
