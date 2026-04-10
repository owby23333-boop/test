package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import java.io.Closeable;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
