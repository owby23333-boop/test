package com.bytedance.e.e.v;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class vn {
    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
