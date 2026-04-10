package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;

/* JADX INFO: loaded from: classes3.dex */
public class SplashPlayDefaultInfoView extends FrameLayout {
    private KSCornerImageView IY;
    private ImageView IZ;
    private TextView Ja;
    private TextView fv;
    private TextView ko;

    public SplashPlayDefaultInfoView(Context context) {
        super(context);
        ne();
    }

    public SplashPlayDefaultInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ne();
    }

    public SplashPlayDefaultInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ne();
    }

    public SplashPlayDefaultInfoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        ne();
    }

    private void ne() {
        inflate(getContext(), R.layout.ksad_play_card_default_info, this);
        this.IY = (KSCornerImageView) findViewById(R.id.ksad_splash_default_icon);
        this.ko = (TextView) findViewById(R.id.ksad_splash_default_title);
        this.IZ = (ImageView) findViewById(R.id.ksad_splash_default_img);
        this.fv = (TextView) findViewById(R.id.ksad_splash_default_desc);
        this.Ja = (TextView) findViewById(R.id.ksad_splash_default_tips);
    }

    public final void a(AdTemplate adTemplate, float f) {
        c cVarNc;
        AdInfo adInfoEl = e.el(adTemplate);
        if (com.kwad.sdk.core.response.b.a.dn(adInfoEl)) {
            cVarNc = c.c(f);
        } else {
            cVarNc = c.nc();
        }
        a(cVarNc);
        this.IY.setRadius(com.kwad.sdk.c.a.a.a(getContext(), cVarNc.nd()));
        KSImageLoader.loadImage(this.IY, com.kwad.sdk.core.response.b.a.co(adInfoEl), adTemplate);
        this.ko.setText(com.kwad.sdk.core.response.b.a.cl(adInfoEl));
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.au(adInfoEl))) {
            this.fv.setVisibility(8);
        } else {
            this.fv.setText(com.kwad.sdk.core.response.b.a.au(adInfoEl));
        }
    }

    private void a(c cVar) {
        ak.a(this, cVar.W(getContext()));
        ak.a(this.IY, cVar.X(getContext()));
        ak.a(this.ko, cVar.Y(getContext()));
        ak.a(this.IZ, cVar.Z(getContext()));
        ak.a(this.fv, cVar.aa(getContext()));
        ak.a(this.Ja, cVar.ab(getContext()));
        this.ko.setTextSize(0, cVar.ac(getContext()));
        this.fv.setTextSize(0, cVar.ad(getContext()));
        this.Ja.setTextSize(0, cVar.ae(getContext()));
    }
}
