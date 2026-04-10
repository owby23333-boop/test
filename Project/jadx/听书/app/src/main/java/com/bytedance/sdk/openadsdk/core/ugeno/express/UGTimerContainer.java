package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class UGTimerContainer extends FrameLayout {
    private com.bytedance.sdk.openadsdk.core.ugeno.uy.z z;

    public UGTimerContainer(Context context) {
        super(context);
    }

    void setTimerHolder(com.bytedance.sdk.openadsdk.core.ugeno.uy.z zVar) {
        this.z = zVar;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.bytedance.sdk.openadsdk.core.ugeno.uy.z zVar = this.z;
        if (zVar != null) {
            if (i == 0) {
                zVar.z();
            } else {
                zVar.g();
            }
        }
    }
}
