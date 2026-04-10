package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    private final e.b aoL;
    private final List<a> aoN = new ArrayList();

    g(int i, e.b bVar) {
        this.aoL = bVar;
        for (int i2 = 0; i2 < 5; i2++) {
            this.aoN.add(new a(i2));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.aoN) {
                int id = messageSnapshot.getId();
                Iterator<a> it = this.aoN.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.aoO.contains(Integer.valueOf(id))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    Iterator<a> it2 = this.aoN.iterator();
                    int size = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.aoO.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (size == 0 || next2.aoO.size() < size) {
                            size = next2.aoO.size();
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.bU(id);
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }

    public class a {
        private final List<Integer> aoO = new ArrayList();
        private final Executor aoP;

        public a(int i) {
            this.aoP = com.kwad.framework.filedownloader.f.b.r(1, "Flow-" + i);
        }

        public final void bU(int i) {
            this.aoO.add(Integer.valueOf(i));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.aoP.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aoL.r(messageSnapshot);
                    try {
                        a.this.aoO.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }
}
