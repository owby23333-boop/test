package com.bytedance.sdk.component.kb.gc.z.z;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements com.bytedance.sdk.component.kb.gc.z.z {
    @Override // com.bytedance.sdk.component.kb.gc.z.z
    public Object z(Class cls, String str) {
        if (TextUtils.isEmpty(str)) {
            return ' ';
        }
        return Character.valueOf(str.charAt(0));
    }
}
