package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class bf {
    final e bf = new e();
    final List<View> d = new ArrayList();
    final InterfaceC0108bf e;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.widget.recycler.bf$bf, reason: collision with other inner class name */
    public interface InterfaceC0108bf {
        View bf(int i);

        RecyclerView.cv bf(View view);

        void bf();

        void d(int i);

        void d(View view);

        int e();

        int e(View view);

        void e(int i);

        void e(View view, int i);

        void e(View view, int i, ViewGroup.LayoutParams layoutParams);

        void tg(View view);
    }

    public bf(InterfaceC0108bf interfaceC0108bf) {
        this.e = interfaceC0108bf;
    }

    private void p(View view) {
        this.d.add(view);
        this.e.d(view);
    }

    private boolean v(View view) {
        if (!this.d.remove(view)) {
            return false;
        }
        this.e.tg(view);
        return true;
    }

    private int vn(int i) {
        if (i < 0) {
            return -1;
        }
        int iE = this.e.e();
        int i2 = i;
        while (i2 < iE) {
            int iGa = i - (i2 - this.bf.ga(i2));
            if (iGa == 0) {
                while (this.bf.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iGa;
        }
        return -1;
    }

    public View bf(int i) {
        return this.e.bf(vn(i));
    }

    public View d(int i) {
        int size = this.d.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.d.get(i2);
            RecyclerView.cv cvVarBf = this.e.bf(view);
            if (cvVarBf.v() == i && !cvVarBf.f() && !cvVarBf.pe()) {
                return view;
            }
        }
        return null;
    }

    public void e(View view, boolean z) {
        e(view, -1, z);
    }

    public void ga(int i) {
        int iVn = vn(i);
        this.bf.tg(iVn);
        this.e.d(iVn);
    }

    public View tg(int i) {
        return this.e.bf(i);
    }

    public String toString() {
        return this.bf.toString() + ", hidden list:" + this.d.size();
    }

    public static class e {
        e bf;
        long e = 0;

        private void bf() {
            if (this.bf == null) {
                this.bf = new e();
            }
        }

        public boolean d(int i) {
            if (i < 64) {
                return (this.e & (1 << i)) != 0;
            }
            bf();
            return this.bf.d(i - 64);
        }

        public void e(int i) {
            if (i < 64) {
                this.e |= 1 << i;
            } else {
                bf();
                this.bf.e(i - 64);
            }
        }

        public int ga(int i) {
            e eVar = this.bf;
            if (eVar == null) {
                return Long.bitCount(i >= 64 ? this.e : this.e & ((1 << i) - 1));
            }
            return i < 64 ? Long.bitCount(this.e & ((1 << i) - 1)) : eVar.ga(i - 64) + Long.bitCount(this.e);
        }

        public void insert(int i, boolean z) {
            if (i >= 64) {
                bf();
                this.bf.insert(i - 64, z);
                return;
            }
            long j = this.e;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.e = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                e(i);
            } else {
                bf(i);
            }
            if (z2 || this.bf != null) {
                bf();
                this.bf.insert(0, z2);
            }
        }

        public boolean tg(int i) {
            if (i >= 64) {
                bf();
                return this.bf.tg(i - 64);
            }
            long j = 1 << i;
            long j2 = this.e;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.e = j3;
            long j4 = j - 1;
            this.e = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            e eVar = this.bf;
            if (eVar != null) {
                if (eVar.d(0)) {
                    e(63);
                }
                this.bf.tg(0);
            }
            return z;
        }

        public String toString() {
            if (this.bf == null) {
                return Long.toBinaryString(this.e);
            }
            return this.bf.toString() + "xx" + Long.toBinaryString(this.e);
        }

        public void bf(int i) {
            if (i >= 64) {
                e eVar = this.bf;
                if (eVar != null) {
                    eVar.bf(i - 64);
                    return;
                }
                return;
            }
            this.e &= ~(1 << i);
        }

        public void e() {
            this.e = 0L;
            e eVar = this.bf;
            if (eVar != null) {
                eVar.e();
            }
        }
    }

    public void e(View view, int i, boolean z) {
        int iE = i < 0 ? this.e.e() : vn(i);
        this.bf.insert(iE, z);
        if (z) {
            p(view);
        }
        this.e.e(view, iE);
    }

    public void tg(View view) {
        int iE = this.e.e(view);
        if (iE >= 0) {
            this.bf.e(iE);
            p(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public int bf() {
        return this.e.e() - this.d.size();
    }

    public int bf(View view) {
        int iE = this.e.e(view);
        if (iE == -1 || this.bf.d(iE)) {
            return -1;
        }
        return iE - this.bf.ga(iE);
    }

    public void ga(View view) {
        int iE = this.e.e(view);
        if (iE >= 0) {
            if (this.bf.d(iE)) {
                this.bf.bf(iE);
                v(view);
                return;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public boolean vn(View view) {
        int iE = this.e.e(view);
        if (iE == -1) {
            v(view);
            return true;
        }
        if (!this.bf.d(iE)) {
            return false;
        }
        this.bf.tg(iE);
        v(view);
        this.e.e(iE);
        return true;
    }

    public int d() {
        return this.e.e();
    }

    public boolean d(View view) {
        return this.d.contains(view);
    }

    public void e(View view) {
        int iE = this.e.e(view);
        if (iE >= 0) {
            if (this.bf.tg(iE)) {
                v(view);
            }
            this.e.e(iE);
        }
    }

    public void e(int i) {
        int iVn = vn(i);
        View viewBf = this.e.bf(iVn);
        if (viewBf != null) {
            if (this.bf.tg(iVn)) {
                v(viewBf);
            }
            this.e.e(iVn);
        }
    }

    public void e() {
        this.bf.e();
        for (int size = this.d.size() - 1; size >= 0; size--) {
            this.e.tg(this.d.get(size));
            this.d.remove(size);
        }
        this.e.bf();
    }

    public void e(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iVn;
        if (i < 0) {
            iVn = this.e.e();
        } else {
            iVn = vn(i);
        }
        this.bf.insert(iVn, z);
        if (z) {
            p(view);
        }
        this.e.e(view, iVn, layoutParams);
    }
}
