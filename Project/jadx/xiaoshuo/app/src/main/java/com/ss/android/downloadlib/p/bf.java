package com.ss.android.downloadlib.p;

import android.annotation.TargetApi;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes4.dex */
public class bf {
    static final e e = new C0490bf();

    /* JADX INFO: renamed from: com.ss.android.downloadlib.p.bf$bf, reason: collision with other inner class name */
    @TargetApi(11)
    public static class C0490bf extends e {
        private C0490bf() {
            super();
        }

        @Override // com.ss.android.downloadlib.p.bf.e
        public <T> void e(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static class e {
        private e() {
        }

        public <T> void e(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.execute(tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void e(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        e.e(asyncTask, tArr);
    }
}
