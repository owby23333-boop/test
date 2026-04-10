package com.liulishuo.filedownloader;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import java.io.File;

/* JADX INFO: compiled from: PauseAllMarker.java */
/* JADX INFO: loaded from: classes3.dex */
public class b0 implements Handler.Callback {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static File f17074v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final Long f17075w = 1000L;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private HandlerThread f17076s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Handler f17077t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final com.liulishuo.filedownloader.f0.b f17078u;

    public b0(com.liulishuo.filedownloader.f0.b bVar) {
        this.f17078u = bVar;
    }

    public static void c() {
        File fileE = e();
        if (fileE.exists()) {
            com.liulishuo.filedownloader.h0.d.a(b0.class, "delete marker file " + fileE.delete(), new Object[0]);
        }
    }

    private static boolean d() {
        return e().exists();
    }

    private static File e() {
        if (f17074v == null) {
            f17074v = new File(com.liulishuo.filedownloader.h0.c.a().getCacheDir() + File.separator + ".filedownloader_pause_all_marker.b");
        }
        return f17074v;
    }

    public void a() {
        this.f17076s = new HandlerThread("PauseAllChecker");
        this.f17076s.start();
        this.f17077t = new Handler(this.f17076s.getLooper(), this);
        this.f17077t.sendEmptyMessageDelayed(0, f17075w.longValue());
    }

    public void b() {
        this.f17077t.removeMessages(0);
        this.f17076s.quit();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            if (d()) {
                try {
                    this.f17078u.pauseAllTasks();
                } catch (RemoteException e2) {
                    com.liulishuo.filedownloader.h0.d.a(this, e2, "pause all failed", new Object[0]);
                }
            }
            this.f17077t.sendEmptyMessageDelayed(0, f17075w.longValue());
            return true;
        } finally {
            c();
        }
    }
}
