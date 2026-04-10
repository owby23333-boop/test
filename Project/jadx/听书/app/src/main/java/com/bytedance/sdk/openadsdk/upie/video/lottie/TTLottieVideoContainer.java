package com.bytedance.sdk.openadsdk.upie.video.lottie;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.renderview.g;

/* JADX INFO: loaded from: classes2.dex */
public class TTLottieVideoContainer extends FrameLayout implements com.bykv.vk.openvk.component.video.api.renderview.g {
    private g.z z;

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public View getView() {
        return this;
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public void z(com.bykv.vk.openvk.component.video.api.renderview.z zVar) {
    }

    public TTLottieVideoContainer(Context context) {
        super(context);
    }

    @Override // com.bykv.vk.openvk.component.video.api.renderview.g
    public void z(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(g.z zVar) {
        this.z = zVar;
    }
}
