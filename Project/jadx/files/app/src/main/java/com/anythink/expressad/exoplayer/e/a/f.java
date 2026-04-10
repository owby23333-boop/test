package com.anythink.expressad.exoplayer.e.a;

import com.anythink.expressad.exoplayer.g.a;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.k.s;

/* JADX INFO: loaded from: classes2.dex */
final class f {
    private static final String F = "und";
    private static final String a = "MetadataUtil";
    private static final int b = af.f("nam");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8919c = af.f("trk");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f8920d = af.f("cmt");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f8921e = af.f("day");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f8922f = af.f("ART");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f8923g = af.f("too");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f8924h = af.f("alb");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f8925i = af.f("com");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f8926j = af.f("wrt");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f8927k = af.f("lyr");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f8928l = af.f("gen");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f8929m = af.f("covr");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f8930n = af.f("gnre");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f8931o = af.f("grp");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f8932p = af.f("disk");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f8933q = af.f("trkn");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f8934r = af.f("tmpo");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f8935s = af.f("cpil");

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f8936t = af.f("aART");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f8937u = af.f("sonm");

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final int f8938v = af.f("soal");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f8939w = af.f("soar");

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f8940x = af.f("soaa");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f8941y = af.f("soco");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f8942z = af.f("rtng");
    private static final int A = af.f("pgap");
    private static final int B = af.f("sosn");
    private static final int C = af.f("tvsh");
    private static final int D = af.f(com.anythink.expressad.exoplayer.g.b.i.a);
    private static final String[] E = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private f() {
    }

    public static a.InterfaceC0191a a(s sVar) {
        int iC = sVar.c() + sVar.i();
        int i2 = sVar.i();
        int i3 = (i2 >> 24) & 255;
        a.InterfaceC0191a eVar = null;
        try {
            if (i3 == 169 || i3 == 65533) {
                int i4 = 16777215 & i2;
                if (i4 == f8920d) {
                    int i5 = sVar.i();
                    if (sVar.i() == a.aK) {
                        sVar.d(8);
                        String strE = sVar.e(i5 - 16);
                        eVar = new com.anythink.expressad.exoplayer.g.b.e("und", strE, strE);
                    } else {
                        String str = "Failed to parse comment attribute: " + a.c(i2);
                    }
                    return eVar;
                }
                if (i4 != b && i4 != f8919c) {
                    if (i4 != f8925i && i4 != f8926j) {
                        if (i4 == f8921e) {
                            return a(i2, "TDRC", sVar);
                        }
                        if (i4 == f8922f) {
                            return a(i2, "TPE1", sVar);
                        }
                        if (i4 == f8923g) {
                            return a(i2, "TSSE", sVar);
                        }
                        if (i4 == f8924h) {
                            return a(i2, "TALB", sVar);
                        }
                        if (i4 == f8927k) {
                            return a(i2, "USLT", sVar);
                        }
                        if (i4 == f8928l) {
                            return a(i2, "TCON", sVar);
                        }
                        if (i4 == f8931o) {
                            return a(i2, "TIT1", sVar);
                        }
                    }
                    return a(i2, "TCOM", sVar);
                }
                return a(i2, "TIT2", sVar);
            }
            if (i2 == f8930n) {
                int iD = d(sVar);
                String str2 = (iD <= 0 || iD > E.length) ? null : E[iD - 1];
                return str2 != null ? new com.anythink.expressad.exoplayer.g.b.k("TCON", null, str2) : null;
            }
            if (i2 == f8932p) {
                return b(i2, "TPOS", sVar);
            }
            if (i2 == f8933q) {
                return b(i2, "TRCK", sVar);
            }
            if (i2 == f8934r) {
                return a(i2, "TBPM", sVar, true, false);
            }
            if (i2 == f8935s) {
                return a(i2, "TCMP", sVar, true, true);
            }
            if (i2 == f8929m) {
                int i6 = sVar.i();
                if (sVar.i() == a.aK) {
                    int iB = a.b(sVar.i());
                    String str3 = iB == 13 ? "image/jpeg" : iB == 14 ? "image/png" : null;
                    if (str3 == null) {
                        "Unrecognized cover art flags: ".concat(String.valueOf(iB));
                    } else {
                        sVar.d(4);
                        byte[] bArr = new byte[i6 - 16];
                        sVar.a(bArr, 0, bArr.length);
                        eVar = new com.anythink.expressad.exoplayer.g.b.a(str3, null, 3, bArr);
                    }
                }
                return eVar;
            }
            if (i2 == f8936t) {
                return a(i2, "TPE2", sVar);
            }
            if (i2 == f8937u) {
                return a(i2, "TSOT", sVar);
            }
            if (i2 == f8938v) {
                return a(i2, "TSO2", sVar);
            }
            if (i2 == f8939w) {
                return a(i2, "TSOA", sVar);
            }
            if (i2 == f8940x) {
                return a(i2, "TSOP", sVar);
            }
            if (i2 == f8941y) {
                return a(i2, "TSOC", sVar);
            }
            if (i2 == f8942z) {
                return a(i2, "ITUNESADVISORY", sVar, false, false);
            }
            if (i2 == A) {
                return a(i2, "ITUNESGAPLESS", sVar, false, true);
            }
            if (i2 == B) {
                return a(i2, "TVSHOWSORT", sVar);
            }
            if (i2 == C) {
                return a(i2, "TVSHOW", sVar);
            }
            if (i2 == D) {
                return a(sVar, iC);
            }
            String str4 = "Skipped unknown metadata entry: " + a.c(i2);
            return null;
        } finally {
            sVar.c(iC);
        }
    }

