package com.yuewen;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class h51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<Integer> f11940a = new HashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11941b = 0;
    public a c;

    public interface a {
        void a();
    }

    public void a(int i) {
        this.f11940a.remove(Integer.valueOf(i));
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public a b() {
        return this.c;
    }

    public boolean c() {
        return !this.f11940a.isEmpty();
    }

    public int d() {
        int i = this.f11941b;
        this.f11941b = i + 1;
        return i;
    }

    public void e(int i) {
        this.f11940a.add(Integer.valueOf(i));
        a aVar = this.c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void f(a aVar) {
        this.c = aVar;
    }
}
