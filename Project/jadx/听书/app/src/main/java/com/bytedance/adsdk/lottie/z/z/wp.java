package com.bytedance.adsdk.lottie.z.z;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.model.g.fo;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public class wp implements i, uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f217a;
    private final com.bytedance.adsdk.lottie.model.g.fo m;
    private final Path z = new Path();
    private final Path g = new Path();
    private final Path dl = new Path();
    private final List<i> gc = new ArrayList();

    public wp(com.bytedance.adsdk.lottie.model.g.fo foVar) {
        this.f217a = foVar.z();
        this.m = foVar;
    }

    @Override // com.bytedance.adsdk.lottie.z.z.uy
    public void z(ListIterator<dl> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            dl dlVarPrevious = listIterator.previous();
            if (dlVarPrevious instanceof i) {
                this.gc.add((i) dlVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.z.dl
    public void z(List<dl> list, List<dl> list2) {
        for (int i = 0; i < this.gc.size(); i++) {
            this.gc.get(i).z(list, list2);
        }
    }

    @Override // com.bytedance.adsdk.lottie.z.z.i
    public Path a() {
        this.dl.reset();
        if (this.m.dl()) {
            return this.dl;
        }
        int i = AnonymousClass1.z[this.m.g().ordinal()];
        if (i == 1) {
            z();
        } else if (i == 2) {
            z(Path.Op.UNION);
        } else if (i == 3) {
            z(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            z(Path.Op.INTERSECT);
        } else if (i == 5) {
            z(Path.Op.XOR);
        }
        return this.dl;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.lottie.z.z.wp$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[fo.z.values().length];
            z = iArr;
            try {
                iArr[fo.z.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[fo.z.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[fo.z.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                z[fo.z.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                z[fo.z.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void z() {
        for (int i = 0; i < this.gc.size(); i++) {
            this.dl.addPath(this.gc.get(i).a());
        }
    }

    private void z(Path.Op op) {
        this.g.reset();
        this.z.reset();
        for (int size = this.gc.size() - 1; size > 0; size--) {
            i iVar = this.gc.get(size);
            if (iVar instanceof a) {
                a aVar = (a) iVar;
                List<i> listG = aVar.g();
                for (int size2 = listG.size() - 1; size2 >= 0; size2--) {
                    Path pathA = listG.get(size2).a();
                    pathA.transform(aVar.dl());
                    this.g.addPath(pathA);
                }
            } else {
                this.g.addPath(iVar.a());
            }
        }
        i iVar2 = this.gc.get(0);
        if (iVar2 instanceof a) {
            a aVar2 = (a) iVar2;
            List<i> listG2 = aVar2.g();
            for (int i = 0; i < listG2.size(); i++) {
                Path pathA2 = listG2.get(i).a();
                pathA2.transform(aVar2.dl());
                this.z.addPath(pathA2);
            }
        } else {
            this.z.set(iVar2.a());
        }
        this.dl.op(this.z, this.g, op);
    }
}
