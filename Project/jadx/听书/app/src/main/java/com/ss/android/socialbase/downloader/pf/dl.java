package com.ss.android.socialbase.downloader.pf;

import android.util.SparseArray;
import com.bytedance.pangle.ZeusPluginEventCallback;
import com.bytedance.sdk.component.utils.wp;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.tb;

/* JADX INFO: loaded from: classes4.dex */
public class dl {
    public static void z(int i, SparseArray<hh> sparseArray, boolean z, com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        SparseArray<hh> sparseArrayClone;
        if (!z || sparseArray == null) {
            return;
        }
        try {
            if (sparseArray.size() <= 0) {
                return;
            }
            synchronized (sparseArray) {
                sparseArrayClone = sparseArray.clone();
            }
            for (int i2 = 0; i2 < sparseArrayClone.size(); i2++) {
                hh hhVar = sparseArrayClone.get(sparseArrayClone.keyAt(i2));
                if (hhVar != null) {
                    if (i == 1) {
                        hhVar.z(dlVar);
                    } else if (i == 2) {
                        hhVar.g(dlVar);
                    } else if (i == 4) {
                        hhVar.dl(dlVar);
                    } else if (i == 5) {
                        hhVar.g(dlVar, zVar);
                    } else if (i == 6) {
                        hhVar.gz(dlVar);
                    } else if (i == 7) {
                        hhVar.dl(dlVar, zVar);
                    } else if (i != 11) {
                        switch (i) {
                            case ZeusPluginEventCallback.RESULT_INSTALLATION_FAILED_COPY_SO /* -7 */:
                                if (hhVar instanceof com.ss.android.socialbase.downloader.a.dl) {
                                    ((com.ss.android.socialbase.downloader.a.dl) hhVar).uy(dlVar);
                                }
                                break;
                            case -6:
                                hhVar.fo(dlVar);
                                break;
                            case -5:
                            case -2:
                                hhVar.a(dlVar);
                                break;
                            case -4:
                                hhVar.m(dlVar);
                                break;
                            case -3:
                                hhVar.gc(dlVar);
                                break;
                            case -1:
                                hhVar.z(dlVar, zVar);
                                break;
                        }
                    } else if (hhVar instanceof tb) {
                        ((tb) hhVar).e(dlVar);
                    }
                }
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }
}
