package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes3.dex */
public class NativeExpressDrawVideoView extends NativeExpressVideoView {
    private int iq;

    public NativeExpressDrawVideoView(Context context, na naVar, com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar, String str) {
        super(context, naVar, gVar, str);
        this.iq = getResources().getConfiguration().orientation;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView
    protected ExpressVideoView z(Context context, na naVar, String str) {
        return new ExpressVideoView(context, naVar, str, true);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        zw();
    }

    private void zw() {
        int i = getResources().getConfiguration().orientation;
        if (this.iq != i) {
            this.iq = i;
            oq.z(this, new oq.z() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressDrawVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.un.oq.z
                public void z(View view) {
                    int width = NativeExpressDrawVideoView.this.getWidth();
                    int height = NativeExpressDrawVideoView.this.getHeight();
                    NativeExpressDrawVideoView nativeExpressDrawVideoView = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView.z(nativeExpressDrawVideoView.v, width, height);
                    View viewFindViewById = NativeExpressDrawVideoView.this.v.findViewById(2114387714);
                    NativeExpressDrawVideoView.this.z(viewFindViewById, width, height);
                    if (viewFindViewById != null) {
                        viewFindViewById.requestLayout();
                    }
                    NativeExpressDrawVideoView nativeExpressDrawVideoView2 = NativeExpressDrawVideoView.this;
                    nativeExpressDrawVideoView2.z(nativeExpressDrawVideoView2.getWebView(), width, height);
                    if (NativeExpressDrawVideoView.this.kb != null) {
                        NativeExpressDrawVideoView.this.kb.z(width, height);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView, com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        zw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        zw();
    }
}
