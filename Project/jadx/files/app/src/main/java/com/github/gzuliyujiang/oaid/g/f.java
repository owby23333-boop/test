package com.github.gzuliyujiang.oaid.g;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;
import com.github.gzuliyujiang.oaid.g.m;
import n0.a.a.a.a.a.a.a.a;

/* JADX INFO: compiled from: GmsImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class f implements com.github.gzuliyujiang.oaid.d {
    private final Context a;

    /* JADX INFO: compiled from: GmsImpl.java */
    class a implements m.a {
        a(f fVar) {
        }

        @Override // com.github.gzuliyujiang.oaid.g.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            n0.a.a.a.a.a.a.a.a aVarA = a.AbstractBinderC0586a.a(iBinder);
            if (aVarA.b(true)) {
                com.github.gzuliyujiang.oaid.e.a("User has disabled advertising identifier");
            }
            return aVarA.getId();
        }
    }

    public f(Context context) {
        this.a = context;
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        Context context = this.a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
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
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        m.a(this.a, intent, cVar, new a(this));
    }
}
