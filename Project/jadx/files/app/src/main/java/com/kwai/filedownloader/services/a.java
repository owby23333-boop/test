package com.kwai.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    private final Class<?> aGO;
    private volatile INTERFACE aHt;
    private final HashMap<String, Object> aHu = new HashMap<>();
    private final List<Context> aHv = new ArrayList();
    private final ArrayList<Runnable> aEC = new ArrayList<>();
    private final CALLBACK aHs = (CALLBACK) Ha();

    protected a(Class<?> cls) {
        this.aGO = cls;
    }

    private void a(Context context, Runnable runnable) {
        if (com.kwai.filedownloader.e.f.dz(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.aGO);
        if (!this.aHv.contains(context)) {
            this.aHv.add(context);
        }
        context.bindService(intent, this, 1);
        context.startService(intent);
    }

    private void bP(boolean z2) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "release connect resources %s", this.aHt);
        }
        this.aHt = null;
        com.kwai.filedownloader.f.GI().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.aGO));
    }

    protected abstract CALLBACK Ha();

    protected final INTERFACE It() {
        return this.aHt;
    }

    protected abstract void a(INTERFACE r1, CALLBACK callback);

    protected abstract INTERFACE b(IBinder iBinder);

    @Override // com.kwai.filedownloader.u
    public final void dw(Context context) {
        a(context, (Runnable) null);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        return It() != null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.aHt = (INTERFACE) b(iBinder);
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "onServiceConnected %s %s", componentName, this.aHt);
        }
        try {
            a(this.aHt, this.aHs);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        List list = (List) this.aEC.clone();
        this.aEC.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        com.kwai.filedownloader.f.GI().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.aGO));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "onServiceDisconnected %s %s", componentName, this.aHt);
        }
        bP(true);
    }
}
