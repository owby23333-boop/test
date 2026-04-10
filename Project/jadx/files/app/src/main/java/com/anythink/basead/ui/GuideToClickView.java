package com.anythink.basead.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.anythink.basead.ui.WaveAnimImageView;
import com.anythink.core.common.k.h;

/* JADX INFO: loaded from: classes2.dex */
public class GuideToClickView extends RelativeLayout {
    WaveAnimImageView a;
    WaveAnimImageView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ImageView f6192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    float f6193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    float f6194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    float f6195f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    float f6196g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    float f6197h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    float f6198i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f6199j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f6200k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final float f6201l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    ValueAnimator f6202m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ValueAnimator f6203n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    ScaleAnimation f6204o;

    public GuideToClickView(Context context) {
        super(context);
        this.f6199j = 1000;
        this.f6200k = 200;
        this.f6201l = 0.71428573f;
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(h.a(context, "myoffer_guide_to_click", "layout"), this);
        this.f6193d = 0.8f;
        this.f6194e = 0.05f;
        this.f6195f = h.a(context, 4.0f);
        this.f6196g = h.a(context, 18.0f);
        this.f6197h = h.a(context, 2.0f);
        this.f6198i = h.a(context, 40.0f);
        this.a = (WaveAnimImageView) findViewById(h.a(context, "myoffer_wave_anim_image", "id"));
        this.b = (WaveAnimImageView) findViewById(h.a(context, "myoffer_wave_anim_image2", "id"));
        this.f6202m = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f6203n = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f6192c = (ImageView) findViewById(h.a(context, "myoffer_guide_to_click_finger", "id"));
        this.f6204o = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f);
        this.f6204o.setRepeatMode(2);
        this.f6204o.setRepeatCount(-1);
        this.f6204o.setDuration(333L);
    }

    private void b() {
        ValueAnimator valueAnimator = this.f6202m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f6203n;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ScaleAnimation scaleAnimation = this.f6204o;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnim(this.f6202m, this.a, 0L);
        startAnim(this.f6203n, this.b, 800L);
        this.f6192c.startAnimation(this.f6204o);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f6202m;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.f6203n;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ScaleAnimation scaleAnimation = this.f6204o;
        if (scaleAnimation != null) {
            scaleAnimation.cancel();
        }
    }

    public void startAnim(ValueAnimator valueAnimator, final WaveAnimImageView waveAnimImageView, long j2) {
        if (valueAnimator != null) {
            valueAnimator.setRepeatMode(1);
            valueAnimator.setRepeatCount(-1);
            valueAnimator.setDuration(1400L);
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.anythink.basead.ui.GuideToClickView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    float f2;
                    float fFloatValue = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                    if (fFloatValue > 0.71428573f) {
                        waveAnimImageView.setVisibility(4);
                        return;
                    }
                    float f3 = fFloatValue / 0.71428573f;
                    GuideToClickView guideToClickView = GuideToClickView.this;
                    float f4 = guideToClickView.f6197h;
                    float f5 = ((guideToClickView.f6198i - f4) * f3) + f4;
                    float f6 = guideToClickView.f6195f + ((guideToClickView.f6196g - f4) * f3);
                    double d2 = f3;
                    if (d2 < 0.2d) {
                        float f7 = guideToClickView.f6193d;
                        double d3 = f7;
                        double d4 = f3 * 1.0f;
                        Double.isNaN(d4);
                        double d5 = guideToClickView.f6194e - f7;
                        Double.isNaN(d5);
                        Double.isNaN(d3);
                        f2 = (float) (d3 + ((1.0d - (d4 / 0.2d)) * d5));
                    } else {
                        float f8 = guideToClickView.f6193d;
                        double d6 = f8;
                        Double.isNaN(d2);
                        double d7 = guideToClickView.f6194e - f8;
                        Double.isNaN(d7);
                        Double.isNaN(d6);
                        f2 = (float) (d6 + ((((d2 - 0.2d) * 1.0d) / 0.8d) * d7));
                    }
                    try {
                        if (GuideToClickView.this.isShown()) {
                            waveAnimImageView.setWaveAnimParams(new WaveAnimImageView.a(f5, f6, f2));
                            if (waveAnimImageView.getVisibility() != 0) {
                                waveAnimImageView.setVisibility(0);
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            valueAnimator.setStartDelay(j2);
            valueAnimator.start();
        }
    }

    public GuideToClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6199j = 1000;
        this.f6200k = 200;
        this.f6201l = 0.71428573f;
        a(context);
    }

    public GuideToClickView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f6199j = 1000;
        this.f6200k = 200;
        this.f6201l = 0.71428573f;
        a(context);
    }

    private void a() {
        startAnim(this.f6202m, this.a, 0L);
        startAnim(this.f6203n, this.b, 800L);
        this.f6192c.startAnimation(this.f6204o);
    }
}
