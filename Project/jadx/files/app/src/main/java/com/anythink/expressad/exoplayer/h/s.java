package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface s {

    public static final class a {
        public final int a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f9419d;

        public a(int i2) {
            this(i2, -1L);
        }

        public final a a(int i2) {
            return this.a == i2 ? this : new a(i2, this.b, this.f9418c, this.f9419d);
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.a == aVar.a && this.b == aVar.b && this.f9418c == aVar.f9418c && this.f9419d == aVar.f9419d) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ((((((this.a + 527) * 31) + this.b) * 31) + this.f9418c) * 31) + ((int) this.f9419d);
        }

        public a(int i2, long j2) {
            this(i2, -1, -1, j2);
        }

        public a(int i2, int i3, int i4, long j2) {
            this.a = i2;
            this.b = i3;
            this.f9418c = i4;
            this.f9419d = j2;
        }

        public final boolean a() {
            return this.b != -1;
        }
    }

    public interface b {
        void a(s sVar, com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj);
    }

    r a(a aVar, com.anythink.expressad.exoplayer.j.b bVar);

    void a(Handler handler, t tVar);

    void a(r rVar);

    void a(b bVar);

    void a(t tVar);

    void a(com.anythink.expressad.exoplayer.h hVar, boolean z2, b bVar);

    void b();
}
