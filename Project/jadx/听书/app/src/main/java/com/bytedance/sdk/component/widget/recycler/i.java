package com.bytedance.sdk.component.widget.recycler;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class i {
    z g = new z();
    final g z;

    interface g {
        int g();

        int g(View view);

        int z();

        int z(View view);

        View z(int i);
    }

    i(g gVar) {
        this.z = gVar;
    }

    View z(int i, int i2, int i3, int i4) {
        int iZ = this.z.z();
        int iG = this.z.g();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewZ = this.z.z(i);
            this.g.z(iZ, iG, this.z.z(viewZ), this.z.g(viewZ));
            if (i3 != 0) {
                this.g.z();
                this.g.z(i3);
                if (this.g.g()) {
                    return viewZ;
                }
            }
            if (i4 != 0) {
                this.g.z();
                this.g.z(i4);
                if (this.g.g()) {
                    view = viewZ;
                }
            }
            i += i5;
        }
        return view;
    }

    static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f837a;
        int dl;
        int g;
        int gc;
        int z = 0;

        int z(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        z() {
        }

        void z(int i, int i2, int i3, int i4) {
            this.g = i;
            this.dl = i2;
            this.f837a = i3;
            this.gc = i4;
        }

        void z(int i) {
            this.z = i | this.z;
        }

        void z() {
            this.z = 0;
        }

        boolean g() {
            int i = this.z;
            if ((i & 7) != 0 && (i & (z(this.f837a, this.g) << 0)) == 0) {
                return false;
            }
            int i2 = this.z;
            if ((i2 & 112) != 0 && (i2 & (z(this.f837a, this.dl) << 4)) == 0) {
                return false;
            }
            int i3 = this.z;
            if ((i3 & 1792) != 0 && (i3 & (z(this.gc, this.g) << 8)) == 0) {
                return false;
            }
            int i4 = this.z;
            return (i4 & 28672) == 0 || (i4 & (z(this.gc, this.dl) << 12)) != 0;
        }
    }
}
