package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.widget.wp;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends g {
    private TextView fv;
    private FrameLayout iq;
    private TextView js;
    private TTRoundRectImageView ls;
    private TextView p;
    protected final AtomicBoolean pf;
    private FrameLayout q;
    private TTRatingBar tb;
    protected int v;

    public dl(TTBaseVideoActivity tTBaseVideoActivity, na naVar, boolean z) {
        super(tTBaseVideoActivity, naVar, z);
        this.v = 0;
        this.pf = new AtomicBoolean(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z() {
        super.z();
        this.gz = (RelativeLayout) this.g.findViewById(2114387649);
        this.ls = (TTRoundRectImageView) this.g.findViewById(2114387793);
        this.p = (TextView) this.g.findViewById(2114387875);
        this.fv = (TextView) this.g.findViewById(2114387630);
        this.js = (TextView) this.g.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) this.g.findViewById(2114387609);
        this.tb = tTRatingBar;
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            this.tb.setStarFillNum(4);
            this.tb.setStarImageWidth(oq.dl(this.g, 15.0f));
            this.tb.setStarImageHeight(oq.dl(this.g, 14.0f));
            this.tb.setStarImagePadding(oq.dl(this.g, 4.0f));
            this.tb.z();
        }
        this.uy = (TextView) this.g.findViewById(2114387658);
        this.fo = (FrameLayout) this.g.findViewById(2114387642);
        this.q = (FrameLayout) this.g.findViewById(2114387964);
        this.iq = (FrameLayout) this.g.findViewById(2114387925);
        oq.z(this.uy, this.dl);
        try {
            if (this.f962a == 2 && this.dl.b() == 1 && (this.js.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.js.getLayoutParams();
                layoutParams.height = oq.dl(this.g, 55.0f);
                layoutParams.topMargin = oq.dl(this.g, 20.0f);
                this.js.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gz.getLayoutParams();
                layoutParams2.bottomMargin = oq.dl(this.g, 12.0f);
                this.gz.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        if (this.dl.b() == 1 && this.fo != null && (this.fo.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fo.getLayoutParams();
            int iA = oq.a((Context) this.g);
            layoutParams3.width = iA;
            int i = (iA * 9) / 16;
            layoutParams3.height = i;
            this.fo.setLayoutParams(layoutParams3);
            this.v = (oq.gc((Context) this.g) - i) / 2;
        }
        dl();
        a();
        gc();
        m();
        e();
        kb();
    }

    private void dl() {
        if (this.ls != null) {
            gk gkVarKp = this.dl.kp();
            if (gkVarKp != null && !TextUtils.isEmpty(gkVarKp.z())) {
                com.bytedance.sdk.openadsdk.gz.g.z(gkVarKp).to(this.ls);
            } else {
                tb.z((Context) this.g, "tt_ad_logo_small", (ImageView) this.ls);
            }
        }
        if (this.p != null) {
            if (this.f962a == 1 && this.dl.c() != null && !TextUtils.isEmpty(this.dl.c().dl())) {
                this.p.setText(this.dl.c().dl());
            } else {
                this.p.setText(this.dl.li());
            }
        }
    }

    private void a() {
        if (this.fv == null) {
            return;
        }
        int iM = this.dl.c() != null ? this.dl.c().m() : 6870;
        this.fv.setText(String.format("%1$s个评分", iM > 10000 ? (iM / 10000) + "万" : String.valueOf(iM)));
    }

    private void gc() {
        TextView textView = this.js;
        if (textView != null) {
            textView.setText(this.dl.b() == 3 ? gz() : g());
        }
    }

    private void m() {
        if (this.f962a == 1) {
            TextView textView = this.p;
            if (textView != null) {
                textView.setMaxWidth(oq.dl(this.g, 153.0f));
            }
        } else {
            TextView textView2 = this.p;
            if (textView2 != null) {
                textView2.setMaxWidth(oq.dl(this.g, 404.0f));
            }
        }
        if (this.m) {
            return;
        }
        oq.z((View) this.gz, 0);
    }

    private void e() {
        if (this.dl.b() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            int iDl = oq.dl(this.g, 17.0f);
            int color = Color.parseColor("#80000000");
            wp.z((LinearLayout) this.g.findViewById(2114387898), new wp.z().z(iArr[0]).g(color).z(iArr).dl(iDl).a(0).gc(oq.dl(this.g, 3.0f)));
        }
    }

    protected String g() {
        if (this.dl == null) {
            return "立即下载";
        }
        if (TextUtils.isEmpty(this.dl.no())) {
            return this.dl.lt() != 4 ? "查看详情" : "立即下载";
        }
        return this.dl.no();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String gz() {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.layout.dl.gz():java.lang.String");
    }

    private String z(boolean z) {
        if (this.dl == null) {
            return null;
        }
        return z ? this.dl.lt() == 4 ? "下载" : "查看" : this.dl.lt() == 4 ? "Install" : "View";
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar, com.bytedance.sdk.openadsdk.core.g.g gVar2) {
        if (this.dl == null) {
            return;
        }
        oq.z((View) this.js, (View.OnClickListener) gVar, (String) null);
        oq.z((View) this.js, (View.OnTouchListener) gVar, (String) null);
        z((View.OnTouchListener) gVar2);
        z((View.OnClickListener) gVar2);
        if (this.dl.b() == 1) {
            FrameLayout frameLayout = this.q;
            if (frameLayout != null) {
                oq.z((View) frameLayout, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
                layoutParams.height = this.v;
                this.q.setLayoutParams(layoutParams);
            }
            FrameLayout frameLayout2 = this.iq;
            if (frameLayout2 != null) {
                oq.z((View) frameLayout2, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.iq.getLayoutParams();
                layoutParams2.height = this.v;
                this.iq.setLayoutParams(layoutParams2);
            }
        }
    }

    private void z(View.OnTouchListener onTouchListener) {
        oq.z(this.gz, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
        oq.z(this.p, onTouchListener, "TTBaseVideoActivity#mTvAppName");
        oq.z(this.ls, onTouchListener, "TTBaseVideoActivity#mIvIcon");
        oq.z(this.fv, onTouchListener, "TTBaseVideoActivity#mTvCommentVertical");
        oq.z(this.tb, onTouchListener, "TTBaseVideoActivity#mRbScore");
        oq.z(this.fo, onTouchListener, "TTBaseVideoActivity#mVideoNativeFrame");
        oq.z(this.q, onTouchListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        oq.z(this.iq, onTouchListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }

    private void z(View.OnClickListener onClickListener) {
        oq.z(this.gz, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
        oq.z(this.p, onClickListener, "TTBaseVideoActivity#mTvAppName");
        oq.z(this.ls, onClickListener, "TTBaseVideoActivity#mIvIcon");
        oq.z(this.fv, onClickListener, "TTBaseVideoActivity#mTvCommentVertical");
        oq.z(this.tb, onClickListener, "TTBaseVideoActivity#mRbScore");
        oq.z(this.fo, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
        oq.z(this.q, onClickListener, "TTBaseVideoActivity#mClickUpperNonContentArea");
        oq.z(this.iq, onClickListener, "TTBaseVideoActivity#mClickLowerNonContentArea");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void g(int i) {
        if (this.gz == null || this.i == -1 || i != this.i || this.pf.getAndSet(true)) {
            return;
        }
        oq.z((View) this.gz, 0);
        Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
        Keyframe keyframeOfFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
        Keyframe keyframeOfFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
        Keyframe keyframeOfFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
        Keyframe keyframeOfFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
        Keyframe keyframeOfFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.gz, PropertyValuesHolder.ofKeyframe("scaleX", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6), PropertyValuesHolder.ofKeyframe("scaleY", keyframeOfFloat, keyframeOfFloat2, keyframeOfFloat3, keyframeOfFloat4, keyframeOfFloat5, keyframeOfFloat6));
        objectAnimatorOfPropertyValuesHolder.setDuration(1000L);
        objectAnimatorOfPropertyValuesHolder.start();
    }
}
