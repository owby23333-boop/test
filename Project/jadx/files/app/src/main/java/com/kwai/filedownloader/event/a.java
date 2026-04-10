package com.kwai.filedownloader.event;

import com.kwai.filedownloader.e.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private final Executor aGJ = com.kwai.filedownloader.e.b.n(10, "EventPool");
    private final HashMap<String, LinkedList<c>> aGK = new HashMap<>();

    private static void a(LinkedList<c> linkedList, b bVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null) {
                ((c) obj).a(bVar);
            }
        }
        Runnable runnable = bVar.aGP;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final boolean a(String str, c cVar) {
        boolean zAdd;
        if (d.aHT) {
            d.i(this, "setListener %s", str);
        }
        if (cVar == null) {
            throw new IllegalArgumentException("listener must not be null!");
        }
        LinkedList<c> linkedList = this.aGK.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                linkedList = this.aGK.get(str);
                if (linkedList == null) {
                    HashMap<String, LinkedList<c>> map = this.aGK;
                    LinkedList<c> linkedList2 = new LinkedList<>();
                    map.put(str, linkedList2);
                    linkedList = linkedList2;
                }
            }
        }
        synchronized (str.intern()) {
            zAdd = linkedList.add(cVar);
        }
        return zAdd;
    }

    public final boolean b(b bVar) {
        if (d.aHT) {
            d.i(this, "publish %s", bVar.getId());
        }
        if (bVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        String id = bVar.getId();
        LinkedList<c> linkedList = this.aGK.get(id);
        if (linkedList == null) {
            synchronized (id.intern()) {
                linkedList = this.aGK.get(id);
                if (linkedList == null) {
                    if (d.aHT) {
                        d.g(this, "No listener for this event %s", id);
                    }
                    return false;
                }
            }
        }
        a(linkedList, bVar);
        return true;
    }

    public final void c(final b bVar) {
        if (d.aHT) {
            d.i(this, "asyncPublishInNewThread %s", bVar.getId());
        }
        this.aGJ.execute(new Runnable() { // from class: com.kwai.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.b(bVar);
                } catch (Exception unused) {
                }
            }
        });
    }
}
