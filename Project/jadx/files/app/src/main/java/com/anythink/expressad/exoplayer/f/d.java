package com.anythink.expressad.exoplayer.f;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.o;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class d {
    private static final String a = "MediaCodecUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9057c = "OMX.MTK.AUDIO.DECODER.RAW";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SparseIntArray f9061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SparseIntArray f9062h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f9063i = "avc1";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f9064j = "avc2";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<String, Integer> f9065k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f9066l = "hev1";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f9067m = "hvc1";
    private static final String b = "OMX.google.raw.decoder";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.anythink.expressad.exoplayer.f.a f9058d = com.anythink.expressad.exoplayer.f.a.a(b);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f9059e = Pattern.compile("^\\D?(\\d+)$");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap<a, List<com.anythink.expressad.exoplayer.f.a>> f9060f = new HashMap<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f9068n = -1;

    private static final class a {
        public final String a;
        public final boolean b;

        public a(String str, boolean z2) {
            this.a = str;
            this.b = z2;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                a aVar = (a) obj;
                if (TextUtils.equals(this.a, aVar.a) && this.b == aVar.b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.b ? 1231 : 1237);
        }
    }

    public static class b extends Exception {
        /* synthetic */ b(Throwable th, byte b) {
            this(th);
        }

        private b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private interface c {
        int a();

        MediaCodecInfo a(int i2);

        boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b();
    }

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.f.d$d, reason: collision with other inner class name */
    private static final class C0190d implements c {
        private C0190d() {
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final int a() {
            return MediaCodecList.getCodecCount();
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean b() {
            return false;
        }

        /* synthetic */ C0190d(byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final MediaCodecInfo a(int i2) {
            return MediaCodecList.getCodecInfoAt(i2);
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return o.f9863h.equals(str);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f9061g = sparseIntArray;
        sparseIntArray.put(66, 1);
        f9061g.put(77, 2);
        f9061g.put(88, 4);
        f9061g.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f9062h = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        f9062h.put(11, 4);
        f9062h.put(12, 8);
        f9062h.put(13, 16);
        f9062h.put(20, 32);
        f9062h.put(21, 64);
        f9062h.put(22, 128);
        f9062h.put(30, 256);
        f9062h.put(31, 512);
        f9062h.put(32, 1024);
        f9062h.put(40, 2048);
        f9062h.put(41, 4096);
        f9062h.put(42, 8192);
        f9062h.put(50, 16384);
        f9062h.put(51, 32768);
        f9062h.put(52, 65536);
        HashMap map = new HashMap();
        f9065k = map;
        map.put("L30", 1);
        f9065k.put("L60", 4);
        f9065k.put("L63", 16);
        f9065k.put("L90", 64);
        f9065k.put("L93", 256);
        f9065k.put("L120", 1024);
        f9065k.put("L123", 4096);
        f9065k.put("L150", 16384);
        f9065k.put("L153", 65536);
        f9065k.put("L156", 262144);
        f9065k.put("L180", 1048576);
        f9065k.put("L183", 4194304);
        f9065k.put("L186", 16777216);
        f9065k.put("H30", 2);
        f9065k.put("H60", 8);
        f9065k.put("H63", 32);
        f9065k.put("H90", 128);
        f9065k.put("H93", 512);
        f9065k.put("H120", 2048);
        f9065k.put("H123", 8192);
        f9065k.put("H150", 32768);
        f9065k.put("H153", 131072);
        f9065k.put("H156", 524288);
        f9065k.put("H180", 2097152);
        f9065k.put("H183", 8388608);
        f9065k.put("H186", Integer.valueOf(DownloadExpSwitchCode.BACK_CLEAR_DATA));
    }

    private d() {
    }

    private static int a(int i2) {
        if (i2 == 1 || i2 == 2) {
            return 25344;
        }
        switch (i2) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            default:
                return -1;
        }
    }

    public static com.anythink.expressad.exoplayer.f.a a() {
        return f9058d;
    }

    private static void b(String str, boolean z2) {
        try {
            c(str, z2);
        } catch (b unused) {
        }
    }

    private static synchronized List<com.anythink.expressad.exoplayer.f.a> c(String str, boolean z2) {
        a aVar = new a(str, z2);
        List<com.anythink.expressad.exoplayer.f.a> list = f9060f.get(aVar);
        if (list != null) {
            return list;
        }
        byte b2 = 0;
        c eVar = af.a >= 21 ? new e(z2) : new C0190d(b2);
        ArrayList<com.anythink.expressad.exoplayer.f.a> arrayListA = a(aVar, eVar, str);
        if (z2 && arrayListA.isEmpty() && 21 <= af.a && af.a <= 23) {
            eVar = new C0190d(b2);
            arrayListA = a(aVar, eVar, str);
            if (!arrayListA.isEmpty()) {
                String str2 = "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + arrayListA.get(0).f9032c;
            }
        }
        if (o.B.equals(str)) {
            arrayListA.addAll(a(new a(o.A, aVar.b), eVar, str));
        }
        a(arrayListA);
        List<com.anythink.expressad.exoplayer.f.a> listUnmodifiableList = Collections.unmodifiableList(arrayListA);
        f9060f.put(aVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    @TargetApi(21)
    private static final class e implements c {
        private final int a;
        private MediaCodecInfo[] b;

        public e(boolean z2) {
            this.a = z2 ? 1 : 0;
        }

        private void c() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.a).getCodecInfos();
            }
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final int a() {
            c();
            return this.b.length;
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean b() {
            return true;
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final MediaCodecInfo a(int i2) {
            c();
            return this.b[i2];
        }

        @Override // com.anythink.expressad.exoplayer.f.d.c
        public final boolean a(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }
    }

    @Nullable
    public static com.anythink.expressad.exoplayer.f.a a(String str, boolean z2) {
        List<com.anythink.expressad.exoplayer.f.a> listC = c(str, z2);
        if (listC.isEmpty()) {
            return null;
        }
        return listC.get(0);
    }

    public static int b() {
        int i2;
        if (f9068n == -1) {
            int iMax = 0;
            com.anythink.expressad.exoplayer.f.a aVarA = a(o.f9863h, false);
            if (aVarA != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrA = aVarA.a();
                int length = codecProfileLevelArrA.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i3 = codecProfileLevelArrA[iMax].level;
                    if (i3 != 1 && i3 != 2) {
                        switch (i3) {
                            case 8:
                            case 16:
                            case 32:
                                i2 = 101376;
                                break;
                            case 64:
                                i2 = 202752;
                                break;
                            case 128:
                            case 256:
                                i2 = 414720;
                                break;
                            case 512:
                                i2 = 921600;
                                break;
                            case 1024:
                                i2 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i2 = 2097152;
                                break;
                            case 8192:
                                i2 = 2228224;
                                break;
                            case 16384:
                                i2 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i2 = 9437184;
                                break;
                            default:
                                i2 = -1;
                                break;
                        }
                    } else {
                        i2 = 25344;
                    }
                    iMax2 = Math.max(i2, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, af.a >= 21 ? 345600 : 172800);
            }
            f9068n = iMax;
        }
        return f9068n;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> a(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.d.a(java.lang.String):android.util.Pair");
    }

    private static boolean b(String str) {
        if (af.a > 22) {
            return false;
        }
        if ("ODROID-XU3".equals(af.f9816d) || "Nexus 10".equals(af.f9816d)) {
            return "OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str);
        }
        return false;
    }

    private static Pair<Integer, Integer> b(String str, String[] strArr) {
        Integer numValueOf;
        Integer numValueOf2;
        if (strArr.length < 2) {
            "Ignoring malformed AVC codec string: ".concat(String.valueOf(str));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer numValueOf3 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                numValueOf = numValueOf3;
            } else if (strArr.length >= 3) {
                numValueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                "Ignoring malformed AVC codec string: ".concat(String.valueOf(str));
                return null;
            }
            int i2 = f9061g.get(numValueOf.intValue(), -1);
            if (i2 == -1) {
                "Unknown AVC profile: ".concat(String.valueOf(numValueOf));
                return null;
            }
            int i3 = f9062h.get(numValueOf2.intValue(), -1);
            if (i3 == -1) {
                "Unknown AVC level: ".concat(String.valueOf(numValueOf2));
                return null;
            }
            return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (NumberFormatException unused) {
            "Ignoring malformed AVC codec string: ".concat(String.valueOf(str));
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:144:0x024b A[Catch: Exception -> 0x0328, TryCatch #3 {Exception -> 0x0328, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x002f, B:14:0x0035, B:16:0x003d, B:18:0x0045, B:20:0x004d, B:22:0x0055, B:24:0x005d, B:27:0x0069, B:29:0x006f, B:32:0x0078, B:34:0x007c, B:36:0x0084, B:38:0x008e, B:40:0x0098, B:43:0x00a3, B:45:0x00a9, B:47:0x00b1, B:49:0x00bb, B:51:0x00c5, B:53:0x00cf, B:55:0x00d9, B:57:0x00e3, B:59:0x00ed, B:61:0x00f7, B:63:0x0101, B:65:0x010b, B:67:0x0115, B:69:0x011f, B:72:0x012b, B:74:0x012f, B:76:0x0137, B:78:0x0141, B:80:0x014b, B:82:0x0155, B:85:0x0161, B:88:0x0169, B:90:0x0171, B:92:0x0179, B:94:0x0181, B:96:0x018b, B:98:0x0195, B:100:0x019f, B:102:0x01a9, B:104:0x01b3, B:106:0x01bd, B:108:0x01c7, B:111:0x01d3, B:114:0x01db, B:116:0x01e3, B:118:0x01eb, B:120:0x01f5, B:122:0x01ff, B:124:0x0207, B:126:0x0211, B:129:0x021d, B:131:0x0221, B:133:0x0229, B:136:0x0233, B:138:0x023d, B:144:0x024b, B:146:0x0253, B:189:0x02d4, B:191:0x02da, B:193:0x02e0, B:194:0x02f3, B:195:0x030d), top: B:211:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02da A[Catch: Exception -> 0x0328, TryCatch #3 {Exception -> 0x0328, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x002f, B:14:0x0035, B:16:0x003d, B:18:0x0045, B:20:0x004d, B:22:0x0055, B:24:0x005d, B:27:0x0069, B:29:0x006f, B:32:0x0078, B:34:0x007c, B:36:0x0084, B:38:0x008e, B:40:0x0098, B:43:0x00a3, B:45:0x00a9, B:47:0x00b1, B:49:0x00bb, B:51:0x00c5, B:53:0x00cf, B:55:0x00d9, B:57:0x00e3, B:59:0x00ed, B:61:0x00f7, B:63:0x0101, B:65:0x010b, B:67:0x0115, B:69:0x011f, B:72:0x012b, B:74:0x012f, B:76:0x0137, B:78:0x0141, B:80:0x014b, B:82:0x0155, B:85:0x0161, B:88:0x0169, B:90:0x0171, B:92:0x0179, B:94:0x0181, B:96:0x018b, B:98:0x0195, B:100:0x019f, B:102:0x01a9, B:104:0x01b3, B:106:0x01bd, B:108:0x01c7, B:111:0x01d3, B:114:0x01db, B:116:0x01e3, B:118:0x01eb, B:120:0x01f5, B:122:0x01ff, B:124:0x0207, B:126:0x0211, B:129:0x021d, B:131:0x0221, B:133:0x0229, B:136:0x0233, B:138:0x023d, B:144:0x024b, B:146:0x0253, B:189:0x02d4, B:191:0x02da, B:193:0x02e0, B:194:0x02f3, B:195:0x030d), top: B:211:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02f3 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x031d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<com.anythink.expressad.exoplayer.f.a> a(com.anythink.expressad.exoplayer.f.d.a r18, com.anythink.expressad.exoplayer.f.d.c r19, java.lang.String r20) throws com.anythink.expressad.exoplayer.f.d.b {
        /*
            Method dump skipped, instruction units count: 818
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.f.d.a(com.anythink.expressad.exoplayer.f.d$a, com.anythink.expressad.exoplayer.f.d$c, java.lang.String):java.util.ArrayList");
    }

    private static boolean a(MediaCodecInfo mediaCodecInfo, String str, boolean z2, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z2 && str.endsWith(".secure"))) {
            return false;
        }
        if (af.a < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (af.a < 18 && "OMX.SEC.MP3.Decoder".equals(str)) {
            return false;
        }
        if (af.a < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str) && ("a70".equals(af.b) || ("Xiaomi".equals(af.f9815c) && af.b.startsWith("HM")))) {
            return false;
        }
        if (af.a == 16 && "OMX.qcom.audio.decoder.mp3".equals(str) && ("dlxu".equals(af.b) || "protou".equals(af.b) || "ville".equals(af.b) || "villeplus".equals(af.b) || "villec2".equals(af.b) || af.b.startsWith("gee") || "C6602".equals(af.b) || "C6603".equals(af.b) || "C6606".equals(af.b) || "C6616".equals(af.b) || "L36h".equals(af.b) || "SO-02E".equals(af.b))) {
            return false;
        }
        if (af.a == 16 && "OMX.qcom.audio.decoder.aac".equals(str) && ("C1504".equals(af.b) || "C1505".equals(af.b) || "C1604".equals(af.b) || "C1605".equals(af.b))) {
            return false;
        }
        if (af.a < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(af.f9815c) && (af.b.startsWith("zeroflte") || af.b.startsWith("zerolte") || af.b.startsWith("zenlte") || "SC-05G".equals(af.b) || "marinelteatt".equals(af.b) || "404SC".equals(af.b) || "SC-04G".equals(af.b) || "SCV31".equals(af.b)))) {
            return false;
        }
        if (af.a <= 19 && "OMX.SEC.vp8.dec".equals(str) && "samsung".equals(af.f9815c) && (af.b.startsWith(com.anythink.expressad.foundation.g.a.O) || af.b.startsWith("serrano") || af.b.startsWith("jflte") || af.b.startsWith("santos") || af.b.startsWith("t0"))) {
            return false;
        }
        if (af.a <= 19 && af.b.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        return (o.B.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    private static void a(List<com.anythink.expressad.exoplayer.f.a> list) {
        if (af.a < 26) {
            if (list.size() <= 1 || !f9057c.equals(list.get(0).f9032c)) {
                return;
            }
            for (int i2 = 1; i2 < list.size(); i2++) {
                com.anythink.expressad.exoplayer.f.a aVar = list.get(i2);
                if (b.equals(aVar.f9032c)) {
                    list.remove(i2);
                    list.add(0, aVar);
                    return;
                }
            }
        }
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        int i2;
        if (strArr.length < 4) {
            "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str));
            return null;
        }
        Matcher matcher = f9059e.matcher(strArr[1]);
        if (!matcher.matches()) {
            "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str));
            return null;
        }
        String strGroup = matcher.group(1);
        if ("1".equals(strGroup)) {
            i2 = 1;
        } else {
            if (!"2".equals(strGroup)) {
                "Unknown HEVC profile string: ".concat(String.valueOf(strGroup));
                return null;
            }
            i2 = 2;
        }
        Integer num = f9065k.get(strArr[3]);
        if (num == null) {
            String str2 = "Unknown HEVC level string: " + matcher.group(1);
            return null;
        }
        return new Pair<>(Integer.valueOf(i2), num);
    }
}
