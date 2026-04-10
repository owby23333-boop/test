package d.a.o;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
class f implements Future<d.a.i> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private m f20735s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f20736t;

    public f(m mVar) {
        this.f20735s = mVar;
    }

    public d.a.i a() throws ExecutionException, InterruptedException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    public d.a.i b() throws ExecutionException, InterruptedException, TimeoutException {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        if (!this.f20736t) {
            this.f20735s.b();
            this.f20736t = true;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ d.a.i get() throws ExecutionException, InterruptedException {
        a();
        throw null;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f20736t;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        throw new RuntimeException("NOT SUPPORT!");
    }

    @Override // java.util.concurrent.Future
    public /* synthetic */ d.a.i get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        b();
        throw null;
    }
}
