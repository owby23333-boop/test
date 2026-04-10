package com.bytedance.sdk.openadsdk.dl;

import android.app.Application;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.dl.z;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Function<SparseArray<Object>, Object> {
    private static volatile a z;
    private final z dl = new z();
    private dl g;

    private a() {
    }

    public static a z() {
        if (z == null) {
            synchronized (a.class) {
                if (z == null) {
                    z = new a();
                }
            }
        }
        return z;
    }

    public Application.ActivityLifecycleCallbacks g() {
        return this.dl;
    }

    public void z(dl dlVar) {
        this.g = dlVar;
    }

    private void z(final g gVar) {
        this.dl.z(new z.InterfaceC0217z() { // from class: com.bytedance.sdk.openadsdk.dl.a.1
            @Override // com.bytedance.sdk.openadsdk.dl.z.InterfaceC0217z
            public void z() {
                gVar.z();
            }

            @Override // com.bytedance.sdk.openadsdk.dl.z.InterfaceC0217z
            public void g() {
                gVar.g();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> functionZ;
        int iIntValue = ((Integer) sparseArray.get(-99999987)).intValue();
        if (iIntValue == -99999986) {
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(10000, 5);
            return sparseArray2;
        }
        if (iIntValue != 14) {
            switch (iIntValue) {
                case 2:
                    return this.dl.z();
                case 3:
                    return TTAppContextHolder.getContext();
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    dl dlVar = this.g;
                    if (dlVar != null && (functionZ = dlVar.z(4)) != null) {
                        return functionZ.apply(sparseArray);
                    }
                    return null;
                case 9:
                    Object obj = sparseArray.get(0);
                    if (obj instanceof Function) {
                        z(new g((Function) obj));
                    }
                    return null;
                case 10:
                    dl dlVar2 = this.g;
                    if (dlVar2 == null) {
                        return null;
                    }
                    return dlVar2.z(((Integer) sparseArray.get(0)).intValue());
                default:
                    return null;
            }
        }
        return this.dl.g();
    }
}
