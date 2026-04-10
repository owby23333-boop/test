package com.liulishuo.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.liulishuo.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: BaseFileServiceUIGuard.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements u, ServiceConnection {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final CALLBACK f17281s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private volatile INTERFACE f17282t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Class<?> f17283u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected boolean f17284v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final List<Context> f17285w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final ArrayList<Runnable> f17286x;

    protected a(Class<?> cls) {
        new HashMap();
        this.f17285w = new ArrayList();
        this.f17286x = new ArrayList<>();
        this.f17283u = cls;
        this.f17281s = (CALLBACK) b();
    }

    private void a(boolean z2) {
        if (!z2 && this.f17282t != null) {
            try {
                b(this.f17282t, this.f17281s);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "release connect resources %s", this.f17282t);
        }
        this.f17282t = null;
        com.liulishuo.filedownloader.f.a().a(new DownloadServiceConnectChangedEvent(z2 ? DownloadServiceConnectChangedEvent.ConnectStatus.lost : DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, this.f17283u));
    }

    protected abstract INTERFACE a(IBinder iBinder);

    protected abstract void a(INTERFACE r1, CALLBACK callback) throws RemoteException;

    protected abstract CALLBACK b();

    protected abstract void b(INTERFACE r1, CALLBACK callback) throws RemoteException;

    protected INTERFACE c() {
        return this.f17282t;
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean isConnected() {
        return c() != null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f17282t = (INTERFACE) a(iBinder);
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "onServiceConnected %s %s", componentName, this.f17282t);
        }
        try {
            a(this.f17282t, this.f17281s);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        List list = (List) this.f17286x.clone();
        this.f17286x.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        com.liulishuo.filedownloader.f.a().a(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.f17283u));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "onServiceDisconnected %s %s", componentName, this.f17282t);
        }
        a(true);
    }

    @Override // com.liulishuo.filedownloader.u
    public void a(Context context) {
        a(context, (Runnable) null);
    }

    @Override // com.liulishuo.filedownloader.u
    public void a(Context context, Runnable runnable) {
        if (!com.liulishuo.filedownloader.h0.f.c(context)) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.f17283u);
            if (runnable != null && !this.f17286x.contains(runnable)) {
                this.f17286x.add(runnable);
            }
            if (!this.f17285w.contains(context)) {
                this.f17285w.add(context);
            }
            this.f17284v = com.liulishuo.filedownloader.h0.f.e(context);
            intent.putExtra("is_foreground", this.f17284v);
            context.bindService(intent, this, 1);
            if (this.f17284v) {
                if (com.liulishuo.filedownloader.h0.d.a) {
                    com.liulishuo.filedownloader.h0.d.a(this, "start foreground service", new Object[0]);
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                    return;
                }
                return;
            }
            context.startService(intent);
            return;
        }
        throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean a() {
        return this.f17284v;
    }
}
