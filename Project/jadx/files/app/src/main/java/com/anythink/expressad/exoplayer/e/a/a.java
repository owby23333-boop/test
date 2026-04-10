package com.anythink.expressad.exoplayer.e.a;

import androidx.core.view.ViewCompat;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.s;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
abstract class a {
    public static final int a = 8;
    public static final int b = 12;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8836c = 16;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8837d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8838e = 0;
    public final int aU;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8839f = af.f("ftyp");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8840g = af.f("avc1");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8841h = af.f("avc3");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f8842i = af.f("hvc1");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f8843j = af.f("hev1");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f8844k = af.f("s263");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f8845l = af.f("d263");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f8846m = af.f("mdat");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f8847n = af.f("mp4a");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f8848o = af.f(".mp3");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f8849p = af.f("wave");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f8850q = af.f("lpcm");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f8851r = af.f("sowt");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f8852s = af.f("ac-3");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f8853t = af.f("dac3");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f8854u = af.f("ec-3");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f8855v = af.f("dec3");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f8856w = af.f("dtsc");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f8857x = af.f("dtsh");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f8858y = af.f("dtsl");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f8859z = af.f("dtse");
    public static final int A = af.f("ddts");
    public static final int B = af.f("tfdt");
    public static final int C = af.f("tfhd");
    public static final int D = af.f("trex");
    public static final int E = af.f("trun");
    public static final int F = af.f("sidx");
    public static final int G = af.f("moov");
    public static final int H = af.f("mvhd");
    public static final int I = af.f("trak");
    public static final int J = af.f("mdia");
    public static final int K = af.f("minf");
    public static final int L = af.f("stbl");
    public static final int M = af.f("avcC");
    public static final int N = af.f("hvcC");
    public static final int O = af.f("esds");
    public static final int P = af.f("moof");
    public static final int Q = af.f("traf");
    public static final int R = af.f("mvex");
    public static final int S = af.f("mehd");
    public static final int T = af.f("tkhd");
    public static final int U = af.f("edts");
    public static final int V = af.f("elst");
    public static final int W = af.f("mdhd");
    public static final int X = af.f("hdlr");
    public static final int Y = af.f("stsd");
    public static final int Z = af.f("pssh");
    public static final int aa = af.f("sinf");
    public static final int ab = af.f("schm");
    public static final int ac = af.f("schi");
    public static final int ad = af.f("tenc");
    public static final int ae = af.f("encv");
    public static final int af = af.f("enca");
    public static final int ag = af.f("frma");
    public static final int ah = af.f("saiz");
    public static final int ai = af.f("saio");
    public static final int aj = af.f("sbgp");
    public static final int ak = af.f("sgpd");
    public static final int al = af.f("uuid");
    public static final int am = af.f("senc");
    public static final int an = af.f("pasp");
    public static final int ao = af.f("TTML");
    public static final int ap = af.f("vmhd");
    public static final int aq = af.f("mp4v");
    public static final int ar = af.f("stts");
    public static final int as = af.f("stss");
    public static final int at = af.f("ctts");
    public static final int au = af.f("stsc");
    public static final int av = af.f("stsz");
    public static final int aw = af.f("stz2");
    public static final int ax = af.f("stco");
    public static final int ay = af.f("co64");
    public static final int az = af.f("tx3g");
    public static final int aA = af.f("wvtt");
    public static final int aB = af.f("stpp");
    public static final int aC = af.f("c608");
    public static final int aD = af.f("samr");
    public static final int aE = af.f("sawb");
    public static final int aF = af.f("udta");
    public static final int aG = af.f(TTDownloadField.TT_META);
    public static final int aH = af.f("ilst");
    public static final int aI = af.f("mean");
    public static final int aJ = af.f("name");
    public static final int aK = af.f("data");
    public static final int aL = af.f("emsg");
    public static final int aM = af.f("st3d");
    public static final int aN = af.f("sv3d");
    public static final int aO = af.f("proj");
    public static final int aP = af.f("vp08");
    public static final int aQ = af.f("vp09");
    public static final int aR = af.f("vpcC");
    public static final int aS = af.f("camm");
    public static final int aT = af.f("alac");

    /* JADX INFO: renamed from: com.anythink.expressad.exoplayer.e.a.a$a, reason: collision with other inner class name */
    static final class C0187a extends a {
        public final long aV;
        public final List<b> aW;
        public final List<C0187a> aX;

        public C0187a(int i2, long j2) {
            super(i2);
            this.aV = j2;
            this.aW = new ArrayList();
            this.aX = new ArrayList();
        }

        private int f(int i2) {
            int size = this.aW.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                if (this.aW.get(i4).aU == i2) {
                    i3++;
                }
            }
            int size2 = this.aX.size();
            for (int i5 = 0; i5 < size2; i5++) {
                if (this.aX.get(i5).aU == i2) {
                    i3++;
                }
            }
            return i3;
        }

        public final void a(b bVar) {
            this.aW.add(bVar);
        }

        public final b d(int i2) {
            int size = this.aW.size();
            for (int i3 = 0; i3 < size; i3++) {
                b bVar = this.aW.get(i3);
                if (bVar.aU == i2) {
                    return bVar;
                }
            }
            return null;
        }

        public final C0187a e(int i2) {
            int size = this.aX.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0187a c0187a = this.aX.get(i3);
                if (c0187a.aU == i2) {
                    return c0187a;
                }
            }
            return null;
        }

        @Override // com.anythink.expressad.exoplayer.e.a.a
        public final String toString() {
            return a.c(this.aU) + " leaves: " + Arrays.toString(this.aW.toArray()) + " containers: " + Arrays.toString(this.aX.toArray());
        }

        public final void a(C0187a c0187a) {
            this.aX.add(c0187a);
        }
    }

    static final class b extends a {
        public final s aV;

        public b(int i2, s sVar) {
            super(i2);
            this.aV = sVar;
        }
    }

    public a(int i2) {
        this.aU = i2;
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(int i2) {
        return i2 & ViewCompat.MEASURED_SIZE_MASK;
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ((i2 >> 24) & 255));
        sb.append((char) ((i2 >> 16) & 255));
        sb.append((char) ((i2 >> 8) & 255));
        sb.append((char) (i2 & 255));
        return sb.toString();
    }

    public String toString() {
        return c(this.aU);
    }
}
