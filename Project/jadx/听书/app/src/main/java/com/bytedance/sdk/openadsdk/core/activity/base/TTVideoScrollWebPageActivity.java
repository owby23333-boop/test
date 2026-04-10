package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.a;
import com.bytedance.sdk.openadsdk.res.gc;
import com.bytedance.sdk.openadsdk.widget.TTScrollView;

/* JADX INFO: loaded from: classes3.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    private TTScrollView fo;

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(2114387873);
        this.fo = tTScrollView;
        tTScrollView.setListener(new TTScrollView.z() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.widget.TTScrollView.z
            public void z(boolean z) {
                try {
                    if (TTVideoScrollWebPageActivity.this.gz != null && (TTVideoScrollWebPageActivity.this.gz instanceof a)) {
                        if (z && !TTVideoScrollWebPageActivity.this.gz.tb()) {
                            ((a) TTVideoScrollWebPageActivity.this.gz).m(false);
                        } else {
                            TTVideoScrollWebPageActivity.this.gz.m();
                        }
                    }
                } catch (Throwable th) {
                    wp.dl("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        if (this.gz != null) {
            this.gz.a(false);
        }
        if (this.e != null) {
            this.e.setVideoAdInteractionListener(new dl.InterfaceC0027dl() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.2
                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void r_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void s_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void t_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void z(long j, long j2) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
                public void q_() {
                    if (TTVideoScrollWebPageActivity.this.fo == null || TTVideoScrollWebPageActivity.this.fo.z() || TTVideoScrollWebPageActivity.this.gz == null) {
                        return;
                    }
                    TTVideoScrollWebPageActivity.this.gz.e();
                }
            });
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(gc.oq(this));
    }
}
