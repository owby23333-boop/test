package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.n;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends b.a implements i {
    private final g apq;
    private final WeakReference<FileDownloadServiceProxy> apr;

    public interface a {
        void a(e eVar);

        void onDisconnected();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder zq() {
        return null;
    }

    e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.apr = weakReference;
        this.apq = gVar;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean x(String str, String str2) {
        return this.apq.z(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        this.apq.b(str, str2, z, i, i2, i3, z2, bVar, z3);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bw(int i) {
        return this.apq.bw(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.apq.zs();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bQ(int i) {
        return this.apq.bQ(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bR(int i) {
        return this.apq.cc(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bS(int i) {
        return this.apq.bS(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final byte bx(int i) {
        return this.apq.bx(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean isIdle() {
        return this.apq.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void startForeground(int i, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.apr;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.apr.get().context.startForeground(i, notification);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void stopForeground(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.apr;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.apr.get().context.stopForeground(z);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean by(int i) {
        return this.apq.by(i);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void yJ() {
        this.apq.yJ();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void zp() {
        n.xB().a(this);
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void onDestroy() {
        n.xB().onDisconnected();
    }
}
