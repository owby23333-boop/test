package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.RatioImageView;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g {
    private TextView fv;
    private TTRatingBar js;
    private TextView ls;
    private TextView p;
    private TTRoundRectImageView pf;
    private UpieImageView q;
    private TextView tb;
    private RatioImageView v;

    public m(TTBaseVideoActivity tTBaseVideoActivity, na naVar, boolean z) {
        super(tTBaseVideoActivity, naVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z() {
        super.z();
        this.fo = (FrameLayout) this.e.findViewById(2114387642);
        this.v = (RatioImageView) this.e.findViewById(2114387766);
        this.pf = (TTRoundRectImageView) this.e.findViewById(2114387722);
        this.ls = (TextView) this.e.findViewById(2114387702);
        this.p = (TextView) this.e.findViewById(2114387934);
        this.fv = (TextView) this.e.findViewById(2114387789);
        this.tb = (TextView) this.e.findViewById(2114387962);
        this.js = (TTRatingBar) this.e.findViewById(2114387787);
        if (com.bytedance.sdk.openadsdk.gc.z.a(this.dl)) {
            UpieImageView upieImageView = new UpieImageView(this.v.getContext(), com.bytedance.sdk.openadsdk.gc.z.fo(this.dl), com.bytedance.sdk.openadsdk.gc.z.uy(this.dl));
            this.q = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar, com.bytedance.sdk.openadsdk.core.g.g gVar2) {
        z(this.tb, gVar, gVar);
        z(this.v, gVar2, gVar2);
        z(this.pf, gVar2, gVar2);
        z(this.ls, gVar2, gVar2);
        z(this.p, gVar2, gVar2);
        z(this.fv, gVar2, gVar2);
        z(this.js, gVar2, gVar2);
        z(this.q, gVar2, gVar2);
    }

    protected void z(View view, com.bytedance.sdk.openadsdk.core.g.g gVar, View.OnTouchListener onTouchListener) {
        if (view == null || this.g == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(gVar);
    }

    private void g() {
        gk gkVarKp;
        oq.z((TextView) this.g.findViewById(2114387658), this.dl);
        if (this.v != null) {
            int iOu = this.dl.ou();
            if (iOu == 3) {
                this.v.setRatio(1.91f);
            } else if (iOu == 33) {
                this.v.setRatio(1.0f);
            } else {
                this.v.setRatio(0.56f);
            }
            z(this.v, this.q);
        }
        if (this.pf != null && (gkVarKp = this.dl.kp()) != null) {
            com.bytedance.sdk.openadsdk.gz.g.z(gkVarKp).to(this.pf);
        }
        TextView textView = this.ls;
        if (textView != null) {
            textView.setText(v());
        }
        TextView textView2 = this.p;
        if (textView2 != null) {
            textView2.setText(pf());
        }
        dl();
        a();
    }

    private void dl() {
        TTRatingBar tTRatingBar = this.js;
        if (tTRatingBar == null) {
            return;
        }
        tTRatingBar.setStarEmptyNum(1);
        this.js.setStarFillNum(4);
        this.js.setStarImageWidth(oq.dl(this.g, 16.0f));
        this.js.setStarImageHeight(oq.dl(this.g, 16.0f));
        this.js.setStarImagePadding(oq.dl(this.g, 4.0f));
        this.js.z();
    }

    private void a() {
        if (this.fv == null) {
            return;
        }
        int iM = this.dl.c() != null ? this.dl.c().m() : 6870;
        this.fv.setText(String.format(tb.z(this.g, "tt_comment_num_backup"), iM > 10000 ? (iM / 10000) + "万" : String.valueOf(iM)));
    }
}
