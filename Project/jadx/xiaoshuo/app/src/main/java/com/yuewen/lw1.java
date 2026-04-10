package com.yuewen;

import android.os.SystemClock;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes15.dex */
public abstract class lw1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f14218a = true;

    public interface a<T> {
        T call() throws Exception;
    }

    public static <T> T a(String str, String str2, @NonNull a<T> aVar) throws Exception {
        if (!f14218a) {
            return aVar.call();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        T tCall = aVar.call();
        pw3.a(str, str2 + ", cost:" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return tCall;
    }

    public static void b(boolean z) {
        f14218a = z;
    }
}
