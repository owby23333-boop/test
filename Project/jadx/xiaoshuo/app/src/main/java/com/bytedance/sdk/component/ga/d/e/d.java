package com.bytedance.sdk.component.ga.d.e;

import com.iflytek.aikit.media.param.MscKeys;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d<K, V> {
    private int bf;
    private int d;
    private final LinkedHashMap<K, SoftReference<V>> e;
    private int ga;
    private int p;
    private int tg;
    private int v;
    private int vn;

    public d(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.d = i;
        this.e = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int d(K k, V v) {
        int iBf = bf(k, v);
        if (iBf >= 0) {
            return iBf;
        }
        throw new IllegalStateException("Negative size: " + k + MscKeys.KEY_VAL_SEP + v);
    }

    public int bf(K k, V v) {
        return 1;
    }

    public void e(boolean z, K k, V v, V v2) {
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.p;
        i2 = this.v + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.d), Integer.valueOf(this.p), Integer.valueOf(this.v), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public V bf(K k) {
        return null;
    }

    public final V e(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.e.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.p++;
                    return v;
                }
                this.e.remove(k);
            } else {
                v = null;
            }
            this.v++;
            V vBf = bf(k);
            if (vBf == null) {
                return null;
            }
            synchronized (this) {
                this.ga++;
                SoftReference<V> softReferencePut = this.e.put(k, new SoftReference<>(vBf));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.e.put(k, softReferencePut);
                } else {
                    this.bf += d(k, vBf);
                }
            }
            if (v != null) {
                e(false, k, vBf, v);
                return v;
            }
            e(this.d);
            return vBf;
        }
    }

    public final V e(K k, V v) {
        V v2;
        if (k != null && v != null) {
            synchronized (this) {
                this.tg++;
                this.bf += d(k, v);
                SoftReference<V> softReferencePut = this.e.put(k, new SoftReference<>(v));
                if (softReferencePut != null) {
                    v2 = softReferencePut.get();
                    if (v2 != null) {
                        this.bf -= d(k, v2);
                    }
                } else {
                    v2 = null;
                }
            }
            if (v2 != null) {
                e(false, k, v2, v);
            }
            e(this.d);
            return v2;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        android.util.Log.e("LruCache", "oom maybe occured, clear cache. size= " + r5.bf + ", maxSize: " + r6);
        r5.bf = 0;
        r5.e.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0081, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(int r6) {
        /*
            r5 = this;
        L0:
            monitor-enter(r5)
            int r0 = r5.bf     // Catch: java.lang.Throwable -> L82
            if (r0 < 0) goto L58
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r5.e     // Catch: java.lang.Throwable -> L82
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L12
            int r0 = r5.bf     // Catch: java.lang.Throwable -> L82
            if (r0 == 0) goto L12
            goto L58
        L12:
            int r0 = r5.bf     // Catch: java.lang.Throwable -> L82
            if (r0 > r6) goto L18
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
            goto L81
        L18:
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r5.e     // Catch: java.lang.Throwable -> L82
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L82
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L82
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L82
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L82
            if (r0 != 0) goto L2c
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
            goto L81
        L2c:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L82
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L82
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0     // Catch: java.lang.Throwable -> L82
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r2 = r5.e     // Catch: java.lang.Throwable -> L82
            r2.remove(r1)     // Catch: java.lang.Throwable -> L82
            r2 = 0
            if (r0 == 0) goto L4c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L82
            int r3 = r5.bf     // Catch: java.lang.Throwable -> L82
            int r4 = r5.d(r1, r0)     // Catch: java.lang.Throwable -> L82
            int r3 = r3 - r4
            r5.bf = r3     // Catch: java.lang.Throwable -> L82
            goto L4d
        L4c:
            r0 = r2
        L4d:
            int r3 = r5.vn     // Catch: java.lang.Throwable -> L82
            r4 = 1
            int r3 = r3 + r4
            r5.vn = r3     // Catch: java.lang.Throwable -> L82
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
            r5.e(r4, r1, r0, r2)
            goto L0
        L58:
            java.lang.String r0 = "LruCache"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L82
            r1.<init>()     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = "oom maybe occured, clear cache. size= "
            r1.append(r2)     // Catch: java.lang.Throwable -> L82
            int r2 = r5.bf     // Catch: java.lang.Throwable -> L82
            r1.append(r2)     // Catch: java.lang.Throwable -> L82
            java.lang.String r2 = ", maxSize: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L82
            r1.append(r6)     // Catch: java.lang.Throwable -> L82
            java.lang.String r6 = r1.toString()     // Catch: java.lang.Throwable -> L82
            android.util.Log.e(r0, r6)     // Catch: java.lang.Throwable -> L82
            r6 = 0
            r5.bf = r6     // Catch: java.lang.Throwable -> L82
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r6 = r5.e     // Catch: java.lang.Throwable -> L82
            r6.clear()     // Catch: java.lang.Throwable -> L82
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
        L81:
            return
        L82:
            r6 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L82
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ga.d.e.d.e(int):void");
    }
}
