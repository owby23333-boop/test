package com.yuewen;

import com.duokan.core.diagnostic.LogLevel;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class vn1<T> implements kv3<T> {
    public static wf2<Throwable> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kv3<T> f19072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FutureTask<T> f19073b = new FutureTask<>(new Callable() { // from class: com.yuewen.un1
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return this.f18518a.d();
        }
    });

    public vn1(kv3<T> kv3Var) {
        this.f19072a = kv3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d() throws Exception {
        return this.f19072a.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object e() throws Exception {
        return this.f19072a.get();
    }

    public boolean c() {
        return this.f19073b.isDone();
    }

    public vn1<T> f() {
        this.f19073b = new FutureTask<>(new Callable() { // from class: com.yuewen.tn1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f18014a.e();
            }
        });
        return this;
    }

    @Override // com.yuewen.kv3
    public T get() {
        if (!this.f19073b.isDone()) {
            this.f19073b.run();
        }
        try {
            return this.f19073b.get(20L, TimeUnit.SECONDS);
        } catch (Exception e) {
            ia0.w().j(LogLevel.ERROR, "InitSupplier", "get single error", e);
            wf2<Throwable> wf2Var = c;
            if (wf2Var != null) {
                wf2Var.run(e);
            }
            return null;
        }
    }

    public vn1() {
    }
}
