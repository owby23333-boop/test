package com.yuewen;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

/* JADX INFO: loaded from: classes12.dex */
@SuppressLint({"NewApi"})
public abstract class me {
    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
