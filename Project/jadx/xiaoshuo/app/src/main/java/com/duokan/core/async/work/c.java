package com.duokan.core.async.work;

import com.duokan.core.async.work.IAsyncWorkProgressListener;
import com.duokan.core.async.work.b;

/* JADX INFO: loaded from: classes12.dex */
public abstract class c<TItem extends b> implements IAsyncWorkProgressListener<TItem> {
    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void b(TItem titem) {
    }

    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void c(TItem titem) {
    }

    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void e(TItem titem) {
    }

    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void f(TItem titem) {
    }

    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public IAsyncWorkProgressListener.CheckErrorResult h(TItem titem, b.a aVar) {
        return IAsyncWorkProgressListener.CheckErrorResult.Ignored;
    }

    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void j(TItem titem) {
    }

    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void k(TItem titem) {
    }

    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void l(TItem titem) {
    }
}
