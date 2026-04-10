package com.xuexiang.xupdate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LruCache;
import com.xuexiang.xupdate.entity.DownloadEntity;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.entity.UpdateError;
import com.xuexiang.xupdate.listener.OnInstallListener;
import com.xuexiang.xupdate.listener.OnUpdateFailureListener;
import com.xuexiang.xupdate.listener.impl.DefaultInstallListener;
import com.xuexiang.xupdate.listener.impl.DefaultUpdateFailureListener;
import com.xuexiang.xupdate.logs.UpdateLog;
import com.xuexiang.xupdate.proxy.IUpdateChecker;
import com.xuexiang.xupdate.proxy.IUpdateDownloader;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;
import com.xuexiang.xupdate.proxy.IUpdateParser;
import com.xuexiang.xupdate.proxy.IUpdatePrompter;
import com.xuexiang.xupdate.proxy.impl.DefaultFileEncryptor;
import com.xuexiang.xupdate.service.DownloadService;
import com.xuexiang.xupdate.utils.UpdateUtils;
import java.io.File;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class _XUpdate {
    private static final long CHECK_TIMEOUT = 10000;
    private static final Map<String, Boolean> sCheckMap = new ConcurrentHashMap();
    private static final Map<String, Boolean> sPrompterMap = new ConcurrentHashMap();
    private static final Map<String, Runnable> sWaitRunnableMap = new ConcurrentHashMap();
    private static final LruCache<String, Drawable> sTopDrawableCache = new LruCache<>(4);
    private static final Handler sMainHandler = new Handler(Looper.getMainLooper());

    public static boolean isAppUpdating(String str) {
        return DownloadService.isRunning() || getCheckUrlStatus(str) || isPrompterShow(str);
    }

    public static void setCheckUrlStatus(final String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sCheckMap.put(str, Boolean.valueOf(z));
        Map<String, Runnable> map = sWaitRunnableMap;
        Runnable runnable = map.get(str);
        if (runnable != null) {
            sMainHandler.removeCallbacks(runnable);
            map.remove(str);
        }
        if (z) {
            Runnable runnable2 = new Runnable() { // from class: com.xuexiang.xupdate._XUpdate.1
                @Override // java.lang.Runnable
                public void run() {
                    _XUpdate.sWaitRunnableMap.remove(str);
                    _XUpdate.sCheckMap.put(str, false);
                }
            };
            sMainHandler.postDelayed(runnable2, 10000L);
            map.put(str, runnable2);
        }
    }

    public static boolean getCheckUrlStatus(String str) {
        Boolean bool = sCheckMap.get(str);
        return bool != null && bool.booleanValue();
    }

    public static void setIsPrompterShow(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sPrompterMap.put(str, Boolean.valueOf(z));
    }

    public static boolean isPrompterShow(String str) {
        Boolean bool = sPrompterMap.get(str);
        return bool != null && bool.booleanValue();
    }

    public static String saveTopDrawable(Drawable drawable) {
        String string = UUID.randomUUID().toString();
        sTopDrawableCache.put(string, drawable);
        return string;
    }

    public static Drawable getTopDrawable(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return sTopDrawableCache.get(str);
    }

    public static Map<String, Object> getParams() {
        return XUpdate.get().mParams;
    }

    public static IUpdateHttpService getIUpdateHttpService() {
        return XUpdate.get().mUpdateHttpService;
    }

    public static IUpdateChecker getIUpdateChecker() {
        return XUpdate.get().mUpdateChecker;
    }

    public static IUpdateParser getIUpdateParser() {
        return XUpdate.get().mUpdateParser;
    }

    public static IUpdatePrompter getIUpdatePrompter() {
        return XUpdate.get().mUpdatePrompter;
    }

    public static IUpdateDownloader getIUpdateDownLoader() {
        return XUpdate.get().mUpdateDownloader;
    }

    public static boolean isGet() {
        return XUpdate.get().mIsGet;
    }

    public static boolean isWifiOnly() {
        return XUpdate.get().mIsWifiOnly;
    }

    public static boolean isAutoMode() {
        return XUpdate.get().mIsAutoMode;
    }

    public static String getApkCacheDir() {
        return XUpdate.get().mApkCacheDir;
    }

    public static String encryptFile(File file) {
        if (XUpdate.get().mFileEncryptor == null) {
            XUpdate.get().mFileEncryptor = new DefaultFileEncryptor();
        }
        return XUpdate.get().mFileEncryptor.encryptFile(file);
    }

    public static boolean isFileValid(String str, File file) {
        if (XUpdate.get().mFileEncryptor == null) {
            XUpdate.get().mFileEncryptor = new DefaultFileEncryptor();
        }
        return XUpdate.get().mFileEncryptor.isFileValid(str, file);
    }

    public static OnInstallListener getOnInstallListener() {
        return XUpdate.get().mOnInstallListener;
    }

    public static void startInstallApk(Context context, File file) {
        startInstallApk(context, file, new DownloadEntity());
    }

    public static void startInstallApk(Context context, UpdateEntity updateEntity) {
        startInstallApk(context, UpdateUtils.getApkFileByUpdateEntity(updateEntity), updateEntity.getDownLoadEntity());
    }

    public static void startInstallApk(Context context, File file, DownloadEntity downloadEntity) {
        UpdateLog.d("开始安装apk文件, 文件路径:" + file.getAbsolutePath() + ", 下载信息:" + downloadEntity);
        if (onInstallApk(context, file, downloadEntity)) {
            onApkInstallSuccess();
        } else {
            onUpdateError(5000);
        }
    }

    private static boolean onInstallApk(Context context, File file, DownloadEntity downloadEntity) {
        if (XUpdate.get().mOnInstallListener == null) {
            XUpdate.get().mOnInstallListener = new DefaultInstallListener();
        }
        return XUpdate.get().mOnInstallListener.onInstallApk(context, file, downloadEntity);
    }

    private static void onApkInstallSuccess() {
        if (XUpdate.get().mOnInstallListener == null) {
            XUpdate.get().mOnInstallListener = new DefaultInstallListener();
        }
        XUpdate.get().mOnInstallListener.onInstallApkSuccess();
    }

    public static OnUpdateFailureListener getOnUpdateFailureListener() {
        return XUpdate.get().mOnUpdateFailureListener;
    }

    public static void onUpdateError(int i) {
        onUpdateError(new UpdateError(i));
    }

    public static void onUpdateError(int i, String str) {
        onUpdateError(new UpdateError(i, str));
    }

    public static void onUpdateError(UpdateError updateError) {
        if (XUpdate.get().mOnUpdateFailureListener == null) {
            XUpdate.get().mOnUpdateFailureListener = new DefaultUpdateFailureListener();
        }
        XUpdate.get().mOnUpdateFailureListener.onFailure(updateError);
    }
}
