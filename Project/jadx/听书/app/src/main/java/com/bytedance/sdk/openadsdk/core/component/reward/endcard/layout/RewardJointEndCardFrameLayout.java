package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.component.widget.recycler.z.dl.m;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView;
import com.bytedance.sdk.openadsdk.core.g.g;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.iq;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.hh.e;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public class RewardJointEndCardFrameLayout extends AbstractEndCardFrameLayout implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f951a;
    private FrameLayout dl;
    private RewardJointBottomView gc;
    private FrameLayout m;

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getEndCardWebView() {
        return null;
    }

    public RewardJointEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    void z() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        z(linearLayout);
        g(linearLayout);
        dl(linearLayout);
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public SSWebView getPlayableWebView() {
        return this.gc.getWebView();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public FrameLayout getVideoArea() {
        return this.m;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void setClickListener(g gVar) {
        oq.z(this.f951a, (View.OnClickListener) gVar, "bar_view");
        this.gc.setClickListener(gVar);
    }

    private void z(ViewGroup viewGroup) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.dl = frameLayout;
        if (a()) {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        } else {
            viewGroup.addView(frameLayout, new LinearLayout.LayoutParams(-1, oq.dl(getContext(), 200.0f)));
        }
        dl();
        if (!na.g(this.g)) {
            final ImageView imageView = new ImageView(getContext());
            frameLayout.addView(imageView, -1, -1);
            com.bytedance.sdk.openadsdk.gz.g.z(this.g.jz().get(0)).config(Bitmap.Config.ARGB_4444).type(2).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.1
                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls<Bitmap> lsVar) {
                    imageView.setImageBitmap(lsVar.getResult());
                }
            });
        } else {
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            this.m = frameLayout2;
        }
    }

    private void dl() {
        if (!na.g(this.g)) {
            com.bytedance.sdk.openadsdk.gz.g.z(this.g.jz().get(0)).config(Bitmap.Config.ARGB_4444).type(2).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2
                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls<Bitmap> lsVar) {
                    Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(RewardJointEndCardFrameLayout.this.getContext(), lsVar.getResult(), 25);
                    if (bitmapZ == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapZ);
                    e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.dl != null) {
                                RewardJointEndCardFrameLayout.this.dl.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        } else {
            com.bytedance.sdk.openadsdk.gz.g.z(tf.g(this.g)).config(Bitmap.Config.ARGB_4444).type(2).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3
                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls<Bitmap> lsVar) {
                    Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(RewardJointEndCardFrameLayout.this.getContext(), lsVar.getResult(), 25);
                    if (bitmapZ == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(RewardJointEndCardFrameLayout.this.getContext().getResources(), bitmapZ);
                    e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RewardJointEndCardFrameLayout.this.m != null) {
                                RewardJointEndCardFrameLayout.this.m.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void g(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(-1);
        linearLayout.setGravity(16);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(oq.dl(getContext(), 15.0f), 0, 0, 0);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(getContext());
        tTRoundRectImageView.setBackgroundColor(0);
        linearLayout.addView(tTRoundRectImageView, new RelativeLayout.LayoutParams(oq.dl(getContext(), 40.0f), oq.dl(getContext(), 40.0f)));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        TextView textView = new TextView(getContext());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setGravity(16);
        textView.setMaxWidth(oq.dl(getContext(), 153.0f));
        textView.setSingleLine(true);
        textView.setTextColor(-16777216);
        textView.setTextSize(2, 17.0f);
        linearLayout2.addView(textView, new LinearLayout.LayoutParams(-2, oq.dl(getContext(), 27.0f)));
        TextView textView2 = new TextView(getContext());
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine(true);
        textView2.setTextColor(Color.parseColor("#4A4A4A"));
        textView2.setTextSize(2, 11.0f);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.setMarginStart(oq.dl(getContext(), 14.0f));
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView3 = new TextView(getContext());
        textView3.setBackgroundColor(Color.parseColor("#1A73E8"));
        textView3.setGravity(17);
        textView3.setTextColor(-1);
        textView3.setTextSize(2, 13.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(oq.dl(getContext(), 70.0f), oq.dl(getContext(), 24.0f));
        layoutParams2.setMarginEnd(oq.dl(getContext(), 15.0f));
        linearLayout.addView(textView3, layoutParams2);
        viewGroup.addView(linearLayout, new LinearLayout.LayoutParams(-1, oq.dl(getContext(), 60.0f)));
        this.f951a = linearLayout;
        gk gkVarKp = this.g.kp();
        if (gkVarKp != null && !TextUtils.isEmpty(gkVarKp.z())) {
            com.bytedance.sdk.openadsdk.gz.g.z(gkVarKp).to(tTRoundRectImageView);
        } else {
            tb.z(getContext(), "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
        }
        if (this.g.c() != null && !TextUtils.isEmpty(this.g.c().dl())) {
            textView.setText(this.g.c().dl());
        } else {
            textView.setText(this.g.hy());
        }
        textView2.setText(this.g.li());
        textView3.setText(this.g.no());
    }

    private void dl(ViewGroup viewGroup) {
        RewardJointBottomView rewardJointBottomView = new RewardJointBottomView(getContext(), this.g);
        this.gc = rewardJointBottomView;
        if (a()) {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, oq.dl(getContext(), 160.0f)));
        } else {
            viewGroup.addView(rewardJointBottomView, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
        rewardJointBottomView.z(iq.z(this.g));
    }

    private boolean a() {
        if (this.g.ou() == 15) {
            return true;
        }
        if (this.g.ou() == 5) {
            return false;
        }
        if (this.g.jz() == null || this.g.jz().isEmpty()) {
            return true;
        }
        gk gkVar = this.g.jz().get(0);
        return gkVar.dl() > gkVar.g();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.z.dl.m
    public boolean z(View view, View view2, int i, int i2) {
        return a();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.z.dl.m
    public void z(View view, int i, int i2, int[] iArr, int i3) {
        int iZ = z(i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gc.getLayoutParams();
        layoutParams.height -= iZ;
        this.gc.setLayoutParams(layoutParams);
        if (iZ != 0) {
            this.z.ec().j();
        }
        iArr[1] = iArr[1] + iZ;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, com.bytedance.sdk.component.widget.recycler.z.dl.gc
    public boolean onNestedPreFling(View view, float f, float f2) {
        return super.onNestedPreFling(view, f, f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int z(int r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 <= 0) goto L1f
            com.bytedance.sdk.openadsdk.core.component.reward.view.lp.RewardJointBottomView r1 = r4.gc
            int r1 = r1.getHeight()
            android.content.Context r2 = r4.getContext()
            r3 = 1128792064(0x43480000, float:200.0)
            int r2 = com.bytedance.sdk.openadsdk.core.un.oq.dl(r2, r3)
            int r1 = r1 - r2
            if (r1 > 0) goto L17
            goto L32
        L17:
            int r2 = java.lang.Math.abs(r5)
            if (r1 >= r2) goto L3b
            r5 = r1
            goto L3b
        L1f:
            android.widget.FrameLayout r1 = r4.dl
            int r1 = r1.getHeight()
            android.content.Context r2 = r4.getContext()
            r3 = 1126170624(0x43200000, float:160.0)
            int r2 = com.bytedance.sdk.openadsdk.core.un.oq.dl(r2, r3)
            int r1 = r1 - r2
            if (r1 > 0) goto L34
        L32:
            r5 = r0
            goto L3b
        L34:
            int r2 = java.lang.Math.abs(r5)
            if (r1 >= r2) goto L3b
            int r5 = -r1
        L3b:
            int r1 = java.lang.Math.abs(r5)
            r2 = 400(0x190, float:5.6E-43)
            if (r1 <= r2) goto L44
            return r0
        L44:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.RewardJointEndCardFrameLayout.z(int):int");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout.AbstractEndCardFrameLayout
    public void g() {
        super.g();
        RewardJointBottomView rewardJointBottomView = this.gc;
        if (rewardJointBottomView != null) {
            rewardJointBottomView.g();
        }
    }
}
