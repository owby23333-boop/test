package com.liulishuo.filedownloader;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.FileDownloadService;
import com.liulishuo.filedownloader.services.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FileDownloadServiceSharedTransmit.java */
/* JADX INFO: loaded from: classes3.dex */
class n implements u, e.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final Class<?> f17271v = FileDownloadService.SharedMainProcessService.class;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f17272s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final ArrayList<Runnable> f17273t = new ArrayList<>();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.liulishuo.filedownloader.services.e f17274u;

    n() {
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) {
        if (!isConnected()) {
            return com.liulishuo.filedownloader.h0.a.a(str, str2, z2);
        }
        this.f17274u.a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
        return true;
    }

    @Override // com.liulishuo.filedownloader.u
    public byte getStatus(int i2) {
        return !isConnected() ? com.liulishuo.filedownloader.h0.a.a(i2) : this.f17274u.getStatus(i2);
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean isConnected() {
        return this.f17274u != null;
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean pause(int i2) {
        return !isConnected() ? com.liulishuo.filedownloader.h0.a.b(i2) : this.f17274u.pause(i2);
    }

    @Override // com.liulishuo.filedownloader.u
    public void stopForeground(boolean z2) {
        if (!isConnected()) {
            com.liulishuo.filedownloader.h0.a.a(z2);
        } else {
            this.f17274u.stopForeground(z2);
            this.f17272s = false;
        }
    }

    @Override // com.liulishuo.filedownloader.u
    public void a(Context context) {
        a(context, null);
    }

    @Override // com.liulishuo.filedownloader.u
    public void a(Context context, Runnable runnable) {
        if (runnable != null && !this.f17273t.contains(runnable)) {
            this.f17273t.add(runnable);
        }
        Intent intent = new Intent(context, f17271v);
        this.f17272s = com.liulishuo.filedownloader.h0.f.e(context);
        intent.putExtra("is_foreground", this.f17272s);
        if (this.f17272s) {
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
    }

    @Override // com.liulishuo.filedownloader.u
    public boolean a() {
        return this.f17272s;
    }

    @Override // com.liulishuo.filedownloader.services.e.a
    public void a(com.liulishuo.filedownloader.services.e eVar) {
        this.f17274u = eVar;
        List list = (List) this.f17273t.clone();
        this.f17273t.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        f.a().a(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, f17271v));
    }
}
