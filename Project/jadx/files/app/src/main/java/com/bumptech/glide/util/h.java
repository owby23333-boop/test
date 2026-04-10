package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class h<T, Y> {
    private final Map<T, a<Y>> a = new LinkedHashMap(100, 0.75f, true);
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f13898c;

    /* JADX INFO: compiled from: LruCache.java */
    static final class a<Y> {
        final Y a;
        final int b;

        a(Y y2, int i2) {
            this.a = y2;
            this.b = i2;
        }
    }

    public h(long j2) {
        this.b = j2;
    }

    @Nullable
    public synchronized Y a(@NonNull T t2) {
        a<Y> aVar;
        aVar = this.a.get(t2);
        return aVar != null ? aVar.a : null;
    }

    protected void a(@NonNull T t2, @Nullable Y y2) {
    }

    protected int b(@Nullable Y y2) {
        return 1;
    }

    public synchronized long b() {
        return this.b;
    }

    @Nullable
    public synchronized Y c(@NonNull T t2) {
        a<Y> aVarRemove = this.a.remove(t2);
        if (aVarRemove == null) {
            return null;
        }
        this.f13898c -= (long) aVarRemove.b;
        return aVarRemove.a;
    }

    @Nullable
    public synchronized Y b(@NonNull T t2, @Nullable Y y2) {
        int iB = b(y2);
        long j2 = iB;
        if (j2 >= this.b) {
            a(t2, y2);
            return null;
        }
        if (y2 != null) {
            this.f13898c += j2;
        }
        a<Y> aVarPut = this.a.put(t2, y2 == null ? null : new a<>(y2, iB));
        if (aVarPut != null) {
            this.f13898c -= (long) aVarPut.b;
            if (!aVarPut.a.equals(y2)) {
                a(t2, aVarPut.a);
            }
        }
        c();
        return aVarPut != null ? aVarPut.a : null;
    }

    public void a() {
        a(0L);
    }

    protected synchronized void a(long j2) {
        while (this.f13898c > j2) {
            Iterator<Map.Entry<T, a<Y>>> it = this.a.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.f13898c -= (long) value.b;
            T key = next.getKey();
            it.remove();
            a(key, value.a);
        }
    }

    private void c() {
        a(this.b);
    }
}
