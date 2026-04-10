package com.bytedance.sdk.component.widget.recycler.z.dl;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f842a;
    private final View dl;
    private ViewParent g;
    private int[] gc;
    private ViewParent z;

    public a(View view) {
        this.dl = view;
    }

    public void z(boolean z) {
        if (this.f842a) {
            e.uy(this.dl);
        }
        this.f842a = z;
    }

    public boolean z() {
        return this.f842a;
    }

    public boolean g() {
        return z(0);
    }

    public boolean z(int i) {
        return a(i) != null;
    }

    public boolean g(int i) {
        return z(i, 0);
    }

    public boolean z(int i, int i2) {
        if (z(i2)) {
            return true;
        }
        if (!z()) {
            return false;
        }
        View view = this.dl;
        for (ViewParent parent = this.dl.getParent(); parent != null; parent = parent.getParent()) {
            if (gz.z(parent, view, this.dl, i, i2)) {
                z(i2, parent);
                gz.g(parent, view, this.dl, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void dl() {
        dl(0);
    }

    public void dl(int i) {
        ViewParent viewParentA = a(i);
        if (viewParentA != null) {
            gz.z(viewParentA, this.dl, i);
            z(i, (ViewParent) null);
        }
    }

    public boolean z(int i, int i2, int i3, int i4, int[] iArr) {
        return z(i, i2, i3, i4, iArr, 0);
    }

    public boolean z(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentA;
        int i6;
        int i7;
        if (!z() || (viewParentA = a(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.dl.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        gz.z(viewParentA, this.dl, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.dl.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean z(int i, int i2, int[] iArr, int[] iArr2) {
        return z(i, i2, iArr, iArr2, 0);
    }

    public boolean z(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentA;
        int i4;
        int i5;
        if (!z() || (viewParentA = a(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.dl.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.gc == null) {
                this.gc = new int[2];
            }
            iArr = this.gc;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        gz.z(viewParentA, this.dl, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.dl.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean z(float f, float f2, boolean z) {
        ViewParent viewParentA;
        if (!z() || (viewParentA = a(0)) == null) {
            return false;
        }
        return gz.z(viewParentA, this.dl, f, f2, z);
    }

    public boolean z(float f, float f2) {
        ViewParent viewParentA;
        if (!z() || (viewParentA = a(0)) == null) {
            return false;
        }
        return gz.z(viewParentA, this.dl, f, f2);
    }

    private ViewParent a(int i) {
        if (i == 0) {
            return this.z;
        }
        if (i != 1) {
            return null;
        }
        return this.g;
    }

    private void z(int i, ViewParent viewParent) {
        if (i == 0) {
            this.z = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.g = viewParent;
        }
    }
}
