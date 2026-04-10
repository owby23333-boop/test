package com.xm.logsdk.log.logger.crypt;

/* JADX INFO: loaded from: classes8.dex */
public interface ICrypt {

    public interface AESLogCallback {
        void callback(byte[] bArr, boolean z);
    }

    String decrypt(byte[] bArr, int i, int i2);

    byte[] encrypt(byte[] bArr, int i, int i2);
}
