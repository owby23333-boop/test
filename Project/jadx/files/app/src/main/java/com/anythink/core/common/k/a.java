package com.anythink.core.common.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    private boolean a;
    private final com.anythink.core.common.i.a b = com.anythink.core.common.i.c.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.anythink.core.common.i.b f7637c = new com.anythink.core.common.i.b() { // from class: com.anythink.core.common.k.a.1
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this) {
                if (!a.this.a) {
                    a.b(a.this);
                    a.this.b();
                }
            }
        }
    };

    static /* synthetic */ boolean b(a aVar) {
        aVar.a = true;
        return true;
    }

    private boolean c() {
        return this.a;
    }

    protected abstract void b();

    protected final synchronized void a(long j2) {
        this.b.a(this.f7637c, j2, false);
    }

    public final synchronized void a() {
        this.b.a(this.f7637c);
    }
}
