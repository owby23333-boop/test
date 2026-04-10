package com.bytedance.sdk.component.uy.dl;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends com.bytedance.sdk.component.uy.z.dl implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Runnable f804a;

    public dl(Runnable runnable) {
        super(runnable);
        this.f804a = runnable;
        g(false);
        z(false);
    }

    @Override // com.bytedance.sdk.component.uy.z.dl, java.lang.Runnable
    public void run() {
        this.f804a.run();
    }
}
