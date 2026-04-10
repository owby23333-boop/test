package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.ad.y;

/* JADX INFO: loaded from: classes4.dex */
public class xu extends e {
    public xu(Context context, com.ss.android.socialbase.downloader.p.e eVar, String str) {
        super(context, eVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.e.ga
    public Intent bf() {
        String strD = this.bf.d("s");
        String strE = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("ag"), strD);
        String strE2 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("ah"), strD);
        String strE3 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d(y.t), strD);
        String strE4 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("aj"), strD);
        Intent intent = new Intent();
        intent.putExtra(strE, this.d);
        intent.putExtra(strE2, "*/*");
        intent.putExtra(strE3, true);
        intent.setAction(strE4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
