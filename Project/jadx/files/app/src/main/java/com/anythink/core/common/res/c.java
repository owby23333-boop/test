package com.anythink.core.common.res;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c<K, V> {
    private final LinkedHashMap<K, V> a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f7912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f7913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f7914h;

    public c(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f7909c = i2;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private void a(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.f7909c = i2;
        }
        b(i2);
    }

    private static V b() {
        return null;
    }

    private int c(K k2, V v2) {
        int iA = a(k2, v2);
        if (iA >= 0) {
            return iA;
        }
        throw new IllegalStateException("Negative size: " + k2 + "=" + v2);
    }

    private synchronized int d() {
        return this.f7909c;
    }

    private synchronized int e() {
        return this.f7913g;
    }

    private synchronized int f() {
        return this.f7914h;
    }

    private synchronized int g() {
        return this.f7911e;
    }

    private synchronized int h() {
        return this.f7910d;
    }

    private synchronized int i() {
        return this.f7912f;
    }

    private synchronized Map<K, V> j() {
        return new LinkedHashMap(this.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0082, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            r6 = this;
            java.util.LinkedHashMap<K, V> r0 = r6.a
            monitor-enter(r0)
        L3:
            monitor-enter(r6)     // Catch: java.lang.Throwable -> L86
            int r1 = r6.b     // Catch: java.lang.Throwable -> L83
            if (r1 < 0) goto L64
            java.util.LinkedHashMap<K, V> r1 = r6.a     // Catch: java.lang.Throwable -> L83
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L14
            int r1 = r6.b     // Catch: java.lang.Throwable -> L83
            if (r1 != 0) goto L64
        L14:
            int r1 = r6.b     // Catch: java.lang.Throwable -> L83
            if (r1 != 0) goto L1a
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L83
            goto L3c
        L1a:
            java.util.LinkedHashMap<K, V> r1 = r6.a     // Catch: java.lang.Throwable -> L83
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L83
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L83
            r2 = 0
            if (r1 <= 0) goto L38
            java.util.LinkedHashMap<K, V> r1 = r6.a     // Catch: java.lang.Throwable -> L83
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L83
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L83
            java.lang.Object r1 = r1.next()     // Catch: java.lang.Throwable -> L83
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch: java.lang.Throwable -> L83
            goto L39
        L38:
            r1 = r2
        L39:
            if (r1 != 0) goto L43
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L83
        L3c:
            java.util.LinkedHashMap<K, V> r1 = r6.a     // Catch: java.lang.Throwable -> L86
            r1.clear()     // Catch: java.lang.Throwable -> L86
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L86
            return
        L43:
            java.lang.Object r3 = r1.getKey()     // Catch: java.lang.Throwable -> L83
            java.lang.Object r1 = r1.getValue()     // Catch: java.lang.Throwable -> L83
            java.util.LinkedHashMap<K, V> r4 = r6.a     // Catch: java.lang.Throwable -> L83
            r4.remove(r3)     // Catch: java.lang.Throwable -> L83
            int r4 = r6.b     // Catch: java.lang.Throwable -> L83
            int r5 = r6.c(r3, r1)     // Catch: java.lang.Throwable -> L83
            int r4 = r4 - r5
            r6.b = r4     // Catch: java.lang.Throwable -> L83
            int r4 = r6.f7912f     // Catch: java.lang.Throwable -> L83
            r5 = 1
            int r4 = r4 + r5
            r6.f7912f = r4     // Catch: java.lang.Throwable -> L83
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L83
            r6.a(r5, r3, r1, r2)     // Catch: java.lang.Throwable -> L86
            goto L3
        L64:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L83
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L83
            r2.<init>()     // Catch: java.lang.Throwable -> L83
            java.lang.Class r3 = r6.getClass()     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Throwable -> L83
            r2.append(r3)     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = ".sizeOf() is reporting inconsistent results!"
            r2.append(r3)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L83
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L83
            throw r1     // Catch: java.lang.Throwable -> L83
        L83:
            r1 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L86
            throw r1     // Catch: java.lang.Throwable -> L86
        L86:
            r1 = move-exception
            monitor-exit(r0)
            goto L8a
        L89:
            throw r1
        L8a:
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.res.c.k():void");
    }

    protected int a(K k2, V v2) {
        return 1;
    }

    protected void a(boolean z2, K k2, V v2, V v3) {
    }

    public final V b(K k2, V v2) {
        V vPut;
        if (k2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f7910d++;
            this.b += c(k2, v2);
            vPut = this.a.put(k2, v2);
            if (vPut != null) {
                this.b -= c(k2, vPut);
            }
        }
        if (vPut != null) {
            a(false, k2, vPut, v2);
        }
        b(this.f7909c);
        return vPut;
    }

    public final synchronized String toString() {
        int i2;
        i2 = this.f7913g + this.f7914h;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f7909c), Integer.valueOf(this.f7913g), Integer.valueOf(this.f7914h), Integer.valueOf(i2 != 0 ? (this.f7913g * 100) / i2 : 0));
    }

    private synchronized int c() {
        return this.b;
    }

    public final V a(K k2) {
        if (k2 != null) {
            synchronized (this) {
                V v2 = this.a.get(k2);
                if (v2 != null) {
                    this.f7913g++;
                    return v2;
                }
                this.f7914h++;
                return null;
            }
        }
        throw new NullPointerException("key == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        r5.b = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results! --> size: " + r5.b + ", map.isEmpty(): " + r5.a.isEmpty());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(int r6) {
        /*
            r5 = this;
        L0:
            monitor-enter(r5)
            int r0 = r5.b     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            if (r0 < 0) goto L5b
            java.util.LinkedHashMap<K, V> r0 = r5.a     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            if (r0 == 0) goto L11
            int r0 = r5.b     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            if (r0 != 0) goto L5b
        L11:
            int r0 = r5.b     // Catch: java.lang.Throwable -> L90
            if (r0 > r6) goto L17
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L90
            return
        L17:
            java.util.LinkedHashMap<K, V> r0 = r5.a     // Catch: java.lang.Throwable -> L90
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L90
            int r0 = r0.size()     // Catch: java.lang.Throwable -> L90
            r1 = 0
            if (r0 <= 0) goto L35
            java.util.LinkedHashMap<K, V> r0 = r5.a     // Catch: java.lang.Throwable -> L90
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L90
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L90
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L90
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L90
            goto L36
        L35:
            r0 = r1
        L36:
            if (r0 != 0) goto L3a
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L90
            return
        L3a:
            java.lang.Object r2 = r0.getKey()     // Catch: java.lang.Throwable -> L90
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L90
            java.util.LinkedHashMap<K, V> r3 = r5.a     // Catch: java.lang.Throwable -> L90
            r3.remove(r2)     // Catch: java.lang.Throwable -> L90
            int r3 = r5.b     // Catch: java.lang.Throwable -> L90
            int r4 = r5.c(r2, r0)     // Catch: java.lang.Throwable -> L90
            int r3 = r3 - r4
            r5.b = r3     // Catch: java.lang.Throwable -> L90
            int r3 = r5.f7912f     // Catch: java.lang.Throwable -> L90
            r4 = 1
            int r3 = r3 + r4
            r5.f7912f = r3     // Catch: java.lang.Throwable -> L90
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L90
            r5.a(r4, r2, r0, r1)
            goto L0
        L5b:
            r6 = 0
            r5.b = r6     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r0.<init>()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.lang.Class r1 = r5.getClass()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r0.append(r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results! --> size: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            int r1 = r5.b     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r0.append(r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.lang.String r1 = ", map.isEmpty(): "
            r0.append(r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.util.LinkedHashMap<K, V> r1 = r5.a     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r0.append(r1)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
            throw r6     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> L92
        L90:
            r6 = move-exception
            goto L98
        L92:
            r6 = move-exception
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L90
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L90
            return
        L98:
            monitor-exit(r5)
            goto L9b
        L9a:
            throw r6
        L9b:
            goto L9a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.common.res.c.b(int):void");
    }

    public final void a() {
        b(-1);
    }

    private V b(K k2) {
        V vRemove;
        if (k2 != null) {
            synchronized (this) {
                vRemove = this.a.remove(k2);
                if (vRemove != null) {
                    this.b -= c(k2, vRemove);
                }
            }
            if (vRemove != null) {
                a(false, k2, vRemove, null);
            }
            return vRemove;
        }
        throw new NullPointerException("key == null");
    }
}
