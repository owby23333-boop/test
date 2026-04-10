package com.kwad.framework.filedownloader.event;

import com.kwad.framework.filedownloader.f.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private final Executor aou = com.kwad.framework.filedownloader.f.b.r(10, "EventPool");
    private final HashMap<String, LinkedList<c>> aov = new HashMap<>();

    public final boolean a(String str, c cVar) {
        boolean zAdd;
        if (d.apD) {
            d.e(this, "setListener %s", str);
        }
        if (cVar == null) {
            throw new IllegalArgumentException("listener must not be null!");
        }
        LinkedList<c> linkedList = this.aov.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                linkedList = this.aov.get(str);
                if (linkedList == null) {
                    HashMap<String, LinkedList<c>> map = this.aov;
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
        if (d.apD) {
            d.e(this, "publish %s", bVar.getId());
        }
        if (bVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        String id = bVar.getId();
        LinkedList<c> linkedList = this.aov.get(id);
        if (linkedList == null) {
            synchronized (id.intern()) {
                linkedList = this.aov.get(id);
                if (linkedList == null) {
                    if (d.apD) {
                        d.c(this, "No listener for this event %s", id);
                    }
                    return false;
                }
            }
        }
        a(linkedList, bVar);
        return true;
    }

    public final void c(final b bVar) {
        if (d.apD) {
            d.e(this, "asyncPublishInNewThread %s", bVar.getId());
        }
        this.aou.execute(new Runnable() { // from class: com.kwad.framework.filedownloader.event.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.b(bVar);
                } catch (Exception unused) {
                }
            }
        });
    }

    private static void a(LinkedList<c> linkedList, b bVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null) {
                ((c) obj).a(bVar);
            }
        }
        if (bVar.aoA != null) {
            bVar.aoA.run();
        }
    }
}
