package com.ss.android.socialbase.appdownloader.z;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class uy extends z {
    public uy(Context context, com.ss.android.socialbase.downloader.i.z zVar, String str) {
        super(context, zVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.z.gc
    public Intent g() {
        Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
        intent.putExtra("FilePathToBeOpenAfterScan", this.dl);
        intent.putExtra("com.iqoo.secure", true);
        intent.putExtra("OpenParentAndLocationDestFile", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
