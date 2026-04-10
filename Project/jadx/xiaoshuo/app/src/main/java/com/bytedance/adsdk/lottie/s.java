package com.bytedance.adsdk.lottie;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class s<T> {
    public static Executor e = Executors.newCachedThreadPool();
    private final Set<m<T>> bf;
    private final Set<m<Throwable>> d;
    private volatile t<T> ga;
    private final Handler tg;

    public class e extends FutureTask<t<T>> {
        public e(Callable<t<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                s.this.setResult(get());
            } catch (InterruptedException | ExecutionException e) {
                s.this.setResult(new t(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public s(Callable<t<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(t<T> tVar) {
        if (this.ga != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.ga = tVar;
        e();
    }

    public synchronized s<T> bf(m<T> mVar) {
        this.bf.remove(mVar);
        return this;
    }

    public synchronized s<T> d(m<Throwable> mVar) {
        t<T> tVar = this.ga;
        if (tVar != null && tVar.bf() != null) {
            mVar.e(tVar.bf());
        }
        this.d.add(mVar);
        return this;
    }

    public synchronized s<T> tg(m<Throwable> mVar) {
        this.d.remove(mVar);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public s(Callable<t<T>> callable, boolean z) {
        this.bf = new LinkedHashSet(1);
        this.d = new LinkedHashSet(1);
        this.tg = new Handler(Looper.getMainLooper());
        this.ga = null;
        if (!z) {
            e.execute(new e(callable));
            return;
        }
        try {
            setResult(callable.call());
        } catch (Throwable th) {
            setResult(new t<>(th));
        }
    }

    public synchronized s<T> e(m<T> mVar) {
        t<T> tVar = this.ga;
        if (tVar != null && tVar.e() != null) {
            mVar.e(tVar.e());
        }
        this.bf.add(mVar);
        return this;
    }

    private void e() {
        this.tg.post(new Runnable() { // from class: com.bytedance.adsdk.lottie.s.1
            @Override // java.lang.Runnable
            public void run() {
                t tVar = s.this.ga;
                if (tVar == null) {
                    return;
                }
                if (tVar.e() != null) {
                    s.this.e(tVar.e());
                } else {
                    s.this.e(tVar.bf());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(T t) {
        Iterator it = new ArrayList(this.bf).iterator();
        while (it.hasNext()) {
            ((m) it.next()).e(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(Throwable th) {
        ArrayList arrayList = new ArrayList(this.d);
        if (arrayList.isEmpty()) {
            com.bytedance.adsdk.lottie.vn.tg.e("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((m) it.next()).e(th);
        }
    }
}
