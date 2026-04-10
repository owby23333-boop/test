package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadAlertDialogInfo;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.exception.ox;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ox implements com.ss.android.downloadad.api.ox {
    private static String mb = "ox";
    private static volatile ox ox;
    private ww b = ww.mb(x.getContext());

    private ox() {
    }

    public static DownloadEventConfig b() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(EventConstants.Tag.LANDING_H5_DOWNLOAD_AD_BUTTON).setClickItemTag(EventConstants.Tag.LANDING_H5_DOWNLOAD_AD_BUTTON).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setClickOpenLabel("click_open_detail").setStorageDenyLabel("storage_deny_detail").setDownloadScene(1).setIsEnableClickEvent(false).setIsEnableNoChargeClickEvent(true).setIsEnableV3Event(false).build();
    }

    public Dialog ox(Context context, String str, boolean z2, final DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z3, IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (mb(downloadModel.getId())) {
            if (z3) {
                mb(downloadModel.getId(), downloadEventConfig, downloadController);
            } else {
                ox(downloadModel.getId());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return null;
        }
        this.b.mb(context, i2, downloadStatusChangeListener, downloadModel);
        final DownloadEventConfig downloadEventConfig2 = (DownloadEventConfig) jb.mb(downloadEventConfig, b());
        final DownloadController downloadController2 = (DownloadController) jb.mb(downloadController, ox());
        downloadEventConfig2.setDownloadScene(1);
        boolean z4 = (x.lz().optInt("disable_lp_dialog", 0) == 1) | z2;
        if (downloadController2.enableShowComplianceDialog() && com.ss.android.downloadlib.addownload.compliance.ox.mb().mb(downloadModel)) {
            z4 = true;
        }
        if (z4) {
            this.b.mb(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2, iDownloadButtonClickListener);
            return null;
        }
        com.ss.android.downloadlib.utils.x.mb(mb, "tryStartDownload show dialog appName:" + downloadModel.getDownloadUrl(), null);
        Dialog dialogOx = x.b().ox(new DownloadAlertDialogInfo.mb(context).mb(downloadModel.getName()).ox("确认要下载此应用吗？").b("确认").hj("取消").mb(new DownloadAlertDialogInfo.ox() { // from class: com.ss.android.downloadlib.ox.2
            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void b(DialogInterface dialogInterface) {
                AdEventHandler.mb().mb(EventConstants.Label.LP_DOWNLOAD_DIALOG_CANCEL, downloadModel, downloadEventConfig2, downloadController2);
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void mb(DialogInterface dialogInterface) {
                ox.this.b.mb(downloadModel.getDownloadUrl(), downloadModel.getId(), 2, downloadEventConfig2, downloadController2);
                AdEventHandler.mb().mb(EventConstants.Label.LP_DOWNLOAD_DIALOG_CONFIRM, downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.download.api.model.DownloadAlertDialogInfo.ox
            public void ox(DialogInterface dialogInterface) {
                AdEventHandler.mb().mb(EventConstants.Label.LP_DOWNLOAD_DIALOG_CANCEL, downloadModel, downloadEventConfig2, downloadController2);
                dialogInterface.dismiss();
            }
        }).mb(0).mb());
        AdEventHandler.mb().mb(EventConstants.Label.LP_DOWNLOAD_DIALOG_SHOW, downloadModel, downloadEventConfig2, downloadController2);
        return dialogOx;
    }

    public static ox mb() {
        if (ox == null) {
            synchronized (ox.class) {
                if (ox == null) {
                    ox = new ox();
                }
            }
        }
        return ox;
    }

    @Override // com.ss.android.downloadad.api.ox
    public Dialog mb(Context context, String str, boolean z2, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        return mb(context, str, z2, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, false);
    }

    @Override // com.ss.android.downloadad.api.ox
    public Dialog mb(Context context, String str, boolean z2, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return mb(context, str, z2, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, false, iDownloadButtonClickListener);
    }

    public Dialog mb(Context context, String str, boolean z2, @NonNull DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, boolean z3) {
        return mb(context, str, z2, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, z3, null);
    }

    public Dialog mb(final Context context, final String str, final boolean z2, @NonNull final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final DownloadStatusChangeListener downloadStatusChangeListener, final int i2, final boolean z3, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return (Dialog) com.ss.android.downloadlib.exception.ox.mb(new ox.mb<Dialog>() { // from class: com.ss.android.downloadlib.ox.1
            @Override // com.ss.android.downloadlib.exception.ox.mb
            /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
            public Dialog ox() {
                return ox.this.ox(context, str, z2, downloadModel, downloadEventConfig, downloadController, downloadStatusChangeListener, i2, z3, iDownloadButtonClickListener);
            }
        });
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(Context context, long j2, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i2) {
        com.ss.android.downloadad.api.mb.ox oxVarHj = com.ss.android.downloadlib.addownload.model.u.mb().hj(j2);
        if (oxVarHj != null) {
            this.b.mb(context, i2, downloadStatusChangeListener, oxVarHj.he());
            return true;
        }
        DownloadModel downloadModelMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(j2);
        if (downloadModelMb == null) {
            return false;
        }
        this.b.mb(context, i2, downloadStatusChangeListener, downloadModelMb);
        return true;
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(long j2, int i2) {
        DownloadModel downloadModelMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(j2);
        if (downloadModelMb == null) {
            return false;
        }
        this.b.mb(downloadModelMb.getDownloadUrl(), i2);
        return true;
    }

    public void mb(long j2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        DownloadModel downloadModelMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(j2);
        com.ss.android.downloadad.api.mb.ox oxVarHj = com.ss.android.downloadlib.addownload.model.u.mb().hj(j2);
        if (downloadModelMb == null && oxVarHj != null) {
            downloadModelMb = oxVarHj.he();
        }
        if (downloadModelMb == null) {
            return;
        }
        if (downloadEventConfig != null && downloadController != null && !(downloadEventConfig instanceof com.ss.android.download.api.download.b) && !(downloadController instanceof com.ss.android.download.api.download.ox)) {
            downloadEventConfig.setDownloadScene(1);
            this.b.mb(downloadModelMb.getDownloadUrl(), j2, 2, downloadEventConfig, downloadController);
        } else {
            ox(j2);
        }
    }

    public void ox(long j2) {
        DownloadModel downloadModelMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(j2);
        com.ss.android.downloadad.api.mb.ox oxVarHj = com.ss.android.downloadlib.addownload.model.u.mb().hj(j2);
        if (downloadModelMb == null && oxVarHj != null) {
            downloadModelMb = oxVarHj.he();
        }
        if (downloadModelMb == null) {
            return;
        }
        DownloadEventConfig downloadEventConfigOx = com.ss.android.downloadlib.addownload.model.u.mb().ox(j2);
        DownloadController downloadControllerB = com.ss.android.downloadlib.addownload.model.u.mb().b(j2);
        if (downloadEventConfigOx instanceof com.ss.android.download.api.download.b) {
            downloadEventConfigOx = null;
        }
        if (downloadControllerB instanceof com.ss.android.download.api.download.ox) {
            downloadControllerB = null;
        }
        if (oxVarHj == null) {
            if (downloadEventConfigOx == null) {
                downloadEventConfigOx = b();
            }
            if (downloadControllerB == null) {
                downloadControllerB = ox();
            }
        } else {
            if (downloadEventConfigOx == null) {
                downloadEventConfigOx = new AdDownloadEventConfig.Builder().setClickButtonTag(oxVarHj.x()).setRefer(oxVarHj.lz()).setIsEnableV3Event(oxVarHj.nk()).setIsEnableClickEvent(false).setClickStartLabel("click_start_detail").setClickPauseLabel("click_pause_detail").setClickContinueLabel("click_continue_detail").setClickInstallLabel("click_install_detail").setStorageDenyLabel("storage_deny_detail").build();
            }
            if (downloadControllerB == null) {
                downloadControllerB = oxVarHj.jm();
            }
        }
        DownloadEventConfig downloadEventConfig = downloadEventConfigOx;
        downloadEventConfig.setDownloadScene(1);
        this.b.mb(downloadModelMb.getDownloadUrl(), j2, 2, downloadEventConfig, downloadControllerB);
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(long j2) {
        return (com.ss.android.downloadlib.addownload.model.u.mb().mb(j2) == null && com.ss.android.downloadlib.addownload.model.u.mb().hj(j2) == null) ? false : true;
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return mb(context, uri, downloadModel, downloadEventConfig, downloadController, null);
    }

    @Override // com.ss.android.downloadad.api.ox
    public boolean mb(final Context context, final Uri uri, final DownloadModel downloadModel, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ((Boolean) com.ss.android.downloadlib.exception.ox.mb(new ox.mb<Boolean>() { // from class: com.ss.android.downloadlib.ox.3
            @Override // com.ss.android.downloadlib.exception.ox.mb
            /* JADX INFO: renamed from: mb, reason: merged with bridge method [inline-methods] */
            public Boolean ox() {
                return Boolean.valueOf(ox.this.ox(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener));
            }
        })).booleanValue();
    }

    public static DownloadController mb(boolean z2) {
        AdDownloadController.Builder shouldUseNewWebView = new AdDownloadController.Builder().setLinkMode(0).setIsEnableBackDialog(true).setIsEnableMultipleDownload(false).setShouldUseNewWebView(false);
        if (z2) {
            shouldUseNewWebView.setDownloadMode(2);
        } else {
            shouldUseNewWebView.setDownloadMode(0);
        }
        return shouldUseNewWebView.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ox(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        DownloadController downloadControllerOx = downloadController;
        if (!com.ss.android.download.api.b.mb.mb(uri) || x.lz().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? x.getContext() : context;
        String strOx = com.ss.android.download.api.b.mb.ox(uri);
        if (downloadModel == null) {
            return com.ss.android.downloadlib.utils.ww.mb(context2, strOx).getType() == 5;
        }
        if (!TextUtils.isEmpty(strOx) && (downloadModel instanceof AdDownloadModel)) {
            ((AdDownloadModel) downloadModel).setPackageName(strOx);
        }
        if (downloadControllerOx != null) {
            downloadControllerOx.setDownloadMode(2);
        } else if ((downloadModel instanceof AdDownloadModel) && TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            ((AdDownloadModel) downloadModel).setDownloadUrl(uri.toString());
            downloadControllerOx = mb(true);
        } else if (downloadModel.getDownloadUrl().startsWith("market")) {
            downloadControllerOx = mb(true);
        } else {
            downloadControllerOx = ox();
        }
        com.ss.android.downloadlib.addownload.model.h hVar = new com.ss.android.downloadlib.addownload.model.h(downloadModel.getId(), downloadModel, (DownloadEventConfig) jb.mb(downloadEventConfig, b()), downloadControllerOx);
        com.ss.android.downloadlib.addownload.model.u.mb().mb(hVar.ox);
        com.ss.android.downloadlib.addownload.model.u.mb().mb(hVar.mb, hVar.b);
        com.ss.android.downloadlib.addownload.model.u.mb().mb(hVar.mb, hVar.hj);
        if (jb.mb(downloadModel) && DownloadSetting.obtainGlobal().optInt("app_link_opt") == 1 && com.ss.android.downloadlib.ox.mb.mb(hVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        jb.mb(jSONObject, EventConstants.ExtraJson.MARKET_URL, uri.toString());
        jb.mb(jSONObject, EventConstants.ExtraJson.DOWNLOAD_SCENE, (Object) 1);
        AdEventHandler.mb().ox(EventConstants.Label.MARKET_CLICK_OPEN, jSONObject, hVar);
        OpenAppResult openAppResultMb = com.ss.android.downloadlib.utils.ww.mb(context2, hVar, strOx);
        String strMb = jb.mb(openAppResultMb.ox(), EventConstants.AppLinkSource.OPEN_MARKET);
        if (openAppResultMb.getType() == 5) {
            com.ss.android.downloadlib.ox.mb.mb(strMb, jSONObject, hVar, true);
            return true;
        }
        if (openAppResultMb.getType() != 6) {
            return true;
        }
        jb.mb(jSONObject, "error_code", Integer.valueOf(openAppResultMb.mb()));
        AdEventHandler.mb().ox(EventConstants.Label.MARKET_OPEN_FAILED, jSONObject, hVar);
        if (com.ss.android.downloadlib.addownload.ww.mb(downloadModel, iDownloadButtonClickListener)) {
            iDownloadButtonClickListener.handleMarketFailedComplianceDialog();
        }
        return false;
    }

    public static DownloadController ox() {
        return mb(false);
    }
}
