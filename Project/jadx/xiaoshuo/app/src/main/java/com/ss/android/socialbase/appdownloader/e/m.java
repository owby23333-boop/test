package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class m extends e {
    public m(Context context, com.ss.android.socialbase.downloader.p.e eVar, String str) {
        super(context, eVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.e.ga
    public Intent bf() {
        Intent intent = new Intent("com.android.filemanager.FILE_OPEN");
        intent.putExtra("FilePathToBeOpenAfterScan", this.d);
        intent.putExtra("com.iqoo.secure", true);
        intent.putExtra("OpenParentAndLocationDestFile", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
