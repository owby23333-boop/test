package com.kwai.filedownloader;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.message.MessageSnapshot;

/* JADX INFO: loaded from: classes3.dex */
final class p extends com.kwai.filedownloader.services.a<a, com.kwai.filedownloader.b.b> {

    protected static class a extends a.AbstractBinderC0464a {
        protected a() {
        }

        @Override // com.kwai.filedownloader.b.a
        public final void q(MessageSnapshot messageSnapshot) {
            com.kwai.filedownloader.message.e.Ij().s(messageSnapshot);
        }
    }

    p(Class<?> cls) {
        super(cls);
    }

    private static a GZ() {
        return new a();
    }

    private static com.kwai.filedownloader.b.b a(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    private static void a(com.kwai.filedownloader.b.b bVar, a aVar) {
        bVar.a(aVar);
    }

    @Override // com.kwai.filedownloader.services.a
    public final /* synthetic */ Binder Ha() {
        return GZ();
    }

    @Override // com.kwai.filedownloader.services.a
    public final /* bridge */ /* synthetic */ void a(IInterface iInterface, Binder binder) {
        a((com.kwai.filedownloader.b.b) iInterface, (a) binder);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, com.kwai.filedownloader.c.b bVar, boolean z4) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.l(str, str2, z2);
        }
        try {
            It().b(str, str2, z2, i2, i3, i4, z3, bVar, z4);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.kwai.filedownloader.services.a
    public final /* synthetic */ IInterface b(IBinder iBinder) {
        return a(iBinder);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cw(int i2) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.cw(i2);
        }
        try {
            return It().cw(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.kwai.filedownloader.u
    public final byte cx(int i2) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.cx(i2);
        }
        try {
            return It().cx(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cy(int i2) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.cy(i2);
        }
        try {
            return It().cy(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
