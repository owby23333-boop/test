package com.anythink.expressad.exoplayer.l;

import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.m;

/* JADX INFO: loaded from: classes2.dex */
public interface h {

    public static final class a {

        @Nullable
        private final Handler a;

        @Nullable
        private final h b;

        public a(@Nullable Handler handler, @Nullable h hVar) {
            this.a = hVar != null ? (Handler) com.anythink.expressad.exoplayer.k.a.a(handler) : null;
            this.b = hVar;
        }

        public final void b(final com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.b(dVar);
                    }
                });
            }
        }

        public final void a(final com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(dVar);
                    }
                });
            }
        }

        public final void a(final String str, final long j2, final long j3) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(str, j2, j3);
                    }
                });
            }
        }

        public final void a(final m mVar) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(mVar);
                    }
                });
            }
        }

        public final void a(final int i2, final long j2) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i2, j2);
                    }
                });
            }
        }

        public final void a(final int i2, final int i3, final int i4, final float f2) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i2, i3, i4, f2);
                    }
                });
            }
        }

        public final void a(final Surface surface) {
            if (this.b != null) {
                this.a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(surface);
                    }
                });
            }
        }
    }

    void a(int i2, int i3, int i4, float f2);

    void a(int i2, long j2);

    void a(Surface surface);

    void a(com.anythink.expressad.exoplayer.c.d dVar);

    void a(m mVar);

    void a(String str, long j2, long j3);

    void b(com.anythink.expressad.exoplayer.c.d dVar);
}
