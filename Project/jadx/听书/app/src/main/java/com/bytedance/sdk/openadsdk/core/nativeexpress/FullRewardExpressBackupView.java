package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class FullRewardExpressBackupView extends BackupView {
    private View i;
    private FrameLayout pf;
    private NativeExpressView v;

    public FullRewardExpressBackupView(Context context) {
        super(context);
        this.z = context;
    }

    public void z(na naVar, NativeExpressView nativeExpressView) {
        setBackgroundColor(-1);
        this.g = naVar;
        this.v = nativeExpressView;
        if (eo.gz(this.g) == 7) {
            this.gc = "rewarded_video";
        } else {
            this.gc = "fullscreen_interstitial_ad";
        }
        z();
        this.v.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void z() {
        this.m = oq.dl(this.z, this.v.getExpectExpressWidth());
        this.e = oq.dl(this.z, this.v.getExpectExpressWidth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.m, this.e);
        }
        layoutParams.width = this.m;
        layoutParams.height = this.e;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        g();
    }

    private void g() {
        FrameLayout frameLayout = new FrameLayout(this.z);
        this.i = frameLayout;
        frameLayout.setId(2114387734);
        addView(this.i);
        FrameLayout frameLayout2 = (FrameLayout) this.i.findViewById(2114387734);
        this.pf = frameLayout2;
        frameLayout2.removeAllViews();
    }

    public FrameLayout getVideoContainer() {
        return this.pf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void z(View view, int i, com.bytedance.sdk.openadsdk.core.iq.zw zwVar) {
        NativeExpressView nativeExpressView = this.v;
        if (nativeExpressView != null) {
            nativeExpressView.z(view, i, zwVar);
        }
    }
}
