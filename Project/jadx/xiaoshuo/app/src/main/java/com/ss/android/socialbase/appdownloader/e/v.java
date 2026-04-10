package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class v extends e {
    public v(Context context, com.ss.android.socialbase.downloader.p.e eVar, String str) {
        super(context, eVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.e.ga
    public Intent bf() {
        Intent intent = new Intent(com.ss.android.socialbase.downloader.constants.ga.d + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.d);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
