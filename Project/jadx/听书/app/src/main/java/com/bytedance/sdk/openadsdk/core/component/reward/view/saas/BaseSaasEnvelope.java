package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.openadsdk.core.gz.dl;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.gz.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSaasEnvelope extends RelativeLayout {
    private AnimatorSet dl;
    private ImageView g;
    private View z;

    public abstract void z();

    public BaseSaasEnvelope(Context context) {
        super(context);
    }

    protected void z(Context context, String str, RelativeLayout relativeLayout) {
        View viewZ = z(context, str);
        this.z = viewZ;
        relativeLayout.addView(viewZ);
        relativeLayout.addView(g(context));
        this.z.setTag(67108864, 2917);
        addView(z(context, relativeLayout));
        ImageView imageView = new ImageView(context);
        this.g = imageView;
        imageView.setImageResource(tb.gc(context, "tt_saas_close"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = oq.dl(context, 25.0f);
        addView(this.g, layoutParams);
    }

    private View z(Context context, String str) {
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oq.dl(context, 166.0f), oq.dl(context, 40.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = oq.dl(context, 26.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#9D301A"));
        textView.setTypeface(null, 1);
        int iDl = oq.dl(context, 40.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f = iDl;
        gradientDrawable.setCornerRadii(new float[]{f, f, f, f, f, f, f, f});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#F2AC5F"), Color.parseColor("#FFEECC")});
        textView.setBackground(gradientDrawable);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, "scaleX", 1.0f, 1.05f, 1.0f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setDuration(800L);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, "scaleY", 1.0f, 1.05f, 1.0f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setDuration(800L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.dl = animatorSet;
        animatorSet.play(objectAnimatorOfFloat).with(objectAnimatorOfFloat2);
        this.dl.start();
        return textView;
    }

    private View g(Context context) {
        String strGc = eo.gc(getContext());
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = oq.dl(context, 80.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 10.0f);
        textView.setGravity(17);
        textView.setText("关联后" + strGc + "将获取你的抖音头像和昵称");
        textView.setTextColor(Color.parseColor("#AAFFFFFF"));
        return textView;
    }

    protected RelativeLayout z(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(oq.dl(getContext(), 301.0f), oq.dl(getContext(), 344.0f));
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(2114387458);
        return relativeLayout;
    }

    private View z(Context context, View view) {
        ImageView imageView = new ImageView(context);
        g.z(dl.z("saas_reward_title.webp")).to(imageView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        layoutParams.setMargins(0, 0, 0, oq.dl(context, 20.0f));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    public void g() {
        AnimatorSet animatorSet = this.dl;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.dl = null;
        }
    }

    public void setOnButtonClickListener(final View.OnClickListener onClickListener) {
        View view = this.z;
        if (view == null || onClickListener == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BaseSaasEnvelope.this.g();
                onClickListener.onClick(view2);
            }
        });
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
