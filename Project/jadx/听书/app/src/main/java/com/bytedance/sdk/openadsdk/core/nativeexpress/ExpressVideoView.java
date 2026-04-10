package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;

/* JADX INFO: loaded from: classes2.dex */
public class ExpressVideoView extends NativeVideoTsView implements View.OnClickListener {
    public ImageView g;
    private boolean iq;
    private boolean q;
    protected int z;
    private boolean zw;

    public ExpressVideoView(Context context, na naVar, String str, boolean z) {
        super(context, naVar, false, false, str, false, false);
        this.q = false;
        if ("draw_ad".equals(str)) {
            this.q = true;
        }
        this.iq = z;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected com.bykv.vk.openvk.component.video.api.a.dl z(Context context, ViewGroup viewGroup, na naVar, String str, boolean z, boolean z2, boolean z3) {
        if (this.iq) {
            return new com.bytedance.sdk.openadsdk.core.video.nativevideo.dl(context, viewGroup, naVar, str, z, z2, z3);
        }
        return super.z(context, viewGroup, naVar, str, z, z2, z3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void g() {
        if (this.q) {
            super.g(this.z);
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.q = z;
    }

    public void setVideoPlayStatus(int i) {
        this.z = i;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.gc != null) {
            this.gc.gc(z);
        }
    }

    public void dl() {
        if (this.i != null) {
            oq.z((View) this.i, 8);
        }
    }

    public void y_() {
        if (this.i != null) {
            oq.z((View) this.i, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (this.wp != null && this.wp.getVisibility() == 0) {
            q();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.wp != null && this.wp.getVisibility() == 0) {
            q();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void gz() {
        oq.z((View) this.uy, 0);
        oq.z((View) this.kb, 0);
        oq.z((View) this.i, 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void z(boolean z) {
        if (this.zw) {
            super.z(z);
        }
    }

    public void g(boolean z) {
        this.zw = z;
    }

    private void q() {
        kb();
        if (this.uy != null) {
            if (this.uy.getVisibility() == 0) {
                return;
            }
            com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.f1401a)).to(this.kb);
            z(this.kb, tf.g(this.f1401a));
        }
        gz();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.wp != null && this.wp.getVisibility() == 0) {
            oq.gc(this.uy);
        }
        g(this.z);
    }

    public void setShowAdInteractionView(boolean z) {
        com.bykv.vk.openvk.component.video.api.a.g gVarFv;
        if (this.gc == null || (gVarFv = this.gc.fv()) == null) {
            return;
        }
        gVarFv.z(z);
    }

    protected void z_() {
        kb();
        oq.z((View) this.uy, 0);
    }

    public void m() {
        if (this.wp != null) {
            oq.z((View) this.wp, 8);
        }
    }

    public boolean A_() {
        return (this.gc == null || this.gc.p() == null || !this.gc.p().i()) ? false : true;
    }

    protected void setPauseIcon(boolean z) {
        if (this.g == null) {
            this.g = new ImageView(getContext());
            if (com.bytedance.sdk.openadsdk.core.uy.ls().xl() != null) {
                this.g.setImageBitmap(com.bytedance.sdk.openadsdk.core.uy.ls().xl());
            } else {
                com.bytedance.sdk.component.utils.tb.z(com.bytedance.sdk.openadsdk.core.zw.getContext(), "tt_new_play_video", this.g);
            }
            this.g.setScaleType(ImageView.ScaleType.FIT_XY);
            int iDl = oq.dl(getContext(), this.ls);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDl, iDl);
            layoutParams.gravity = 17;
            this.m.addView(this.g, layoutParams);
        }
        if (z) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    public com.bykv.vk.openvk.component.video.api.a.dl getVideoController() {
        return this.gc;
    }
}
