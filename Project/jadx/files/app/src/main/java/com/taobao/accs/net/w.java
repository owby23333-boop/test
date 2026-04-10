package com.taobao.accs.net;

import com.taobao.accs.data.Message;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class w implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ v f18255c;

    w(v vVar, Message message, boolean z2) {
        this.f18255c = vVar;
        this.a = message;
        this.b = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f18255c.f18247u) {
            this.f18255c.a(this.a);
            if (this.f18255c.f18247u.size() == 0) {
                this.f18255c.f18247u.add(this.a);
            } else {
                Message message = (Message) this.f18255c.f18247u.getFirst();
                if (this.a.getType() == 1 || this.a.getType() == 0) {
                    this.f18255c.f18247u.addLast(this.a);
                    if (message.getType() == 2) {
                        this.f18255c.f18247u.removeFirst();
                    }
                } else if (this.a.getType() != 2 || message.getType() != 2) {
                    this.f18255c.f18247u.addLast(this.a);
                } else if (!message.force && this.a.force) {
                    this.f18255c.f18247u.removeFirst();
                    this.f18255c.f18247u.addFirst(this.a);
                }
            }
            if (this.b || this.f18255c.f18246t == 3) {
                try {
                    this.f18255c.f18247u.notifyAll();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
