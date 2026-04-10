package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.liulishuo.filedownloader.f0.b;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.c;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: FDServiceSeparateHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends b.a implements c.b, j {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final RemoteCallbackList<com.liulishuo.filedownloader.f0.a> f17292s = new RemoteCallbackList<>();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final g f17293t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final WeakReference<FileDownloadService> f17294u;

    d(WeakReference<FileDownloadService> weakReference, g gVar) {
        this.f17294u = weakReference;
        this.f17293t = gVar;
        com.liulishuo.filedownloader.message.c.a().a(this);
    }

    private synchronized int b(MessageSnapshot messageSnapshot) {
        int iBeginBroadcast;
        RemoteCallbackList<com.liulishuo.filedownloader.f0.a> remoteCallbackList;
        iBeginBroadcast = this.f17292s.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            try {
                try {
                    ((com.liulishuo.filedownloader.f0.a) this.f17292s.getBroadcastItem(i2)).a(messageSnapshot);
                } catch (RemoteException e2) {
                    com.liulishuo.filedownloader.h0.d.a(this, e2, "callback error", new Object[0]);
                    remoteCallbackList = this.f17292s;
                    remoteCallbackList.finishBroadcast();
                    return iBeginBroadcast;
                }
            } catch (Throwable th) {
                this.f17292s.finishBroadcast();
                throw th;
            }
        }
        remoteCallbackList = this.f17292s;
        remoteCallbackList.finishBroadcast();
        return iBeginBroadcast;
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void a(com.liulishuo.filedownloader.f0.a aVar) throws RemoteException {
        this.f17292s.unregister(aVar);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean c(int i2) throws RemoteException {
        return this.f17293t.a(i2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public long e(int i2) throws RemoteException {
        return this.f17293t.b(i2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void f() throws RemoteException {
        this.f17293t.a();
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public byte getStatus(int i2) throws RemoteException {
        return this.f17293t.c(i2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean isIdle() throws RemoteException {
        return this.f17293t.b();
    }

    @Override // com.liulishuo.filedownloader.services.j
    public IBinder onBind(Intent intent) {
        return this;
    }

    @Override // com.liulishuo.filedownloader.services.j
    public void onStartCommand(Intent intent, int i2, int i3) {
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean pause(int i2) throws RemoteException {
        return this.f17293t.f(i2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void pauseAllTasks() throws RemoteException {
        this.f17293t.c();
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void startForeground(int i2, Notification notification) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f17294u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f17294u.get().startForeground(i2, notification);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void stopForeground(boolean z2) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f17294u;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f17294u.get().stopForeground(z2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) throws RemoteException {
        this.f17293t.a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public long a(int i2) throws RemoteException {
        return this.f17293t.d(i2);
    }

    @Override // com.liulishuo.filedownloader.message.c.b
    public void a(MessageSnapshot messageSnapshot) {
        b(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void b(com.liulishuo.filedownloader.f0.a aVar) throws RemoteException {
        this.f17292s.register(aVar);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean b(String str, String str2) throws RemoteException {
        return this.f17293t.a(str, str2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean b(int i2) throws RemoteException {
        return this.f17293t.g(i2);
    }
}
