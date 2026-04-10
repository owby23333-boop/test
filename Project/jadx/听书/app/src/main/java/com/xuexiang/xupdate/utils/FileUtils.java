package com.xuexiang.xupdate.utils;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.umeng.analytics.pro.ar;
import com.xuexiang.xupdate.XUpdate;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class FileUtils {
    private static final String APP_EXT_STORAGE_PATH;
    private static final String EXT_DCIM_PATH;
    private static final String EXT_DOWNLOADS_PATH;
    private static final String EXT_PICTURES_PATH;
    private static final String EXT_STORAGE_DIR;
    private static final String EXT_STORAGE_PATH;
    public static final String MODE_READ_ONLY = "r";

    static {
        String extStoragePath = getExtStoragePath();
        EXT_STORAGE_PATH = extStoragePath;
        String str = extStoragePath + File.separator;
        EXT_STORAGE_DIR = str;
        APP_EXT_STORAGE_PATH = str + "Android";
        EXT_DOWNLOADS_PATH = getExtDownloadsPath();
        EXT_PICTURES_PATH = getExtPicturesPath();
        EXT_DCIM_PATH = getExtDCIMPath();
    }

    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static File getFileByPath(String str) {
        if (isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean isFileExists(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return isFileExists(file.getAbsolutePath());
    }

    public static boolean isFileExists(String str) {
        File fileByPath = getFileByPath(str);
        if (fileByPath == null) {
            return false;
        }
        if (fileByPath.exists()) {
            return true;
        }
        return isFileExistsApi29(str);
    }

    private static boolean isFileExistsApi29(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = openAssetFileDescriptor(Uri.parse(str));
                if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                    closeIOQuietly(assetFileDescriptorOpenAssetFileDescriptor);
                    closeIOQuietly(assetFileDescriptorOpenAssetFileDescriptor);
                    return true;
                }
                closeIOQuietly(assetFileDescriptorOpenAssetFileDescriptor);
                return false;
            } catch (FileNotFoundException unused) {
                closeIOQuietly(null);
            } catch (Throwable th) {
                closeIOQuietly(null);
                throw th;
            }
        }
        return false;
    }

    public static InputStream getFileInputStream(File file) throws FileNotFoundException {
        if (isScopedStorageMode()) {
            return getContentResolver().openInputStream(getUriByFile(file));
        }
        return new FileInputStream(file);
    }

    public static Uri getUriByFile(File file) {
        if (file == null) {
            return null;
        }
        if (isScopedStorageMode() && isPublicPath(file)) {
            String absolutePath = file.getAbsolutePath();
            if (absolutePath.startsWith(EXT_DOWNLOADS_PATH)) {
                return getDownloadContentUri(XUpdate.getContext(), file);
            }
            if (absolutePath.startsWith(EXT_PICTURES_PATH) || absolutePath.startsWith(EXT_DCIM_PATH)) {
                return getMediaContentUri(XUpdate.getContext(), file);
            }
            return getUriForFile(file);
        }
        return getUriForFile(file);
    }

    public static Uri getUriForFile(File file) {
        if (file == null) {
            return null;
        }
        return FileProvider.getUriForFile(XUpdate.getContext(), XUpdate.getContext().getPackageName() + ".updateFileProvider", file);
    }

    public static boolean isScopedStorageMode() {
        return Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy();
    }

    public static Uri getMediaContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{ar.d}, "_data=? ", new String[]{absolutePath}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex(ar.d));
            cursorQuery.close();
            return Uri.withAppendedPath(uri, "" + i);
        }
        if (!file.exists()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(uri, contentValues);
    }

    public static Uri getDownloadContentUri(Context context, File file) {
        String absolutePath = file.getAbsolutePath();
        Uri uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{ar.d}, "_data=? ", new String[]{absolutePath}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex(ar.d));
            cursorQuery.close();
            return Uri.withAppendedPath(uri, "" + i);
        }
        if (!file.exists()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", absolutePath);
        return context.getContentResolver().insert(uri, contentValues);
    }

    public static boolean isPrivatePath(Context context, String str) {
        if (isSpace(str)) {
            return false;
        }
        String appIntPath = getAppIntPath(context);
        String appExtPath = getAppExtPath(context);
        return (!TextUtils.isEmpty(appIntPath) && str.startsWith(appIntPath)) || (!TextUtils.isEmpty(appExtPath) && str.startsWith(appExtPath));
    }

    public static boolean isPublicPath(File file) {
        if (file == null) {
            return false;
        }
        try {
            return isPublicPath(file.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isPublicPath(String str) {
        return (isSpace(str) || !str.startsWith(EXT_STORAGE_PATH) || str.startsWith(APP_EXT_STORAGE_PATH)) ? false : true;
    }

    private static boolean isSpace(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void closeIOQuietly(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    public static AssetFileDescriptor openAssetFileDescriptor(Uri uri) throws FileNotFoundException {
        return getContentResolver().openAssetFileDescriptor(uri, "r");
    }

    private static ContentResolver getContentResolver() {
        return XUpdate.getContext().getContentResolver();
    }

    public static String getExtStoragePath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public static String getExtDownloadsPath() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    }

    public static String getExtPicturesPath() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
    }

    public static String getExtDCIMPath() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    }

    public static String getAppIntPath(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return getDirName(cacheDir.getAbsolutePath());
        }
        return null;
    }

    public static String getAppExtPath(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return getDirName(externalCacheDir.getAbsolutePath());
        }
        return null;
    }

    public static String getDirName(String str) {
        if (isSpace(str)) {
            return str;
        }
        int iLastIndexOf = str.lastIndexOf(File.separator);
        return iLastIndexOf == -1 ? "" : str.substring(0, iLastIndexOf + 1);
    }
}
