package com.ss.android.socialbase.appdownloader.z;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes4.dex */
public class g extends z {
    public g(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.z.gc
    public Intent g() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.z.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        return intent;
    }
}
