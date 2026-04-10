package com.alipay.android.phone.mrpc.core;

import android.util.Log;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class r {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.e(com.xiaomi.ad.f.f7260a, "", e);
            }
        }
    }
}
