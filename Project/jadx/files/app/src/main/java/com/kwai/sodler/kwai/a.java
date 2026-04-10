package com.kwai.sodler.kwai;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.a.g;
import com.kwai.sodler.lib.ext.PluginError;
import com.kwai.sodler.lib.ext.b;
import com.kwai.sodler.lib.ext.c;
import com.kwai.sodler.lib.i;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static InterfaceC0472a aIi = null;
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static volatile boolean hasInit = false;

    /* JADX INFO: renamed from: com.kwai.sodler.kwai.a$a, reason: collision with other inner class name */
    public interface InterfaceC0472a {
        void a(f fVar, File file);

        int getMaxRetryCount();

        boolean sF();
    }

    static class b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> extends b.C0473b<P, R> {
        com.kwai.sodler.lib.ext.b<P, R> aIl;
        c<P, R> aIm;

        protected b(com.kwai.sodler.lib.ext.b<P, R> bVar, c<P, R> cVar) {
            this.aIl = bVar;
            this.aIm = cVar;
        }

        @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
        public final void a(R r2) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aIl;
            if (bVar != null) {
                bVar.a(r2);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
        public final void a(R r2, P p2) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aIl;
            if (bVar != null) {
                bVar.a(r2, p2);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
        public final void a(R r2, PluginError pluginError) {
            com.kwai.sodler.lib.a.e("Sodler.helper", "load failed:" + pluginError.getCode() + ":" + pluginError.getMessage());
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aIl;
            if (bVar != null) {
                bVar.a(r2, pluginError);
            }
            c<P, R> cVar = this.aIm;
            if (cVar != null) {
                cVar.d(r2);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
        public final void b(R r2) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aIl;
            if (bVar != null) {
                bVar.b(r2);
            }
        }

        @Override // com.kwai.sodler.lib.ext.b.C0473b, com.kwai.sodler.lib.ext.b
        public final void c(R r2) {
            com.kwai.sodler.lib.ext.b<P, R> bVar = this.aIl;
            if (bVar != null) {
                bVar.c(r2);
            }
        }
    }

    interface c<P extends com.kwai.sodler.lib.a.a, R extends f<P>> {
        void d(R r2);
    }

    private static <P extends com.kwai.sodler.lib.a.a, R extends f<P>> void a(Context context, R r2, com.kwai.sodler.lib.ext.b<P, R> bVar) {
        init(context);
        r2.dh(i.IZ().Jb().getRetryCount());
        r2.a(new b(bVar, new c<P, R>() { // from class: com.kwai.sodler.kwai.a.1
            /* JADX WARN: Incorrect types in method signature: (TR;)V */
            @Override // com.kwai.sodler.kwai.a.c
            public final void d(final f fVar) {
                i.IZ().l(fVar);
                a.handler.postDelayed(new Runnable() { // from class: com.kwai.sodler.kwai.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (fVar.Jr()) {
                            i.IZ().a(fVar, 16);
                        }
                    }
                }, fVar.Jq() instanceof PluginError.UpdateError ? 1000L : 0L);
            }
        }));
        i.IZ().a(r2, 16);
    }

    public static void a(Context context, @NonNull com.kwai.sodler.lib.c.b bVar, b.a aVar) {
        a(context, new com.kwai.sodler.lib.b.a(bVar), aVar);
    }

    public static void a(Context context, @NonNull com.kwai.sodler.lib.c.b bVar, b.c cVar) {
        a(context, new com.kwai.sodler.lib.b.c(bVar), cVar);
    }

    public static void a(InterfaceC0472a interfaceC0472a) {
        aIi = interfaceC0472a;
    }

    @Nullable
    public static <T extends com.kwai.sodler.lib.a.a> T as(Context context, String str) {
        init(context);
        return (T) i.IZ().Jc().fv(str);
    }

    private static synchronized void dC(Context context) {
        c.a aVar = new c.a();
        aVar.fH("sodler");
        aVar.di(1);
        aVar.bQ(false);
        aVar.bR(true);
        i.IZ().a(context, aVar.JM());
    }

    private static synchronized void init(Context context) {
        if (hasInit) {
            return;
        }
        if (aIi == null) {
            dC(context);
            hasInit = true;
            return;
        }
        c.a aVar = new c.a();
        aVar.fH("sodler");
        aVar.di(aIi.getMaxRetryCount());
        aVar.bQ(false);
        aVar.bR(aIi.sF());
        i.IZ().a(context, aVar.JM());
        i.IZ().Jd().a(new g.a() { // from class: com.kwai.sodler.kwai.a.2
            @Override // com.kwai.sodler.lib.a.g.a
            public final void a(f fVar, File file) {
                a.aIi.a(fVar, file);
            }
        });
        hasInit = true;
    }
}
