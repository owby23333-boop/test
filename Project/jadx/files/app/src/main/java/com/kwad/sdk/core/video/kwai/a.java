package com.kwad.sdk.core.video.kwai;

import android.media.TimedText;
import com.kwad.sdk.core.video.kwai.c;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements c {
    private c.e QP;
    private c.h QQ;
    private c.b QR;
    private c.InterfaceC0446c QS;
    private c.d QT;
    private c.a QU;
    private c.f aml;
    private c.g amm;

    protected static void f(float f2) {
        com.kwad.sdk.core.video.kwai.kwai.a.cu(f2 == 0.0f ? "autoMute" : "autoVoice");
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.a aVar) {
        this.QU = aVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.b bVar) {
        this.QR = bVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.InterfaceC0446c interfaceC0446c) {
        this.QS = interfaceC0446c;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.f fVar) {
        this.aml = fVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.g gVar) {
        this.amm = gVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(c.h hVar) {
        this.QQ = hVar;
    }

    protected final void b(TimedText timedText) {
        c.g gVar = this.amm;
        if (gVar != null) {
            gVar.a(timedText);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void b(c.e eVar) {
        this.QP = eVar;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void c(c.d dVar) {
        this.QT = dVar;
    }

    protected final void notifyOnBufferingUpdate(int i2) {
        c.a aVar = this.QU;
        if (aVar != null) {
            aVar.av(i2);
        }
    }

    protected final void notifyOnCompletion() {
        c.b bVar = this.QR;
        if (bVar != null) {
            bVar.on();
        }
    }

    protected final boolean notifyOnError(int i2, int i3) {
        c.InterfaceC0446c interfaceC0446c = this.QS;
        return interfaceC0446c != null && interfaceC0446c.j(i2, i3);
    }

    protected final boolean notifyOnInfo(int i2, int i3) {
        c.d dVar = this.QT;
        return dVar != null && dVar.k(i2, i3);
    }

    protected final void notifyOnPrepared() {
        c.e eVar = this.QP;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    protected final void notifyOnSeekComplete() {
        c.f fVar = this.aml;
        if (fVar != null) {
            fVar.oo();
        }
    }

    protected final void q(int i2, int i3) {
        c.h hVar = this.QQ;
        if (hVar != null) {
            hVar.i(i2, i3);
        }
    }

    public final void resetListeners() {
        this.QP = null;
        this.QU = null;
        this.QR = null;
        this.aml = null;
        this.QQ = null;
        this.QS = null;
        this.QT = null;
        this.amm = null;
    }
}
