package com.bytedance.sdk.component.e.z;

import android.util.Base64;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.a.g.z {
    @Override // com.bytedance.sdk.component.a.g.z
    public int type() {
        return 32;
    }

    @Override // com.bytedance.sdk.component.a.g.z
    public String encrypt(String str) {
        return Base64.encodeToString(str.toString().getBytes(Charset.forName("UTF-8")), 0);
    }

    @Override // com.bytedance.sdk.component.a.g.z
    public String decrypt(String str) {
        return new String(Base64.decode(str.toString().getBytes(Charset.forName("UTF-8")), 0), Charset.forName("UTF-8"));
    }
}
