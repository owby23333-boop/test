package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class o {
    private static String ayo = "";
    private static String ayp = "";
    private static String ayq = "";

    private static String a(String str, InputStream inputStream) {
        String strDY;
        synchronized (o.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.Cc();
            strDY = oVar.Cb().dY(str);
            oVar.end();
        }
        return strDY;
    }

    public static String ca(int i2) {
        String str;
        String str2;
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        if (context == null) {
            com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey context is null");
            return "";
        }
        if (i2 == 0) {
            str = ayo;
            str2 = "aes_key";
        } else if (i2 == 1) {
            str = ayp;
            str2 = "rsa_public_key";
        } else if (i2 != 2) {
            str = "";
            str2 = str;
        } else {
            str = ayq;
            str2 = "rsa_private_key";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (TextUtils.isEmpty(str2)) {
            com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get id is error ");
        }
        InputStream inputStreamOpen = null;
        try {
            try {
                inputStreamOpen = context.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get InputStream from loader is null,  e: " + th);
            }
            if (inputStreamOpen == null) {
                inputStreamOpen = context.getAssets().open("ksad_common_encrypt_image.png");
            }
            String strA = a(str2, inputStreamOpen);
            if (TextUtils.isEmpty(strA)) {
                com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
            }
            if (i2 == 0) {
                ayo = strA;
            } else if (i2 == 1) {
                ayp = strA;
            } else if (i2 == 2) {
                ayq = strA;
            }
            return strA;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
            return "";
        }
    }
}
