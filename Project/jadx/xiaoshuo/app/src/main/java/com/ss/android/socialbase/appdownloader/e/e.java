package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e implements ga {
    protected final com.ss.android.socialbase.downloader.p.e bf;
    protected final String d;
    protected final Context e;

    public e(Context context, com.ss.android.socialbase.downloader.p.e eVar, String str) {
        this.e = context;
        this.bf = eVar;
        this.d = str;
    }

    public boolean e() {
        if (this.e == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.d.e.e()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return bf().resolveActivity(this.e.getPackageManager()) != null;
    }
}
