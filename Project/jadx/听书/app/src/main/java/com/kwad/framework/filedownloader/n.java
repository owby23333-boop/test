package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;

/* JADX INFO: loaded from: classes4.dex */
public final class n implements u {
    private final u amj;

    /* synthetic */ n(byte b) {
        this();
    }

    static final class a {
        private static final n amk = new n(0);
    }

    public static n xA() {
        return a.amk;
    }

    public static e.a xB() {
        if (xA().amj instanceof o) {
            return (e.a) xA().amj;
        }
        return null;
    }

    private n() {
        u pVar;
        if (com.kwad.framework.filedownloader.f.e.zB().apH) {
            pVar = new o();
        } else {
            pVar = new p(FileDownloadService.SeparateProcessService.class);
        }
        this.amj = pVar;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        return this.amj.a(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bw(int i) {
        return this.amj.bw(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte bx(int i) {
        return this.amj.bx(i);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.amj.isConnected();
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void aG(Context context) {
        this.amj.aG(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean by(int i) {
        return this.amj.by(i);
    }
}
