package com.kwad.sdk.core.video.a;

import android.media.TimedText;
import com.kwad.sdk.core.video.a.c;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements c {
    private c.f aKh;
    private c.g aKi;
    private c.h aKj;
    private c.e aaa;
    private c.i aab;
    private c.b aac;
    private c.InterfaceC0408c aad;
    private c.d aae;
    private c.a aaf;

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.f fVar) {
        this.aKh = fVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(c.e eVar) {
        this.aaa = eVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.b bVar) {
        this.aac = bVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.a aVar) {
        this.aaf = aVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.g gVar) {
        this.aKi = gVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.i iVar) {
        this.aab = iVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.InterfaceC0408c interfaceC0408c) {
        this.aad = interfaceC0408c;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void c(c.d dVar) {
        this.aae = dVar;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void a(c.h hVar) {
        this.aKj = hVar;
    }

    public final void resetListeners() {
        this.aKh = null;
        this.aaa = null;
        this.aaf = null;
        this.aac = null;
        this.aKi = null;
        this.aab = null;
        this.aad = null;
        this.aae = null;
        this.aKj = null;
    }

    protected final void JV() {
        c.f fVar = this.aKh;
        if (fVar != null) {
            fVar.tG();
        }
    }

    public final void notifyOnPrepared() {
        c.e eVar = this.aaa;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    public final void notifyOnCompletion() {
        c.b bVar = this.aac;
        if (bVar != null) {
            bVar.qK();
        }
    }

    public final void notifyOnBufferingUpdate(int i) {
        c.a aVar = this.aaf;
        if (aVar != null) {
            aVar.aK(i);
        }
    }

    public final void notifyOnSeekComplete() {
        c.g gVar = this.aKi;
        if (gVar != null) {
            gVar.qL();
        }
    }

    public final void x(int i, int i2) {
        c.i iVar = this.aab;
        if (iVar != null) {
            iVar.l(i, i2);
        }
    }

    public final boolean notifyOnError(int i, int i2) {
        com.kwad.sdk.core.video.a.a.a.eE("videoPlayError");
        c.InterfaceC0408c interfaceC0408c = this.aad;
        return interfaceC0408c != null && interfaceC0408c.m(i, i2);
    }

    public final boolean notifyOnInfo(int i, int i2) {
        c.d dVar = this.aae;
        return dVar != null && dVar.n(i, i2);
    }

    protected final void b(TimedText timedText) {
        c.h hVar = this.aKj;
        if (hVar != null) {
            hVar.a(timedText);
        }
    }

    protected static void h(float f) {
        if (f == 0.0f) {
            com.kwad.sdk.core.video.a.a.a.eE("autoMute");
        } else {
            com.kwad.sdk.core.video.a.a.a.eE("autoVoice");
        }
    }
}
