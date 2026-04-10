package com.bytedance.adsdk.lottie.tg;

import com.bytedance.component.sdk.annotation.RestrictTo;
import com.dangdang.reader.utils.DangdangFileManager;
import com.yuewen.t50;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public enum d {
    JSON(".json"),
    ZIP(DangdangFileManager.FONT_EXTEN);

    public final String d;

    d(String str) {
        this.d = str;
    }

    public String e() {
        return t50.f17863a + this.d;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.d;
    }
}
