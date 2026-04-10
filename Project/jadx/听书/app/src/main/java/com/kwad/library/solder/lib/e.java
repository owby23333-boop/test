package com.kwad.library.solder.lib;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes4.dex */
public final class e implements com.kwad.library.solder.lib.a.d {
    private final com.kwad.library.solder.lib.ext.c aqp;
    private final com.kwad.library.solder.lib.a.c aqr;
    private final com.kwad.library.solder.lib.a.f aqs;
    private final com.kwad.library.solder.lib.a.b aqt;
    private final com.kwad.library.solder.lib.ext.a aqu;
    private Map<String, b> aqv;

    public e(com.kwad.library.solder.lib.a.c cVar, com.kwad.library.solder.lib.a.f fVar, com.kwad.library.solder.lib.a.b bVar, com.kwad.library.solder.lib.ext.c cVar2, com.kwad.library.solder.lib.ext.a aVar) {
        this.aqr = cVar;
        this.aqs = fVar;
        this.aqt = bVar;
        this.aqp = cVar2;
        this.aqu = aVar;
    }

    public final com.kwad.library.solder.lib.a.e a(com.kwad.library.solder.lib.a.e eVar, a aVar) {
        if (eVar.zZ() == null) {
            eVar.a(this);
        }
        eVar.Ad();
        eVar.Aa();
        aVar.j(eVar);
        return eVar;
    }

    public final b a(com.kwad.library.solder.lib.a.e eVar, int i) {
        return b(eVar, a.a(this, 16));
    }

    private b b(final com.kwad.library.solder.lib.a.e eVar, final a aVar) {
        b bVarBQ = bQ(eVar.Ad());
        if (bVarBQ != null) {
            bVarBQ.cancel();
        }
        eVar.a(this);
        b bVar = new b(eVar, this.aqp.Aw().submit(new Callable<com.kwad.library.solder.lib.a.e>() { // from class: com.kwad.library.solder.lib.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: zR, reason: merged with bridge method [inline-methods] */
            public com.kwad.library.solder.lib.a.e call() {
                return e.this.a(eVar, aVar);
            }
        }));
        a(eVar.Ad(), bVar);
        return bVar;
    }

    public final void i(com.kwad.library.solder.lib.a.e eVar) {
        b bVarBQ = bQ(eVar.Ad());
        if (bVarBQ != null) {
            bVarBQ.cancel();
        }
        a(eVar.Ad(), (b) null);
    }

    private synchronized b bQ(String str) {
        Map<String, b> mapD = d(this.aqv);
        this.aqv = mapD;
        if (str == null) {
            return null;
        }
        return mapD.get(str);
    }

    private synchronized void a(String str, b bVar) {
        Map<String, b> mapD = d(this.aqv);
        this.aqv = mapD;
        if (str != null) {
            mapD.put(str, bVar);
        }
    }

    private static Map<String, b> d(Map<String, b> map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.c zM() {
        return this.aqp;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.c zN() {
        return this.aqr;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.f zO() {
        return this.aqs;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.a.b zP() {
        return this.aqt;
    }

    @Override // com.kwad.library.solder.lib.a.d
    public final com.kwad.library.solder.lib.ext.a zQ() {
        return this.aqu;
    }

    public static abstract class a {
        final com.kwad.library.solder.lib.a.d aqz;

        public abstract void j(com.kwad.library.solder.lib.a.e eVar);

        public static a a(com.kwad.library.solder.lib.a.d dVar, int i) {
            if (i == 1) {
                return new b(dVar);
            }
            return new C0382a(dVar);
        }

        public a(com.kwad.library.solder.lib.a.d dVar) {
            this.aqz = dVar;
        }

        static class b extends a {
            b(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.aqz.zO().k(eVar);
            }
        }

        /* JADX INFO: renamed from: com.kwad.library.solder.lib.e$a$a, reason: collision with other inner class name */
        static class C0382a extends a {
            C0382a(com.kwad.library.solder.lib.a.d dVar) {
                super(dVar);
            }

            @Override // com.kwad.library.solder.lib.e.a
            public final void j(com.kwad.library.solder.lib.a.e eVar) {
                this.aqz.zN().g(eVar);
            }
        }
    }

    public static class b {
        private final com.kwad.library.solder.lib.a.e aqA;
        private final Future<com.kwad.library.solder.lib.a.e> aqB;

        public b(com.kwad.library.solder.lib.a.e eVar, Future<com.kwad.library.solder.lib.a.e> future) {
            this.aqA = eVar;
            this.aqB = future;
        }

        public final void cancel() {
            this.aqA.cancel();
            this.aqB.cancel(true);
        }
    }
}
