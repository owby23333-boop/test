package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.r.o;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.k;

/* JADX INFO: loaded from: classes2.dex */
public class DrawCardH5 extends FrameLayout implements View.OnClickListener {
    private a dA;
    private ImageView dB;
    private TextView dC;
    private TextView dD;
    private ValueAnimator dy;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private int mHeight;
    private KsLogoView mLogoView;

    public interface a {
        void aD();

        void aE();
    }

    public DrawCardH5(Context context) {
        super(context);
        D(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawCardH5(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        D(context);
    }

    private void D(Context context) {
        this.mContext = context;
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_draw_card_h5, this);
        this.dB = (ImageView) findViewById(R.id.ksad_card_close);
        this.dC = (TextView) findViewById(R.id.ksad_card_ad_desc);
        this.dD = (TextView) findViewById(R.id.ksad_card_h5_open_btn);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_draw_h5_logo);
    }

    private void aM() {
        ValueAnimator valueAnimator = this.dy;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.dy.cancel();
        }
    }

    private void aW() {
        d(this.mHeight, 0);
    }

    private void d(int i2, int i3) {
        aM();
        this.dy = o.b(this, i2, i3);
        this.dy.setInterpolator(new DecelerateInterpolator(2.0f));
        this.dy.setDuration(300L);
        this.dy.start();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoCb = d.cb(this.mAdTemplate);
        this.dA = aVar;
        this.dC.setText(com.kwad.sdk.core.response.a.a.ao(adInfoCb));
        this.dD.setText(com.kwad.sdk.core.response.a.a.ax(adInfoCb));
        this.dB.setOnClickListener(this);
        this.dD.setOnClickListener(this);
        this.mLogoView.U(adTemplate);
        setOnClickListener(this);
        this.dC.measure(View.MeasureSpec.makeMeasureSpec((k.getScreenWidth(this.mContext) - (com.kwad.sdk.b.kwai.a.a(this.mContext, 16.0f) * 2)) - (com.kwad.sdk.b.kwai.a.a(this.mContext, 10.0f) * 2), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.mHeight = com.kwad.sdk.b.kwai.a.a(this.mContext, 100.0f) + this.dC.getMeasuredHeight();
    }

    public final void aU() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.dB) {
            com.kwad.components.core.d.b.a.a(new a.C0395a(getContext()).J(this.mAdTemplate).a(new a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardH5.1
                @Override // com.kwad.components.core.d.b.a.b
                public final void onAdClicked() {
                    if (DrawCardH5.this.dA != null) {
                        DrawCardH5.this.dA.aE();
                    }
                }
            }));
            return;
        }
        aW();
        a aVar = this.dA;
        if (aVar != null) {
            aVar.aD();
        }
    }

    public final void release() {
        aM();
    }
}
