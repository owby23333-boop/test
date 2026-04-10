package com.kwai.filedownloader.message;

import com.kwai.filedownloader.message.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private final e.b aHa;
    private final List<a> aHc = new ArrayList();

    public class a {
        private final List<Integer> aHd = new ArrayList();
        private final Executor aHe;

        public a(int i2) {
            this.aHe = com.kwai.filedownloader.e.b.n(1, "Flow-" + i2);
        }

        public final void cU(int i2) {
            this.aHd.add(Integer.valueOf(i2));
        }

        public final void u(final MessageSnapshot messageSnapshot) {
            this.aHe.execute(new Runnable() { // from class: com.kwai.filedownloader.message.g.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.aHa.r(messageSnapshot);
                    try {
                        a.this.aHd.remove(Integer.valueOf(messageSnapshot.getId()));
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    g(int i2, e.b bVar) {
        this.aHa = bVar;
        for (int i3 = 0; i3 < 5; i3++) {
            this.aHc.add(new a(i3));
        }
    }

    public final void u(MessageSnapshot messageSnapshot) {
        a aVar = null;
        try {
            synchronized (this.aHc) {
                int id = messageSnapshot.getId();
                Iterator<a> it = this.aHc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.aHd.contains(Integer.valueOf(id))) {
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    int size = 0;
                    Iterator<a> it2 = this.aHc.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        a next2 = it2.next();
                        if (next2.aHd.size() <= 0) {
                            aVar = next2;
                            break;
                        } else if (size == 0 || next2.aHd.size() < size) {
                            size = next2.aHd.size();
                            aVar = next2;
                        }
                    }
                }
                if (aVar != null) {
                    aVar.cU(id);
                }
            }
        } finally {
            if (aVar != null) {
                aVar.u(messageSnapshot);
            }
        }
    }
}
