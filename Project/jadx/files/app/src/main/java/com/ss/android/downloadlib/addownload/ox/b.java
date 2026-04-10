package com.ss.android.downloadlib.addownload.ox;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bj;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static void mb() throws Throwable {
        List<DownloadInfo> listMb = com.ss.android.socialbase.appdownloader.hj.x().mb(x.getContext());
        if (listMb == null || listMb.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < listMb.size(); i2++) {
            DownloadInfo downloadInfo = listMb.get(i2);
            File file = new File(downloadInfo.getTempPath(), downloadInfo.getTempName());
            long jLastModified = file.lastModified();
            long jOptInt = ((long) DownloadSetting.obtain(downloadInfo.getId()).optInt("download_file_expire_hours", 0)) * 3600000;
            if (jOptInt <= 0) {
                jOptInt = bj.f12906d;
            }
            if (file.isFile() && file.exists() && System.currentTimeMillis() - jLastModified >= jOptInt) {
                mb(file);
                Downloader.getInstance(x.getContext()).clearDownloadData(downloadInfo.getId());
            }
        }
    }

    public static void ox() throws Throwable {
        List successedDownloadInfosWithMimeType = Downloader.getInstance(x.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK);
        if (successedDownloadInfosWithMimeType == null || successedDownloadInfosWithMimeType.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < successedDownloadInfosWithMimeType.size(); i2++) {
            DownloadInfo downloadInfo = (DownloadInfo) successedDownloadInfosWithMimeType.get(i2);
            if (downloadInfo != null) {
                String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
                File file = new File(str);
                if (file.exists()) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - file.lastModified();
                    long jOptInt = ((long) DownloadSetting.obtain(downloadInfo.getId()).optInt("download_complete_file_expire_hours", 0)) * 3600000;
                    if (jOptInt <= 0) {
                        jOptInt = bj.f12906d;
                    }
                    boolean z2 = true;
                    if (jCurrentTimeMillis < jOptInt && !jb.h(x.getContext(), str)) {
                        z2 = false;
                    }
                    if (z2) {
                        mb(file);
                    }
                }
            }
        }
    }

    public static void mb(Context context) {
        File externalCacheDir;
        if (context == null || (externalCacheDir = context.getExternalCacheDir()) == null) {
            return;
        }
        try {
            mb(externalCacheDir.getPath());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0030 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void mb(java.io.File r3) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L18
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L18
            java.lang.String r0 = "1"
            byte[] r0 = r0.getBytes()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2d
            r1.write(r0)     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2d
            r1.close()     // Catch: java.lang.Exception -> L13 java.lang.Throwable -> L2d
            goto L29
        L13:
            r0 = move-exception
            goto L1c
        L15:
            r3 = move-exception
            r1 = r0
            goto L2e
        L18:
            r1 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L1c:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L29
            r1.close()     // Catch: java.lang.Exception -> L25
            goto L29
        L25:
            r0 = move-exception
            r0.printStackTrace()
        L29:
            r3.delete()
            return
        L2d:
            r3 = move-exception
        L2e:
            if (r1 == 0) goto L38
            r1.close()     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r0 = move-exception
            r0.printStackTrace()
        L38:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.ox.b.mb(java.io.File):void");
    }

    private static void mb(String str) {
        File file = new File(str);
        if (file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            for (String str2 : list) {
                if (str2 != null) {
                    String str3 = str.endsWith(File.separator) ? str + str2 : str + File.separator + str2;
                    File file2 = new File(str3);
                    if (file2.isFile()) {
                        file2.delete();
                    }
                    if (file2.isDirectory()) {
                        mb(str3);
                    }
                }
            }
            file.delete();
        }
    }
}
