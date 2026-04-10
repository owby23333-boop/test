package com.xuexiang.xupdate.listener;

import android.content.Context;
import com.xuexiang.xupdate.entity.DownloadEntity;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public interface OnInstallListener {
    boolean onInstallApk(Context context, File file, DownloadEntity downloadEntity);

    void onInstallApkSuccess();
}
