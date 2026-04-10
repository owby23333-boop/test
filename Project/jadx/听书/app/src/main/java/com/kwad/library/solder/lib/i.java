package com.kwad.library.solder.lib;

import android.content.Context;
import android.util.Log;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.ext.b;
import com.kwad.library.solder.lib.ext.c;
import com.kwad.sdk.utils.bw;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    private static volatile i aqD;
    private static Map<String, Integer> aqF = new ConcurrentHashMap(8);
    private static a aqG;
    private e aqE;
    private volatile boolean mHasInit = false;

    public interface a {
        void b(String str, File file);

        void f(String str, Throwable th);

        int getCorePoolSize();

        int getMaxRetryCount();

        boolean zV();
    }

    private i() {
    }

    public static i zS() {
        if (aqD == null) {
            synchronized (i.class) {
                if (aqD == null) {
                    aqD = new i();
                }
            }
        }
        return aqD;
    }

    private static ExecutorService cg(int i) {
        return new ThreadPoolExecutor(i, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.library.solder.lib.i.1
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                try {
                    String name = thread.getName();
                    thread.setName(name + "-");
                    i.aqF.put(name, 1);
                } catch (Throwable th) {
                    com.kwad.library.solder.lib.a.e("Sodler", Log.getStackTraceString(th));
                }
                return thread;
            }
        });
    }

    public static boolean bR(String str) {
        try {
            Map<String, Integer> map = aqF;
            if (map != null) {
                return map.containsKey(str);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(a aVar) {
        aqG = aVar;
    }

    private synchronized void init(Context context) {
        if (this.mHasInit) {
            return;
        }
        c.a aVarBZ = new c.a().bZ("sodler");
        a aVar = aqG;
        c.a aVarBk = aVarBZ.cj(aVar != null ? aVar.getMaxRetryCount() : 1).bk(false);
        a aVar2 = aqG;
        c.a aVarBl = aVarBk.bl(aVar2 != null && aVar2.zV());
        a aVar3 = aqG;
        c.a aVarA = aVarBl.a(cg(aVar3 != null ? aVar3.getCorePoolSize() : 0));
        a aVar4 = aqG;
        com.kwad.library.solder.lib.ext.c cVarAy = aVarA.ck(aVar4 != null ? aVar4.getCorePoolSize() : 0).Ay();
        d dVar = new d(context);
        c cVar = new c(context, cVarAy);
        f fVar = new f(context);
        fVar.a(new f.a() { // from class: com.kwad.library.solder.lib.i.2
            @Override // com.kwad.library.solder.lib.a.f.a
            public final void a(com.kwad.library.solder.lib.a.e eVar, File file) throws PluginError.UpdateError {
                if (i.aqG != null) {
                    try {
                        i.aqG.b(eVar.getDownloadUrl(), file);
                    } catch (Throwable th) {
                        i.aqG.f(eVar.getDownloadUrl(), th);
                        throw new PluginError.UpdateError(th.getMessage(), PluginError.ERROR_UPD_PLUGIN_CONNECTION);
                    }
                }
            }
        });
        this.aqE = new e(dVar, fVar, cVar, cVarAy, new com.kwad.library.solder.lib.ext.a());
        this.mHasInit = true;
    }

    public final <P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> void a(Context context, R r, com.kwad.library.solder.lib.ext.b<P, R> bVar) {
        init(context);
        r.ci(this.aqE.zM().getRetryCount());
        r.a(new b<P, R>(bVar, new b.C0383b()) { // from class: com.kwad.library.solder.lib.i.3
            /* JADX WARN: Incorrect types in method signature: (TR;Lcom/kwad/library/solder/lib/ext/PluginError;)V */
            @Override // com.kwad.library.solder.lib.b, com.kwad.library.solder.lib.ext.b
            public final void a(final com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
                super.a(eVar, pluginError);
                com.kwad.library.solder.lib.a.e("Sodler", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
                i.this.aqE.i(eVar);
                bw.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.library.solder.lib.i.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (eVar.Ac()) {
                            i.this.aqE.a(eVar, 16);
                        }
                    }
                }, eVar.Ab() instanceof PluginError.UpdateError ? 1000L : 0L);
            }
        });
        this.aqE.a(r, 16);
    }

    public final com.kwad.library.solder.lib.a.a m(Context context, String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        e eVar = this.aqE;
        if (eVar != null) {
            return eVar.zN().bP(str);
        }
        return null;
    }

    public final com.kwad.library.solder.lib.ext.c zM() {
        if (!this.mHasInit) {
            throw new RuntimeException("Sodler has not yet been init.");
        }
        return this.aqE.zM();
    }

    public final void l(Context context, final String str) {
        if (!this.mHasInit && context != null) {
            init(context);
        }
        if (zM() == null || zM().Aw() == null) {
            return;
        }
        zM().Aw().execute(new Runnable() { // from class: com.kwad.library.solder.lib.i.4
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    i.this.aqE.zP().bN(str);
                } catch (Throwable th) {
                    Log.getStackTraceString(th);
                }
            }
        });
    }
}
