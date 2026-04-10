package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.swiper.FullSwiperView;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends g {
    private FullSwiperView ls;
    private float pf;
    private float v;

    public uy(TTBaseVideoActivity tTBaseVideoActivity, na naVar, boolean z) {
        super(tTBaseVideoActivity, naVar, z);
    }

    public void z(float[] fArr) {
        this.v = fArr[0];
        this.pf = fArr[1];
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z() {
        super.z();
        this.e.setBackgroundColor(0);
        this.ls = new FullSwiperView(this.g);
    }

    public void z(List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.z> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ls.z(list).z(this.v).g(this.pf).z(String.valueOf(eo.fo(this.dl))).z();
        this.e.addView(this.ls, new FrameLayout.LayoutParams(-1, -1));
    }

    public void g() {
        FullSwiperView fullSwiperView = this.ls;
        if (fullSwiperView != null) {
            fullSwiperView.g();
        }
    }

    public void dl() {
        FullSwiperView fullSwiperView = this.ls;
        if (fullSwiperView != null) {
            fullSwiperView.dl();
        }
    }

    public void a() {
        FullSwiperView fullSwiperView = this.ls;
        if (fullSwiperView != null) {
            fullSwiperView.a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void uy() {
        super.uy();
        FullSwiperView fullSwiperView = this.ls;
        if (fullSwiperView != null) {
            fullSwiperView.gc();
        }
    }

    public int gc() {
        FullSwiperView fullSwiperView = this.ls;
        if (fullSwiperView != null) {
            return fullSwiperView.getCurrentPosition();
        }
        return 0;
    }

    public void m() {
        FullSwiperView fullSwiperView = this.ls;
        if (fullSwiperView != null) {
            fullSwiperView.e();
        }
    }
}
