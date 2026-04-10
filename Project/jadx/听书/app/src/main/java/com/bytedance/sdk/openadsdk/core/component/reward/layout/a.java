package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import androidx.media3.common.C;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardDrawRecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class a extends g {
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.dl fv;
    private boolean iq;
    private float js;
    private RewardDrawRecyclerView ls;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.z p;
    private RewardGuideSlideUp pf;
    private boolean q;
    private float tb;
    private boolean v;

    public a(TTBaseVideoActivity tTBaseVideoActivity, na naVar, boolean z) {
        super(tTBaseVideoActivity, naVar, z);
        this.q = true;
    }

    public void z(float[] fArr) {
        this.js = fArr[0];
        this.tb = fArr[1];
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z() {
        super.z();
        this.ls = (RewardDrawRecyclerView) this.e.findViewById(2114387885);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.dl dlVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.dl(this.g, 0, false);
        this.fv = dlVar;
        this.ls.setLayoutManager(dlVar);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.z zVar = new com.bytedance.sdk.openadsdk.core.component.reward.draw.z(this.g, this.js, this.tb);
        this.p = zVar;
        this.ls.setAdapter(zVar);
        if (this.v) {
            RewardGuideSlideUp rewardGuideSlideUp = (RewardGuideSlideUp) this.e.findViewById(2114387966);
            this.pf = rewardGuideSlideUp;
            rewardGuideSlideUp.z();
        }
    }

    public RecyclerView g() {
        return this.ls;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.z dl() {
        return this.p;
    }

    public com.bytedance.sdk.openadsdk.core.component.reward.draw.dl a() {
        return this.fv;
    }

    public void gc() {
        if (this.v && this.q) {
            this.e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.v && a.this.q) {
                        a.this.q = false;
                        oq.z((View) a.this.pf, 0);
                        a.this.pf.getSlideUpAnimatorSet().start();
                        a.this.iq = true;
                        a.this.e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.a.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.m();
                            }
                        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    }
                }
            }, 0L);
        }
    }

    public void m() {
        if (this.v) {
            this.q = false;
            if (this.iq) {
                oq.z((View) this.pf, 8);
                RewardGuideSlideUp rewardGuideSlideUp = this.pf;
                if (rewardGuideSlideUp != null) {
                    rewardGuideSlideUp.g();
                }
                this.iq = false;
            }
        }
    }

    public void z(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.dl dlVar = this.fv;
        if (dlVar == null) {
            return;
        }
        dlVar.g(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void uy() {
        super.uy();
        m();
    }
}
