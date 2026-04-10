package com.kwai.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.n;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends b.a implements i {
    private final g aHF;
    private final WeakReference<FileDownloadServiceProxy> aHG;

    public interface a {
        void a(e eVar);

        void onDisconnected();
    }

    e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.aHG = weakReference;
        this.aHF = gVar;
    }

    @Override // com.kwai.filedownloader.b.b
    public final void HZ() {
        this.aHF.HZ();
    }

    @Override // com.kwai.filedownloader.services.i
    public final void IF() {
        n.GW().a(this);
    }

    @Override // com.kwai.filedownloader.services.i
    public final IBinder IG() {
        return null;
    }

    @Override // com.kwai.filedownloader.b.b
    public final void a(com.kwai.filedownloader.b.a aVar) {
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean ai(String str, String str2) {
        return this.aHF.ak(str, str2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final void b(com.kwai.filedownloader.b.a aVar) {
    }

    @Override // com.kwai.filedownloader.b.b
    public final void b(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, com.kwai.filedownloader.c.b bVar, boolean z4) {
        this.aHF.b(str, str2, z2, i2, i3, i4, z3, bVar, z4);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cQ(int i2) {
        return this.aHF.cQ(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final long cR(int i2) {
        return this.aHF.dc(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final long cS(int i2) {
        return this.aHF.cS(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cw(int i2) {
        return this.aHF.cw(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final byte cx(int i2) {
        return this.aHF.cx(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cy(int i2) {
        return this.aHF.cy(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean isIdle() {
        return this.aHF.isIdle();
    }

    @Override // com.kwai.filedownloader.services.i
    public final void onDestroy() {
        n.GW().onDisconnected();
    }

    @Override // com.kwai.filedownloader.b.b
    public final void pauseAllTasks() {
        this.aHF.IH();
    }

    @Override // com.kwai.filedownloader.b.b
    public final void startForeground(int i2, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aHG;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.aHG.get().context.startForeground(i2, notification);
    }

    @Override // com.kwai.filedownloader.b.b
    public final void stopForeground(boolean z2) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aHG;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.aHG.get().context.stopForeground(z2);
    }
}
