package com.bytedance.sdk.component.uy.a;

import android.os.AsyncTask;
import com.bytedance.sdk.component.uy.uy;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {
    public static Executor z = new a(0, 20, 3, TimeUnit.MILLISECONDS, new SynchronousQueue(), new uy("PAsyncTask"));

    public AsyncTask<Params, Progress, Result> z(Params... paramsArr) {
        return executeOnExecutor(z, paramsArr);
    }
}
