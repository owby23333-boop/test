package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f822a;
    long dl;
    ArrayList<RecyclerView> g = new ArrayList<>();
    private ArrayList<g> m = new ArrayList<>();
    static final ThreadLocal<a> z = new ThreadLocal<>();
    static Comparator<g> gc = new Comparator<g>() { // from class: com.bytedance.sdk.component.widget.recycler.a.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            if ((gVar.f823a == null) != (gVar2.f823a == null)) {
                return gVar.f823a == null ? 1 : -1;
            }
            if (gVar.z != gVar2.z) {
                return gVar.z ? -1 : 1;
            }
            int i = gVar2.g - gVar.g;
            if (i != 0) {
                return i;
            }
            int i2 = gVar.dl - gVar2.dl;
            if (i2 != 0) {
                return i2;
            }
            return 0;
        }
    };

    a() {
    }

    public void z(RecyclerView recyclerView) {
        this.g.add(recyclerView);
    }

    public void g(RecyclerView recyclerView) {
        this.g.remove(recyclerView);
    }

    void z(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.dl == 0) {
            this.dl = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.l.z(i, i2);
    }

    private void z() {
        g gVar;
        int size = this.g.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.g.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.l.z(recyclerView, false);
                i += recyclerView.l.f824a;
            }
        }
        this.m.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.g.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                z zVar = recyclerView2.l;
                int iAbs = Math.abs(zVar.z) + Math.abs(zVar.g);
                for (int i5 = 0; i5 < zVar.f824a * 2; i5 += 2) {
                    if (i3 >= this.m.size()) {
                        gVar = new g();
                        this.m.add(gVar);
                    } else {
                        gVar = this.m.get(i3);
                    }
                    int i6 = zVar.dl[i5 + 1];
                    gVar.z = i6 <= iAbs;
                    gVar.g = iAbs;
                    gVar.dl = i6;
                    gVar.f823a = recyclerView2;
                    gVar.gc = zVar.dl[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.m, gc);
    }

    static boolean z(RecyclerView recyclerView, int i) {
        int iDl = recyclerView.e.dl();
        for (int i2 = 0; i2 < iDl; i2++) {
            RecyclerView.zw zwVarGc = RecyclerView.gc(recyclerView.e.a(i2));
            if (zwVarGc.dl == i && !zwVarGc.v()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.zw z(RecyclerView recyclerView, int i, long j) {
        if (z(recyclerView, i)) {
            return null;
        }
        RecyclerView.ls lsVar = recyclerView.gc;
        try {
            recyclerView.wp();
            RecyclerView.zw zwVarZ = lsVar.z(i, false, j);
            if (zwVarZ != null) {
                if (zwVarZ.ls() && !zwVarZ.v()) {
                    lsVar.z(zwVarZ.z);
                } else {
                    lsVar.z(zwVarZ, false);
                }
            }
            return zwVarZ;
        } finally {
            recyclerView.g(false);
        }
    }

    private void z(RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.zw && recyclerView.e.dl() != 0) {
                recyclerView.dl();
            }
            z zVar = recyclerView.l;
            zVar.z(recyclerView, true);
            if (zVar.f824a != 0) {
                try {
                    com.bytedance.sdk.component.widget.recycler.z.z.z.z("RV Nested Prefetch");
                    recyclerView.h.z(recyclerView.i);
                    for (int i = 0; i < zVar.f824a * 2; i += 2) {
                        z(recyclerView, zVar.dl[i], j);
                    }
                } finally {
                    com.bytedance.sdk.component.widget.recycler.z.z.z.z();
                }
            }
        }
    }

    private void z(g gVar, long j) {
        RecyclerView.zw zwVarZ = z(gVar.f823a, gVar.gc, gVar.z ? Long.MAX_VALUE : j);
        if (zwVarZ == null || zwVarZ.g == null || !zwVarZ.ls() || zwVarZ.v()) {
            return;
        }
        z(zwVarZ.g.get(), j);
    }

    private void g(long j) {
        for (int i = 0; i < this.m.size(); i++) {
            g gVar = this.m.get(i);
            if (gVar.f823a == null) {
                return;
            }
            z(gVar, j);
            gVar.z();
        }
    }

    void z(long j) {
        z();
        g(j);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.bytedance.sdk.component.widget.recycler.z.z.z.z("RV Prefetch");
            if (!this.g.isEmpty()) {
                int size = this.g.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.g.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    z(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f822a);
                }
            }
        } finally {
            this.dl = 0L;
            com.bytedance.sdk.component.widget.recycler.z.z.z.z();
        }
    }

    static class z implements RecyclerView.fo.z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f824a;
        int[] dl;
        int g;
        int z;

        z() {
        }

        void z(int i, int i2) {
            this.z = i;
            this.g = i2;
        }

        void z(RecyclerView recyclerView, boolean z) {
            this.f824a = 0;
            int[] iArr = this.dl;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.fo foVar = recyclerView.v;
            if (recyclerView.i == null || foVar == null || !foVar.v()) {
                return;
            }
            if (z) {
                if (!recyclerView.m.a()) {
                    foVar.z(recyclerView.i.z(), this);
                }
            } else if (!recyclerView.q()) {
                foVar.z(this.z, this.g, recyclerView.h, this);
            }
            if (this.f824a > foVar.ls) {
                foVar.ls = this.f824a;
                foVar.p = z;
                recyclerView.gc.g();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.fo.z
        public void g(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.f824a * 2;
            int[] iArr = this.dl;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.dl = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.dl = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.dl;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.f824a++;
        }

        boolean z(int i) {
            if (this.dl != null) {
                int i2 = this.f824a * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.dl[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void z() {
            int[] iArr = this.dl;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f824a = 0;
        }
    }

    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RecyclerView f823a;
        public int dl;
        public int g;
        public int gc;
        public boolean z;

        g() {
        }

        public void z() {
            this.z = false;
            this.g = 0;
            this.dl = 0;
            this.f823a = null;
            this.gc = 0;
        }
    }
}
