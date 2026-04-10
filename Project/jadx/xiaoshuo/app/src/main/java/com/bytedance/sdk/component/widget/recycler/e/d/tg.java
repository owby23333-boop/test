package com.bytedance.sdk.component.widget.recycler.e.d;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class tg {
    private ViewParent bf;
    private final View d;
    private ViewParent e;
    private int[] ga;
    private boolean tg;

    public tg(View view) {
        this.d = view;
    }

    private ViewParent tg(int i) {
        if (i == 0) {
            return this.e;
        }
        if (i != 1) {
            return null;
        }
        return this.bf;
    }

    public boolean bf() {
        return e(0);
    }

    public void d() {
        d(0);
    }

    public void e(boolean z) {
        if (this.tg) {
            p.m(this.d);
        }
        this.tg = z;
    }

    public boolean bf(int i) {
        return e(i, 0);
    }

    public void d(int i) {
        ViewParent viewParentTg = tg(i);
        if (viewParentTg != null) {
            v.e(viewParentTg, this.d, i);
            e(i, (ViewParent) null);
        }
    }

    public boolean e() {
        return this.tg;
    }

    public boolean e(int i) {
        return tg(i) != null;
    }

    public boolean e(int i, int i2) {
        if (e(i2)) {
            return true;
        }
        if (!e()) {
            return false;
        }
        View view = this.d;
        for (ViewParent parent = this.d.getParent(); parent != null; parent = parent.getParent()) {
            if (v.e(parent, view, this.d, i, i2)) {
                e(i2, parent);
                v.bf(parent, view, this.d, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean e(int i, int i2, int i3, int i4, int[] iArr) {
        return e(i, i2, i3, i4, iArr, 0);
    }

    public boolean e(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentTg;
        int i6;
        int i7;
        if (!e() || (viewParentTg = tg(i5)) == null) {
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
            this.d.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        v.e(viewParentTg, this.d, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.d.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public boolean e(int i, int i2, int[] iArr, int[] iArr2) {
        return e(i, i2, iArr, iArr2, 0);
    }

    public boolean e(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentTg;
        int i4;
        int i5;
        if (!e() || (viewParentTg = tg(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        if (iArr2 != null) {
            this.d.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.ga == null) {
                this.ga = new int[2];
            }
            iArr = this.ga;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        v.e(viewParentTg, this.d, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.d.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    public boolean e(float f, float f2, boolean z) {
        ViewParent viewParentTg;
        if (!e() || (viewParentTg = tg(0)) == null) {
            return false;
        }
        return v.e(viewParentTg, this.d, f, f2, z);
    }

    public boolean e(float f, float f2) {
        ViewParent viewParentTg;
        if (!e() || (viewParentTg = tg(0)) == null) {
            return false;
        }
        return v.e(viewParentTg, this.d, f, f2);
    }

    private void e(int i, ViewParent viewParent) {
        if (i == 0) {
            this.e = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.bf = viewParent;
        }
    }
}
