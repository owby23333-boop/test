package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: LostServiceConnectedHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class z extends e implements v {
    private final ArrayList<a.b> b = new ArrayList<>();

    @Override // com.liulishuo.filedownloader.e
    public void a() {
        w wVarB = q.d().b();
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.b) {
            List<a.b> list = (List) this.b.clone();
            this.b.clear();
            ArrayList arrayList = new ArrayList(wVarB.a());
            for (a.b bVar : list) {
                int iD = bVar.d();
                if (wVarB.a(iD)) {
                    bVar.getOrigin().e().a();
                    if (!arrayList.contains(Integer.valueOf(iD))) {
                        arrayList.add(Integer.valueOf(iD));
                    }
                } else {
                    bVar.o();
                }
            }
            wVarB.a(arrayList);
        }
    }

    @Override // com.liulishuo.filedownloader.e
    public void b() {
        if (c() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            if (h.b().a() > 0) {
                com.liulishuo.filedownloader.h0.d.e(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.b().a()));
                return;
            }
            return;
        }
        w wVarB = q.d().b();
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.b().a()));
        }
        if (h.b().a() > 0) {
            synchronized (this.b) {
                h.b().a(this.b);
                Iterator<a.b> it = this.b.iterator();
                while (it.hasNext()) {
                    it.next().free();
                }
                wVarB.b();
            }
            try {
                q.d().bindService();
            } catch (IllegalStateException unused) {
                com.liulishuo.filedownloader.h0.d.e(this, "restart service failed, you may need to restart downloading manually when the app comes back to foreground", new Object[0]);
            }
        }
    }

    @Override // com.liulishuo.filedownloader.v
    public void c(a.b bVar) {
        if (this.b.isEmpty()) {
            return;
        }
        synchronized (this.b) {
            this.b.remove(bVar);
        }
    }

    @Override // com.liulishuo.filedownloader.v
    public boolean a(a.b bVar) {
        if (!q.d().c()) {
            synchronized (this.b) {
                if (!q.d().c()) {
                    if (com.liulishuo.filedownloader.h0.d.a) {
                        com.liulishuo.filedownloader.h0.d.a(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(bVar.getOrigin().getId()));
                    }
                    m.c().a(com.liulishuo.filedownloader.h0.c.a());
                    if (!this.b.contains(bVar)) {
                        bVar.free();
                        this.b.add(bVar);
                    }
                    return true;
                }
            }
        }
        c(bVar);
        return false;
    }

    @Override // com.liulishuo.filedownloader.v
    public boolean b(a.b bVar) {
        return !this.b.isEmpty() && this.b.contains(bVar);
    }
}
