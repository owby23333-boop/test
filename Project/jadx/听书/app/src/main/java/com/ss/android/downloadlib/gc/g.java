package com.ss.android.downloadlib.gc;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    public interface z<T> {
        T g();
    }

    public static <T> T z(boolean z2, String str, z<T> zVar) {
        try {
            return zVar.g();
        } catch (Throwable th) {
            if (th instanceof com.ss.android.downloadlib.gc.z) {
                throw th;
            }
            dl.z().z(z2, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T z(z<T> zVar) {
        return (T) z(true, null, zVar);
    }

    public static void z(final Runnable runnable) {
        z(new z<Void>() { // from class: com.ss.android.downloadlib.gc.g.1
            @Override // com.ss.android.downloadlib.gc.g.z
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Void g() {
                runnable.run();
                return null;
            }
        });
    }
}
