package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.bytedance.sdk.component.adexpress.dynamic.d.m;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.component.utils.pe;

/* JADX INFO: loaded from: classes.dex */
public class WriggleGuideAnimationView extends LinearLayout {
    private ImageView bf;
    private pe d;
    private TextView e;
    private e ga;
    private WriggleGuideView p;
    private TextView tg;
    private m v;
    private LinearLayout vn;

    public interface e {
        void e();
    }

    public WriggleGuideAnimationView(Context context, int i, m mVar) {
        super(context);
        this.v = mVar;
        e(context, i);
    }

    public TextView getTopTextView() {
        return this.e;
    }

    public LinearLayout getWriggleLayout() {
        return this.vn;
    }

    public WriggleGuideView getWriggleProgressIv() {
        return this.p;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.d == null) {
                this.d = new pe(getContext().getApplicationContext(), 2);
            }
            this.d.e(new pe.e() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.2
                @Override // com.bytedance.sdk.component.utils.pe.e
                public void e(int i) {
                    if (i == 2 && WriggleGuideAnimationView.this.isShown() && WriggleGuideAnimationView.this.ga != null) {
                        WriggleGuideAnimationView.this.ga.e();
                    }
                }
            });
            if (this.v != null) {
                this.d.bf(r0.d());
                this.d.bf(this.v.ga());
            }
            this.d.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pe peVar = this.d;
        if (peVar != null) {
            peVar.bf();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        pe peVar = this.d;
        if (peVar != null) {
            if (z) {
                peVar.e();
            } else {
                peVar.bf();
            }
        }
    }

    public void setOnShakeViewListener(e eVar) {
        this.ga = eVar;
    }

    public void setShakeText(String str) {
        this.tg.setText(str);
    }

    private void e(Context context, int i) {
        View.inflate(context, i, this);
        this.vn = (LinearLayout) findViewById(dt.ga(context, "tt_interact_splash_wriggle_layout"));
        this.bf = (ImageView) findViewById(dt.ga(context, "tt_interact_splash_top_img"));
        this.p = (WriggleGuideView) findViewById(dt.ga(context, "tt_interact_splash_progress_img"));
        this.e = (TextView) findViewById(dt.ga(context, "tt_interact_splash_top_text"));
        this.tg = (TextView) findViewById(dt.ga(context, "tt_interact_splash_click_bar_text"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.vn.setBackground(gradientDrawable);
    }

    public void e() {
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                if (WriggleGuideAnimationView.this.bf != null) {
                    ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(WriggleGuideAnimationView.this.bf, PropertyValuesHolder.ofKeyframe(Key.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.095f, -30.0f), Keyframe.ofFloat(0.285f, 30.0f), Keyframe.ofFloat(0.38f, 0.0f), Keyframe.ofFloat(0.475f, -30.0f), Keyframe.ofFloat(0.665f, 30.0f), Keyframe.ofFloat(0.76f, 0.0f)));
                    objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
                    objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
                    objectAnimatorOfPropertyValuesHolder.setDuration(4200L).start();
                }
            }
        }, 500L);
    }
}
