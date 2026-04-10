package com.bytedance.adsdk.ugeno.z.g;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.z.gc;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    public g(Context context, com.bytedance.adsdk.ugeno.g.dl dlVar, String str, TreeMap<Float, String> treeMap) {
        super(context, dlVar, str, treeMap);
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.z.g.g$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[gc.values().length];
            z = iArr;
            try {
                iArr[gc.TRANSLATE_X.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[gc.TRANSLATE_Y.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[gc.SCALE_X.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                z[gc.SCALE_Y.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                z[gc.ROTATE_X.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                z[gc.ROTATE_Y.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                z[gc.ROTATE_Z.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                z[gc.ALPHA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                z[gc.BORDER_RADIUS.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public void g() {
        float fI;
        switch (AnonymousClass1.z[this.f270a.ordinal()]) {
            case 1:
                fI = this.e.i();
                break;
            case 2:
                fI = this.e.v();
                break;
            case 3:
                fI = this.e.pf();
                break;
            case 4:
                fI = this.e.ls();
                break;
            case 5:
                fI = this.e.p();
                break;
            case 6:
                fI = this.e.fv();
                break;
            case 7:
                fI = this.e.js();
                break;
            case 8:
                fI = this.e.tb();
                break;
            case 9:
                fI = this.e.q();
                break;
            default:
                fI = 0.0f;
                break;
        }
        this.gc.add(Keyframe.ofFloat(0.0f, fI));
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public void z(float f, String str) {
        float fZ;
        if (this.g.startsWith(gc.TRANSLATE.z()) || this.f270a == gc.BORDER_RADIUS) {
            fZ = gz.z(this.z, com.bytedance.adsdk.ugeno.m.dl.z(str, 0.0f));
        } else {
            fZ = com.bytedance.adsdk.ugeno.m.dl.z(str, 0.0f);
        }
        this.gc.add(Keyframe.ofFloat(f, fZ));
    }

    @Override // com.bytedance.adsdk.ugeno.z.g.z
    public TypeEvaluator m() {
        return new FloatEvaluator();
    }
}
