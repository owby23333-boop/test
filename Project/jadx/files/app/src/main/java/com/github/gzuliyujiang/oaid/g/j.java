package com.github.gzuliyujiang.oaid.g;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.g.m;
import repeackage.com.bun.lib.MsaIdInterface;

/* JADX INFO: compiled from: MsaImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class j implements com.github.gzuliyujiang.oaid.d {
    private final Context a;

    /* JADX INFO: compiled from: MsaImpl.java */
    class a implements m.a {
        a(j jVar) {
        }

        @Override // com.github.gzuliyujiang.oaid.g.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (msaIdInterfaceAsInterface == null) {
                throw new OAIDException("MsaIdInterface is null");
            }
            if (msaIdInterfaceAsInterface.isSupported()) {
                return msaIdInterfaceAsInterface.getOAID();
            }
            throw new OAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public j(Context context) {
        this.a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.a.startService(intent);
            } else {
                this.a.startForegroundService(intent);
            }
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
        }
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
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
        b();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
        m.a(this.a, intent, cVar, new a(this));
    }
}
