package com.dangdang.reader.dread.jni;

import com.dangdang.zframework.log.LogM;

/* JADX INFO: loaded from: classes10.dex */
public class DrmWarp {
    public static final int FAILED = -1;
    public static final int SUCCESS = 1;
    private byte[] deCryptData;
    private byte[] enCryptData;
    private String publicKey;

    static {
        System.loadLibrary("ddlayoutkit");
    }

    public static DrmWarp getInstance() {
        return new DrmWarp();
    }

    public native int deCryptFile(String str, int i);

    public native int deCryptPic(String str, int i);

    public native int enCrypt(byte[] bArr);

    public native String generateSignature(String str, String str2, String str3);

    public byte[] getDeCryptAfterData() {
        return this.deCryptData;
    }

    public byte[] getEnCryptData() {
        return this.enCryptData;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public native int getPublicKeyN();

    public native int init(String str, String str2);

    public native boolean initBookKey(String str, byte[] bArr, String str2, boolean z, boolean z2);

    public final native String safe(String str, String str2, String str3, Integer num);

    public final native String safeMagic(String str, String str2, Integer num);

    public native void setBasePackageName(String str, boolean z);

    public void setDeCryptAfterData(byte[] bArr) {
        LogM.i(getClass().getSimpleName(), " setDeCryptAfterData byte[].length = " + bArr.length);
        this.deCryptData = bArr;
    }

    public void setEnCryptData(byte[] bArr) {
        this.enCryptData = bArr;
    }

    public void setPublicKey(String str) {
        this.publicKey = str;
        LogM.d(getClass().getSimpleName(), " setPublicKey = " + str);
    }

    public native int verifyRSAKey();
}
