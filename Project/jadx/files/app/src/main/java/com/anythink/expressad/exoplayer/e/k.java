package com.anythink.expressad.exoplayer.e;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface k {

    public static final class a {
        public final l a;
        public final l b;

        public a(l lVar) {
            this(lVar, lVar);
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.a.equals(aVar.a) && this.b.equals(aVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.a);
            if (this.a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }

        public a(l lVar, l lVar2) {
            this.a = (l) com.anythink.expressad.exoplayer.k.a.a(lVar);
            this.b = (l) com.anythink.expressad.exoplayer.k.a.a(lVar2);
        }
    }

    public static final class b implements k {
        private final long a;
        private final a b;

        private b(long j2) {
            this(j2, 0L);
        }

        @Override // com.anythink.expressad.exoplayer.e.k
        public final a a(long j2) {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.e.k
        public final boolean a() {
            return false;
        }

        @Override // com.anythink.expressad.exoplayer.e.k
        public final long b() {
            return this.a;
        }

        public b(long j2, long j3) {
            this.a = j2;
            this.b = new a(j3 == 0 ? l.a : new l(0L, j3));
        }
    }

    a a(long j2);

    boolean a();

    long b();
}
