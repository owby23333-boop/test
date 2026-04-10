package com.github.gzuliyujiang.oaid.g;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.g.m;
import repeackage.com.zui.deviceidservice.IDeviceidInterface;

/* JADX INFO: compiled from: LenovoImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class h implements com.github.gzuliyujiang.oaid.d {
    private final Context a;

    /* JADX INFO: compiled from: LenovoImpl.java */
    class a implements m.a {
        a(h hVar) {
        }

        @Override // com.github.gzuliyujiang.oaid.g.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (iDeviceidInterfaceAsInterface == null) {
                throw new OAIDException("IDeviceidInterface is null");
            }
            if (iDeviceidInterfaceAsInterface.isSupport()) {
                return iDeviceidInterfaceAsInterface.getOAID();
            }
            throw new OAIDException("IDeviceidInterface#isSupport return false");
        }
    }

    public h(Context context) {
        this.a = context;
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
            return false;
        }
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public void a(com.github.gzuliyujiang.oaid.c cVar) {
        if (this.a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        m.a(this.a, intent, cVar, new a(this));
    }
}
