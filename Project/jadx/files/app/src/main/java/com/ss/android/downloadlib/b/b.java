package com.ss.android.downloadlib.b;

import com.anythink.china.common.a.a;
import com.ss.android.download.api.config.nk;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class b implements IDownloadCompleteHandler {
    private File mb(String str, String str2) {
        File file = new File(str2);
        String name = file.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf > 0) {
            str = name.substring(0, iLastIndexOf);
        }
        return new File(file.getParent(), str + a.f6395g);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        nk nkVarX = x.x();
        if (downloadInfo == null || nkVarX == null) {
            return;
        }
        String packageName = downloadInfo.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        File fileMb = mb(packageName, targetFilePath);
        com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        nkVarX.mb(packageName, targetFilePath, fileMb, oxVarMb != null ? jb.mb(oxVarMb.ko()) : null);
        downloadInfo.setMimeType(AdBaseConstants.MIME_APK);
        downloadInfo.setName(fileMb.getName());
        downloadInfo.setMd5(null);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.download.api.b.ox.mb(DownloadSetting.obtain(downloadInfo.getId()), downloadInfo.getMimeType());
        }
        return false;
    }
}
