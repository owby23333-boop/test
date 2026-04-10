package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(api = 26)
public class ox extends mb {
    public ox(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.mb.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        return intent;
    }
}
