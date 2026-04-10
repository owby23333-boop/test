package com.anythink.expressad.shake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.t;

/* JADX INFO: loaded from: classes2.dex */
public class MBShakeView extends LinearLayout {
    private static final String a = "MBSplashShakeView";
    private ImageView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Animation f11210c;

    public MBShakeView(Context context) {
        super(context);
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? getContext().getResources().getConfiguration().locale.getLanguage().contains("en") ? "Redirect to third party application" : "浏览第三方应用" : str;
    }

    public void initView(String str) {
        initView(str, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f11210c = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.f11210c.setDuration(100L);
        this.f11210c.setRepeatMode(2);
        this.f11210c.setRepeatCount(-1);
        this.b.startAnimation(this.f11210c);
    }

    public MBShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void initView(String str, boolean z2) {
        setOrientation(1);
        setGravity(1);
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(t.b(getContext(), z2 ? 60.0f : 80.0f), t.b(getContext(), z2 ? 60.0f : 80.0f)));
        int color = Color.parseColor("#80000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(200.0f);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.b = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(t.b(getContext(), z2 ? 20.0f : 40.0f), t.b(getContext(), z2 ? 20.0f : 40.0f));
        layoutParams.gravity = 17;
        this.b.setLayoutParams(layoutParams);
        this.b.setImageResource(getResources().getIdentifier("anythink_splash_btn_shake", i.f10645c, com.anythink.expressad.foundation.b.a.b().a()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.b);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = t.b(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        if (getContext().getResources().getConfiguration().locale.getLanguage().contains("en")) {
            textView.setText("Shake your phone");
        } else {
            textView.setText("摇动手机 或 点击图标");
        }
        textView.setTextSize(z2 ? 16.0f : 20.0f);
        textView.setTextColor(-1);
        textView.setShadowLayer(8.0f, 3.0f, 3.0f, -16777216);
        if (TextUtils.isEmpty(str)) {
            str = getContext().getResources().getConfiguration().locale.getLanguage().contains("en") ? "Redirect to third party application" : "浏览第三方应用";
        }
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = t.b(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(str);
        textView2.setTextSize(z2 ? 12.0f : 16.0f);
        textView2.setTextColor(-1);
        textView2.setShadowLayer(8.0f, 3.0f, 3.0f, -16777216);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    public MBShakeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public MBShakeView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    private static void a(View view) {
        int color = Color.parseColor("#80000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(200.0f);
        view.setBackgroundDrawable(gradientDrawable);
    }

    private void a() {
        this.f11210c = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.f11210c.setDuration(100L);
        this.f11210c.setRepeatMode(2);
        this.f11210c.setRepeatCount(-1);
        this.b.startAnimation(this.f11210c);
    }
}
