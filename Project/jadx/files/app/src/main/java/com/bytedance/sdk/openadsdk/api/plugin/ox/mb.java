package com.bytedance.sdk.openadsdk.api.plugin.ox;

import android.util.Base64;
import com.anythink.expressad.foundation.g.a;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public class mb {
    public static String mb(String str, String str2, String str3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str3.getBytes(), "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKeySpec, new IvParameterSpec(str2.getBytes()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes(a.bN)), 0);
        } catch (Throwable unused) {
            return null;
        }
    }
}