    private static com.anythink.expressad.exoplayer.g.b.k b(int i2, String str, s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == a.aK && i3 >= 22) {
            sVar.d(10);
            int iE = sVar.e();
            if (iE > 0) {
                String strValueOf = String.valueOf(iE);
                int iE2 = sVar.e();
                if (iE2 > 0) {
                    strValueOf = strValueOf + "/" + iE2;
                }
                return new com.anythink.expressad.exoplayer.g.b.k(str, null, strValueOf);
            }
        }
        String str2 = "Failed to parse index/count attribute: " + a.c(i2);
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.b.a c(s sVar) {
        int i2 = sVar.i();
        if (sVar.i() != a.aK) {
            return null;
        }
        int iB = a.b(sVar.i());
        String str = iB == 13 ? "image/jpeg" : iB == 14 ? "image/png" : null;
        if (str == null) {
            "Unrecognized cover art flags: ".concat(String.valueOf(iB));
            return null;
        }
        sVar.d(4);
        byte[] bArr = new byte[i2 - 16];
        sVar.a(bArr, 0, bArr.length);
        return new com.anythink.expressad.exoplayer.g.b.a(str, null, 3, bArr);
    }

    private static int d(s sVar) {
        sVar.d(4);
        if (sVar.i() != a.aK) {
            return -1;
        }
        sVar.d(8);
        return sVar.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.anythink.expressad.exoplayer.g.b.k b(com.anythink.expressad.exoplayer.k.s r3) {
        /*
            int r3 = d(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = com.anythink.expressad.exoplayer.e.a.f.E
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1c
            com.anythink.expressad.exoplayer.g.b.k r1 = new com.anythink.expressad.exoplayer.g.b.k
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L1c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.e.a.f.b(com.anythink.expressad.exoplayer.k.s):com.anythink.expressad.exoplayer.g.b.k");
    }

    private static com.anythink.expressad.exoplayer.g.b.k a(int i2, String str, s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == a.aK) {
            sVar.d(8);
            return new com.anythink.expressad.exoplayer.g.b.k(str, null, sVar.e(i3 - 16));
        }
        String str2 = "Failed to parse text attribute: " + a.c(i2);
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.b.e a(int i2, s sVar) {
        int i3 = sVar.i();
        if (sVar.i() == a.aK) {
            sVar.d(8);
            String strE = sVar.e(i3 - 16);
            return new com.anythink.expressad.exoplayer.g.b.e("und", strE, strE);
        }
        String str = "Failed to parse comment attribute: " + a.c(i2);
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.b.h a(int i2, String str, s sVar, boolean z2, boolean z3) {
        int iD = d(sVar);
        if (z3) {
            iD = Math.min(1, iD);
        }
        if (iD >= 0) {
            if (z2) {
                return new com.anythink.expressad.exoplayer.g.b.k(str, null, Integer.toString(iD));
            }
            return new com.anythink.expressad.exoplayer.g.b.e("und", str, Integer.toString(iD));
        }
        String str2 = "Failed to parse uint8 attribute: " + a.c(i2);
        return null;
    }

    private static com.anythink.expressad.exoplayer.g.b.h a(s sVar, int i2) {
        String strE = null;
        String strE2 = null;
        int i3 = -1;
        int i4 = -1;
        while (sVar.c() < i2) {
            int iC = sVar.c();
            int i5 = sVar.i();
            int i6 = sVar.i();
            sVar.d(4);
            if (i6 == a.aI) {
                strE = sVar.e(i5 - 12);
            } else if (i6 == a.aJ) {
                strE2 = sVar.e(i5 - 12);
            } else {
                if (i6 == a.aK) {
                    i3 = iC;
                    i4 = i5;
                }
                sVar.d(i5 - 12);
            }
        }
        if (strE == null || strE2 == null || i3 == -1) {
            return null;
        }
        sVar.c(i3);
        sVar.d(16);
        return new com.anythink.expressad.exoplayer.g.b.i(strE, strE2, sVar.e(i4 - 16));
    }
}
