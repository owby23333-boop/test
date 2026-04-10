package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeView extends BaseShakeView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f6307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f6308d;

    public ShakeView(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    final void a() {
        setOrientation(1);
        setGravity(1);
        this.f6307c = new ImageView(getContext());
        this.f6307c.setLayoutParams(new LinearLayout.LayoutParams(h.a(getContext(), 115.0f), h.a(getContext(), 115.0f)));
        ImageView imageView = this.f6307c;
        int iA = h.a(getContext(), 115.0f);
        int color = Color.parseColor("#99000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(iA);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.a = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h.a(getContext(), 76.0f), h.a(getContext(), 76.0f));
        layoutParams.gravity = 17;
        this.a.setLayoutParams(layoutParams);
        this.a.setImageResource(h.a(n.a().g(), "myoffer_shake_icon", i.f10645c));
        FrameLayout frameLayout = new FrameLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        frameLayout.setLayoutParams(layoutParams2);
        frameLayout.addView(this.f6307c);
        frameLayout.addView(this.a);
        this.f6308d = LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_splash_shake_hint_text", "layout"), (ViewGroup) null);
        this.f6308d.setLayoutParams(layoutParams2);
        ((TextView) this.f6308d.findViewById(h.a(n.a().g(), "tv_splash_shake_hint_text", "id"))).setText(h.a(n.a().g(), "myoffer_shake_full_title", i.f10649g));
        addView(frameLayout);
        addView(this.f6308d);
    }

    @Override // com.anythink.basead.ui.BaseShakeView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // com.anythink.basead.ui.BaseShakeView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        try {
            this.a.setOnClickListener(onClickListener);
            this.f6307c.setOnClickListener(onClickListener);
            this.f6308d.setOnClickListener(onClickListener);
        } catch (Throwable unused) {
        }
    }

    public ShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public ShakeView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    private void a(View view) {
        int iA = h.a(getContext(), 115.0f);
        int color = Color.parseColor("#99000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(iA);
        view.setBackgroundDrawable(gradientDrawable);
    }
}
