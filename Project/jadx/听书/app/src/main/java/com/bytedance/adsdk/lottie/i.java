package com.bytedance.adsdk.lottie;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public class i<T> {
    public static Executor z = com.bytedance.sdk.component.uy.dl.g(new com.bytedance.sdk.component.uy.uy("ie/LottieTask"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f153a;
    private final Set<uy<Throwable>> dl;
    private final Set<uy<T>> g;
    private volatile wp<T> gc;

    public i(Callable<wp<T>> callable) {
        this(callable, false);
    }

    i(Callable<wp<T>> callable, boolean z2) {
        this.g = new LinkedHashSet(1);
        this.dl = new LinkedHashSet(1);
        this.f153a = new Handler(Looper.getMainLooper());
        this.gc = null;
        if (z2) {
            try {
                setResult(callable.call());
                return;
            } catch (Throwable th) {
                setResult(new wp<>(th));
                return;
            }
        }
        z.execute(new z(callable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(wp<T> wpVar) {
        if (this.gc != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.gc = wpVar;
        z();
    }

    public synchronized i<T> z(uy<T> uyVar) {
        wp<T> wpVar = this.gc;
        if (wpVar != null && wpVar.z() != null) {
            uyVar.z(wpVar.z());
        }
        this.g.add(uyVar);
        return this;
    }

    public synchronized i<T> g(uy<T> uyVar) {
        this.g.remove(uyVar);
        return this;
    }

    public synchronized i<T> dl(uy<Throwable> uyVar) {
        wp<T> wpVar = this.gc;
        if (wpVar != null && wpVar.g() != null) {
            uyVar.z(wpVar.g());
        }
        this.dl.add(uyVar);
        return this;
    }

    public synchronized i<T> a(uy<Throwable> uyVar) {
        this.dl.remove(uyVar);
        return this;
    }

    private void z() {
        this.f153a.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.i.1
            @Override // java.lang.Runnable
            public void run() {
                wp wpVar = i.this.gc;
                if (wpVar == null) {
                    return;
                }
                if (wpVar.z() != null) {
                    i.this.z(wpVar.z());
                } else {
                    i.this.z(wpVar.g());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(T t) {
        Iterator it = new ArrayList(this.g).iterator();
        while (it.hasNext()) {
            ((uy) it.next()).z(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void z(Throwable th) {
        ArrayList arrayList = new ArrayList(this.dl);
        if (arrayList.isEmpty()) {
            com.bytedance.adsdk.lottie.gc.gc.z("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((uy) it.next()).z(th);
        }
    }

    private class z extends FutureTask<wp<T>> {
        z(Callable<wp<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                i.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                i.this.setResult(new wp(e));
            }
        }
    }
}
