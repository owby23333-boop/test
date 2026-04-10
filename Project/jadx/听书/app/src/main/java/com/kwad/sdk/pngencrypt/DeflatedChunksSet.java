package com.kwad.sdk.pngencrypt;

import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes4.dex */
public class DeflatedChunksSet {
    private long aUA = 0;
    private long aUB = 0;
    int aUC = -1;
    int aUD = -1;
    public final String aUE;
    protected final boolean aUd;
    protected byte[] aUt;
    private int aUu;
    private int aUv;
    private int aUw;
    State aUx;
    private final boolean aUy;
    private d aUz;
    private Inflater inf;

    protected void Od() {
    }

    enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }

        public final boolean isClosed() {
            return this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        this.aUx = State.WAITING_FOR_INPUT;
        this.aUE = str;
        this.aUd = z;
        this.aUv = i;
        if (i <= 0 || i2 < i) {
            throw new PngjException("bad inital row len " + i);
        }
        if (inflater != null) {
            this.inf = inflater;
            this.aUy = false;
        } else {
            this.inf = new Inflater();
            this.aUy = true;
        }
        this.aUt = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
        this.aUw = -1;
        this.aUx = State.WAITING_FOR_INPUT;
        try {
            ef(i);
        } catch (RuntimeException e) {
            close();
            throw e;
        }
    }

    protected final void a(d dVar) {
        if (!this.aUE.equals(dVar.NP().aoB)) {
            new PngjException("Bad chunk inside IdatSet, id:" + dVar.NP().aoB + ", expected:" + this.aUE);
        }
        this.aUz = dVar;
        int i = this.aUC + 1;
        this.aUC = i;
        int i2 = this.aUD;
        if (i2 >= 0) {
            dVar.ee(i + i2);
        }
    }

    protected final void b(byte[] bArr, int i, int i2) {
        this.aUA += (long) i2;
        if (i2 <= 0 || this.aUx.isDone()) {
            return;
        }
        if (this.aUx == State.ROW_READY) {
            new PngjException("this should only be called if waitingForMoreInput");
        }
        if (this.inf.needsDictionary() || !this.inf.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.inf.setInput(bArr, i, i2);
        if (this.aUd) {
            while (Oc()) {
                ef(Oe());
                isDone();
            }
            return;
        }
        Oc();
    }

    private boolean Oc() {
        State state;
        int iInflate;
        try {
            if (this.aUx == State.ROW_READY) {
                new PngjException("invalid state");
            }
            if (this.aUx.isDone()) {
                return false;
            }
            byte[] bArr = this.aUt;
            if (bArr == null || bArr.length < this.aUv) {
                this.aUt = new byte[this.aUv];
            }
            if (this.aUu < this.aUv && !this.inf.finished()) {
                try {
                    Inflater inflater = this.inf;
                    byte[] bArr2 = this.aUt;
                    int i = this.aUu;
                    iInflate = inflater.inflate(bArr2, i, this.aUv - i);
                } catch (DataFormatException e) {
                    new PngjException("error decompressing zlib stream ", e);
                    iInflate = 0;
                }
                this.aUu += iInflate;
                this.aUB += (long) iInflate;
            }
            if (this.aUu == this.aUv) {
                state = State.ROW_READY;
            } else if (!this.inf.finished()) {
                state = State.WAITING_FOR_INPUT;
            } else if (this.aUu > 0) {
                state = State.ROW_READY;
            } else {
                state = State.DONE;
            }
            this.aUx = state;
            if (state != State.ROW_READY) {
                return false;
            }
            Od();
            return true;
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    protected int Oe() {
        throw new PngjException("not implemented");
    }

    public final void ef(int i) {
        this.aUu = 0;
        this.aUw++;
        if (i <= 0) {
            this.aUv = 0;
            Of();
        } else {
            if (this.inf.finished()) {
                this.aUv = 0;
                Of();
                return;
            }
            this.aUx = State.WAITING_FOR_INPUT;
            this.aUv = i;
            if (this.aUd) {
                return;
            }
            Oc();
        }
    }

    public final boolean isDone() {
        return this.aUx.isDone();
    }

    public final boolean isClosed() {
        return this.aUx.isClosed();
    }

    public final boolean gx(String str) {
        if (this.aUx.isClosed()) {
            return false;
        }
        if (str.equals(this.aUE)) {
            return true;
        }
        if (this.aUx.isDone()) {
            if (!this.aUx.isClosed()) {
                close();
            }
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.aUE + " set is not done");
    }

    public void close() {
        Inflater inflater;
        try {
            if (!this.aUx.isClosed()) {
                this.aUx = State.CLOSED;
            }
            if (!this.aUy || (inflater = this.inf) == null) {
                return;
            }
            inflater.end();
            this.inf = null;
        } catch (Exception unused) {
        }
    }

    public final void Of() {
        if (isDone()) {
            return;
        }
        this.aUx = State.DONE;
    }

    public final int Og() {
        return this.aUw;
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.aUz.NP().aoB + " state=" + this.aUx + " rows=" + this.aUw + " bytes=" + this.aUA + "/" + this.aUB).toString();
    }
}
