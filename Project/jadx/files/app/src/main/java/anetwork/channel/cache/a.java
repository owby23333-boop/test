package anetwork.channel.cache;

import anet.channel.util.ALog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static List<C0014a> a = new ArrayList();
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ReentrantReadWriteLock.ReadLock f565c = b.readLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ReentrantReadWriteLock.WriteLock f566d = b.writeLock();

    /* JADX INFO: renamed from: anetwork.channel.cache.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Taobao */
    private static class C0014a implements Comparable<C0014a> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final Cache f567s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final b f568t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final int f569u;

        C0014a(Cache cache, b bVar, int i2) {
            this.f567s = cache;
            this.f568t = bVar;
            this.f569u = i2;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0014a c0014a) {
            return this.f569u - c0014a.f569u;
        }
    }

    public static void a(Cache cache, b bVar, int i2) {
        try {
            if (cache == null) {
                throw new IllegalArgumentException("cache is null");
            }
            if (bVar == null) {
                throw new IllegalArgumentException("prediction is null");
            }
            f566d.lock();
            a.add(new C0014a(cache, bVar, i2));
            Collections.sort(a);
        } finally {
            f566d.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001f, code lost:
    
        r3 = r1.f567s;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static anetwork.channel.cache.Cache a(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = anetwork.channel.cache.a.f565c     // Catch: java.lang.Throwable -> L29
            r0.lock()     // Catch: java.lang.Throwable -> L29
            java.util.List<anetwork.channel.cache.a$a> r0 = anetwork.channel.cache.a.a     // Catch: java.lang.Throwable -> L29
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L29
        Lb:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L29
            if (r1 == 0) goto L27
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L29
            anetwork.channel.cache.a$a r1 = (anetwork.channel.cache.a.C0014a) r1     // Catch: java.lang.Throwable -> L29
            anetwork.channel.cache.b r2 = r1.f568t     // Catch: java.lang.Throwable -> L29
            boolean r2 = r2.handleCache(r3, r4)     // Catch: java.lang.Throwable -> L29
            if (r2 == 0) goto Lb
            anetwork.channel.cache.Cache r3 = r1.f567s     // Catch: java.lang.Throwable -> L29
        L21:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = anetwork.channel.cache.a.f565c
            r4.unlock()
            return r3
        L27:
            r3 = 0
            goto L21
        L29:
            r3 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r4 = anetwork.channel.cache.a.f565c
            r4.unlock()
            goto L31
        L30:
            throw r3
        L31:
            goto L30
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.cache.a.a(java.lang.String, java.util.Map):anetwork.channel.cache.Cache");
    }

    public static void a() {
        ALog.w("anet.CacheManager", "clearAllCache", null, new Object[0]);
        Iterator<C0014a> it = a.iterator();
        while (it.hasNext()) {
            try {
                it.next().f567s.clear();
            } catch (Exception unused) {
            }
        }
    }
}
