package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class DynamicUnlockView extends FrameLayout {
    private final ImageView bf;
    private final FlowLightView d;
    private final TextView e;
    private final RotateAnimation tg;

    public DynamicUnlockView(Context context) {
        super(context);
        View.inflate(context, dt.vn(getContext(), "tt_dynamic_splash_interact_unlock"), this);
        this.e = (TextView) findViewById(dt.ga(getContext(), "tt_splash_unlock_text"));
        this.bf = (ImageView) findViewById(dt.ga(getContext(), "tt_splash_unlock_go"));
        this.d = (FlowLightView) findViewById(dt.ga(getContext(), "tt_splash_arrow_group"));
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.tg = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicUnlockView.this.bf.startAnimation(DynamicUnlockView.this.tg);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.d.e(4);
                    }
                }, 100L);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicUnlockView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.d.e(4);
                    }
                }, 300L);
                DynamicUnlockView dynamicUnlockView = DynamicUnlockView.this;
                dynamicUnlockView.postDelayed(dynamicUnlockView.getHaloAnimation(), 1200L);
            }
        };
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "Slide or click to jump to the details page or third-party application";
        }
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bf() {
        this.tg.cancel();
    }

    public void e() {
        postDelayed(getHaloAnimation(), 300L);
    }
}
