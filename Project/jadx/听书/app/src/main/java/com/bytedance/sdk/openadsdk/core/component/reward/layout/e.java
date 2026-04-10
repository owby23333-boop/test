package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.eo;
import com.bytedance.sdk.openadsdk.core.iq.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;

/* JADX INFO: loaded from: classes2.dex */
public class e extends g {
    private TextView fv;
    private UpieImageView js;
    private TextView ls;
    private TextView p;
    private TTRoundRectImageView pf;
    private ImageView v;

    public e(TTBaseVideoActivity tTBaseVideoActivity, na naVar, boolean z) {
        super(tTBaseVideoActivity, naVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z() {
        super.z();
        this.fo = (FrameLayout) this.g.findViewById(2114387915);
        z(this.e);
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.dl)) {
            a();
        } else {
            dl();
            g();
        }
    }

    private void g() {
        int i = (int) (this.gc * 1000.0f);
        if (i == 666 || i == 1500 || i == 1777 || i == 562 || i == 1000) {
            return;
        }
        z(this.f962a == 1 ? 0.562f : 1.777f);
    }

    private void z(View view) {
        if (this.dl == null || view == null) {
            return;
        }
        final float fVd = this.dl.vd();
        if (fVd <= 0.0f) {
            return;
        }
        view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.e.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                if (outline == null) {
                    return;
                }
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), oq.dl(zw.getContext(), fVd));
            }
        });
        view.setClipToOutline(true);
    }

    private void dl() {
        TextView textView;
        this.v = (ImageView) this.g.findViewById(2114387712);
        this.pf = (TTRoundRectImageView) this.g.findViewById(2114387722);
        this.ls = (TextView) this.g.findViewById(2114387702);
        this.p = (TextView) this.g.findViewById(2114387962);
        this.fv = (TextView) this.g.findViewById(2114387719);
        if (com.bytedance.sdk.openadsdk.gc.z.a(this.dl)) {
            UpieImageView upieImageView = new UpieImageView(this.v.getContext(), com.bytedance.sdk.openadsdk.gc.z.fo(this.dl), com.bytedance.sdk.openadsdk.gc.z.uy(this.dl));
            this.js = upieImageView;
            upieImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        if (!TextUtils.isEmpty(this.dl.no()) && (textView = this.p) != null) {
            textView.setText(this.dl.no());
        }
        if (tf.v(this.dl) != null && na.g(this.dl)) {
            oq.z((View) this.v, 8);
            oq.z((View) this.fo, 0);
        } else {
            z(this.v, this.js);
            oq.z((View) this.v, 0);
            oq.z((View) this.fo, 8);
        }
        gk gkVarKp = this.dl.kp();
        if (gkVarKp != null) {
            com.bytedance.sdk.openadsdk.gz.g.z(gkVarKp).to(this.pf);
        }
        TextView textView2 = this.ls;
        if (textView2 != null) {
            textView2.setText(v());
        }
        TextView textView3 = this.fv;
        if (textView3 != null) {
            textView3.setText(pf());
        }
        oq.z((TextView) this.g.findViewById(2114387658), this.dl);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void a(int i) {
        oq.z((View) this.kb, i);
    }

    private void a() {
        this.kb = (RelativeLayout) this.g.findViewById(2114387844);
        this.wp = (TextView) this.g.findViewById(2114387716);
        if (eo.z(this.dl)) {
            String strGz = eo.gz(this.dl);
            if (TextUtils.isEmpty(strGz)) {
                return;
            }
            com.bytedance.sdk.openadsdk.gz.g.z(strGz).config(Bitmap.Config.ARGB_4444).type(2).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.e.2
                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str, Throwable th) {
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls<Bitmap> lsVar) {
                    Bitmap bitmapZ = com.bytedance.sdk.component.adexpress.a.g.z(e.this.g, lsVar.getResult(), 25);
                    if (bitmapZ == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(e.this.g.getResources(), bitmapZ);
                    com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.e.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (e.this.e != null) {
                                e.this.e.setBackground(bitmapDrawable);
                            }
                        }
                    });
                }
            }, 4);
        }
    }

    private void z(float f) {
        float fMin;
        float fMax;
        int iMax;
        float fGc = gc();
        float fM = m();
        if (this.f962a == 2) {
            fMin = Math.max(fGc, fM);
            fMax = Math.min(fGc, fM);
        } else {
            fMin = Math.min(fGc, fM);
            fMax = Math.max(fGc, fM);
        }
        int iMin = (int) (Math.min(fMin, fMax) * this.dl.la());
        if (this.f962a != 2) {
            fMax -= oq.a(this.g, oq.kb((Context) this.g));
        }
        if (this.f962a != 2) {
            float f2 = iMin;
            iMin = (int) Math.max((fMax - (((fMin - f2) - f2) / f)) / 2.0f, 0.0f);
            iMax = iMin;
        } else {
            float f3 = iMin;
            iMax = (int) Math.max((fMin - (((fMax - f3) - f3) * f)) / 2.0f, 0.0f);
        }
        float f4 = iMin;
        float f5 = iMax;
        try {
            this.g.getWindow().getDecorView().setPadding(oq.dl(this.g, f5), oq.dl(this.g, f4), oq.dl(this.g, f5), oq.dl(this.g, f4));
        } catch (Throwable unused) {
        }
    }

    private float gc() {
        return oq.a(this.g, oq.fo((Context) this.g));
    }

    private float m() {
        return oq.a(this.g, oq.uy((Context) this.g));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.g
    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar, com.bytedance.sdk.openadsdk.core.g.g gVar2) {
        z(this.p, gVar, gVar);
        z(this.wp, gVar, gVar);
        z(this.fo, gVar2, gVar2);
        z(this.v, gVar2, gVar2);
        z(this.pf, gVar2, gVar2);
        z(this.ls, gVar2, gVar2);
        z(this.fv, gVar2, gVar2);
        z(this.e, gVar2, gVar2);
        z(this.js, gVar2, gVar2);
    }

    private void z(View view, com.bytedance.sdk.openadsdk.core.g.g gVar, View.OnTouchListener onTouchListener) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(onTouchListener);
        view.setOnClickListener(gVar);
    }
}
