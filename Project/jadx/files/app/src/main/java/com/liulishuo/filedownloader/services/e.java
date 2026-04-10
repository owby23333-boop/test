package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.liulishuo.filedownloader.f0.b;
import com.liulishuo.filedownloader.m;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: FDServiceSharedHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends b.a implements j {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final g f17295s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final WeakReference<FileDownloadService> f17296t;

    /* JADX INFO: compiled from: FDServiceSharedHandler.java */
    public interface a {
        void a(e eVar);
    }

    e(WeakReference<FileDownloadService> weakReference, g gVar) {
        this.f17296t = weakReference;
        this.f17295s = gVar;
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void a(com.liulishuo.filedownloader.f0.a aVar) {
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) {
        this.f17295s.a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void b(com.liulishuo.filedownloader.f0.a aVar) {
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean b(String str, String str2) {
        return this.f17295s.a(str, str2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean c(int i2) {
        return this.f17295s.a(i2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public long e(int i2) {
        return this.f17295s.b(i2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void f() {
        this.f17295s.a();
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public byte getStatus(int i2) {
        return this.f17295s.c(i2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean isIdle() {
        return this.f17295s.b();
    }

    @Override // com.liulishuo.filedownloader.services.j
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.liulishuo.filedownloader.services.j
    public void onStartCommand(Intent intent, int i2, int i3) {
        m.b().a(this);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean pause(int i2) {
        return this.f17295s.f(i2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void pauseAllTasks() {
        this.f17295s.c();
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void startForeground(int i2, Notification notification) {
        WeakReference<FileDownloadService> weakReference = this.f17296t;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f17296t.get().startForeground(i2, notification);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public void stopForeground(boolean z2) {
        WeakReference<FileDownloadService> weakReference = this.f17296t;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f17296t.get().stopForeground(z2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public long a(int i2) {
        return this.f17295s.d(i2);
    }

    @Override // com.liulishuo.filedownloader.f0.b
    public boolean b(int i2) {
        return this.f17295s.g(i2);
    }
}
