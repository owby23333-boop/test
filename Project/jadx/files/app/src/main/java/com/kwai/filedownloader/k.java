package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
final class k implements t {
    private a.InterfaceC0461a aEu;
    private a.c aEv;
    private Queue<MessageSnapshot> aEw;
    private boolean aEx = false;

    k(a.InterfaceC0461a interfaceC0461a, a.c cVar) {
        a(interfaceC0461a, cVar);
    }

    private void a(a.InterfaceC0461a interfaceC0461a, a.c cVar) {
        this.aEu = interfaceC0461a;
        this.aEv = cVar;
        this.aEw = new LinkedBlockingQueue();
    }

    private void cv(int i2) {
        if (com.kwai.filedownloader.c.d.cY(i2)) {
            if (!this.aEw.isEmpty()) {
                MessageSnapshot messageSnapshotPeek = this.aEw.peek();
                com.kwai.filedownloader.e.d.h(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(messageSnapshotPeek.getId()), Integer.valueOf(this.aEw.size()), Byte.valueOf(messageSnapshotPeek.Ge()));
            }
            this.aEu = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify completed %s", this.aEu);
        }
        this.aEv.Gv();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0461a interfaceC0461a = this.aEu;
        if (interfaceC0461a == null) {
            if (com.kwai.filedownloader.e.d.aHT) {
                com.kwai.filedownloader.e.d.g(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Ge()));
            }
        } else {
            if (!this.aEx && interfaceC0461a.Gm().Gb() != null) {
                this.aEw.offer(messageSnapshot);
                j.GM().a(this);
                return;
            }
            if ((l.isValid() || this.aEu.Gt()) && messageSnapshot.Ge() == 4) {
                this.aEv.Gv();
            }
            cv(messageSnapshot.Ge());
        }
    }

    @Override // com.kwai.filedownloader.t
    public final boolean GP() {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify begin %s", this.aEu);
        }
        if (this.aEu == null) {
            com.kwai.filedownloader.e.d.h(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.aEw.size()));
            return false;
        }
        this.aEv.onBegin();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwai.filedownloader.t
    public final void GQ() {
        if (this.aEx) {
            return;
        }
        MessageSnapshot messageSnapshotPoll = this.aEw.poll();
        byte bGe = messageSnapshotPoll.Ge();
        a.InterfaceC0461a interfaceC0461a = this.aEu;
        if (interfaceC0461a == null) {
            return;
        }
        a aVarGm = interfaceC0461a.Gm();
        i iVarGb = aVarGm.Gb();
        x.a aVarGn = interfaceC0461a.Gn();
        cv(bGe);
        if (iVarGb == null) {
            return;
        }
        if (bGe == 4) {
            try {
                iVarGb.b(aVarGm);
                o(((com.kwai.filedownloader.message.a) messageSnapshotPoll).Ib());
                return;
            } catch (Throwable th) {
                m(aVarGn.l(th));
                return;
            }
        }
        g gVar = iVarGb instanceof g ? (g) iVarGb : null;
        if (bGe == -4) {
            iVarGb.d(aVarGm);
            return;
        }
        if (bGe == -3) {
            iVarGb.c(aVarGm);
            return;
        }
        if (bGe == -2) {
            if (gVar == null) {
                iVarGb.c(aVarGm, messageSnapshotPoll.Ic(), messageSnapshotPoll.Id());
                return;
            } else {
                messageSnapshotPoll.Ig();
                messageSnapshotPoll.Ie();
                return;
            }
        }
        if (bGe == -1) {
            iVarGb.a(aVarGm, messageSnapshotPoll.Ih());
            return;
        }
        if (bGe == 1) {
            if (gVar == null) {
                iVarGb.a(aVarGm, messageSnapshotPoll.Ic(), messageSnapshotPoll.Id());
                return;
            } else {
                messageSnapshotPoll.Ig();
                messageSnapshotPoll.Ie();
                return;
            }
        }
        if (bGe == 2) {
            if (gVar == null) {
                iVarGb.a(aVarGm, messageSnapshotPoll.getEtag(), messageSnapshotPoll.HU(), aVarGm.getSmallFileSoFarBytes(), messageSnapshotPoll.Id());
                return;
            }
            messageSnapshotPoll.getEtag();
            messageSnapshotPoll.HU();
            messageSnapshotPoll.Ie();
            return;
        }
        if (bGe == 3) {
            if (gVar != null) {
                messageSnapshotPoll.Ig();
                return;
            } else {
                iVarGb.b(aVarGm, messageSnapshotPoll.Ic(), aVarGm.getSmallFileTotalBytes());
                return;
            }
        }
        if (bGe != 5) {
            if (bGe != 6) {
                return;
            }
            iVarGb.a(aVarGm);
        } else {
            messageSnapshotPoll.Ih();
            messageSnapshotPoll.Gi();
            if (gVar != null) {
                messageSnapshotPoll.Ig();
            } else {
                messageSnapshotPoll.Ic();
            }
        }
    }

    @Override // com.kwai.filedownloader.t
    public final boolean GR() {
        return this.aEu.Gm().Gj();
    }

    @Override // com.kwai.filedownloader.t
    public final boolean GS() {
        return this.aEw.peek().Ge() == 4;
    }

    @Override // com.kwai.filedownloader.t
    public final void GT() {
        this.aEx = true;
    }

    @Override // com.kwai.filedownloader.t
    public final void b(a.InterfaceC0461a interfaceC0461a, a.c cVar) {
        if (this.aEu != null) {
            throw new IllegalStateException(com.kwai.filedownloader.e.f.j("the messenger is working, can't re-appointment for %s", interfaceC0461a));
        }
        a(interfaceC0461a, cVar);
    }

    @Override // com.kwai.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify pending %s", this.aEu);
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify started %s", this.aEu);
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify connected %s", this.aEu);
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a aVarGm = this.aEu.Gm();
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify progress %s %d %d", aVarGm, Long.valueOf(aVarGm.Gc()), Long.valueOf(aVarGm.Gd()));
        }
        if (aVarGm.FY() > 0) {
            p(messageSnapshot);
        } else if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify progress but client not request notify %s", this.aEu);
        }
    }

    @Override // com.kwai.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify block completed %s %s", this.aEu, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aHT) {
            a aVarGm = this.aEu.Gm();
            com.kwai.filedownloader.e.d.g(this, "notify retry %s %d %d %s", this.aEu, Integer.valueOf(aVarGm.Gh()), Integer.valueOf(aVarGm.Gi()), aVarGm.Gg());
        }
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify warn %s", this.aEu);
        }
        this.aEv.Gv();
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aHT) {
            a.InterfaceC0461a interfaceC0461a = this.aEu;
            com.kwai.filedownloader.e.d.g(this, "notify error %s %s", interfaceC0461a, interfaceC0461a.Gm().Gg());
        }
        this.aEv.Gv();
        p(messageSnapshot);
    }

    @Override // com.kwai.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwai.filedownloader.e.d.aHT) {
            com.kwai.filedownloader.e.d.g(this, "notify paused %s", this.aEu);
        }
        this.aEv.Gv();
        p(messageSnapshot);
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        a.InterfaceC0461a interfaceC0461a = this.aEu;
        objArr[0] = Integer.valueOf(interfaceC0461a == null ? -1 : interfaceC0461a.Gm().getId());
        objArr[1] = super.toString();
        return com.kwai.filedownloader.e.f.j("%d:%s", objArr);
    }
}
