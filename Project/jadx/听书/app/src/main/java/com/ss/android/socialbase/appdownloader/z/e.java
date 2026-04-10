package com.ss.android.socialbase.appdownloader.z;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class e extends z {
    public e(Context context, com.ss.android.socialbase.downloader.i.z zVar, String str) {
        super(context, zVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.z.gc
    public Intent g() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.g.gc.dl + ".filemanager.intent.action.BROWSER_FILE");
        intent.putExtra("CurrentDir", this.dl);
        intent.putExtra("CurrentMode", 1);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
