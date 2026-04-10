package com.amgcyo.cuttadon.sdk.self.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView;
import com.amgcyo.cuttadon.utils.otherutils.n;
import com.amgcyo.cuttadon.view.otherview.SelfAdLogoFrameLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.g;
import com.bumptech.glide.request.k.j;
import me.jessyan.art.f.e;
import me.jessyan.art.http.imageloader.glide.ImageConfigImpl;

/* JADX INFO: loaded from: classes.dex */
public class SelfBannerAdView extends BaseSelfRenderView {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private me.jessyan.art.c.e.c f4203s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Context f4204t;

    class a implements g<Drawable> {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ ImageView f4205s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ SelfAdLogoFrameLayout f4206t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ NewApiAd f4207u;

        a(ImageView imageView, SelfAdLogoFrameLayout selfAdLogoFrameLayout, NewApiAd newApiAd) {
            this.f4205s = imageView;
            this.f4206t = selfAdLogoFrameLayout;
            this.f4207u = newApiAd;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(@Nullable GlideException glideException, Object obj, j<Drawable> jVar, boolean z2) {
            SelfBannerAdView selfBannerAdView = SelfBannerAdView.this;
            selfBannerAdView.a(this.f4205s, 8, selfBannerAdView.f4204t);
            SelfBannerAdView.this.setAdLogoStatus(this.f4206t);
            return false;
        }

        @Override // com.bumptech.glide.request.g
        public boolean a(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z2) {
            SelfBannerAdView selfBannerAdView = SelfBannerAdView.this;
            selfBannerAdView.a(selfBannerAdView.f4204t, this.f4207u);
            SelfBannerAdView.this.getViewHeight();
            SelfBannerAdView.this.setAdLogoStatus(this.f4206t);
            return false;
        }
    }

    public SelfBannerAdView(@NonNull Context context) {
        super(context);
        a(context);
    }

    @Override // com.amgcyo.cuttadon.sdk.ui.BaseSelfRenderView
    public void a() {
    }

    public SelfBannerAdView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SelfBannerAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @SuppressLint({"InflateParams"})
    private void a(Context context) {
        if (isInEditMode()) {
            return;
        }
        this.f4204t = context;
        this.f4203s = e.a(this.f4204t).imageLoader();
    }

    public void a(final NewApiAd newApiAd, boolean z2) {
        removeAllViews();
        if (newApiAd != null) {
            SelfAdLogoFrameLayout selfAdLogoFrameLayout = new SelfAdLogoFrameLayout(this.f4204t);
            ImageView iv_native_image = selfAdLogoFrameLayout.getIv_native_image();
            String image = newApiAd.getImage();
            if (!TextUtils.isEmpty(image)) {
                this.f4203s.a(this.f4204t, ImageConfigImpl.builder().url(image).imageRadius(8).isNeedPlaceholder(false).imageView(iv_native_image).listener(new a(iv_native_image, selfAdLogoFrameLayout, newApiAd)).build());
                setOnClickListener(new View.OnClickListener() { // from class: com.amgcyo.cuttadon.sdk.self.view.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f4242s.a(newApiAd, view);
                    }
                });
            }
            if (z2) {
                o.a(iv_native_image, 0, 0, 0, 0);
            } else {
                int iA = n.a(5.0f);
                o.a(iv_native_image, iA, 0, iA, 0);
                selfAdLogoFrameLayout.setLogoImgeViewMargin(iA);
            }
            addView(selfAdLogoFrameLayout);
        }
    }

    public /* synthetic */ void a(NewApiAd newApiAd, View view) {
        com.amgcyo.cuttadon.h.h.a.a(this.f4204t, newApiAd);
    }
}
