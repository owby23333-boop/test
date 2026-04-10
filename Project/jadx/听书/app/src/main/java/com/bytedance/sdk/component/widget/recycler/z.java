package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.e;
import com.bytedance.sdk.component.widget.recycler.z.g.a;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class z implements e.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Runnable f840a;
    final InterfaceC0145z dl;
    private a.z<g> e;
    final ArrayList<g> g;
    final boolean gc;
    private int gz;
    final e m;
    final ArrayList<g> z;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.widget.recycler.z$z, reason: collision with other inner class name */
    interface InterfaceC0145z {
        void a(int i, int i2);

        void dl(int i, int i2);

        void g(int i, int i2);

        RecyclerView.zw z(int i);

        void z(int i, int i2);

        void z(int i, int i2, Object obj);
    }

    z(InterfaceC0145z interfaceC0145z) {
        this(interfaceC0145z, false);
    }

    z(InterfaceC0145z interfaceC0145z, boolean z) {
        this.e = new a.g(30);
        this.z = new ArrayList<>();
        this.g = new ArrayList<>();
        this.gz = 0;
        this.dl = interfaceC0145z;
        this.gc = z;
        this.m = new e(this);
    }

    void z() {
        z(this.z);
        z(this.g);
        this.gz = 0;
    }

    void g() {
        this.m.z(this.z);
        int size = this.z.size();
        for (int i = 0; i < size; i++) {
            g gVar = this.z.get(i);
            int i2 = gVar.z;
            if (i2 == 1) {
                m(gVar);
            } else if (i2 == 2) {
                dl(gVar);
            } else if (i2 == 4) {
                a(gVar);
            } else if (i2 == 8) {
                g(gVar);
            }
            Runnable runnable = this.f840a;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.z.clear();
    }

    void dl() {
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            this.g.get(i);
        }
        z(this.g);
        this.gz = 0;
    }

    private void g(g gVar) {
        e(gVar);
    }

    private void dl(g gVar) {
        boolean z;
        byte b;
        int i = gVar.g;
        int i2 = gVar.g + gVar.f841a;
        int i3 = gVar.g;
        byte b2 = -1;
        int i4 = 0;
        while (i3 < i2) {
            if (this.dl.z(i3) != null || a(i3)) {
                if (b2 == 0) {
                    gc(z(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 1;
            } else {
                if (b2 == 1) {
                    e(z(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b2 = b;
        }
        if (i4 != gVar.f841a) {
            z(gVar);
            gVar = z(2, i, i4, null);
        }
        if (b2 == 0) {
            gc(gVar);
        } else {
            e(gVar);
        }
    }

    private void a(g gVar) {
        int i = gVar.g;
        int i2 = gVar.g + gVar.f841a;
        byte b = -1;
        int i3 = 0;
        for (int i4 = gVar.g; i4 < i2; i4++) {
            if (this.dl.z(i4) != null || a(i4)) {
                if (b == 0) {
                    gc(z(4, i, i3, gVar.dl));
                    i = i4;
                    i3 = 0;
                }
                b = 1;
            } else {
                if (b == 1) {
                    e(z(4, i, i3, gVar.dl));
                    i = i4;
                    i3 = 0;
                }
                b = 0;
            }
            i3++;
        }
        if (i3 != gVar.f841a) {
            Object obj = gVar.dl;
            z(gVar);
            gVar = z(4, i, i3, obj);
        }
        if (b == 0) {
            gc(gVar);
        } else {
            e(gVar);
        }
    }

    private void gc(g gVar) {
        int i;
        if (gVar.z != 1 && gVar.z != 8) {
            int iG = g(gVar.g, gVar.z);
            int i2 = gVar.g;
            int i3 = gVar.z;
            if (i3 == 2) {
                i = 0;
            } else {
                if (i3 != 4) {
                    throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(gVar)));
                }
                i = 1;
            }
            int i4 = 1;
            for (int i5 = 1; i5 < gVar.f841a; i5++) {
                int iG2 = g(gVar.g + (i * i5), gVar.z);
                int i6 = gVar.z;
                if (i6 == 2 ? iG2 == iG : i6 == 4 && iG2 == iG + 1) {
                    i4++;
                } else {
                    g gVarZ = z(gVar.z, iG, i4, gVar.dl);
                    z(gVarZ, i2);
                    z(gVarZ);
                    if (gVar.z == 4) {
                        i2 += i4;
                    }
                    i4 = 1;
                    iG = iG2;
                }
            }
            Object obj = gVar.dl;
            z(gVar);
            if (i4 > 0) {
                g gVarZ2 = z(gVar.z, iG, i4, obj);
                z(gVarZ2, i2);
                z(gVarZ2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    void z(g gVar, int i) {
        int i2 = gVar.z;
        if (i2 == 2) {
            this.dl.z(i, gVar.f841a);
        } else {
            if (i2 == 4) {
                this.dl.z(i, gVar.f841a, gVar.dl);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int g(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.g.size() - 1; size >= 0; size--) {
            g gVar = this.g.get(size);
            if (gVar.z == 8) {
                if (gVar.g < gVar.f841a) {
                    i3 = gVar.g;
                    i4 = gVar.f841a;
                } else {
                    i3 = gVar.f841a;
                    i4 = gVar.g;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == gVar.g) {
                        if (i2 == 1) {
                            gVar.f841a++;
                        } else if (i2 == 2) {
                            gVar.f841a--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            gVar.g++;
                        } else if (i2 == 2) {
                            gVar.g--;
                        }
                        i--;
                    }
                } else if (i < gVar.g) {
                    if (i2 == 1) {
                        gVar.g++;
                        gVar.f841a++;
                    } else if (i2 == 2) {
                        gVar.g--;
                        gVar.f841a--;
                    }
                }
            } else if (gVar.g <= i) {
                if (gVar.z == 1) {
                    i -= gVar.f841a;
                } else if (gVar.z == 2) {
                    i += gVar.f841a;
                }
            } else if (i2 == 1) {
                gVar.g++;
            } else if (i2 == 2) {
                gVar.g--;
            }
        }
        for (int size2 = this.g.size() - 1; size2 >= 0; size2--) {
            g gVar2 = this.g.get(size2);
            if (gVar2.z == 8) {
                if (gVar2.f841a == gVar2.g || gVar2.f841a < 0) {
                    this.g.remove(size2);
                    z(gVar2);
                }
            } else if (gVar2.f841a <= 0) {
                this.g.remove(size2);
                z(gVar2);
            }
        }
        return i;
    }

    private boolean a(int i) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.g.get(i2);
            if (gVar.z == 8) {
                if (z(gVar.f841a, i2 + 1) == i) {
                    return true;
                }
            } else if (gVar.z == 1) {
                int i3 = gVar.g + gVar.f841a;
                for (int i4 = gVar.g; i4 < i3; i4++) {
                    if (z(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void m(g gVar) {
        e(gVar);
    }

    private void e(g gVar) {
        this.g.add(gVar);
        int i = gVar.z;
        if (i == 1) {
            this.dl.dl(gVar.g, gVar.f841a);
            return;
        }
        if (i == 2) {
            this.dl.g(gVar.g, gVar.f841a);
        } else if (i == 4) {
            this.dl.z(gVar.g, gVar.f841a, gVar.dl);
        } else {
            if (i != 8) {
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(gVar)));
            }
            this.dl.a(gVar.g, gVar.f841a);
        }
    }

    boolean a() {
        return this.z.size() > 0;
    }

    boolean z(int i) {
        return (i & this.gz) != 0;
    }

    int g(int i) {
        return z(i, 0);
    }

    int z(int i, int i2) {
        int size = this.g.size();
        while (i2 < size) {
            g gVar = this.g.get(i2);
            if (gVar.z == 8) {
                if (gVar.g == i) {
                    i = gVar.f841a;
                } else {
                    if (gVar.g < i) {
                        i--;
                    }
                    if (gVar.f841a <= i) {
                        i++;
                    }
                }
            } else if (gVar.g > i) {
                continue;
            } else if (gVar.z == 2) {
                if (i < gVar.g + gVar.f841a) {
                    return -1;
                }
                i -= gVar.f841a;
            } else if (gVar.z == 1) {
                i += gVar.f841a;
            }
            i2++;
        }
        return i;
    }

    boolean z(int i, int i2, Object obj) {
        if (i2 <= 0) {
            return false;
        }
        this.z.add(z(4, i, i2, obj));
        this.gz |= 4;
        return this.z.size() == 1;
    }

    void gc() {
        dl();
        int size = this.z.size();
        for (int i = 0; i < size; i++) {
            g gVar = this.z.get(i);
            int i2 = gVar.z;
            if (i2 == 1) {
                this.dl.dl(gVar.g, gVar.f841a);
            } else if (i2 == 2) {
                this.dl.z(gVar.g, gVar.f841a);
            } else if (i2 == 4) {
                this.dl.z(gVar.g, gVar.f841a, gVar.dl);
            } else if (i2 == 8) {
                this.dl.a(gVar.g, gVar.f841a);
            }
            Runnable runnable = this.f840a;
            if (runnable != null) {
                runnable.run();
            }
        }
        z(this.z);
        this.gz = 0;
    }

    public int dl(int i) {
        int size = this.z.size();
        for (int i2 = 0; i2 < size; i2++) {
            g gVar = this.z.get(i2);
            int i3 = gVar.z;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 8) {
                        if (gVar.g == i) {
                            i = gVar.f841a;
                        } else {
                            if (gVar.g < i) {
                                i--;
                            }
                            if (gVar.f841a <= i) {
                                i++;
                            }
                        }
                    }
                } else if (gVar.g > i) {
                    continue;
                } else {
                    if (gVar.g + gVar.f841a > i) {
                        return -1;
                    }
                    i -= gVar.f841a;
                }
            } else if (gVar.g <= i) {
                i += gVar.f841a;
            }
        }
        return i;
    }

    boolean m() {
        return (this.g.isEmpty() || this.z.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.e.z
    public g z(int i, int i2, int i3, Object obj) {
        g gVarZ = this.e.z();
        if (gVarZ == null) {
            return new g(i, i2, i3, obj);
        }
        gVarZ.z = i;
        gVarZ.g = i2;
        gVarZ.f841a = i3;
        gVarZ.dl = obj;
        return gVarZ;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.e.z
    public void z(g gVar) {
        if (this.gc) {
            return;
        }
        gVar.dl = null;
        this.e.z(gVar);
    }

    void z(List<g> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            z(list.get(i));
        }
        list.clear();
    }

    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f841a;
        Object dl;
        int g;
        int z;

        g(int i, int i2, int i3, Object obj) {
            this.z = i;
            this.g = i2;
            this.f841a = i3;
            this.dl = obj;
        }

        String z() {
            int i = this.z;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : t.w : "add";
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + z() + ",s:" + this.g + "c:" + this.f841a + ",p:" + this.dl + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            g gVar = (g) obj;
            int i = this.z;
            if (i != gVar.z) {
                return false;
            }
            if (i == 8 && Math.abs(this.f841a - this.g) == 1 && this.f841a == gVar.g && this.g == gVar.f841a) {
                return true;
            }
            if (this.f841a != gVar.f841a || this.g != gVar.g) {
                return false;
            }
            Object obj2 = this.dl;
            if (obj2 != null) {
                if (!obj2.equals(gVar.dl)) {
                    return false;
                }
            } else if (gVar.dl != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.z * 31) + this.g) * 31) + this.f841a;
        }
    }
}
