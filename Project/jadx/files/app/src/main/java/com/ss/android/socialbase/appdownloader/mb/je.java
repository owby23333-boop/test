package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* JADX INFO: loaded from: classes3.dex */
public class je extends mb {
    public je(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        String strOptString = this.ox.optString("s");
        String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("ag"), strOptString);
        String strMb2 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("ah"), strOptString);
        String strMb3 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString(com.anythink.expressad.d.a.b.cZ), strOptString);
        String strMb4 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("aj"), strOptString);
        Intent intent = new Intent();
        intent.putExtra(strMb, this.b);
        intent.putExtra(strMb2, "*/*");
        intent.putExtra(strMb3, true);
        intent.setAction(strMb4);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.addFlags(32768);
        return intent;
    }
}
