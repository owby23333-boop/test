package com.bytedance.adsdk.lottie.model.g;

import android.graphics.Paint;
import com.bytedance.adsdk.lottie.z.z.tb;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class fv implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.model.z.z f166a;
    private final List<com.bytedance.adsdk.lottie.model.z.g> dl;
    private final z e;
    private final float fo;
    private final com.bytedance.adsdk.lottie.model.z.g g;
    private final com.bytedance.adsdk.lottie.model.z.a gc;
    private final g gz;
    private final com.bytedance.adsdk.lottie.model.z.g m;
    private final boolean uy;
    private final String z;

    public enum z {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap z() {
            int i = AnonymousClass1.z[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i == 2) {
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.SQUARE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.model.g.fv$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] g;
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[g.values().length];
            g = iArr;
            try {
                iArr[g.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                g[g.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                g[g.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[z.values().length];
            z = iArr2;
            try {
                iArr2[z.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                z[z.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                z[z.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum g {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join z() {
            int i = AnonymousClass1.g[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public fv(String str, com.bytedance.adsdk.lottie.model.z.g gVar, List<com.bytedance.adsdk.lottie.model.z.g> list, com.bytedance.adsdk.lottie.model.z.z zVar, com.bytedance.adsdk.lottie.model.z.a aVar, com.bytedance.adsdk.lottie.model.z.g gVar2, z zVar2, g gVar3, float f, boolean z2) {
        this.z = str;
        this.g = gVar;
        this.dl = list;
        this.f166a = zVar;
        this.gc = aVar;
        this.m = gVar2;
        this.e = zVar2;
        this.gz = gVar3;
        this.fo = f;
        this.uy = z2;
    }

    @Override // com.bytedance.adsdk.lottie.model.g.dl
    public com.bytedance.adsdk.lottie.z.z.dl z(com.bytedance.adsdk.lottie.gz gzVar, com.bytedance.adsdk.lottie.m mVar, com.bytedance.adsdk.lottie.model.layer.dl dlVar) {
        return new tb(gzVar, dlVar, this);
    }

    public String z() {
        return this.z;
    }

    public com.bytedance.adsdk.lottie.model.z.z g() {
        return this.f166a;
    }

    public com.bytedance.adsdk.lottie.model.z.a dl() {
        return this.gc;
    }

    public com.bytedance.adsdk.lottie.model.z.g a() {
        return this.m;
    }

    public List<com.bytedance.adsdk.lottie.model.z.g> gc() {
        return this.dl;
    }

    public com.bytedance.adsdk.lottie.model.z.g m() {
        return this.g;
    }

    public z e() {
        return this.e;
    }

    public g gz() {
        return this.gz;
    }

    public float fo() {
        return this.fo;
    }

    public boolean uy() {
        return this.uy;
    }
}
