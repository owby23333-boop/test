package cn.kuaipan.android.kss;

import cn.kuaipan.android.http.IKscDecoder;
import cn.kuaipan.android.utils.RC4;
import java.security.InvalidKeyException;

/* JADX INFO: loaded from: classes.dex */
public class RC4Encoder implements IKscDecoder {
    private static final int BUF_SIZE = 8192;
    private byte[] buf;
    private int bufUsed = 0;
    private final byte[] key;
    private final RC4 rc4;

    public RC4Encoder(byte[] bArr) throws InvalidKeyException {
        this.key = bArr;
        RC4 rc4 = new RC4();
        this.rc4 = rc4;
        rc4.makeKey(bArr);
        this.buf = new byte[8192];
    }

    @Override // cn.kuaipan.android.http.IKscDecoder
    public boolean canEnd() {
        return true;
    }

    @Override // cn.kuaipan.android.http.IKscDecoder
    public void end() {
        this.bufUsed = 0;
    }

    @Override // cn.kuaipan.android.http.IKscDecoder
    public synchronized void fillData(byte[] bArr, int i, int i2) {
        int i3 = this.bufUsed + i2;
        byte[] bArr2 = this.buf;
        if (i3 > bArr2.length) {
            int length = bArr2.length;
            do {
                length <<= 1;
            } while (i3 > length);
            byte[] bArr3 = new byte[length];
            this.buf = bArr3;
            System.arraycopy(bArr2, 0, bArr3, 0, this.bufUsed);
        }
        this.rc4.genRC4(bArr, i, i2, bArr, i);
        System.arraycopy(bArr, i, this.buf, this.bufUsed, i2);
        this.bufUsed = i3;
    }

    @Override // cn.kuaipan.android.http.IKscDecoder
    public void init() {
        try {
            this.rc4.makeKey(this.key);
            this.bufUsed = 0;
        } catch (InvalidKeyException unused) {
        }
    }

    @Override // cn.kuaipan.android.http.IKscDecoder
    public int needFill() {
        return Math.max(8192 - this.bufUsed, 0);
    }

    @Override // cn.kuaipan.android.http.IKscDecoder
    public synchronized int readDecodeData(byte[] bArr, int i, int i2) {
        int i3 = this.bufUsed;
        if (i3 <= 0) {
            return 0;
        }
        int iMin = Math.min(Math.min(i3, i2), bArr.length - i);
        System.arraycopy(this.buf, 0, bArr, i, iMin);
        int i4 = this.bufUsed - iMin;
        if (i4 > 0) {
            byte[] bArr2 = this.buf;
            System.arraycopy(bArr2, iMin, bArr2, 0, i4);
        }
        this.bufUsed = i4;
        return iMin;
    }

    @Override // cn.kuaipan.android.http.IKscDecoder
    public void skip(long j) {
        try {
            this.rc4.makeKey(this.key);
            this.bufUsed = 0;
            this.rc4.skip(j);
        } catch (InvalidKeyException unused) {
        }
    }

    @Override // cn.kuaipan.android.http.IKscDecoder
    public boolean supportRepeat() {
        return true;
    }

    @Override // cn.kuaipan.android.http.IKscDecoder
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RC4Encoder m10clone() {
        try {
            return new RC4Encoder(this.key);
        } catch (InvalidKeyException unused) {
            return null;
        }
    }
}
