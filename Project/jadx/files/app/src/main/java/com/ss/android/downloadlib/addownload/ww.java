package com.ss.android.downloadlib.addownload;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ww {
    public static boolean mb(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public static boolean mb(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean ox(int i2) {
        return i2 == 2 || i2 == 1;
    }

    public static boolean ox(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean mb(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int mb(@NonNull com.ss.android.downloadlib.addownload.model.h hVar, boolean z2, com.ss.android.socialbase.appdownloader.u uVar) {
        int iMb;
        if (uVar == null || TextUtils.isEmpty(uVar.mb()) || uVar.getContext() == null) {
            return 0;
        }
        try {
            iMb = mb(uVar, uVar.mb());
        } catch (Throwable th) {
            x.m().mb(th, "redirectSavePathIfPossible");
            iMb = 4;
        }
        uVar.mb(iMb);
        if (iMb == 0) {
            uVar.mb(new com.ss.android.downloadlib.b.mb());
        }
        if (!uVar.cd()) {
            uVar.mb(new com.ss.android.downloadlib.b.ox());
        }
        int iMb2 = com.ss.android.socialbase.appdownloader.hj.x().mb(uVar);
        com.ss.android.downloadad.api.mb.ox oxVarMb = mb(hVar, iMb2);
        com.ss.android.downloadlib.addownload.model.u.mb().mb(oxVarMb);
        oxVarMb.ko(iMb2);
        oxVarMb.ww(System.currentTimeMillis());
        oxVarMb.lz(0L);
        DownloadSetting downloadSettingObtain = DownloadSetting.obtain(uVar.kg());
        if (!mb(uVar, downloadSettingObtain, iMb2) && hVar.ox.isShowToast()) {
            String startToast = hVar.ox.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = downloadSettingObtain.optString("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z2 ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            x.b().mb(2, uVar.getContext(), hVar.ox, startToast, null, 0);
        }
        return iMb2;
    }

    private static com.ss.android.downloadad.api.mb.ox mb(com.ss.android.downloadlib.addownload.model.h hVar, int i2) {
        com.ss.android.downloadad.api.mb.ox oxVar = new com.ss.android.downloadad.api.mb.ox(hVar.ox, hVar.b, hVar.hj, i2);
        boolean z2 = true;
        if (DownloadSetting.obtain(i2).optInt("download_event_opt", 1) > 1) {
            try {
                String packageName = hVar.ox.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (x.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z2 = false;
                    }
                    oxVar.ww(z2);
                }
            } catch (Throwable unused) {
            }
        }
        return oxVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean mb(com.ss.android.socialbase.appdownloader.u r11, @androidx.annotation.NonNull com.ss.android.socialbase.downloader.setting.DownloadSetting r12, int r13) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.ww.mb(com.ss.android.socialbase.appdownloader.u, com.ss.android.socialbase.downloader.setting.DownloadSetting, int):boolean");
    }

    public static String mb(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static int mb(com.ss.android.socialbase.appdownloader.u uVar, String str) {
        DownloadSetting downloadSettingObtain = DownloadSetting.obtain(uVar.kg());
        JSONObject jSONObjectOptJSONObject = downloadSettingObtain.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (jSONObjectOptJSONObject == null || TextUtils.isEmpty(jSONObjectOptJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME))) {
            return -1;
        }
        String strOx = uVar.ox();
        String strAl = uVar.al();
        if (TextUtils.isEmpty(strAl)) {
            strAl = com.ss.android.socialbase.appdownloader.b.mb(str, strOx, uVar.je(), true);
        }
        if (strAl.length() > 255) {
            strAl = strAl.substring(strAl.length() - 255);
        }
        if (TextUtils.isEmpty(strOx)) {
            strOx = strAl;
        }
        String strB = uVar.b();
        if (TextUtils.isEmpty(strB)) {
            strB = com.ss.android.socialbase.appdownloader.b.ox();
        }
        String str2 = strB + File.separator + com.ss.android.socialbase.appdownloader.b.mb(strOx, downloadSettingObtain);
        DownloadInfo downloadInfoMb = com.ss.android.socialbase.appdownloader.hj.x().mb(uVar.getContext(), str);
        if (downloadInfoMb != null && downloadInfoMb.isSavePathRedirected()) {
            uVar.b(downloadInfoMb.getSavePath());
            try {
                uVar.mb(new JSONObject(downloadInfoMb.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (downloadInfoMb != null || !AdBaseConstants.MIME_APK.equalsIgnoreCase(com.ss.android.socialbase.appdownloader.hj.x().mb(strAl, uVar.je()))) {
            return downloadInfoMb != null ? 8 : 9;
        }
        int iMb = com.ss.android.socialbase.appdownloader.ox.mb(downloadSettingObtain);
        if (iMb != 0) {
            return iMb;
        }
        uVar.b(str2);
        return iMb;
    }
}
