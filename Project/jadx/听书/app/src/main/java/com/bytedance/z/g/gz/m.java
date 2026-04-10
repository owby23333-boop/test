package com.bytedance.z.g.gz;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static void z(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
