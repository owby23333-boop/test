package com.anythink.expressad.foundation.g.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static final String a = "j";
    private Context b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<i> f10600d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ExecutorService f10601e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f10602f = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f10599c = new d(new Handler(Looper.getMainLooper()));

    public interface a {
        boolean a(i<?> iVar);
    }

    public j(Context context) {
        this.b = context.getApplicationContext();
    }

    private int a() {
        return this.f10602f.incrementAndGet();
    }

    final void b(i iVar) {
        synchronized (this) {
            this.f10600d.remove(iVar);
        }
    }

    private void a(a aVar) {
        synchronized (this) {
            for (i iVar : this.f10600d) {
                if (aVar.a(iVar)) {
                    iVar.e();
                }
            }
        }
    }

    private void a(final Object obj) {
        if (obj != null) {
            a(new a() { // from class: com.anythink.expressad.foundation.g.f.j.1
                @Override // com.anythink.expressad.foundation.g.f.j.a
                public final boolean a(i<?> iVar) {
                    return iVar.b() == obj;
                }
            });
            return;
        }
        throw new IllegalArgumentException("Cannot cancelAll with a null tag");
    }

    public final void a(final i iVar) {
        iVar.a(this);
        synchronized (this) {
            this.f10600d.add(iVar);
        }
        iVar.a(this.f10602f.incrementAndGet());
        this.f10601e.execute(new Runnable() { // from class: com.anythink.expressad.foundation.g.f.j.2
            @Override // java.lang.Runnable
            public final void run() {
                Context unused = j.this.b;
                new h(null, j.this.f10599c).a(iVar);
            }
        });
    }
}
