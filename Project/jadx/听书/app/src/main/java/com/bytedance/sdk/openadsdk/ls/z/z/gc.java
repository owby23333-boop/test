package com.bytedance.sdk.openadsdk.ls.z.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.DownloadStatusController;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements DownloadStatusController {
    private final Function<SparseArray<Object>, Object> z;

    public gc(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.dl.dl : function;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 222101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999987, 222102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
