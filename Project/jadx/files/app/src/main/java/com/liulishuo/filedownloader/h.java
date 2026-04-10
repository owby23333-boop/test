package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FileDownloadList.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    private final ArrayList<a.b> a;

    /* JADX INFO: compiled from: FileDownloadList.java */
    private static final class b {
        private static final h a = new h();
    }

    public static h b() {
        return b.a;
    }

    int a() {
        return this.a.size();
    }

    boolean c(a.b bVar) {
        return this.a.isEmpty() || !this.a.contains(bVar);
    }

    private h() {
        this.a = new ArrayList<>();
    }

    int a(int i2) {
        int i3;
        synchronized (this.a) {
            Iterator<a.b> it = this.a.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().a(i2)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    List<a.b> b(int i2) {
        byte bC;
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            for (a.b bVar : this.a) {
                if (bVar.a(i2) && !bVar.isOver() && (bC = bVar.getOrigin().c()) != 0 && bC != 10) {
                    arrayList.add(bVar);
                }
            }
        }
        return arrayList;
    }

    void a(List<a.b> list) {
        synchronized (this.a) {
            for (a.b bVar : this.a) {
                if (!list.contains(bVar)) {
                    list.add(bVar);
                }
            }
            this.a.clear();
        }
    }

    void b(a.b bVar) {
        if (bVar.t()) {
            return;
        }
        synchronized (this.a) {
            if (this.a.contains(bVar)) {
                com.liulishuo.filedownloader.h0.d.e(this, "already has %s", bVar);
            } else {
                bVar.n();
                this.a.add(bVar);
                if (com.liulishuo.filedownloader.h0.d.a) {
                    com.liulishuo.filedownloader.h0.d.d(this, "add list in all %s %d %d", bVar, Byte.valueOf(bVar.getOrigin().c()), Integer.valueOf(this.a.size()));
                }
            }
        }
    }

    public boolean a(a.b bVar, MessageSnapshot messageSnapshot) {
        boolean zRemove;
        byte bO = messageSnapshot.o();
        synchronized (this.a) {
            zRemove = this.a.remove(bVar);
            if (zRemove && this.a.size() == 0 && m.c().a()) {
                q.d().a(true);
            }
        }
        if (com.liulishuo.filedownloader.h0.d.a && this.a.size() == 0) {
            com.liulishuo.filedownloader.h0.d.d(this, "remove %s left %d %d", bVar, Byte.valueOf(bO), Integer.valueOf(this.a.size()));
        }
        if (zRemove) {
            t tVarG = bVar.getMessageHandler().g();
            if (bO == -4) {
                tVarG.h(messageSnapshot);
            } else if (bO == -3) {
                tVarG.i(com.liulishuo.filedownloader.message.d.a(messageSnapshot));
            } else if (bO == -2) {
                tVarG.f(messageSnapshot);
            } else if (bO == -1) {
                tVarG.b(messageSnapshot);
            }
        } else {
            com.liulishuo.filedownloader.h0.d.b(this, "remove error, not exist: %s %d", bVar, Byte.valueOf(bO));
        }
        return zRemove;
    }

    void a(a.b bVar) {
        if (!bVar.getOrigin().f()) {
            bVar.s();
        }
        if (bVar.getMessageHandler().g().b()) {
            b(bVar);
        }
    }
}
