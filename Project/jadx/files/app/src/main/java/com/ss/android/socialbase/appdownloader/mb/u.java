package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes3.dex */
public class u extends mb {
    public u(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
