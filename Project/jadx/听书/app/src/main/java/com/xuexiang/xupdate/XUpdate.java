package com.xuexiang.xupdate;

import android.app.Application;
import android.content.Context;
import com.xuexiang.xupdate.UpdateManager;
import com.xuexiang.xupdate.entity.UpdateError;
import com.xuexiang.xupdate.listener.OnInstallListener;
import com.xuexiang.xupdate.listener.OnUpdateFailureListener;
import com.xuexiang.xupdate.listener.impl.DefaultInstallListener;
import com.xuexiang.xupdate.listener.impl.DefaultUpdateFailureListener;
import com.xuexiang.xupdate.logs.ILogger;
import com.xuexiang.xupdate.logs.UpdateLog;
import com.xuexiang.xupdate.proxy.IFileEncryptor;
import com.xuexiang.xupdate.proxy.IUpdateChecker;
import com.xuexiang.xupdate.proxy.IUpdateDownloader;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;
import com.xuexiang.xupdate.proxy.IUpdateParser;
import com.xuexiang.xupdate.proxy.IUpdatePrompter;
import com.xuexiang.xupdate.proxy.impl.DefaultFileEncryptor;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateChecker;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateDownloader;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdatePrompter;
import com.xuexiang.xupdate.utils.ApkInstallUtils;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
public class XUpdate {
    private static XUpdate sInstance;
    String mApkCacheDir;
    private Application mContext;
    Map<String, Object> mParams;
    IUpdateHttpService mUpdateHttpService;
    boolean mIsGet = false;
    boolean mIsWifiOnly = true;
    boolean mIsAutoMode = false;
    IUpdateChecker mUpdateChecker = new DefaultUpdateChecker();
    IUpdateParser mUpdateParser = new DefaultUpdateParser();
    IUpdateDownloader mUpdateDownloader = new DefaultUpdateDownloader();
    IUpdatePrompter mUpdatePrompter = new DefaultUpdatePrompter();
    IFileEncryptor mFileEncryptor = new DefaultFileEncryptor();
    OnInstallListener mOnInstallListener = new DefaultInstallListener();
    OnUpdateFailureListener mOnUpdateFailureListener = new DefaultUpdateFailureListener();

    private XUpdate() {
    }

    public static XUpdate get() {
        if (sInstance == null) {
            synchronized (XUpdate.class) {
                if (sInstance == null) {
                    sInstance = new XUpdate();
                }
            }
        }
        return sInstance;
    }

    public void init(Application application) {
        this.mContext = application;
        UpdateError.init(application);
    }

    private Application getApplication() {
        testInitialize();
        return this.mContext;
    }

    private void testInitialize() {
        if (this.mContext == null) {
            throw new ExceptionInInitializerError("请先在全局Application中调用 XUpdate.get().init() 初始化！");
        }
    }

    public static Context getContext() {
        return get().getApplication();
    }

    public static UpdateManager.Builder newBuild(Context context) {
        return new UpdateManager.Builder(context);
    }

    public static UpdateManager.Builder newBuild(Context context, String str) {
        return new UpdateManager.Builder(context).updateUrl(str);
    }

    public XUpdate param(String str, Object obj) {
        if (this.mParams == null) {
            this.mParams = new TreeMap();
        }
        UpdateLog.d("设置全局参数, key:" + str + ", value:" + obj.toString());
        this.mParams.put(str, obj);
        return this;
    }

    public XUpdate params(Map<String, Object> map) {
        logForParams(map);
        this.mParams = map;
        return this;
    }

    private void logForParams(Map<String, Object> map) {
        StringBuilder sb = new StringBuilder("设置全局参数:{\n");
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            sb.append("key = ").append(entry.getKey()).append(", value = ").append(entry.getValue().toString()).append("\n");
        }
        sb.append("}");
        UpdateLog.d(sb.toString());
    }

    public XUpdate setIUpdateHttpService(IUpdateHttpService iUpdateHttpService) {
        UpdateLog.d("设置全局更新网络请求服务:" + iUpdateHttpService.getClass().getCanonicalName());
        this.mUpdateHttpService = iUpdateHttpService;
        return this;
    }

    public XUpdate setIUpdateChecker(IUpdateChecker iUpdateChecker) {
        this.mUpdateChecker = iUpdateChecker;
        return this;
    }

    public XUpdate setIUpdateParser(IUpdateParser iUpdateParser) {
        this.mUpdateParser = iUpdateParser;
        return this;
    }

    public XUpdate setIUpdatePrompter(IUpdatePrompter iUpdatePrompter) {
        this.mUpdatePrompter = iUpdatePrompter;
        return this;
    }

    public XUpdate setIUpdateDownLoader(IUpdateDownloader iUpdateDownloader) {
        this.mUpdateDownloader = iUpdateDownloader;
        return this;
    }

    public XUpdate isGet(boolean z) {
        UpdateLog.d("设置全局是否使用的是Get请求:" + z);
        this.mIsGet = z;
        return this;
    }

    public XUpdate isWifiOnly(boolean z) {
        UpdateLog.d("设置全局是否只在wifi下进行版本更新检查:" + z);
        this.mIsWifiOnly = z;
        return this;
    }

    public XUpdate isAutoMode(boolean z) {
        UpdateLog.d("设置全局是否是自动版本更新模式:" + z);
        this.mIsAutoMode = z;
        return this;
    }

    public XUpdate setApkCacheDir(String str) {
        UpdateLog.d("设置全局apk的缓存路径:" + str);
        this.mApkCacheDir = str;
        return this;
    }

    public XUpdate supportSilentInstall(boolean z) {
        ApkInstallUtils.setSupportSilentInstall(z);
        return this;
    }

    public XUpdate debug(boolean z) {
        UpdateLog.debug(z);
        return this;
    }

    public XUpdate setILogger(ILogger iLogger) {
        UpdateLog.setLogger(iLogger);
        return this;
    }

    public XUpdate setIFileEncryptor(IFileEncryptor iFileEncryptor) {
        this.mFileEncryptor = iFileEncryptor;
        return this;
    }

    public XUpdate setOnInstallListener(OnInstallListener onInstallListener) {
        this.mOnInstallListener = onInstallListener;
        return this;
    }

    public XUpdate setOnUpdateFailureListener(OnUpdateFailureListener onUpdateFailureListener) {
        this.mOnUpdateFailureListener = onUpdateFailureListener;
        return this;
    }
}
