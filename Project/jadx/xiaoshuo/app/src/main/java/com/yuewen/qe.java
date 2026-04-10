package com.yuewen;

import com.duokan.core.async.work.IAsyncWorkProgressListener;
import com.duokan.core.async.work.b;
import com.yuewen.ki1;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes12.dex */
public class qe<TItem extends com.duokan.core.async.work.b, TStubItem extends TItem, TStubWork extends ki1<TStubItem>> implements ki1<TItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TStubWork f16498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.duokan.core.async.work.d<TItem, TStubItem>> f16499b = new LinkedList();

    public qe(TStubWork tstubwork) {
        this.f16498a = tstubwork;
    }

    @Override // com.yuewen.ki1
    public void a(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        com.duokan.core.async.work.d<TItem, TStubItem> dVar;
        if (iAsyncWorkProgressListener == null) {
            return;
        }
        synchronized (this.f16499b) {
            Iterator<com.duokan.core.async.work.d<TItem, TStubItem>> it = this.f16499b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    dVar = null;
                    break;
                } else {
                    dVar = it.next();
                    if (dVar.a() == iAsyncWorkProgressListener) {
                        break;
                    }
                }
            }
            if (dVar == null) {
                dVar = new com.duokan.core.async.work.d<>(iAsyncWorkProgressListener);
            }
        }
        this.f16498a.a(dVar);
    }

    @Override // com.yuewen.ki1
    public TItem b() {
        return (TItem) this.f16498a.b();
    }

    @Override // com.yuewen.ki1
    public void c(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        com.duokan.core.async.work.d<TItem, TStubItem> next;
        if (iAsyncWorkProgressListener == null) {
            return;
        }
        synchronized (this.f16499b) {
            Iterator<com.duokan.core.async.work.d<TItem, TStubItem>> it = this.f16499b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (next.a() == iAsyncWorkProgressListener) {
                        break;
                    }
                }
            }
            if (next != null) {
                this.f16499b.remove(next);
            }
        }
        if (next != null) {
            this.f16498a.c(next);
        }
    }

    @Override // com.yuewen.ki1
    public void cancel() {
        this.f16498a.cancel();
    }

    @Override // com.yuewen.ki1
    public void d(IAsyncWorkProgressListener<TItem> iAsyncWorkProgressListener) {
        com.duokan.core.async.work.d<TItem, TStubItem> dVar;
        boolean z;
        if (iAsyncWorkProgressListener == null) {
            return;
        }
        synchronized (this.f16499b) {
            Iterator<com.duokan.core.async.work.d<TItem, TStubItem>> it = this.f16499b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    dVar = null;
                    z = false;
                    break;
                } else {
                    dVar = it.next();
                    if (dVar.a() == iAsyncWorkProgressListener) {
                        z = true;
                        break;
                    }
                }
            }
            if (dVar == null) {
                dVar = new com.duokan.core.async.work.d<>(iAsyncWorkProgressListener);
                this.f16499b.add(dVar);
            }
        }
        if (z) {
            return;
        }
        this.f16498a.d(dVar);
    }

    @Override // com.yuewen.ki1
    public void e(ThreadPoolExecutor threadPoolExecutor) {
        this.f16498a.e(threadPoolExecutor);
    }

    @Override // com.yuewen.ki1
    public void f(boolean z) {
        this.f16498a.f(z);
    }

    public TStubWork g() {
        return this.f16498a;
    }
}
