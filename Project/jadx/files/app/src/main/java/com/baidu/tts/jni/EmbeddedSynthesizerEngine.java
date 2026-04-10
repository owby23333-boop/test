package com.baidu.tts.jni;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;

/* JADX INFO: loaded from: classes2.dex */
public class EmbeddedSynthesizerEngine {
    private static final String TAG = "EmbeddedSynthesizerEngine";
    private static OnNewDataListener mNewDataListener;

    public interface OnNewDataListener {
        int onNewData(byte[] bArr, int i2);
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
        } catch (Throwable unused2) {
            LoggerProxy.e(TAG, "so file BDSpeechDecoder_V1 load fail");
        }
        try {
            LoggerProxy.d(TAG, "before load bd_etts");
            System.loadLibrary("bd_etts");
        } catch (Throwable unused3) {
            LoggerProxy.e(TAG, "so file bd_etts load fail");
        }
    }

    public static native int bdTTSCheckDomainFile(byte[] bArr);

    public static native int bdTTSDomainDataInit(byte[] bArr, long j2);

    public static native int bdTTSDomainDataUninit(long j2);

    public static native int bdTTSEngineInit(Context context, byte[] bArr, byte[] bArr2, byte[] bArr3, long[] jArr);

    public static native int bdTTSEngineUninit(long j2);

    public static native String bdTTSGetAESKEY();

    public static native String bdTTSGetDatParam(String str);

    public static native int bdTTSGetDataFileParam(byte[] bArr, int i2, byte[] bArr2);

    public static native long bdTTSGetDomainSampleRate(byte[] bArr);

    public static native synchronized String bdTTSGetEngineParam();

    public static native int bdTTSGetLicense(Context context, String str, String str2, String str3, String str4, String str5);

    public static native long bdTTSGetParam(long j2, int i2);

    public static native long bdTTSGetSpeechSampleRate(byte[] bArr);

    public static native int bdTTSGetTestAuthorize();

    public static native int bdTTSReInitData(Context context, byte[] bArr, byte[] bArr2, long j2);

    public static native int bdTTSSetParam(long j2, int i2, long j3);

    public static native int bdTTSSetParamFloat(long j2, int i2, float f2);

    public static native int bdTTSSetText(long j2, byte[] bArr, int i2);

    public static native synchronized int bdTTSSynthesis(long j2, byte[] bArr, int i2);

    public static native int bdTTSVerifyDataFile(byte[] bArr);

    public static native synchronized int bdTTSVerifyLicense(Context context, String str, String str2, String str3, String str4, byte[] bArr);

    public static native int getEngineMinVersion();

    public static native int loadEnglishEngine(byte[] bArr, byte[] bArr2, long j2);

    public static int newAudioDataCallback(byte[] bArr, int i2) {
        return mNewDataListener.onNewData(bArr, i2);
    }

    public static void setOnNewDataListener(OnNewDataListener onNewDataListener) {
        mNewDataListener = onNewDataListener;
    }
}
