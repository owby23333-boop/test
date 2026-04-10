package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.je;
import com.ss.android.downloadlib.utils.lz;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ko implements je.mb {
    private boolean b = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ox f17996h;
    private h hj;
    private long mb;
    private com.ss.android.downloadlib.addownload.model.h ox;

    static class mb extends AbsDownloadExtListener {
        private com.ss.android.downloadlib.utils.je mb;

        mb(com.ss.android.downloadlib.utils.je jeVar) {
            this.mb = jeVar;
        }

        private void mb(DownloadInfo downloadInfo, int i2) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 3;
            messageObtain.obj = downloadInfo;
            messageObtain.arg1 = i2;
            this.mb.sendMessage(messageObtain);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            mb(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            mb(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            mb(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            mb(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            mb(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            mb(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            mb(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener, com.ss.android.socialbase.downloader.depend.IDownloadExtListener
        public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
            mb(downloadInfo, 11);
        }
    }

    public interface ox {
        void mb(DownloadInfo downloadInfo);
    }

    public ko(h hVar) {
        this.hj = hVar;
    }

    private boolean b() {
        return hj() && h();
    }

    private boolean h() {
        return this.ox.hj.isAddToDownloadManage();
    }

    private boolean hj() {
        DownloadModel downloadModel = this.ox.ox;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.ox.ox.getDownloadUrl())) ? false : true;
    }

    private boolean u() {
        return com.ss.android.downloadlib.utils.jb.mb(this.ox.ox) && ww.mb(this.ox.hj.getLinkMode());
    }

    @Override // com.ss.android.downloadlib.utils.je.mb
    public void mb(Message message) {
    }

    private boolean h(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.utils.jb.mb(this.ox.ox) && u(downloadInfo);
    }

    private boolean u(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && DownloadUtils.isFileExist(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    void b(DownloadInfo downloadInfo) {
        if (!ww.mb(this.ox.ox) || this.b) {
            return;
        }
        AdEventHandler.mb().mb(EventConstants.Label.FILE_STATUS, (downloadInfo == null || !com.ss.android.downloadlib.utils.jb.ox(downloadInfo.getTargetFilePath())) ? 2 : 1, this.ox);
        this.b = true;
    }

    public void mb(long j2) {
        this.mb = j2;
        this.ox = com.ss.android.downloadlib.addownload.model.u.mb().h(j2);
        if (this.ox.on()) {
            com.ss.android.downloadlib.exception.b.mb().mb("setAdId ModelBox notValid");
        }
    }

    public void ox(@Nullable DownloadInfo downloadInfo) {
        ox oxVar = this.f17996h;
        if (oxVar != null) {
            oxVar.mb(downloadInfo);
            this.f17996h = null;
        }
    }

    boolean hj(DownloadInfo downloadInfo) {
        return u() || h(downloadInfo);
    }

    private void ox(final gm gmVar) {
        if (!com.ss.android.downloadlib.utils.lz.ox("android.permission.WRITE_EXTERNAL_STORAGE")) {
            com.ss.android.downloadlib.utils.lz.mb(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, new lz.mb() { // from class: com.ss.android.downloadlib.addownload.ko.2
                @Override // com.ss.android.downloadlib.utils.lz.mb
                public void mb() {
                    gm gmVar2 = gmVar;
                    if (gmVar2 != null) {
                        gmVar2.mb();
                    }
                }

                @Override // com.ss.android.downloadlib.utils.lz.mb
                public void mb(String str) {
                    gm gmVar2 = gmVar;
                    if (gmVar2 != null) {
                        gmVar2.mb(str);
                    }
                }
            });
        } else if (gmVar != null) {
            gmVar.mb();
        }
    }

    public void mb(DownloadInfo downloadInfo) {
        this.b = false;
        ox(downloadInfo);
    }

    boolean mb(Context context, int i2, boolean z2) {
        if (com.ss.android.downloadlib.utils.jb.mb(this.ox.ox)) {
            com.ss.android.downloadad.api.mb.ox oxVarHj = com.ss.android.downloadlib.addownload.model.u.mb().hj(this.ox.mb);
            if (oxVarHj != null) {
                DownloadNotificationManager.getInstance().cancelNotification(oxVarHj.m());
            }
            return com.ss.android.downloadlib.ox.mb.mb(this.ox);
        }
        if (mb(i2) && !TextUtils.isEmpty(this.ox.ox.getPackageName()) && x.lz().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.ox.mb.mb(this.ox, i2)) {
                return true;
            }
            return this.hj.lz() && this.hj.hj(true);
        }
        if (!z2 || this.ox.hj.getDownloadMode() != 4 || this.hj.h()) {
            return false;
        }
        this.hj.b(true);
        return true;
    }

    @Nullable
    public String ox() {
        File externalFilesDir = x.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.mb> ox(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.mb) {
                    arrayList.add((com.ss.android.download.api.download.mb) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof com.ss.android.download.api.download.mb) {
                        arrayList.add((com.ss.android.download.api.download.mb) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean mb(int i2) {
        if (this.ox.hj.getDownloadMode() == 2 && i2 == 2) {
            return true;
        }
        return this.ox.hj.getDownloadMode() == 2 && i2 == 1 && x.lz().optInt("disable_lp_if_market", 0) == 1;
    }

    boolean mb(boolean z2) {
        return !z2 && this.ox.hj.getDownloadMode() == 1;
    }

    void mb(@NonNull final gm gmVar) {
        if (!TextUtils.isEmpty(this.ox.ox.getFilePath())) {
            String filePath = this.ox.ox.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                gmVar.mb();
                return;
            } else {
                try {
                    if (filePath.startsWith(x.getContext().getExternalCacheDir().getParent())) {
                        gmVar.mb();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
        }
        ox(new gm() { // from class: com.ss.android.downloadlib.addownload.ko.1
            @Override // com.ss.android.download.api.config.gm
            public void mb() {
                gmVar.mb();
            }

            @Override // com.ss.android.download.api.config.gm
            public void mb(String str) {
                x.b().mb(1, x.getContext(), ko.this.ox.ox, "您已禁止使用存储权限，请授权后再下载", null, 1);
                AdEventHandler.mb().ox(ko.this.mb, 1);
                gmVar.mb(str);
            }
        });
    }

    void mb(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        ox oxVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i2 = message.arg1;
        if (i2 != 1 && i2 != 6 && i2 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.ko koVarMb = com.ss.android.downloadlib.ko.mb();
                com.ss.android.downloadlib.addownload.model.h hVar = this.ox;
                koVarMb.mb(hVar.ox, hVar.hj, hVar.b);
                downloadInfo.setFirstDownload(false);
            }
            AdEventHandler.mb().mb(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        lz.mb(downloadShortInfo);
        int iMb = com.ss.android.socialbase.appdownloader.b.mb(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) && (oxVar = this.f17996h) != null) {
            oxVar.mb(downloadInfo);
            this.f17996h = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : mb(map)) {
            if (iMb != 1) {
                if (iMb == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, lz.mb(downloadInfo.getId(), curBytes));
                } else if (iMb == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.utils.jb.mb(this.ox.ox)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, lz.mb(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.mb> it = ox(map).iterator();
                while (it.hasNext()) {
                    it.next().mb(downloadInfo);
                }
            }
        }
    }

    void mb() {
        if (this.f17996h == null) {
            this.f17996h = new ox() { // from class: com.ss.android.downloadlib.addownload.ko.3
                @Override // com.ss.android.downloadlib.addownload.ko.ox
                public void mb(DownloadInfo downloadInfo) {
                    AdEventHandler.mb().mb(ko.this.mb, 2, downloadInfo);
                }
            };
        }
    }

    int mb(Context context, IDownloadListener iDownloadListener) {
        HttpHeader httpHeaderMb;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.ox.ox.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (x.lz().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.ox.ox.getLogExtra()) && (httpHeaderMb = mb(this.ox.ox.getLogExtra())) != null) {
            arrayList.add(httpHeaderMb);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new HttpHeader(entry.getKey(), entry.getValue()));
                }
            }
        }
        String strMb = com.ss.android.downloadlib.utils.b.mb(String.valueOf(this.ox.ox.getId()), this.ox.ox.getNotificationJumpUrl(), this.ox.ox.isShowToast(), String.valueOf(this.ox.ox.getModelType()));
        DownloadSetting downloadSettingOx = com.ss.android.downloadlib.utils.hj.ox(this.ox.ox);
        JSONObject jSONObjectMb = com.ss.android.downloadlib.utils.hj.mb(this.ox.ox);
        if (!this.ox.hj.enableAH()) {
            jSONObjectMb = com.ss.android.downloadlib.utils.jb.mb(jSONObjectMb);
            com.ss.android.downloadlib.utils.jb.mb(jSONObjectMb, DownloadSettingKeys.KEY_AH_PLANS, new JSONArray());
        }
        int executorGroup = this.ox.ox.getExecutorGroup();
        if (this.ox.ox.isAd() || ww.ox(this.ox.ox)) {
            executorGroup = 4;
        }
        String strMb2 = mb(downloadSettingOx);
        DownloadInfo downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(DownloadComponentManager.getDownloadId(this.ox.ox.getDownloadUrl(), strMb2));
        if (downloadInfo != null && 3 == this.ox.ox.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.u uVarLc = new com.ss.android.socialbase.appdownloader.u(context, this.ox.ox.getDownloadUrl()).ox(this.ox.ox.getBackupUrls()).mb(this.ox.ox.getName()).hj(strMb).mb(arrayList).mb(this.ox.ox.isShowNotification()).b(this.ox.ox.isNeedWifi()).ox(this.ox.ox.getFileName()).b(strMb2).x(this.ox.ox.getAppIcon()).ko(this.ox.ox.getMd5()).lz(this.ox.ox.getSdkMonitorScene()).mb(this.ox.ox.getExpectFileLength()).mb(iDownloadListener).je(this.ox.ox.needIndependentProcess() || downloadSettingOx.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, 0) == 1).mb(this.ox.ox.getDownloadFileUriProvider()).ox(this.ox.ox.autoInstallWithoutNotification()).u(this.ox.ox.getPackageName()).hj(1000).h(100).mb(jSONObjectMb).lz(true).x(true).ox(downloadSettingOx.optInt("retry_count", 5)).b(downloadSettingOx.optInt("backup_url_retry_count", 0)).x(true).nk(downloadSettingOx.optInt("need_head_connection", 0) == 1).hj(downloadSettingOx.optInt("need_https_to_http_retry", 0) == 1).ww(downloadSettingOx.optInt(MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, 1) == 1).ko(downloadSettingOx.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, 0) == 1).ww(downloadSettingOx.optString("retry_delay_time_array")).jb(downloadSettingOx.optInt("need_reuse_runnable", 0) == 1).u(executorGroup).io(this.ox.ox.isAutoInstall()).lc(this.ox.ox.distinctDir());
        if (!TextUtils.isEmpty(this.ox.ox.getMimeType())) {
            uVarLc.h(this.ox.ox.getMimeType());
        } else {
            uVarLc.h(AdBaseConstants.MIME_APK);
        }
        if (downloadSettingOx.optInt("notification_opt_2", 0) == 1) {
            uVarLc.mb(false);
            uVarLc.ox(true);
        }
        com.ss.android.downloadlib.addownload.ox.mb mbVar = null;
        if (downloadSettingOx.optInt("clear_space_use_disk_handler", 0) == 1) {
            mbVar = new com.ss.android.downloadlib.addownload.ox.mb();
            uVarLc.mb(mbVar);
        }
        int iMb = ww.mb(this.ox, b(), uVarLc);
        if (mbVar != null) {
            mbVar.mb(iMb);
        }
        return iMb;
    }

    private String mb(DownloadSetting downloadSetting) {
        if (!TextUtils.isEmpty(this.ox.ox.getFilePath())) {
            return this.ox.ox.getFilePath();
        }
        DownloadInfo downloadInfoMb = com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext(), this.ox.ox.getDownloadUrl());
        boolean zOx = com.ss.android.downloadlib.utils.lz.ox("android.permission.WRITE_EXTERNAL_STORAGE");
        String strOx = ox();
        if (downloadInfoMb != null && !TextUtils.isEmpty(downloadInfoMb.getSavePath())) {
            String savePath = downloadInfoMb.getSavePath();
            if (zOx || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(strOx)) {
                    if (savePath.startsWith(strOx)) {
                        return savePath;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(downloadInfoMb.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(EventConstants.ExtraJson.KEY_CODE, Integer.valueOf(zOx ? 1 : 2));
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        AdEventHandler.mb().mb(EventConstants.UnityLabel.LABEL_EXTERNAL_PERMISSION, jSONObject, this.ox);
        String strOx2 = null;
        try {
            strOx2 = com.ss.android.socialbase.appdownloader.b.ox();
        } catch (Exception unused) {
        }
        int iMb = com.ss.android.downloadlib.utils.hj.mb(downloadSetting);
        if (iMb != 0) {
            if (iMb != 4 && (zOx || iMb != 2)) {
                if ((iMb == 3 || (!zOx && iMb == 1)) && !TextUtils.isEmpty(strOx)) {
                    return strOx;
                }
            } else {
                File filesDir = x.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return strOx2;
    }

    void mb(DownloadInfo downloadInfo, boolean z2) {
        if (this.ox.ox == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status == -1 || status == -4 || ww.mb(this.ox.ox)) {
            AdEventHandler.mb().mb(this.mb, 2);
        } else if (z2 && com.ss.android.downloadlib.event.ox.mb().b() && (status == -2 || status == -3)) {
            AdEventHandler.mb().mb(this.mb, 2);
        }
        switch (status) {
            case -4:
            case -1:
                mb();
                com.ss.android.downloadlib.addownload.model.u uVarMb = com.ss.android.downloadlib.addownload.model.u.mb();
                com.ss.android.downloadlib.addownload.model.h hVar = this.ox;
                uVarMb.mb(new com.ss.android.downloadad.api.mb.ox(hVar.ox, hVar.b, hVar.hj, downloadInfo.getId()));
                break;
            case -3:
                if (com.ss.android.downloadlib.utils.jb.mb(this.ox.ox)) {
                    com.ss.android.downloadlib.exception.b.mb().ox("SUCCESSED isInstalledApp");
                    break;
                } else {
                    AdEventHandler.mb().mb(this.mb, 5, downloadInfo);
                    if (z2 && com.ss.android.downloadlib.event.ox.mb().ox() && !com.ss.android.downloadlib.event.ox.mb().ox(this.mb, this.ox.ox.getLogExtra())) {
                        AdEventHandler.mb().mb(this.mb, 2);
                        break;
                    }
                }
                break;
            case -2:
                AdEventHandler.mb().mb(this.mb, 4, downloadInfo);
                if (z2 && com.ss.android.downloadlib.event.ox.mb().ox() && !com.ss.android.downloadlib.event.ox.mb().ox(this.mb, this.ox.ox.getLogExtra())) {
                    AdEventHandler.mb().mb(this.mb, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                AdEventHandler.mb().mb(this.mb, 3, downloadInfo);
                break;
        }
    }

    void mb(DownloadInfo downloadInfo, DownloadShortInfo downloadShortInfo, List<DownloadStatusChangeListener> list) {
        if (list.isEmpty()) {
            return;
        }
        if (downloadInfo != null && downloadShortInfo != null) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            int curBytes = downloadInfo.getTotalBytes() > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / downloadInfo.getTotalBytes()) : 0;
            int i2 = curBytes >= 0 ? curBytes : 0;
            downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
            lz.mb(downloadShortInfo);
            for (DownloadStatusChangeListener downloadStatusChangeListener : list) {
                switch (downloadInfo.getStatus()) {
                    case -4:
                    case 0:
                        if (com.ss.android.downloadlib.utils.jb.mb(this.ox.ox)) {
                            downloadShortInfo.status = -3;
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onIdle();
                        }
                        break;
                    case -3:
                        if (com.ss.android.downloadlib.utils.jb.mb(this.ox.ox)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                        break;
                    case -2:
                        downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, lz.mb(downloadInfo.getId(), i2));
                        break;
                    case -1:
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                        break;
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 7:
                    case 8:
                        downloadStatusChangeListener.onDownloadActive(downloadShortInfo, lz.mb(downloadInfo.getId(), i2));
                        break;
                    case 11:
                        if (downloadStatusChangeListener instanceof com.ss.android.download.api.download.mb) {
                            ((com.ss.android.download.api.download.mb) downloadStatusChangeListener).mb(downloadInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadActive(downloadShortInfo, lz.mb(downloadInfo.getId(), i2));
                        }
                        break;
                }
            }
            return;
        }
        Iterator<DownloadStatusChangeListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
    }

    @NonNull
    public static List<DownloadStatusChangeListener> mb(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof DownloadStatusChangeListener) {
                        arrayList.add((DownloadStatusChangeListener) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    private HttpHeader mb(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new HttpHeader("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e2) {
            x.m().mb(e2, "parseLogExtra Error");
            return null;
        }
    }
}
