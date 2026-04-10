package com.bykv.vk.component.ttvideo.player;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import com.bykv.vk.component.ttvideo.utils.Util;
import com.google.android.exoplayer2.util.MimeTypes;
import com.xiaomi.onetrack.util.z;
import com.xiaomi.passport.ui.utils.OsHelper;
import com.yuewen.w51;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@Keep
@TargetApi(16)
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

    @CalledByNative
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
        Log.i(TAG, "initialize, need workaround " + mDeviceNeedsSetOutputSurfaceWorkaround);
    }

    public static int ceilDivide(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        int i = Util.SDK_INT;
        return i < 18 || (i == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005f A[Catch: all -> 0x0093, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:10:0x0018, B:51:0x008d, B:13:0x0020, B:35:0x0061, B:50:0x008b, B:40:0x0072, B:43:0x007c, B:34:0x005f, B:20:0x0039, B:23:0x0043, B:26:0x004d, B:52:0x008f), top: B:58:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007c A[Catch: all -> 0x0093, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:10:0x0018, B:51:0x008d, B:13:0x0020, B:35:0x0061, B:50:0x008b, B:40:0x0072, B:43:0x007c, B:34:0x005f, B:20:0x0039, B:23:0x0043, B:26:0x004d, B:52:0x008f), top: B:58:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b A[Catch: all -> 0x0093, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:10:0x0018, B:51:0x008d, B:13:0x0020, B:35:0x0061, B:50:0x008b, B:40:0x0072, B:43:0x007c, B:34:0x005f, B:20:0x0039, B:23:0x0043, B:26:0x004d, B:52:0x008f), top: B:58:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        /*
            java.lang.Class<com.bykv.vk.component.ttvideo.player.AJMediaCodec> r0 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.class
            monitor-enter(r0)
            boolean r1 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround     // Catch: java.lang.Throwable -> L93
            if (r1 != 0) goto L8f
            int r1 = com.bykv.vk.component.ttvideo.utils.Util.SDK_INT     // Catch: java.lang.Throwable -> L93
            r2 = 27
            r3 = 1
            if (r1 > r2) goto L1c
            java.lang.String r4 = "dangal"
            java.lang.String r5 = com.bykv.vk.component.ttvideo.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L93
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L1c
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
            goto L8d
        L1c:
            if (r1 < r2) goto L20
            goto L8d
        L20:
            java.lang.String r1 = com.bykv.vk.component.ttvideo.utils.Util.DEVICE     // Catch: java.lang.Throwable -> L93
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L93
            r4 = 99329(0x18401, float:1.3919E-40)
            r5 = 0
            r6 = 2
            r7 = -1
            if (r2 == r4) goto L4d
            r4 = 3351335(0x332327, float:4.69622E-39)
            if (r2 == r4) goto L43
            r4 = 1865889110(0x6f373556, float:5.6700236E28)
            if (r2 == r4) goto L39
            goto L57
        L39:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L57
            r1 = r6
            goto L58
        L43:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L57
            r1 = r3
            goto L58
        L4d:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L57
            r1 = r5
            goto L58
        L57:
            r1 = r7
        L58:
            if (r1 == 0) goto L5f
            if (r1 == r3) goto L5f
            if (r1 == r6) goto L5f
            goto L61
        L5f:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
        L61:
            java.lang.String r1 = com.bykv.vk.component.ttvideo.utils.Util.MODEL     // Catch: java.lang.Throwable -> L93
            int r2 = r1.hashCode()     // Catch: java.lang.Throwable -> L93
            r4 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r4) goto L7c
            r4 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r4) goto L72
            goto L85
        L72:
            java.lang.String r2 = "AFTN"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L85
            r5 = r3
            goto L86
        L7c:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L93
            if (r1 == 0) goto L85
            goto L86
        L85:
            r5 = r7
        L86:
            if (r5 == 0) goto L8b
            if (r5 == r3) goto L8b
            goto L8d
        L8b:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
        L8d:
            com.bykv.vk.component.ttvideo.player.AJMediaCodec.mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = r3     // Catch: java.lang.Throwable -> L93
        L8f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            boolean r0 = com.bykv.vk.component.ttvideo.player.AJMediaCodec.mDeviceNeedsSetOutputSurfaceWorkaround
            return r0
        L93:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L93
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.player.AJMediaCodec.codecNeedsSetOutputSurfaceWorkaround():boolean");
    }

    private void createDummySurface() {
        Log.d(TAG, "create dummy surface");
        this.mDummySurface = DummySurface.newInstanceV17(false);
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
        } else if (!str.equals(MimeTypes.VIDEO_H264)) {
            if (!str.equals(MimeTypes.VIDEO_VP8)) {
                if (!str.equals(MimeTypes.VIDEO_H265) && !str.equals(MimeTypes.VIDEO_VP9)) {
                    return -1;
                }
                iCeilDivide = i * i2;
                i3 = 4;
            }
            iCeilDivide = i * i2;
            i3 = 2;
        } else {
            if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                return -1;
            }
            iCeilDivide = ceilDivide(i, 16) * ceilDivide(i2, 16) * 16 * 16;
            i3 = 2;
        }
        return (iCeilDivide * 3) / (i3 * 2);
    }

    public static String getProperty(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            } catch (Exception e) {
                e.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
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
            Log.w(TAG, "vendor property abnormal");
            d = w51.l;
        }
        return d < FIX_VERSION;
    }

    private boolean isMtkByteVC1BlockList() {
        String lowerCase = Util.HARDWARE.toLowerCase(Locale.US);
        return lowerCase.startsWith("mt6763") || lowerCase.startsWith("mt6757") || lowerCase.startsWith("mt6739") || lowerCase.startsWith("mt6750");
    }

    private static void maybeSetCsdBuffers(android.media.MediaFormat mediaFormat, ByteBuffer byteBuffer, int i) {
        if (byteBuffer == null) {
            return;
        }
        mediaFormat.setByteBuffer("csd-" + i, byteBuffer);
    }

    private static void maybeSetInteger(android.media.MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodec(MediaCodec mediaCodec) {
        Surface surface;
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.release();
            surface = this.mDummySurface;
        } catch (Exception unused) {
            if (this.mDummySurface != null) {
                surface = this.mDummySurface;
            }
        } catch (Throwable th) {
            if (this.mDummySurface != null) {
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            Log.i(TAG, "codec release end");
            throw th;
        }
        if (surface != null) {
            surface.release();
            this.mDummySurface = null;
        }
        Log.i(TAG, "codec release end");
    }

    @TargetApi(21)
    private int renderOutputBufferV21(int i, long j) {
        try {
            this.mMediaCodec.releaseOutputBuffer(i, j);
            return 0;
        } catch (Exception unused) {
            return -10000;
        }
    }

    @TargetApi(23)
    private int setOutputSurfaceV23(MediaCodec mediaCodec, Surface surface) {
        try {
            mediaCodec.setOutputSurface(surface);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            Log.w(TAG, "setoutputsurface failed = " + e);
            return -1;
        }
    }

    @CalledByNative
    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    @CalledByNative
    public void close() {
        Log.i(TAG, "close start");
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
                        Log.i(AJMediaCodec.TAG, "start releaseCodec task");
                        AJMediaCodec.this.releaseCodec(mediaCodec);
                    }
                });
            } catch (Throwable unused) {
                Log.w(TAG, "new thread failed");
                releaseCodec(mediaCodec);
            }
        }
        Log.i(TAG, "close end");
    }

    @CalledByNative
    public int configure(int i, int i2, int i3, int i4, int i5, String str, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, Surface surface, boolean z, boolean z2, int i6, int i7, boolean z3, int i8, boolean z4, boolean z5, int i9, int i10) {
        Surface surface2 = surface;
        int i11 = i6;
        int i12 = i7;
        Log.i(TAG, "configure =" + surface2 + ", surfaceConfigure =" + z);
        android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
        mediaFormat.setString("mime", str);
        maybeSetInteger(mediaFormat, "width", i);
        maybeSetInteger(mediaFormat, "height", i2);
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
        Log.i(TAG, "format  = " + mediaFormat);
        int maxInputSize = getMaxInputSize(str, i, i2);
        Log.i(TAG, "max input = " + maxInputSize);
        maybeSetInteger(mediaFormat, "max-input-size", maxInputSize);
        maybeSetCsdBuffers(mediaFormat, byteBuffer, 0);
        maybeSetCsdBuffers(mediaFormat, byteBuffer2, 1);
        maybeSetCsdBuffers(mediaFormat, byteBuffer3, 2);
        if (z) {
            int i13 = Util.SDK_INT;
            if (i13 >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            if ((surface2 == null || !surface.isValid()) && this.mDummySurface == null && i13 >= 23 && !mDeviceNeedsSetOutputSurfaceWorkaround) {
                Log.i(TAG, "create dummy surface");
                createDummySurface();
                surface2 = this.mDummySurface;
            }
            if (surface2 == null) {
                this.mExceptionInfo = "Error: configure with null surface";
                return -10003;
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
            Log.d(TAG, "dv codecs = " + dolbyCodecs);
            Pair<Integer, Integer> dolbyVisionProfileAndLevel = MediaCodecUtil.getDolbyVisionProfileAndLevel(dolbyCodecs, dolbyCodecs.split(z.f7779a));
            if (dolbyVisionProfileAndLevel != null) {
                Log.d(TAG, "dv profile & level  = " + dolbyVisionProfileAndLevel.toString());
                maybeSetInteger(mediaFormat, "profile", ((Integer) dolbyVisionProfileAndLevel.first).intValue());
            }
        }
        try {
            this.mMediaCodec.configure(mediaFormat, surface2, (MediaCrypto) null, 0);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            Log.d(TAG, "configure failed = " + this.mMediaCodec + ", ex=" + e.toString());
            return e instanceof IllegalArgumentException ? -10003 : -1;
        }
    }

    @CalledByNative
    public int createByCodecName(String str) {
        Log.i(TAG, "createByCodecName = " + str);
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            Log.d(TAG, "createByCodecName fail = " + e.toString());
            return -1;
        }
    }

    @TargetApi(23)
    @CalledByNative
    public void decodeFRC(int i) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23) {
            return;
        }
        Log.i(TAG, "frc level = " + i);
        Bundle bundle = new Bundle();
        bundle.putInt("vivo.video-dec.dynamic-frc", i);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e) {
            Log.w(TAG, "setParameters failed ret = " + e);
        }
    }

    @CalledByNative
    public int dequeueInputBuffer(long j) {
        try {
            return this.mMediaCodec.dequeueInputBuffer(j);
        } catch (Exception e) {
            Log.d(TAG, "dequeueInputBuffer failed, exception: " + e);
            return handleCodecException(e);
        }
    }

    @CalledByNative
    public void flush() {
        Log.i(TAG, "flush");
        try {
            this.mMediaCodec.flush();
        } catch (Exception unused) {
        }
        Log.i(TAG, "flush done");
    }

    @CalledByNative
    public String getBestCodecName(String str) {
        String[] supportedTypes;
        AJMediaCodecRank aJMediaCodecRank;
        if (Util.SDK_INT < 16) {
            Log.d(TAG, "API < 16");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals(MimeTypes.VIDEO_H265) && mIsByteVC1Blocklist) {
            Log.w(TAG, "the device is hw decoder blocklist," + Util.HARDWARE);
            return null;
        }
        Log.i(TAG, "detect hardware codec by codecType = " + str);
        ArrayList<AJMediaCodecRank> arrayList = new ArrayList();
        synchronized (mCodecListLock) {
            boolean z = !mVideoHWDecoderCodecs.isEmpty();
            try {
                int size = z ? mVideoHWDecoderCodecs.size() : MediaCodecList.getCodecCount();
                for (int i = 0; i < size && (!z || arrayList.isEmpty()); i++) {
                    MediaCodecInfo codecInfoAt = z ? mVideoHWDecoderCodecs.get(i) : MediaCodecList.getCodecInfoAt(i);
                    String name = codecInfoAt.getName();
                    Log.d(TAG, "found codec name : " + name);
                    if (!codecInfoAt.isEncoder() && !name.startsWith("OMX.google") && !name.startsWith("c2.android") && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                        for (String str2 : supportedTypes) {
                            if (!TextUtils.isEmpty(str2)) {
                                if (!z && str2.startsWith("video/")) {
                                    mVideoHWDecoderCodecs.add(codecInfoAt);
                                }
                                if (str2.equalsIgnoreCase(str)) {
                                    Log.d(TAG, "codec types : " + str2);
                                    if ((name.startsWith("OMX.") || name.startsWith("c2.")) && !name.startsWith("OMX.pv") && !name.startsWith("OMX.ittiam") && !name.contains("ffmpeg") && !name.contains("avcodec") && !name.contains("secure") && ((!name.startsWith("OMX.MTK.") || Util.SDK_INT >= 18) && !codecNeedsFlushWorkaround(name) && (aJMediaCodecRank = AJMediaCodecRank.setupRank(codecInfoAt, str)) != null)) {
                                        Log.i(TAG, "codec : " + aJMediaCodecRank.mMediaCodecInfo.getName() + ",  rank : " + aJMediaCodecRank.mRank);
                                        int i2 = aJMediaCodecRank.mRank;
                                        if (i2 == 40 && Util.SDK_INT < 21) {
                                            Log.w(TAG, "skip vendor mediacodec api impl ambiguous");
                                        } else if (i2 == 20) {
                                            Log.w(TAG, "skip vendor software codec");
                                        } else {
                                            arrayList.add(aJMediaCodecRank);
                                        }
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
                Log.w(TAG, "mediaserver died");
                return null;
            }
        }
    }

    @CalledByNative
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

    @CalledByNative
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

    @CalledByNative
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

    @CalledByNative
    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    @CalledByNative
    public int getFormatHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP) ? (this.mOutputMediaFormat.getInteger(KEY_CROP_BOTTOM) - this.mOutputMediaFormat.getInteger(KEY_CROP_TOP)) + 1 : this.mOutputMediaFormat.getInteger("height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public int getFormatWidth() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP) ? (this.mOutputMediaFormat.getInteger(KEY_CROP_RIGHT) - this.mOutputMediaFormat.getInteger(KEY_CROP_LEFT)) + 1 : this.mOutputMediaFormat.getInteger("width");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @CalledByNative
    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mInputBuffers;
        }
        return null;
    }

    @CalledByNative
    public int getOSVerion() {
        return Util.SDK_INT;
    }

    @CalledByNative
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

    @CalledByNative
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

    @CalledByNative
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

    public int handleCodecException(Exception exc) {
        this.mExceptionInfo = exc.toString();
        return Util.SDK_INT >= 21 ? handleCodecExceptionV21(exc) : exc instanceof IllegalStateException ? -10002 : -10000;
    }

    @TargetApi(21)
    public int handleCodecExceptionV21(Exception exc) {
        if (exc instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
            if (Util.SDK_INT >= 23) {
                Log.d(TAG, "exception codecExc isRecoverable: " + codecException.isRecoverable() + ", errorcode: " + codecException.getErrorCode());
                if (!codecException.isRecoverable() && codecException.getErrorCode() != 1100 && codecException.getErrorCode() != 1101) {
                    return -10001;
                }
            } else {
                Log.d(TAG, "exception codecExc isRecoverable: " + codecException.isRecoverable());
                if (!codecException.isRecoverable()) {
                    return -10001;
                }
            }
        }
        return exc instanceof IllegalStateException ? -10002 : -10000;
    }

    public int open(int i, int i2, int i3, String str, String str2, ByteBuffer byteBuffer, Surface surface) {
        Log.i(TAG, "open, rotation = " + i3 + "; codecName = " + str + "; codecType =" + str2);
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(str);
            Log.i(TAG, "configure mediacodec");
            android.media.MediaFormat mediaFormat = new android.media.MediaFormat();
            mediaFormat.setString("mime", str2);
            maybeSetInteger(mediaFormat, "width", i);
            maybeSetInteger(mediaFormat, "height", i2);
            if (byteBuffer != null) {
                mediaFormat.setByteBuffer("csd-0", byteBuffer);
            }
            if (surface != null && Util.SDK_INT >= 21) {
                maybeSetInteger(mediaFormat, "rotation-degrees", i3);
            }
            try {
                this.mMediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
                Log.i(TAG, "mediacodec start");
                try {
                    this.mMediaCodec.start();
                    this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                    this.mInputBuffersValid = true;
                    Log.d(TAG, String.format(Locale.US, "open() input params. width:%d,height:%d", Integer.valueOf(i), Integer.valueOf(i2)));
                    return 0;
                } catch (Exception e) {
                    Log.d(TAG, e.toString());
                    return -1;
                }
            } catch (Exception e2) {
                Log.d(TAG, e2.toString());
                return -1;
            }
        } catch (Exception e3) {
            Log.d(TAG, e3.toString());
            return -1;
        }
    }

    @CalledByNative
    public int queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        try {
            this.mMediaCodec.queueInputBuffer(i, i2, i3, j, i4);
            return 0;
        } catch (Exception e) {
            Log.d(TAG, "queueInputBuffer failed, exception: " + e);
            return handleCodecException(e);
        }
    }

    @CalledByNative
    public int read(AJMediaCodecFrame aJMediaCodecFrame, long j) {
        while (true) {
            try {
                int iDequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, j);
                if (iDequeueOutputBuffer >= 0) {
                    aJMediaCodecFrame.data = this.mOutputBuffers[iDequeueOutputBuffer];
                    MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
                    aJMediaCodecFrame.pts = bufferInfo.presentationTimeUs;
                    aJMediaCodecFrame.index = iDequeueOutputBuffer;
                    aJMediaCodecFrame.size = bufferInfo.size;
                    aJMediaCodecFrame.flags = bufferInfo.flags;
                    return 0;
                }
                if (iDequeueOutputBuffer != -3) {
                    if (iDequeueOutputBuffer != -2) {
                        if (iDequeueOutputBuffer != -1) {
                            Log.e(TAG, "error, idx = " + iDequeueOutputBuffer);
                        }
                        return -1;
                    }
                    Log.i(TAG, "INFO_OUTPUT_FORMAT_CHANGED");
                    try {
                        this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();
                        if (this.mOutputBuffers == null) {
                            try {
                                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                            } catch (Exception e) {
                                Log.i(TAG, "getOutputBuffers e = " + e);
                                return handleCodecException(e);
                            }
                        }
                        return iDequeueOutputBuffer;
                    } catch (Exception e2) {
                        Log.i(TAG, "getOutputFormat e =" + e2);
                        return handleCodecException(e2);
                    }
                }
                Log.i(TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
                try {
                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                } catch (Exception e3) {
                    Log.i(TAG, "getOutputBuffers e = " + e3);
                    return handleCodecException(e3);
                }
            } catch (Exception e4) {
                Log.i(TAG, "dequeueOutputBuffer e :" + e4);
                return handleCodecException(e4);
            }
        }
    }

    @CalledByNative
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

    @CalledByNative
    public int setOutputSurface(Surface surface) {
        Log.d(TAG, "setoutput surface = " + surface);
        if (mDeviceNeedsSetOutputSurfaceWorkaround || !this.mInputBuffersValid) {
            return -1;
        }
        if (surface == null) {
            if (this.mDummySurface == null) {
                createDummySurface();
            }
            surface = this.mDummySurface;
            Log.i(TAG, "use dummy surface");
        }
        Log.d(TAG, "setoutputSurface = " + surface);
        return setOutputSurfaceV23(this.mMediaCodec, surface);
    }

    @TargetApi(23)
    @CalledByNative
    public void speedEnhance(float f) {
        if (this.mMediaCodec == null || !this.mInputBuffersValid || Util.SDK_INT < 23 || f <= 30.0f) {
            return;
        }
        Log.i(TAG, "rate " + f);
        Bundle bundle = new Bundle();
        bundle.putFloat("operating-rate", f);
        try {
            this.mMediaCodec.setParameters(bundle);
        } catch (Exception e) {
            Log.w(TAG, "setParameters failed ret = " + e);
        }
    }

    @CalledByNative
    public int start() {
        Log.i(TAG, "start");
        try {
            this.mMediaCodec.start();
            this.mInputBuffers = this.mMediaCodec.getInputBuffers();
            if (Util.SDK_INT >= 21) {
                this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
            }
            this.mInputBuffersValid = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            Log.i(TAG, "start end");
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            return -1;
        }
    }

    @CalledByNative
    public int stop() {
        if (this.mInputBuffersValid) {
            Log.i(TAG, "stop");
            try {
                this.mInputBuffersValid = false;
                this.mMediaCodec.stop();
            } catch (Exception unused) {
                Log.d(TAG, "mediacodec stop exception");
                return -1;
            }
        }
        return 0;
    }

    @CalledByNative
    public int vendorOppoHWEnable() {
        if (Util.BARND.equals(OsHelper.ROM_OPPO)) {
            String property = getProperty(VENDOR_OPPO_PROPERTY, "1");
            Log.i(TAG, "oppo property = " + property);
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                Log.w(TAG, "vendor oppo property abnormal");
            }
        }
        return 1;
    }

    @CalledByNative
    public int write(AJMediaCodecFrame aJMediaCodecFrame) {
        if (aJMediaCodecFrame == null || aJMediaCodecFrame.data == null) {
            Log.d(TAG, "buffer is nullpoint");
            return -1;
        }
        try {
            int iDequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(30000L);
            if (iDequeueInputBuffer < 0) {
                return iDequeueInputBuffer == -1 ? 4 : -1;
            }
            this.mInputBuffers[iDequeueInputBuffer].put(aJMediaCodecFrame.data);
            this.mMediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, aJMediaCodecFrame.size, aJMediaCodecFrame.pts, 0);
            return 0;
        } catch (Exception e) {
            Log.e(TAG, "write meet exception =" + e);
            return -1;
        }
    }
}
