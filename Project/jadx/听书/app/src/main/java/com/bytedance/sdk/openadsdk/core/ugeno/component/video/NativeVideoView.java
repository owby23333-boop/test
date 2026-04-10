package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.a;
import com.bytedance.sdk.openadsdk.hh.uy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NativeVideoView extends NativeVideoTsView implements dl.z {
    private z g;
    private boolean iq;
    private com.bytedance.adsdk.ugeno.dl q;
    private int z;

    public NativeVideoView(Context context) {
        super(context);
        if (this.gc != null) {
            this.gc.z(true);
        }
        this.tb.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void B_() {
        super.B_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected dl z(Context context, ViewGroup viewGroup, na naVar, String str, boolean z, boolean z2, boolean z3) {
        z zVar = new z(context, viewGroup, naVar, str, z, z2, z3);
        this.g = zVar;
        return zVar;
    }

    public void setPlayerType(int i) {
        this.z = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void a() {
        if (this.gc == null) {
            B_();
        } else if ((this.gc instanceof a) && !ls()) {
            ((a) this.gc).vm();
        }
        if (this.gc == null || !this.tb.get()) {
            return;
        }
        this.tb.set(false);
        e();
        if (v()) {
            oq.z((View) this.uy, 0);
            if (this.wp != null) {
                oq.z((View) this.wp, 8);
            }
            if (tf.v(this.f1401a) != null) {
                com.bykv.vk.openvk.component.video.api.dl.a aVarZ = tf.z(4, this.f1401a);
                aVarZ.g(this.f1401a.mj());
                aVarZ.g(this.m.getWidth());
                aVarZ.dl(this.m.getHeight());
                aVarZ.dl(this.f1401a.vk());
                this.f1401a.ec(this.z);
                aVarZ.gc(this.z);
                aVarZ.z(uy.z(this.f1401a));
                aVarZ.z(this.gc.kb());
                aVarZ.g(this.gc.js());
                ((a) this.gc).gc(this.z);
                ((a) this.gc).z(this.f1401a);
                z(aVarZ);
                this.gc.dl(false);
                return;
            }
            wp.a("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        if (this.gc.tb()) {
            oq.z((View) this.uy, 0);
            return;
        }
        wp.z("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
        kb();
        oq.z((View) this.uy, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void gc() {
        super.gc();
        oq.z((View) this.uy, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void setIsAutoPlay(boolean z) {
        super.setIsAutoPlay(z);
        oq.z((View) this.uy, 0);
    }

    public void z(boolean z, boolean z2) {
        kb();
        oq.z((View) this.uy, 0);
        oq.z((View) this.i, z ? 0 : 8);
        oq.z((View) this.kb, z2 ? 0 : 8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.dl dlVar = this.q;
        if (dlVar != null) {
            int[] iArrZ = dlVar.z(i, i2);
            super.onMeasure(iArrZ[0], iArrZ[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public boolean z(long j, boolean z, boolean z2) {
        this.m.setVisibility(0);
        if (this.gc == null) {
            this.gc = new a(getContext(), this.e, this.f1401a, this.pf, false, false);
        }
        if (wp() || this.fo) {
            z(this.dl, 25, tf.g(this.f1401a));
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bytedance.sdk.openadsdk.core.video.nativevideo.a.z
    public void C_() {
        oq.z((View) this.uy, 8);
        super.C_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bykv.vk.openvk.component.video.api.a.dl.z
    public void g(long j, int i) {
        super.g(j, i);
        oq.z((View) this.uy, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.iq && i == 8) {
            gc();
        }
    }

    public void setExtraMap(Map<String, Object> map) {
        if (this.gc != null) {
            this.gc.g(map);
        }
    }

    public void M_() {
        z zVar = this.g;
        if (zVar != null) {
            zVar.gz();
            oq.z((View) this.uy, 8);
        }
    }

    public void gz() {
        z zVar = this.g;
        if (zVar != null) {
            zVar.m();
        }
    }

    public void setLp(boolean z) {
        this.iq = z;
    }

    public void z(com.bytedance.adsdk.ugeno.dl dlVar) {
        this.q = dlVar;
    }
}
