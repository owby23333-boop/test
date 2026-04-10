package cn.bmob.v3.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class InstallUtil {
    private static boolean hasSDCard = Environment.getExternalStorageState().equals("mounted");
    private static String sAuthorities;

    public static String getAppDir() {
        if (hasSDCard) {
            return mkdirs(Environment.getExternalStorageDirectory() + "/Download/bmob");
        }
        return mkdirs(Environment.getDownloadCacheDirectory() + "/Download/bmob");
    }

    private static String mkdirs(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static void setAuthorities(String str) {
        sAuthorities = str;
    }

    public static Intent startInstall(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            if (TextUtils.isEmpty(sAuthorities)) {
                sAuthorities = context.getPackageName();
            }
            Uri uriForFile = FileProvider.getUriForFile(context, sAuthorities, file);
            intent.addFlags(1);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
        } else {
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
        }
        context.startActivity(intent);
        return intent;
    }
}
