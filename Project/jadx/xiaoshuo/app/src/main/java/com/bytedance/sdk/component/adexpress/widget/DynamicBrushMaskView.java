package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.adexpress.d.bf;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.component.utils.wu;

/* JADX INFO: loaded from: classes.dex */
public class DynamicBrushMaskView extends FrameLayout {
    private BrushMaskView bf;
    private TextView d;
    private RelativeLayout e;
    private ObjectAnimator ga;
    private volatile boolean m;
    private ImageView p;
    private Context tg;
    private FrameLayout v;
    private ImageView vn;
    private volatile boolean zk;

    public DynamicBrushMaskView(Context context) {
        super(context);
        this.m = false;
        this.tg = context;
        View.inflate(context, dt.vn(context, "tt_dynamic_splash_layout_brush_mask_view"), this);
        tg();
    }

    public void e() {
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            try {
                ObjectAnimator objectAnimator = this.ga;
                if (objectAnimator == null || !(objectAnimator.isStarted() || this.ga.isRunning() || this.m)) {
                    BrushMaskView brushMaskView = this.bf;
                    if (brushMaskView != null) {
                        brushMaskView.e();
                    }
                    RelativeLayout relativeLayout = this.e;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    ga();
                }
            } catch (Exception e) {
                wu.vn("DynamicBrushMaskView", e.getMessage());
            }
        }
    }

    public void setBrushText(String str) {
        if (this.d == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.d.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga() {
        if (this.bf != null) {
            this.zk = false;
            int iE = bf.e(this.tg);
            int i = (iE * MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            int i2 = (i * 80) / MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME;
            this.v.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            float f = i;
            final float f2 = f - (f / 3.0f);
            this.bf.setEraserSize((this.bf.getHeight() * 3) / 5.0f);
            float fE = bf.e(getContext(), 15.0f);
            final FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f2, i2 / 2);
            int i3 = i2 / 4;
            layoutParams.topMargin = i3;
            float f3 = f / 6.0f;
            layoutParams.leftMargin = (int) f3;
            this.vn.setLayoutParams(layoutParams);
            int i4 = (iE * 58) / MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS;
            this.p.setLayoutParams(new RelativeLayout.LayoutParams(500, 500));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, (i4 * 76) / 58);
            layoutParams2.topMargin = (int) (i3 + fE);
            layoutParams2.leftMargin = (int) (f3 - (fE * 1.5f));
            this.e.setLayoutParams(layoutParams2);
            this.bf.e(this.bf.getWidth() / 6.0f, this.bf.getHeight() / 2.0f);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.e, "translationX", 0.0f, f2);
            this.ga = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(1000L);
            this.ga.setRepeatMode(1);
            this.ga.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    if (DynamicBrushMaskView.this.vn != null) {
                        layoutParams.width = (int) (f2 * animatedFraction);
                        DynamicBrushMaskView.this.vn.setLayoutParams(layoutParams);
                    }
                }
            });
            this.ga.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    if (DynamicBrushMaskView.this.bf != null) {
                        if (DynamicBrushMaskView.this.vn != null) {
                            layoutParams.width = 0;
                            DynamicBrushMaskView.this.vn.setLayoutParams(layoutParams);
                        }
                        if (DynamicBrushMaskView.this.zk) {
                            return;
                        }
                        DynamicBrushMaskView.this.m = true;
                        DynamicBrushMaskView.this.bf.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DynamicBrushMaskView.this.m = false;
                                if (DynamicBrushMaskView.this.zk) {
                                    return;
                                }
                                DynamicBrushMaskView.this.ga.start();
                            }
                        }, 100L);
                    }
                }
            });
            ObjectAnimator objectAnimator = this.ga;
            if (objectAnimator == null || objectAnimator.isStarted() || this.ga.isRunning() || this.m) {
                return;
            }
            this.ga.start();
        }
    }

    private void tg() {
        this.bf = (BrushMaskView) findViewById(dt.ga(this.tg, "tt_interact_splash_brush_mask_view"));
        this.e = (RelativeLayout) findViewById(dt.ga(this.tg, "tt_interact_splash_brush_hand"));
        this.vn = (ImageView) findViewById(dt.ga(this.tg, "tt_interact_splash_first_step_image"));
        this.v = (FrameLayout) findViewById(dt.ga(this.tg, "tt_interact_splash_brush_fl"));
        this.p = (ImageView) findViewById(dt.ga(this.tg, "image_hand"));
        this.v.setClipChildren(false);
        this.d = (TextView) findViewById(dt.ga(this.tg, "tt_interact_splash_brush_text"));
        BrushMaskView brushMaskView = this.bf;
        if (brushMaskView != null) {
            brushMaskView.setWatermark(dt.tg(this.tg, "tt_splash_brush_bg"));
            this.bf.post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.DynamicBrushMaskView.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (DynamicBrushMaskView.this.ga == null || !DynamicBrushMaskView.this.ga.isStarted()) {
                            DynamicBrushMaskView.this.ga();
                        }
                    } catch (Exception e) {
                        wu.bf("DynamicBrushMaskView", e.getMessage());
                    }
                }
            });
        }
    }

    public void bf() {
        if (this.zk) {
            return;
        }
        this.zk = true;
        ObjectAnimator objectAnimator = this.ga;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            RelativeLayout relativeLayout = this.e;
            if (relativeLayout != null) {
                relativeLayout.clearAnimation();
                this.e.setVisibility(4);
            }
            this.bf.e();
        }
        BrushMaskView brushMaskView = this.bf;
        if (brushMaskView != null) {
            brushMaskView.setEraserSize(brushMaskView.getHeight());
            this.bf.e(0.0f, r0.getHeight() / 2.0f);
            this.bf.bf();
        }
    }

    public void d() {
        clearAnimation();
    }
}
