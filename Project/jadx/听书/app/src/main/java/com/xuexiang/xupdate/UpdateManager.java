package com.xuexiang.xupdate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.xuexiang.xupdate.entity.PromptEntity;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.listener.IUpdateParseCallback;
import com.xuexiang.xupdate.logs.UpdateLog;
import com.xuexiang.xupdate.proxy.IUpdateChecker;
import com.xuexiang.xupdate.proxy.IUpdateDownloader;
import com.xuexiang.xupdate.proxy.IUpdateHttpService;
import com.xuexiang.xupdate.proxy.IUpdateParser;
import com.xuexiang.xupdate.proxy.IUpdatePrompter;
import com.xuexiang.xupdate.proxy.IUpdateProxy;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdatePrompter;
import com.xuexiang.xupdate.service.OnFileDownloadListener;
import com.xuexiang.xupdate.utils.UpdateUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes4.dex */
public class UpdateManager implements IUpdateProxy {
    private final String mApkCacheDir;
    private final WeakReference<Context> mContext;
    private final IUpdateChecker mIUpdateChecker;
    private IUpdateDownloader mIUpdateDownloader;
    private IUpdateHttpService mIUpdateHttpService;
    private final IUpdateParser mIUpdateParser;
    private final IUpdatePrompter mIUpdatePrompter;
    private final boolean mIsAutoMode;
    private final boolean mIsGet;
    private final boolean mIsWifiOnly;
    private OnFileDownloadListener mOnFileDownloadListener;
    private final Map<String, Object> mParams;
    private final PromptEntity mPromptEntity;
    private UpdateEntity mUpdateEntity;
    private IUpdateProxy mUpdateProxy;
    private final String mUpdateUrl;

    private UpdateManager(Builder builder) {
        this.mContext = new WeakReference<>(builder.context);
        this.mUpdateUrl = builder.updateUrl;
        this.mParams = builder.params;
        this.mApkCacheDir = builder.apkCacheDir;
        this.mIsWifiOnly = builder.isWifiOnly;
        this.mIsGet = builder.isGet;
        this.mIsAutoMode = builder.isAutoMode;
        this.mIUpdateHttpService = builder.updateHttpService;
        this.mIUpdateChecker = builder.updateChecker;
        this.mIUpdateParser = builder.updateParser;
        this.mIUpdateDownloader = builder.updateDownLoader;
        this.mOnFileDownloadListener = builder.onFileDownloadListener;
        this.mIUpdatePrompter = builder.updatePrompter;
        this.mPromptEntity = builder.promptEntity;
    }

