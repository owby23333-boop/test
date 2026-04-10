package com.ss.android.downloadlib.b;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.anythink.china.common.a.a;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class mb implements IDownloadCompleteHandler {
    private boolean mb(DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        File file = new File(str);
        String strMb = com.ss.android.socialbase.appdownloader.u.mb.h.mb(x.getContext(), com.ss.android.socialbase.appdownloader.b.mb(downloadInfo, file), str);
        boolean zRenameTo = false;
        if (!TextUtils.isEmpty(strMb)) {
            String str2 = strMb + a.f6395g;
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                zRenameTo = file.renameTo(new File(downloadInfo.getSavePath() + File.separator + str2));
                if (zRenameTo) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return zRenameTo;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !mb(downloadInfo)) {
            return;
        }
        mb(x.getContext(), downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.utils.hj.ox(DownloadSetting.obtain(downloadInfo.getId()));
        }
        return false;
    }

    private void mb(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursorQuery.getInt(cursorQuery.getColumnIndex("_id"))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{AdBaseConstants.MIME_APK}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.b.mb.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, uri.toString());
                        DownloadComponentManager.getDownloadCache().updateDownloadInfo(downloadInfo);
                    }
                }
            });
        }
        DownloadUtils.safeClose(cursorQuery);
    }
}
