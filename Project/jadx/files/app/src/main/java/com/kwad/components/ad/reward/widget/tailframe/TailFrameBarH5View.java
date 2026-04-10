package com.kwad.components.ad.reward.widget.tailframe;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public class TailFrameBarH5View extends LinearLayout {
    protected TextView dP;
    protected TextView dQ;
    protected ValueAnimator iT;

    public TailFrameBarH5View(Context context) {
        this(context, null, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TailFrameBarH5View(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    private void f(Context context, int i2) {
        com.kwad.sdk.i.a.inflate(context, i2, this);
        this.dP = (TextView) findViewById(R.id.ksad_tf_h5_ad_desc);
        this.dQ = (TextView) findViewById(R.id.ksad_tf_h5_open_btn);
    }

    private void kz() {
        if (this.iT != null) {
            kA();
            this.iT.start();
        }
        this.iT = ValueAnimator.ofFloat(1.0f, 1.2f, 1.0f);
        this.iT.setDuration(1200L);
        this.iT.setRepeatCount(-1);
        this.iT.setRepeatMode(1);
        this.iT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.widget.tailframe.TailFrameBarH5View.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TailFrameBarH5View.this.dQ.setScaleY(fFloatValue);
                TailFrameBarH5View.this.dQ.setScaleX(fFloatValue);
            }
        });
        this.iT.start();
    }

    public final void bindView(@NonNull AdTemplate adTemplate) {
        AdInfo adInfoCb = d.cb(adTemplate);
        this.dP.setText(com.kwad.sdk.core.response.a.a.ao(adInfoCb));
        this.dQ.setText(com.kwad.sdk.core.response.a.a.ax(adInfoCb));
        kz();
    }

    public final void e(boolean z2, boolean z3) {
        f(getContext(), z2 ? z3 ? R.layout.ksad_video_tf_bar_h5_portrait_vertical : R.layout.ksad_video_tf_bar_h5_portrait_horizontal : R.layout.ksad_video_tf_bar_h5_landscape);
    }

    public TextView getH5OpenBtn() {
        return this.dQ;
    }

    public final void kA() {
        ValueAnimator valueAnimator = this.iT;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.iT.cancel();
        this.iT.end();
    }
}
