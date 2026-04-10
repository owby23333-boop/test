package com.kwad.components.core.k;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private CopyOnWriteArrayList<b> Rl = new CopyOnWriteArrayList<>();
    private volatile boolean Rm;

    public interface c {
        void bF();
    }

    /* JADX INFO: renamed from: com.kwad.components.core.k.a$a, reason: collision with other inner class name */
    static final class C0339a {
        private static final a Rn = new a();
    }

    public static a qp() {
        return C0339a.Rn;
    }

    public static class b {
        private final c Ro;
        public boolean Rp;

        public b(c cVar) {
            this.Ro = cVar;
        }
    }

    public final void a(b bVar) {
        if (this.Rl.contains(bVar)) {
            return;
        }
        if (!this.Rm) {
            this.Rm = true;
            bVar.Rp = true;
        }
        this.Rl.add(bVar);
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.Rp;
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.Rp) {
            bVar.Rp = false;
            this.Rm = false;
        }
        this.Rl.remove(bVar);
        if (this.Rl.size() == 0 || this.Rm) {
            return;
        }
        this.Rl.get(0).Rp = true;
        this.Rm = true;
        this.Rl.get(0).Ro.bF();
    }
}
