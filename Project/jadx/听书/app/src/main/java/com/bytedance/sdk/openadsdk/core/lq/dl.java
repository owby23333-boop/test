package com.bytedance.sdk.openadsdk.core.lq;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static String z(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return kb.z(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }
}
