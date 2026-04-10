package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* JADX INFO: compiled from: ErrorRequestCoordinator.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements RequestCoordinator, e {
    private final Object a;

    @Nullable
    private final RequestCoordinator b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile e f13845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile e f13846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f13847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f13848f;

    public b(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f13847e = requestState;
        this.f13848f = requestState;
        this.a = obj;
        this.b = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean d() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.f(this);
    }

    @GuardedBy("requestLock")
    private boolean e() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    @GuardedBy("requestLock")
    private boolean f() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @GuardedBy("requestLock")
    private boolean g(e eVar) {
        return eVar.equals(this.f13845c) || (this.f13847e == RequestCoordinator.RequestState.FAILED && eVar.equals(this.f13846d));
    }

    public void a(e eVar, e eVar2) {
        this.f13845c = eVar;
        this.f13846d = eVar2;
    }

    @Override // com.bumptech.glide.request.e
    public boolean b() {
        boolean z2;
        synchronized (this.a) {
            z2 = this.f13847e == RequestCoordinator.RequestState.CLEARED && this.f13848f == RequestCoordinator.RequestState.CLEARED;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public void c() {
        synchronized (this.a) {
            if (this.f13847e != RequestCoordinator.RequestState.RUNNING) {
                this.f13847e = RequestCoordinator.RequestState.RUNNING;
                this.f13845c.c();
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public void clear() {
        synchronized (this.a) {
            this.f13847e = RequestCoordinator.RequestState.CLEARED;
            this.f13845c.clear();
            if (this.f13848f != RequestCoordinator.RequestState.CLEARED) {
                this.f13848f = RequestCoordinator.RequestState.CLEARED;
                this.f13846d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.a) {
            root = this.b != null ? this.b.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isComplete() {
        boolean z2;
        synchronized (this.a) {
            z2 = this.f13847e == RequestCoordinator.RequestState.SUCCESS || this.f13848f == RequestCoordinator.RequestState.SUCCESS;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isRunning() {
        boolean z2;
        synchronized (this.a) {
            z2 = this.f13847e == RequestCoordinator.RequestState.RUNNING || this.f13848f == RequestCoordinator.RequestState.RUNNING;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public void pause() {
        synchronized (this.a) {
            if (this.f13847e == RequestCoordinator.RequestState.RUNNING) {
                this.f13847e = RequestCoordinator.RequestState.PAUSED;
                this.f13845c.pause();
            }
            if (this.f13848f == RequestCoordinator.RequestState.RUNNING) {
                this.f13848f = RequestCoordinator.RequestState.PAUSED;
                this.f13846d.pause();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void d(e eVar) {
        synchronized (this.a) {
            if (eVar.equals(this.f13846d)) {
                this.f13848f = RequestCoordinator.RequestState.FAILED;
                if (this.b != null) {
                    this.b.d(this);
                }
            } else {
                this.f13847e = RequestCoordinator.RequestState.FAILED;
                if (this.f13848f != RequestCoordinator.RequestState.RUNNING) {
                    this.f13848f = RequestCoordinator.RequestState.RUNNING;
                    this.f13846d.c();
                }
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(e eVar) {
        synchronized (this.a) {
            if (eVar.equals(this.f13845c)) {
                this.f13847e = RequestCoordinator.RequestState.SUCCESS;
            } else if (eVar.equals(this.f13846d)) {
                this.f13848f = RequestCoordinator.RequestState.SUCCESS;
            }
            if (this.b != null) {
                this.b.e(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean f(e eVar) {
        boolean z2;
        synchronized (this.a) {
            z2 = d() && g(eVar);
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public boolean a(e eVar) {
        if (!(eVar instanceof b)) {
            return false;
        }
        b bVar = (b) eVar;
        return this.f13845c.a(bVar.f13845c) && this.f13846d.a(bVar.f13846d);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(e eVar) {
        boolean z2;
        synchronized (this.a) {
            z2 = e() && g(eVar);
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.e
    public boolean a() {
        boolean z2;
        synchronized (this.a) {
            z2 = this.f13845c.a() || this.f13846d.a();
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(e eVar) {
        boolean z2;
        synchronized (this.a) {
            z2 = f() && g(eVar);
        }
        return z2;
    }
}
