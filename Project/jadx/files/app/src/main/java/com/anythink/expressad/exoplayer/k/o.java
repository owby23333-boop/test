package com.anythink.expressad.exoplayer.k;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final String A = "audio/eac3";
    public static final String B = "audio/eac3-joc";
    public static final String C = "audio/true-hd";
    public static final String D = "audio/vnd.dts";
    public static final String E = "audio/vnd.dts.hd";
    public static final String F = "audio/vnd.dts.hd;profile=lbr";
    public static final String G = "audio/vorbis";
    public static final String H = "audio/opus";
    public static final String I = "audio/3gpp";
    public static final String J = "audio/amr-wb";
    public static final String K = "audio/flac";
    public static final String L = "audio/alac";
    public static final String M = "audio/gsm";
    public static final String N = "audio/x-unknown";
    public static final String O = "text/vtt";
    public static final String P = "text/x-ssa";
    public static final String Q = "application/mp4";
    public static final String R = "application/webm";
    public static final String S = "application/dash+xml";
    public static final String T = "application/x-mpegURL";
    public static final String U = "application/vnd.ms-sstr+xml";
    public static final String V = "application/id3";
    public static final String W = "application/cea-608";
    public static final String X = "application/cea-708";
    public static final String Y = "application/x-subrip";
    public static final String Z = "application/ttml+xml";
    public static final String a = "video";
    public static final String aa = "application/x-quicktime-tx3g";
    public static final String ab = "application/x-mp4-vtt";
    public static final String ac = "application/x-mp4-cea-608";
    public static final String ad = "application/x-rawcc";
    public static final String ae = "application/vobsub";
    public static final String af = "application/pgs";
    public static final String ag = "application/x-scte35";
    public static final String ah = "application/x-camera-motion";
    public static final String ai = "application/x-emsg";
    public static final String aj = "application/dvbsubs";
    public static final String ak = "application/x-exif";
    private static final ArrayList<a> al = new ArrayList<>();
    public static final String b = "audio";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9858c = "text";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9859d = "application";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9860e = "video/mp4";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9861f = "video/webm";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9862g = "video/3gpp";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f9863h = "video/avc";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f9864i = "video/hevc";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f9865j = "video/x-vnd.on2.vp8";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f9866k = "video/x-vnd.on2.vp9";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f9867l = "video/mp4v-es";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f9868m = "video/mpeg";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f9869n = "video/mpeg2";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f9870o = "video/wvc1";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f9871p = "video/x-unknown";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f9872q = "audio/mp4";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f9873r = "audio/mp4a-latm";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f9874s = "audio/webm";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f9875t = "audio/mpeg";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f9876u = "audio/mpeg-L1";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f9877v = "audio/mpeg-L2";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f9878w = "audio/raw";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f9879x = "audio/g711-alaw";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f9880y = "audio/g711-mlaw";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f9881z = "audio/ac3";

    private static final class a {
        public final String a;
        public final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9882c;

        public a(String str, String str2, int i2) {
            this.a = str;
            this.b = str2;
            this.f9882c = i2;
        }
    }

    private o() {
    }

    @Nullable
    public static String a(int i2) {
        if (i2 == 32) {
            return f9867l;
        }
        if (i2 == 33) {
            return f9863h;
        }
        if (i2 == 35) {
            return f9864i;
        }
        if (i2 == 64) {
            return f9873r;
        }
        if (i2 == 163) {
            return f9870o;
        }
        if (i2 == 177) {
            return f9866k;
        }
        if (i2 == 165) {
            return f9881z;
        }
        if (i2 == 166) {
            return A;
        }
        switch (i2) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return f9869n;
            case 102:
            case 103:
            case 104:
                return f9873r;
            case 105:
            case 107:
                return f9875t;
            case 106:
                return f9868m;
            default:
                switch (i2) {
                    case 169:
                    case 172:
                        return D;
                    case 170:
                    case 171:
                        return E;
                    case 173:
                        return H;
                    default:
                        return null;
                }
        }
    }

    private static void a(String str, String str2, int i2) {
        a aVar = new a(str, str2, i2);
        int size = al.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            if (str.equals(al.get(i3).a)) {
                al.remove(i3);
                break;
            }
            i3++;
        }
        al.add(aVar);
    }

    public static boolean b(String str) {
        return "video".equals(k(str));
    }

    @Nullable
    public static String c(@Nullable String str) {
        String strA = null;
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("avc1") || strTrim.startsWith("avc3")) {
            return f9863h;
        }
        if (strTrim.startsWith("hev1") || strTrim.startsWith("hvc1")) {
            return f9864i;
        }
        if (strTrim.startsWith("vp9") || strTrim.startsWith("vp09")) {
            return f9866k;
        }
        if (strTrim.startsWith("vp8") || strTrim.startsWith("vp08")) {
            return f9865j;
        }
        if (strTrim.startsWith("mp4a")) {
            if (strTrim.startsWith("mp4a.")) {
                String strSubstring = strTrim.substring(5);
                if (strSubstring.length() >= 2) {
                    try {
                        strA = a(Integer.parseInt(af.e(strSubstring.substring(0, 2)), 16));
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return strA == null ? f9873r : strA;
        }
        if (strTrim.startsWith("ac-3") || strTrim.startsWith("dac3")) {
            return f9881z;
        }
        if (strTrim.startsWith("ec-3") || strTrim.startsWith("dec3")) {
            return A;
        }
        if (strTrim.startsWith("ec+3")) {
            return B;
        }
        if (strTrim.startsWith("dtsc") || strTrim.startsWith("dtse")) {
            return D;
        }
        if (strTrim.startsWith("dtsh") || strTrim.startsWith("dtsl")) {
            return E;
        }
        if (strTrim.startsWith("opus")) {
            return H;
        }
        if (strTrim.startsWith("vorbis")) {
            return G;
        }
        int size = al.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = al.get(i2);
            if (strTrim.startsWith(aVar.b)) {
                return aVar.a;
            }
        }
        return null;
    }

    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (a(str)) {
            return 1;
        }
        if (b(str)) {
            return 2;
        }
        if ("text".equals(k(str)) || W.equals(str) || X.equals(str) || ac.equals(str) || Y.equals(str) || Z.equals(str) || aa.equals(str) || ab.equals(str) || ad.equals(str) || ae.equals(str) || af.equals(str) || aj.equals(str)) {
            return 3;
        }
        if (V.equals(str) || ai.equals(str) || ag.equals(str) || ah.equals(str)) {
            return 4;
        }
        int size = al.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = al.get(i2);
            if (str.equals(aVar.a)) {
                return aVar.f9882c;
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int e(java.lang.String r7) {
        /*
            int r0 = r7.hashCode()
            r1 = 0
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 5
            switch(r0) {
                case -2123537834: goto L40;
                case -1095064472: goto L36;
                case 187078296: goto L2c;
                case 1504578661: goto L22;
                case 1505942594: goto L18;
                case 1556697186: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "audio/true-hd"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L4a
            r7 = 5
            goto L4b
        L18:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L4a
            r7 = 4
            goto L4b
        L22:
            java.lang.String r0 = "audio/eac3"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L4a
            r7 = 1
            goto L4b
        L2c:
            java.lang.String r0 = "audio/ac3"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L4a
            r7 = 0
            goto L4b
        L36:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L4a
            r7 = 3
            goto L4b
        L40:
            java.lang.String r0 = "audio/eac3-joc"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L4a
            r7 = 2
            goto L4b
        L4a:
            r7 = -1
        L4b:
            if (r7 == 0) goto L62
            if (r7 == r5) goto L60
            if (r7 == r4) goto L60
            if (r7 == r3) goto L5e
            if (r7 == r2) goto L5b
            if (r7 == r6) goto L58
            return r1
        L58:
            r7 = 14
            return r7
        L5b:
            r7 = 8
            return r7
        L5e:
            r7 = 7
            return r7
        L60:
            r7 = 6
            return r7
        L62:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.k.o.e(java.lang.String):int");
    }

    public static int f(String str) {
        return d(c(str));
    }

    private static boolean g(String str) {
        return "text".equals(k(str));
    }

    private static boolean h(String str) {
        return f9859d.equals(k(str));
    }

    @Nullable
    private static String i(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : af.a(str, ",")) {
            String strC = c(str2);
            if (strC != null && b(strC)) {
                return strC;
            }
        }
        return null;
    }

    @Nullable
    private static String j(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : af.a(str, ",")) {
            String strC = c(str2);
            if (strC != null && a(strC)) {
                return strC;
            }
        }
        return null;
    }

    @Nullable
    private static String k(@Nullable String str) {
        if (str == null) {
            return null;
        }
        int iIndexOf = str.indexOf(47);
        if (iIndexOf != -1) {
            return str.substring(0, iIndexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: ".concat(String.valueOf(str)));
    }

    @Nullable
    private static String l(String str) {
        int size = al.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = al.get(i2);
            if (str.startsWith(aVar.b)) {
                return aVar.a;
            }
        }
        return null;
    }

    private static int m(String str) {
        int size = al.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = al.get(i2);
            if (str.equals(aVar.a)) {
                return aVar.f9882c;
            }
        }
        return -1;
    }

    public static boolean a(String str) {
        return b.equals(k(str));
    }
}
