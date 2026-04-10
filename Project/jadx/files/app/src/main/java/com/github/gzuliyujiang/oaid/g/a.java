package com.github.gzuliyujiang.oaid.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.g.m;
import repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: compiled from: AsusImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class a implements com.github.gzuliyujiang.oaid.d {
    private final Context a;

    /* JADX INFO: renamed from: com.github.gzuliyujiang.oaid.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsusImpl.java */
    class C0317a implements m.a {
        C0317a(a aVar) {
        }

        @Override // com.github.gzuliyujiang.oaid.g.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
            if (iDidAidlInterfaceAsInterface == null) {
                throw new OAIDException("IDidAidlInterface is null");
            }
            if (iDidAidlInterfaceAsInterface.isSupport()) {
                return iDidAidlInterfaceAsInterface.getOAID();
            }
            throw new OAIDException("IDidAidlInterface#isSupport return false");
        }
    }

    public a(Context context) {
        this.a = context;
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
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
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        m.a(this.a, intent, cVar, new C0317a(this));
    }
}
