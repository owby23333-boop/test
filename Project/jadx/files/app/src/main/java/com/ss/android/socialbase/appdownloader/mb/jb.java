package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes3.dex */
public class jb extends mb {
    public jb(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.b);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
