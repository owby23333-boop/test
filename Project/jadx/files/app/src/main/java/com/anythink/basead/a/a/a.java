package com.anythink.basead.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<R, E> implements c<R, E> {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b<R, E> f5754c;

    @Override // com.anythink.basead.a.a.c
    public final void a() {
        if (!this.a.get() && this.b.decrementAndGet() == 0) {
            this.a.set(true);
            b<R, E> bVar = this.f5754c;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // com.anythink.basead.a.a.c
    public final void a(E e2) {
        if (this.a.get()) {
            return;
        }
        this.a.set(true);
        b<R, E> bVar = this.f5754c;
        if (bVar != null) {
            bVar.a(e2);
        }
    }

    @Override // com.anythink.basead.a.a.c
    public final void a(int i2) {
        this.b.set(i2);
    }

    @Override // com.anythink.basead.a.a.c
    public final void a(b<R, E> bVar) {
        this.f5754c = bVar;
    }
}
