package com.duokan.kernel.epublib;

import android.util.Log;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes11.dex */
public class DKFileInfo {
    private static final String LOG_TAG = "com.duokan.epublib.DKFileInfo";
    public byte[] data;
    public long dataLength = 0;
    public String extension;

    public void initData(long j) {
        this.dataLength = j;
        this.data = new byte[(int) j];
    }

    public void initExtension(byte[] bArr) {
        try {
            this.extension = new String(bArr, "UTF-32LE");
        } catch (UnsupportedEncodingException e) {
            Log.e(LOG_TAG, "Unsupported encoding exception...", e);
        }
    }
}
