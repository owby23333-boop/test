package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final byte[] awa;
    public final String awb;
    private CRC32 awe;
    public final int len;
    public byte[] data = null;
    private long awc = 0;
    public byte[] awd = new byte[4];

    public d(int i2, String str, boolean z2) {
        this.len = i2;
        this.awb = str;
        this.awa = b.dT(str);
        for (int i3 = 0; i3 < 4; i3++) {
            byte[] bArr = this.awa;
            if (bArr[i3] < 65 || bArr[i3] > 122 || (bArr[i3] > 90 && bArr[i3] < 97)) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
        }
        if (z2) {
            Cf();
        }
    }

    private void Cf() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    final ByteArrayInputStream Cg() {
        return new ByteArrayInputStream(this.data);
    }

    public final long Ch() {
        return this.awc;
    }

    public final void ae(long j2) {
        this.awc = j2;
    }

    public final void bk(boolean z2) {
        int value = (int) this.awe.getValue();
        int iG = com.kwad.sdk.pngencrypt.n.g(this.awd, 0);
        if (value != iG) {
            String str = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.awb, Long.valueOf(this.awc), Integer.valueOf(iG), Integer.valueOf(value));
            if (z2) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", str);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.awb;
        if (str == null) {
            if (dVar.awb != null) {
                return false;
            }
        } else if (!str.equals(dVar.awb)) {
            return false;
        }
        return this.awc == dVar.awc;
    }

    public final void f(byte[] bArr, int i2, int i3) {
        if (this.awe == null) {
            this.awe = new CRC32();
        }
        this.awe.update(bArr, i2, i3);
    }

    public final int hashCode() {
        String str = this.awb;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j2 = this.awc;
        return ((iHashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.i(this.awa) + " len=" + this.len;
    }
}
