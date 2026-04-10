package com.yuewen;

import com.duokan.core.async.work.IAsyncWorkProgressListener;
import com.duokan.core.async.work.b;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes12.dex */
public interface ki1<TItem extends com.duokan.core.async.work.b> {
    void a(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener);

    TItem b();

    void c(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener);

    void cancel();

    void d(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener);

    void e(ThreadPoolExecutor threadPoolExecutor);

    void f(boolean z);
}
