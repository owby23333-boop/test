package com.liulishuo.filedownloader.e0;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.liulishuo.filedownloader.e0.a;
import com.liulishuo.filedownloader.h0.f;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: compiled from: RemitDatabase.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements com.liulishuo.filedownloader.e0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f17178c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Thread f17182g;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Integer> f17180e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicInteger f17181f = new AtomicInteger();
    private final b a = new b();
    private final d b = new d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f17179d = com.liulishuo.filedownloader.h0.e.a().b;

    /* JADX INFO: compiled from: RemitDatabase.java */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                if (c.this.f17182g != null) {
                    LockSupport.unpark(c.this.f17182g);
                    c.this.f17182g = null;
                }
                return false;
            }
            try {
                c.this.f17181f.set(i2);
                c.this.h(i2);
                c.this.f17180e.add(Integer.valueOf(i2));
                return false;
            } finally {
                c.this.f17181f.set(0);
                if (c.this.f17182g != null) {
                    LockSupport.unpark(c.this.f17182g);
                    c.this.f17182g = null;
                }
            }
        }
    }

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.l("RemitHandoverToDB"));
        handlerThread.start();
        this.f17178c = new Handler(handlerThread.getLooper(), new a());
    }

    private void f(int i2) {
        this.f17178c.removeMessages(i2);
        if (this.f17181f.get() != i2) {
            h(i2);
            return;
        }
        this.f17182g = Thread.currentThread();
        this.f17178c.sendEmptyMessage(0);
        LockSupport.park();
    }

    private boolean g(int i2) {
        return !this.f17180e.contains(Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "sync cache to db %d", Integer.valueOf(i2));
        }
        this.b.update(this.a.d(i2));
        List<com.liulishuo.filedownloader.model.a> listC = this.a.c(i2);
        this.b.e(i2);
        Iterator<com.liulishuo.filedownloader.model.a> it = listC.iterator();
        while (it.hasNext()) {
            this.b.a(it.next());
        }
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void clear() {
        this.a.clear();
        this.b.clear();
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public FileDownloadModel d(int i2) {
        return this.a.d(i2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void e(int i2) {
        this.a.e(i2);
        if (g(i2)) {
            return;
        }
        this.b.e(i2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void insert(FileDownloadModel fileDownloadModel) {
        this.a.insert(fileDownloadModel);
        if (g(fileDownloadModel.e())) {
            return;
        }
        this.b.insert(fileDownloadModel);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public boolean remove(int i2) {
        this.b.remove(i2);
        return this.a.remove(i2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void update(FileDownloadModel fileDownloadModel) {
        this.a.update(fileDownloadModel);
        if (g(fileDownloadModel.e())) {
            return;
        }
        this.b.update(fileDownloadModel);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void b(int i2) {
        this.f17178c.sendEmptyMessageDelayed(i2, this.f17179d);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public List<com.liulishuo.filedownloader.model.a> c(int i2) {
        return this.a.c(i2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void b(int i2, long j2) {
        this.a.b(i2, j2);
        if (g(i2)) {
            return;
        }
        this.b.b(i2, j2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void c(int i2, long j2) {
        this.a.c(i2, j2);
        if (g(i2)) {
            f(i2);
        }
        this.b.c(i2, j2);
        this.f17180e.remove(Integer.valueOf(i2));
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(com.liulishuo.filedownloader.model.a aVar) {
        this.a.a(aVar);
        if (g(aVar.c())) {
            return;
        }
        this.b.a(aVar);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, int i3, long j2) {
        this.a.a(i2, i3, j2);
        if (g(i2)) {
            return;
        }
        this.b.a(i2, i3, j2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, int i3) {
        this.a.a(i2, i3);
        if (g(i2)) {
            return;
        }
        this.b.a(i2, i3);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, String str, long j2, long j3, int i3) {
        this.a.a(i2, str, j2, j3, i3);
        if (g(i2)) {
            return;
        }
        this.b.a(i2, str, j2, j3, i3);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, long j2, String str, String str2) {
        this.a.a(i2, j2, str, str2);
        if (g(i2)) {
            return;
        }
        this.b.a(i2, j2, str, str2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2) {
        this.a.a(i2);
        if (g(i2)) {
            return;
        }
        this.b.a(i2);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, Throwable th) {
        this.a.a(i2, th);
        if (g(i2)) {
            return;
        }
        this.b.a(i2, th);
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, Throwable th, long j2) {
        this.a.a(i2, th, j2);
        if (g(i2)) {
            f(i2);
        }
        this.b.a(i2, th, j2);
        this.f17180e.remove(Integer.valueOf(i2));
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public void a(int i2, long j2) {
        this.a.a(i2, j2);
        if (g(i2)) {
            this.f17178c.removeMessages(i2);
            if (this.f17181f.get() == i2) {
                this.f17182g = Thread.currentThread();
                this.f17178c.sendEmptyMessage(0);
                LockSupport.park();
                this.b.a(i2, j2);
            }
        } else {
            this.b.a(i2, j2);
        }
        this.f17180e.remove(Integer.valueOf(i2));
    }

    @Override // com.liulishuo.filedownloader.e0.a
    public a.InterfaceC0484a a() {
        d dVar = this.b;
        b bVar = this.a;
        return dVar.a(bVar.a, bVar.b);
    }
}
