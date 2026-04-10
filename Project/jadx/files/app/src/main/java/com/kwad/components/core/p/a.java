package com.kwad.components.core.p;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private static volatile a Pm;
    private int Mc;
    private int Pn;
    private boolean Po;
    private boolean Pp;
    private int Pq;
    private boolean Pr;

    private a() {
    }

    public static a pJ() {
        if (Pm == null) {
            synchronized (a.class) {
                if (Pm == null) {
                    Pm = new a();
                }
            }
        }
        return Pm;
    }

    public final void aD(int i2) {
        this.Pn = i2;
    }

    public final void aE(int i2) {
        this.Pq = i2;
    }

    public final void aF(int i2) {
        this.Mc = i2;
    }

    public final void aF(boolean z2) {
        this.Po = true;
    }

    public final void aG(boolean z2) {
        this.Pp = z2;
    }

    public final void aH(boolean z2) {
        this.Pr = z2;
    }

    public final void clear() {
        this.Pp = false;
        this.Po = false;
        this.Pq = 0;
        this.Pr = false;
        this.Pn = -1;
        this.Mc = 0;
    }

    public final int pK() {
        return this.Pn;
    }

    public final boolean pL() {
        return this.Po;
    }

    public final boolean pM() {
        return this.Pp;
    }

    public final boolean pN() {
        int i2 = this.Pq;
        return i2 == 1 || i2 == 3;
    }

    public final int pO() {
        return this.Pq;
    }

    public final boolean pP() {
        return this.Pr;
    }

    public final int pQ() {
        return this.Mc;
    }
}
