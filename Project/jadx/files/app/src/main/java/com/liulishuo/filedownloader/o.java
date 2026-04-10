package com.liulishuo.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.liulishuo.filedownloader.f0.a;
import com.liulishuo.filedownloader.f0.b;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.FileDownloadService;

/* JADX INFO: compiled from: FileDownloadServiceUIGuard.java */
/* JADX INFO: loaded from: classes3.dex */
class o extends com.liulishuo.filedownloader.services.a<a, com.liulishuo.filedownloader.f0.b> {

    /* JADX INFO: compiled from: FileDownloadServiceUIGuard.java */
    protected static class a extends a.AbstractBinderC0487a {
        protected a() {
        }

        @Override // com.liulishuo.filedownloader.f0.a
        public void a(MessageSnapshot messageSnapshot) throws RemoteException {
            com.liulishuo.filedownloader.message.c.a().a(messageSnapshot);
        }
    }

    o() {
        super(FileDownloadService.SeparateProcessService.class);
    }

    @Override // com.liulishuo.filedownloader.u
    public byte getStatus(int i2) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.h0.a.a(i2);
        }
        try {
            return c().getStatus(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean pause(int i2) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.h0.a.b(i2);
        }
        try {
            return c().pause(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.liulishuo.filedownloader.u
    public void stopForeground(boolean z2) {
        if (!isConnected()) {
            com.liulishuo.filedownloader.h0.a.a(z2);
            return;
        }
        try {
            try {
                c().stopForeground(z2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        } finally {
            this.f17284v = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.liulishuo.filedownloader.services.a
    public com.liulishuo.filedownloader.f0.b a(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.liulishuo.filedownloader.services.a
    public a b() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.liulishuo.filedownloader.services.a
    public void a(com.liulishuo.filedownloader.f0.b bVar, a aVar) throws RemoteException {
        bVar.b(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.liulishuo.filedownloader.services.a
    public void b(com.liulishuo.filedownloader.f0.b bVar, a aVar) throws RemoteException {
        bVar.a(aVar);
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.h0.a.a(str, str2, z2);
        }
        try {
            c().a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
