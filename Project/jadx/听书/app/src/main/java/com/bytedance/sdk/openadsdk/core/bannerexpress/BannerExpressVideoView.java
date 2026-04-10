package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class BannerExpressVideoView extends z {
    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public /* bridge */ /* synthetic */ void dl() {
        super.dl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public /* bridge */ /* synthetic */ void gc() {
        super.gc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public /* bridge */ /* synthetic */ NativeExpressView getCurView() {
        return super.getCurView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public /* bridge */ /* synthetic */ NativeExpressView getNextView() {
        return super.getNextView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public /* bridge */ /* synthetic */ void setDuration(int i) {
        super.setDuration(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public /* bridge */ /* synthetic */ void setExpressInteractionListener(com.bytedance.sdk.openadsdk.core.nativeexpress.z zVar) {
        super.setExpressInteractionListener(zVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public /* bridge */ /* synthetic */ void setVideoAdListener(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
        super.setVideoAdListener(dlVar);
    }

    public BannerExpressVideoView(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        super(context, naVar, gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    protected void z() {
        this.g = new NativeExpressVideoView(this.z, this.f926a, this.gc, this.uy);
        addView(this.g, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.bannerexpress.z
    public void z(na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.dl = new NativeExpressVideoView(this.z, naVar, gVar, this.uy);
        this.dl.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.z() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressVideoView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, int i) {
                if (BannerExpressVideoView.this.m != null) {
                    BannerExpressVideoView.this.m.z(BannerExpressVideoView.this, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
            public void z(View view, float f, float f2) {
                BannerExpressVideoView.this.z(f, f2);
                BannerExpressVideoView.this.m();
            }
        });
        oq.z((View) this.dl, 8);
        addView(this.dl, new ViewGroup.LayoutParams(-1, -1));
    }

    public com.bytedance.sdk.openadsdk.core.multipro.g.z getVideoModel() {
        if (this.g != null) {
            return ((NativeExpressVideoView) this.g).getVideoModel();
        }
        return null;
    }
}
