package com.bytedance.adsdk.lottie.model.layer;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f184a;
    private final String dl;
    private final String e;
    private final com.bytedance.adsdk.lottie.model.z.wp fo;
    private final com.bytedance.adsdk.lottie.model.z.kb fv;
    private final com.bytedance.adsdk.lottie.m g;
    private final z gc;
    private final List<com.bytedance.adsdk.lottie.model.g.gz> gz;
    private final float i;
    private final com.bytedance.adsdk.lottie.a.uy io;
    private final boolean iq;
    private final com.bytedance.adsdk.lottie.model.z.g js;
    private final int kb;
    private final float ls;
    private final long m;
    private final com.bytedance.adsdk.lottie.model.z.uy p;
    private final float pf;
    private final g q;
    private final List<com.bytedance.adsdk.lottie.m.z<Float>> tb;
    private final int uy;
    private final float v;
    private final int wp;
    private final List<com.bytedance.adsdk.lottie.model.g.dl> z;
    private final com.bytedance.adsdk.lottie.model.g.z zw;

    public enum g {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public enum z {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public gz(List<com.bytedance.adsdk.lottie.model.g.dl> list, com.bytedance.adsdk.lottie.m mVar, String str, long j, z zVar, long j2, String str2, List<com.bytedance.adsdk.lottie.model.g.gz> list2, com.bytedance.adsdk.lottie.model.z.wp wpVar, int i, int i2, int i3, float f, float f2, float f3, float f4, com.bytedance.adsdk.lottie.model.z.uy uyVar, com.bytedance.adsdk.lottie.model.z.kb kbVar, List<com.bytedance.adsdk.lottie.m.z<Float>> list3, g gVar, com.bytedance.adsdk.lottie.model.z.g gVar2, boolean z2, com.bytedance.adsdk.lottie.model.g.z zVar2, com.bytedance.adsdk.lottie.a.uy uyVar2) {
        this.z = list;
        this.g = mVar;
        this.dl = str;
        this.f184a = j;
        this.gc = zVar;
        this.m = j2;
        this.e = str2;
        this.gz = list2;
        this.fo = wpVar;
        this.uy = i;
        this.kb = i2;
        this.wp = i3;
        this.i = f;
        this.v = f2;
        this.pf = f3;
        this.ls = f4;
        this.p = uyVar;
        this.fv = kbVar;
        this.tb = list3;
        this.q = gVar;
        this.js = gVar2;
        this.iq = z2;
        this.zw = zVar2;
        this.io = uyVar2;
    }

    com.bytedance.adsdk.lottie.m z() {
        return this.g;
    }

    float g() {
        return this.i;
    }

    float dl() {
        return this.v / this.g.fv();
    }

    List<com.bytedance.adsdk.lottie.m.z<Float>> a() {
        return this.tb;
    }

    public long gc() {
        return this.f184a;
    }

    public String m() {
        return this.dl;
    }

    public String e() {
        return this.e;
    }

    float gz() {
        return this.pf;
    }

    float fo() {
        return this.ls;
    }

    List<com.bytedance.adsdk.lottie.model.g.gz> uy() {
        return this.gz;
    }

    public z kb() {
        return this.gc;
    }

    g wp() {
        return this.q;
    }

    long i() {
        return this.m;
    }

    List<com.bytedance.adsdk.lottie.model.g.dl> v() {
        return this.z;
    }

    com.bytedance.adsdk.lottie.model.z.wp pf() {
        return this.fo;
    }

    int ls() {
        return this.wp;
    }

    int p() {
        return this.kb;
    }

    int fv() {
        return this.uy;
    }

    com.bytedance.adsdk.lottie.model.z.uy js() {
        return this.p;
    }

    com.bytedance.adsdk.lottie.model.z.kb tb() {
        return this.fv;
    }

    com.bytedance.adsdk.lottie.model.z.g q() {
        return this.js;
    }

    public String toString() {
        return z("");
    }

    public boolean iq() {
        return this.iq;
    }

    public com.bytedance.adsdk.lottie.model.g.z zw() {
        return this.zw;
    }

    public com.bytedance.adsdk.lottie.a.uy io() {
        return this.io;
    }

    public String z(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(m()).append("\n");
        gz gzVarZ = this.g.z(i());
        if (gzVarZ != null) {
            sb.append("\t\tParents: ").append(gzVarZ.m());
            gz gzVarZ2 = this.g.z(gzVarZ.i());
            while (gzVarZ2 != null) {
                sb.append("->").append(gzVarZ2.m());
                gzVarZ2 = this.g.z(gzVarZ2.i());
            }
            sb.append(str).append("\n");
        }
        if (!uy().isEmpty()) {
            sb.append(str).append("\tMasks: ").append(uy().size()).append("\n");
        }
        if (fv() != 0 && p() != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(fv()), Integer.valueOf(p()), Integer.valueOf(ls())));
        }
        if (!this.z.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.bytedance.adsdk.lottie.model.g.dl> it = this.z.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append("\n");
            }
        }
        return sb.toString();
    }
}
