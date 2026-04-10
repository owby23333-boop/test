package com.ss.android.downloadlib.utils;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    static final mb mb = new C0520ox();

    private static class mb {
        private mb() {
        }

        public <T> void mb(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.utils.ox$ox, reason: collision with other inner class name */
    @TargetApi(11)
    private static class C0520ox extends mb {
        private C0520ox() {
            super();
        }

        @Override // com.ss.android.downloadlib.utils.ox.mb
        public <T> void mb(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void mb(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        mb.mb(asyncTask, tArr);
    }
}
