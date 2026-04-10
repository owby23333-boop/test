package com.bytedance.sdk.openadsdk.ls.z.g;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Function<SparseArray<Object>, Object> {
    private final ExitInstallListener z;

    public z(ExitInstallListener exitInstallListener) {
        this.z = exitInstallListener;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.z != null && com.bykv.z.z.z.z.dl.z(sparseArray).g().intValue(-99999987) == 223101) {
            this.z.onExitInstall();
        }
        return null;
    }
}
