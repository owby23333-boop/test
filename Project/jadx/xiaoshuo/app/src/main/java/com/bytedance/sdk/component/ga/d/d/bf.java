package com.bytedance.sdk.component.ga.d.d;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    public static void e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }
}
