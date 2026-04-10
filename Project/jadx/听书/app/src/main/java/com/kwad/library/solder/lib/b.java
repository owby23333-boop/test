package com.kwad.library.solder.lib;

import com.kwad.library.solder.lib.a.a;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;

/* JADX INFO: loaded from: classes4.dex */
public class b<P extends com.kwad.library.solder.lib.a.a, R extends com.kwad.library.solder.lib.a.e<P>> implements com.kwad.library.solder.lib.ext.b<P, R> {
    com.kwad.library.solder.lib.ext.b<P, R> aql;
    com.kwad.library.solder.lib.ext.b<P, R> aqm;

    public b(com.kwad.library.solder.lib.ext.b<P, R> bVar, com.kwad.library.solder.lib.ext.b<P, R> bVar2) {
        this.aql = bVar;
        this.aqm = bVar2;
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void e(R r) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.e(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void d(R r) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.d(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void f(R r) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.f(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void c(R r) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.c(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void a(R r, P p) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.a(r, p);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public void a(R r, PluginError pluginError) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.a(r, pluginError);
        }
        com.kwad.library.solder.lib.ext.b<P, R> bVar2 = this.aqm;
        if (bVar2 != null) {
            bVar2.a(r, pluginError);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void b(R r) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.b(r);
        }
    }

    @Override // com.kwad.library.solder.lib.ext.b
    public final void a(R r) {
        com.kwad.library.solder.lib.ext.b<P, R> bVar = this.aql;
        if (bVar != null) {
            bVar.a(r);
        }
    }
}
