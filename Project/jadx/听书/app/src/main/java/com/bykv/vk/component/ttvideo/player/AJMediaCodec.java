package com.bykv.vk.component.ttvideo.player;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.utils.Util;
import com.bytedance.sdk.component.utils.wp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class AJMediaCodec {
    private static final int AV_TRC_ARIB_STD_B67 = 18;
    private static final int AV_TRC_SMPTE2084 = 16;
    private static final int CODEC_ERROR = -10000;
    private static final int CODEC_EXCEPTION_ERROR = -10001;
    private static final int CODEC_ILLEGAL_ARGUMENT = -10003;
    private static final int CODEC_ILLEGAL_STATE = -10002;
    private static final double FIX_VERSION = 0.18041d;
    private static final long INPUT_TIMEOUT_US = 30000;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int NO_VALUE = -1;
    private static final int PIXEL_FORMAT_NV12 = 3;
    private static final int PIXEL_FORMAT_YUV420P = 0;
    private static final String TAG = "aj_media_codec";
    private static final String VENDOR_OPPO_PROPERTY = "persist.sys.aweme.hdsupport";
    private static final String VERSION_PROPERTY = "ro.config.hw_codec_support";
    private MediaCodec.BufferInfo mBufferInfo;
    private Surface mDummySurface;
    private String mExceptionInfo;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private static ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs = new ArrayList<>();
    private static Object mCodecListLock = new Object();
    private static boolean mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mIsInitDetected = false;
    private static boolean mIsByteVC1Blocklist = false;
    private static boolean mNeedByteVC1WorkAround = false;
    private boolean mInputBuffersValid = false;
    private android.media.MediaFormat mOutputMediaFormat = null;

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    public static String getProperty(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
                return str3;
            } catch (Exception e) {
                wp.z(e);
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public AJMediaCodec() {
        boolean z = false;
        if (!mIsInitDetected) {
            if (Util.HARDWARE.toLowerCase(Locale.US).startsWith("mt") && Util.SDK_INT < 26) {
                z = true;
            }
            mNeedByteVC1WorkAround = z;
            if (isHisiByteVC1BlockList() || isMtkByteVC1BlockList()) {
                mIsByteVC1Blocklist = true;
            }
        }
        codecNeedsSetOutputSurfaceWorkaround();
        mIsInitDetected = true;
        wp.z(TAG, "initialize, need workaround " + mDeviceNeedsSetOutputSurfaceWorkaround);
    }

    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    private boolean isHisiByteVC1BlockList() {
        double d;
        String property = getProperty("ro.board.platform", null);
        if (Util.SDK_INT != 26 || property == null) {
            return false;
        }
        if (!property.startsWith("kirin960") && !property.startsWith("hi3660")) {
            return false;
        }
        try {
            d = Double.parseDouble(getProperty(VERSION_PROPERTY, "0.0"));
        } catch (NumberFormatException unused) {
            wp.g(TAG, "vendor property abnormal");
            d = 0.0d;
        }
        return d < FIX_VERSION;
    }

    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    private boolean isMtkByteVC1BlockList() {
        String lowerCase = Util.HARDWARE.toLowerCase(Locale.US);
        return lowerCase.startsWith("mt6763") || lowerCase.startsWith("mt6757") || lowerCase.startsWith("mt6739") || lowerCase.startsWith("mt6750");
    }

    public int vendorOppoHWEnable() {
        if (Util.BARND.equals("OPPO")) {
            String property = getProperty(VENDOR_OPPO_PROPERTY, "1");
            wp.z(TAG, "oppo property = ".concat(String.valueOf(property)));
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                wp.g(TAG, "vendor oppo property abnormal");
            }
        }
        return 1;
    }

    public int createByCodecName(String str) {
        wp.z(TAG, "createByCodecName = ".concat(String.valueOf(str)));
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            return -1;
        }
    }

    private static void maybeSetInteger(android.media.MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    private static void maybeSetCsdBuffers(android.media.MediaFormat mediaFormat, ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            return;
        }
        mediaFormat.setByteBuffer("csd-".concat(String.valueOf(i)), byteBuffer);
    }

    private void createDummySurface() {
        this.mDummySurface = DummySurface.newInstanceV17(false);
    }

    public int configure(int i, int i2, int i3, int i4, int i5, String str, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, Surface surface, boolean z, boolean z2, int i6, int i7, boolean z3, int i8, boolean z4, boolean z5, int i9, int i10) {
        Surface surface2 = surface;
        int i11 = i6;
        int i12 = i7;
        wp.z(TAG, "configure =" + surface2 + ", surfaceConfigure =" + z);
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", str);
        maybeSetInteger(mediaFormat, MediaFormat.KEY_WIDTH, i);
        maybeSetInteger(mediaFormat, MediaFormat.KEY_HEIGHT, i2);
        if (i11 != -1 && i12 != -1) {
            if (i11 <= i) {
                i11 = i;
            }
            maybeSetInteger(mediaFormat, "max-width", i11);
            if (i12 <= i2) {
                i12 = i2;
            }
            maybeSetInteger(mediaFormat, "max-height", i12);
        }
        maybeSetInteger(mediaFormat, MediaFormat.KEY_SAMPLE_RATE, i4);
        maybeSetInteger(mediaFormat, MediaFormat.KEY_CHANNEL_COUNT, i5);
        wp.z(TAG, "format  = ".concat(String.valueOf(mediaFormat)));
        int maxInputSize = getMaxInputSize(str, i, i2);
        wp.z(TAG, "max input = ".concat(String.valueOf(maxInputSize)));
        maybeSetInteger(mediaFormat, "max-input-size", maxInputSize);
        maybeSetCsdBuffers(mediaFormat, byteBuffer, 0);
        maybeSetCsdBuffers(mediaFormat, byteBuffer2, 1);
        maybeSetCsdBuffers(mediaFormat, byteBuffer3, 2);
        if (z) {
            if (Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            if ((surface2 == null || !surface.isValid()) && this.mDummySurface == null && Util.SDK_INT >= 23 && !mDeviceNeedsSetOutputSurfaceWorkaround) {
                wp.z(TAG, "create dummy surface");
                createDummySurface();
                surface2 = this.mDummySurface;
            }
            if (surface2 == null) {
                this.mExceptionInfo = "Error: configure with null surface";
                return CODEC_ILLEGAL_ARGUMENT;
            }
        }
        if (Util.SDK_INT >= 23 && z2) {
            mediaFormat.setInteger("priority", 0);
        }
        if (z3) {
            VendorQTI.setupVpp(mediaFormat, i8);
        }
        if (z4) {
            VendorQTI.debugEffect(mediaFormat);
        }
        if (z5) {
            VendorQTI.enableLowLatency(mediaFormat);
        }
        if (i10 > 0 && i9 >= 0) {
            String dolbyCodecs = MediaCodecUtil.getDolbyCodecs(i9, i10);
            Pair<Integer, Integer> dolbyVisionProfileAndLevel = MediaCodecUtil.getDolbyVisionProfileAndLevel(dolbyCodecs, dolbyCodecs.split("\\."));
            if (dolbyVisionProfileAndLevel != null) {
                maybeSetInteger(mediaFormat, "profile", ((Integer) dolbyVisionProfileAndLevel.first).intValue());
            }
        }
        try {
            this.mMediaCodec.configure(mediaFormat, surface2, (MediaCrypto) null, 0);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            if (e instanceof IllegalArgumentException) {
                return CODEC_ILLEGAL_ARGUMENT;
            }
            return -1;
        }
    }

    public int start() {
        wp.z(TAG, TtmlNode.START);
        try {
            this.mMediaCodec.start();
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            if (Util.SDK_INT >= 21) {
                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
            }
            this.mInputBuffersValid = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            wp.z(TAG, "start end");
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            return -1;
        }
    }

    public int open(int i, int i2, int i3, String str, String str2, ByteBuffer byteBuffer, Surface surface) {
        wp.z(TAG, "open, rotation = " + i3 + "; codecName = " + str + "; codecType =" + str2);
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            wp.z(TAG, "configure mediacodec");
            android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
            mediaFormat.setString("mime", str2);
            maybeSetInteger(mediaFormat, MediaFormat.KEY_WIDTH, i);
            maybeSetInteger(mediaFormat, MediaFormat.KEY_HEIGHT, i2);
            if (byteBuffer != null) {
                mediaFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (surface != null && Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            this.mMediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            wp.z(TAG, "mediacodec start");
            this.mMediaCodec.start();
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            this.mInputBuffersValid = true;
            String.format(Locale.US, "open() input params. width:%d,height:%d", Integer.valueOf(i), Integer.valueOf(i2));
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public int stop() {
        if (this.mInputBuffersValid) {
            wp.z(TAG, "stop");
            try {
                this.mInputBuffersValid = false;
                this.mMediaCodec.stop();
            } catch (Exception unused) {
                return -1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodec(MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.release();
            Surface surface = this.mDummySurface;
            if (surface != null) {
                surface.release();
                this.mDummySurface = null;
            }
            wp.z(TAG, "codec release end");
        } catch (Exception unused) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            wp.z(TAG, "codec release end");
        } catch (Throwable th) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            wp.z(TAG, "codec release end");
            throw th;
        }
    }

    public void close() {
        wp.z(TAG, "close start");
        if (this.mMediaCodec != null) {
            stop();
            final MediaCodec mediaCodec = this.mMediaCodec;
            this.mInputBuffers = null;
            this.mOutputBuffers = null;
            this.mMediaCodec = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.bykv.vk.component.ttvideo.player.AJMediaCodec.1
                    @Override // java.lang.Runnable
                    public void run() {
                        wp.z(AJMediaCodec.TAG, "start releaseCodec task");
                        AJMediaCodec.this.releaseCodec(mediaCodec);
                    }
                });
            } catch (Throwable unused) {
                wp.g(TAG, "new thread failed");
                releaseCodec(mediaCodec);
            }
        }
        wp.z(TAG, "close end");
    }

    private int renderOutputBufferV21(int i, long j) {
        try {
            this.mMediaCodec.releaseOutputBuffer(i, j);
            return 0;
        } catch (Exception unused) {
            return -10000;
        }
    }

    public int handleCodecExceptionV21(Exception exc) {
        if (exc instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
            if (Util.SDK_INT >= 23) {
                codecException.isRecoverable();
                codecException.getErrorCode();
                if (!codecException.isRecoverable() && codecException.getErrorCode() != 1100 && codecException.getErrorCode() != 1101) {
                    return CODEC_EXCEPTION_ERROR;
                }
            } else {
                codecException.isRecoverable();
                if (!codecException.isRecoverable()) {
                    return CODEC_EXCEPTION_ERROR;
                }
            }
        }
        if (exc instanceof IllegalStateException) {
            return CODEC_ILLEGAL_STATE;
        }
        return -10000;
    }

    public int handleCodecException(Exception exc) {
        this.mExceptionInfo = exc.toString();
        if (Util.SDK_INT >= 21) {
            return handleCodecExceptionV21(exc);
        }
        if (exc instanceof IllegalStateException) {
            return CODEC_ILLEGAL_STATE;
        }
        return -10000;
    }

    public int dequeueInputBuffer(long j) {
        try {
            return this.mMediaCodec.dequeueInputBuffer(j);
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mInputBuffers;
        }
        return null;
    }

    public int queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        try {
            this.mMediaCodec.queueInputBuffer(i, i2, i3, j, i4);
            return 0;
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public int setOutputSurface(Surface surface) {
        if (mDeviceNeedsSetOutputSurfaceWorkaround || !this.mInputBuffersValid) {
            return -1;
        }
        if (surface == null) {
            if (this.mDummySurface == null) {
                createDummySurface();
            }
            surface = this.mDummySurface;
            wp.z(TAG, "use dummy surface");
        }
        return setOutputSurfaceV23(this.mMediaCodec, surface);
    }

    public int write(AJMediaCodecFrame aJMediaCodecFrame) {
        if (aJMediaCodecFrame != null && aJMediaCodecFrame.data != null) {
            try {
                int iDequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(30000L);
                if (iDequeueInputBuffer < 0) {
                    return iDequeueInputBuffer == -1 ? 4 : -1;
                }
                this.mInputBuffers[iDequeueInputBuffer].put(aJMediaCodecFrame.data);
                this.mMediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, aJMediaCodecFrame.size, aJMediaCodecFrame.pts, 0);
                return 0;
            } catch (Exception e) {
                wp.a(TAG, "write meet exception =".concat(String.valueOf(e)));
            }
        }
        return -1;
    }

    public int read(AJMediaCodecFrame aJMediaCodecFrame, long j) {
        while (true) {
            try {
                int iDequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, j);
                if (iDequeueOutputBuffer >= 0) {
                    aJMediaCodecFrame.data = this.mOutputBuffers[iDequeueOutputBuffer];
                    aJMediaCodecFrame.pts = this.mBufferInfo.presentationTimeUs;
                    aJMediaCodecFrame.index = iDequeueOutputBuffer;
                    aJMediaCodecFrame.size = this.mBufferInfo.size;
                    aJMediaCodecFrame.flags = this.mBufferInfo.flags;
                    return 0;
                }
                if (iDequeueOutputBuffer != -3) {
                    if (iDequeueOutputBuffer != -2) {
                        if (iDequeueOutputBuffer != -1) {
                            wp.a(TAG, "error, idx = ".concat(String.valueOf(iDequeueOutputBuffer)));
                        }
                        return -1;
                    }
                    wp.z(TAG, "INFO_OUTPUT_FORMAT_CHANGED");
                    try {
                        this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();
                        if (this.mOutputBuffers == null) {
                            try {
                                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                            } catch (Exception e) {
                                wp.z(TAG, "getOutputBuffers e = ".concat(String.valueOf(e)));
                                return handleCodecException(e);
                            }
                        }
                        return iDequeueOutputBuffer;
                    } catch (Exception e2) {
                        wp.z(TAG, "getOutputFormat e =".concat(String.valueOf(e2)));
                        return handleCodecException(e2);
                    }
                }
                wp.z(TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
                try {
                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                } catch (Exception e3) {
                    wp.z(TAG, "getOutputBuffers e = ".concat(String.valueOf(e3)));
                    return handleCodecException(e3);
                }
            } catch (Exception e4) {
                wp.z(TAG, "dequeueOutputBuffer e :".concat(String.valueOf(e4)));
                return handleCodecException(e4);
            }
        }
    }

    public void flush() {
        wp.z(TAG, "flush");
        try {
            this.mMediaCodec.flush();
        } catch (Exception unused) {
        }
        wp.z(TAG, "flush done");
    }

    public int releaseBuffer(int i, boolean z, long j) {
        if (Util.SDK_INT >= 21 && z) {
            return renderOutputBufferV21(i, j);
        }
        try {
            this.mMediaCodec.releaseOutputBuffer(i, z);
            return 0;
        } catch (Exception e) {
            return handleCodecException(e);
        }
    }

    public int getFormatWidth() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_RIGHT) - this.mOutputMediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
                }
                return this.mOutputMediaFormat.getInteger(MediaFormat.KEY_WIDTH);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getFormatHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_BOTTOM) - this.mOutputMediaFormat.getInteger(KEY_CROP_TOP)) + 1;
                }
                return this.mOutputMediaFormat.getInteger(MediaFormat.KEY_HEIGHT);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getStride() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("stride");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getSliceHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("slice-height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getSampleRate() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getChannelCount() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorFormat() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-format");
                return (integer == 21 || integer == 2130706688 || integer == 2141391872) ? 3 : 0;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorTransfer() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-transfer");
                if (integer != 6) {
                    return integer != 7 ? 0 : 18;
                }
                return 16;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getOSVerion() {
        return Util.SDK_INT;
    }

    public void speedEnhance(float f) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23 || f <= 30.0f) {
            return;
        }
        wp.z(TAG, "rate ".concat(String.valueOf(f)));
        Bundle bundle = new Bundle();
        bundle.putFloat("operating-rate", f);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e) {
            wp.g(TAG, "setParameters failed ret = ".concat(String.valueOf(e)));
        }
    }

    public void decodeFRC(int i) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23) {
            return;
        }
        wp.z(TAG, "frc level = ".concat(String.valueOf(i)));
        Bundle bundle = new Bundle();
        bundle.putInt("vivo.video-dec.dynamic-frc", i);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e) {
            wp.g(TAG, "setParameters failed ret = ".concat(String.valueOf(e)));
        }
    }

    public String getBestCodecName(String str) {
        String[] supportedTypes;
        AJMediaCodecRank aJMediaCodecRank;
        if (Util.SDK_INT < 16 || TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(MimeTypes.VIDEO_H265) && mIsByteVC1Blocklist) {
            wp.g(TAG, "the device is hw decoder blocklist," + Util.HARDWARE);
            return null;
        }
        wp.z(TAG, "detect hardware codec by codecType = ".concat(String.valueOf(str)));
        ArrayList<AJMediaCodecRank> arrayList = new ArrayList();
        synchronized (mCodecListLock) {
            boolean z = !mVideoHWDecoderCodecs.isEmpty();
            try {
                int size = z ? mVideoHWDecoderCodecs.size() : MediaCodecList.getCodecCount();
                for (int i = 0; i < size && (!z || arrayList.isEmpty()); i++) {
                    MediaCodecInfo codecInfoAt = z ? mVideoHWDecoderCodecs.get(i) : MediaCodecList.getCodecInfoAt(i);
                    String name = codecInfoAt.getName();
                    if (!codecInfoAt.isEncoder() && !name.startsWith("OMX.google") && !name.startsWith("c2.android") && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                        for (String str2 : supportedTypes) {
                            if (!TextUtils.isEmpty(str2)) {
                                if (!z && str2.startsWith("video/")) {
                                    mVideoHWDecoderCodecs.add(codecInfoAt);
                                }
                                if (str2.equalsIgnoreCase(str) && ((name.startsWith("OMX.") || name.startsWith("c2.")) && !name.startsWith("OMX.pv") && !name.startsWith("OMX.ittiam") && !name.contains("ffmpeg") && !name.contains("avcodec") && !name.contains("secure") && ((!name.startsWith("OMX.MTK.") || Util.SDK_INT >= 18) && !codecNeedsFlushWorkaround(name) && (aJMediaCodecRank = AJMediaCodecRank.setupRank(codecInfoAt, str)) != null))) {
                                    wp.z(TAG, "codec : " + aJMediaCodecRank.mMediaCodecInfo.getName() + ",  rank : " + aJMediaCodecRank.mRank);
                                    if (aJMediaCodecRank.mRank == 40 && Util.SDK_INT < 21) {
                                        wp.g(TAG, "skip vendor mediacodec api impl ambiguous");
                                    } else if (aJMediaCodecRank.mRank == 20) {
                                        wp.g(TAG, "skip vendor software codec");
                                    } else {
                                        arrayList.add(aJMediaCodecRank);
                                    }
                                }
                            }
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                AJMediaCodecRank aJMediaCodecRank2 = (AJMediaCodecRank) arrayList.get(0);
                for (AJMediaCodecRank aJMediaCodecRank3 : arrayList) {
                    if (aJMediaCodecRank3.mRank > aJMediaCodecRank2.mRank) {
                        aJMediaCodecRank2 = aJMediaCodecRank3;
                    }
                }
                return aJMediaCodecRank2.mMediaCodecInfo.getName();
            } catch (Exception unused) {
                wp.g(TAG, "mediaserver died");
                return null;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005b A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:49:0x0087, B:50:0x0089, B:10:0x0018, B:12:0x001c, B:34:0x005d, B:39:0x006e, B:42:0x0078, B:33:0x005b, B:19:0x0035, B:22:0x003f, B:25:0x0049, B:51:0x008b), top: B:57:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078 A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:49:0x0087, B:50:0x0089, B:10:0x0018, B:12:0x001c, B:34:0x005d, B:39:0x006e, B:42:0x0078, B:33:0x005b, B:19:0x0035, B:22:0x003f, B:25:0x0049, B:51:0x008b), top: B:57:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0087 A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:49:0x0087, B:50:0x0089, B:10:0x0018, B:12:0x001c, B:34:0x005d, B:39:0x006e, B:42:0x0078, B:33:0x005b, B:19:0x0035, B:22:0x003f, B:25:0x0049, B:51:0x008b), top: B:57:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        /*
            java.lang.Class<com.bykv.vk.component.ttvideo.player.AJMediaCodec> r0 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.class
            monitor-enter(r0)
            boolean r1 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L8b
            int r1 = com.bykv.vk.component.ttvideo.utils.Util.SDK_INT     // Catch: java.lang.Throwable -> L8f
            r2 = 27
            r3 = 1
            if (r1 > r2) goto L18
            java.lang.String r1 = "dangal"
            java.lang.String r4 = com.bykv.vk.component.ttvideo.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L8f
            boolean r1 = r1.equals(r4)     // Catch: java.lang.Throwable -> L8f
            if (r1 != 0) goto L87
        L18:
            int r1 = com.bykv.vk.component.ttvideo.utils.Util.SDK_INT     // Catch: java.lang.Throwable -> L8f
            if (r1 >= r2) goto L89
            java.lang.String r1 = com.bykv.vk.component.ttvideo.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L8f
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L8f
            r4 = 99329(0x18401, float:1.3919E-40)
            r5 = 0
            r6 = 2
            r7 = -1
            if (r2 == r4) goto L49
            r4 = 3351335(0x332327, float:4.69622E-39)
            if (r2 == r4) goto L3f
            r4 = 1865889110(0x6f373556, float:5.6700236E28)
            if (r2 == r4) goto L35
            goto L53
        L35:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L53
            r1 = r6
            goto L54
        L3f:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L53
            r1 = r3
            goto L54
        L49:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L53
            r1 = r5
            goto L54
        L53:
            r1 = r7
        L54:
            if (r1 == 0) goto L5b
            if (r1 == r3) goto L5b
            if (r1 == r6) goto L5b
            goto L5d
        L5b:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L8f
        L5d:
            java.lang.String r1 = com.bykv.vk.component.ttvideo.utils.Util.MODEL     // Catch: java.lang.Throwable -> L8f
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L8f
            r4 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r4) goto L78
            r4 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r4) goto L6e
            goto L81
        L6e:
            java.lang.String r2 = "AFTN"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L81
            r5 = r3
            goto L82
        L78:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L81
            goto L82
        L81:
            r5 = r7
        L82:
            if (r5 == 0) goto L87
            if (r5 == r3) goto L87
            goto L89
        L87:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L8f
        L89:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L8f
        L8b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            boolean r0 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround
            return r0
        L8f:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8f
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.AJMediaCodec.codecNeedsSetOutputSurfaceWorkaround():boolean");
    }

    private int setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        try {
            mediaCodec.setOutputSurface(surface);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            wp.g(TAG, "setoutputsurface failed = ".concat(String.valueOf(e)));
            return -1;
        }
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    private static int getMaxInputSize(String str, int i, int i2) {
        int iCeilDivide;
        int i3;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        if (str.equals(MimeTypes.VIDEO_H263) || str.equals(MimeTypes.VIDEO_MP4V)) {
            iCeilDivide = i * i2;
            i3 = 2;
        } else if (str.equals(MimeTypes.VIDEO_H264)) {
            if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                return -1;
            }
            iCeilDivide = ceilDivide(i, 16) * ceilDivide(i2, 16) * 16 * 16;
            i3 = 2;
        } else {
            if (!str.equals(MimeTypes.VIDEO_VP8)) {
                if (!str.equals(MimeTypes.VIDEO_H265) && !str.equals(MimeTypes.VIDEO_VP9)) {
                    return -1;
                }
                iCeilDivide = i * i2;
                i3 = 4;
            }
            iCeilDivide = i * i2;
            i3 = 2;
        }
        return (iCeilDivide * 3) / (i3 * 2);
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        if (Util.SDK_INT < 18) {
            return true;
        }
        if (Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) {
            return true;
        }
        if (Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800")) {
            return "OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str);
        }
        return false;
    }
}
