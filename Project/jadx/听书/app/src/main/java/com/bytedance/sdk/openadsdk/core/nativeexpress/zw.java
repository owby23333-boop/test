package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes3.dex */
public class zw extends q {
    public zw(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        super(context, naVar, gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.q
    public void z(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        this.z = new NativeExpressVideoView(context, naVar, gVar, "embeded_ad");
        z(this.z, this.dl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g, com.bytedance.sdk.openadsdk.ls.dl.g.v
    public void z(final com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
        if (this.z != null) {
            this.z.setVideoAdListener(new dl.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zw.1
                @Override // com.bykv.vk.openvk.component.video.api.a.dl.a
                public void p_() {
                    com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.a.dl.a
                public void z(int i, int i2) {
                    com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z(i, i2);
                    }
                }
            });
            this.z.setVideoAdInteractionListener(new dl.InterfaceC0027dl() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.zw.2
                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void q_() {
                    com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.g();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void r_() {
                    com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.dl();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void s_() {
                    com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.a();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void z(long j, long j2) {
                    com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.z(j, j2);
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void t_() {
                    com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar2 = dlVar;
                    if (dlVar2 != null) {
                        dlVar2.gc();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public com.bytedance.sdk.openadsdk.core.multipro.g.z kb() {
        if (this.gc != null && this.gc.get() != null) {
            return this.gc.get().getVideoModel();
        }
        if (!(this.z instanceof NativeExpressVideoView)) {
            return null;
        }
        ((NativeExpressVideoView) this.z).pf();
        return ((NativeExpressVideoView) this.z).getVideoModel();
    }
}
