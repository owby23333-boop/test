package com.bytedance.sdk.openadsdk.pf;

import android.text.TextUtils;
import com.bytedance.embedapplog.gc;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private gc.z g;
    private String z;

    public a(gc.z zVar) {
        this.g = zVar;
        if (zVar == null || TextUtils.isEmpty(zVar.z) || TextUtils.equals("00000000-0000-0000-0000-000000000000", zVar.z)) {
            this.z = "error";
        }
    }

    public a(String str) {
        this.z = str;
    }

    public gc.z z() {
        return this.g;
    }

    public String getType() {
        return this.z;
    }
}
