package com.bytedance.sdk.component.vn.e;

import android.util.Base64;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class e implements d {
    @Override // com.bytedance.sdk.component.vn.e.d
    public <T> T bf(T t) {
        return (T) new String(Base64.decode(t.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }

    @Override // com.bytedance.sdk.component.vn.e.d
    public <T> String e(T t) {
        return Base64.encodeToString(t.toString().getBytes(Charset.forName("UTF-8")), 0);
    }
}
