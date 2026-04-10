package com.bytedance.sdk.component.m;

import android.graphics.Bitmap;
import android.util.SparseArray;
import android.widget.ImageView;
import java.util.concurrent.ExecutorService;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class pf implements v, Function {
    v g;
    Function z;

    public pf(v vVar) {
        this.g = vVar;
    }

    public pf(Function function) {
        this.z = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object ufVar = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (ufVar != null) {
                    ufVar = new uf((Function) ufVar);
                }
                wp wpVar = this.g.to((io) ufVar, ((Integer) obj2).intValue());
                return wpVar != null ? new i(wpVar) : wpVar;
            case 2:
                Object ufVar2 = sparseArray.get(1);
                if (ufVar2 != null) {
                    ufVar2 = new uf((Function) ufVar2);
                }
                wp wpVar2 = this.g.to((io) ufVar2);
                return wpVar2 != null ? new i(wpVar2) : wpVar2;
            case 3:
                wp wpVar3 = this.g.to((ImageView) sparseArray.get(1));
                return wpVar3 != null ? new i(wpVar3) : wpVar3;
            case 4:
                return this.g.from((String) sparseArray.get(1));
            case 5:
                return this.g.key((String) sparseArray.get(1));
            case 6:
                Object dlVar = sparseArray.get(1);
                if (dlVar != null) {
                    dlVar = new dl((Function) dlVar);
                }
                return this.g.cache((g) dlVar);
            case 7:
                return this.g.cacheDir((String) sparseArray.get(1));
            case 8:
                return this.g.scaleType((ImageView.ScaleType) sparseArray.get(1));
            case 9:
                return this.g.config((Bitmap.Config) sparseArray.get(1));
            case 10:
                return this.g.width(((Integer) sparseArray.get(1)).intValue());
            case 11:
                return this.g.height(((Integer) sparseArray.get(1)).intValue());
            case 12:
                return this.g.type(((Integer) sparseArray.get(1)).intValue());
            case 13:
                Object gkVar = sparseArray.get(1);
                if (gkVar != null) {
                    gkVar = new gk((Function) gkVar);
                }
                return this.g.track((h) gkVar);
            case 14:
                return this.g.headers(((Boolean) sparseArray.get(1)).booleanValue());
            case 15:
                return this.g.requestTime(((Boolean) sparseArray.get(1)).booleanValue());
            case 16:
                return this.g.runIn((ExecutorService) sparseArray.get(1));
            case 17:
                Object kbVar = sparseArray.get(1);
                if (kbVar != null) {
                    kbVar = new kb((Function) kbVar);
                }
                return this.g.converter((uy) kbVar);
            case 18:
                return this.g.maxWidth(((Integer) sparseArray.get(1)).intValue());
            case 19:
                return this.g.maxHeight(((Integer) sparseArray.get(1)).intValue());
            case 20:
                return this.g.sync(((Boolean) sparseArray.get(1)).booleanValue());
            case 21:
                Object qVar = sparseArray.get(1);
                if (qVar != null) {
                    qVar = new q((Function) qVar);
                }
                return this.g.loadSetp((tb) qVar);
            default:
                return null;
        }
    }

    @Override // com.bytedance.sdk.component.m.v
    public v cache(g gVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        if (gVar != null) {
            gVar = new dl(gVar);
        }
        sparseArray.put(1, gVar);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v cacheDir(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, str);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v config(Bitmap.Config config) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, config);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v converter(uy uyVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        if (uyVar != null) {
            uyVar = new kb(uyVar);
        }
        sparseArray.put(1, uyVar);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v from(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v headers(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Boolean.valueOf(z));
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v height(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Integer.valueOf(i));
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v key(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v loadSetp(tb tbVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        if (tbVar != null) {
            tbVar = new q(tbVar);
        }
        sparseArray.put(1, tbVar);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v maxHeight(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, Integer.valueOf(i));
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v maxWidth(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, Integer.valueOf(i));
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v requestTime(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Boolean.valueOf(z));
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v runIn(ExecutorService executorService) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, executorService);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v scaleType(ImageView.ScaleType scaleType) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, scaleType);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v sync(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        sparseArray.put(1, Boolean.valueOf(z));
        this.z.apply(sparseArray);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.bytedance.sdk.component.m.v
    public wp to(ImageView imageView) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, imageView);
        ?? Apply = this.z.apply(sparseArray);
        ?? iVar = Apply;
        if (Apply != 0) {
            iVar = new i((Function) Apply);
        }
        return (wp) iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.bytedance.sdk.component.m.v
    public wp to(io ioVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (ioVar != null) {
            ioVar = new uf(ioVar);
        }
        sparseArray.put(1, ioVar);
        ?? Apply = this.z.apply(sparseArray);
        ?? iVar = Apply;
        if (Apply != 0) {
            iVar = new i((Function) Apply);
        }
        return (wp) iVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.bytedance.sdk.component.m.v
    public wp to(io ioVar, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (ioVar != null) {
            ioVar = new uf(ioVar);
        }
        sparseArray.put(1, ioVar);
        sparseArray.put(2, Integer.valueOf(i));
        ?? Apply = this.z.apply(sparseArray);
        ?? iVar = Apply;
        if (Apply != 0) {
            iVar = new i((Function) Apply);
        }
        return (wp) iVar;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v track(h hVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        if (hVar != null) {
            hVar = new gk(hVar);
        }
        sparseArray.put(1, hVar);
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v type(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, Integer.valueOf(i));
        this.z.apply(sparseArray);
        return this;
    }

    @Override // com.bytedance.sdk.component.m.v
    public v width(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Integer.valueOf(i));
        this.z.apply(sparseArray);
        return this;
    }
}
