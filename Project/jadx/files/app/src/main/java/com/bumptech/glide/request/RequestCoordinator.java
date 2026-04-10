package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes2.dex */
public interface RequestCoordinator {

    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);


        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final boolean f13813s;

        RequestState(boolean z2) {
            this.f13813s = z2;
        }

        boolean f() {
            return this.f13813s;
        }
    }

    boolean a();

    boolean b(e eVar);

    boolean c(e eVar);

    void d(e eVar);

    void e(e eVar);

    boolean f(e eVar);

    RequestCoordinator getRoot();
}
