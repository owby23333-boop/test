package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* JADX INFO: compiled from: ThumbnailRequestCoordinator.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements RequestCoordinator, e {

    @Nullable
    private final RequestCoordinator a;
    private final Object b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile e f13857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile e f13858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f13859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("requestLock")
    private RequestCoordinator.RequestState f13860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("requestLock")
    private boolean f13861g;

    public j(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f13859e = requestState;
        this.f13860f = requestState;
        this.b = obj;
        this.a = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean d() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.f(this);
    }

    @GuardedBy("requestLock")
    private boolean e() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    @GuardedBy("requestLock")
    private boolean f() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    public void a(e eVar, e eVar2) {
        this.f13857c = eVar;
        this.f13858d = eVar2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(e eVar) {
        boolean z2;
        synchronized (this.b) {
            z2 = e() && eVar.equals(this.f13857c) && !a();
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(e eVar) {
        boolean z2;
        synchronized (this.b) {
            z2 = f() && (eVar.equals(this.f13857c) || this.f13859e != RequestCoordinator.RequestState.SUCCESS);
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public void clear() {
        synchronized (this.b) {
            this.f13861g = false;
            this.f13859e = RequestCoordinator.RequestState.CLEARED;
            this.f13860f = RequestCoordinator.RequestState.CLEARED;
            this.f13858d.clear();
            this.f13857c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.b) {
            root = this.a != null ? this.a.getRoot() : this;
        }
        return root;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isComplete() {
        boolean z2;
        synchronized (this.b) {
            z2 = this.f13859e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public boolean isRunning() {
        boolean z2;
        synchronized (this.b) {
            z2 = this.f13859e == RequestCoordinator.RequestState.RUNNING;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public void pause() {
        synchronized (this.b) {
            if (!this.f13860f.f()) {
                this.f13860f = RequestCoordinator.RequestState.PAUSED;
                this.f13858d.pause();
            }
            if (!this.f13859e.f()) {
                this.f13859e = RequestCoordinator.RequestState.PAUSED;
                this.f13857c.pause();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void d(e eVar) {
        synchronized (this.b) {
            if (!eVar.equals(this.f13857c)) {
                this.f13860f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.f13859e = RequestCoordinator.RequestState.FAILED;
            if (this.a != null) {
                this.a.d(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(e eVar) {
        synchronized (this.b) {
            if (eVar.equals(this.f13858d)) {
                this.f13860f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.f13859e = RequestCoordinator.RequestState.SUCCESS;
            if (this.a != null) {
                this.a.e(this);
            }
            if (!this.f13860f.f()) {
                this.f13858d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean f(e eVar) {
        boolean z2;
        synchronized (this.b) {
            z2 = d() && eVar.equals(this.f13857c) && this.f13859e != RequestCoordinator.RequestState.PAUSED;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.e
    public boolean a() {
        boolean z2;
        synchronized (this.b) {
            z2 = this.f13858d.a() || this.f13857c.a();
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public boolean b() {
        boolean z2;
        synchronized (this.b) {
            z2 = this.f13859e == RequestCoordinator.RequestState.CLEARED;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.e
    public void c() {
        synchronized (this.b) {
            this.f13861g = true;
            try {
                if (this.f13859e != RequestCoordinator.RequestState.SUCCESS && this.f13860f != RequestCoordinator.RequestState.RUNNING) {
                    this.f13860f = RequestCoordinator.RequestState.RUNNING;
                    this.f13858d.c();
                }
                if (this.f13861g && this.f13859e != RequestCoordinator.RequestState.RUNNING) {
                    this.f13859e = RequestCoordinator.RequestState.RUNNING;
                    this.f13857c.c();
                }
            } finally {
                this.f13861g = false;
            }
        }
    }

    @Override // com.bumptech.glide.request.e
    public boolean a(e eVar) {
        if (!(eVar instanceof j)) {
            return false;
        }
        j jVar = (j) eVar;
        if (this.f13857c == null) {
            if (jVar.f13857c != null) {
                return false;
            }
        } else if (!this.f13857c.a(jVar.f13857c)) {
            return false;
        }
        if (this.f13858d == null) {
            if (jVar.f13858d != null) {
                return false;
            }
        } else if (!this.f13858d.a(jVar.f13858d)) {
            return false;
        }
        return true;
    }
}
