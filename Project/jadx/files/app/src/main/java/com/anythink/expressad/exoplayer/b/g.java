package com.anythink.expressad.exoplayer.b;

import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface g {

    public static final class a {

        @Nullable
        private final Handler a;

        @Nullable
        private final g b;

        public a(@Nullable Handler handler, @Nullable g gVar) {
            this.a = gVar != null ? (Handler) com.anythink.expressad.exoplayer.k.a.a(handler) : null;
            this.b = gVar;
        }

        public final void b(final com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.d(dVar);
                    }
                });
            }
        }

        public final void a(final com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.c(dVar);
                    }
                });
            }
        }

        public final void a(final String str, final long j2, final long j3) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.b(str, j2, j3);
                    }
                });
            }
        }

        public final void a(final com.anythink.expressad.exoplayer.m mVar) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.b(mVar);
                    }
                });
            }
        }

        public final void a(final int i2, final long j2, final long j3) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i2, j2, j3);
                    }
                });
            }
        }

        public final void a(final int i2) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i2);
                    }
                });
            }
        }
    }

    void a(int i2);

    void a(int i2, long j2, long j3);

    void b(com.anythink.expressad.exoplayer.m mVar);

    void b(String str, long j2, long j3);

    void c(com.anythink.expressad.exoplayer.c.d dVar);

    void d(com.anythink.expressad.exoplayer.c.d dVar);
}
