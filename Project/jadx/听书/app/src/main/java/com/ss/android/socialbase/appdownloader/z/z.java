package com.ss.android.socialbase.appdownloader.z;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z implements gc {
    protected final String dl;
    protected final com.ss.android.socialbase.downloader.i.z g;
    protected final Context z;

    public z(Context context, com.ss.android.socialbase.downloader.i.z zVar, String str) {
        this.z = context;
        this.g = zVar;
        this.dl = str;
    }

    public boolean z() {
        if (this.z == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.m.z.z()) {
                com.bytedance.sdk.component.utils.wp.dl("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return g().resolveActivity(this.z.getPackageManager()) != null;
    }
}
