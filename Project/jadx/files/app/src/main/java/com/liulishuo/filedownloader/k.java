package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.message.BlockCompleteMessage;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: FileDownloadMessenger.java */
/* JADX INFO: loaded from: classes3.dex */
class k implements t {
    private a.b a;
    private a.d b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Queue<MessageSnapshot> f17223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17224d = false;

    k(a.b bVar, a.d dVar) {
        a(bVar, dVar);
    }

    private void a(a.b bVar, a.d dVar) {
        this.a = bVar;
        this.b = dVar;
        this.f17223c = new LinkedBlockingQueue();
    }

    private void k(MessageSnapshot messageSnapshot) {
        a.b bVar = this.a;
        if (bVar == null) {
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.e()), Byte.valueOf(messageSnapshot.o()));
            }
        } else {
            if (!this.f17224d && bVar.getOrigin().getListener() != null) {
                this.f17223c.offer(messageSnapshot);
                j.a().a(this);
                return;
            }
            if ((l.b() || this.a.v()) && messageSnapshot.o() == 4) {
                this.b.f();
            }
            a(messageSnapshot.o());
        }
    }

    @Override // com.liulishuo.filedownloader.t
    public boolean b() {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify begin %s", this.a);
        }
        if (this.a == null) {
            com.liulishuo.filedownloader.h0.d.e(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.f17223c.size()));
            return false;
        }
        this.b.onBegin();
        return true;
    }

    @Override // com.liulishuo.filedownloader.t
    public void c(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            a origin = this.a.getOrigin();
            com.liulishuo.filedownloader.h0.d.a(this, "notify retry %s %d %d %s", this.a, Integer.valueOf(origin.j()), Integer.valueOf(origin.a()), origin.b());
        }
        this.b.h();
        k(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.t
    public void d(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify connected %s", this.a);
        }
        this.b.h();
        k(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.t
    public void e(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify started %s", this.a);
        }
        this.b.h();
        k(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.t
    public void f(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify paused %s", this.a);
        }
        this.b.f();
        k(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.t
    public void g(MessageSnapshot messageSnapshot) {
        a origin = this.a.getOrigin();
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify progress %s %d %d", origin, Long.valueOf(origin.p()), Long.valueOf(origin.r()));
        }
        if (origin.l() > 0) {
            this.b.h();
            k(messageSnapshot);
        } else if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify progress but client not request notify %s", this.a);
        }
    }

    @Override // com.liulishuo.filedownloader.t
    public void h(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify warn %s", this.a);
        }
        this.b.f();
        k(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.t
    public void i(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify block completed %s %s", this.a, Thread.currentThread().getName());
        }
        this.b.h();
        k(messageSnapshot);
    }

    public void j(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify completed %s", this.a);
        }
        this.b.f();
        k(messageSnapshot);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        a.b bVar = this.a;
        objArr[0] = Integer.valueOf(bVar == null ? -1 : bVar.getOrigin().getId());
        objArr[1] = super.toString();
        return com.liulishuo.filedownloader.h0.f.a("%d:%s", objArr);
    }

    @Override // com.liulishuo.filedownloader.t
    public void a(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.a(this, "notify pending %s", this.a);
        }
        this.b.h();
        k(messageSnapshot);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.liulishuo.filedownloader.t
    public void d() {
        if (this.f17224d) {
            return;
        }
        MessageSnapshot messageSnapshotPoll = this.f17223c.poll();
        byte bO = messageSnapshotPoll.o();
        a.b bVar = this.a;
        if (bVar != null) {
            a origin = bVar.getOrigin();
            i listener = origin.getListener();
            x.a messageHandler = bVar.getMessageHandler();
            a(bO);
            if (listener == null || listener.a()) {
                return;
            }
            if (bO == 4) {
                try {
                    listener.a(origin);
                    j(((BlockCompleteMessage) messageSnapshotPoll).b());
                    return;
                } catch (Throwable th) {
                    b(messageHandler.a(th));
                    return;
                }
            }
            g gVar = listener instanceof g ? (g) listener : null;
            if (bO == -4) {
                listener.d(origin);
                return;
            }
            if (bO == -3) {
                listener.b(origin);
                return;
            }
            if (bO == -2) {
                if (gVar != null) {
                    gVar.a(origin, messageSnapshotPoll.f(), messageSnapshotPoll.g());
                    return;
                } else {
                    listener.a(origin, messageSnapshotPoll.i(), messageSnapshotPoll.n());
                    return;
                }
            }
            if (bO == -1) {
                listener.a(origin, messageSnapshotPoll.p());
                return;
            }
            if (bO == 1) {
                if (gVar != null) {
                    gVar.b(origin, messageSnapshotPoll.f(), messageSnapshotPoll.g());
                    return;
                } else {
                    listener.b(origin, messageSnapshotPoll.i(), messageSnapshotPoll.n());
                    return;
                }
            }
            if (bO == 2) {
                if (gVar != null) {
                    gVar.a(origin, messageSnapshotPoll.c(), messageSnapshotPoll.r(), origin.p(), messageSnapshotPoll.g());
                    return;
                } else {
                    listener.a(origin, messageSnapshotPoll.c(), messageSnapshotPoll.r(), origin.getSmallFileSoFarBytes(), messageSnapshotPoll.n());
                    return;
                }
            }
            if (bO == 3) {
                if (gVar != null) {
                    gVar.c(origin, messageSnapshotPoll.f(), origin.r());
                    return;
                } else {
                    listener.c(origin, messageSnapshotPoll.i(), origin.getSmallFileTotalBytes());
                    return;
                }
            }
            if (bO != 5) {
                if (bO != 6) {
                    return;
                }
                listener.c(origin);
                return;
            } else if (gVar != null) {
                gVar.a(origin, messageSnapshotPoll.p(), messageSnapshotPoll.h(), messageSnapshotPoll.f());
                return;
            } else {
                listener.a(origin, messageSnapshotPoll.p(), messageSnapshotPoll.h(), messageSnapshotPoll.i());
                return;
            }
        }
        throw new IllegalArgumentException(com.liulishuo.filedownloader.h0.f.a("can't handover the message, no master to receive this message(status[%d]) size[%d]", Integer.valueOf(bO), Integer.valueOf(this.f17223c.size())));
    }

    private void a(int i2) {
        if (com.liulishuo.filedownloader.model.b.b(i2)) {
            if (!this.f17223c.isEmpty()) {
                MessageSnapshot messageSnapshotPeek = this.f17223c.peek();
                com.liulishuo.filedownloader.h0.d.e(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(messageSnapshotPeek.e()), Integer.valueOf(this.f17223c.size()), Byte.valueOf(messageSnapshotPeek.o()));
            }
            this.a = null;
        }
    }

    @Override // com.liulishuo.filedownloader.t
    public void b(MessageSnapshot messageSnapshot) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            a.b bVar = this.a;
            com.liulishuo.filedownloader.h0.d.a(this, "notify error %s %s", bVar, bVar.getOrigin().b());
        }
        this.b.f();
        k(messageSnapshot);
    }

    @Override // com.liulishuo.filedownloader.t
    public boolean c() {
        return this.f17223c.peek().o() == 4;
    }

    @Override // com.liulishuo.filedownloader.t
    public boolean a() {
        return this.a.getOrigin().w();
    }
}
