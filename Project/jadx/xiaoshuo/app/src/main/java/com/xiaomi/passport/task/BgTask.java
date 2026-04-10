package com.xiaomi.passport.task;

import android.os.AsyncTask;
import com.xiaomi.accountsdk.account.utils.ReferenceHolder;
import com.xiaomi.passport.utils.XiaomiPassportExecutor;

/* JADX INFO: loaded from: classes8.dex */
public class BgTask<T> extends AsyncTask<Void, Void, Result<T>> {
    private final ReferenceHolder<BgTaskRunnable<T>> mBgTaskRunnableRef;
    private final ReferenceHolder<ErrorResultRunnable> mErrorResultRunnableRef;
    private final ReferenceHolder<SuccessResultRunnable<T>> mSuccessResultRunnableRef;

    public interface BgTaskRunnable<T> {
        T run() throws Throwable;
    }

    public interface ErrorResultRunnable {
        void run(Throwable th);
    }

    public static class Result<T> {
        public final Throwable error;
        public final T result;

        public Result(T t, Throwable th) {
            this.result = t;
            this.error = th;
        }
    }

    public interface SuccessResultRunnable<T> {
        void run(T t);
    }

    public BgTask(BgTaskRunnable<T> bgTaskRunnable, SuccessResultRunnable<T> successResultRunnable, ErrorResultRunnable errorResultRunnable) {
        this.mBgTaskRunnableRef = new ReferenceHolder<>(bgTaskRunnable);
        this.mSuccessResultRunnableRef = new ReferenceHolder<>(successResultRunnable);
        this.mErrorResultRunnableRef = new ReferenceHolder<>(errorResultRunnable);
    }

    public void cancelAndRelease() {
        this.mBgTaskRunnableRef.set(null);
        this.mSuccessResultRunnableRef.set(null);
        this.mErrorResultRunnableRef.set(null);
        cancel(true);
    }

    public void execute() {
        executeOnExecutor(XiaomiPassportExecutor.getSingleton(), new Void[0]);
    }

    @Override // android.os.AsyncTask
    public Result doInBackground(Void... voidArr) {
        BgTaskRunnable<T> bgTaskRunnable = this.mBgTaskRunnableRef.get();
        if (bgTaskRunnable == null) {
            return new Result(null, null);
        }
        try {
            return new Result(bgTaskRunnable.run(), null);
        } catch (Throwable th) {
            return new Result(null, th);
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Result<T> result) {
        if (result.error == null) {
            SuccessResultRunnable<T> successResultRunnable = this.mSuccessResultRunnableRef.get();
            if (successResultRunnable != null) {
                successResultRunnable.run(result.result);
                return;
            }
            return;
        }
        ErrorResultRunnable errorResultRunnable = this.mErrorResultRunnableRef.get();
        if (errorResultRunnable != null) {
            errorResultRunnable.run(result.error);
        }
    }
}
