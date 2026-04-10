package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    private final ArrayList<a.InterfaceC0370a> alT;

    /* synthetic */ h(byte b) {
        this();
    }

    static final class a {
        private static final h alU = new h(0);
    }

    public static h xp() {
        return a.alU;
    }

    private h() {
        this.alT = new ArrayList<>();
    }

    final int size() {
        return this.alT.size();
    }

    final int bs(int i) {
        int i2;
        synchronized (this.alT) {
            Iterator<a.InterfaceC0370a> it = this.alT.iterator();
            i2 = 0;
            while (it.hasNext()) {
                if (it.next().br(i)) {
                    i2++;
                }
            }
        }
        return i2;
    }

    final List<a.InterfaceC0370a> bt(int i) {
        byte bWJ;
        ArrayList arrayList = new ArrayList();
        synchronized (this.alT) {
            for (a.InterfaceC0370a interfaceC0370a : this.alT) {
                if (interfaceC0370a.br(i) && !interfaceC0370a.isOver() && (bWJ = interfaceC0370a.wR().wJ()) != 0 && bWJ != 10) {
                    arrayList.add(interfaceC0370a);
                }
            }
        }
        return arrayList;
    }

    final List<a.InterfaceC0370a> bu(int i) {
        ArrayList arrayList = new ArrayList();
        synchronized (this.alT) {
            for (a.InterfaceC0370a interfaceC0370a : this.alT) {
                if (interfaceC0370a.br(i) && !interfaceC0370a.isOver()) {
                    arrayList.add(interfaceC0370a);
                }
            }
        }
        return arrayList;
    }

    final boolean a(a.InterfaceC0370a interfaceC0370a) {
        return this.alT.isEmpty() || !this.alT.contains(interfaceC0370a);
    }

    final void p(List<a.InterfaceC0370a> list) {
        synchronized (this.alT) {
            for (a.InterfaceC0370a interfaceC0370a : this.alT) {
                if (!list.contains(interfaceC0370a)) {
                    list.add(interfaceC0370a);
                }
            }
            this.alT.clear();
        }
    }

    public final boolean a(a.InterfaceC0370a interfaceC0370a, MessageSnapshot messageSnapshot) {
        boolean zRemove;
        byte bWJ = messageSnapshot.wJ();
        synchronized (this.alT) {
            zRemove = this.alT.remove(interfaceC0370a);
        }
        if (com.kwad.framework.filedownloader.f.d.apD && this.alT.size() == 0) {
            com.kwad.framework.filedownloader.f.d.e(this, "remove %s left %d %d", interfaceC0370a, Byte.valueOf(bWJ), Integer.valueOf(this.alT.size()));
        }
        if (zRemove) {
            t tVarXh = interfaceC0370a.wS().xh();
            if (bWJ == -4) {
                tVarXh.l(messageSnapshot);
            } else if (bWJ == -3) {
                tVarXh.j(com.kwad.framework.filedownloader.message.f.t(messageSnapshot));
            } else if (bWJ == -2) {
                tVarXh.n(messageSnapshot);
            } else if (bWJ == -1) {
                tVarXh.m(messageSnapshot);
            }
        } else {
            com.kwad.framework.filedownloader.f.d.a(this, "remove error, not exist: %s %d", interfaceC0370a, Byte.valueOf(bWJ));
        }
        return zRemove;
    }

    final void b(a.InterfaceC0370a interfaceC0370a) {
        if (!interfaceC0370a.wR().wC()) {
            interfaceC0370a.wU();
        }
        if (interfaceC0370a.wS().xh().xu()) {
            c(interfaceC0370a);
        }
    }

    final void c(a.InterfaceC0370a interfaceC0370a) {
        if (interfaceC0370a.wV()) {
            return;
        }
        synchronized (this.alT) {
            if (this.alT.contains(interfaceC0370a)) {
                com.kwad.framework.filedownloader.f.d.d(this, "already has %s", interfaceC0370a);
            } else {
                interfaceC0370a.wW();
                this.alT.add(interfaceC0370a);
                if (com.kwad.framework.filedownloader.f.d.apD) {
                    com.kwad.framework.filedownloader.f.d.e(this, "add list in all %s %d %d", interfaceC0370a, Byte.valueOf(interfaceC0370a.wR().wJ()), Integer.valueOf(this.alT.size()));
                }
            }
        }
    }
}
