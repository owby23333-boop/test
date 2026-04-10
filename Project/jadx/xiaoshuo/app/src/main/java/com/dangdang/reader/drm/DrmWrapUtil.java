package com.dangdang.reader.drm;

import android.text.TextUtils;
import com.dangdang.reader.dread.jni.DrmWarp;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes10.dex */
public class DrmWrapUtil {
    public static byte[] getPartBookCertKey(String str) {
        byte[] bytes = TextUtils.isEmpty(str) ? new byte[1] : str.getBytes();
        DrmWarp drmWarp = DrmWarp.getInstance();
        drmWarp.enCrypt(bytes);
        return drmWarp.getEnCryptData();
    }

    public static String getPublicKey() {
        DrmWarp drmWarp = DrmWarp.getInstance();
        String publicKey = drmWarp.getPublicKeyN() != -1 ? drmWarp.getPublicKey() : "";
        try {
            return URLEncoder.encode(publicKey, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return publicKey;
        }
    }
}
