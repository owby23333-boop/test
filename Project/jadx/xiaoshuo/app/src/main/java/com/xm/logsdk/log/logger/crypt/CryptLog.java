package com.xm.logsdk.log.logger.crypt;

import com.xm.logsdk.log.Logz;
import com.xm.logsdk.log.logger.crypt.ICrypt;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes8.dex */
public class CryptLog {
    public static final int sBlockHeaderLen = 7;
    public static final int sENC_UNIT_SIZE = 15;
    public static final int sFileHeaderLen = 11;
    public static final byte sMagicBlockStart = 7;
    public static final byte sMagicEnd = 0;
    public static final byte sMagicSliceStart = 6;
    private ICrypt mCrypt;
    private String mKey;
    private boolean mSliceByLimit;
    private byte[] remainBytes;

    public CryptLog(String str) {
        this(str, false);
    }

    public String decrypt(byte[] bArr, int i, int i2) {
        return (bArr == null || bArr.length < i2 + i) ? "" : this.mCrypt.decrypt(bArr, i, i2);
    }

    public void encrypt(String str, ICrypt.AESLogCallback aESLogCallback) {
        if (this.mSliceByLimit) {
            encryptByLimit(str, false, aESLogCallback);
        } else {
            encryptAll(str, aESLogCallback);
        }
    }

    public void encryptAll(String str, ICrypt.AESLogCallback aESLogCallback) {
        if (str == null || aESLogCallback == null) {
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        ICrypt iCrypt = this.mCrypt;
        if (iCrypt == null) {
            aESLogCallback.callback(bytes, false);
            return;
        }
        byte[] bArrEncrypt = iCrypt.encrypt(bytes, 0, bytes.length);
        aESLogCallback.callback(getBlockHeader(bArrEncrypt.length), false);
        aESLogCallback.callback(bArrEncrypt, true);
        log("enc:" + bArrEncrypt.length);
    }

    public void encryptByLimit(String str, boolean z, ICrypt.AESLogCallback aESLogCallback) {
        if (str == null || aESLogCallback == null) {
            return;
        }
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        if (this.mCrypt == null) {
            aESLogCallback.callback(bytes, false);
            return;
        }
        byte[] bArr = this.remainBytes;
        if (bArr != null) {
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(bytes, 0, bArr2, this.remainBytes.length, bytes.length);
            bytes = bArr2;
        }
        int length = bytes.length / 15;
        for (int i = 0; i < length; i++) {
            aESLogCallback.callback(this.mCrypt.encrypt(bytes, i * 15, 15), true);
        }
        int i2 = length * 15;
        int length2 = bytes.length - i2;
        if (!z || length2 <= 0) {
            if (z || length2 <= 0) {
                this.remainBytes = null;
                return;
            } else {
                aESLogCallback.callback(this.mCrypt.encrypt(bytes, i2, length2), true);
                this.remainBytes = null;
                return;
            }
        }
        byte[] bArr3 = new byte[length2];
        this.remainBytes = bArr3;
        System.arraycopy(bytes, i2, bArr3, 0, length2);
        log("remainBytes:" + new String(this.remainBytes));
    }

    public byte[] flush() {
        ICrypt iCrypt;
        byte[] bArr = this.remainBytes;
        if (bArr == null || (iCrypt = this.mCrypt) == null) {
            return null;
        }
        return iCrypt.encrypt(bArr, 0, bArr.length);
    }

    public byte[] getBlockEnd() {
        return new byte[]{0};
    }

    public byte[] getBlockHeader(int i) {
        byte[] bArr = new byte[7];
        if (this.mSliceByLimit) {
            bArr[0] = 6;
        } else {
            bArr[0] = 7;
        }
        bArr[1] = 0;
        bArr[2] = 0;
        bArr[3] = (byte) (i >> 24);
        bArr[4] = (byte) (i >> 16);
        bArr[5] = (byte) (i >> 8);
        bArr[6] = (byte) i;
        return bArr;
    }

    public byte[] getFileHeader() {
        byte[] bArr = new byte[11];
        if (this.mSliceByLimit) {
            bArr[0] = 6;
        } else {
            bArr[0] = 7;
        }
        bArr[1] = 1;
        bArr[2] = 109;
        bArr[3] = 97;
        bArr[4] = 103;
        bArr[5] = 105;
        bArr[6] = 99;
        bArr[7] = 127;
        bArr[8] = 126;
        bArr[9] = 125;
        bArr[10] = 124;
        return bArr;
    }

    public void log(String str) {
    }

    public CryptLog(String str, boolean z) {
        this.mKey = null;
        this.mSliceByLimit = false;
        this.remainBytes = null;
        this.mCrypt = null;
        ICrypt cryptImpl = Logz.sLogConfig.getCryptImpl();
        this.mCrypt = cryptImpl;
        if (cryptImpl == null) {
            this.mCrypt = new AESLog(str);
        }
        this.mSliceByLimit = z;
        this.mKey = str;
    }
}
