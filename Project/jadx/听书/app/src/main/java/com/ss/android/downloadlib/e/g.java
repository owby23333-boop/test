package com.ss.android.downloadlib.e;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    static final z z = new C0443g();

    private static class z {
        private z() {
        }

        public <T> void z(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(com.bytedance.sdk.component.uy.a.g.z, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.e.g$g, reason: collision with other inner class name */
    private static class C0443g extends z {
        private C0443g() {
            super();
        }

        @Override // com.ss.android.downloadlib.e.g.z
        public <T> void z(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static <T> void z(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        z.z(asyncTask, tArr);
    }
}
