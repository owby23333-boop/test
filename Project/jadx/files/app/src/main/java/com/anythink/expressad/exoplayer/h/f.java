package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.s;
import com.anythink.expressad.exoplayer.h.t;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f<T> extends c {
    private final HashMap<T, b> a = new HashMap<>();
    private com.anythink.expressad.exoplayer.h b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f9318c;

    private static final class b {
        public final s a;
        public final s.b b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final t f9320c;

        public b(s sVar, s.b bVar, t tVar) {
            this.a = sVar;
            this.b = bVar;
            this.f9320c = tVar;
        }
    }

    protected f() {
    }

    protected int a(@Nullable T t2, int i2) {
        return i2;
    }

    protected long a(long j2) {
        return j2;
    }

    @Nullable
    protected s.a a(@Nullable T t2, s.a aVar) {
        return aVar;
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    @CallSuper
    public void a(com.anythink.expressad.exoplayer.h hVar, boolean z2) {
        this.b = hVar;
        this.f9318c = new Handler();
    }

    protected abstract void a(@Nullable T t2, s sVar, com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj);

    @Override // com.anythink.expressad.exoplayer.h.s
    @CallSuper
    public void b() {
        Iterator<b> it = this.a.values().iterator();
        while (it.hasNext()) {
            it.next().a.b();
        }
    }

    private final class a implements t {

        @Nullable
        private final T b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private t.a f9319c;

        public a(@Nullable T t2) {
            this.f9319c = f.this.a((s.a) null);
            this.b = t2;
        }

        private boolean d(int i2, @Nullable s.a aVar) {
            s.a aVarA;
            if (aVar != null) {
                aVarA = f.this.a(this.b, aVar);
                if (aVarA == null) {
                    return false;
                }
            } else {
                aVarA = null;
            }
            int iA = f.this.a(this.b, i2);
            t.a aVar2 = this.f9319c;
            if (aVar2.a == iA && com.anythink.expressad.exoplayer.k.af.a(aVar2.b, aVarA)) {
                return true;
            }
            this.f9319c = f.this.a(iA, aVarA);
            return true;
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i2, s.a aVar) {
            if (d(i2, aVar)) {
                this.f9319c.a();
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void b(int i2, s.a aVar) {
            if (d(i2, aVar)) {
                this.f9319c.b();
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void c(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar) {
            if (d(i2, aVar)) {
                this.f9319c.c(bVar, a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar) {
            if (d(i2, aVar)) {
                this.f9319c.a(bVar, a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void b(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar) {
            if (d(i2, aVar)) {
                this.f9319c.b(bVar, a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void c(int i2, s.a aVar) {
            if (d(i2, aVar)) {
                this.f9319c.c();
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i2, @Nullable s.a aVar, t.b bVar, t.c cVar, IOException iOException, boolean z2) {
            if (d(i2, aVar)) {
                this.f9319c.a(bVar, a(cVar), iOException, z2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void b(int i2, @Nullable s.a aVar, t.c cVar) {
            if (d(i2, aVar)) {
                this.f9319c.b(a(cVar));
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.t
        public final void a(int i2, @Nullable s.a aVar, t.c cVar) {
            if (d(i2, aVar)) {
                this.f9319c.a(a(cVar));
            }
        }

        private t.c a(t.c cVar) {
            long jA = f.this.a(cVar.f9439f);
            long jA2 = f.this.a(cVar.f9440g);
            return (jA == cVar.f9439f && jA2 == cVar.f9440g) ? cVar : new t.c(cVar.a, cVar.b, cVar.f9436c, cVar.f9437d, cVar.f9438e, jA, jA2);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.c
    @CallSuper
    public void a() {
        for (b bVar : this.a.values()) {
            bVar.a.a(bVar.b);
            bVar.a.a(bVar.f9320c);
        }
        this.a.clear();
        this.b = null;
    }

    protected final void a(@Nullable final T t2, s sVar) {
        com.anythink.expressad.exoplayer.k.a.a(!this.a.containsKey(t2));
        s.b bVar = new s.b() { // from class: com.anythink.expressad.exoplayer.h.f.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.anythink.expressad.exoplayer.h.s.b
            public final void a(s sVar2, com.anythink.expressad.exoplayer.ae aeVar, @Nullable Object obj) {
                f.this.a(t2, sVar2, aeVar, obj);
            }
        };
        a aVar = new a(t2);
        this.a.put(t2, new b(sVar, bVar, aVar));
        sVar.a(this.f9318c, aVar);
        sVar.a(this.b, false, bVar);
    }

    protected final void a(@Nullable T t2) {
        b bVarRemove = this.a.remove(t2);
        bVarRemove.a.a(bVarRemove.b);
        bVarRemove.a.a(bVarRemove.f9320c);
    }
}
