package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public final byte[] aVN;
    private CRC32 aVQ;
    public final String aoB;
    public final int len;
    public byte[] data = null;
    private long aVO = 0;
    public byte[] aVP = new byte[4];

    public d(int i, String str, boolean z) {
        this.len = i;
        this.aoB = str;
        this.aVN = b.gy(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = this.aVN[i2];
            if (b < 65 || b > 122 || (b > 90 && b < 97)) {
                new PngjException("Bad id chunk: must be ascii letters " + str);
            }
        }
        if (z) {
            OA();
        }
    }

    private void OA() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final void bS(boolean z) {
        int value = (int) this.aVQ.getValue();
        int iG = com.kwad.sdk.pngencrypt.n.g(this.aVP, 0);
        if (value != iG) {
            String str = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.aoB, Long.valueOf(this.aVO), Integer.valueOf(iG), Integer.valueOf(value));
            if (z) {
                new PngjException(str);
            }
        }
    }

    public final void e(byte[] bArr, int i, int i2) {
        if (this.aVQ == null) {
            this.aVQ = new CRC32();
        }
        this.aVQ.update(bArr, i, i2);
    }

    final ByteArrayInputStream OB() {
        return new ByteArrayInputStream(this.data);
    }

    public final long OC() {
        return this.aVO;
    }

    public final void aU(long j) {
        this.aVO = j;
    }

    public final String toString() {
        return "chunkid=" + b.h(this.aVN) + " len=" + this.len;
    }

    public final int hashCode() {
        String str = this.aoB;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.aVO;
        return ((iHashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.aoB;
        if (str == null) {
            if (dVar.aoB != null) {
                return false;
            }
        } else if (!str.equals(dVar.aoB)) {
            return false;
        }
        return this.aVO == dVar.aVO;
    }
}
