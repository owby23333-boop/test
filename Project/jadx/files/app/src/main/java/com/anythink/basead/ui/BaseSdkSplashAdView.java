package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.u;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.res.b;
import com.anythink.core.common.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSdkSplashAdView extends BaseSplashAdView {
    public static final int TYPE_ASSEBLEM = 1;
    public static final int TYPE_SINGLE_PICTURE = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected RoundImageView f6151t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    ViewGroup f6152u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    TextView f6153v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    TextView f6154w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    TextView f6155x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    TextView f6156y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected final View.OnClickListener f6157z;

    public BaseSdkSplashAdView(Context context) {
        super(context);
        this.f6157z = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k kVar = BaseSdkSplashAdView.this.f6114c.f7312m;
                if (kVar == null || kVar.x() != 0) {
                    return;
                }
                BaseSdkSplashAdView.super.b(1);
            }
        };
    }

    public static boolean isSinglePicture(i iVar, k kVar) {
        return ((iVar instanceof s) && (kVar instanceof u)) ? 2 == ((u) kVar).X() : (iVar instanceof aa) && 1 == ((aa) iVar).Y();
    }

    protected abstract void b();

    protected abstract void c();

    protected void o() {
        b();
        this.f6152u = (ViewGroup) findViewById(h.a(getContext(), "myoffer_four_element_container", "id"));
        this.f6153v = (TextView) findViewById(h.a(getContext(), "myoffer_publisher_name", "id"));
        this.f6154w = (TextView) findViewById(h.a(getContext(), "myoffer_privacy_agreement", "id"));
        this.f6155x = (TextView) findViewById(h.a(getContext(), "myoffer_permission_manage", "id"));
        this.f6156y = (TextView) findViewById(h.a(getContext(), "myoffer_version_name", "id"));
        if (this.f6115d.K()) {
            ViewGroup viewGroup = this.f6152u;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            TextView textView = this.f6153v;
            if (textView != null) {
                textView.setVisibility(0);
                this.f6153v.setText(this.f6115d.F());
                this.f6129r.add(this.f6153v);
            }
            TextView textView2 = this.f6154w;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.f6154w.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        l.b(n.a().g(), BaseSdkSplashAdView.this.f6115d.H());
                    }
                });
            }
            TextView textView3 = this.f6155x;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.f6155x.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        l.b(n.a().g(), BaseSdkSplashAdView.this.f6115d.I());
                    }
                });
            }
            TextView textView4 = this.f6156y;
            if (textView4 != null) {
                textView4.setVisibility(0);
                this.f6156y.setText(getContext().getResources().getString(h.a(getContext(), "myoffer_panel_version", com.anythink.expressad.foundation.h.i.f10649g), this.f6115d.G()));
                this.f6129r.add(this.f6156y);
            }
        } else {
            ViewGroup viewGroup2 = this.f6152u;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            TextView textView5 = this.f6156y;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.f6153v;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            TextView textView7 = this.f6154w;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            TextView textView8 = this.f6155x;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
            try {
                View viewFindViewById = findViewById(h.a(getContext(), "myoffer_four_element_container_bg", "id"));
                if (viewFindViewById != null) {
                    viewFindViewById.setBackgroundDrawable(null);
                }
            } catch (Throwable unused) {
            }
        }
        this.f6151t = (RoundImageView) findViewById(h.a(getContext(), "myoffer_ad_logo", "id"));
        final ViewGroup.LayoutParams layoutParams = this.f6151t.getLayoutParams();
        if (!TextUtils.isEmpty(this.f6115d.v())) {
            this.f6151t.setVisibility(0);
            int i2 = layoutParams.width;
            com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.f6115d.v()), i2, i2, new b.a() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.4
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                    BaseSdkSplashAdView.this.f6151t.setVisibility(8);
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(str, BaseSdkSplashAdView.this.f6115d.v())) {
                        ViewGroup.LayoutParams layoutParams2 = layoutParams;
                        int i3 = layoutParams2.height;
                        layoutParams2.width = (int) (i3 * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                        layoutParams2.height = i3;
                        BaseSdkSplashAdView.this.f6151t.setLayoutParams(layoutParams2);
                        BaseSdkSplashAdView.this.f6151t.setScaleType(ImageView.ScaleType.FIT_XY);
                        BaseSdkSplashAdView.this.f6151t.setImageBitmap(bitmap);
                        BaseSdkSplashAdView.this.f6151t.setVisibility(0);
                    }
                }
            });
        } else if (this.f6115d.J() != null) {
            Bitmap bitmapJ = this.f6115d.J();
            int i3 = layoutParams.height;
            layoutParams.width = (int) (i3 * ((bitmapJ.getWidth() * 1.0f) / bitmapJ.getHeight()));
            layoutParams.height = i3;
            this.f6151t.setLayoutParams(layoutParams);
            this.f6151t.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f6151t.setImageBitmap(bitmapJ);
            this.f6151t.setImageBitmap(this.f6115d.J());
            this.f6151t.setVisibility(0);
        } else {
            this.f6151t.setVisibility(8);
        }
        this.f6129r.add(this.f6151t);
        q();
        r();
    }

    @Override // com.anythink.basead.ui.BaseSplashAdView, com.anythink.basead.ui.BaseAdView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.anythink.basead.ui.BaseSplashAdView, com.anythink.basead.ui.BaseAdView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.anythink.basead.ui.BaseSplashAdView
    protected void p() {
        super.p();
        setOnClickListener(this.f6157z);
    }

    @Override // com.anythink.basead.ui.BaseSplashAdView, com.anythink.basead.ui.BaseAdView
    protected final void a(int i2) {
        com.anythink.basead.e.a aVar = this.F;
        if (aVar != null) {
            aVar.onAdClick(i2);
        }
        GuideToClickView guideToClickView = this.J;
        if (guideToClickView != null) {
            guideToClickView.setVisibility(8);
        }
    }

    public BaseSdkSplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
        this.f6157z = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k kVar = BaseSdkSplashAdView.this.f6114c.f7312m;
                if (kVar == null || kVar.x() != 0) {
                    return;
                }
                BaseSdkSplashAdView.super.b(1);
            }
        };
        c();
        p();
        a(this.B, this.f6114c.f7312m.h());
    }
}
