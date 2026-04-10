package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes3.dex */
public class TailFrameBarH5View extends LinearLayout {
    protected TextView gC;
    protected TextView gD;
    protected ValueAnimator lJ;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    public TailFrameBarH5View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void f(Context context, int i) {
        m.inflate(context, i, this);
        this.gC = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.gD = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    public final void g(boolean z, boolean z2) {
        int i;
        if (!z) {
            i = R.layout.ksad_video_tf_bar_h5_landscape;
        } else if (z2) {
            i = R.layout.ksad_video_tf_bar_h5_portrait_vertical;
        } else {
            i = R.layout.ksad_video_tf_bar_h5_portrait_horizontal;
        }
        f(getContext(), i);
    }

    public final void j(AdTemplate adTemplate) {
        AdInfo adInfoEl = e.el(adTemplate);
        this.gC.setText(com.kwad.sdk.core.response.b.a.au(adInfoEl));
        this.gD.setText(com.kwad.sdk.core.response.b.a.aE(adInfoEl));
        lu();
    }

    public TextView getH5OpenBtn() {
        return this.gD;
    }

    private void lu() {
        if (this.lJ != null) {
            lv();
            this.lJ.start();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.lJ = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1200L);
        this.lJ.setRepeatCount(-1);
        this.lJ.setRepeatMode(1);
        this.lJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.gD.setScaleY(fFloatValue);
                TailFrameBarH5View.this.gD.setScaleX(fFloatValue);
            }
        });
        this.lJ.start();
    }

    public final void lv() {
        ValueAnimator valueAnimator = this.lJ;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.lJ.cancel();
        this.lJ.end();
    }
}
