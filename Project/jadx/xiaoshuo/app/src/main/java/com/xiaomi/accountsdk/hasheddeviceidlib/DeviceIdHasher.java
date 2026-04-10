package com.xiaomi.accountsdk.hasheddeviceidlib;

import android.util.Base64;
import com.yuewen.yg3;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceIdHasher {
    public static String hashDeviceInfo(String str) {
        return hashDeviceInfo(str, 8);
    }

    public static String hashDeviceInfo(String str, int i) {
        if (str == null) {
            return null;
        }
        try {
            return Base64.encodeToString(MessageDigest.getInstance(yg3.b.f20351b).digest(str.getBytes()), i).substring(0, 16);
        } catch (NoSuchAlgorithmException unused) {
            throw new IllegalStateException("failed to init SHA1 digest");
        }
    }
}
