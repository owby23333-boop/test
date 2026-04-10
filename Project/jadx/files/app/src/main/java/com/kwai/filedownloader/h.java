package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private final ArrayList<a.InterfaceC0461a> aEj;

    static final class a {
        private static final h aEk = new h(0);
    }

    private h() {
        this.aEj = new ArrayList<>();
    }

    /* synthetic */ h(byte b) {
        this();
    }

    public static h GK() {
        return a.aEk;
    }

    final void G(List<a.InterfaceC0461a> list) {
        synchronized (this.aEj) {
            for (a.InterfaceC0461a interfaceC0461a : this.aEj) {
                if (!list.contains(interfaceC0461a)) {
                    list.add(interfaceC0461a);
                }
            }
            this.aEj.clear();
        }
    }

    final boolean a(a.InterfaceC0461a interfaceC0461a) {
        return this.aEj.isEmpty() || !this.aEj.contains(interfaceC0461a);
    }

    public final boolean a(a.InterfaceC0461a interfaceC0461a, MessageSnapshot messageSnapshot) {
        boolean zRemove;
        byte bGe = messageSnapshot.Ge();
        synchronized (this.aEj) {
            zRemove = this.aEj.remove(interfaceC0461a);
        }
        if (com.kwai.filedownloader.e.d.aHT && this.aEj.size() == 0) {
            com.kwai.filedownloader.e.d.i(this, "remove %s left %d %d", interfaceC0461a, Byte.valueOf(bGe), Integer.valueOf(this.aEj.size()));
        }
        if (zRemove) {
            t tVarGC = interfaceC0461a.Gn().GC();
            if (bGe == -4) {
                tVarGC.l(messageSnapshot);
            } else if (bGe == -3) {
                tVarGC.j(com.kwai.filedownloader.message.f.t(messageSnapshot));
            } else if (bGe == -2) {
                tVarGC.n(messageSnapshot);
            } else if (bGe == -1) {
                tVarGC.m(messageSnapshot);
            }
        } else {
            com.kwai.filedownloader.e.d.e(this, "remove error, not exist: %s %d", interfaceC0461a, Byte.valueOf(bGe));
        }
        return zRemove;
    }

    final void b(a.InterfaceC0461a interfaceC0461a) {
        if (!interfaceC0461a.Gm().FX()) {
            interfaceC0461a.Gp();
        }
        if (interfaceC0461a.Gn().GC().GP()) {
            c(interfaceC0461a);
        }
    }

    final void c(a.InterfaceC0461a interfaceC0461a) {
        if (interfaceC0461a.Gq()) {
            return;
        }
        synchronized (this.aEj) {
            if (this.aEj.contains(interfaceC0461a)) {
                com.kwai.filedownloader.e.d.h(this, "already has %s", interfaceC0461a);
            } else {
                interfaceC0461a.Gr();
                this.aEj.add(interfaceC0461a);
                if (com.kwai.filedownloader.e.d.aHT) {
                    com.kwai.filedownloader.e.d.i(this, "add list in all %s %d %d", interfaceC0461a, Byte.valueOf(interfaceC0461a.Gm().Ge()), Integer.valueOf(this.aEj.size()));
                }
            }
        }
    }

    final int cs(int i2) {
        int i3;
        synchronized (this.aEj) {
            Iterator<a.InterfaceC0461a> it = this.aEj.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().cr(i2)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    final List<a.InterfaceC0461a> ct(int i2) {
        byte bGe;
        ArrayList arrayList = new ArrayList();
        synchronized (this.aEj) {
            for (a.InterfaceC0461a interfaceC0461a : this.aEj) {
                if (interfaceC0461a.cr(i2) && !interfaceC0461a.isOver() && (bGe = interfaceC0461a.Gm().Ge()) != 0 && bGe != 10) {
                    arrayList.add(interfaceC0461a);
                }
            }
        }
        return arrayList;
    }

    final List<a.InterfaceC0461a> cu(int i2) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aEj) {
            for (a.InterfaceC0461a interfaceC0461a : this.aEj) {
                if (interfaceC0461a.cr(i2) && !interfaceC0461a.isOver()) {
                    arrayList.add(interfaceC0461a);
                }
            }
        }
        return arrayList;
    }

    final int size() {
        return this.aEj.size();
    }
}
