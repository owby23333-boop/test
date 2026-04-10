package com.anythink.expressad.a.a;

import com.anythink.expressad.foundation.g.a.e;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements e<String, b> {
    private final LinkedHashMap<String, b> a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8028c;

    public c(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.b = i2;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private static int c() {
        return 1;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.b));
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final void a(String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            if (this.a.remove(str) != null) {
                this.f8028c--;
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final b b(String str) {
        if (str != null) {
            synchronized (this) {
                b bVar = this.a.get(str);
                if (bVar != null) {
                    return bVar;
                }
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final void b() {
        a(-1);
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final boolean a(String str, b bVar) {
        if (str != null && bVar != null) {
            synchronized (this) {
                this.f8028c++;
                if (this.a.put(str, bVar) != null) {
                    this.f8028c--;
                }
            }
            a(this.b);
            return true;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0068, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r3) {
        /*
            r2 = this;
        L0:
            monitor-enter(r2)
            int r0 = r2.f8028c     // Catch: java.lang.Throwable -> L69
            if (r0 < 0) goto L4a
            java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.a.a.b> r0 = r2.a     // Catch: java.lang.Throwable -> L69
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L11
            int r0 = r2.f8028c     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L4a
        L11:
            int r0 = r2.f8028c     // Catch: java.lang.Throwable -> L69
            if (r0 <= r3) goto L48
            java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.a.a.b> r0 = r2.a     // Catch: java.lang.Throwable -> L69
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L1e
            goto L48
        L1e:
            java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.a.a.b> r0 = r2.a     // Catch: java.lang.Throwable -> L69
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L69
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L69
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L69
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L69
            if (r0 != 0) goto L32
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L69
            return
        L32:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L69
            r0.getValue()     // Catch: java.lang.Throwable -> L69
            java.util.LinkedHashMap<java.lang.String, com.anythink.expressad.a.a.b> r0 = r2.a     // Catch: java.lang.Throwable -> L46
            r0.remove(r1)     // Catch: java.lang.Throwable -> L46
            int r0 = r2.f8028c     // Catch: java.lang.Throwable -> L46
            int r0 = r0 + (-1)
            r2.f8028c = r0     // Catch: java.lang.Throwable -> L46
        L46:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L69
            goto L0
        L48:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L69
            return
        L4a:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L69
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69
            r0.<init>()     // Catch: java.lang.Throwable -> L69
            java.lang.Class r1 = r2.getClass()     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L69
            r0.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L69
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L69
            throw r3     // Catch: java.lang.Throwable -> L69
        L69:
            r3 = move-exception
            monitor-exit(r2)
            goto L6d
        L6c:
            throw r3
        L6d:
            goto L6c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.a.a.c.a(int):void");
    }

    @Override // com.anythink.expressad.foundation.g.a.e
    public final Collection<String> a() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.a.keySet());
        }
        return hashSet;
    }
}
