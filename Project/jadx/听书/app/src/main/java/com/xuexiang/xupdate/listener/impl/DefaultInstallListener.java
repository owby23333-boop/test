package com.xuexiang.xupdate.listener.impl;

import android.content.Context;
import com.xuexiang.xupdate._XUpdate;
import com.xuexiang.xupdate.entity.DownloadEntity;
import com.xuexiang.xupdate.listener.OnInstallListener;
import com.xuexiang.xupdate.utils.ApkInstallUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class DefaultInstallListener implements OnInstallListener {
    @Override // com.xuexiang.xupdate.listener.OnInstallListener
    public void onInstallApkSuccess() {
    }

    @Override // com.xuexiang.xupdate.listener.OnInstallListener
    public boolean onInstallApk(Context context, File file, DownloadEntity downloadEntity) {
        if (checkApkFile(downloadEntity, file)) {
            return installApkFile(context, file);
        }
        _XUpdate.onUpdateError(5000, "Apk file verify failed, please check whether the MD5 value you set is correct！");
        return false;
    }

    protected boolean checkApkFile(DownloadEntity downloadEntity, File file) {
        return downloadEntity != null && downloadEntity.isApkFileValid(file);
    }

    protected boolean installApkFile(Context context, File file) {
        try {
            return ApkInstallUtils.install(context, file);
        } catch (IOException e) {
            _XUpdate.onUpdateError(5000, "An error occurred while install apk:" + e.getMessage());
            return false;
        }
    }
}
