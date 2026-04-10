package e0;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DownloadUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static volatile String a;
    public static volatile String b;

    public static String a(Context context) {
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 28) {
                return context.getExternalFilesDir(null).getPath() + "/bddownload/";
            }
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return context.getFilesDir().getPath() + "/bddownload/";
            }
            if (i2 >= 19) {
                return context.getExternalFilesDir(null).getPath() + "/bddownload/";
            }
            return context.getFilesDir().getPath() + "/bddownload/";
        } catch (Exception unused) {
            return null;
        }
    }

    public static String b(Context context) {
        File externalFilesDir;
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String path = null;
        if (context.getSharedPreferences("tt_sdk_settings", 0).getInt("download_config_storage_internal", 1) == 1) {
            try {
                if (!e(context)) {
                    File file = new File(context.getCacheDir(), Environment.DIRECTORY_DOWNLOADS);
                    file.mkdirs();
                    path = file.getPath();
                    if (!TextUtils.isEmpty(path)) {
                        try {
                            Runtime.getRuntime().exec("chmod 777 " + path);
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        if (TextUtils.isEmpty(path)) {
            if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)) != null) {
                path = externalFilesDir.getPath();
            }
            if (TextUtils.isEmpty(path)) {
                File file2 = new File(context.getFilesDir(), Environment.DIRECTORY_DOWNLOADS);
                file2.mkdirs();
                path = file2.getPath();
            }
        }
        if (!TextUtils.isEmpty(path)) {
            a = path;
        }
        return a;
    }

    public static String c(Context context) {
        File externalFilesDir;
        if ("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            try {
                externalFilesDir = context.getExternalFilesDir(null);
            } catch (Exception unused) {
                externalFilesDir = null;
            }
            if (externalFilesDir != null) {
                String path = externalFilesDir.getPath();
                if (TextUtils.isEmpty(path)) {
                    path = context.getFilesDir().getPath();
                }
                StringBuilder sbA = y.b.a(path);
                String str = File.separator;
                sbA.append(str);
                sbA.append("ksadsdk");
                sbA.append(str);
                sbA.append("Download");
                return sbA.toString();
            }
        }
        return null;
    }

    public static String d(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        String string = context.getSharedPreferences("tt_sdk_settings", 0).getString("download_sdk_config", null);
        if (string != null) {
            try {
                b = Environment.getExternalStorageDirectory().getPath() + File.separator + new JSONObject(string).optString("default_save_dir_name", BaseConstants.DOWNLOAD_DIR);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        } else {
            b = Environment.getExternalStorageDirectory().getPath() + File.separator + BaseConstants.DOWNLOAD_DIR;
        }
        return b;
    }

    public static boolean e(Context context) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
