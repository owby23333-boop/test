package com.ss.android.downloadlib.dl;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.socialbase.downloader.a.v;
import com.umeng.analytics.pro.ar;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public class z implements v {
    @Override // com.ss.android.socialbase.downloader.a.v
    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) throws com.ss.android.socialbase.downloader.gc.z {
        if (dlVar == null || !dl(dlVar)) {
            return;
        }
        z(wp.getContext(), dlVar);
    }

    @Override // com.ss.android.socialbase.downloader.a.v
    public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar != null) {
            return com.ss.android.downloadlib.e.gc.g(com.ss.android.socialbase.downloader.i.z.z(dlVar.e()));
        }
        return false;
    }

    private boolean dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
        String str = dlVar.kb() + File.separator + dlVar.gz();
        File file = new File(str);
        String strZ = com.ss.android.socialbase.appdownloader.m.z.gc.z(wp.getContext(), com.ss.android.socialbase.appdownloader.dl.z(dlVar, file), str);
        boolean zRenameTo = false;
        if (!TextUtils.isEmpty(strZ)) {
            String str2 = strZ + ".apk";
            if (str2.equals(dlVar.gz())) {
                return true;
            }
            try {
                zRenameTo = file.renameTo(new File(dlVar.kb() + File.separator + str2));
                if (zRenameTo) {
                    dlVar.m(str2);
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
        return zRenameTo;
    }

    private void z(Context context, final com.ss.android.socialbase.downloader.e.dl dlVar) {
        String str = dlVar.kb() + File.separator + dlVar.gz();
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Files.getContentUri("external"), new String[]{ar.d}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            dlVar.z("file_content_uri", (Object) ContentUris.withAppendedId(MediaStore.Files.getContentUri("external"), cursorQuery.getInt(cursorQuery.getColumnIndex(ar.d))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.dl.z.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        dlVar.z("file_content_uri", (Object) uri.toString());
                        com.ss.android.socialbase.downloader.downloader.dl.io().z(dlVar);
                    }
                }
            });
        }
        com.ss.android.socialbase.downloader.pf.m.z(cursorQuery);
    }
}
