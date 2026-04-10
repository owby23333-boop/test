package com.bytedance.sdk.component.m.dl.dl;

import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static void z(Closeable closeable) {
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
