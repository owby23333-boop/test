package com.yuewen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class r9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f16984a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Long> f16985b = new HashSet();
    public final Set<Long> c = new HashSet();

    public String a() {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = this.f16984a.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(',');
        }
        return sb.toString();
    }

    public String b() {
        StringBuilder sb = new StringBuilder();
        Iterator<Long> it = this.f16985b.iterator();
        while (it.hasNext()) {
            sb.append(it.next().longValue());
            sb.append(',');
        }
        return sb.toString();
    }

    public void c() {
        this.f16984a.clear();
        this.f16985b.clear();
    }

    public boolean d(long j) {
        return this.c.contains(Long.valueOf(j));
    }

    public void e(String str) {
        this.f16984a.add(str);
    }

    public void f(long j) {
        this.f16985b.add(Long.valueOf(j));
        this.c.add(Long.valueOf(j));
    }
}
