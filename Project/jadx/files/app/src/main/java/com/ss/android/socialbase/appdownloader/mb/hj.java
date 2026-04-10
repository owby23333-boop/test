package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.foundation.g.a;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    public static mb mb(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        DownloadSetting downloadSettingObtain = DownloadSetting.obtain(downloadInfo);
        if (str.equals("v1")) {
            return new x(context, downloadSettingObtain, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new jb(context, downloadSettingObtain, file.getAbsolutePath());
        }
        if (str.equals(a.f10413j)) {
            return new je(context, downloadSettingObtain, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new ko(context, downloadSettingObtain, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new ww(context, downloadSettingObtain, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString(DbJsonConstants.CONTENT_URI);
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new lz(context, downloadSettingObtain, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new b(context, downloadSettingObtain, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new nk(context, downloadSettingObtain, com.ss.android.socialbase.appdownloader.b.mb(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.hj.x().hj(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean mb(Context context, String str, JSONObject jSONObject, DownloadSetting downloadSetting) {
        if (context == null || str == null) {
            return false;
        }
        mb nkVar = null;
        String strOx = com.ss.android.socialbase.appdownloader.b.ox();
        if (TextUtils.isEmpty(strOx) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.u.hj.b() && str.equals("v1")) {
            nkVar = new x(context, downloadSetting, strOx);
        } else if (com.ss.android.socialbase.appdownloader.u.hj.b() && str.equals("v2")) {
            nkVar = new jb(context, downloadSetting, strOx);
        } else if (com.ss.android.socialbase.appdownloader.u.hj.b() && str.equals(a.f10413j)) {
            nkVar = new je(context, downloadSetting, strOx);
        } else if (com.ss.android.socialbase.appdownloader.u.hj.hj() && str.equals("o1")) {
            nkVar = new ko(context, downloadSetting, strOx);
        } else if (com.ss.android.socialbase.appdownloader.u.hj.hj() && str.equals("o2")) {
            nkVar = new ww(context, downloadSetting, strOx);
        } else if (com.ss.android.socialbase.appdownloader.u.hj.hj() && str.equals("o3")) {
            nkVar = new lz(context, downloadSetting, strOx, strOx, strOx);
        } else if (com.ss.android.socialbase.appdownloader.u.hj.b() && str.equals("custom")) {
            nkVar = new b(context, downloadSetting, strOx, jSONObject);
        } else if (com.ss.android.socialbase.appdownloader.u.hj.b() && str.equals("vbi")) {
            nkVar = new nk(context, downloadSetting, strOx);
        }
        return nkVar != null && nkVar.mb();
    }
}
