package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.e.bf.tg;
import com.bytedance.sdk.component.widget.recycler.p;
import com.yuewen.el2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class e implements p.e {
    final ArrayList<bf> bf;
    final InterfaceC0109e d;
    final ArrayList<bf> e;
    final boolean ga;
    private tg.e<bf> p;
    Runnable tg;
    private int v;
    final p vn;

    public static class bf {
        int bf;
        Object d;
        int e;
        int tg;

        public bf(int i, int i2, int i3, Object obj) {
            this.e = i;
            this.bf = i2;
            this.tg = i3;
            this.d = obj;
        }

        public String e() {
            int i = this.e;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : el2.T8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            bf bfVar = (bf) obj;
            int i = this.e;
            if (i != bfVar.e) {
                return false;
            }
            if (i == 8 && Math.abs(this.tg - this.bf) == 1 && this.tg == bfVar.bf && this.bf == bfVar.tg) {
                return true;
            }
            if (this.tg != bfVar.tg || this.bf != bfVar.bf) {
                return false;
            }
            Object obj2 = this.d;
            if (obj2 != null) {
                if (!obj2.equals(bfVar.d)) {
                    return false;
                }
            } else if (bfVar.d != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.e * 31) + this.bf) * 31) + this.tg;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + e() + ",s:" + this.bf + "c:" + this.tg + ",p:" + this.d + "]";
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.widget.recycler.e$e, reason: collision with other inner class name */
    public interface InterfaceC0109e {
        void bf(int i, int i2);

        void bf(bf bfVar);

        void d(int i, int i2);

        RecyclerView.cv e(int i);

        void e(int i, int i2);

        void e(int i, int i2, Object obj);

        void e(bf bfVar);

        void tg(int i, int i2);
    }

    public e(InterfaceC0109e interfaceC0109e) {
        this(interfaceC0109e, false);
    }

    private void ga(bf bfVar) {
        int i;
        int i2 = bfVar.e;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iBf = bf(bfVar.bf, i2);
        int i3 = bfVar.bf;
        int i4 = bfVar.e;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bfVar);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bfVar.tg; i6++) {
            int iBf2 = bf(bfVar.bf + (i * i6), bfVar.e);
            int i7 = bfVar.e;
            if (i7 == 2 ? iBf2 == iBf : i7 == 4 && iBf2 == iBf + 1) {
                i5++;
            } else {
                bf bfVarE = e(i7, iBf, i5, bfVar.d);
                e(bfVarE, i3);
                e(bfVarE);
                if (bfVar.e == 4) {
                    i3 += i5;
                }
                i5 = 1;
                iBf = iBf2;
            }
        }
        Object obj = bfVar.d;
        e(bfVar);
        if (i5 > 0) {
            bf bfVarE2 = e(bfVar.e, iBf, i5, obj);
            e(bfVarE2, i3);
            e(bfVarE2);
        }
    }

    private void p(bf bfVar) {
        this.bf.add(bfVar);
        int i = bfVar.e;
        if (i == 1) {
            this.d.d(bfVar.bf, bfVar.tg);
            return;
        }
        if (i == 2) {
            this.d.bf(bfVar.bf, bfVar.tg);
            return;
        }
        if (i == 4) {
            this.d.e(bfVar.bf, bfVar.tg, bfVar.d);
        } else {
            if (i == 8) {
                this.d.tg(bfVar.bf, bfVar.tg);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bfVar);
        }
    }

    private void tg(bf bfVar) {
        int i = bfVar.bf;
        int i2 = bfVar.tg + i;
        int i3 = 0;
        byte b2 = -1;
        int i4 = i;
        while (i < i2) {
            if (this.d.e(i) != null || tg(i)) {
                if (b2 == 0) {
                    ga(e(4, i4, i3, bfVar.d));
                    i4 = i;
                    i3 = 0;
                }
                b2 = 1;
            } else {
                if (b2 == 1) {
                    p(e(4, i4, i3, bfVar.d));
                    i4 = i;
                    i3 = 0;
                }
                b2 = 0;
            }
            i3++;
            i++;
        }
        if (i3 != bfVar.tg) {
            Object obj = bfVar.d;
            e(bfVar);
            bfVar = e(4, i4, i3, obj);
        }
        if (b2 == 0) {
            ga(bfVar);
        } else {
            p(bfVar);
        }
    }

    private void vn(bf bfVar) {
        p(bfVar);
    }

    public void bf() {
        this.vn.e(this.e);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            bf bfVar = this.e.get(i);
            int i2 = bfVar.e;
            if (i2 == 1) {
                vn(bfVar);
            } else if (i2 == 2) {
                d(bfVar);
            } else if (i2 == 4) {
                tg(bfVar);
            } else if (i2 == 8) {
                bf(bfVar);
            }
            Runnable runnable = this.tg;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.e.clear();
    }

    public void d() {
        int size = this.bf.size();
        for (int i = 0; i < size; i++) {
            this.d.bf(this.bf.get(i));
        }
        e(this.bf);
        this.v = 0;
    }

    public void e() {
        e(this.e);
        e(this.bf);
        this.v = 0;
    }

    public e(InterfaceC0109e interfaceC0109e, boolean z) {
        this.p = new tg.bf(30);
        this.e = new ArrayList<>();
        this.bf = new ArrayList<>();
        this.v = 0;
        this.d = interfaceC0109e;
        this.ga = z;
        this.vn = new p(this);
    }

    public boolean vn() {
        return (this.bf.isEmpty() || this.e.isEmpty()) ? false : true;
    }

    public void e(bf bfVar, int i) {
        this.d.e(bfVar);
        int i2 = bfVar.e;
        if (i2 == 2) {
            this.d.e(i, bfVar.tg);
        } else {
            if (i2 == 4) {
                this.d.e(i, bfVar.tg, bfVar.d);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private void d(bf bfVar) {
        boolean z;
        byte b2;
        int i = bfVar.bf;
        int i2 = bfVar.tg + i;
        byte b3 = -1;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.d.e(i3) != null || tg(i3)) {
                if (b3 == 0) {
                    ga(e(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 1;
            } else {
                if (b3 == 1) {
                    p(e(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b3 = b2;
        }
        if (i4 != bfVar.tg) {
            e(bfVar);
            bfVar = e(2, i, i4, null);
        }
        if (b3 == 0) {
            ga(bfVar);
        } else {
            p(bfVar);
        }
    }

    public boolean e(int i) {
        return (i & this.v) != 0;
    }

    public int e(int i, int i2) {
        int size = this.bf.size();
        while (i2 < size) {
            bf bfVar = this.bf.get(i2);
            int i3 = bfVar.e;
            if (i3 == 8) {
                int i4 = bfVar.bf;
                if (i4 == i) {
                    i = bfVar.tg;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bfVar.tg <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bfVar.bf;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bfVar.tg;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bfVar.tg;
                }
            }
            i2++;
        }
        return i;
    }

    private void bf(bf bfVar) {
        p(bfVar);
    }

    private int bf(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.bf.size() - 1; size >= 0; size--) {
            bf bfVar = this.bf.get(size);
            int i5 = bfVar.e;
            if (i5 == 8) {
                int i6 = bfVar.bf;
                int i7 = bfVar.tg;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            bfVar.bf = i6 + 1;
                            bfVar.tg = i7 + 1;
                        } else if (i2 == 2) {
                            bfVar.bf = i6 - 1;
                            bfVar.tg = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        bfVar.tg = i7 + 1;
                    } else if (i2 == 2) {
                        bfVar.tg = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        bfVar.bf = i6 + 1;
                    } else if (i2 == 2) {
                        bfVar.bf = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = bfVar.bf;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= bfVar.tg;
                    } else if (i5 == 2) {
                        i += bfVar.tg;
                    }
                } else if (i2 == 1) {
                    bfVar.bf = i8 + 1;
                } else if (i2 == 2) {
                    bfVar.bf = i8 - 1;
                }
            }
        }
        for (int size2 = this.bf.size() - 1; size2 >= 0; size2--) {
            bf bfVar2 = this.bf.get(size2);
            if (bfVar2.e == 8) {
                int i9 = bfVar2.tg;
                if (i9 == bfVar2.bf || i9 < 0) {
                    this.bf.remove(size2);
                    e(bfVar2);
                }
            } else if (bfVar2.tg <= 0) {
                this.bf.remove(size2);
                e(bfVar2);
            }
        }
        return i;
    }

    private boolean tg(int i) {
        int size = this.bf.size();
        for (int i2 = 0; i2 < size; i2++) {
            bf bfVar = this.bf.get(i2);
            int i3 = bfVar.e;
            if (i3 == 8) {
                if (e(bfVar.tg, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bfVar.bf;
                int i5 = bfVar.tg + i4;
                while (i4 < i5) {
                    if (e(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public int d(int i) {
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            bf bfVar = this.e.get(i2);
            int i3 = bfVar.e;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bfVar.bf;
                    if (i4 <= i) {
                        int i5 = bfVar.tg;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bfVar.bf;
                    if (i6 == i) {
                        i = bfVar.tg;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bfVar.tg <= i) {
                            i++;
                        }
                    }
                }
            } else if (bfVar.bf <= i) {
                i += bfVar.tg;
            }
        }
        return i;
    }

    public boolean e(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.e.add(e(4, i, i2, obj));
        this.v |= 4;
        return this.e.size() == 1;
    }

    public void ga() {
        d();
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            bf bfVar = this.e.get(i);
            int i2 = bfVar.e;
            if (i2 == 1) {
                this.d.bf(bfVar);
                this.d.d(bfVar.bf, bfVar.tg);
            } else if (i2 == 2) {
                this.d.bf(bfVar);
                this.d.e(bfVar.bf, bfVar.tg);
            } else if (i2 == 4) {
                this.d.bf(bfVar);
                this.d.e(bfVar.bf, bfVar.tg, bfVar.d);
            } else if (i2 == 8) {
                this.d.bf(bfVar);
                this.d.tg(bfVar.bf, bfVar.tg);
            }
            Runnable runnable = this.tg;
            if (runnable != null) {
                runnable.run();
            }
        }
        e(this.e);
        this.v = 0;
    }

    public boolean tg() {
        return this.e.size() > 0;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.p.e
    public bf e(int i, int i2, int i3, Object obj) {
        bf bfVarE = this.p.e();
        if (bfVarE == null) {
            return new bf(i, i2, i3, obj);
        }
        bfVarE.e = i;
        bfVarE.bf = i2;
        bfVarE.tg = i3;
        bfVarE.d = obj;
        return bfVarE;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.p.e
    public void e(bf bfVar) {
        if (this.ga) {
            return;
        }
        bfVar.d = null;
        this.p.e(bfVar);
    }

    public void e(List<bf> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            e(list.get(i));
        }
        list.clear();
    }

    public int bf(int i) {
        return e(i, 0);
    }
}
