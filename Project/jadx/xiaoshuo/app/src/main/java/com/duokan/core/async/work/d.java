package com.duokan.core.async.work;

import com.duokan.core.async.work.IAsyncWorkProgressListener;
import com.duokan.core.async.work.b;

/* JADX INFO: loaded from: classes12.dex */
public class d<TStubItem extends b, TItem extends TStubItem> implements IAsyncWorkProgressListener<TItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAsyncWorkProgressListener<TStubItem> f2783a;

    public d(IAsyncWorkProgressListener<TStubItem> iAsyncWorkProgressListener) {
        this.f2783a = iAsyncWorkProgressListener;
    }

    public IAsyncWorkProgressListener<TStubItem> a() {
        return this.f2783a;
    }

    /* JADX WARN: Incorrect types in method signature: (TTItem;)V */
    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void b(b bVar) {
        this.f2783a.b(bVar);
    }

    /* JADX WARN: Incorrect types in method signature: (TTItem;)V */
    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void c(b bVar) {
        this.f2783a.c(bVar);
    }

    /* JADX WARN: Incorrect types in method signature: (TTItem;)V */
    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void e(b bVar) {
        this.f2783a.e(bVar);
    }

    /* JADX WARN: Incorrect types in method signature: (TTItem;)V */
    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void f(b bVar) {
        this.f2783a.f(bVar);
    }

    /* JADX WARN: Incorrect types in method signature: (TTItem;Lcom/duokan/core/async/work/b$a;)Lcom/duokan/core/async/work/IAsyncWorkProgressListener$CheckErrorResult; */
    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public IAsyncWorkProgressListener.CheckErrorResult h(b bVar, b.a aVar) {
        return this.f2783a.h(bVar, aVar);
    }

    /* JADX WARN: Incorrect types in method signature: (TTItem;)V */
    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void j(b bVar) {
        this.f2783a.j(bVar);
    }

    /* JADX WARN: Incorrect types in method signature: (TTItem;)V */
    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void k(b bVar) {
        this.f2783a.k(bVar);
    }

    /* JADX WARN: Incorrect types in method signature: (TTItem;)V */
    @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
    public void l(b bVar) {
        this.f2783a.l(bVar);
    }
}
