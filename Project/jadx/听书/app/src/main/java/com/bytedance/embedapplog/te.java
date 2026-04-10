package com.bytedance.embedapplog;

import android.os.Bundle;
import com.bytedance.embedapplog.yt;

/* JADX INFO: loaded from: classes2.dex */
public class te extends yt.z {
    private volatile String z = "";

    @Override // com.bytedance.embedapplog.yt
    public void z(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.bytedance.embedapplog.yt
    public void z(int i, Bundle bundle) {
        if (i != 0 || bundle == null) {
            return;
        }
        this.z = bundle.getString("oa_id_flag");
    }

    public String g() {
        return this.z;
    }
}
