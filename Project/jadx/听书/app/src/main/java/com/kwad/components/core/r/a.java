package com.kwad.components.core.r;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private static volatile a XX;
    private int Uc;
    private int XY;
    private boolean XZ;
    private boolean Ya;
    private int Yb;
    private boolean Yc;

    private a() {
    }

    public static a sF() {
        if (XX == null) {
            synchronized (a.class) {
                if (XX == null) {
                    XX = new a();
                }
            }
        }
        return XX;
    }

    public final int sG() {
        return this.XY;
    }

    public final void aW(int i) {
        this.XY = i;
    }

    public final boolean sH() {
        return this.XZ;
    }

    public final void aN(boolean z) {
        this.XZ = true;
    }

    public final boolean sI() {
        return this.Ya;
    }

    public final void aO(boolean z) {
        this.Ya = z;
    }

    public final boolean sJ() {
        int i = this.Yb;
        return i == 1 || i == 3;
    }

    public final void aX(int i) {
        this.Yb = i;
    }

    public final int sK() {
        return this.Yb;
    }

    public final boolean sL() {
        return this.Yc;
    }

    public final void aP(boolean z) {
        this.Yc = z;
    }

    public final int sM() {
        return this.Uc;
    }

    public final void aY(int i) {
        this.Uc = i;
    }

    public final void clear() {
        this.Ya = false;
        this.XZ = false;
        this.Yb = 0;
        this.Yc = false;
        this.XY = -1;
        this.Uc = 0;
    }
}
