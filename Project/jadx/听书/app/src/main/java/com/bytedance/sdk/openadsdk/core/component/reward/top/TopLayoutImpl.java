package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.iq.hh;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TopLayoutImpl extends FrameLayout implements z<TopLayoutImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f968a;
    private View dl;
    private View e;
    private TextView fo;
    private View fv;
    private ImageView g;
    private TextView gc;
    private View gz;
    private View i;
    private na iq;
    private TextView js;
    private TextView kb;
    private TextView ls;
    private View m;
    private View p;
    private View pf;
    private g q;
    private boolean tb;
    private View uy;
    private View v;
    private View wp;
    private View z;

    public TopLayoutImpl(Context context) {
        this(context, null);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public TopLayoutImpl z(na naVar) {
        this.iq = naVar;
        if (js.kb(naVar)) {
            addView(com.bytedance.sdk.openadsdk.res.gc.gz(getContext()));
        } else if (y.gz(this.iq)) {
            addView(com.bytedance.sdk.openadsdk.res.gc.e(getContext()));
        } else {
            addView(com.bytedance.sdk.openadsdk.res.gc.m(getContext()));
        }
        this.z = findViewById(2114387845);
        this.g = (ImageView) findViewById(2114387758);
        this.dl = findViewById(2114387819);
        this.f968a = findViewById(2114387673);
        this.gc = (TextView) findViewById(2114387632);
        this.m = findViewById(2114387713);
        this.e = findViewById(2114387951);
        this.gz = findViewById(2114387725);
        this.fo = (TextView) findViewById(2114387606);
        this.uy = findViewById(2114387635);
        this.kb = (TextView) findViewById(2114387785);
        this.wp = findViewById(2114387738);
        this.i = findViewById(2114387924);
        this.v = findViewById(2114387950);
        this.pf = findViewById(2114387949);
        this.ls = (TextView) findViewById(2114387948);
        this.p = findViewById(2114387947);
        this.fv = findViewById(2114387946);
        this.js = (TextView) findViewById(2114387945);
        View view = this.uy;
        if (view != null) {
            view.setEnabled(false);
            this.uy.setClickable(false);
        }
        a();
        return this;
    }

    private void a() {
        oq.z(this.z, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.q != null) {
                    TopLayoutImpl.this.q.dl(view);
                }
            }
        }, "top_dislike_button");
        oq.z(this.g, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopLayoutImpl.this.tb = !r0.tb;
                tb.z(TopLayoutImpl.this.getContext(), TopLayoutImpl.this.tb ? "tt_mute" : "tt_unmute", TopLayoutImpl.this.g);
                if (TopLayoutImpl.this.q != null) {
                    TopLayoutImpl.this.q.g(view);
                }
            }
        }, "top_mute_button");
        oq.z(this.e, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "top_before_button");
        oq.z(this.uy, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", TopLayoutImpl.this.q);
                    jSONObject.put("topImpl", 1);
                } catch (Throwable unused) {
                }
                if (!hh.z(TopLayoutImpl.this.iq) || com.bytedance.sdk.openadsdk.core.pf.a.z(String.valueOf(eo.fo(TopLayoutImpl.this.iq)))) {
                    v.z().z(TopLayoutImpl.this.iq, "stats_reward_full_click_native_close", jSONObject);
                }
                if (TopLayoutImpl.this.q != null) {
                    TopLayoutImpl.this.q.z(view);
                }
            }
        }, "top_skip_button");
        oq.z(this.dl, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.q != null) {
                    TopLayoutImpl.this.q.a(view);
                }
            }
        }, "top_back_button");
        oq.z(this.f968a, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.q != null) {
                    TopLayoutImpl.this.q.gc(view);
                }
            }
        }, "top_again_button");
        oq.z(this.m, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.q != null) {
                    TopLayoutImpl.this.q.m(view);
                }
            }
        }, "top_skip_border");
        oq.z(this.fv, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.top.TopLayoutImpl.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.q != null) {
                    TopLayoutImpl.this.q.e(view);
                }
            }
        }, "top_next_video_cancel");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setShowSound(boolean z) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setSoundMute(boolean z) {
        this.tb = z;
        tb.z(getContext(), this.tb ? "tt_mute" : "tt_unmute", this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setShowBack(boolean z) {
        View view = this.dl;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void z(boolean z, String str, String str2, boolean z2, boolean z3) {
        oq.z(this.m, 0);
        boolean z4 = z || !TextUtils.isEmpty(str);
        boolean z5 = z2 || !TextUtils.isEmpty(str2);
        boolean z6 = z4 && z5;
        oq.z(this.m, (z4 || z5) ? 0 : 4);
        oq.z(this.e, z4 ? 0 : 8);
        oq.z(this.uy, z5 ? 0 : 8);
        oq.z(this.i, z6 ? 0 : 8);
        oq.z(this.gz, z ? 0 : 8);
        oq.z((View) this.fo, !TextUtils.isEmpty(str) ? 0 : 8);
        oq.z(this.wp, z2 ? 0 : 8);
        oq.z((View) this.kb, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            oq.z(this.fo, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            oq.z(this.kb, str2);
        }
        View view = this.uy;
        if (view != null) {
            view.setEnabled(z3);
            this.uy.setClickable(z3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void z(String str, String str2, boolean z) {
        boolean z2 = !TextUtils.isEmpty(str);
        boolean z3 = !TextUtils.isEmpty(str2);
        boolean z4 = z2 && z3;
        oq.z(this.v, (z2 || z3) ? 0 : 4);
        oq.z(this.pf, z2 ? 0 : 8);
        oq.z(this.fv, z3 ? 0 : 8);
        oq.z(this.p, z4 ? 0 : 8);
        oq.z((View) this.ls, !TextUtils.isEmpty(str) ? 0 : 8);
        oq.z((View) this.js, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            oq.z(this.ls, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            oq.z(this.js, str2);
        }
        View view = this.uy;
        if (view != null) {
            view.setEnabled(z);
            this.uy.setClickable(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setShowDislike(boolean z) {
        View view = this.z;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setListener(g gVar) {
        this.q = gVar;
    }

    public g getTopListener() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void z() {
        View view = this.uy;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void g() {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void dl() {
        View view = this.z;
        if (view != null) {
            view.performClick();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public View getCloseButton() {
        return this.uy;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public boolean getSkipOrCloseVisible() {
        return oq.a(this.uy) || (this.m != null && oq.a(this.kb) && !TextUtils.isEmpty(this.kb.getText()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setShowAgain(boolean z) {
        oq.z(this.f968a, z ? 0 : 8);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setPlayAgainEntranceText(String str) {
        oq.z(this.gc, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.z
    public void setDislikeLeft(boolean z) {
        if (this.z.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.z.getLayoutParams();
            layoutParams.gravity = z ? GravityCompat.START : GravityCompat.END;
            this.z.setLayoutParams(layoutParams);
        }
    }
}
