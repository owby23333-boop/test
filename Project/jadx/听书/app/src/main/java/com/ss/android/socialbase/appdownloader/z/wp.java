package com.ss.android.socialbase.appdownloader.z;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes4.dex */
public class wp extends z {
    public wp(Context context, com.ss.android.socialbase.downloader.i.z zVar, String str) {
        super(context, zVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.z.gc
    public Intent g() {
        String strDl = this.g.dl("s");
        String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(this.g.dl("ag"), strDl);
        String strZ2 = com.ss.android.socialbase.appdownloader.m.dl.z(this.g.dl("ah"), strDl);
        String strZ3 = com.ss.android.socialbase.appdownloader.m.dl.z(this.g.dl("ai"), strDl);
        String strZ4 = com.ss.android.socialbase.appdownloader.m.dl.z(this.g.dl("aj"), strDl);
        Intent intent = new Intent();
        intent.putExtra(strZ, this.dl);
        intent.putExtra(strZ2, "*/*");
        intent.putExtra(strZ3, true);
        intent.setAction(strZ4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
