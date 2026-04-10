package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ko {
    private static volatile ko mb;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f18030u;
    private final List<com.ss.android.downloadlib.addownload.u> b = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.addownload.u> hj = new ConcurrentHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CopyOnWriteArrayList<Object> f18029h = new CopyOnWriteArrayList<>();
    private final Handler ox = new Handler(Looper.getMainLooper());

    private ko() {
    }

    private void b(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.h hVar = new com.ss.android.downloadlib.addownload.h();
        hVar.ox(context).ox(i2, downloadStatusChangeListener).ox(downloadModel).mb();
        this.hj.put(downloadModel.getDownloadUrl(), hVar);
    }

    private void hj() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.u uVar : this.b) {
            if (!uVar.ox() && jCurrentTimeMillis - uVar.hj() > 300000) {
                uVar.ww();
                arrayList.add(uVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.b.removeAll(arrayList);
    }

    private synchronized void ox(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.b.size() <= 0) {
            b(context, i2, downloadStatusChangeListener, downloadModel);
        } else {
            com.ss.android.downloadlib.addownload.u uVarRemove = this.b.remove(0);
            uVarRemove.ox(context).ox(i2, downloadStatusChangeListener).ox(downloadModel).mb();
            this.hj.put(downloadModel.getDownloadUrl(), uVarRemove);
        }
    }

    public static ko mb() {
        if (mb == null) {
            synchronized (ko.class) {
                if (mb == null) {
                    mb = new ko();
                }
            }
        }
        return mb;
    }

    private void b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f18030u < 300000) {
            return;
        }
        this.f18030u = jCurrentTimeMillis;
        if (this.b.isEmpty()) {
            return;
        }
        hj();
    }

    public void mb(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        com.ss.android.downloadlib.addownload.u uVar = this.hj.get(downloadModel.getDownloadUrl());
        if (uVar != null) {
            uVar.ox(context).ox(i2, downloadStatusChangeListener).ox(downloadModel).mb();
        } else if (!this.b.isEmpty()) {
            ox(context, i2, downloadStatusChangeListener, downloadModel);
        } else {
            b(context, i2, downloadStatusChangeListener, downloadModel);
        }
    }

    public void ox(final DownloadInfo downloadInfo, final String str) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.4
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : ko.this.f18029h) {
                    if (obj instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) obj).ox(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).ox(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler ox() {
        return this.ox;
    }

    public com.ss.android.downloadlib.addownload.h mb(String str) {
        Map<String, com.ss.android.downloadlib.addownload.u> map = this.hj;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            com.ss.android.downloadlib.addownload.u uVar = this.hj.get(str);
            if (uVar instanceof com.ss.android.downloadlib.addownload.h) {
                return (com.ss.android.downloadlib.addownload.h) uVar;
            }
        }
        return null;
    }

    public void mb(String str, int i2) {
        com.ss.android.downloadlib.addownload.u uVar;
        if (TextUtils.isEmpty(str) || (uVar = this.hj.get(str)) == null) {
            return;
        }
        if (uVar.mb(i2)) {
            this.b.add(uVar);
            this.hj.remove(str);
        }
        b();
    }

    public void mb(String str, boolean z2) {
        com.ss.android.downloadlib.addownload.u uVar;
        if (TextUtils.isEmpty(str) || (uVar = this.hj.get(str)) == null) {
            return;
        }
        uVar.mb(z2);
    }

    public void mb(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        mb(str, j2, i2, downloadEventConfig, downloadController, null, null);
    }

    public void mb(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        mb(str, j2, i2, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void mb(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.u uVar;
        if (TextUtils.isEmpty(str) || (uVar = this.hj.get(str)) == null) {
            return;
        }
        uVar.mb(j2).ox(downloadEventConfig).ox(downloadController).mb(onItemClickListener).mb(iDownloadButtonClickListener).ox(i2);
    }

    public void mb(com.ss.android.download.api.download.mb.mb mbVar) {
        if (mbVar != null) {
            if (DownloadSetting.obtainGlobal().optBugFix("fix_listener_oom", false)) {
                this.f18029h.add(new SoftReference(mbVar));
            } else {
                this.f18029h.add(mbVar);
            }
        }
    }

    public void mb(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.1
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : ko.this.f18029h) {
                    if (obj instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) obj).mb(downloadModel, downloadController, downloadEventConfig);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).mb(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void mb(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.2
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : ko.this.f18029h) {
                    if (obj instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) obj).mb(downloadInfo, baseException, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).mb(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void mb(final DownloadInfo downloadInfo, final String str) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.3
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : ko.this.f18029h) {
                    if (obj instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) obj).mb(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).mb(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void mb(final DownloadInfo downloadInfo) {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.ko.5
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : ko.this.f18029h) {
                    if (obj instanceof com.ss.android.download.api.download.mb.mb) {
                        ((com.ss.android.download.api.download.mb.mb) obj).mb(downloadInfo);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.mb.mb) {
                            ((com.ss.android.download.api.download.mb.mb) softReference.get()).mb(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
