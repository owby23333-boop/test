package com.ss.android.socialbase.downloader.impls;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.CSJIndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.kb;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class v extends com.ss.android.socialbase.downloader.downloader.z implements ServiceConnection {
    private static final String gc = "v";
    private com.ss.android.socialbase.downloader.downloader.ls e;
    private int gz = -1;
    private com.ss.android.socialbase.downloader.downloader.kb m;

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.ss.android.socialbase.downloader.m.z.g(gc, "bindService");
            Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
            if (com.ss.android.socialbase.downloader.pf.m.z()) {
                intent.putExtra("fix_downloader_db_sigbus", com.ss.android.socialbase.downloader.i.z.dl().z("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.ss.android.socialbase.downloader.m.z.g(gc, "stopService");
        this.g = false;
        Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z, com.ss.android.socialbase.downloader.downloader.p
    public IBinder z(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.bytedance.sdk.component.utils.wp.g(gc, "downloader process sync database on main process!");
            com.ss.android.socialbase.downloader.i.z.z("fix_sigbus_downloader_db", true);
        }
        com.ss.android.socialbase.downloader.m.z.g(gc, "onBind IndependentDownloadBinder");
        return new i();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z, com.ss.android.socialbase.downloader.downloader.p
    public void g(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.m.z.g(gc, "tryDownload aidlService == null:" + (this.m == null));
        if (this.m == null) {
            z(aVar);
            startService(com.ss.android.socialbase.downloader.downloader.dl.xl(), this);
            return;
        }
        e();
        try {
            this.m.z(com.ss.android.socialbase.downloader.pf.e.z(aVar));
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    private void e() {
        SparseArray<List<com.ss.android.socialbase.downloader.e.a>> sparseArrayClone;
        try {
            synchronized (this.z) {
                sparseArrayClone = this.z.clone();
                this.z.clear();
            }
            if (sparseArrayClone == null || sparseArrayClone.size() <= 0 || com.ss.android.socialbase.downloader.downloader.dl.h() == null) {
                return;
            }
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<com.ss.android.socialbase.downloader.e.a> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    Iterator<com.ss.android.socialbase.downloader.e.a> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.m.z(com.ss.android.socialbase.downloader.pf.e.z(it.next()));
                        } catch (RemoteException e) {
                            com.bytedance.sdk.component.utils.wp.z(e);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.m.z.g(gc, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z, com.ss.android.socialbase.downloader.downloader.p
    public void dl(com.ss.android.socialbase.downloader.e.a aVar) {
        if (aVar == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.a.z().z(aVar.p(), true);
        z zVarH = com.ss.android.socialbase.downloader.downloader.dl.h();
        if (zVarH != null) {
            zVarH.z(aVar);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = gc;
        com.ss.android.socialbase.downloader.m.z.g(str, "onServiceConnected ");
        this.m = kb.z.z(iBinder);
        com.ss.android.socialbase.downloader.downloader.ls lsVar = this.e;
        if (lsVar != null) {
            lsVar.z(iBinder);
        }
        com.ss.android.socialbase.downloader.m.z.g(str, "onServiceConnected aidlService!=null" + (this.m != null) + " pendingTasks.size:" + this.z.size());
        if (this.m != null) {
            com.ss.android.socialbase.downloader.downloader.a.z().g();
            this.g = true;
            this.f2063a = false;
            int i = this.gz;
            if (i != -1) {
                try {
                    this.m.wp(i);
                } catch (RemoteException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
            if (this.m != null) {
                e();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.ss.android.socialbase.downloader.m.z.g(gc, "onServiceDisconnected ");
        this.m = null;
        this.g = false;
        com.ss.android.socialbase.downloader.downloader.ls lsVar = this.e;
        if (lsVar != null) {
            lsVar.gz();
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.m = null;
        com.ss.android.socialbase.downloader.downloader.ls lsVar = this.e;
        if (lsVar != null) {
            lsVar.gz();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z, com.ss.android.socialbase.downloader.downloader.p
    public void z(com.ss.android.socialbase.downloader.downloader.ls lsVar) {
        this.e = lsVar;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z, com.ss.android.socialbase.downloader.downloader.p
    public void z(int i) {
        com.ss.android.socialbase.downloader.downloader.kb kbVar = this.m;
        if (kbVar == null) {
            this.gz = i;
            return;
        }
        try {
            kbVar.wp(i);
        } catch (RemoteException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z, com.ss.android.socialbase.downloader.downloader.p
    public void startService() {
        if (this.m == null) {
            startService(com.ss.android.socialbase.downloader.downloader.dl.xl(), this);
        }
    }
}
