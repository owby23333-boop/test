package com.ss.android.downloadlib.mb.mb;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    public static String mb(Context context) {
        try {
            return mb(b.mb(mb(), "MD5"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String ox(Context context) {
        String string;
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception e2) {
            e2.printStackTrace();
            string = null;
        }
        return TextUtils.isEmpty(string) ? "normal" : string;
    }

    public static String mb() {
        return ox(x.getContext());
    }

    public static String mb(byte[] bArr) {
        return mb.mb(bArr);
    }
}