    public UpdateManager setIUpdateProxy(IUpdateProxy iUpdateProxy) {
        this.mUpdateProxy = iUpdateProxy;
        return this;
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public Context getContext() {
        return this.mContext.get();
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public String getUrl() {
        return this.mUpdateUrl;
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public IUpdateHttpService getIUpdateHttpService() {
        return this.mIUpdateHttpService;
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void update() {
        UpdateLog.d("XUpdate.update()启动:" + this);
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.update();
        } else {
            doUpdate();
        }
    }

    private void doUpdate() {
        onBeforeCheck();
        doCheck();
    }

    private void doCheck() {
        if (this.mIsWifiOnly) {
            if (UpdateUtils.checkWifi()) {
                checkVersion();
                return;
            } else {
                onAfterCheck();
                _XUpdate.onUpdateError(2001);
                return;
            }
        }
        if (UpdateUtils.checkNetwork()) {
            checkVersion();
        } else {
            onAfterCheck();
            _XUpdate.onUpdateError(2002);
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void onBeforeCheck() {
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.onBeforeCheck();
        } else {
            this.mIUpdateChecker.onBeforeCheck();
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void checkVersion() {
        UpdateLog.d("开始检查版本信息...");
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.checkVersion();
        } else {
            if (TextUtils.isEmpty(this.mUpdateUrl)) {
                throw new NullPointerException("[UpdateManager] : mUpdateUrl 不能为空");
            }
            this.mIUpdateChecker.checkVersion(this.mIsGet, this.mUpdateUrl, this.mParams, this);
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void onAfterCheck() {
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.onAfterCheck();
        } else {
            this.mIUpdateChecker.onAfterCheck();
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public boolean isAsyncParser() {
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            return iUpdateProxy.isAsyncParser();
        }
        return this.mIUpdateParser.isAsyncParser();
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public UpdateEntity parseJson(String str) throws Exception {
        UpdateLog.i("服务端返回的最新版本信息:" + str);
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            this.mUpdateEntity = iUpdateProxy.parseJson(str);
        } else {
            this.mUpdateEntity = this.mIUpdateParser.parseJson(str);
        }
        UpdateEntity updateEntityRefreshParams = refreshParams(this.mUpdateEntity);
        this.mUpdateEntity = updateEntityRefreshParams;
        return updateEntityRefreshParams;
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void parseJson(String str, final IUpdateParseCallback iUpdateParseCallback) throws Exception {
        UpdateLog.i("服务端返回的最新版本信息:" + str);
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.parseJson(str, new IUpdateParseCallback() { // from class: com.xuexiang.xupdate.UpdateManager.1
                @Override // com.xuexiang.xupdate.listener.IUpdateParseCallback
                public void onParseResult(UpdateEntity updateEntity) {
                    UpdateManager updateManager = UpdateManager.this;
                    updateManager.mUpdateEntity = updateManager.refreshParams(updateEntity);
                    iUpdateParseCallback.onParseResult(updateEntity);
                }
            });
        } else {
            this.mIUpdateParser.parseJson(str, new IUpdateParseCallback() { // from class: com.xuexiang.xupdate.UpdateManager.2
                @Override // com.xuexiang.xupdate.listener.IUpdateParseCallback
                public void onParseResult(UpdateEntity updateEntity) {
                    UpdateManager updateManager = UpdateManager.this;
                    updateManager.mUpdateEntity = updateManager.refreshParams(updateEntity);
                    iUpdateParseCallback.onParseResult(updateEntity);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public UpdateEntity refreshParams(UpdateEntity updateEntity) {
        if (updateEntity != null) {
            updateEntity.setApkCacheDir(this.mApkCacheDir);
            updateEntity.setIsAutoMode(this.mIsAutoMode);
            updateEntity.setIUpdateHttpService(this.mIUpdateHttpService);
        }
        return updateEntity;
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void findNewVersion(UpdateEntity updateEntity, IUpdateProxy iUpdateProxy) {
        UpdateLog.i("发现新版本:" + updateEntity);
        if (updateEntity.isSilent()) {
            if (!UpdateUtils.isApkDownloaded(updateEntity)) {
                startDownload(updateEntity, this.mOnFileDownloadListener);
                return;
            } else {
                _XUpdate.startInstallApk(getContext(), this.mUpdateEntity);
                return;
            }
        }
        IUpdateProxy iUpdateProxy2 = this.mUpdateProxy;
        if (iUpdateProxy2 != null) {
            iUpdateProxy2.findNewVersion(updateEntity, iUpdateProxy);
            return;
        }
        IUpdatePrompter iUpdatePrompter = this.mIUpdatePrompter;
        if (iUpdatePrompter instanceof DefaultUpdatePrompter) {
            Context context = getContext();
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isFinishing()) {
                _XUpdate.onUpdateError(3001);
                return;
            } else {
                this.mIUpdatePrompter.showPrompt(updateEntity, iUpdateProxy, this.mPromptEntity);
                return;
            }
        }
        iUpdatePrompter.showPrompt(updateEntity, iUpdateProxy, this.mPromptEntity);
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void noNewVersion(Throwable th) {
        UpdateLog.i(th != null ? "未发现新版本:" + th.getMessage() : "未发现新版本!");
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.noNewVersion(th);
        } else {
            this.mIUpdateChecker.noNewVersion(th);
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void startDownload(UpdateEntity updateEntity, OnFileDownloadListener onFileDownloadListener) {
        UpdateLog.i("开始下载更新文件:" + updateEntity);
        updateEntity.setIUpdateHttpService(this.mIUpdateHttpService);
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.startDownload(updateEntity, onFileDownloadListener);
            return;
        }
        IUpdateDownloader iUpdateDownloader = this.mIUpdateDownloader;
        if (iUpdateDownloader != null) {
            iUpdateDownloader.startDownload(updateEntity, onFileDownloadListener);
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void backgroundDownload() {
        UpdateLog.i("点击了后台更新按钮, 在通知栏中显示下载进度...");
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.backgroundDownload();
            return;
        }
        IUpdateDownloader iUpdateDownloader = this.mIUpdateDownloader;
        if (iUpdateDownloader != null) {
            iUpdateDownloader.backgroundDownload();
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void cancelDownload() {
        UpdateLog.d("正在取消更新文件的下载...");
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.cancelDownload();
            return;
        }
        IUpdateDownloader iUpdateDownloader = this.mIUpdateDownloader;
        if (iUpdateDownloader != null) {
            iUpdateDownloader.cancelDownload();
        }
    }

    @Override // com.xuexiang.xupdate.proxy.IUpdateProxy
    public void recycle() {
        UpdateLog.d("正在回收资源...");
        IUpdateProxy iUpdateProxy = this.mUpdateProxy;
        if (iUpdateProxy != null) {
            iUpdateProxy.recycle();
            this.mUpdateProxy = null;
        }
        Map<String, Object> map = this.mParams;
        if (map != null) {
            map.clear();
        }
        this.mIUpdateHttpService = null;
        this.mIUpdateDownloader = null;
        this.mOnFileDownloadListener = null;
    }

    public boolean download(String str, OnFileDownloadListener onFileDownloadListener) {
        if (_XUpdate.isAppUpdating("")) {
            _XUpdate.onUpdateError(2003);
            return false;
        }
        startDownload(refreshParams(new UpdateEntity().setDownloadUrl(str)), onFileDownloadListener);
        return true;
    }

    public boolean update(UpdateEntity updateEntity) {
        if (_XUpdate.isAppUpdating("")) {
            _XUpdate.onUpdateError(2003);
            return false;
        }
        UpdateEntity updateEntityRefreshParams = refreshParams(updateEntity);
        this.mUpdateEntity = updateEntityRefreshParams;
        try {
            UpdateUtils.processUpdateEntity(updateEntityRefreshParams, "这里调用的是直接更新方法，因此没有json!", this);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static class Builder {
        String apkCacheDir;
        Context context;
        boolean isAutoMode;
        boolean isGet;
        boolean isWifiOnly;
        OnFileDownloadListener onFileDownloadListener;
        Map<String, Object> params = new TreeMap();
        PromptEntity promptEntity;
        IUpdateChecker updateChecker;
        IUpdateDownloader updateDownLoader;
        IUpdateHttpService updateHttpService;
        IUpdateParser updateParser;
        IUpdatePrompter updatePrompter;
        String updateUrl;

        Builder(Context context) {
            this.context = context;
            if (_XUpdate.getParams() != null) {
                this.params.putAll(_XUpdate.getParams());
            }
            this.promptEntity = new PromptEntity();
            this.updateHttpService = _XUpdate.getIUpdateHttpService();
            this.updateChecker = _XUpdate.getIUpdateChecker();
            this.updateParser = _XUpdate.getIUpdateParser();
            this.updatePrompter = _XUpdate.getIUpdatePrompter();
            this.updateDownLoader = _XUpdate.getIUpdateDownLoader();
            this.isGet = _XUpdate.isGet();
            this.isWifiOnly = _XUpdate.isWifiOnly();
            this.isAutoMode = _XUpdate.isAutoMode();
            this.apkCacheDir = _XUpdate.getApkCacheDir();
        }

        public Builder updateUrl(String str) {
            this.updateUrl = str;
            return this;
        }

        public Builder params(Map<String, Object> map) {
            this.params.putAll(map);
            return this;
        }

        public Builder param(String str, Object obj) {
            this.params.put(str, obj);
            return this;
        }

        public Builder updateHttpService(IUpdateHttpService iUpdateHttpService) {
            this.updateHttpService = iUpdateHttpService;
            return this;
        }

        public Builder apkCacheDir(String str) {
            this.apkCacheDir = str;
            return this;
        }

        public Builder isGet(boolean z) {
            this.isGet = z;
            return this;
        }

        public Builder isAutoMode(boolean z) {
            this.isAutoMode = z;
            return this;
        }

        public Builder isWifiOnly(boolean z) {
            this.isWifiOnly = z;
            return this;
        }

        public Builder updateChecker(IUpdateChecker iUpdateChecker) {
            this.updateChecker = iUpdateChecker;
            return this;
        }

        public Builder updateParser(IUpdateParser iUpdateParser) {
            this.updateParser = iUpdateParser;
            return this;
        }

        public Builder updatePrompter(IUpdatePrompter iUpdatePrompter) {
            this.updatePrompter = iUpdatePrompter;
            return this;
        }

        public Builder setOnFileDownloadListener(OnFileDownloadListener onFileDownloadListener) {
            this.onFileDownloadListener = onFileDownloadListener;
            return this;
        }

        @Deprecated
        public Builder themeColor(int i) {
            this.promptEntity.setThemeColor(i);
            return this;
        }

        public Builder promptThemeColor(int i) {
            this.promptEntity.setThemeColor(i);
            return this;
        }

        @Deprecated
        public Builder topResId(int i) {
            this.promptEntity.setTopResId(i);
            return this;
        }

        public Builder promptTopResId(int i) {
            this.promptEntity.setTopResId(i);
            return this;
        }

        public Builder promptTopDrawable(Drawable drawable) {
            if (drawable != null) {
                this.promptEntity.setTopDrawableTag(_XUpdate.saveTopDrawable(drawable));
            }
            return this;
        }

        public Builder promptTopBitmap(Bitmap bitmap) {
            if (bitmap != null) {
                this.promptEntity.setTopDrawableTag(_XUpdate.saveTopDrawable(new BitmapDrawable(this.context.getResources(), bitmap)));
            }
            return this;
        }

        public Builder promptButtonTextColor(int i) {
            this.promptEntity.setButtonTextColor(i);
            return this;
        }

        public Builder supportBackgroundUpdate(boolean z) {
            this.promptEntity.setSupportBackgroundUpdate(z);
            return this;
        }

        public Builder promptWidthRatio(float f) {
            this.promptEntity.setWidthRatio(f);
            return this;
        }

        public Builder promptHeightRatio(float f) {
            this.promptEntity.setHeightRatio(f);
            return this;
        }

        public Builder promptIgnoreDownloadError(boolean z) {
            this.promptEntity.setIgnoreDownloadError(z);
            return this;
        }

        public Builder promptStyle(PromptEntity promptEntity) {
            this.promptEntity = promptEntity;
            return this;
        }

        public Builder updateDownLoader(IUpdateDownloader iUpdateDownloader) {
            this.updateDownLoader = iUpdateDownloader;
            return this;
        }

        public UpdateManager build() {
            UpdateUtils.requireNonNull(this.context, "[UpdateManager.Builder] : context == null");
            UpdateUtils.requireNonNull(this.updateHttpService, "[UpdateManager.Builder] : updateHttpService == null");
            if (TextUtils.isEmpty(this.apkCacheDir)) {
                this.apkCacheDir = UpdateUtils.getDefaultDiskCacheDirPath();
            }
            return new UpdateManager(this);
        }

        public void update() {
            build().update();
        }

        public void update(IUpdateProxy iUpdateProxy) {
            build().setIUpdateProxy(iUpdateProxy).update();
        }
    }

    public String toString() {
        return "XUpdate{mUpdateUrl='" + this.mUpdateUrl + "', mParams=" + this.mParams + ", mApkCacheDir='" + this.mApkCacheDir + "', mIsWifiOnly=" + this.mIsWifiOnly + ", mIsGet=" + this.mIsGet + ", mIsAutoMode=" + this.mIsAutoMode + '}';
    }
}
