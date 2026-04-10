package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.jb;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ww {
    private static volatile ww mb;
    private final ko b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.ss.android.downloadad.api.ox f18045h;
    private final com.ss.android.downloadad.api.mb hj;
    private final com.ss.android.download.api.mb ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f18046u;

    /* JADX INFO: Access modifiers changed from: private */
    public ko ww() {
        return this.b;
    }

    public void b() {
        this.f18046u = System.currentTimeMillis();
    }

    public com.ss.android.downloadad.api.ox h() {
        if (this.f18045h == null) {
            this.f18045h = ox.mb();
        }
        return this.f18045h;
    }

    public com.ss.android.downloadad.api.mb hj() {
        return this.hj;
    }

    public void ko() {
        hj.mb().h();
    }

    public String u() {
        return x.nk();
    }

    private ww(Context context) {
        this.b = ko.mb();
        this.ox = new h();
        this.f18046u = System.currentTimeMillis();
        ox(context);
        this.hj = mb.mb();
    }

    public static ww mb(final Context context) {
        if (mb == null) {
            synchronized (ww.class) {
                if (mb == null) {
                    com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ww unused = ww.mb = new ww(context);
                        }
                    });
                }
            }
        }
        return mb;
    }

    private void ox(Context context) {
        x.mb(context);
        Downloader.getInstance(x.getContext());
        com.ss.android.downloadlib.addownload.model.u.mb().ox();
        com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), "misc_config", new com.ss.android.downloadlib.b.ko(), new com.ss.android.downloadlib.b.u(context), new b());
        com.ss.android.downloadlib.b.hj hjVar = new com.ss.android.downloadlib.b.hj();
        com.ss.android.socialbase.appdownloader.hj.x().mb(hjVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(hjVar);
        com.ss.android.socialbase.appdownloader.hj.x().mb(new jb());
        DownloadComponentManager.setDownloadEventListener(new com.ss.android.downloadlib.b.h());
        com.ss.android.socialbase.appdownloader.hj.x().mb(com.ss.android.downloadlib.hj.b.mb());
    }

    public com.ss.android.download.api.mb mb() {
        return this.ox;
    }

    public com.ss.android.download.api.mb mb(String str) {
        com.ss.android.download.api.config.u uVarOx = u.mb().ox();
        if (uVarOx != null && uVarOx.mb(str)) {
            return uVarOx.ox(str);
        }
        return this.ox;
    }

    public long ox() {
        return this.f18046u;
    }

    @MainThread
    public void mb(final Context context, final int i2, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.4
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(context, i2, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public DownloadInfo ox(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), str);
    }

    @MainThread
    public void mb(final String str, final long j2, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.5
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, j2, i2, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void mb(final String str, final long j2, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.6
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, j2, i2, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void mb(final String str, final long j2, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.7
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, j2, i2, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void mb(final String str, final int i2) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.2
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, i2);
            }
        });
    }

    @MainThread
    public void mb(final String str, final boolean z2) {
        com.ss.android.downloadlib.exception.ox.mb(new Runnable() { // from class: com.ss.android.downloadlib.ww.3
            @Override // java.lang.Runnable
            public void run() {
                ww.this.ww().mb(str, z2);
            }
        });
    }

    public void mb(com.ss.android.download.api.download.mb.mb mbVar) {
        ww().mb(mbVar);
    }
}
