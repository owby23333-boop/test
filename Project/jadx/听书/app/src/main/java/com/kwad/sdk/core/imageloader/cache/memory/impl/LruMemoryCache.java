package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.utils.ax;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class LruMemoryCache implements MemoryCache {
    private final LinkedHashMap<String, DecodedResult> map;
    private final int maxSize;
    private int size;

    public LruMemoryCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult get(String str) {
        DecodedResult decodedResult;
        ax.ax(str, "key");
        synchronized (this) {
            decodedResult = this.map.get(str);
        }
        return decodedResult;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final boolean put(String str, DecodedResult decodedResult) {
        ax.ax(str, "key");
        ax.g(decodedResult, "value");
        synchronized (this) {
            this.size += sizeOf(str, decodedResult);
            DecodedResult decodedResultPut = this.map.put(str, decodedResult);
            if (decodedResultPut != null) {
                this.size -= sizeOf(str, decodedResultPut);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trimToSize(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.size     // Catch: java.lang.Throwable -> L71
            if (r0 < 0) goto L50
            java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.core.decode.DecodedResult> r0 = r3.map     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L11
            int r0 = r3.size     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L50
        L11:
            int r0 = r3.size     // Catch: java.lang.Throwable -> L71
            if (r0 <= r4) goto L4e
            java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.core.decode.DecodedResult> r0 = r3.map     // Catch: java.lang.Throwable -> L71
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L71
            if (r0 == 0) goto L1e
            goto L4e
        L1e:
            java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.core.decode.DecodedResult> r0 = r3.map     // Catch: java.lang.Throwable -> L71
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L71
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L71
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L71
            if (r0 != 0) goto L32
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            return
        L32:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L71
            com.kwad.sdk.core.imageloader.core.decode.DecodedResult r0 = (com.kwad.sdk.core.imageloader.core.decode.DecodedResult) r0     // Catch: java.lang.Throwable -> L71
            java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.core.decode.DecodedResult> r2 = r3.map     // Catch: java.lang.Throwable -> L71
            r2.remove(r1)     // Catch: java.lang.Throwable -> L71
            int r2 = r3.size     // Catch: java.lang.Throwable -> L71
            int r0 = r3.sizeOf(r1, r0)     // Catch: java.lang.Throwable -> L71
            int r2 = r2 - r0
            r3.size = r2     // Catch: java.lang.Throwable -> L71
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            goto L0
        L4e:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            return
        L50:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L71
            r0.<init>()     // Catch: java.lang.Throwable -> L71
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L71
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L71
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L71
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L71
            throw r4     // Catch: java.lang.Throwable -> L71
        L71:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L71
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.memory.impl.LruMemoryCache.trimToSize(int):void");
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult remove(String str) {
        DecodedResult decodedResultRemove;
        ax.ax(str, "key");
        synchronized (this) {
            decodedResultRemove = this.map.remove(str);
            if (decodedResultRemove != null) {
                this.size -= sizeOf(str, decodedResultRemove);
            }
        }
        return decodedResultRemove;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        trimToSize(-1);
    }

    private int sizeOf(String str, DecodedResult decodedResult) {
        return decodedResult.getByteSize();
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.maxSize));
    }
}
