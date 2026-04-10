package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeThumbView extends BaseShakeView {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f6306c;

    public ShakeThumbView(Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.BaseShakeView
    final void a() {
        setOrientation(1);
        setGravity(1);
        this.f6306c = new ImageView(getContext());
        this.f6306c.setLayoutParams(new LinearLayout.LayoutParams(h.a(getContext(), 90.0f), h.a(getContext(), 90.0f)));
        ImageView imageView = this.f6306c;
        int iA = h.a(getContext(), 88.0f);
        int color = Color.parseColor("#99000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(iA);
        imageView.setBackgroundDrawable(gradientDrawable);
        this.a = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(h.a(getContext(), 40.0f), h.a(getContext(), 40.0f));
        layoutParams.gravity = 49;
        layoutParams.topMargin = h.a(getContext(), 12.0f);
        this.a.setLayoutParams(layoutParams);
        this.a.setImageResource(h.a(n.a().g(), "myoffer_shake_icon", i.f10645c));
        TextView textView = new TextView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = h.a(getContext(), 13.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setText(h.a(n.a().g(), "myoffer_shake_simple_title", i.f10649g));
        textView.setTextSize(1, 11.0f);
        textView.setTextColor(-1);
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(this.f6306c);
        frameLayout.addView(this.a);
        frameLayout.addView(textView);
        addView(frameLayout);
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
            this.f6306c.setOnClickListener(onClickListener);
        } catch (Throwable unused) {
        }
    }

    public ShakeThumbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShakeThumbView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @RequiresApi(api = 21)
    public ShakeThumbView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    private void a(View view) {
        int iA = h.a(getContext(), 88.0f);
        int color = Color.parseColor("#99000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius(iA);
        view.setBackgroundDrawable(gradientDrawable);
    }
}
