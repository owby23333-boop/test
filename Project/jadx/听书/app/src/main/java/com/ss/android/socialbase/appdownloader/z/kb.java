package com.ss.android.socialbase.appdownloader.z;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class kb extends z {
    public kb(Context context, com.ss.android.socialbase.downloader.i.z zVar, String str) {
        super(context, zVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.z.gc
    public Intent g() {
        Intent intent = new Intent("com.android.filemanager.OPEN_FOLDER");
        intent.putExtra("com.android.filemanager.OPEN_FOLDER", this.dl);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
