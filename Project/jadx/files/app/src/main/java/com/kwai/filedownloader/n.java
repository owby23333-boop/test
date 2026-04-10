package com.kwai.filedownloader;

import android.content.Context;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwai.filedownloader.services.e;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements u {
    private final u aEz;

    static final class a {
        private static final n aEA = new n(0);
    }

    private n() {
        this.aEz = com.kwai.filedownloader.e.e.IP().aHX ? new o() : new p(FileDownloadService.SeparateProcessService.class);
    }

    /* synthetic */ n(byte b) {
        this();
    }

    public static n GV() {
        return a.aEA;
    }

    public static e.a GW() {
        if (GV().aEz instanceof o) {
            return (e.a) GV().aEz;
        }
        return null;
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, com.kwai.filedownloader.c.b bVar, boolean z4) {
        return this.aEz.a(str, str2, z2, i2, i3, i4, z3, bVar, z4);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cw(int i2) {
        return this.aEz.cw(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final byte cx(int i2) {
        return this.aEz.cx(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cy(int i2) {
        return this.aEz.cy(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final void dw(Context context) {
        this.aEz.dw(context);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        return this.aEz.isConnected();
    }
}
