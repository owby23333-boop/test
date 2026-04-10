package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static volatile g z;
    private Handler g = null;

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    public void z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (g() && dlVar != null) {
            try {
                File file = new File(dlVar.kb(), dlVar.gz());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            if (this.g == null) {
                this.g = new Handler(Looper.getMainLooper());
            }
            final String strUy = dlVar.uy();
            com.ss.android.socialbase.downloader.downloader.e.g(context).uy(dlVar.e());
            this.g.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.g.1
                @Override // java.lang.Runnable
                public void run() {
                    wp.dl().z(3, wp.getContext(), null, "下载失败，请重试！", null, 0);
                    gc gcVarZ = com.ss.android.downloadlib.gz.z().z(strUy);
                    if (gcVarZ != null) {
                        gcVarZ.e();
                    }
                }
            });
        }
    }

    public boolean g() {
        return wp.fo().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }
}
