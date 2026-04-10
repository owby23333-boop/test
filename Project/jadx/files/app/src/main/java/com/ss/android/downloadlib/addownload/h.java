package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.b;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.ko;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.je;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h implements u, je.mb {
    private static final String mb = "h";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private SoftReference<OnItemClickListener> f17985e;
    private SoftReference<IDownloadButtonClickListener> gm;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference<Context> f17986h;
    private boolean jb;
    private long je;
    private DownloadShortInfo ko;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17988l;
    private b lz;
    private DownloadInfo ww;
    private final com.ss.android.downloadlib.utils.je ox = new com.ss.android.downloadlib.utils.je(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final Map<Integer, Object> f17991u = new ConcurrentHashMap();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final IDownloadListener f17992x = new ko.mb(this.ox);
    private long nk = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private DownloadModel f17990o = null;
    private DownloadEventConfig lc = null;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private DownloadController f17987io = null;
    private ko b = new ko(this);
    private hj hj = new hj(this.ox);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f17989m = DownloadSetting.obtainGlobal().optBugFix("ttdownloader_callback_twice");

    interface mb {
        void mb();
    }

    interface ox {
        void mb(long j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadShortInfo e() {
        if (this.ko == null) {
            this.ko = new DownloadShortInfo();
        }
        return this.ko;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.f17986h;
        return (weakReference == null || weakReference.get() == null) ? x.getContext() : this.f17986h.get();
    }

    private void io() {
        b bVar = this.lz;
        if (bVar != null && bVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.lz.cancel(true);
        }
        this.lz = new b();
        com.ss.android.downloadlib.utils.ox.mb(this.lz, this.f17990o.getDownloadUrl(), this.f17990o.getPackageName());
    }

    private void jb() {
        SoftReference<OnItemClickListener> softReference = this.f17985e;
        if (softReference == null || softReference.get() == null) {
            x.ox().mb(getContext(), this.f17990o, nk(), je());
        } else {
            this.f17985e.get().onItemClick(this.f17990o, je(), nk());
            this.f17985e = null;
        }
    }

    @NonNull
    private DownloadEventConfig je() {
        DownloadEventConfig downloadEventConfig = this.lc;
        return downloadEventConfig == null ? new b.mb().mb() : downloadEventConfig;
    }

    private boolean lc() {
        if (!DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            DownloadInfo downloadInfo = this.ww;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || Downloader.getInstance(x.getContext()).canResume(this.ww.getId())) || this.ww.getStatus() == 0;
        }
        DownloadInfo downloadInfo2 = this.ww;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.ww.getCurBytes() <= 0) || this.ww.getStatus() == 0 || this.ww.getStatus() == -4) {
            return true;
        }
        return DownloadUtils.isDownloadSuccessAndFileNotExist(this.ww.getStatus(), this.ww.getSavePath(), this.ww.getName());
    }

    @NonNull
    private DownloadController nk() {
        if (this.f17987io == null) {
            this.f17987io = new com.ss.android.download.api.download.ox();
        }
        return this.f17987io;
    }

    private void o() {
        com.ss.android.downloadlib.utils.x.mb(mb, "pICD", null);
        if (this.b.hj(this.ww)) {
            com.ss.android.downloadlib.utils.x.mb(mb, "pICD BC", null);
            u(false);
        } else {
            com.ss.android.downloadlib.utils.x.mb(mb, "pICD IC", null);
            jb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ko(final boolean z2) {
        this.hj.mb(new com.ss.android.downloadlib.addownload.model.h(this.nk, this.f17990o, je(), nk()));
        this.hj.mb(0, 0L, 0L, new mb() { // from class: com.ss.android.downloadlib.addownload.h.5
            @Override // com.ss.android.downloadlib.addownload.h.mb
            public void mb() {
                if (h.this.hj.mb()) {
                    return;
                }
                h.this.ww(z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww(boolean z2) {
        Iterator<DownloadStatusChangeListener> it = ko.mb(this.f17991u).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.f17990o, nk());
        }
        int iMb = this.b.mb(x.getContext(), this.f17992x);
        com.ss.android.downloadlib.utils.x.mb(mb, "beginDown id:" + iMb, null);
        if (iMb == 0) {
            DownloadInfo downloadInfoBuild = new DownloadInfo.Builder(this.f17990o.getDownloadUrl()).build();
            downloadInfoBuild.setStatus(-1);
            mb(downloadInfoBuild);
            AdEventHandler.mb().mb(this.nk, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.exception.b.mb().ox("beginDown");
        } else if (this.ww != null && !DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            this.b.mb(this.ww, false);
        } else if (z2) {
            this.b.mb();
        }
        if (this.b.mb(b())) {
            com.ss.android.downloadlib.utils.x.mb(mb, "beginDown IC id:" + iMb, null);
            jb();
        }
    }

    public boolean b() {
        DownloadInfo downloadInfo = this.ww;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    public boolean h() {
        return x.lz().optInt("quick_app_enable_switch", 0) == 0 && this.f17990o.getQuickAppModel() != null && !TextUtils.isEmpty(this.f17990o.getQuickAppModel().mb()) && com.ss.android.downloadlib.addownload.b.mb(this.ww) && com.ss.android.downloadlib.utils.jb.mb(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.f17990o.getQuickAppModel().mb())));
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public long hj() {
        return this.je;
    }

    public boolean lz() {
        SoftReference<IDownloadButtonClickListener> softReference = this.gm;
        if (softReference == null) {
            return false;
        }
        return ww.mb(this.f17990o, softReference.get());
    }

    public void u() {
        this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.h.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = ko.mb((Map<Integer, Object>) h.this.f17991u).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(h.this.e());
                }
            }
        });
    }

    private boolean b(int i2) {
        if (!h()) {
            return false;
        }
        int i3 = -1;
        String strMb = this.f17990o.getQuickAppModel().mb();
        if (i2 == 1) {
            i3 = 5;
        } else if (i2 == 2) {
            i3 = 4;
        }
        DownloadModel downloadModel = this.f17990o;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean zB = com.ss.android.downloadlib.utils.ww.b(x.getContext(), strMb);
        if (zB) {
            AdEventHandler.mb().mb(this.nk, i2);
            Message messageObtain = Message.obtain();
            messageObtain.what = i3;
            messageObtain.obj = Long.valueOf(this.f17990o.getId());
            com.ss.android.downloadlib.addownload.b.mb().mb(this, i3, this.f17990o);
        } else {
            AdEventHandler.mb().mb(this.nk, false, 0);
        }
        return zB;
    }

    private void u(final boolean z2) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        com.ss.android.downloadlib.utils.x.mb(mb, "pBCD", null);
        if (lc()) {
            com.ss.android.downloadlib.addownload.model.h hVarH = com.ss.android.downloadlib.addownload.model.u.mb().h(this.nk);
            if (this.f17988l) {
                if (lz()) {
                    if (hj(false) && (downloadController2 = hVarH.hj) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        mb(z2, true);
                        return;
                    }
                    return;
                }
                mb(z2, true);
                return;
            }
            if (this.f17990o.isAd() && (downloadController = hVarH.hj) != null && downloadController.enableShowComplianceDialog() && hVarH.ox != null && com.ss.android.downloadlib.addownload.compliance.ox.mb().mb(hVarH.ox) && com.ss.android.downloadlib.addownload.compliance.ox.mb().mb(hVarH)) {
                return;
            }
            mb(z2, true);
            return;
        }
        com.ss.android.downloadlib.utils.x.mb(mb, "pBCD continue download, status:" + this.ww.getStatus(), null);
        DownloadInfo downloadInfo = this.ww;
        if (downloadInfo != null && (downloadModel = this.f17990o) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        final int status = this.ww.getStatus();
        final int id = this.ww.getId();
        final com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(this.ww);
        if (status != -2 && status != -1) {
            if (je.mb(status)) {
                if (this.f17990o.enablePause()) {
                    this.hj.mb(true);
                    com.ss.android.downloadlib.b.ww.mb().ox(com.ss.android.downloadlib.addownload.model.u.mb().hj(this.nk));
                    com.ss.android.downloadlib.addownload.b.u.mb().mb(oxVarMb, status, new com.ss.android.downloadlib.addownload.b.b() { // from class: com.ss.android.downloadlib.addownload.h.3
                        @Override // com.ss.android.downloadlib.addownload.b.b
                        public void mb(com.ss.android.downloadad.api.mb.ox oxVar) {
                            if (h.this.ww == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                                h.this.ww = Downloader.getInstance(x.getContext()).getDownloadInfo(id);
                            }
                            h.this.b.mb(h.this.ww, z2);
                            if (h.this.ww != null && DownloadUtils.isWifi(x.getContext()) && h.this.ww.isPauseReserveOnWifi()) {
                                h.this.ww.stopPauseReserveOnWifi();
                                AdEventHandler.mb().ox(EventConstants.Label.PAUSE_RESERVE_WIFI_CANCEL_ON_WIFI, oxVarMb);
                            } else {
                                h hVar = h.this;
                                hVar.mb(id, status, hVar.ww);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.b.mb(this.ww, z2);
            mb(id, status, this.ww);
            return;
        }
        this.b.mb(this.ww, z2);
        if (oxVarMb != null) {
            oxVarMb.ww(System.currentTimeMillis());
            oxVarMb.lz(this.ww.getCurBytes());
        }
        this.ww.setDownloadFromReserveWifi(false);
        this.hj.mb(new com.ss.android.downloadlib.addownload.model.h(this.nk, this.f17990o, je(), nk()));
        this.hj.mb(id, this.ww.getCurBytes(), this.ww.getTotalBytes(), new mb() { // from class: com.ss.android.downloadlib.addownload.h.2
            @Override // com.ss.android.downloadlib.addownload.h.mb
            public void mb() {
                if (h.this.hj.mb()) {
                    return;
                }
                h hVar = h.this;
                hVar.mb(id, status, hVar.ww);
            }
        });
    }

    public boolean hj(boolean z2) {
        SoftReference<IDownloadButtonClickListener> softReference = this.gm;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z2) {
                    this.gm.get().handleComplianceDialog(true);
                } else {
                    this.gm.get().handleMarketFailedComplianceDialog();
                }
                this.gm = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.exception.b.mb().ox("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.exception.b.mb().ox("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void ko() {
        if (this.f17991u.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = ko.mb(this.f17991u).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.ww;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
    public h ox(Context context) {
        if (context != null) {
            this.f17986h = new WeakReference<>(context);
        }
        x.ox(context);
        return this;
    }

    private class b extends AsyncTask<String, Void, DownloadInfo> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = strArr[0];
            if (h.this.f17990o != null && !TextUtils.isEmpty(h.this.f17990o.getFilePath())) {
                downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(str, h.this.f17990o.getFilePath());
            }
            return downloadInfo == null ? com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), str) : downloadInfo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || h.this.f17990o == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.model.b bVarMb = com.ss.android.downloadlib.utils.jb.mb(h.this.f17990o.getPackageName(), h.this.f17990o.getVersionCode(), h.this.f17990o.getVersionName());
                com.ss.android.downloadlib.addownload.model.ko.mb().mb(h.this.f17990o.getVersionCode(), bVarMb.ox(), com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo));
                boolean zMb = bVarMb.mb();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (zMb || !Downloader.getInstance(x.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(x.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (h.this.ww == null || h.this.ww.getStatus() != -4) {
                        h.this.ww = downloadInfo;
                        if (h.this.f17989m) {
                            Downloader.getInstance(x.getContext()).setMainThreadListener(h.this.ww.getId(), h.this.f17992x, false);
                        } else {
                            Downloader.getInstance(x.getContext()).setMainThreadListener(h.this.ww.getId(), h.this.f17992x);
                        }
                    } else {
                        h.this.ww = null;
                    }
                    h.this.b.mb(h.this.ww, h.this.e(), ko.mb((Map<Integer, Object>) h.this.f17991u));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(x.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                        h.this.ww = null;
                    }
                    if (h.this.ww != null) {
                        Downloader.getInstance(x.getContext()).removeTaskMainListener(h.this.ww.getId());
                        if (h.this.f17989m) {
                            Downloader.getInstance(h.this.getContext()).setMainThreadListener(h.this.ww.getId(), h.this.f17992x, false);
                        } else {
                            Downloader.getInstance(h.this.getContext()).setMainThreadListener(h.this.ww.getId(), h.this.f17992x);
                        }
                    }
                    if (!zMb) {
                        Iterator<DownloadStatusChangeListener> it = ko.mb((Map<Integer, Object>) h.this.f17991u).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        h.this.ww = null;
                    } else {
                        h.this.ww = new DownloadInfo.Builder(h.this.f17990o.getDownloadUrl()).build();
                        h.this.ww.setStatus(-3);
                        h.this.b.mb(h.this.ww, h.this.e(), ko.mb((Map<Integer, Object>) h.this.f17991u));
                    }
                }
                h.this.b.b(h.this.ww);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void h(boolean z2) {
        if (com.ss.android.downloadlib.utils.hj.ox(this.f17990o).optInt("notification_opt_2") == 1 && this.ww != null) {
            DownloadNotificationManager.getInstance().cancelNotification(this.ww.getId());
        }
        u(z2);
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
    public h ox(int i2, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (x.lz().optInt("back_use_softref_listener") == 1) {
                this.f17991u.put(Integer.valueOf(i2), downloadStatusChangeListener);
            } else {
                this.f17991u.put(Integer.valueOf(i2), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public boolean ox() {
        return this.jb;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public void ox(int i2) {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.b.mb(this.nk);
        if (!com.ss.android.downloadlib.addownload.model.u.mb().h(this.nk).jq()) {
            com.ss.android.downloadlib.exception.b.mb().mb("handleDownload ModelBox !isStrictValid");
        }
        if (this.b.mb(getContext(), i2, this.f17988l)) {
            return;
        }
        boolean zB = b(i2);
        if (i2 == 1) {
            if (zB) {
                return;
            }
            com.ss.android.downloadlib.utils.x.mb(mb, "handleDownload id:" + this.nk + ",pIC:", null);
            b(true);
            return;
        }
        if (i2 == 2 && !zB) {
            com.ss.android.downloadlib.utils.x.mb(mb, "handleDownload id:" + this.nk + ",pBC:", null);
            ox(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
    public h ox(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.exception.b.mb().mb("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.exception.b.mb().mb(false, "setDownloadModel id=0");
                if (DownloadSetting.obtainGlobal().optBugFix("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadModel);
            this.nk = downloadModel.getId();
            this.f17990o = downloadModel;
            if (ww.mb(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.mb.ox oxVarHj = com.ss.android.downloadlib.addownload.model.u.mb().hj(this.nk);
                if (oxVarHj != null && oxVarHj.je() != 3) {
                    oxVarHj.h(3L);
                    com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVarHj);
                }
            }
        }
        return this;
    }

    public void b(boolean z2) {
        if (z2) {
            AdEventHandler.mb().mb(this.nk, 1);
        }
        o();
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public void ww() {
        com.ss.android.downloadlib.addownload.model.u.mb().u(this.nk);
    }

    public void ox(boolean z2) {
        h(z2);
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
    public h ox(DownloadController downloadController) {
        JSONObject extra;
        this.f17987io = downloadController;
        if (com.ss.android.downloadlib.utils.hj.ox(this.f17990o).optInt("force_auto_open") == 1) {
            nk().setLinkMode(1);
        }
        if (DownloadSetting.obtainGlobal().optBugFix("fix_show_dialog") && (extra = this.f17990o.getExtra()) != null && extra.optInt("subprocess") > 0) {
            nk().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.model.u.mb().mb(this.nk, nk());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
    public h ox(DownloadEventConfig downloadEventConfig) {
        this.lc = downloadEventConfig;
        this.f17988l = je().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.model.u.mb().mb(this.nk, je());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public u mb(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.f17985e = null;
        } else {
            this.f17985e = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public void mb() {
        this.jb = true;
        com.ss.android.downloadlib.addownload.model.u.mb().mb(this.nk, je());
        com.ss.android.downloadlib.addownload.model.u.mb().mb(this.nk, nk());
        this.b.mb(this.nk);
        io();
        if (x.lz().optInt("enable_empty_listener", 1) == 1 && this.f17991u.get(Integer.MIN_VALUE) == null) {
            ox(Integer.MIN_VALUE, new com.ss.android.download.api.config.mb());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public boolean mb(int i2) {
        if (i2 == 0) {
            this.f17991u.clear();
        } else {
            this.f17991u.remove(Integer.valueOf(i2));
        }
        if (this.f17991u.isEmpty()) {
            this.jb = false;
            this.je = System.currentTimeMillis();
            if (this.ww != null) {
                Downloader.getInstance(x.getContext()).removeTaskMainListener(this.ww.getId());
            }
            b bVar = this.lz;
            if (bVar != null && bVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.lz.cancel(true);
            }
            this.b.mb(this.ww);
            String str = mb;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.ww;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.utils.x.mb(str, sb.toString(), null);
            this.ox.removeCallbacksAndMessages(null);
            this.ko = null;
            this.ww = null;
            return true;
        }
        if (this.f17991u.size() == 1 && this.f17991u.containsKey(Integer.MIN_VALUE)) {
            this.b.ox(this.ww);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public void mb(boolean z2) {
        if (this.ww != null) {
            if (z2) {
                com.ss.android.socialbase.appdownloader.b.hj hjVarOx = com.ss.android.socialbase.appdownloader.hj.x().ox();
                if (hjVarOx != null) {
                    hjVarOx.mb(this.ww);
                }
                Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(this.ww.getId(), true);
                return;
            }
            Intent intent = new Intent(x.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.ww.getId());
            x.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public u mb(long j2) {
        if (j2 != 0) {
            DownloadModel downloadModelMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(j2);
            if (downloadModelMb != null) {
                this.f17990o = downloadModelMb;
                this.nk = j2;
                this.b.mb(this.nk);
            }
        } else {
            com.ss.android.downloadlib.exception.b.mb().mb(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.utils.je.mb
    public void mb(Message message) {
        if (message != null && this.jb && message.what == 3) {
            this.ww = (DownloadInfo) message.obj;
            this.b.mb(message, e(), this.f17991u);
        }
    }

    public void mb(boolean z2, final boolean z3) {
        if (z2) {
            AdEventHandler.mb().mb(this.nk, 2);
        }
        if (!com.ss.android.downloadlib.utils.lz.ox("android.permission.WRITE_EXTERNAL_STORAGE") && !nk().enableNewActivity()) {
            this.f17990o.setFilePath(this.b.ox());
        }
        if (com.ss.android.downloadlib.utils.hj.b(this.f17990o) == 0) {
            com.ss.android.downloadlib.utils.x.mb(mb, "pBCD not start", null);
            this.b.mb(new gm() { // from class: com.ss.android.downloadlib.addownload.h.4
                @Override // com.ss.android.download.api.config.gm
                public void mb() {
                    com.ss.android.downloadlib.utils.x.mb(h.mb, "pBCD start download", null);
                    h.this.ko(z3);
                }

                @Override // com.ss.android.download.api.config.gm
                public void mb(String str) {
                    com.ss.android.downloadlib.utils.x.mb(h.mb, "pBCD onDenied", null);
                }
            });
        } else {
            ko(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mb(int i2, int i3, @NonNull DownloadInfo downloadInfo) {
        if (DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            if (i3 != -3 && !DownloadProcessDispatcher.getInstance().canResume(i2)) {
                mb(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), i2, i3);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), i2, i3);
    }

    private void mb(DownloadInfo downloadInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = downloadInfo;
        this.ox.sendMessage(messageObtain);
    }

    @Override // com.ss.android.downloadlib.addownload.u
    public u mb(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.gm = null;
        } else {
            this.gm = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
