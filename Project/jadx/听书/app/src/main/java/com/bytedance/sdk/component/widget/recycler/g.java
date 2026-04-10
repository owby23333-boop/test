package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class g {
    final InterfaceC0144g z;
    final z g = new z();
    final List<View> dl = new ArrayList();

    /* JADX INFO: renamed from: com.bytedance.sdk.component.widget.recycler.g$g, reason: collision with other inner class name */
    interface InterfaceC0144g {
        void a(View view);

        void dl(int i);

        void dl(View view);

        View g(int i);

        RecyclerView.zw g(View view);

        void g();

        int z();

        int z(View view);

        void z(int i);

        void z(View view, int i);

        void z(View view, int i, ViewGroup.LayoutParams layoutParams);
    }

    g(InterfaceC0144g interfaceC0144g) {
        this.z = interfaceC0144g;
    }

    private void e(View view) {
        this.dl.add(view);
        this.z.dl(view);
    }

    private boolean gz(View view) {
        if (!this.dl.remove(view)) {
            return false;
        }
        this.z.a(view);
        return true;
    }

    void z(View view, boolean z2) {
        z(view, -1, z2);
    }

    void z(View view, int i, boolean z2) {
        int iM;
        if (i < 0) {
            iM = this.z.z();
        } else {
            iM = m(i);
        }
        this.g.insert(iM, z2);
        if (z2) {
            e(view);
        }
        this.z.z(view, iM);
    }

    private int m(int i) {
        if (i < 0) {
            return -1;
        }
        int iZ = this.z.z();
        int i2 = i;
        while (i2 < iZ) {
            int iGc = i - (i2 - this.g.gc(i2));
            if (iGc == 0) {
                while (this.g.dl(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iGc;
        }
        return -1;
    }

    void z(View view) {
        int iZ = this.z.z(view);
        if (iZ >= 0) {
            if (this.g.a(iZ)) {
                gz(view);
            }
            this.z.z(iZ);
        }
    }

    void z(int i) {
        int iM = m(i);
        View viewG = this.z.g(iM);
        if (viewG != null) {
            if (this.g.a(iM)) {
                gz(viewG);
            }
            this.z.z(iM);
        }
    }

    View g(int i) {
        return this.z.g(m(i));
    }

    void z() {
        this.g.z();
        for (int size = this.dl.size() - 1; size >= 0; size--) {
            this.z.a(this.dl.get(size));
            this.dl.remove(size);
        }
        this.z.g();
    }

    View dl(int i) {
        int size = this.dl.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.dl.get(i2);
            RecyclerView.zw zwVarG = this.z.g(view);
            if (zwVarG.a() == i && !zwVarG.v() && !zwVarG.p()) {
                return view;
            }
        }
        return null;
    }

    void z(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z2) {
        int iM;
        if (i < 0) {
            iM = this.z.z();
        } else {
            iM = m(i);
        }
        this.g.insert(iM, z2);
        if (z2) {
            e(view);
        }
        this.z.z(view, iM, layoutParams);
    }

    int g() {
        return this.z.z() - this.dl.size();
    }

    int dl() {
        return this.z.z();
    }

    View a(int i) {
        return this.z.g(i);
    }

    void gc(int i) {
        int iM = m(i);
        this.g.a(iM);
        this.z.dl(iM);
    }

    int g(View view) {
        int iZ = this.z.z(view);
        if (iZ == -1 || this.g.dl(iZ)) {
            return -1;
        }
        return iZ - this.g.gc(iZ);
    }

    boolean dl(View view) {
        return this.dl.contains(view);
    }

    void a(View view) {
        int iZ = this.z.z(view);
        if (iZ < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        this.g.z(iZ);
        e(view);
    }

    void gc(View view) {
        int iZ = this.z.z(view);
        if (iZ < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide ".concat(String.valueOf(view)));
        }
        if (!this.g.dl(iZ)) {
            throw new RuntimeException("trying to unhide a view that was not hidden".concat(String.valueOf(view)));
        }
        this.g.g(iZ);
        gz(view);
    }

    public String toString() {
        return this.g.toString() + ", hidden list:" + this.dl.size();
    }

    boolean m(View view) {
        int iZ = this.z.z(view);
        if (iZ == -1) {
            gz(view);
            return true;
        }
        if (!this.g.dl(iZ)) {
            return false;
        }
        this.g.a(iZ);
        gz(view);
        this.z.z(iZ);
        return true;
    }

    static class z {
        z g;
        long z = 0;

        z() {
        }

        void z(int i) {
            if (i >= 64) {
                g();
                this.g.z(i - 64);
            } else {
                this.z |= 1 << i;
            }
        }

        private void g() {
            if (this.g == null) {
                this.g = new z();
            }
        }

        void g(int i) {
            if (i >= 64) {
                z zVar = this.g;
                if (zVar != null) {
                    zVar.g(i - 64);
                    return;
                }
                return;
            }
            this.z &= ~(1 << i);
        }

        boolean dl(int i) {
            if (i < 64) {
                return (this.z & (1 << i)) != 0;
            }
            g();
            return this.g.dl(i - 64);
        }

        void z() {
            this.z = 0L;
            z zVar = this.g;
            if (zVar != null) {
                zVar.z();
            }
        }

        void insert(int i, boolean z) {
            if (i >= 64) {
                g();
                this.g.insert(i - 64, z);
                return;
            }
            long j = this.z;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.z = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                z(i);
            } else {
                g(i);
            }
            if (z2 || this.g != null) {
                g();
                this.g.insert(0, z2);
            }
        }

        boolean a(int i) {
            if (i >= 64) {
                g();
                return this.g.a(i - 64);
            }
            long j = 1 << i;
            long j2 = this.z;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.z = j3;
            long j4 = j - 1;
            this.z = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            z zVar = this.g;
            if (zVar != null) {
                if (zVar.dl(0)) {
                    z(63);
                }
                this.g.a(0);
            }
            return z;
        }

        int gc(int i) {
            z zVar = this.g;
            return zVar == null ? i >= 64 ? Long.bitCount(this.z) : Long.bitCount(this.z & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.z & ((1 << i) - 1)) : zVar.gc(i - 64) + Long.bitCount(this.z);
        }

        public String toString() {
            return this.g == null ? Long.toBinaryString(this.z) : this.g.toString() + "xx" + Long.toBinaryString(this.z);
        }
    }
}
