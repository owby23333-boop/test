package com.yuewen;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ta4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17923b = 0;
    public static final int c = 1;
    public static final int d = 2;
    public static kv3<ta4> e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<d> f17924a = new LinkedList<>();

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17925a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f17926b = 0;
        public long c = 0;
        public long d = 0;
        public boolean e = true;

        public int a(long j) {
            int i = this.f17925a > j ? 1 : 0;
            if (this.f17926b > j) {
                i++;
            }
            return this.c > j ? i + 1 : i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f17925a == bVar.f17925a && this.f17926b == bVar.f17926b && this.c == bVar.c;
        }
    }

    public interface c {
        void g2(b bVar);
    }

    public interface d {
        void H0(ob4 ob4Var);
    }

    public static ta4 i() {
        kv3<ta4> kv3Var = e;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void w(kv3<ta4> kv3Var) {
        e = kv3Var;
    }

    public abstract void g(c cVar);

    public void h(d dVar) {
        this.f17924a.add(dVar);
    }

    public abstract long j();

    public abstract b k();

    public abstract ob4 l();

    public abstract long m();

    public abstract boolean o();

    public abstract boolean p();

    public abstract boolean q();

    public abstract void r();

    public abstract void s();

    public abstract void u(c cVar);

    public void v(d dVar) {
        this.f17924a.remove(dVar);
    }
}
