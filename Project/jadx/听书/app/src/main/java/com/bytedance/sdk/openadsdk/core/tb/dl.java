package com.bytedance.sdk.openadsdk.core.tb;

import android.content.Context;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.v.gz;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private com.bytedance.sdk.openadsdk.v.z g;
    private gz z;

    public gz z(Context context, SSWebView sSWebView, com.bytedance.sdk.openadsdk.v.dl dlVar, com.bytedance.sdk.openadsdk.v.z zVar, Set<String> set, gz.z zVar2) {
        if (this.z == null) {
            gz gzVarZ = gz.z(context, sSWebView, dlVar, zVar, set, zVar2, true);
            this.z = gzVarZ;
            gzVarZ.a(false);
        }
        this.g = zVar;
        return this.z;
    }
}
