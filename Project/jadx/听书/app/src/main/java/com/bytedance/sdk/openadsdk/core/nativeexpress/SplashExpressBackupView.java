package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;

/* JADX INFO: loaded from: classes2.dex */
public class SplashExpressBackupView extends BackupView implements dl.InterfaceC0027dl {
    private FrameLayout fv;
    private NativeExpressView i;
    private com.bytedance.sdk.openadsdk.core.io.z.g js;
    private TextView ls;
    private Button p;
    private GifView pf;
    private dl.InterfaceC0027dl q;
    private NativeVideoTsView tb;
    private View v;

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void q_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void r_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void s_() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void z(long j, long j2) {
    }

    public SplashExpressBackupView(Context context) {
        super(context);
        this.z = context;
        this.gc = "splash_ad";
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void z(View view, int i, com.bytedance.sdk.openadsdk.core.iq.zw zwVar) {
        NativeExpressView nativeExpressView = this.i;
        if (nativeExpressView != null) {
            nativeExpressView.z(view, i, zwVar);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.io.z.g gVar, na naVar, NativeExpressView nativeExpressView) {
        this.g = naVar;
        this.i = nativeExpressView;
        this.m = oq.dl(this.z, this.i.getExpectExpressWidth());
        this.e = oq.dl(this.z, this.i.getExpectExpressWidth());
        this.js = gVar;
        m();
        this.i.addView(this, new ViewGroup.LayoutParams(-1, -1));
    }

    private void m() {
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
        z(this.g.ou(), this.g);
    }

    private void z(int i, na naVar) {
        if (!e()) {
            if (i == 5) {
                kb();
                return;
            } else {
                wp();
                return;
            }
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        i();
                        return;
                    }
                }
            }
            if (gz()) {
                i();
                return;
            } else {
                uy();
                return;
            }
        }
        fo();
    }

    private boolean e() {
        NativeExpressView nativeExpressView = this.i;
        if (nativeExpressView instanceof NativeExpressVideoView) {
            return false;
        }
        boolean z = nativeExpressView instanceof NativeExpressView;
        return true;
    }

    private boolean gz() {
        return this.g != null && this.g.zr() == 2;
    }

    private void fo() {
        v();
        this.pf.setVisibility(0);
        this.fv.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.pf.getLayoutParams();
        layoutParams.height = oq.dl(this.z, 291.0f);
        this.pf.setLayoutParams(layoutParams);
        z(this.pf, this.g, this.js);
        this.ls.setText(this.g.he());
        if (this.g.xf() != null) {
            oq.z((View) this.p, 8);
        } else {
            oq.z((View) this.p, 0);
            this.p.setText(this.g.no());
            z((View) this.p, true);
        }
        setExpressBackupListener(this.v);
    }

    private void uy() {
        v();
        this.pf.setVisibility(0);
        this.fv.setVisibility(8);
        z(this.pf, this.g, this.js);
        this.ls.setText(this.g.he());
        if (this.g.xf() != null) {
            oq.z((View) this.p, 8);
        } else {
            oq.z((View) this.p, 0);
            this.p.setText(this.g.no());
            z((View) this.p, true);
        }
        setExpressBackupListener(this.v);
    }

    private void kb() {
        v();
        this.pf.setVisibility(8);
        this.fv.setVisibility(0);
        if (tf.v(this.g) != null) {
            NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) z(this.i);
            this.tb = nativeVideoTsView;
            nativeVideoTsView.setVideoAdInteractionListener(this);
            if (this.tb == null) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.fv.addView(this.tb, layoutParams);
        }
        this.ls.setText(this.g.he());
        if (this.g.xf() != null) {
            oq.z((View) this.p, 8);
        } else {
            oq.z((View) this.p, 0);
            this.p.setText(this.g.no());
            z((View) this.p, true);
        }
        setExpressBackupListener(this.v);
    }

    private void wp() {
        NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) z(this.i);
        this.tb = nativeVideoTsView;
        nativeVideoTsView.setVideoAdInteractionListener(this);
        NativeVideoTsView nativeVideoTsView2 = this.tb;
        if (nativeVideoTsView2 == null) {
            return;
        }
        addView(nativeVideoTsView2);
        setExpressBackupListener(this);
    }

    public void setVideoAdListener(dl.InterfaceC0027dl interfaceC0027dl) {
        this.q = interfaceC0027dl;
    }

    private void i() {
        GifView gifView = new GifView(this.z);
        gifView.setScaleType(ImageView.ScaleType.FIT_XY);
        z(gifView, this.g, this.js);
        addView(gifView, new ViewGroup.LayoutParams(-1, -1));
        setExpressBackupListener(this);
    }

    private void setExpressBackupListener(View view) {
        if (this.g == null || this.g.bm() != 1) {
            return;
        }
        z(view, true);
    }

    private View z(Context context) {
        if (context == null) {
            return null;
        }
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        com.bytedance.sdk.component.utils.tb.z(context, "tt_splash_ad_backup_bg", linearLayout);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = oq.dl(context, 79.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText(com.bytedance.sdk.component.utils.tb.z(context, "tt_splash_backup_ad_title"));
        textView.setGravity(17);
        textView.setTextSize(2, 30.0f);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView.setTextColor(Color.parseColor("#895434"));
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        this.ls = textView2;
        textView2.setId(2114387471);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 218.0f, resources.getDisplayMetrics()), -2);
        layoutParams3.topMargin = oq.dl(context, 31.0f);
        layoutParams3.gravity = 1;
        this.ls.setLayoutParams(layoutParams3);
        this.ls.setGravity(1);
        this.ls.setTextSize(2, 15.0f);
        this.ls.setTextColor(Color.parseColor("#895434"));
        this.ls.setSingleLine(false);
        linearLayout.addView(this.ls);
        GifView gifView = new GifView(context);
        this.pf = gifView;
        gifView.setId(2114387470);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 219.0f, resources.getDisplayMetrics()));
        layoutParams4.topMargin = oq.dl(context, 29.0f);
        layoutParams4.setMarginStart(oq.dl(context, 15.0f));
        layoutParams4.setMarginEnd(oq.dl(context, 15.0f));
        layoutParams4.gravity = 1;
        this.pf.setLayoutParams(layoutParams4);
        this.pf.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.pf);
        FrameLayout frameLayout = new FrameLayout(context);
        this.fv = frameLayout;
        frameLayout.setId(2114387469);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 185.0f, resources.getDisplayMetrics()));
        layoutParams5.setMarginStart(oq.dl(context, 15.0f));
        layoutParams5.setMarginEnd(oq.dl(context, 15.0f));
        this.fv.setLayoutParams(layoutParams5);
        this.fv.setVisibility(8);
        linearLayout.addView(this.fv);
        Button button = new Button(context);
        this.p = button;
        button.setId(2114387468);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 145.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 43.0f, resources.getDisplayMetrics()));
        layoutParams6.topMargin = oq.dl(context, 37.0f);
        layoutParams6.gravity = 1;
        this.p.setLayoutParams(layoutParams6);
        this.p.setText(com.bytedance.sdk.component.utils.tb.z(context, "tt_splash_backup_ad_btn"));
        this.p.setTextColor(Color.parseColor("#ffffff"));
        this.p.setTypeface(Typeface.defaultFromStyle(1));
        com.bytedance.sdk.component.utils.tb.z(context, "tt_splash_ad_backup_btn_bg", this.p);
        linearLayout.addView(this.p);
        return linearLayout;
    }

    private void v() {
        View viewZ = z(this.z);
        if (viewZ == null) {
            return;
        }
        addView(viewZ);
    }

    private void z(GifView gifView) {
        gk gkVar = this.g.jz().get(0);
        if (gkVar != null) {
            com.bytedance.sdk.openadsdk.gz.g.z(gkVar).to(gifView);
        }
        if (com.bytedance.sdk.openadsdk.gc.z.a(this.g)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.gc.z.fo(this.g), com.bytedance.sdk.openadsdk.gc.z.uy(this.g));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.gc.z.z(gifView, upieImageView);
        }
    }

    void z(byte[] bArr, GifView gifView) {
        if (bArr == null || gifView == null) {
            return;
        }
        gifView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        gifView.z(bArr, false);
    }

    void z(Drawable drawable, GifView gifView) {
        if (drawable == null || gifView == null) {
            return;
        }
        gifView.setImageDrawable(drawable);
    }

    void z(GifView gifView, na naVar, com.bytedance.sdk.openadsdk.core.io.z.g gVar) {
        Drawable drawableZ;
        if (gVar == null) {
            z(gifView);
            return;
        }
        if (gVar.gc()) {
            z(gVar.dl(), gifView);
            return;
        }
        if (naVar.jz() == null || naVar.jz().get(0) == null) {
            return;
        }
        if (gVar.z() != null) {
            drawableZ = new BitmapDrawable(gVar.z());
        } else {
            drawableZ = com.bytedance.sdk.openadsdk.core.un.fv.z(gVar.dl(), naVar.jz().get(0).g());
        }
        z(drawableZ, gifView);
        if (com.bytedance.sdk.openadsdk.gc.z.a(this.g)) {
            UpieImageView upieImageView = new UpieImageView(gifView.getContext(), com.bytedance.sdk.openadsdk.gc.z.fo(this.g), com.bytedance.sdk.openadsdk.gc.z.uy(this.g));
            upieImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            com.bytedance.sdk.openadsdk.gc.z.z(gifView, upieImageView);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void z(View view, boolean z) {
        if (this.g == null || this.g.xf() == null || this.g.xf().z() != 1) {
            return;
        }
        super.z(view, z);
    }

    public com.bykv.vk.openvk.component.video.api.a.dl getVideoController() {
        NativeVideoTsView nativeVideoTsView = this.tb;
        if (nativeVideoTsView == null) {
            return null;
        }
        return nativeVideoTsView.getNativeVideoController();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl.InterfaceC0027dl
    public void t_() {
        dl.InterfaceC0027dl interfaceC0027dl = this.q;
        if (interfaceC0027dl != null) {
            interfaceC0027dl.t_();
        }
    }
}
