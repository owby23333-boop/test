package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.message.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: MessageSnapshotThreadPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {
    private final List<a> a = new ArrayList();
    private final c.b b;

    /* JADX INFO: compiled from: MessageSnapshotThreadPool.java */
    public class a {
        private final List<Integer> a = new ArrayList();
        private final Executor b;

        /* JADX INFO: renamed from: com.liulishuo.filedownloader.message.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MessageSnapshotThreadPool.java */
        class RunnableC0491a implements Runnable {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ MessageSnapshot f17254s;

            RunnableC0491a(MessageSnapshot messageSnapshot) {
                this.f17254s = messageSnapshot;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.b.a(this.f17254s);
                a.this.a.remove(Integer.valueOf(this.f17254s.e()));
            }
        }

        public a(int i2) {
            this.b = com.liulishuo.filedownloader.h0.b.a(1, "Flow-" + i2);
        }

        public void a(int i2) {
            this.a.add(Integer.valueOf(i2));
        }

        public void a(MessageSnapshot messageSnapshot) {
            this.b.execute(new RunnableC0491a(messageSnapshot));
        }
    }

    e(int i2, c.b bVar) {
        this.b = bVar;
        for (int i3 = 0; i3 < i2; i3++) {
            this.a.add(new a(i3));
        }
    }

    public void a(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.a) {
                int iE = messageSnapshot.e();
                Iterator<a> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.a.contains(Integer.valueOf(iE))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int size = 0;
                    Iterator<a> it2 = this.a.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.a.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (size == 0 || next2.a.size() < size) {
                            size = next2.a.size();
                            aVar = next2;
                        }
                    }
                }
                aVar.a(iE);
            }
        } finally {
            aVar.a(messageSnapshot);
        }
    }
}
