package com.baidu.speechsynthesizer.utility;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

/* JADX INFO: loaded from: classes2.dex */
public class SpeechDecoder {
    private static final String TAG = "SpeechDecoder";
    private static OnDecodedDataListener mDecodedDataListener;

    public interface OnDecodedDataListener {
        void onDecodedData(byte[] bArr);
    }

    static {
        try {
            LoggerProxy.d(TAG, "before load gnustl_shared");
            System.loadLibrary("gnustl_shared");
        } catch (Throwable unused) {
            LoggerProxy.e(TAG, "so file gnustl_shared load fail");
        }
        try {
            LoggerProxy.d(TAG, "before load BDSpeechDecoder_V1");
            System.loadLibrary("BDSpeechDecoder_V1");
            LoggerProxy.d(TAG, "after load BDSpeechDecoder_V1");
        } catch (Throwable unused2) {
            LoggerProxy.e(TAG, "so file BDSpeechDecoder_V1 load fail");
        }
    }

    public static native int decodeWithCallback(byte[] bArr, Object obj, int i2);

    public static void setOnDecodedDataListener(OnDecodedDataListener onDecodedDataListener) {
        mDecodedDataListener = onDecodedDataListener;
    }

    public native int decode(byte[] bArr, int i2, short[] sArr, int[] iArr, int i3, int i4);

    public int decodeWithCallback(byte[] bArr, int i2) {
        return decodeWithCallback(bArr, this, i2);
    }

    public void decode_audio_callback(byte[] bArr) {
        mDecodedDataListener.onDecodedData(bArr);
    }
}
