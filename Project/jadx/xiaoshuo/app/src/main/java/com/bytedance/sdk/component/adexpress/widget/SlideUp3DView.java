package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.bf;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes.dex */
public class SlideUp3DView extends FrameLayout {
    private ImageView bf;
    private TextView d;
    private Context e;
    private AnimationDrawable ga;
    private TextView tg;

    public SlideUp3DView(Context context) {
        super(context);
        this.e = context;
        e();
    }

    private void tg() {
        this.ga = new AnimationDrawable();
        e(100, "tt_slide_up_1");
        e(100, "tt_slide_up_2");
        e(100, "tt_slide_up_3");
        e(100, "tt_slide_up_4");
        e(100, "tt_slide_up_5");
        e(100, "tt_slide_up_6");
        e(100, "tt_slide_up_7");
        e(100, "tt_slide_up_8");
        e(100, "tt_slide_up_9");
        e(100, "tt_slide_up_10");
        e(120, "tt_slide_up_11");
        e(120, "tt_slide_up_12");
        e(120, "tt_slide_up_13");
        e(120, "tt_slide_up_14");
        e(120, "tt_slide_up_15");
        this.ga.setOneShot(false);
    }

    public void bf() {
        if (this.ga == null) {
            tg();
        }
        this.bf.setImageDrawable(this.ga);
        this.ga.start();
    }

    public void d() {
        AnimationDrawable animationDrawable = this.ga;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.ga = null;
        }
    }

    public void e() {
        this.bf = new ImageView(this.e);
        this.tg = new TextView(this.e);
        this.d = new TextView(this.e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) bf.e(this.e, 200.0f), (int) bf.e(this.e, 200.0f));
        layoutParams.gravity = 49;
        layoutParams.bottomMargin = (int) bf.e(this.e, 70.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = (int) bf.e(this.e, 25.0f);
        this.tg.setText(dt.bf(this.e, "tt_slide_up_3d"));
        this.tg.setTextColor(-1);
        this.tg.setTextSize(24.0f);
        this.tg.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#59000000"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        this.d.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#59000000"));
        this.d.setTextColor(-1);
        this.d.setTextSize(14.0f);
        addView(this.bf, layoutParams);
        addView(this.tg, layoutParams2);
        addView(this.d, layoutParams3);
    }

    public void setGuideText(String str) {
        this.d.setText(str);
    }

    private void e(int i, String str) {
        this.ga.addFrame(dt.d(this.e, str), i);
    }
}
