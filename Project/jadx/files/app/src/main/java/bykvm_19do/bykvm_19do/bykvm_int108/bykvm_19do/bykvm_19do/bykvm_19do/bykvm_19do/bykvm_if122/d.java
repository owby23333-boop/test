package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public abstract class d<T extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> {
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a a;
    private Queue<T> b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f1821c;

    public d(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar, Queue<String> queue, String str) {
        this.f1821c = "EventMemoryCacheManager";
        this.a = aVar;
        this.f1821c = str;
    }

    public void a(int i2, List<T> list) {
        synchronized (this) {
            if (i2 == -1 || i2 == 200 || i2 == 509) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d(this.f1821c + " memory size：" + this.b.size());
            } else {
                this.b.addAll(list);
            }
        }
    }

    public void a(T t2) {
        Queue<T> queue = this.b;
        if (queue == null || t2 == null) {
            return;
        }
        queue.offer(t2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(int r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.Queue<T extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> r6 = r4.b     // Catch: java.lang.Throwable -> L50
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L50
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a r0 = r4.a     // Catch: java.lang.Throwable -> L50
            int r0 = r0.b()     // Catch: java.lang.Throwable -> L50
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r1.<init>()     // Catch: java.lang.Throwable -> L50
            java.lang.String r2 = r4.f1821c     // Catch: java.lang.Throwable -> L50
            r1.append(r2)     // Catch: java.lang.Throwable -> L50
            java.lang.String r2 = " size:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L50
            r1.append(r6)     // Catch: java.lang.Throwable -> L50
            java.lang.String r2 = " cacheCount:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L50
            r1.append(r0)     // Catch: java.lang.Throwable -> L50
            java.lang.String r2 = " message:"
            r1.append(r2)     // Catch: java.lang.Throwable -> L50
            r1.append(r5)     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L50
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d(r1)     // Catch: java.lang.Throwable -> L50
            r1 = 2
            r2 = 0
            r3 = 1
            if (r5 == r1) goto L41
            if (r5 != r3) goto L3e
            goto L41
        L3e:
            if (r6 >= r0) goto L4d
            goto L4e
        L41:
            boolean r5 = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.d()     // Catch: java.lang.Throwable -> L50
            if (r5 == 0) goto L4a
            if (r6 < r3) goto L4e
            goto L4d
        L4a:
            if (r6 >= r0) goto L4d
            goto L4e
        L4d:
            r2 = 1
        L4e:
            monitor-exit(r4)
            return r2
        L50:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.a(int, int):boolean");
    }

    public List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> b(int i2, int i3) {
        ArrayList arrayList;
        synchronized (this) {
            if (a(i2, i3)) {
                arrayList = new ArrayList(this.a.b());
                do {
                    T tPoll = this.b.poll();
                    if (tPoll == null) {
                        break;
                    }
                    arrayList.add(tPoll);
                } while (arrayList.size() != this.a.a());
            } else {
                arrayList = null;
            }
        }
        return arrayList;
    }
}
