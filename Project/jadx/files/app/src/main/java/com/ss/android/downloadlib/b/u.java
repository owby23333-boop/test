package com.ss.android.downloadlib.b;

import android.content.Context;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class u implements com.ss.android.socialbase.appdownloader.b.hj {
    private Context mb;

    public u(Context context) {
        this.mb = context.getApplicationContext();
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public void mb(Context context, String str) {
        com.ss.android.downloadlib.mb.mb().mb(str);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public void mb(int i2, int i3, String str, int i4, long j2) {
        DownloadInfo downloadInfo;
        com.ss.android.downloadad.api.mb.ox oxVarMb;
        Context context = this.mb;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() == 0 || (oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo)) == null) {
            return;
        }
        if (i3 == 1) {
            com.ss.android.downloadlib.mb.mb(downloadInfo, oxVarMb);
            if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
                com.ss.android.downloadlib.addownload.mb.mb().mb(downloadInfo, oxVarMb.ox(), oxVarMb.je(), oxVarMb.h(), downloadInfo.getTitle(), oxVarMb.hj(), downloadInfo.getTargetFilePath());
                return;
            }
            return;
        }
        if (i3 == 3) {
            AdEventHandler.mb().mb(EventConstants.Tag.NOTIFICATION, EventConstants.Label.NOTIFICATION_INSTALL, com.ss.android.downloadlib.mb.ox(new JSONObject(), downloadInfo), oxVarMb);
            return;
        }
        if (i3 == 5) {
            AdEventHandler.mb().mb(EventConstants.Tag.NOTIFICATION, EventConstants.Label.NOTIFICATION_PAUSE, oxVarMb);
        } else if (i3 == 6) {
            AdEventHandler.mb().mb(EventConstants.Tag.NOTIFICATION, EventConstants.Label.NOTIFICATION_CONTINUE, oxVarMb);
        } else {
            if (i3 != 7) {
                return;
            }
            AdEventHandler.mb().mb(EventConstants.Tag.NOTIFICATION, EventConstants.Label.NOTIFICATION_CLICK, oxVarMb);
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public boolean mb(int i2, boolean z2) {
        if (x.o() != null) {
            return x.o().mb(z2);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public void mb(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadlib.ko.mb().mb(downloadInfo);
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt("report_download_cancel", 1) == 1) {
            AdEventHandler.mb().mb(downloadInfo, new BaseException(1012, ""));
        } else {
            AdEventHandler.mb().ox(downloadInfo, new BaseException(1012, ""));
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public void mb(int i2, int i3, String str, String str2, String str3) {
        DownloadInfo downloadInfo;
        Context context = this.mb;
        if (context == null || (downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2)) == null || downloadInfo.getStatus() != -3) {
            return;
        }
        downloadInfo.setPackageName(str2);
        com.ss.android.downloadlib.addownload.ox.mb().mb(this.mb, downloadInfo);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.hj
    public boolean mb() {
        return com.ss.android.downloadlib.addownload.ox.mb().ox();
    }
}
