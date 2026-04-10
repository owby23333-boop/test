package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.oq;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class RewardBrowserMixTopLayoutImpl extends FrameLayout implements z<RewardBrowserMixTopLayoutImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private na f967a;
    private g dl;
    private View g;
    private Context gc;
    private View z;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void g() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setDislikeLeft(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setPlayAgainEntranceText(String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setShowAgain(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setShowBack(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setShowDislike(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setShowSound(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setSoundMute(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void z(String str, String str2, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void z(boolean z, String str, String str2, boolean z2, boolean z3) {
    }

    public RewardBrowserMixTopLayoutImpl(Context context) {
        this(context, null);
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gc = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
        if (z && this.f967a.i()) {
            this.z.setVisibility(0);
        }
    }

    public RewardBrowserMixTopLayoutImpl z(na naVar) {
        this.f967a = naVar;
        addView(com.bytedance.sdk.openadsdk.res.gc.gz(getContext()));
        this.z = findViewById(2114387869);
        View viewFindViewById = findViewById(2114387453);
        this.g = findViewById(2114387454);
        if (js.i(naVar)) {
            this.z = findViewById(2114387869);
            this.g.setVisibility(8);
            viewFindViewById.setVisibility(8);
            tb.z(this.gc, "tt_ad_skip_btn_bg", this.z);
        } else if (js.v(naVar)) {
            findViewById(2114387738).setVisibility(8);
            this.z = findViewById(2114387869);
        } else {
            this.z = findViewById(2114387713);
            this.g.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        if (this.z != null) {
            if (naVar.i()) {
                this.z.setVisibility(8);
            } else {
                this.z.setVisibility(0);
                this.z.setEnabled(true);
                this.z.setClickable(true);
            }
        }
        a();
        return this;
    }

    private void a() {
        oq.z(this.z, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", RewardBrowserMixTopLayoutImpl.this.dl);
                    jSONObject.put("topImpl", 2);
                } catch (Throwable unused) {
                }
                v.z().z(RewardBrowserMixTopLayoutImpl.this.f967a, "stats_reward_full_click_native_close", jSONObject);
                if (RewardBrowserMixTopLayoutImpl.this.dl != null) {
                    RewardBrowserMixTopLayoutImpl.this.dl.z(view);
                }
            }
        }, "top_skip_border");
        oq.z(this.g, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.RewardBrowserMixTopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardBrowserMixTopLayoutImpl.this.dl != null) {
                    RewardBrowserMixTopLayoutImpl.this.dl.dl(view);
                }
            }
        }, "top_dislike_button");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setListener(g gVar) {
        this.dl = gVar;
    }

    public g getTopListener() {
        return this.dl;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void z() {
        View view = this.z;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void dl() {
        View view = this.g;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public View getCloseButton() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public boolean getSkipOrCloseVisible() {
        return oq.a(this.z);
    }
}
