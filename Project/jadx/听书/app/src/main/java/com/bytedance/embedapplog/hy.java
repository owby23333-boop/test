package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.yt;

/* JADX INFO: loaded from: classes2.dex */
public class hy extends yt.z {
    private volatile boolean z = false;

    @Override // com.bytedance.embedapplog.yt
    public void z(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.embedapplog.yt
    public void z(int i, Bundle bundle) {
        if (i != 0 || bundle == null) {
            return;
        }
        this.z = bundle.getBoolean("oa_id_limit_state");
    }

    public boolean g() {
        return this.z;
    }
}
