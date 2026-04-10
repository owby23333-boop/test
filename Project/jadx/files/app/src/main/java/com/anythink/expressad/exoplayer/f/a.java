package com.anythink.expressad.exoplayer.f;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class a {
    public static final String a = "MediaCodecInfo";
    public static final int b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f9033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final MediaCodecInfo.CodecCapabilities f9034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f9035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f9038i;

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private a(java.lang.String r1, @androidx.annotation.Nullable java.lang.String r2, @androidx.annotation.Nullable android.media.MediaCodecInfo.CodecCapabilities r3, boolean r4, boolean r5, boolean r6) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = com.anythink.expressad.exoplayer.k.a.a(r1)
            java.lang.String r1 = (java.lang.String) r1
            r0.f9032c = r1
            r0.f9033d = r2
            r0.f9034e = r3
            r0.f9038i = r4
            r1 = 1
            r2 = 0
            if (r5 != 0) goto L2c
            if (r3 == 0) goto L2c
            int r4 = com.anythink.expressad.exoplayer.k.af.a
            r5 = 19
            if (r4 < r5) goto L27
            java.lang.String r4 = "adaptive-playback"
            boolean r4 = r3.isFeatureSupported(r4)
            if (r4 == 0) goto L27
            r4 = 1
            goto L28
        L27:
            r4 = 0
        L28:
            if (r4 == 0) goto L2c
            r4 = 1
            goto L2d
        L2c:
            r4 = 0
        L2d:
            r0.f9035f = r4
            r4 = 21
            if (r3 == 0) goto L46
            int r5 = com.anythink.expressad.exoplayer.k.af.a
            if (r5 < r4) goto L41
            java.lang.String r5 = "tunneled-playback"
            boolean r5 = r3.isFeatureSupported(r5)
            if (r5 == 0) goto L41
            r5 = 1
            goto L42
        L41:
            r5 = 0
        L42:
            if (r5 == 0) goto L46
            r5 = 1
            goto L47
        L46:
            r5 = 0
        L47:
            r0.f9036g = r5
            if (r6 != 0) goto L60
            if (r3 == 0) goto L5f
            int r5 = com.anythink.expressad.exoplayer.k.af.a
            if (r5 < r4) goto L5b
            java.lang.String r4 = "secure-playback"
            boolean r3 = r3.isFeatureSupported(r4)
            if (r3 == 0) goto L5b
            r3 = 1
            goto L5c
        L5b:
            r3 = 0
        L5c:
            if (r3 == 0) goto L5f
            goto L60
        L5f:
            r1 = 0
        L60:
            r0.f9037h = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.a.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean):void");
    }

    public static a a(String str) {
        return new a(str, null, null, true, false, false);
    }

    private int b() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (af.a < 23 || (codecCapabilities = this.f9034e) == null) {
            return -1;
        }
        return codecCapabilities.getMaxSupportedInstances();
    }

    private void c(String str) {
        String str2 = "NoSupport [" + str + "] [" + this.f9032c + ", " + this.f9033d + "] [" + af.f9817e + "]";
    }

    private void d(String str) {
        String str2 = "AssumedSupport [" + str + "] [" + this.f9032c + ", " + this.f9033d + "] [" + af.f9817e + "]";
    }

    private static boolean e(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return af.a >= 21 && codecCapabilities.isFeatureSupported("secure-playback");
    }

    @TargetApi(21)
    private static boolean f(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @TargetApi(23)
    private static int g(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }

    private static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return new a(str, str2, codecCapabilities, false, false, false);
    }

    private static boolean c(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return af.a >= 21 && codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    @TargetApi(21)
    private static boolean d(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static a a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z2, boolean z3) {
        return new a(str, str2, codecCapabilities, false, z2, z3);
    }

    public final boolean b(String str) {
        String strC;
        if (str == null || this.f9033d == null || (strC = o.c(str)) == null) {
            return true;
        }
        if (!this.f9033d.equals(strC)) {
            c("codec.mime " + str + ", " + strC);
            return false;
        }
        Pair<Integer, Integer> pairA = d.a(str);
        if (pairA == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : a()) {
            if (codecProfileLevel.profile == ((Integer) pairA.first).intValue() && codecProfileLevel.level >= ((Integer) pairA.second).intValue()) {
                return true;
            }
        }
        c("codec.profileLevel, " + str + ", " + strC);
        return false;
    }

    public final MediaCodecInfo.CodecProfileLevel[] a() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9034e;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @TargetApi(21)
    public final boolean a(int i2, int i3, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9034e;
        if (codecCapabilities == null) {
            c("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("sizeAndRate.vCaps");
            return false;
        }
        if (a(videoCapabilities, i2, i3, d2)) {
            return true;
        }
        if (i2 < i3 && a(videoCapabilities, i3, i2, d2)) {
            String str = "AssumedSupport [" + ("sizeAndRate.rotated, " + i2 + "x" + i3 + "x" + d2) + "] [" + this.f9032c + ", " + this.f9033d + "] [" + af.f9817e + "]";
            return true;
        }
        c("sizeAndRate.support, " + i2 + "x" + i3 + "x" + d2);
        return false;
    }

    @TargetApi(21)
    public final boolean b(int i2) {
        int i3;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9034e;
        if (codecCapabilities == null) {
            c("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("channelCount.aCaps");
            return false;
        }
        String str = this.f9032c;
        String str2 = this.f9033d;
        int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
        if (maxInputChannelCount <= 1 && ((af.a < 26 || maxInputChannelCount <= 0) && !o.f9875t.equals(str2) && !o.I.equals(str2) && !o.J.equals(str2) && !o.f9873r.equals(str2) && !o.G.equals(str2) && !o.H.equals(str2) && !o.f9878w.equals(str2) && !o.K.equals(str2) && !o.f9879x.equals(str2) && !o.f9880y.equals(str2) && !o.M.equals(str2))) {
            if (o.f9881z.equals(str2)) {
                i3 = 6;
            } else {
                i3 = o.A.equals(str2) ? 16 : 30;
            }
            String str3 = "AssumedMaxChannelAdjustment: " + str + ", [" + maxInputChannelCount + " to " + i3 + "]";
            maxInputChannelCount = i3;
        }
        if (maxInputChannelCount >= i2) {
            return true;
        }
        c("channelCount.support, ".concat(String.valueOf(i2)));
        return false;
    }

    @TargetApi(21)
    public final Point a(int i2, int i3) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9034e;
        if (codecCapabilities == null) {
            c("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            c("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(af.a(i2, widthAlignment) * widthAlignment, af.a(i3, heightAlignment) * heightAlignment);
    }

    @TargetApi(21)
    public final boolean a(int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.f9034e;
        if (codecCapabilities == null) {
            c("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            c("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i2)) {
            return true;
        }
        c("sampleRate.support, ".concat(String.valueOf(i2)));
        return false;
    }

    private static int a(String str, String str2, int i2) {
        int i3;
        if (i2 > 1 || ((af.a >= 26 && i2 > 0) || o.f9875t.equals(str2) || o.I.equals(str2) || o.J.equals(str2) || o.f9873r.equals(str2) || o.G.equals(str2) || o.H.equals(str2) || o.f9878w.equals(str2) || o.K.equals(str2) || o.f9879x.equals(str2) || o.f9880y.equals(str2) || o.M.equals(str2))) {
            return i2;
        }
        if (o.f9881z.equals(str2)) {
            i3 = 6;
        } else {
            i3 = o.A.equals(str2) ? 16 : 30;
        }
        String str3 = "AssumedMaxChannelAdjustment: " + str + ", [" + i2 + " to " + i3 + "]";
        return i3;
    }

    @TargetApi(19)
    private static boolean b(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private static boolean a(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return af.a >= 19 && codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    @TargetApi(21)
    private static boolean a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i2, int i3, double d2) {
        if (d2 != -1.0d && d2 > PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
            return videoCapabilities.areSizeAndRateSupported(i2, i3, d2);
        }
        return videoCapabilities.isSizeSupported(i2, i3);
    }
}
