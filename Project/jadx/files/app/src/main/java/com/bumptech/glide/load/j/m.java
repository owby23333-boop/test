package com.bumptech.glide.load.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* JADX INFO: compiled from: ModelCache.java */
/* JADX INFO: loaded from: classes2.dex */
public class m<A, B> {
    private final com.bumptech.glide.util.h<b<A>, B> a;

    /* JADX INFO: compiled from: ModelCache.java */
    class a extends com.bumptech.glide.util.h<b<A>, B> {
        a(m mVar, long j2) {
            super(j2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.util.h
        public void a(@NonNull b<A> bVar, @Nullable B b) {
            bVar.a();
        }
    }

    public m(long j2) {
        this.a = new a(this, j2);
    }

    @Nullable
    public B a(A a2, int i2, int i3) {
        b<A> bVarA = b.a(a2, i2, i3);
        B bA = this.a.a(bVarA);
        bVarA.a();
        return bA;
    }

    public void a(A a2, int i2, int i3, B b2) {
        this.a.b(b.a(a2, i2, i3), b2);
    }

    /* JADX INFO: compiled from: ModelCache.java */
    @VisibleForTesting
    static final class b<A> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f13679d = com.bumptech.glide.util.l.a(0);
        private int a;
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private A f13680c;

        private b() {
        }

        static <A> b<A> a(A a, int i2, int i3) {
            b<A> bVar;
            synchronized (f13679d) {
                bVar = (b) f13679d.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a, i2, i3);
            return bVar;
        }

        private void b(A a, int i2, int i3) {
            this.f13680c = a;
            this.b = i2;
            this.a = i3;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && this.a == bVar.a && this.f13680c.equals(bVar.f13680c);
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.f13680c.hashCode();
        }

        public void a() {
            synchronized (f13679d) {
                f13679d.offer(this);
            }
        }
    }
}
