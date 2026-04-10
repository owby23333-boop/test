package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.anythink.core.common.res.b;
import com.anythink.core.common.ui.component.RoundImageView;

/* JADX INFO: loaded from: classes2.dex */
public class SinglePictureSplashAdView extends BaseSdkSplashAdView {
    public SinglePictureSplashAdView(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashAdView
    protected final void b() {
        TextView textView = (TextView) findViewById(h.a(getContext(), "myoffer_splash_ad_install_btn", "id"));
        final RoundImageView roundImageView = (RoundImageView) findViewById(h.a(getContext(), "myoffer_splash_bg", "id"));
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(1, this.f6115d.u()), getResources().getDisplayMetrics().widthPixels, (getResources().getDisplayMetrics().widthPixels * 627) / 1200, new b.a() { // from class: com.anythink.basead.ui.SinglePictureSplashAdView.1
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, final Bitmap bitmap) {
                if (TextUtils.equals(str, SinglePictureSplashAdView.this.f6115d.u())) {
                    SinglePictureSplashAdView singlePictureSplashAdView = SinglePictureSplashAdView.this;
                    final WrapRoundImageView wrapRoundImageView = (WrapRoundImageView) singlePictureSplashAdView.findViewById(h.a(singlePictureSplashAdView.getContext(), "myoffer_splash_ad_content_image_area", "id"));
                    if (SinglePictureSplashAdView.this.f6114c.f7312m.j() == 2) {
                        wrapRoundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        wrapRoundImageView.setImageBitmap(bitmap);
                    } else {
                        wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        wrapRoundImageView.post(new Runnable() { // from class: com.anythink.basead.ui.SinglePictureSplashAdView.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                wrapRoundImageView.setBitmapAndResize(bitmap, SinglePictureSplashAdView.this.getWidth(), SinglePictureSplashAdView.this.getHeight());
                            }
                        });
                    }
                    if (roundImageView != null) {
                        roundImageView.setImageBitmap(com.anythink.core.common.k.b.a(SinglePictureSplashAdView.this.getContext(), bitmap));
                    }
                }
            }
        });
        k kVar = this.f6114c.f7312m;
        if (kVar == null || textView == null) {
            return;
        }
        if (kVar.x() == 0 || m()) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        if (TextUtils.isEmpty(this.f6115d.w())) {
            textView.setText(com.anythink.basead.a.e.a(getContext(), this.f6115d));
        } else {
            textView.setText(this.f6115d.w());
        }
        this.f6129r.add(textView);
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashAdView
    protected final void c() {
        super.a(this.f6114c.f7312m.R() < 0 ? 100 : this.f6114c.f7312m.R(), new Runnable() { // from class: com.anythink.basead.ui.SinglePictureSplashAdView.2
            @Override // java.lang.Runnable
            public final void run() {
                SinglePictureSplashAdView singlePictureSplashAdView = SinglePictureSplashAdView.this;
                if (singlePictureSplashAdView.F == null) {
                    return;
                }
                int width = singlePictureSplashAdView.getWidth();
                int height = SinglePictureSplashAdView.this.getHeight();
                int i2 = SinglePictureSplashAdView.this.getResources().getDisplayMetrics().widthPixels;
                int i3 = SinglePictureSplashAdView.this.getResources().getDisplayMetrics().heightPixels;
                double d2 = i2;
                Double.isNaN(d2);
                int i4 = (int) (d2 * 0.5d);
                double d3 = i3;
                Double.isNaN(d3);
                int i5 = (int) (d3 * 0.5d);
                if (width < i4) {
                    SinglePictureSplashAdView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, "Splash display width is less than 50% of screen width!"));
                } else if (height < i5) {
                    SinglePictureSplashAdView.this.a(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5907k, "Splash display height is less than 50% of screen height!"));
                } else {
                    SinglePictureSplashAdView.super.h();
                }
            }
        });
    }

    public SinglePictureSplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a() {
        if (this.f6114c.f7312m.q() == 2) {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_splash_ad_layout_single_land", "layout"), this);
        } else {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_splash_ad_layout_single_port", "layout"), this);
        }
        o();
    }
}
