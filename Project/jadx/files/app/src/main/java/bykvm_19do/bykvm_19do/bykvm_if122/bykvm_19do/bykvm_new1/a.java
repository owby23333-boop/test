package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f1612d;
    private long a;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Queue<Long> f1613c = new LinkedList();

    private a() {
    }

    public static a b() {
        if (f1612d == null) {
            synchronized (a.class) {
                if (f1612d == null) {
                    f1612d = new a();
                }
            }
        }
        return f1612d;
    }

    public void a(long j2, long j3) {
        synchronized (a.class) {
            if (this.a != j2 || this.b != j3) {
                this.a = j2;
                this.b = j3;
                this.f1613c.clear();
            }
        }
    }

    public boolean a() {
        boolean z2;
        Queue<Long> queue;
        Long lValueOf;
        synchronized (a.class) {
            z2 = false;
            if (this.a > 0 && this.b > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (this.f1613c.size() >= this.a) {
                    while (this.f1613c.size() > this.a) {
                        this.f1613c.poll();
                    }
                    if (Math.abs(jCurrentTimeMillis - this.f1613c.peek().longValue()) <= this.b) {
                        z2 = true;
                    } else {
                        this.f1613c.poll();
                        queue = this.f1613c;
                        lValueOf = Long.valueOf(jCurrentTimeMillis);
                    }
                } else {
                    queue = this.f1613c;
                    lValueOf = Long.valueOf(jCurrentTimeMillis);
                }
                queue.offer(lValueOf);
            }
        }
        return z2;
    }
}
