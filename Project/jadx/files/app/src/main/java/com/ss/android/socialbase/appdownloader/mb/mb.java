package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes3.dex */
public abstract class mb implements h {
    protected final String b;
    protected final Context mb;
    protected final DownloadSetting ox;

    public mb(Context context, DownloadSetting downloadSetting, String str) {
        this.mb = context;
        this.ox = downloadSetting;
        this.b = str;
    }

    public boolean mb() {
        if (this.mb == null) {
            return false;
        }
        try {
        } catch (Throwable unused) {
            Logger.debug();
        }
        return ox().resolveActivity(this.mb.getPackageManager()) != null;
    }
}
