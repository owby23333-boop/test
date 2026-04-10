package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.component.reward.a.dl;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.nativeexpress.uy;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.g.z;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import com.bytedance.sdk.openadsdk.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends RecyclerView.zw implements l.z {
    private LinearLayout eo;
    public ViewGroup fv;
    private boolean gk;
    private boolean h;
    protected final AtomicBoolean hh;
    public TTProgressBar io;
    public FrameLayout iq;
    public FrameLayout js;
    private boolean l;
    private boolean lq;
    private int mc;
    private final AnimatorSet oq;
    public FullRewardExpressView p;
    public FrameLayout q;
    protected final AtomicBoolean sy;
    public FrameLayout tb;
    private final l ti;
    public a uf;
    private dl.z un;
    private int wj;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.g x;
    public FrameLayout zw;

    public gc(View view) {
        super(view);
        this.ti = new l(Looper.getMainLooper(), this);
        this.oq = new AnimatorSet();
        this.sy = new AtomicBoolean(false);
        this.hh = new AtomicBoolean(false);
        this.wj = Integer.MAX_VALUE;
        this.fv = (ViewGroup) view.findViewById(2114387892);
        this.js = (FrameLayout) view.findViewById(2114387778);
        this.tb = (FrameLayout) view.findViewById(2114387812);
        this.q = (FrameLayout) view.findViewById(2114387670);
        this.iq = (FrameLayout) view.findViewById(2114387821);
        this.zw = (FrameLayout) view.findViewById(2114387679);
        this.io = (TTProgressBar) view.findViewById(2114387767);
        z(view.getContext());
    }

    public void z(final com.bytedance.sdk.openadsdk.core.component.reward.draw.g gVar, float f, float f2) {
        this.x = gVar;
        this.io.setVisibility(0);
        wj();
        this.p = gVar.g(f, f2);
        if (gVar.gc) {
            if (this.p.q()) {
                this.iq.setVisibility(8);
                this.zw.addView(z(this.z.getContext(), gVar));
                this.zw.setVisibility(0);
            } else {
                this.p.z((ViewGroup) this.js, false);
            }
            this.mc = this.p.getDynamicShowType();
            this.gk = true;
            gk();
            this.io.setVisibility(8);
        } else {
            this.p.setExpressInteractionListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.gc.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.z
                public void z(View view, float f3, float f4) {
                    if (gc.this.p.q()) {
                        gc.this.iq.setVisibility(8);
                        gc.this.zw.addView(gc.this.z(view.getContext(), gVar));
                        gc.this.zw.setVisibility(0);
                    } else {
                        gc.this.p.z((ViewGroup) gc.this.js, false);
                    }
                    gc gcVar = gc.this;
                    gcVar.mc = gcVar.p.getDynamicShowType();
                    gc.this.gk = true;
                    gc.this.gk();
                    gc.this.io.setVisibility(8);
                }
            });
        }
        this.p.setExpressVideoListenerProxy(new uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.gc.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void dl(int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void e() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void fo() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void gc() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public long getActualPlayDuration() {
                return 0L;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void gz() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void kb() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void m() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void setPauseFromExpressView(boolean z2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void uy() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(float f3) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(int i, String str) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(boolean z2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(int i) {
                if (gc.this.uf == null) {
                    return;
                }
                if (i == 2) {
                    gc.this.uf.e(true);
                    if (gc.this.h) {
                        gc.this.un.z();
                        gc.this.lq();
                        return;
                    }
                    return;
                }
                if (i != 3) {
                    return;
                }
                gc.this.hh.set(false);
                gc.this.uf.e(false);
                if (gc.this.h) {
                    gc.this.un.g();
                    gc.this.mc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public long z() {
                return gc.this.uf.kb();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public int g() {
                if (gc.this.sy.get()) {
                    return 4;
                }
                if (gc.this.uf == null || !gc.this.lq) {
                    return 2;
                }
                if (gc.this.uf.sv()) {
                    return 5;
                }
                if (gc.this.uf.iq()) {
                    return 1;
                }
                if (gc.this.uf.f()) {
                    return 2;
                }
                gc.this.uf.io();
                return 3;
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public int dl() {
                if (gc.this.uf == null) {
                    return 0;
                }
                return (int) (gc.this.uf.kb() / 1000);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void z(float f3, float f4, float f5, float f6, int i) {
                gc.this.z(f3, f4, f5, f6, i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void a() {
                gc.this.hh.set(true);
                if (gc.this.h) {
                    gc.this.un.z();
                    gc.this.x.g(false);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
            public void g(int i) {
                gc.this.un.z(i);
            }
        });
        this.p.setOnVideoSizeChangeListener(new FullRewardExpressView.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.gc.3
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView.z
            public void z(int i) {
                gc.this.wj = i;
            }
        });
        this.iq.addView(this.p);
        a aVar = new a(this.fv.getContext(), this.tb, gVar.z());
        this.uf = aVar;
        this.p.setVideoController(aVar);
        gVar.z(this.tb, this.q, this.p);
        this.uf.z(new g(gVar.gc(), y.dl(this.x.z()), new g.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.gc.4
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.gc.g.z
            public void z(boolean z2) {
                gc.this.a(z2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.gc.g.z
            public void z() {
                gc.this.un.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.gc.g.z
            public void z(long j, long j2) {
                gc.this.un.z(j, j2);
            }
        }, this.ti));
        this.uf.g(this.x.kb());
        this.p.fv();
    }

    public View z(Context context, com.bytedance.sdk.openadsdk.core.component.reward.draw.g gVar) {
        String strNo;
        View viewV = com.bytedance.sdk.openadsdk.res.gc.v(context);
        RelativeLayout relativeLayout = (RelativeLayout) viewV.findViewById(2114387649);
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) viewV.findViewById(2114387793);
        TextView textView = (TextView) viewV.findViewById(2114387875);
        TextView textView2 = (TextView) viewV.findViewById(2114387630);
        TextView textView3 = (TextView) viewV.findViewById(2114387830);
        TTRatingBar tTRatingBar = (TTRatingBar) viewV.findViewById(2114387609);
        if (tTRatingBar != null) {
            tTRatingBar.setStarEmptyNum(1);
            tTRatingBar.setStarFillNum(4);
            tTRatingBar.setStarImageWidth(oq.dl(context, 15.0f));
            tTRatingBar.setStarImageHeight(oq.dl(context, 14.0f));
            tTRatingBar.setStarImagePadding(oq.dl(context, 4.0f));
            tTRatingBar.z();
        }
        if (tTRoundRectImageView != null) {
            gk gkVarKp = gVar.z().kp();
            if (gkVarKp != null && !TextUtils.isEmpty(gkVarKp.z())) {
                com.bytedance.sdk.openadsdk.gz.g.z(gkVarKp).to(tTRoundRectImageView);
            } else {
                tb.z(context, "tt_ad_logo_small", (ImageView) tTRoundRectImageView);
            }
        }
        if (textView != null) {
            if (gVar.z().c() != null && !TextUtils.isEmpty(gVar.z().c().dl())) {
                textView.setText(gVar.z().c().dl());
            } else {
                textView.setText(gVar.z().li());
            }
        }
        if (textView2 != null) {
            int iM = gVar.z().c() != null ? gVar.z().c().m() : 6870;
            textView2.setText(String.format(tb.z(context, "tt_comment_num"), iM > 10000 ? (iM / 10000) + "万" : String.valueOf(iM)));
        }
        if (textView3 != null) {
            if (TextUtils.isEmpty(gVar.z().no())) {
                strNo = gVar.z().lt() != 4 ? "查看详情" : "立即下载";
            } else {
                strNo = gVar.z().no();
            }
            textView3.setText(strNo);
        }
        oq.z((View) relativeLayout, (View.OnClickListener) gVar.dl(), "reward_draw_listener");
        return viewV;
    }

    private void wj() {
        FullRewardExpressView fullRewardExpressView = this.p;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
        this.wj = Integer.MAX_VALUE;
        this.gk = false;
        this.h = false;
        this.lq = false;
        this.tb.removeAllViews();
        this.q.removeAllViews();
        this.iq.removeAllViews();
        this.zw.removeAllViews();
        this.sy.set(false);
        this.hh.set(false);
        this.js.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        a aVar = this.uf;
        if (aVar != null) {
            aVar.uy();
        }
    }

    public void g(boolean z2) {
        if (this.h == z2) {
            return;
        }
        this.h = z2;
        if (z2) {
            gk();
            return;
        }
        lq();
        oq.z((View) this.eo, 8);
        this.oq.cancel();
    }

    public void hh() {
        if (this.oq.isStarted() && this.oq.isRunning()) {
            this.oq.pause();
        }
    }

    public void l() {
        if (this.oq.isStarted() && this.oq.isPaused()) {
            this.oq.resume();
        }
    }

    public void h() {
        if (this.oq.isStarted() && this.oq.isRunning()) {
            this.oq.cancel();
        }
    }

    public void gk() {
        if (this.uf != null && this.h && this.gk) {
            this.x.fo();
            this.p.ls();
            if (this.lq && this.uf.io()) {
                dl(this.x.m());
                mc();
            } else {
                this.lq = true;
                this.ti.sendEmptyMessageDelayed(101, 5000L);
                this.x.z(this.p);
                this.uf.z(this.x.uy());
            }
        }
    }

    public long x() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.g gVar = this.x;
        if (gVar == null) {
            return -1L;
        }
        return gVar.kb();
    }

    public void lq() {
        a aVar = this.uf;
        if (aVar != null) {
            aVar.m();
        }
    }

    public void mc() {
        a aVar = this.uf;
        if (aVar != null) {
            aVar.gz();
        }
    }

    public void un() {
        FullRewardExpressView fullRewardExpressView = this.p;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.i();
        }
        a aVar = this.uf;
        if (aVar != null) {
            aVar.fo();
        }
    }

    public void dl(boolean z2) {
        a aVar = this.uf;
        if (aVar != null) {
            aVar.g(z2);
        }
    }

    public com.bykv.vk.openvk.component.video.api.a.dl ti() {
        return this.uf;
    }

    public boolean eo() {
        a aVar = this.uf;
        if (aVar == null) {
            return false;
        }
        return aVar.uf();
    }

    public boolean oq() {
        return this.hh.get();
    }

    private void z(Context context) {
        if (this.l) {
            LinearLayout linearLayout = new LinearLayout(context);
            this.eo = linearLayout;
            linearLayout.setClipChildren(false);
            this.eo.setGravity(1);
            this.eo.setOrientation(1);
            ImageView imageView = new ImageView(context);
            tb.z(context, "tt_ic_back_light", imageView);
            this.eo.addView(imageView, -1, -2);
            ImageView imageView2 = new ImageView(context);
            tb.z(context, "tt_ic_back_light", imageView2);
            imageView2.setAlpha(0.7f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = oq.dl(context, -8.0f);
            this.eo.addView(imageView2, layoutParams);
            TextView textView = new TextView(context);
            textView.setGravity(1);
            textView.setTextColor(-1);
            textView.setText("上滑浏览更多内容");
            this.eo.addView(textView);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 81;
            layoutParams2.bottomMargin = oq.dl(context, 156.0f);
            this.fv.addView(this.eo, layoutParams2);
            this.fv.setClipChildren(false);
            this.eo.setVisibility(8);
            z(imageView, imageView2);
        }
    }

    private void z(View view, View view2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setInterpolator(new z());
        objectAnimatorOfFloat.setDuration(1300L);
        objectAnimatorOfFloat.setStartDelay(700L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, oq.dl(this.fv.getContext(), -5.0f));
        objectAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat2.setDuration(1300L);
        objectAnimatorOfFloat2.setStartDelay(700L);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat3.setInterpolator(new z());
        objectAnimatorOfFloat3.setDuration(1300L);
        objectAnimatorOfFloat3.setStartDelay(500L);
        objectAnimatorOfFloat3.setRepeatCount(-1);
        objectAnimatorOfFloat3.setRepeatMode(1);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(view2, "translationY", oq.dl(this.fv.getContext(), -6.0f));
        objectAnimatorOfFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, -0.3f, 1.0f));
        objectAnimatorOfFloat4.setDuration(1300L);
        objectAnimatorOfFloat4.setStartDelay(500L);
        objectAnimatorOfFloat4.setRepeatCount(-1);
        objectAnimatorOfFloat4.setRepeatMode(1);
        this.oq.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat3, objectAnimatorOfFloat2, objectAnimatorOfFloat4);
    }

    public void z(View view) {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.g gVar = this.x;
        if (gVar == null || gVar.dl() == null) {
            return;
        }
        this.x.dl().onClick(view);
    }

    private static class z implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return f <= 0.38f ? f * 2.631579f : (f * (-1.6129032f)) + 1.6129032f;
        }

        private z() {
        }
    }

    public void z(float f, float f2, float f3, float f4, int i) {
        FullRewardExpressView fullRewardExpressView = this.p;
        if (fullRewardExpressView == null || fullRewardExpressView.getVideoFrameLayout() == null) {
            return;
        }
        int measuredWidth = this.p.getVideoFrameLayout().getMeasuredWidth();
        int measuredHeight = this.p.getVideoFrameLayout().getMeasuredHeight();
        if (this.uf.gb()) {
            this.p.getVideoFrameLayout().animate().translationY(-(measuredHeight * (1.0f - f2))).setDuration(i).start();
        } else {
            ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f, 1.0f, f2, measuredWidth * f3, measuredHeight * f4);
            scaleAnimation.setFillAfter(true);
            scaleAnimation.setDuration(i);
            this.p.getVideoFrameLayout().startAnimation(scaleAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        if (this.h) {
            if (this.wj > oq.gc(this.z.getContext()) * 0.7f) {
                oq.z((View) this.eo, 0);
                this.oq.start();
            }
            if (!z2 || this.sy.get()) {
                return;
            }
            this.sy.set(true);
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what != 101) {
            return;
        }
        a(true);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.g gVar = this.x;
        if (gVar != null) {
            gVar.e();
        }
    }

    public void z(dl.z zVar) {
        a aVar;
        this.un = zVar;
        if (zVar == null || (aVar = this.uf) == null) {
            return;
        }
        aVar.g(zVar.dl());
    }

    private static class g implements z.InterfaceC0210z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f947a;
        private boolean dl = false;
        private final z g;
        private final l gc;
        private final z.InterfaceC0210z z;

        interface z {
            void z();

            void z(long j, long j2);

            void z(boolean z);
        }

        g(z.InterfaceC0210z interfaceC0210z, int i, z zVar, l lVar) {
            this.z = interfaceC0210z;
            this.g = zVar;
            this.f947a = i;
            this.gc = lVar;
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void z() {
            this.dl = false;
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.z();
            }
            z zVar = this.g;
            if (zVar != null) {
                zVar.z();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void z(int i, String str) {
            z(true);
            this.dl = false;
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.z(i, str);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void g() {
            z(true);
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.g();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void z(long j, long j2) {
            this.gc.removeMessages(101);
            if (j2 > 20000 && j > Math.min(((long) this.f947a) * 1000, j2) * 0.75f) {
                z(false);
                this.dl = true;
            }
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.z(j, j2);
            }
            z zVar = this.g;
            if (zVar != null) {
                zVar.z(j, j2);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.video.g.z.InterfaceC0210z
        public void dl() {
            z.InterfaceC0210z interfaceC0210z = this.z;
            if (interfaceC0210z != null) {
                interfaceC0210z.dl();
            }
        }

        private void z(boolean z2) {
            z zVar;
            if (this.dl || (zVar = this.g) == null) {
                return;
            }
            zVar.z(z2);
        }
    }
}
