package com.ss.android.socialbase.appdownloader.z;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class m extends z {
    public m(Context context) {
        super(context, null, null);
    }

    @Override // com.ss.android.socialbase.appdownloader.z.gc
    public Intent g() {
        Intent intent = new Intent("android.settings.SECURITY_SETTINGS");
        intent.addFlags(268435456);
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        return intent;
    }
}
