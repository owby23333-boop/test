package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.z.g.a;

/* JADX INFO: loaded from: classes2.dex */
class v {
    final com.bytedance.sdk.component.widget.recycler.z.g.z<RecyclerView.zw, z> z = new com.bytedance.sdk.component.widget.recycler.z.g.z<>();
    final com.bytedance.sdk.component.widget.recycler.z.g.dl<RecyclerView.zw> g = new com.bytedance.sdk.component.widget.recycler.z.g.dl<>();

    interface g {
        void dl(RecyclerView.zw zwVar, RecyclerView.m.g gVar, RecyclerView.m.g gVar2);

        void g(RecyclerView.zw zwVar, RecyclerView.m.g gVar, RecyclerView.m.g gVar2);

        void z(RecyclerView.zw zwVar);

        void z(RecyclerView.zw zwVar, RecyclerView.m.g gVar, RecyclerView.m.g gVar2);
    }

    v() {
    }

    void z() {
        this.z.clear();
        this.g.dl();
    }

    void z(RecyclerView.zw zwVar, RecyclerView.m.g gVar) {
        z zVarZ = this.z.get(zwVar);
        if (zVarZ == null) {
            zVarZ = z.z();
            this.z.put(zwVar, zVarZ);
        }
        zVarZ.g = gVar;
        zVarZ.z |= 4;
    }

    boolean z(RecyclerView.zw zwVar) {
        z zVar = this.z.get(zwVar);
        return (zVar == null || (zVar.z & 1) == 0) ? false : true;
    }

    RecyclerView.m.g g(RecyclerView.zw zwVar) {
        return z(zwVar, 4);
    }

    RecyclerView.m.g dl(RecyclerView.zw zwVar) {
        return z(zwVar, 8);
    }

    private RecyclerView.m.g z(RecyclerView.zw zwVar, int i) {
        z zVarG;
        RecyclerView.m.g gVar;
        int iZ = this.z.z(zwVar);
        if (iZ < 0 || (zVarG = this.z.g(iZ)) == null || (zVarG.z & i) == 0) {
            return null;
        }
        zVarG.z &= ~i;
        if (i == 4) {
            gVar = zVarG.g;
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Must provide flag PRE or POST");
            }
            gVar = zVarG.dl;
        }
        if ((zVarG.z & 12) == 0) {
            this.z.dl(iZ);
            z.z(zVarG);
        }
        return gVar;
    }

    void z(long j, RecyclerView.zw zwVar) {
        this.g.g(j, zwVar);
    }

    void g(RecyclerView.zw zwVar, RecyclerView.m.g gVar) {
        z zVarZ = this.z.get(zwVar);
        if (zVarZ == null) {
            zVarZ = z.z();
            this.z.put(zwVar, zVarZ);
        }
        zVarZ.z |= 2;
        zVarZ.g = gVar;
    }

    boolean a(RecyclerView.zw zwVar) {
        z zVar = this.z.get(zwVar);
        return (zVar == null || (zVar.z & 4) == 0) ? false : true;
    }

    RecyclerView.zw z(long j) {
        return this.g.z(j);
    }

    void dl(RecyclerView.zw zwVar, RecyclerView.m.g gVar) {
        z zVarZ = this.z.get(zwVar);
        if (zVarZ == null) {
            zVarZ = z.z();
            this.z.put(zwVar, zVarZ);
        }
        zVarZ.dl = gVar;
        zVarZ.z |= 8;
    }

    void gc(RecyclerView.zw zwVar) {
        z zVarZ = this.z.get(zwVar);
        if (zVarZ == null) {
            zVarZ = z.z();
            this.z.put(zwVar, zVarZ);
        }
        zVarZ.z |= 1;
    }

    void m(RecyclerView.zw zwVar) {
        z zVar = this.z.get(zwVar);
        if (zVar != null) {
            zVar.z &= -2;
        }
    }

    void z(g gVar) {
        for (int size = this.z.size() - 1; size >= 0; size--) {
            RecyclerView.zw zwVarZ = this.z.z(size);
            z zVarDl = this.z.dl(size);
            if ((zVarDl.z & 3) == 3) {
                gVar.z(zwVarZ);
            } else if ((zVarDl.z & 1) != 0) {
                if (zVarDl.g == null) {
                    gVar.z(zwVarZ);
                } else {
                    gVar.z(zwVarZ, zVarDl.g, zVarDl.dl);
                }
            } else if ((zVarDl.z & 14) == 14) {
                gVar.g(zwVarZ, zVarDl.g, zVarDl.dl);
            } else if ((zVarDl.z & 12) == 12) {
                gVar.dl(zwVarZ, zVarDl.g, zVarDl.dl);
            } else if ((zVarDl.z & 4) != 0) {
                gVar.z(zwVarZ, zVarDl.g, null);
            } else if ((zVarDl.z & 8) != 0) {
                gVar.g(zwVarZ, zVarDl.g, zVarDl.dl);
            }
            z.z(zVarDl);
        }
    }

    void e(RecyclerView.zw zwVar) {
        int iG = this.g.g() - 1;
        while (true) {
            if (iG < 0) {
                break;
            }
            if (zwVar == this.g.dl(iG)) {
                this.g.z(iG);
                break;
            }
            iG--;
        }
        z zVarRemove = this.z.remove(zwVar);
        if (zVarRemove != null) {
            z.z(zVarRemove);
        }
    }

    void g() {
        z.g();
    }

    public void gz(RecyclerView.zw zwVar) {
        m(zwVar);
    }

    static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static a.z<z> f839a = new a.g(20);
        RecyclerView.m.g dl;
        RecyclerView.m.g g;
        int z;

        private z() {
        }

        static z z() {
            z zVarZ = f839a.z();
            return zVarZ == null ? new z() : zVarZ;
        }

        static void z(z zVar) {
            zVar.z = 0;
            zVar.g = null;
            zVar.dl = null;
            f839a.z(zVar);
        }

        static void g() {
            while (f839a.z() != null) {
            }
        }
    }
}
