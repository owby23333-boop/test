package com.ss.android.downloadlib.exception;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ox {

    public interface mb<T> {
        T ox();
    }

    public static <T> T mb(boolean z2, String str, @NonNull mb<T> mbVar) {
        try {
            return mbVar.ox();
        } catch (Throwable th) {
            if (th instanceof com.ss.android.downloadlib.exception.mb) {
                throw th;
            }
            b.mb().mb(z2, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T mb(mb<T> mbVar) {
        return (T) mb(true, null, mbVar);
    }

    public static void mb(final Runnable runnable) {
        mb(new mb<Void>() { // from class: com.ss.android.downloadlib.exception.ox.1
            @Override // com.ss.android.downloadlib.exception.ox.mb
            /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
            public Void ox() {
                runnable.run();
                return null;
            }
        });
    }
}
