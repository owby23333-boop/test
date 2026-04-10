package com.kwad.components.core.h;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private CopyOnWriteArrayList<b> JY = new CopyOnWriteArrayList<>();
    private volatile boolean JZ;

    /* JADX INFO: renamed from: com.kwad.components.core.h.a$a, reason: collision with other inner class name */
    static final class C0400a {
        private static final a Ka = new a();
    }

    public static class b {
        private final c Kb;
        public boolean Kc;

        public b(c cVar) {
            this.Kb = cVar;
        }
    }

    public interface c {
        void bs();
    }

    public static boolean b(b bVar) {
        if (bVar == null) {
            return true;
        }
        return bVar.Kc;
    }

    public static a nX() {
        return C0400a.Ka;
    }

    public final void a(b bVar) {
        if (this.JY.contains(bVar)) {
            return;
        }
        if (!this.JZ) {
            this.JZ = true;
            bVar.Kc = true;
        }
        this.JY.add(bVar);
    }

    public final void c(b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar.Kc) {
            bVar.Kc = false;
            this.JZ = false;
        }
        this.JY.remove(bVar);
        if (this.JY.size() == 0 || this.JZ) {
            return;
        }
        this.JY.get(0).Kc = true;
        this.JZ = true;
        this.JY.get(0).Kb.bs();
    }
}
