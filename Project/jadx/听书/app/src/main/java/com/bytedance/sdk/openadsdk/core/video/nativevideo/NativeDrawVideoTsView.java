package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.uy;

/* JADX INFO: loaded from: classes2.dex */
public class NativeDrawVideoTsView extends NativeVideoTsView implements View.OnClickListener {
    private int g;
    private boolean z;

    public NativeDrawVideoTsView(Context context, na naVar) {
        super(context, naVar);
        this.z = false;
        setOnClickListener(this);
        this.g = getResources().getConfiguration().orientation;
    }

    public NativeDrawVideoTsView(Context context, na naVar, String str, boolean z, boolean z2) {
        super(context, naVar, str, z, z2);
        this.z = false;
        setOnClickListener(this);
        this.g = getResources().getConfiguration().orientation;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void e() {
        this.pf = "draw_ad";
        super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void g() {
        if (this.z) {
            super.g();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.z = z;
    }

    public void z(Bitmap bitmap, int i) {
        uy.ls().z(bitmap);
        this.ls = i;
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
        g();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        if (this.g == configuration.orientation) {
            return;
        }
        this.g = configuration.orientation;
        oq.z(this, new oq.z() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.1
            @Override // com.bytedance.sdk.openadsdk.core.un.oq.z
            public void z(View view) {
                if (NativeDrawVideoTsView.this.gc == null) {
                    return;
                }
                NativeDrawVideoTsView.this.z(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void a() {
        int i = getResources().getConfiguration().orientation;
        if (this.g != i) {
            this.g = i;
            oq.z(this, new oq.z() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView.2
                @Override // com.bytedance.sdk.openadsdk.core.un.oq.z
                public void z(View view) {
                    if (NativeDrawVideoTsView.this.gc == null) {
                        return;
                    }
                    NativeDrawVideoTsView.this.z(NativeDrawVideoTsView.this.getWidth(), NativeDrawVideoTsView.this.getHeight());
                    NativeDrawVideoTsView.super.a();
                }
            });
        } else {
            super.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected com.bykv.vk.openvk.component.video.api.a.dl z(Context context, ViewGroup viewGroup, na naVar, String str, boolean z, boolean z2, boolean z3) {
        return new dl(context, viewGroup, naVar, str, z, z2, z3);
    }
}
