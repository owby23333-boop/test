package com.liulishuo.filedownloader.event;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DownloadEventPoolImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements c {
    private final Executor a = com.liulishuo.filedownloader.h0.b.a(10, "EventPool");
    private final HashMap<String, LinkedList<d>> b = new HashMap<>();

    /* JADX INFO: renamed from: com.liulishuo.filedownloader.event.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DownloadEventPoolImpl.java */
    class RunnableC0486a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ b f17198s;

        RunnableC0486a(b bVar) {
            this.f17198s = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b(this.f17198s);
        }
    }

    public boolean a(String str, d dVar) {
        boolean zAdd;
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.d(this, "setListener %s", str);
        }
        if (dVar == null) {
            throw new IllegalArgumentException("listener must not be null!");
        }
        LinkedList<d> linkedList = this.b.get(str);
        if (linkedList == null) {
            synchronized (str.intern()) {
                linkedList = this.b.get(str);
                if (linkedList == null) {
                    HashMap<String, LinkedList<d>> map = this.b;
                    LinkedList<d> linkedList2 = new LinkedList<>();
                    map.put(str, linkedList2);
                    linkedList = linkedList2;
                }
            }
        }
        synchronized (str.intern()) {
            zAdd = linkedList.add(dVar);
        }
        return zAdd;
    }

    public boolean b(b bVar) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.d(this, "publish %s", bVar.a());
        }
        if (bVar == null) {
            throw new IllegalArgumentException("event must not be null!");
        }
        String strA = bVar.a();
        LinkedList<d> linkedList = this.b.get(strA);
        if (linkedList == null) {
            synchronized (strA.intern()) {
                linkedList = this.b.get(strA);
                if (linkedList == null) {
                    if (com.liulishuo.filedownloader.h0.d.a) {
                        com.liulishuo.filedownloader.h0.d.a(this, "No listener for this event %s", strA);
                    }
                    return false;
                }
            }
        }
        a(linkedList, bVar);
        return true;
    }

    public void a(b bVar) {
        if (com.liulishuo.filedownloader.h0.d.a) {
            com.liulishuo.filedownloader.h0.d.d(this, "asyncPublishInNewThread %s", bVar.a());
        }
        if (bVar != null) {
            this.a.execute(new RunnableC0486a(bVar));
            return;
        }
        throw new IllegalArgumentException("event must not be null!");
    }

    private void a(LinkedList<d> linkedList, b bVar) {
        for (Object obj : linkedList.toArray()) {
            if (obj != null && ((d) obj).a(bVar)) {
                break;
            }
        }
        Runnable runnable = bVar.a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
