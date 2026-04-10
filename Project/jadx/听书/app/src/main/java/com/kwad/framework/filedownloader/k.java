package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes4.dex */
final class k implements t {
    private a.InterfaceC0370a ame;
    private a.c amf;
    private Queue<MessageSnapshot> amg;
    private boolean amh = false;

    k(a.InterfaceC0370a interfaceC0370a, a.c cVar) {
        a(interfaceC0370a, cVar);
    }

    private void a(a.InterfaceC0370a interfaceC0370a, a.c cVar) {
        this.ame = interfaceC0370a;
        this.amf = cVar;
        this.amg = new LinkedBlockingQueue();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean xu() {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.ame);
        }
        if (this.ame == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.amg.size()));
            return false;
        }
        this.amf.onBegin();
        return true;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.ame);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.ame);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.ame);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a aVarWR = this.ame.wR();
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", aVarWR, Long.valueOf(aVarWR.wH()), Long.valueOf(aVarWR.wI()));
        }
        if (aVarWR.wD() <= 0) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.ame);
                return;
            }
            return;
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.ame, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            a aVarWR = this.ame.wR();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.ame, Integer.valueOf(aVarWR.wM()), Integer.valueOf(aVarWR.wN()), aVarWR.wL());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.ame);
        }
        this.amf.xa();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            a.InterfaceC0370a interfaceC0370a = this.ame;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC0370a, interfaceC0370a.wR().wL());
        }
        this.amf.xa();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.ame);
        }
        this.amf.xa();
        p(messageSnapshot);
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.apD) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.ame);
        }
        this.amf.xa();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0370a interfaceC0370a = this.ame;
        if (interfaceC0370a == null) {
            if (com.kwad.framework.filedownloader.f.d.apD) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.wJ()));
            }
        } else {
            if (this.amh || interfaceC0370a.wR().wG() == null) {
                if ((l.isValid() || this.ame.wY()) && messageSnapshot.wJ() == 4) {
                    this.amf.xa();
                }
                bv(messageSnapshot.wJ());
                return;
            }
            this.amg.offer(messageSnapshot);
            j.xr().a(this);
        }
    }

    private void bv(int i) {
        if (com.kwad.framework.filedownloader.d.d.bY(i)) {
            if (!this.amg.isEmpty()) {
                MessageSnapshot messageSnapshotPeek = this.amg.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(messageSnapshotPeek.getId()), Integer.valueOf(this.amg.size()), Byte.valueOf(messageSnapshotPeek.wJ()));
            }
            this.ame = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.framework.filedownloader.t
    public final void xv() {
        if (this.amh) {
            return;
        }
        MessageSnapshot messageSnapshotPoll = this.amg.poll();
        byte bWJ = messageSnapshotPoll.wJ();
        a.InterfaceC0370a interfaceC0370a = this.ame;
        if (interfaceC0370a == null) {
            return;
        }
        a aVarWR = interfaceC0370a.wR();
        i iVarWG = aVarWR.wG();
        x.a aVarWS = interfaceC0370a.wS();
        bv(bWJ);
        if (iVarWG == null) {
            return;
        }
        if (bWJ == 4) {
            try {
                iVarWG.b(aVarWR);
                o(((com.kwad.framework.filedownloader.message.a) messageSnapshotPoll).yL());
                return;
            } catch (Throwable th) {
                m(aVarWS.g(th));
                return;
            }
        }
        g gVar = iVarWG instanceof g ? (g) iVarWG : null;
        if (bWJ == -4) {
            iVarWG.d(aVarWR);
            return;
        }
        if (bWJ == -3) {
            iVarWG.c(aVarWR);
            return;
        }
        if (bWJ == -2) {
            if (gVar != null) {
                messageSnapshotPoll.yQ();
                messageSnapshotPoll.yO();
                return;
            } else {
                iVarWG.c(aVarWR, messageSnapshotPoll.yM(), messageSnapshotPoll.yN());
                return;
            }
        }
        if (bWJ == -1) {
            iVarWG.a(aVarWR, messageSnapshotPoll.yR());
            return;
        }
        if (bWJ == 1) {
            if (gVar != null) {
                messageSnapshotPoll.yQ();
                messageSnapshotPoll.yO();
                return;
            } else {
                iVarWG.a(aVarWR, messageSnapshotPoll.yM(), messageSnapshotPoll.yN());
                return;
            }
        }
        if (bWJ == 2) {
            if (gVar != null) {
                messageSnapshotPoll.getEtag();
                messageSnapshotPoll.yE();
                messageSnapshotPoll.yO();
                return;
            }
            iVarWG.a(aVarWR, messageSnapshotPoll.getEtag(), messageSnapshotPoll.yE(), aVarWR.getSmallFileSoFarBytes(), messageSnapshotPoll.yN());
            return;
        }
        if (bWJ == 3) {
            if (gVar != null) {
                messageSnapshotPoll.yQ();
                return;
            } else {
                iVarWG.b(aVarWR, messageSnapshotPoll.yM(), aVarWR.getSmallFileTotalBytes());
                return;
            }
        }
        if (bWJ != 5) {
            if (bWJ != 6) {
                return;
            }
            iVarWG.a(aVarWR);
        } else if (gVar != null) {
            messageSnapshotPoll.yR();
            messageSnapshotPoll.wN();
            messageSnapshotPoll.yQ();
        } else {
            messageSnapshotPoll.yR();
            messageSnapshotPoll.wN();
            messageSnapshotPoll.yM();
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean xw() {
        return this.ame.wR().wO();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC0370a interfaceC0370a, a.c cVar) {
        if (this.ame != null) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("the messenger is working, can't re-appointment for %s", interfaceC0370a));
        }
        a(interfaceC0370a, cVar);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean xx() {
        return this.amg.peek().wJ() == 4;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void xy() {
        this.amh = true;
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        a.InterfaceC0370a interfaceC0370a = this.ame;
        objArr[0] = Integer.valueOf(interfaceC0370a == null ? -1 : interfaceC0370a.wR().getId());
        objArr[1] = super.toString();
        return com.kwad.framework.filedownloader.f.f.c("%d:%s", objArr);
    }
}
