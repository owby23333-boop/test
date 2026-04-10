package com.xuexiang.xupdate.proxy;

import android.content.Context;
import com.xuexiang.xupdate.entity.UpdateEntity;
import com.xuexiang.xupdate.listener.IUpdateParseCallback;
import com.xuexiang.xupdate.service.OnFileDownloadListener;

/* JADX INFO: loaded from: classes4.dex */
public interface IUpdateProxy {
    void backgroundDownload();

    void cancelDownload();

    void checkVersion();

    void findNewVersion(UpdateEntity updateEntity, IUpdateProxy iUpdateProxy);

    Context getContext();

    IUpdateHttpService getIUpdateHttpService();

    String getUrl();

    boolean isAsyncParser();

    void noNewVersion(Throwable th);

    void onAfterCheck();

    void onBeforeCheck();

    UpdateEntity parseJson(String str) throws Exception;

    void parseJson(String str, IUpdateParseCallback iUpdateParseCallback) throws Exception;

    void recycle();

    void startDownload(UpdateEntity updateEntity, OnFileDownloadListener onFileDownloadListener);

    void update();
}
