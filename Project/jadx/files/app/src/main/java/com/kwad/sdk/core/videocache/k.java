package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.utils.an;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes3.dex */
public final class k {
    static void b(byte[] bArr, long j2, int i2) {
        an.f(bArr, "Buffer must be not null!");
        an.checkArgument(j2 >= 0, "Data offset must be positive!");
        an.checkArgument(i2 >= 0 && i2 <= bArr.length, "Length must be in range [0..buffer.length]");
    }

    static String cG(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    static String decode(String str) {
        try {
            return URLDecoder.decode(str, com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error decoding url", e2);
        }
    }

    static String encode(String str) {
        try {
            return URLEncoder.encode(str, com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Error encoding url", e2);
        }
    }
}
