package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes3.dex */
public class DeflatedChunksSet {
    protected byte[] auG;
    private int auH;
    private int auI;
    private int auJ;
    State auK;
    private final boolean auL;
    private d auM;
    private long auN = 0;
    private long auO = 0;
    int auP = -1;
    int auQ = -1;
    public final String auR;
    protected final boolean auq;
    private Inflater inf;

    enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            return this == CLOSED;
        }

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z2, int i2, int i3, Inflater inflater, byte[] bArr) {
        boolean z3;
        this.auK = State.WAITING_FOR_INPUT;
        this.auR = str;
        this.auq = z2;
        this.auI = i2;
        if (i2 <= 0 || i3 < i2) {
            throw new PngjException("bad inital row len " + i2);
        }
        if (inflater != null) {
            this.inf = inflater;
            z3 = false;
        } else {
            this.inf = new Inflater();
            z3 = true;
        }
        this.auL = z3;
        this.auG = (bArr == null || bArr.length < i2) ? new byte[i3] : bArr;
        this.auJ = -1;
        this.auK = State.WAITING_FOR_INPUT;
        try {
            bG(i2);
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    private boolean BH() {
        State state;
        int iInflate;
        try {
            if (this.auK == State.ROW_READY) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("invalid state"));
            }
            if (this.auK.isDone()) {
                return false;
            }
            if (this.auG == null || this.auG.length < this.auI) {
                this.auG = new byte[this.auI];
            }
            if (this.auH < this.auI && !this.inf.finished()) {
                try {
                    iInflate = this.inf.inflate(this.auG, this.auH, this.auI - this.auH);
                } catch (DataFormatException e2) {
                    com.kwad.sdk.core.d.b.printStackTrace(new PngjException("error decompressing zlib stream ", e2));
                    iInflate = 0;
                }
                this.auH += iInflate;
                this.auO += (long) iInflate;
            }
            if (this.auH != this.auI) {
                state = !this.inf.finished() ? State.WAITING_FOR_INPUT : this.auH > 0 ? State.ROW_READY : State.DONE;
            }
            this.auK = state;
            if (this.auK != State.ROW_READY) {
                return false;
            }
            BI();
            return true;
        } catch (RuntimeException e3) {
            close();
            throw e3;
        }
    }

    protected void BI() {
    }

    protected int BJ() {
        throw new PngjException("not implemented");
    }

    public final void BK() {
        if (isDone()) {
            return;
        }
        this.auK = State.DONE;
    }

    public final int BL() {
        return this.auJ;
    }

    protected final void a(d dVar) {
        if (!this.auR.equals(dVar.Bu().awb)) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + dVar.Bu().awb + ", expected:" + this.auR));
        }
        this.auM = dVar;
        this.auP++;
        int i2 = this.auQ;
        if (i2 >= 0) {
            dVar.bF(this.auP + i2);
        }
    }

    public final void bG(int i2) {
        this.auH = 0;
        this.auJ++;
        if (i2 <= 0 || this.inf.finished()) {
            this.auI = 0;
            BK();
            return;
        }
        this.auK = State.WAITING_FOR_INPUT;
        this.auI = i2;
        if (this.auq) {
            return;
        }
        BH();
    }

    protected final void c(byte[] bArr, int i2, int i3) {
        this.auN += (long) i3;
        if (i3 <= 0 || this.auK.isDone()) {
            return;
        }
        if (this.auK == State.ROW_READY) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.inf.needsDictionary() || !this.inf.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.inf.setInput(bArr, i2, i3);
        if (!this.auq) {
            BH();
            return;
        }
        while (BH()) {
            bG(BJ());
            isDone();
        }
    }

    public void close() {
        try {
            if (!this.auK.isClosed()) {
                this.auK = State.CLOSED;
            }
            if (!this.auL || this.inf == null) {
                return;
            }
            this.inf.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final boolean dS(String str) {
        if (this.auK.isClosed()) {
            return false;
        }
        if (str.equals(this.auR)) {
            return true;
        }
        if (this.auK.isDone()) {
            if (!this.auK.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.auR + " set is not done");
    }

    public final boolean isClosed() {
        return this.auK.isClosed();
    }

    public final boolean isDone() {
        return this.auK.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.auM.Bu().awb + " state=" + this.auK + " rows=" + this.auJ + " bytes=" + this.auN + "/" + this.auO).toString();
    }
}
