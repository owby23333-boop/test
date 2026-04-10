package com.open.hule.library;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.open.hule.library.c.c;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadReceiver extends BroadcastReceiver {
    private void a(Context context, long j2) {
        Cursor cursorQuery;
        String path;
        if (j2 == -1) {
            return;
        }
        try {
            DownloadManager downloadManager = (DownloadManager) context.getSystemService("download");
            DownloadManager.Query query = new DownloadManager.Query();
            if (downloadManager == null || (cursorQuery = downloadManager.query(query.setFilterById(j2))) == null || !cursorQuery.moveToFirst()) {
                return;
            }
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("local_uri"));
            if (!TextUtils.isEmpty(string) && (path = Uri.parse(string).getPath()) != null && !TextUtils.isEmpty(path)) {
                File file = new File(path);
                Intent intent = new Intent("android.intent.action.VIEW");
                if (Build.VERSION.SDK_INT < 24) {
                    intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
                } else {
                    Uri uriForFile = FileProvider.getUriForFile(context.getApplicationContext(), context.getPackageName() + ".fileProvider", file);
                    intent.addFlags(1);
                    intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
                }
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                context.startActivity(intent);
            }
            cursorQuery.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || !c.f17657h) {
            return;
        }
        if (((String) Objects.requireNonNull(intent.getAction())).equals("android.intent.action.DOWNLOAD_COMPLETE")) {
            a(context, intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, -1L));
        } else if (intent.getAction().equals("android.intent.action.DOWNLOAD_NOTIFICATION_CLICKED")) {
            Intent intent2 = new Intent("android.intent.action.VIEW_DOWNLOADS");
            intent2.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent2);
        }
    }
}
