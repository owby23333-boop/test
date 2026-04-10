package com.duokan.core.async.work;

import com.duokan.core.async.work.b;

/* JADX INFO: loaded from: classes12.dex */
public interface IAsyncWorkProgressListener<TItem extends b> {

    public enum CheckErrorResult {
        Ignored,
        Passed,
        Failed
    }

    void b(TItem titem);

    void c(TItem titem);

    void e(TItem titem);

    void f(TItem titem);

    CheckErrorResult h(TItem titem, b.a aVar);

    void j(TItem titem);

    void k(TItem titem);

    void l(TItem titem);
}
