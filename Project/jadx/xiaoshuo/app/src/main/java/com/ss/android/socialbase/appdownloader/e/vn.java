package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class vn extends e {
    public vn(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.e.ga
    public Intent bf() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
