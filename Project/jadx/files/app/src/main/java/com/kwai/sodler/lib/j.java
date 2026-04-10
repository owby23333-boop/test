package com.kwai.sodler.lib;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class j implements com.kwai.sodler.lib.a.e {
    private final com.kwai.sodler.lib.a.d aIA;
    private final com.kwai.sodler.lib.a.g aIB;
    private final com.kwai.sodler.lib.a.c aIC;
    private final com.kwai.sodler.lib.a.b aID;
    private final com.kwai.sodler.lib.ext.a aIE;
    private final com.kwai.sodler.lib.ext.c aIq;

    public static abstract class a {
        final com.kwai.sodler.lib.a.e aIF;

        /* JADX INFO: renamed from: com.kwai.sodler.lib.j$a$a, reason: collision with other inner class name */
        static class C0475a extends a {
            public C0475a(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void m(com.kwai.sodler.lib.a.f fVar) {
                this.aIF.Jf().e(fVar);
            }
        }

        static class b extends a {
            b(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void m(com.kwai.sodler.lib.a.f fVar) {
                this.aIF.Jc().f(fVar);
            }
        }

        static class c extends a {
            c(com.kwai.sodler.lib.a.e eVar) {
                super(eVar);
            }

            @Override // com.kwai.sodler.lib.j.a
            public final void m(com.kwai.sodler.lib.a.f fVar) {
                this.aIF.Jd().i(fVar);
            }
        }

        public a(com.kwai.sodler.lib.a.e eVar) {
            this.aIF = eVar;
        }

        public static a a(com.kwai.sodler.lib.a.e eVar, int i2) {
            return i2 != 1 ? i2 != 256 ? new b(eVar) : new C0475a(eVar) : new c(eVar);
        }

        public abstract void m(com.kwai.sodler.lib.a.f fVar);
    }

    public j(com.kwai.sodler.lib.a.d dVar, com.kwai.sodler.lib.a.g gVar, com.kwai.sodler.lib.a.c cVar, com.kwai.sodler.lib.a.b bVar, com.kwai.sodler.lib.ext.c cVar2, com.kwai.sodler.lib.ext.a aVar) {
        this.aIA = dVar;
        this.aIB = gVar;
        this.aIC = cVar;
        this.aIq = cVar2;
        this.aIE = aVar;
        this.aID = bVar;
    }

    protected static Map f(Map map) {
        return (map == null || map == Collections.EMPTY_MAP) ? new HashMap() : map;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.c Jb() {
        return this.aIq;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.d Jc() {
        return this.aIA;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.g Jd() {
        return this.aIB;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.c Je() {
        return this.aIC;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.a.b Jf() {
        return this.aID;
    }

    @Override // com.kwai.sodler.lib.a.e
    public com.kwai.sodler.lib.ext.a Jg() {
        return this.aIE;
    }

    public com.kwai.sodler.lib.a.f a(@NonNull com.kwai.sodler.lib.a.f fVar, @NonNull a aVar) {
        if (fVar.Jo() == null) {
            fVar.a(this);
        }
        StringBuilder sb = new StringBuilder("request id = ");
        sb.append(fVar.getId());
        sb.append(", state log = ");
        sb.append(fVar.Jp());
        aVar.m(fVar);
        return fVar;
    }
}
