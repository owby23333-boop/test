package com.bytedance.adsdk.lottie;

import com.iflytek.aikit.media.param.MscKeys;
import java.util.LinkedHashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class l<K, V> {
    private int bf;
    private int d;
    private final LinkedHashMap<K, V> e;
    private int ga;
    private int p;
    private int tg;
    private int v;
    private int vn;

    public l(int i) {
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
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.d), Integer.valueOf(this.p), Integer.valueOf(this.v), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public V bf(K k) {
        return null;
    }

    public final V e(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.e.get(k);
            if (v != null) {
                this.p++;
                return v;
            }
            this.v++;
            V vBf = bf(k);
            if (vBf == null) {
                return null;
            }
            synchronized (this) {
                this.ga++;
                vPut = this.e.put(k, vBf);
                if (vPut != null) {
                    this.e.put(k, vPut);
                } else {
                    this.bf += d(k, vBf);
                }
            }
            if (vPut != null) {
                e(false, k, vBf, vPut);
                return vPut;
            }
            e(this.d);
            return vBf;
        }
    }

    public final V e(K k, V v) {
        V vPut;
        if (k != null && v != null) {
            synchronized (this) {
                this.tg++;
                this.bf += d(k, v);
                vPut = this.e.put(k, v);
                if (vPut != null) {
                    this.bf -= d(k, vPut);
                }
            }
            if (vPut != null) {
                e(false, k, vPut, v);
            }
            e(this.d);
            return vPut;
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(int r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            int r0 = r4.bf     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L52
            java.util.LinkedHashMap<K, V> r0 = r4.e     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r4.bf     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L52
        L11:
            int r0 = r4.bf     // Catch: java.lang.Throwable -> L71
            if (r0 <= r5) goto L50
            java.util.LinkedHashMap<K, V> r0 = r4.e     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L50
        L1e:
            java.util.LinkedHashMap<K, V> r0 = r4.e     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<K, V> r2 = r4.e     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r4.bf     // Catch: java.lang.Throwable -> L71
            int r3 = r4.d(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r3
            r4.bf = r2     // Catch: java.lang.Throwable -> L71
            int r2 = r4.vn     // Catch: java.lang.Throwable -> L71
            r3 = 1
            int r2 = r2 + r3
            r4.vn = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            r2 = 0
            r4.e(r3, r1, r0, r2)
            goto L0
        L50:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            return
        L52:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r5     // Catch: java.lang.Throwable -> L71
        L71:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L71
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.l.e(int):void");
    }
}
