package com.github.gzuliyujiang.oaid.g;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.github.gzuliyujiang.oaid.OAIDException;

/* JADX INFO: compiled from: OAIDService.java */
/* JADX INFO: loaded from: classes2.dex */
class m implements ServiceConnection {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Context f14891s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final com.github.gzuliyujiang.oaid.c f14892t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final a f14893u;

    /* JADX INFO: compiled from: OAIDService.java */
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws OAIDException, RemoteException;
    }

    private m(Context context, com.github.gzuliyujiang.oaid.c cVar, a aVar) {
        if (context instanceof Application) {
            this.f14891s = context;
        } else {
            this.f14891s = context.getApplicationContext();
        }
        this.f14892t = cVar;
        this.f14893u = aVar;
    }

    public static void a(Context context, Intent intent, com.github.gzuliyujiang.oaid.c cVar, a aVar) {
        new m(context, cVar, aVar).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.github.gzuliyujiang.oaid.e.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String strA = this.f14893u.a(iBinder);
                    if (strA == null || strA.length() == 0) {
                        throw new OAIDException("OAID/AAID acquire failed");
                    }
                    com.github.gzuliyujiang.oaid.e.a("OAID/AAID acquire success: " + strA);
                    this.f14892t.a(strA);
                    this.f14891s.unbindService(this);
                    com.github.gzuliyujiang.oaid.e.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e2) {
                    com.github.gzuliyujiang.oaid.e.a(e2);
                    this.f14892t.a(e2);
                    this.f14891s.unbindService(this);
                    com.github.gzuliyujiang.oaid.e.a("Service has been unbound: " + componentName.getClassName());
                }
            } catch (Exception e3) {
                com.github.gzuliyujiang.oaid.e.a(e3);
            }
        } catch (Throwable th) {
            try {
                this.f14891s.unbindService(this);
                com.github.gzuliyujiang.oaid.e.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e4) {
                com.github.gzuliyujiang.oaid.e.a(e4);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.github.gzuliyujiang.oaid.e.a("Service has been disconnected: " + componentName.getClassName());
    }

    private void a(Intent intent) {
        try {
            if (!this.f14891s.bindService(intent, this, 1)) {
                throw new OAIDException("Service binding failed");
            }
            com.github.gzuliyujiang.oaid.e.a("Service has been bound: " + intent);
        } catch (Exception e2) {
            this.f14892t.a(e2);
        }
    }
}
