package com.kwai.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.services.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class o implements e.a, u {
    private static Class<?> aEB;
    private final ArrayList<Runnable> aEC = new ArrayList<>();
    private com.kwai.filedownloader.services.e aED;

    o() {
    }

    private static Class<?> GY() {
        if (aEB == null) {
            aEB = FileDownloadService.SharedMainProcessService.class;
        }
        return aEB;
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, GY()));
    }

    @Override // com.kwai.filedownloader.services.e.a
    public final void a(com.kwai.filedownloader.services.e eVar) {
        this.aED = eVar;
        List list = (List) this.aEC.clone();
        this.aEC.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        f.GI().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, GY()));
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, com.kwai.filedownloader.c.b bVar, boolean z4) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.l(str, str2, z2);
        }
        this.aED.b(str, str2, z2, i2, i3, i4, z3, bVar, z4);
        return true;
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cw(int i2) {
        return !isConnected() ? com.kwai.filedownloader.e.a.cw(i2) : this.aED.cw(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final byte cx(int i2) {
        return !isConnected() ? com.kwai.filedownloader.e.a.cx(i2) : this.aED.cx(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cy(int i2) {
        return !isConnected() ? com.kwai.filedownloader.e.a.cy(i2) : this.aED.cy(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final void dw(Context context) {
        a(context, null);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        return this.aED != null;
    }

    @Override // com.kwai.filedownloader.services.e.a
    public final void onDisconnected() {
        this.aED = null;
        f.GI().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, GY()));
    }
}
