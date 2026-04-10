package com.ss.android.downloadlib.addownload.b;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.ww;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class u {
    private static u mb;
    private List<hj> ox = new ArrayList();

    private u() {
        this.ox.add(new h());
        this.ox.add(new ko());
        this.ox.add(new ox());
        this.ox.add(new mb());
    }

    public static u mb() {
        if (mb == null) {
            synchronized (u.class) {
                if (mb == null) {
                    mb = new u();
                }
            }
        }
        return mb;
    }

    public void mb(com.ss.android.downloadad.api.mb.ox oxVar, int i2, b bVar) {
        List<hj> list = this.ox;
        if (list != null && list.size() != 0 && oxVar != null) {
            DownloadInfo downloadInfoOx = ww.mb((Context) null).ox(oxVar.mb());
            if (downloadInfoOx != null && AdBaseConstants.MIME_APK.equals(downloadInfoOx.getMimeType())) {
                boolean z2 = DownloadSetting.obtain(oxVar.m()).optInt("pause_optimise_switch", 0) == 1;
                for (hj hjVar : this.ox) {
                    if (z2 || (hjVar instanceof ko)) {
                        if (hjVar.mb(oxVar, i2, bVar)) {
                            return;
                        }
                    }
                }
                bVar.mb(oxVar);
                return;
            }
            bVar.mb(oxVar);
            return;
        }
        bVar.mb(oxVar);
    }
}
