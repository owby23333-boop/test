package com.bytedance.z.g.gc.z;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static volatile gc z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f1519a;
    private Map<com.bytedance.z.g.dl, dl> dl = new HashMap();
    private Context g;
    private a gc;

    private gc(Context context) {
        this.g = context;
        this.f1519a = new g(this.g);
        this.gc = new a(this.g);
    }

    public static gc z() {
        if (z == null) {
            throw new IllegalArgumentException("CrashContextAssembly not init");
        }
        return z;
    }

    public static void z(Context context) {
        if (z == null) {
            z = new gc(context);
        }
    }

    private dl z(com.bytedance.z.g.dl dlVar) {
        dl eVar = this.dl.get(dlVar);
        if (eVar != null) {
            return eVar;
        }
        int i = AnonymousClass1.z[dlVar.ordinal()];
        if (i == 1) {
            eVar = new e(this.g, this.f1519a, this.gc);
        } else if (i == 2) {
            eVar = new z(this.g, this.f1519a, this.gc);
        } else if (i == 3) {
            eVar = new m(this.g, this.f1519a, this.gc);
        }
        if (eVar != null) {
            this.dl.put(dlVar, eVar);
        }
        return eVar;
    }

    /* JADX INFO: renamed from: com.bytedance.z.g.gc.z.gc$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[com.bytedance.z.g.dl.values().length];
            z = iArr;
            try {
                iArr[com.bytedance.z.g.dl.JAVA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[com.bytedance.z.g.dl.ANR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[com.bytedance.z.g.dl.CUSTOM_JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public com.bytedance.z.g.dl.z z(com.bytedance.z.g.dl dlVar, com.bytedance.z.g.dl.z zVar) {
        dl dlVarZ;
        return (dlVar == null || (dlVarZ = z(dlVar)) == null) ? zVar : dlVarZ.z(zVar);
    }
}
