package com.liulishuo.filedownloader;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: FileDownloadMessageStation.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Executor f17217e = com.liulishuo.filedownloader.h0.b.a(5, "BlockCompleted");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static int f17218f = 10;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static int f17219g = 5;
    private final Handler a;
    private final LinkedBlockingQueue<t> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f17220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ArrayList<t> f17221d;

    /* JADX INFO: compiled from: FileDownloadMessageStation.java */
    static class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ t f17222s;

        a(t tVar) {
            this.f17222s = tVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17222s.d();
        }
    }

    /* JADX INFO: compiled from: FileDownloadMessageStation.java */
    private static final class b {
        private static final j a = new j(null);
    }

    /* JADX INFO: compiled from: FileDownloadMessageStation.java */
    private static class c implements Handler.Callback {
        private c() {
        }

        private void a(ArrayList<t> arrayList) {
            for (t tVar : arrayList) {
                if (!j.e(tVar)) {
                    tVar.d();
                }
            }
            arrayList.clear();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                ((t) message.obj).d();
            } else if (i2 == 2) {
                a((ArrayList) message.obj);
                j.a().c();
            }
            return true;
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* synthetic */ j(a aVar) {
        this();
    }

    private void c(t tVar) {
        synchronized (this.f17220c) {
            this.b.offer(tVar);
        }
        c();
    }

    private void d(t tVar) {
        Handler handler = this.a;
        handler.sendMessage(handler.obtainMessage(1, tVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(t tVar) {
        if (!tVar.c()) {
            return false;
        }
        f17217e.execute(new a(tVar));
        return true;
    }

    private j() {
        this.f17220c = new Object();
        this.f17221d = new ArrayList<>();
        this.a = new Handler(Looper.getMainLooper(), new c(null));
        this.b = new LinkedBlockingQueue<>();
    }

    public static j a() {
        return b.a;
    }

    public static boolean b() {
        return f17218f > 0;
    }

    void a(t tVar) {
        a(tVar, false);
    }

    void a(t tVar, boolean z2) {
        if (tVar.a()) {
            tVar.d();
            return;
        }
        if (e(tVar)) {
            return;
        }
        if (!b() && !this.b.isEmpty()) {
            synchronized (this.f17220c) {
                if (!this.b.isEmpty()) {
                    Iterator<t> it = this.b.iterator();
                    while (it.hasNext()) {
                        d(it.next());
                    }
                }
                this.b.clear();
            }
        }
        if (b() && !z2) {
            c(tVar);
        } else {
            d(tVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i2;
        synchronized (this.f17220c) {
            if (this.f17221d.isEmpty()) {
                if (this.b.isEmpty()) {
                    return;
                }
                if (!b()) {
                    this.b.drainTo(this.f17221d);
                    i2 = 0;
                } else {
                    i2 = f17218f;
                    int iMin = Math.min(this.b.size(), f17219g);
                    for (int i3 = 0; i3 < iMin; i3++) {
                        this.f17221d.add(this.b.remove());
                    }
                }
                Handler handler = this.a;
                handler.sendMessageDelayed(handler.obtainMessage(2, this.f17221d), i2);
            }
        }
    }
}
