package com.bytedance.sdk.component.m.dl.z;

import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class dl<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f769a;
    private int dl;
    private int e;
    private int g;
    private int gc;
    private int gz;
    private int m;
    private final LinkedHashMap<K, SoftReference<V>> z;

    protected int g(K k, V v) {
        return 1;
    }

    protected V g(K k) {
        return null;
    }

    public dl(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.dl = i;
        this.z = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V z(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.z.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.e++;
                    return v;
                }
                this.z.remove(k);
            } else {
                v = null;
            }
            this.gz++;
            V vG = g(k);
            if (vG == null) {
                return null;
            }
            synchronized (this) {
                this.gc++;
                SoftReference<V> softReferencePut = this.z.put(k, new SoftReference<>(vG));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.z.put(k, softReferencePut);
                } else {
                    this.g += dl(k, vG);
                }
            }
            if (v != null) {
                return v;
            }
            z(this.dl);
            return vG;
        }
    }

    public final V z(K k, V v) {
        V v2;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f769a++;
            this.g += dl(k, v);
            SoftReference<V> softReferencePut = this.z.put(k, new SoftReference<>(v));
            if (softReferencePut != null) {
                v2 = softReferencePut.get();
                if (v2 != null) {
                    this.g -= dl(k, v2);
                }
            } else {
                v2 = null;
            }
        }
        z(this.dl);
        return v2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0052, code lost:
    
        com.bytedance.sdk.component.utils.wp.a("LruCache", "oom maybe occured, clear cache. size= " + r3.g + ", maxSize: " + r4);
        r3.g = 0;
        r3.z.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x007b, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void z(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.g     // Catch: java.lang.Throwable -> L7c
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.z     // Catch: java.lang.Throwable -> L7c
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L12
            int r0 = r3.g     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L12
            goto L52
        L12:
            int r0 = r3.g     // Catch: java.lang.Throwable -> L7c
            if (r0 > r4) goto L18
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            return
        L18:
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.z     // Catch: java.lang.Throwable -> L7c
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L7c
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L7c
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L7c
            if (r0 != 0) goto L2c
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            return
        L2c:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L7c
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L7c
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0     // Catch: java.lang.Throwable -> L7c
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r2 = r3.z     // Catch: java.lang.Throwable -> L7c
            r2.remove(r1)     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L4a
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L7c
            int r2 = r3.g     // Catch: java.lang.Throwable -> L7c
            int r0 = r3.dl(r1, r0)     // Catch: java.lang.Throwable -> L7c
            int r2 = r2 - r0
            r3.g = r2     // Catch: java.lang.Throwable -> L7c
        L4a:
            int r0 = r3.m     // Catch: java.lang.Throwable -> L7c
            int r0 = r0 + 1
            r3.m = r0     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            goto L0
        L52:
            java.lang.String r0 = "LruCache"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = "oom maybe occured, clear cache. size= "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7c
            int r2 = r3.g     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r2 = ", maxSize: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r4 = r1.append(r4)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L7c
            com.bytedance.sdk.component.utils.wp.a(r0, r4)     // Catch: java.lang.Throwable -> L7c
            r4 = 0
            r3.g = r4     // Catch: java.lang.Throwable -> L7c
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r4 = r3.z     // Catch: java.lang.Throwable -> L7c
            r4.clear()     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            return
        L7c:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L7c
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.m.dl.z.dl.z(int):void");
    }

    private int dl(K k, V v) {
        int iG = g(k, v);
        if (iG >= 0) {
            return iG;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final void z() {
        z(-1);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.e;
        i2 = this.gz + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.dl), Integer.valueOf(this.e), Integer.valueOf(this.gz), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
