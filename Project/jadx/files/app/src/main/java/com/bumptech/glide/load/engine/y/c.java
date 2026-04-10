package com.bumptech.glide.load.engine.y;

import com.bumptech.glide.util.k;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: DiskCacheWriteLocker.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    private final Map<String, a> a = new HashMap();
    private final b b = new b();

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class a {
        final Lock a = new ReentrantLock();
        int b;

        a() {
        }
    }

    c() {
    }

    void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = this.a.get(str);
            if (aVarA == null) {
                aVarA = this.b.a();
                this.a.put(str, aVarA);
            }
            aVarA.b++;
        }
        aVarA.a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.a.get(str);
            k.a(aVar2);
            aVar = aVar2;
            if (aVar.b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
            }
            aVar.b--;
            if (aVar.b == 0) {
                a aVarRemove = this.a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.b.a(aVarRemove);
            }
        }
        aVar.a.unlock();
    }

    /* JADX INFO: compiled from: DiskCacheWriteLocker.java */
    private static class b {
        private final Queue<a> a = new ArrayDeque();

        b() {
        }

        a a() {
            a aVarPoll;
            synchronized (this.a) {
                aVarPoll = this.a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void a(a aVar) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(aVar);
                }
            }
        }
    }
}
