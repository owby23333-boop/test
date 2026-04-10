package com.kwai.sodler.lib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.sodler.lib.j;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends j {
    private static volatile i aIt;
    private j aIu;
    private ExecutorService aIv;
    private Map<String, a> aIw;
    private volatile boolean mHasInit;

    public static class a {
        private final com.kwai.sodler.lib.a.f aIz;
        private final Future<com.kwai.sodler.lib.a.f> adO;

        public a(com.kwai.sodler.lib.a.f fVar, Future<com.kwai.sodler.lib.a.f> future) {
            this.aIz = fVar;
            this.adO = future;
        }

        public final void cancel() {
            this.aIz.cancel();
            this.adO.cancel(true);
        }
    }

    private i() {
        super(null, null, null, null, null, null);
        this.mHasInit = false;
    }

    public static i IZ() {
        if (aIt == null) {
            synchronized (i.class) {
                if (aIt == null) {
                    aIt = new i();
                }
            }
        }
        return aIt;
    }

    private static ExecutorService Ja() {
        return new ThreadPoolExecutor(0, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwai.sodler.lib.i.1
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "ksad-Sodler-" + this.poolNumber.getAndIncrement());
            }
        });
    }

    private void Jh() {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
    }

    private synchronized void a(String str, a aVar) {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        this.aIw = j.f(this.aIw);
        if (str != null) {
            this.aIw.put(str, aVar);
        }
    }

    private a b(@NonNull final com.kwai.sodler.lib.a.f fVar, @NonNull final j.a aVar) {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        a aVarFw = fw(fVar.getId());
        if (aVarFw != null) {
            aVarFw.cancel();
        }
        fVar.a(this);
        a aVar2 = new a(fVar, this.aIv.submit(new Callable<com.kwai.sodler.lib.a.f>() { // from class: com.kwai.sodler.lib.i.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: Ji, reason: merged with bridge method [inline-methods] */
            public com.kwai.sodler.lib.a.f call() {
                return i.this.a(fVar, aVar);
            }
        }));
        a(fVar.getId(), aVar2);
        return aVar2;
    }

    @Nullable
    private synchronized a fw(String str) {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        this.aIw = j.f(this.aIw);
        if (str == null) {
            return null;
        }
        return this.aIw.get(str);
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.c Jb() {
        if (this.mHasInit) {
            return this.aIu.Jb();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.d Jc() {
        if (this.mHasInit) {
            return this.aIu.Jc();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.g Jd() {
        if (this.mHasInit) {
            return this.aIu.Jd();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.c Je() {
        if (this.mHasInit) {
            return this.aIu.Je();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.a.b Jf() {
        if (this.mHasInit) {
            return this.aIu.Jf();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j, com.kwai.sodler.lib.a.e
    public final com.kwai.sodler.lib.ext.a Jg() {
        if (this.mHasInit) {
            return this.aIu.Jg();
        }
        throw new RuntimeException("Sodler has not yet been init.");
    }

    @Override // com.kwai.sodler.lib.j
    public final com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull j.a aVar) {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        com.kwai.sodler.lib.a.e eVarJo = fVar.Jo();
        j jVar = this.aIu;
        if (eVarJo == null) {
            eVarJo = jVar;
        }
        return jVar.a(fVar.a(eVarJo), aVar);
    }

    public final a a(@NonNull com.kwai.sodler.lib.a.f fVar, int i2) {
        return b(fVar, j.a.a(this, 16));
    }

    public final synchronized void a(Context context, @NonNull com.kwai.sodler.lib.ext.c cVar) {
        if (!this.mHasInit) {
            d dVar = new d(context);
            e eVar = new e(context);
            c cVar2 = new c(context, cVar);
            b bVar = new b();
            this.aIv = Ja();
            this.aIu = new j(dVar, eVar, cVar2, bVar, cVar, new com.kwai.sodler.lib.ext.a());
            this.mHasInit = true;
            Jh();
        }
    }

    public final void l(@NonNull com.kwai.sodler.lib.a.f fVar) {
        a aVarFw = fw(fVar.getId());
        if (aVarFw != null) {
            aVarFw.cancel();
        }
        a(fVar.getId(), (a) null);
    }
}
